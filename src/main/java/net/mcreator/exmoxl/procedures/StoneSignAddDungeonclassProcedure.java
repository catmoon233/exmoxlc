package net.mcreator.exmoxl.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class StoneSignAddDungeonclassProcedure {
	public static void execute(LevelAccessor world, CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		BlockState block = Blocks.AIR.defaultBlockState();
		if (!world.isClientSide()) {
			BlockPos _bp = BlockPos.containing(DoubleArgumentType.getDouble(arguments, "x"), DoubleArgumentType.getDouble(arguments, "y"), DoubleArgumentType.getDouble(arguments, "z"));
			BlockEntity _blockEntity = world.getBlockEntity(_bp);
			BlockState _bs = world.getBlockState(_bp);
			if (_blockEntity != null)
				_blockEntity.getPersistentData().putString("StoneSignIndex", (StringArgumentType.getString(arguments, "dungeonsname")));
			if (world instanceof Level _level)
				_level.sendBlockUpdated(_bp, _bs, _bs, 3);
		}
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal(
					(ForgeRegistries.BLOCKS.getKey((world.getBlockState(BlockPos.containing(DoubleArgumentType.getDouble(arguments, "x"), DoubleArgumentType.getDouble(arguments, "y"), DoubleArgumentType.getDouble(arguments, "z")))).getBlock())
							.toString() + " ->\u8BE5\u65B9\u5757\u7684\u526F\u672C\u7D22\u5F15\u5DF2\u6539\u4E3A" + StringArgumentType.getString(arguments, "dungeonsname"))),
					false);
	}
}
