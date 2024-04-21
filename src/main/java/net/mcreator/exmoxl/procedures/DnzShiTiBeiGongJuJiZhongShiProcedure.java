package net.mcreator.exmoxl.procedures;

import net.minecraft.world.item.ItemStack;

public class DnzShiTiBeiGongJuJiZhongShiProcedure {
	public static void execute(ItemStack itemstack) {
		if (itemstack.getOrCreateTag().getDouble("dnzz") < 10) {
			itemstack.getOrCreateTag().putDouble("dnzz", (itemstack.getOrCreateTag().getDouble("dnzz") + 1));
		}
	}
}
