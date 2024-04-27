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

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class TaskguiScreen extends AbstractContainerScreen<TaskguiMenu> {
    private final static HashMap<String, Object> guistate = TaskguiMenu.guistate;
    private final Level world;
    private final int x, y, z;
    private final Player entity;
    ImageButton imagebutton_taskbutton;

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

        mx = gx;
        px = this.leftPos + -179;
        py = this.topPos + -20;
        my = gy;

        RenderSystem.disableBlend();
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
    public void containerTick( ) {
        super.containerTick();
    }

    @Override

    protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
        String talknr = (entity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ExmoxlModVariables.PlayerVariables())).tasknr;
        int nrline;
        List<String> wrappedLines = new ArrayList<>();
        String xxnr = talknr;
        int maxLineWidth = 100; // 选择一个合适的最大宽度值

        for (int index = 0; index * maxLineWidth < font.width(xxnr); index++) {
            xxnr = font.plainSubstrByWidth(talknr, maxLineWidth);
            wrappedLines.add(xxnr);
            xxnr = generateTextC(xxnr,talknr);
            talknr = xxnr;
        }
        List<String> pl;
        pl = (entity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ExmoxlModVariables.PlayerVariables())).task;
         for (int index = 0; index < pl.size(); index++)System.out.printf(pl.get(index));
        for (int index = 0; index < 6; index++) {
            if(pl.size()>index){
                guiGraphics.drawString(this.font, Component.literal(pl.get(index)), -190, -11  +36*index, -12829636, false);

            }
        }
        int lineint=0;
        for (String wrappedLine : wrappedLines) {
        	System.out.printf(wrappedLine);
            lineint++;
            guiGraphics.drawString(this.font, Component.literal(wrappedLine), -64, 34 + font.lineHeight*lineint, -12829636, false);
        }




        guiGraphics.drawString(this.font, Component.literal((entity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ExmoxlModVariables.PlayerVariables())).tasktitle), -64, -2, -12829636, false);
        guiGraphics.drawString(this.font, Component.literal((entity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ExmoxlModVariables.PlayerVariables())).taskftitle), -64, 7, -12829636, false);
    }

    public static String generateTextC(String a, String b) {
        StringBuilder c = new StringBuilder();
        for (char charB : b.toCharArray()) {
            if (a.indexOf(charB) == -1) {
                c.append(charB);
            }
        }
        return c.toString();
    }
    @Override
    public void onClose() {
        super.onClose();
    }

    @Override
    public void init() {
        List<String> pl;
        pl = (entity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ExmoxlModVariables.PlayerVariables())).task;
        int index = 0;
        index = pl.size();
        if (pl.size()>6)index = 6;
        super.init();
        imagebutton_taskbutton = new ImageButton(this.leftPos + -199, this.topPos + -20, 130, 4 + 32*index, 0, 0, 200, new ResourceLocation("exmoxl:textures/screens/atlas/imagebutton_taskbutton.png"), 130, 400, e -> {
            if (true) {
                ExmoxlMod.PACKET_HANDLER.sendToServer(new TaskguiButtonMessage(0, x, y, z));
                TaskguiButtonMessage.handleButtonAction(entity, 0, x, y, z);
            }
        });
        guistate.put("button:imagebutton_taskbutton", imagebutton_taskbutton);
        this.addRenderableWidget(imagebutton_taskbutton);
    }
}
