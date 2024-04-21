package net.mcreator.exmoxl.procedures;

import net.minecraft.world.item.ItemStack;

public class IronpShuXingZhiTiGongQiProcedure {
	public static double execute(ItemStack itemstack) {
		return itemstack.getOrCreateTag().getDouble("isdark");
	}
}
