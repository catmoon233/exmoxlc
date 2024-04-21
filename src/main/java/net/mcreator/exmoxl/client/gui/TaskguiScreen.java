package net.mcreator.exmoxl.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.GuiGraphics;
import net.mcreator.exmoxl.network.ExmoxlModVariables;

import net.mcreator.exmoxl.world.inventory.TaskguiMenu;
import net.mcreator.exmoxl.network.TaskguiButtonMessage;
import net.mcreator.exmoxl.ExmoxlMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class TaskguiScreen extends AbstractContainerScreen<TaskguiMenu> {
	private final static HashMap<String, Object> guistate = TaskguiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_hui;

	public TaskguiScreen(TaskguiMenu container, Inventory inventory, Component text) {
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
    public static int mx;
    public static int px;
    public static int py;
    public static int my;
	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();

		guiGraphics.blit(new ResourceLocation("exmoxl:textures/screens/task-background.png"), this.leftPos + -199, this.topPos + -20, 0, 0, 400, 200, 400, 200);

        List<String> pl;
        System.out.printf(mx+"|"+my+"|"+px+"|"+py+"\n");
        pl = (entity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ExmoxlModVariables.PlayerVariables())).task;
        if (pl != null) {
            for (int index = 0; index < 6; index++) {
                if (pl.size() > index) {
                    //  System.out.printf(pl.get(index)+"\n");
                    if (pl.get((int) (index)) != null) {
                        guiGraphics.blit(new ResourceLocation("exmoxl:textures/screens/task.png"), this.leftPos + -199, this.topPos + -20 + 36 * index, 0, 0, 130, 36, 130, 36);
                    }
                }
            }
        }
        mx = gx;
        px = this.leftPos + -199;
        py = this.topPos + -20;
        my = gy;

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
        List<String> pl;
        pl = (entity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ExmoxlModVariables.PlayerVariables())).task;
        // for (int index = 0; index < pl.size(); index++)System.out.printf(pl.get(index));
        for (int index = 0; index < 6; index++) {
            if(pl.size()>index){
                guiGraphics.drawString(this.font, Component.literal(pl.get(index)), -190, -11  +36*index, -12829636, false);

            }
        }
        if (pl.size() > ((int) ((entity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ExmoxlModVariables.PlayerVariables())).taskxz))) {
            guiGraphics.drawString(this.font, Component.translatable("title"), -64, -2, -12829636, false);
            guiGraphics.drawString(this.font, Component.translatable("title2"), -64, 7, -12829636, false);
            guiGraphics.drawString(this.font, Component.translatable("nr"), -64, 34, -12829636, false);
        }
    }

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
		imagebutton_hui = new ImageButton(this.leftPos + -217, this.topPos + -47, 250, 250, 0, 0, 250, new ResourceLocation("exmoxl:textures/screens/atlas/imagebutton_hui.png"), 250, 500, e -> {
			if (true) {
				ExmoxlMod.PACKET_HANDLER.sendToServer(new TaskguiButtonMessage(0, x, y, z));
				TaskguiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:imagebutton_hui", imagebutton_hui);
		this.addRenderableWidget(imagebutton_hui);
	}
}
