package net.mcreator.exmoxl.init;

import net.minecraftforge.fml.event.lifecycle.FMLConstructModEvent;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.mcreator.exmoxl.configuration.ExmoxlConfigConfiguration;
import net.mcreator.exmoxl.ExmoxlMod;

@Mod.EventBusSubscriber(modid = ExmoxlMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ExmoxlModConfigs {
	@SubscribeEvent
	public static void register(FMLConstructModEvent event) {
		event.enqueueWork(() -> {
			ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ExmoxlConfigConfiguration.SPEC, "exmoxl.toml");
		});
	}
}
