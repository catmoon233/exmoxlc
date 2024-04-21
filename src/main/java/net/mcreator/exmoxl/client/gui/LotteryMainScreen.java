package net.mcreator.exmoxl.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.exmoxl.world.inventory.LotteryMainMenu;
import net.mcreator.exmoxl.network.LotteryMainButtonMessage;
import net.mcreator.exmoxl.ExmoxlMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class LotteryMainScreen extends AbstractContainerScreen<LotteryMainMenu> {
	private final static HashMap<String, Object> guistate = LotteryMainMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_wuka;

	public LotteryMainScreen(LotteryMainMenu container, Inventory inventory, Component text) {
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

		guiGraphics.blit(new ResourceLocation("exmoxl:textures/screens/background3.png"), this.leftPos + -199, this.topPos + -20, 0, 0, 400, 200, 400, 200);

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
		imagebutton_wuka = new ImageButton(this.leftPos + -172, this.topPos + -11, 78, 175, 0, 0, 175, new ResourceLocation("exmoxl:textures/screens/atlas/imagebutton_wuka.png"), 78, 350, e -> {
			if (true) {
				ExmoxlMod.PACKET_HANDLER.sendToServer(new LotteryMainButtonMessage(0, x, y, z));
				LotteryMainButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:imagebutton_wuka", imagebutton_wuka);
		this.addRenderableWidget(imagebutton_wuka);
	}
}
