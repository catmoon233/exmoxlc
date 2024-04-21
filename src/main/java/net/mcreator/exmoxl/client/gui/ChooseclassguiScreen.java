package net.mcreator.exmoxl.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.exmoxl.world.inventory.ChooseclassguiMenu;
import net.mcreator.exmoxl.network.ChooseclassguiButtonMessage;
import net.mcreator.exmoxl.ExmoxlMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class ChooseclassguiScreen extends AbstractContainerScreen<ChooseclassguiMenu> {
	private final static HashMap<String, Object> guistate = ChooseclassguiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_xiandao;
	ImageButton imagebutton_yaodao;
	ImageButton imagebutton_rendao;
	ImageButton imagebutton_modao;

	public ChooseclassguiScreen(ChooseclassguiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 0;
		this.imageHeight = 166;
	}

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();

		guiGraphics.blit(new ResourceLocation("exmoxl:textures/screens/xbj.png"), this.leftPos + -199, this.topPos + -20, 0, 0, 400, 200, 400, 200);

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
		imagebutton_xiandao = new ImageButton(this.leftPos + -172, this.topPos + 16, 50, 125, 0, 0, 125, new ResourceLocation("exmoxl:textures/screens/atlas/imagebutton_xiandao.png"), 50, 250, e -> {
			if (true) {
				ExmoxlMod.PACKET_HANDLER.sendToServer(new ChooseclassguiButtonMessage(0, x, y, z));
				ChooseclassguiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:imagebutton_xiandao", imagebutton_xiandao);
		this.addRenderableWidget(imagebutton_xiandao);
		imagebutton_yaodao = new ImageButton(this.leftPos + -73, this.topPos + 16, 50, 125, 0, 0, 125, new ResourceLocation("exmoxl:textures/screens/atlas/imagebutton_yaodao.png"), 50, 250, e -> {
			if (true) {
				ExmoxlMod.PACKET_HANDLER.sendToServer(new ChooseclassguiButtonMessage(1, x, y, z));
				ChooseclassguiButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:imagebutton_yaodao", imagebutton_yaodao);
		this.addRenderableWidget(imagebutton_yaodao);
		imagebutton_rendao = new ImageButton(this.leftPos + 26, this.topPos + 16, 50, 125, 0, 0, 125, new ResourceLocation("exmoxl:textures/screens/atlas/imagebutton_rendao.png"), 50, 250, e -> {
			if (true) {
				ExmoxlMod.PACKET_HANDLER.sendToServer(new ChooseclassguiButtonMessage(2, x, y, z));
				ChooseclassguiButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});
		guistate.put("button:imagebutton_rendao", imagebutton_rendao);
		this.addRenderableWidget(imagebutton_rendao);
		imagebutton_modao = new ImageButton(this.leftPos + 125, this.topPos + 16, 50, 125, 0, 0, 125, new ResourceLocation("exmoxl:textures/screens/atlas/imagebutton_modao.png"), 50, 250, e -> {
			if (true) {
				ExmoxlMod.PACKET_HANDLER.sendToServer(new ChooseclassguiButtonMessage(3, x, y, z));
				ChooseclassguiButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		});
		guistate.put("button:imagebutton_modao", imagebutton_modao);
		this.addRenderableWidget(imagebutton_modao);
	}
}
