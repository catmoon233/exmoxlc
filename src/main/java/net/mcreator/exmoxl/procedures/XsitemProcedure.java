package net.mcreator.exmoxl.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;

import java.util.function.Supplier;
import java.util.Map;

public class XsitemProcedure {
	public static ItemStack execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return null;
		BlockState con = Blocks.AIR.defaultBlockState();
		ItemStack a1 = ItemStack.EMPTY;
		a1 = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY);
/*		ItemEntity entityToSpawn =null;
		if (world instanceof ServerLevel _level) {
			entityToSpawn = new ItemEntity(_level, x, y, z, a1);
		}*/
		return a1;
	}
}
