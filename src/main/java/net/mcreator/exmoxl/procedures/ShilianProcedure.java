package net.mcreator.exmoxl.procedures;

import net.minecraftforge.network.NetworkHooks;
import net.mcreator.exmoxl.network.ExmoxlModVariables;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.exmoxl.network.ExmoxlModVariables;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.arguments.DoubleArgumentType;

import net.mcreator.exmoxl.network.ExmoxlModVariables;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.MenuProvider;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;
import net.mcreator.exmoxl.network.LotteryshiButtonMessage;
import net.mcreator.exmoxl.procedures.RandomkashiProcedure;

import net.mcreator.exmoxl.world.inventory.LotteryshiMenu;

import io.netty.buffer.Unpooled;
import java.util.List;
import org.apache.logging.log4j.core.appender.rolling.OnStartupTriggeringPolicy;

public class ShilianProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;

	//	if(world.isClientSide())return;
		if ((entity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ExmoxlModVariables.PlayerVariables())).piao2 >= 10) {
			{
				double _setval = (entity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ExmoxlModVariables.PlayerVariables())).piao2 - 10;
				entity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.piao2 = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		{
		double _setval = 0;
		entity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
			capability.cnum = _setval;
			capability.clevel = _setval;
			capability.syncPlayerVariables(entity);
		});
		}
		{
	/*	List<Integer> _setval = null;
		entity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
			capability.chou = _setval;
			capability.syncPlayerVariables(entity);
		});
		}
		//if(!world.isClientSide()){
		{*/
		List<Integer> _setval = RandomkashiProcedure.execute(entity,world);
		entity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
			capability.chou = _setval;
				//	System.out.printf("fz");
			capability.syncPlayerVariables(entity);
		});
		}
		if (entity instanceof ServerPlayer _ent) {
			BlockPos _bpos = BlockPos.containing(x, y, z);
			NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
				@Override
				public Component getDisplayName() {
					return Component.literal("Lotteryshi");
				}

				@Override
				public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
					return new LotteryshiMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
				}
			}, _bpos);
			
		}
				System.out.printf("open");
		//}
//LotteryshiButtonMessage.chou = 	
//LotteryshiButtonMessage.cnum =0;
//LotteryshiButtonMessage.clevel = 0;


		}
	}
}
