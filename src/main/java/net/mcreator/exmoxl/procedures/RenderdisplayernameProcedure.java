package net.mcreator.exmoxl.procedures;





import net.minecraft.network.chat.ComponentUtils;
import com.mojang.blaze3d.vertex.PoseStack;
import dev.xkmc.l2hostility.content.capability.mob.MobTraitCap;
import dev.xkmc.l2hostility.content.item.traits.EnchantmentDisabler;
import dev.xkmc.l2hostility.init.L2Hostility;
import dev.xkmc.l2hostility.init.data.LHConfig;
import dev.xkmc.l2library.util.Proxy;
import dev.xkmc.l2library.util.raytrace.RayTraceUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderNameTagEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.joml.Matrix4f;
import net.mcreator.exmoxl.network.ExmoxlModVariables;
import net.minecraft.world.entity.Entity;
import java.io.Console;
import java.util.ArrayList;
import net.minecraft.core.registries.Registries;

import net.mcreator.exmoxl.Capmap;
import net.minecraft.world.level.LevelAccessor;
@Mod.EventBusSubscriber(Dist.CLIENT)
public class RenderdisplayernameProcedure {


	@SubscribeEvent(priority = EventPriority.LOW)
public static void renderNamePlate(RenderNameTagEvent event) {


			if (event.getEntity() instanceof LivingEntity le && le.getHealth()>0 ) {
				LocalPlayer player = Proxy.getClientPlayer();
				double x1 = le.getX();
				double y1 = le.getY();
				double z1 = le.getZ();
			if ((Math.abs(player.getX() - x1) + Math.abs(player.getY() - y1) + Math.abs(player.getZ() - z1)) <=25){ 
				LevelAccessor world = (LevelAccessor)le.level();

/*boolean isb =false;
int suoy = 0;


for (int i = 0; i < ExmoxlModVariables.uuidboss.size(); i++) {
if (le.getStringUUID().equals((String) ExmoxlModVariables.uuidboss.get(i))) {
    isb = true;
    suoy = i;
}}*/

    if (ExmoxlModVariables.MapVariables.get(world).bossstring.containsKey(le.getUUID())) {

if (ExmoxlModVariables.MapVariables.get(world).bossstring.get(le.getUUID()) != ""){
		

		//	if (!event.getEntity().level().isClientSide())
		//		((Mobcapmain) event.getEntity().getCapability(MobcapmainProvider.MOB_CAP_MAIN_CAPABILITY, null).orElse(new Mobcapmain(false,""))).syncLivingEntityVariables(event.getEntity());

			assert player != null;
			boolean needHover = le.isInvisible() || LHConfig.CLIENT.showOnlyWhenHovered.get();
			if (needHover && RayTraceUtil.rayTraceEntity(player, player.getEntityReach(), e -> e == le) == null) {
				return;
			}

			Font.DisplayMode mode = player.hasLineOfSight(event.getEntity()) ?
					Font.DisplayMode.SEE_THROUGH :
					Font.DisplayMode.NORMAL;
				LivingEntity closestEntity = 	(LivingEntity)event.getEntity();

        Component text = Component.literal(ExmoxlModVariables.MapVariables.get(world).bossstring.get(le.getUUID())/*MobcapmainmangerProcedure.getcitiao(le)*/);
        renderNameTag(event, text, event.getPoseStack(), 0.6f, mode);
}
	}
		}
	
}
}
	protected static void renderNameTag(RenderNameTagEvent event, Component text, PoseStack pose, float offset, Font.DisplayMode mode) {
		var dispatcher = Minecraft.getInstance().getEntityRenderDispatcher();
		double d0 = dispatcher.distanceToSqr(event.getEntity());
		int max = LHConfig.CLIENT.overHeadRenderDistance.get();
		int light = LHConfig.CLIENT.overHeadRenderFullBright.get() ? LightTexture.FULL_BRIGHT :
				event.getPackedLight();
		if (d0 < max * max) {

			float f = event.getEntity().getNameTagOffsetY() + offset;
			pose.pushPose();
			pose.translate(0.0F, f, 0.0F);
			pose.mulPose(dispatcher.cameraOrientation());
			pose.scale(-0.025F, -0.025F, 0.025F);
			Matrix4f matrix4f = pose.last().pose();
			Font font = event.getEntityRenderer().getFont();
			float f2 = (float) (-font.width(text) / 2);
			float f1 = Minecraft.getInstance().options.getBackgroundOpacity(0.25F);
			int j = (int) (f1 * 255.0F) << 24;
			font.drawInBatch(text, f2, 0, -1, false, matrix4f,
					event.getMultiBufferSource(), mode, j, light);
			pose.popPose();
		}
	}

}

