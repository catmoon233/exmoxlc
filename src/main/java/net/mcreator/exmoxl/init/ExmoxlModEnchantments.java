
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.exmoxl.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.enchantment.Enchantment;

import net.mcreator.exmoxl.enchantment.FocusImpactEnchantment;
import net.mcreator.exmoxl.enchantment.BloodthirstyEnchantment;
import net.mcreator.exmoxl.ExmoxlMod;

public class ExmoxlModEnchantments {
	public static final DeferredRegister<Enchantment> REGISTRY = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, ExmoxlMod.MODID);
	public static final RegistryObject<Enchantment> BLOODTHIRSTY = REGISTRY.register("bloodthirsty", () -> new BloodthirstyEnchantment());
	public static final RegistryObject<Enchantment> FOCUS_IMPACT = REGISTRY.register("focus_impact", () -> new FocusImpactEnchantment());
}
