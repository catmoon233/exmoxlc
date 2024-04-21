
package net.mcreator.exmoxl.enchantment;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.EquipmentSlot;

import net.mcreator.exmoxl.init.ExmoxlModItems;

public class BloodthirstyEnchantment extends Enchantment {
	public BloodthirstyEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.VERY_RARE, EnchantmentCategory.WEAPON, slots);
	}

	@Override
	public boolean canApplyAtEnchantingTable(ItemStack itemstack) {
		return !Ingredient.of(new ItemStack(ExmoxlModItems.WANDAO.get()), new ItemStack(Blocks.AIR)).test(itemstack);
	}

	@Override
	public boolean isAllowedOnBooks() {
		return false;
	}

	@Override
	public boolean isDiscoverable() {
		return false;
	}

	@Override
	public boolean isTradeable() {
		return false;
	}
}
