package net.mcreator.exmoxl.item.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.exmoxl.item.Asksky2Item;

public class Asksky2ItemModel extends GeoModel<Asksky2Item> {
	@Override
	public ResourceLocation getAnimationResource(Asksky2Item animatable) {
		return new ResourceLocation("exmoxl", "animations/asksky2.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(Asksky2Item animatable) {
		return new ResourceLocation("exmoxl", "geo/asksky2.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(Asksky2Item animatable) {
		return new ResourceLocation("exmoxl", "textures/item/texture.png");
	}
}
