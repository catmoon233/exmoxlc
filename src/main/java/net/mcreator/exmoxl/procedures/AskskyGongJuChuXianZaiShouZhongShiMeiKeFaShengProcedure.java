package net.mcreator.exmoxl.procedures;

import net.minecraft.world.item.ItemStack;

public class AskskyGongJuChuXianZaiShouZhongShiMeiKeFaShengProcedure {
	public static void execute(ItemStack itemstack) {
		if (itemstack.getOrCreateTag().getDouble("attzt2cq") > 0) {
			itemstack.getOrCreateTag().putDouble("attzt2cq", (itemstack.getOrCreateTag().getDouble("attzt2cq") - 1));
		}
		if (itemstack.getOrCreateTag().getDouble("attzt1cq") > 0) {
			itemstack.getOrCreateTag().putDouble("attzt1cq", (itemstack.getOrCreateTag().getDouble("attzt1cq") - 1));
		}
	}
}
