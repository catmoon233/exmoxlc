package net.mcreator.exmoxl.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.exmoxl.world.inventory.ActivatiguiMenu;
import net.mcreator.exmoxl.procedures.ActivatiguitProcedure;
import net.mcreator.exmoxl.procedures.Activatiguit2Procedure;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class ActivatiguiScreen extends AbstractContainerScreen<ActivatiguiMenu> {
	private final static HashMap<String, Object> guistate = ActivatiguiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public ActivatiguiScreen(ActivatiguiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 168;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("exmoxl:textures/screens/activatigui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
		if (mouseX > leftPos + 47 && mouseX < leftPos + 71 && mouseY > topPos + 61 && mouseY < topPos + 85)
			guiGraphics.renderTooltip(font, Component.translatable("gui.exmoxl.activatigui.tooltip_ci_ci_fang_ru_za_chen"), mouseX, mouseY);
		if (mouseX > leftPos + 47 && mouseX < leftPos + 71 && mouseY > topPos + 25 && mouseY < topPos + 49)
			guiGraphics.renderTooltip(font, Component.translatable("gui.exmoxl.activatigui.tooltip_ci_chu_fang_ru_xing_yan"), mouseX, mouseY);
		if (mouseX > leftPos + 11 && mouseX < leftPos + 35 && mouseY > topPos + 43 && mouseY < topPos + 67)
			guiGraphics.renderTooltip(font, Component.translatable("gui.exmoxl.activatigui.tooltip_ci_chu_fang_ru_wu_qi"), mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		guiGraphics.blit(new ResourceLocation("exmoxl:textures/screens/jiantou.png"), this.leftPos + 88, this.topPos + 46, 0, 0, 20, 11, 20, 11);

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
		guiGraphics.drawString(this.font,

				ActivatiguitProcedure.execute(entity), 2, 7, -12829636, false);
		guiGraphics.drawString(this.font,

				Activatiguit2Procedure.execute(entity), 2, 16, -12829636, false);
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
