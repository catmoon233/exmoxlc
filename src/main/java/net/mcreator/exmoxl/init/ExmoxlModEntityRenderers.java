
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.exmoxl.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.exmoxl.client.renderer.FazhenentityRenderer;
import net.mcreator.exmoxl.client.renderer.Asksky2flysworldRenderer;
import net.mcreator.exmoxl.client.renderer.AsRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ExmoxlModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(ExmoxlModEntities.AS.get(), AsRenderer::new);
		event.registerEntityRenderer(ExmoxlModEntities.FAZHENENTITY.get(), FazhenentityRenderer::new);
		event.registerEntityRenderer(ExmoxlModEntities.ASKSKY_2FLYSWORLD.get(), Asksky2flysworldRenderer::new);
	}
}
