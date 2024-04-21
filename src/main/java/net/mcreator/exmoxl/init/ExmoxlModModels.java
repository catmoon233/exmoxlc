
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.exmoxl.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.exmoxl.client.model.Modelasksky2_Converted_Converted;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class ExmoxlModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(Modelasksky2_Converted_Converted.LAYER_LOCATION, Modelasksky2_Converted_Converted::createBodyLayer);
	}
}
