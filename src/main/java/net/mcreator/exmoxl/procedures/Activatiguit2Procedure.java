package net.mcreator.exmoxl.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import java.util.function.Supplier;
import java.util.Map;

public class Activatiguit2Procedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "\u9700\u8981\u7684\u661F\u7130\u7C89:"
				+ ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(4)).getItem() : ItemStack.EMPTY).getOrCreateTag().getDouble(("zizhix"
						+ ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(4)).getItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("zizhi")))));
	}
}
