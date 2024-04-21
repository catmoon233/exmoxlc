package net.mcreator.exmoxl.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.exmoxl.world.inventory.LotteryweaponMenu;
import net.mcreator.exmoxl.procedures.TextofchouProcedure;
import net.mcreator.exmoxl.procedures.Textofchou2Procedure;
import net.mcreator.exmoxl.network.LotteryweaponButtonMessage;
import net.mcreator.exmoxl.ExmoxlMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class LotteryweaponScreen extends AbstractContainerScreen<LotteryweaponMenu> {
	private final static HashMap<String, Object> guistate = LotteryweaponMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_shilianbutton;
	ImageButton imagebutton_danchoubutton;

	public LotteryweaponScreen(LotteryweaponMenu container, Inventory inventory, Component text) {
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

		guiGraphics.blit(new ResourceLocation("exmoxl:textures/screens/ka2.png"), this.leftPos + -181, this.topPos + -11, 0, 0, 340, 178, 340, 178);

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

				TextofchouProcedure.execute(entity), -176, 152, -1, false);
		guiGraphics.drawString(this.font,

				Textofchou2Procedure.execute(entity), -177, 138, -1, false);
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
		imagebutton_shilianbutton = new ImageButton(this.leftPos + 71, this.topPos + 133, 80, 30, 0, 0, 30, new ResourceLocation("exmoxl:textures/screens/atlas/imagebutton_shilianbutton.png"), 80, 60, e -> {
			if (true) {
				ExmoxlMod.PACKET_HANDLER.sendToServer(new LotteryweaponButtonMessage(0, x, y, z));
				LotteryweaponButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:imagebutton_shilianbutton", imagebutton_shilianbutton);
		this.addRenderableWidget(imagebutton_shilianbutton);
		imagebutton_danchoubutton = new ImageButton(this.leftPos + -19, this.topPos + 133, 80, 30, 0, 0, 30, new ResourceLocation("exmoxl:textures/screens/atlas/imagebutton_danchoubutton.png"), 80, 60, e -> {
			if (true) {
				ExmoxlMod.PACKET_HANDLER.sendToServer(new LotteryweaponButtonMessage(1, x, y, z));
				LotteryweaponButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:imagebutton_danchoubutton", imagebutton_danchoubutton);
		this.addRenderableWidget(imagebutton_danchoubutton);
	}
}
