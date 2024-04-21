package net.mcreator.exmoxl.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.exmoxl.world.inventory.WeawordkbeachguiMenu;
import net.mcreator.exmoxl.procedures.XsitemProcedure;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class WeawordkbeachguiScreen extends AbstractContainerScreen<WeawordkbeachguiMenu> {
	private final static HashMap<String, Object> guistate = WeawordkbeachguiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public WeawordkbeachguiScreen(WeawordkbeachguiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 170;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("exmoxl:textures/screens/weawordkbeachgui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		//if (XsitemProcedure.execute(world, x, y, z, entity) instanceof LivingEntity livingEntity) {
			//InventoryScreen.renderEntityInInventoryFollowsAngle(guiGraphics, this.leftPos + 28, this.topPos + 57, 30, 0f + (float) Math.atan((this.leftPos + 28 - mouseX) / 40.0), (float) Math.atan((this.topPos + 8 - mouseY) / 40.0), livingEntity);
         guiGraphics.pose().pushPose();

// 设置物品渲染大小为5倍
        guiGraphics.pose().scale(3F, 3F, 1f);

        guiGraphics.renderItem(XsitemProcedure.execute(world, x, y, z, entity), this.leftPos + 28, this.topPos + 47 );

        guiGraphics.pose().popPose();
		//}
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		guiGraphics.blit(new ResourceLocation("exmoxl:textures/screens/backround.png"), this.leftPos + 3, this.topPos + 7, 0, 0, 50, 50, 50, 50);

		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
	}
}
