
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.exmoxl.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.effect.MobEffect;

import net.mcreator.exmoxl.potion.ZhenyaMobEffect;
import net.mcreator.exmoxl.potion.YishangMobEffect;
import net.mcreator.exmoxl.potion.RegperMobEffect;
import net.mcreator.exmoxl.potion.DoubleWhammyMobEffect;
import net.mcreator.exmoxl.ExmoxlMod;

public class ExmoxlModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, ExmoxlMod.MODID);
	public static final RegistryObject<MobEffect> DOUBLE_WHAMMY = REGISTRY.register("double_whammy", () -> new DoubleWhammyMobEffect());
	public static final RegistryObject<MobEffect> REGPER = REGISTRY.register("regper", () -> new RegperMobEffect());
	public static final RegistryObject<MobEffect> ZHENYA = REGISTRY.register("zhenya", () -> new ZhenyaMobEffect());
	public static final RegistryObject<MobEffect> YISHANG = REGISTRY.register("yishang", () -> new YishangMobEffect());
}
