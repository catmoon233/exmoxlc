package net.mcreator.exmoxl.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.exmoxl.entity.FazhenentityEntity;

public class FazhenentityModel extends GeoModel<FazhenentityEntity> {
	@Override
	public ResourceLocation getAnimationResource(FazhenentityEntity entity) {
		return new ResourceLocation("exmoxl", "animations/fazhen.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(FazhenentityEntity entity) {
		return new ResourceLocation("exmoxl", "geo/fazhen.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(FazhenentityEntity entity) {
		return new ResourceLocation("exmoxl", "textures/entities/" + entity.getTexture() + ".png");
	}

}
