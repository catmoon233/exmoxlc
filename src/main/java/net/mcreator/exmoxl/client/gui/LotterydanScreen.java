package net.mcreator.exmoxl.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.exmoxl.world.inventory.LotterydanMenu;
import net.mcreator.exmoxl.procedures.RendomdanchouxsProcedure;
import net.mcreator.exmoxl.network.LotterydanButtonMessage;
import net.mcreator.exmoxl.ExmoxlMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;
import java.util.List;
import net.minecraft.world.level.LevelAccessor;

public class LotterydanScreen extends AbstractContainerScreen<LotterydanMenu> {
	private final static HashMap<String, Object> guistate = LotterydanMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_danchouabutton;
	ImageButton imagebutton_backbutton;

	public LotterydanScreen(LotterydanMenu container, Inventory inventory, Component text) {
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
		LevelAccessor level = (LevelAccessor)world;
		if(level.isClientSide()){

        if (LotterydanButtonMessage.clevel ==1){
        guiGraphics.blit(new ResourceLocation("exmoxl:textures/screens/danchoua-buttonw.png"), this.leftPos + -28, this.topPos + 7, 0, 0, 50, 125, 50, 125);
        }

        if (LotterydanButtonMessage.clevel ==2){
        guiGraphics.blit(new ResourceLocation("exmoxl:textures/screens/danchoua-buttonb.png"), this.leftPos + -28, this.topPos + 7, 0, 0, 50, 125, 50, 125);
        }
        
        if (LotterydanButtonMessage.clevel ==3){
        guiGraphics.blit(new ResourceLocation("exmoxl:textures/screens/danchoua-buttonp.png"), this.leftPos + -28, this.topPos + 7, 0, 0, 50, 125, 50, 125);
        }
        
        if (LotterydanButtonMessage.clevel ==4){
        guiGraphics.blit(new ResourceLocation("exmoxl:textures/screens/danchoua-buttony.png"), this.leftPos + -28, this.topPos + 7, 0, 0, 50, 125, 50, 125);
        }
        RenderSystem.disableBlend();
	}
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
imagebutton_danchouabutton = new ImageButton(this.leftPos + -28, this.topPos + 7, 50, 125, 0, 0, 125, new ResourceLocation("exmoxl:textures/screens/atlas/imagebutton_danchouabutton.png"), 50, 250, e -> {
			if (LotterydanButtonMessage.clevel ==0) {
				ExmoxlMod.PACKET_HANDLER.sendToServer(new LotterydanButtonMessage(0, x, y, z));
				LotterydanButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}) {
			@Override
			public void render(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				if (LotterydanButtonMessage.clevel ==0)
					super.render(guiGraphics, gx, gy, ticks);
			}
		};
		guistate.put("button:imagebutton_danchouabutton", imagebutton_danchouabutton);
		this.addRenderableWidget(imagebutton_danchouabutton);
		imagebutton_backbutton = new ImageButton(this.leftPos + -208, this.topPos + -29, 80, 30, 0, 0, 30, new ResourceLocation("exmoxl:textures/screens/atlas/imagebutton_backbutton.png"), 80, 60, e -> {
			if (true) {
				ExmoxlMod.PACKET_HANDLER.sendToServer(new LotterydanButtonMessage(1, x, y, z));
				LotterydanButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:imagebutton_backbutton", imagebutton_backbutton);
		this.addRenderableWidget(imagebutton_backbutton);
	}
}
