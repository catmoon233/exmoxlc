package net.mcreator.exmoxl.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.exmoxl.world.inventory.StoneDungeonMenu;
import net.mcreator.exmoxl.network.StoneDungeonButtonMessage;
import net.mcreator.exmoxl.ExmoxlMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class StoneDungeonScreen extends AbstractContainerScreen<StoneDungeonMenu> {
	private final static HashMap<String, Object> guistate = StoneDungeonMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	public static int MouseX, MouseY,sx,sy;
	ImageButton imagebutton_stonesign;
	ImageButton imagebutton_talentselect;

	public StoneDungeonScreen(StoneDungeonMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 0;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("exmoxl:textures/screens/stone_dungeon.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		MouseX = mouseX;
		MouseY = mouseY;
		sx = this.leftPos + -199;
		sy = this.topPos + -20;
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		//guiGraphics.blit(new ResourceLocation("exmoxl:textures/screens/5wei.png"), this.leftPos + -199, this.topPos + -38, 0, 0, 50, 50, 50, 50);

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
		guiGraphics.drawString(this.font, Component.translatable("gui.exmoxl.stone_dungeon.label_empty"), -91, 88, -12829636, false);
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
		imagebutton_stonesign = new ImageButton(this.leftPos + -199, this.topPos + -38, 400, 240, 0, 0, 240, new ResourceLocation("exmoxl:textures/screens/atlas/imagebutton_stonesign.png"), 400, 480, e -> {
			if (true) {
				ExmoxlMod.PACKET_HANDLER.sendToServer(new StoneDungeonButtonMessage(0, x, y, z));
				StoneDungeonButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:imagebutton_stonesign", imagebutton_stonesign);
		this.addRenderableWidget(imagebutton_stonesign);
		imagebutton_talentselect = new ImageButton(this.leftPos + 116, this.topPos + 169, 78, 28, 0, 0, 28, new ResourceLocation("exmoxl:textures/screens/atlas/imagebutton_talentselect.png"), 78, 56, e -> {
		});
		guistate.put("button:imagebutton_talentselect", imagebutton_talentselect);
		this.addRenderableWidget(imagebutton_talentselect);
	}
}
