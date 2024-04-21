package net.mcreator.exmoxl.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.GuiGraphics;
import net.mcreator.exmoxl.procedures.OpenlotteryofwaponProcedure;

import net.mcreator.exmoxl.world.inventory.LotteryshiMenu;
import net.mcreator.exmoxl.network.LotteryshiButtonMessage;
import net.mcreator.exmoxl.ExmoxlMod;

import java.util.HashMap;
import java.util.List;
import net.mcreator.exmoxl.network.ExmoxlModVariables;
import com.mojang.blaze3d.systems.RenderSystem;
import org.apache.logging.log4j.Logger;


public class LotteryshiScreen extends AbstractContainerScreen<LotteryshiMenu> {
	private final static HashMap<String, Object> guistate = LotteryshiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_air;

	public LotteryshiScreen(LotteryshiMenu container, Inventory inventory, Component text) {
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
		
		double cnum = (entity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ExmoxlModVariables.PlayerVariables())).cnum;
		double clevel = (entity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ExmoxlModVariables.PlayerVariables())).clevel;
		List<Integer> chou = (entity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ExmoxlModVariables.PlayerVariables())).chou;

		for (int i = 0; i < 10; i++) {
		if(i > cnum){
		guiGraphics.blit(new ResourceLocation("exmoxl:textures/screens/danchoua-button.png"), this.leftPos + -250 +(50*i), this.topPos + 7, 0, 0, 50, 125, 50, 125);
		}
		else{
		//if(chou.contains(i)){
		//System.out.printf(String.valueOf(i));

        if (chou.get(i) ==1){
		guiGraphics.blit(new ResourceLocation("exmoxl:textures/screens/danchoua-buttonw.png"), this.leftPos + -250+(50*i), this.topPos + 7, 0, 0, 50, 125, 50, 125);

        }

        if (chou.get(i) ==2){
		guiGraphics.blit(new ResourceLocation("exmoxl:textures/screens/danchoua-buttonb.png"), this.leftPos + -250+(50*i), this.topPos + 7, 0, 0, 50, 125, 50, 125);

        }
        
        if (chou.get(i) ==3){
		guiGraphics.blit(new ResourceLocation("exmoxl:textures/screens/danchoua-buttonp.png"), this.leftPos + -250+(50*i), this.topPos + 7, 0, 0, 50, 125, 50, 125);

        }
        
        if (chou.get(i) ==4){
		guiGraphics.blit(new ResourceLocation("exmoxl:textures/screens/danchoua-buttony.png"), this.leftPos + -250+(50*i), this.topPos + 7, 0, 0, 50, 125, 50, 125);
        }
		//}
		}


		guiGraphics.blit(new ResourceLocation("exmoxl:textures/screens/ka-ground.png"), this.leftPos + -397, this.topPos + -20, 0, 0, 800, 200, 800, 200);



		}
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
		imagebutton_air = new ImageButton(this.leftPos + -842, this.topPos + -324, 1920, 1080, 0, 0, 1080, new ResourceLocation("exmoxl:textures/screens/atlas/imagebutton_air.png"), 1920, 2160, e -> {
			if (true) {
				ExmoxlMod.PACKET_HANDLER.sendToServer(new LotteryshiButtonMessage(0, x, y, z));
				LotteryshiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:imagebutton_air", imagebutton_air);
		this.addRenderableWidget(imagebutton_air);
	}
}
