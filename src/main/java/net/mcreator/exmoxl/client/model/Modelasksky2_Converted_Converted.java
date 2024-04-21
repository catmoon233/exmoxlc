package net.mcreator.exmoxl.client.model;

import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.EntityModel;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

// Made with Blockbench 4.9.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class Modelasksky2_Converted_Converted<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("exmoxl", "modelasksky_2_converted_converted"), "main");
	public final ModelPart daobing;
	public final ModelPart skill1;

	public Modelasksky2_Converted_Converted(ModelPart root) {
		this.daobing = root.getChild("daobing");
		this.skill1 = root.getChild("skill1");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition daobing = partdefinition.addOrReplaceChild("daobing",
				CubeListBuilder.create().texOffs(10, 19).addBox(-1.0F, -7.0F, -1.0F, 1.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(18, 13).addBox(-2.0F, -8.0F, -3.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(26, 4)
						.addBox(-1.0F, 0.0F, 1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(10, 4).addBox(0.0F, 0.0F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(26, 6)
						.addBox(-1.0F, 0.0F, -2.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(16, 24).addBox(-2.0F, 0.0F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(16, 24)
						.addBox(-2.0F, -8.0F, 1.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(16, 4).addBox(-2.0F, -8.0F, -2.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(10, 4)
						.addBox(0.0F, -8.0F, -2.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(0.0F, -8.0F, 1.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(10, 12)
						.addBox(0.0F, -8.0F, -3.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(18, 15).addBox(-1.0F, -8.0F, 1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(18, 12)
						.addBox(-1.0F, -8.0F, -3.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(10, 0).addBox(-2.0F, -10.0F, -5.0F, 3.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(18, 8)
						.addBox(-2.0F, -11.0F, -1.0F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(16, 20).addBox(-2.0F, -10.0F, 5.0F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(10, 16)
						.addBox(-1.0F, -10.0F, 8.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(15, 0).addBox(-1.0F, -10.0F, -9.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(6, 0)
						.addBox(-2.0F, -10.0F, -8.0F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(26, 0).addBox(-1.0F, -11.0F, -5.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(22, 24)
						.addBox(-1.0F, -11.0F, 2.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(25, 20).addBox(-1.0F, -12.0F, 2.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(14, 19)
						.addBox(-1.0F, -12.0F, -3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-1.0F, -30.0F, -2.0F, 1.0F, 21.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(10, 12)
						.addBox(-1.0F, -32.0F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition skill1 = partdefinition.addOrReplaceChild("skill1",
				CubeListBuilder.create().texOffs(33, 0).addBox(-1.0F, -12.0F, -3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(33, 0).mirror().addBox(-1.0F, -12.0F, 2.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offset(0.0F, 24.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		daobing.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		skill1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
