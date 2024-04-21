package net.mcreator.exmoxl.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.GuiGraphics;
import net.mcreator.exmoxl.network.ExmoxlModVariables;

import net.mcreator.exmoxl.world.inventory.AttrmbMenu;
import net.mcreator.exmoxl.procedures.XpxsProcedure;
import net.mcreator.exmoxl.procedures.TfdsxProcedure;
import net.mcreator.exmoxl.procedures.StrxsProcedure;
import net.mcreator.exmoxl.procedures.SelfmodleProcedure;
import net.mcreator.exmoxl.procedures.LevelxsProcedure;
import net.mcreator.exmoxl.procedures.IgnsProcedure;
import net.mcreator.exmoxl.procedures.AgisxProcedure;
import net.mcreator.exmoxl.network.AttrmbButtonMessage;
import net.mcreator.exmoxl.ExmoxlMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class AttrmbScreen extends AbstractContainerScreen<AttrmbMenu> {
	private final static HashMap<String, Object> guistate = AttrmbMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_attmbb22;
	ImageButton imagebutton_attmbb221;
	ImageButton imagebutton_attmbb222;
   	public static int bt;

	public AttrmbScreen(AttrmbMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 0;
		this.imageHeight = 166;
		double xp = (entity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ExmoxlModVariables.PlayerVariables())).playerxp;
		double xpup = (entity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ExmoxlModVariables.PlayerVariables())).playerupxp;
		bt = (int)((xp/xpup) *100);
	}

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		if (SelfmodleProcedure.execute(entity) instanceof LivingEntity livingEntity) {
			InventoryScreen.renderEntityInInventoryFollowsAngle(guiGraphics, this.leftPos + -72, this.topPos + 63, 30, 0f + (float) Math.atan((this.leftPos + -72 - mouseX) / 40.0), (float) Math.atan((this.topPos + 14 - mouseY) / 40.0), livingEntity);
		}
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();

		guiGraphics.blit(new ResourceLocation("exmoxl:textures/screens/attmb.png"), this.leftPos + -109, this.topPos + -20, 0, 0, 216, 171, 216, 171);

		guiGraphics.blit(new ResourceLocation("exmoxl:textures/screens/levelbar1.png"), this.leftPos + -100, this.topPos + 79, 0, 0, 100, 20, 100, 20);

		guiGraphics.blit(new ResourceLocation("exmoxl:textures/screens/levelbar2.png"), this.leftPos + -100, this.topPos + 79, 0, 0, bt, 20, 100, 20);

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

				StrxsProcedure.execute(entity), 38, 1, -12829636, false);
		guiGraphics.drawString(this.font,

				AgisxProcedure.execute(entity), 38, 25, -12829636, false);
		guiGraphics.drawString(this.font,

				IgnsProcedure.execute(entity), 38, 47, -12829636, false);
		guiGraphics.drawString(this.font,

				XpxsProcedure.execute(entity), -94, 85, -12829636, false);
		guiGraphics.drawString(this.font,

				LevelxsProcedure.execute(entity), 4, 86, -12829636, false);
		guiGraphics.drawString(this.font,

				TfdsxProcedure.execute(entity), 31, 68, -12829636, false);
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
		imagebutton_attmbb22 = new ImageButton(this.leftPos + 21, this.topPos + -1, 16, 15, 0, 0, 15, new ResourceLocation("exmoxl:textures/screens/atlas/imagebutton_attmbb22.png"), 16, 30, e -> {
			if (true) {
				ExmoxlMod.PACKET_HANDLER.sendToServer(new AttrmbButtonMessage(0, x, y, z));
				AttrmbButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:imagebutton_attmbb22", imagebutton_attmbb22);
		this.addRenderableWidget(imagebutton_attmbb22);
		imagebutton_attmbb221 = new ImageButton(this.leftPos + 21, this.topPos + 22, 16, 15, 0, 0, 15, new ResourceLocation("exmoxl:textures/screens/atlas/imagebutton_attmbb221.png"), 16, 30, e -> {
			if (true) {
				ExmoxlMod.PACKET_HANDLER.sendToServer(new AttrmbButtonMessage(1, x, y, z));
				AttrmbButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:imagebutton_attmbb221", imagebutton_attmbb221);
		this.addRenderableWidget(imagebutton_attmbb221);
		imagebutton_attmbb222 = new ImageButton(this.leftPos + 21, this.topPos + 44, 16, 15, 0, 0, 15, new ResourceLocation("exmoxl:textures/screens/atlas/imagebutton_attmbb222.png"), 16, 30, e -> {
			if (true) {
				ExmoxlMod.PACKET_HANDLER.sendToServer(new AttrmbButtonMessage(2, x, y, z));
				AttrmbButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});
		guistate.put("button:imagebutton_attmbb222", imagebutton_attmbb222);
		this.addRenderableWidget(imagebutton_attmbb222);
	}
}
