
package net.mcreator.exmoxl.client.renderer;

import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.cache.object.BakedGeoModel;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.exmoxl.entity.model.FazhenentityModel;
import net.mcreator.exmoxl.entity.FazhenentityEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class FazhenentityRenderer extends GeoEntityRenderer<FazhenentityEntity> {
	public FazhenentityRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new FazhenentityModel());
		this.shadowRadius = 0.5f;
	}

	@Override
	public RenderType getRenderType(FazhenentityEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}

	@Override
	public void preRender(PoseStack poseStack, FazhenentityEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green,
			float blue, float alpha) {
		float scale = 2f;
		this.scaleHeight = scale;
		this.scaleWidth = scale;
		super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	protected float getDeathMaxRotation(FazhenentityEntity entityLivingBaseIn) {
		return 0.0F;
	}
}
