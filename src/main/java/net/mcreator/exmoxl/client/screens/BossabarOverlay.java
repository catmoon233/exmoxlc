
package net.mcreator.exmoxl.client.screens;

import org.checkerframework.checker.units.qual.h;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.client.event.RenderGuiEvent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.ComponentUtils;
//import net.mcreator.exmoxl.procedures.TickbossdisplaynameProcedure;
//import net.mcreator.exmoxl.procedures.TickbossProcedure;
//import net.mcreator.exmoxl.procedures.TickbosshpnProcedure;
import net.mcreator.exmoxl.network.ExmoxlModVariables;


import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.platform.GlStateManager;
import net.minecraft.world.entity.monster.Enemy;

@Mod.EventBusSubscriber({Dist.CLIENT})
public class BossabarOverlay {
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public static void eventHandler(RenderGuiEvent.Pre event) {
		int w = event.getWindow().getGuiScaledWidth();
		int h = event.getWindow().getGuiScaledHeight();
		Level world = null;
		double x = 0;
		double y = 0;
		double z = 0;
		String disname = "无名";
			int init1 = 0;
		Player entity = Minecraft.getInstance().player;
		if (entity != null) {
			world = entity.level();
			x = entity.getX();
			y = entity.getY();
			z = entity.getZ();
			//disname = (entity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ExmoxlModVariables.PlayerVariables())).bossastring;
			// init1 = TickbosshpnProcedure.gethpa(world,entity);
		}
		RenderSystem.disableDepthTest();
		RenderSystem.depthMask(false);
		RenderSystem.enableBlend();
		RenderSystem.setShader(GameRenderer::getPositionTexShader);
		RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
		RenderSystem.setShaderColor(1, 1, 1, 1);
		if (/*init1 != 0*/false) {
			event.getGuiGraphics().blit(new ResourceLocation("exmoxl:textures/screens/bossbar.png"), w / 2 + -99, 0, 0, 0, 200, 5, 200, 5);

			event.getGuiGraphics().blit(new ResourceLocation("exmoxl:textures/screens/bossbar2.png"), w / 2 + -99, 0, 0, 0, init1, 5, 200, 5);

			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					disname, w / 2 + -99, 7, -1, false);
		}
		RenderSystem.depthMask(true);
		RenderSystem.defaultBlendFunc();
		RenderSystem.enableDepthTest();
		RenderSystem.disableBlend();
		RenderSystem.setShaderColor(1, 1, 1, 1);
	}
}
