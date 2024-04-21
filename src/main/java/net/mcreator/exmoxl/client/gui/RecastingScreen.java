package net.mcreator.exmoxl.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.exmoxl.world.inventory.RecastingMenu;
import net.mcreator.exmoxl.procedures.RecxstProcedure;
import net.mcreator.exmoxl.procedures.Rect3Procedure;
import net.mcreator.exmoxl.procedures.Rect2Procedure;
import net.mcreator.exmoxl.procedures.Rect1Procedure;
import net.mcreator.exmoxl.procedures.Recpd3Procedure;
import net.mcreator.exmoxl.procedures.Recpd2Procedure;
import net.mcreator.exmoxl.procedures.Recpd1Procedure;
import net.mcreator.exmoxl.network.RecastingButtonMessage;
import net.mcreator.exmoxl.ExmoxlMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class RecastingScreen extends AbstractContainerScreen<RecastingMenu> {
	private final static HashMap<String, Object> guistate = RecastingMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_recasting2;
	ImageButton imagebutton_recasting21;
	ImageButton imagebutton_recasting22;

	public RecastingScreen(RecastingMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("exmoxl:textures/screens/recasting.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
		if (mouseX > leftPos + 33 && mouseX < leftPos + 57 && mouseY > topPos + 52 && mouseY < topPos + 76)
			guiGraphics.renderTooltip(font, Component.translatable("gui.exmoxl.recasting.tooltip_ci_chu_fang_ru_zhong_zhu_shi"), mouseX, mouseY);
		if (mouseX > leftPos + 33 && mouseX < leftPos + 57 && mouseY > topPos + 16 && mouseY < topPos + 40)
			guiGraphics.renderTooltip(font, Component.translatable("gui.exmoxl.recasting.tooltip_ci_chu_fang_ru_sheng_ji_ji_pin"), mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		guiGraphics.blit(new ResourceLocation("exmoxl:textures/screens/recasting1.png"), this.leftPos + 60, this.topPos + 16, 0, 0, 108, 19, 108, 19);

		guiGraphics.blit(new ResourceLocation("exmoxl:textures/screens/recasting1.png"), this.leftPos + 60, this.topPos + 34, 0, 0, 108, 19, 108, 19);

		guiGraphics.blit(new ResourceLocation("exmoxl:textures/screens/recasting1.png"), this.leftPos + 60, this.topPos + 52, 0, 0, 108, 19, 108, 19);

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
		if (RecxstProcedure.execute(entity))
			guiGraphics.drawString(this.font,

					Rect1Procedure.execute(entity), 69, 25, -12829636, false);
		if (RecxstProcedure.execute(entity))
			guiGraphics.drawString(this.font,

					Rect2Procedure.execute(entity), 69, 43, -12829636, false);
		if (RecxstProcedure.execute(entity))
			guiGraphics.drawString(this.font,

					Rect3Procedure.execute(entity), 69, 61, -12829636, false);
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
		imagebutton_recasting2 = new ImageButton(this.leftPos + 60, this.topPos + 16, 108, 19, 0, 0, 19, new ResourceLocation("exmoxl:textures/screens/atlas/imagebutton_recasting2.png"), 108, 38, e -> {
			if (Recpd1Procedure.execute(entity)) {
				ExmoxlMod.PACKET_HANDLER.sendToServer(new RecastingButtonMessage(0, x, y, z));
				RecastingButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}) {
			@Override
			public void render(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				if (Recpd1Procedure.execute(entity))
					super.render(guiGraphics, gx, gy, ticks);
			}
		};
		guistate.put("button:imagebutton_recasting2", imagebutton_recasting2);
		this.addRenderableWidget(imagebutton_recasting2);
		imagebutton_recasting21 = new ImageButton(this.leftPos + 60, this.topPos + 34, 108, 19, 0, 0, 19, new ResourceLocation("exmoxl:textures/screens/atlas/imagebutton_recasting21.png"), 108, 38, e -> {
			if (Recpd2Procedure.execute(entity)) {
				ExmoxlMod.PACKET_HANDLER.sendToServer(new RecastingButtonMessage(1, x, y, z));
				RecastingButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}) {
			@Override
			public void render(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				if (Recpd2Procedure.execute(entity))
					super.render(guiGraphics, gx, gy, ticks);
			}
		};
		guistate.put("button:imagebutton_recasting21", imagebutton_recasting21);
		this.addRenderableWidget(imagebutton_recasting21);
		imagebutton_recasting22 = new ImageButton(this.leftPos + 60, this.topPos + 52, 108, 19, 0, 0, 19, new ResourceLocation("exmoxl:textures/screens/atlas/imagebutton_recasting22.png"), 108, 38, e -> {
			if (Recpd3Procedure.execute(entity)) {
				ExmoxlMod.PACKET_HANDLER.sendToServer(new RecastingButtonMessage(2, x, y, z));
				RecastingButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}) {
			@Override
			public void render(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				if (Recpd3Procedure.execute(entity))
					super.render(guiGraphics, gx, gy, ticks);
			}
		};
		guistate.put("button:imagebutton_recasting22", imagebutton_recasting22);
		this.addRenderableWidget(imagebutton_recasting22);
	}
}
