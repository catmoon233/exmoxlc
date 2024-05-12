package net.mcreator.exmoxl.client.gui;

import net.mcreator.exmoxl.TalentList;
import net.mcreator.exmoxl.network.ExmoxlModVariables;
import net.minecraft.client.player.LocalPlayer;
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

import net.mcreator.exmoxl.world.inventory.CharacterxttalentMenu;
import net.mcreator.exmoxl.procedures.SelfmodleProcedure;
import net.mcreator.exmoxl.network.CharacterxttalentButtonMessage;
import net.mcreator.exmoxl.ExmoxlMod;

import java.util.*;

import com.mojang.blaze3d.systems.RenderSystem;

public class CharacterxttalentScreen extends AbstractContainerScreen<CharacterxttalentMenu> {
	private final static HashMap<String, Object> guistate = CharacterxttalentMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	public  int leftpos = this.leftPos;
	public  int toppos = this.topPos;
	ImageButton imagebutton_enterp;
	ImageButton imagebutton_backround2;
	public CharacterxttalentScreen(CharacterxttalentMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 0;
		this.imageHeight = 166;
	}
	public static List<String> talentxz = new ArrayList<>();
	public static int mouseXx;
	public static int Widthh ;
	public static int Heightt;
	public static int mouseYy;

	private static final ResourceLocation texture = new ResourceLocation("exmoxl:textures/screens/characterxttalent.png");
	protected static ResourceLocation getPlayerSkin(LocalPlayer player) {
		return player.getSkinTextureLocation();
	}
	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		Widthh = this.width;
		Heightt = this.height;
		mouseXx =mouseX;
		mouseYy = mouseY;
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
            ResourceLocation l = getPlayerSkin(this.minecraft.player);
//		if (SelfmodleProcedure.execute(entity) instanceof LivingEntity livingEntity) {
//			InventoryScreen.renderEntityInInventoryFollowsAngle(guiGraphics, this.leftPos + -171, this.topPos + 18, 20, 0f, 0, livingEntity);
//		}
		//guiGraphics.pose().scale(0.5f, 0.5f, 0.5f);
		guiGraphics.blit(l, this.leftPos + -188, this.topPos -20, 32, 32, 32, 32);
		guiGraphics.blit(l, this.leftPos + -188, this.topPos -20, 160, 32, 32, 32);
	//	guiGraphics.pose().scale(2f, 2f, 2f);
        this.renderTooltip(guiGraphics, mouseX, mouseY);
		List<String> list = (entity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ExmoxlModVariables.PlayerVariables())).SelectTalent;
		int rx = width / 2 + -144 ,ry =height / 2 + -49;
		int by = ry;
		int bx = rx;
		for (int i = 0; i < 9; i++) {
			if(i==3||i==6){
				by += 30;
				bx = rx;

			}
			if (mouseX > bx && mouseX < bx +75 && mouseY > by  && mouseY < by+25) {
				try {
					guiGraphics.renderTooltip(font, Component.translatable(TalentList.TalenDecription.get(list.get(i))), mouseX, mouseY);
				} catch (Exception e) {
					ExmoxlMod.LOGGER.warn("Couldn't render tooltip for " + TalentList.TalenDecription.get(list.get(i)));
				}
			}


				bx += 100;
		}

	}
	public  static int  Selectioningtf(){
		int rx = Widthh / 2 + -144 ,ry =Heightt / 2 + -49;
		int by = ry;
		int bx = rx;
		for (int i = 0; i < 10; i++) {
			if(i==3||i==6){
				by += 30;
				bx = rx;

			}
			if (mouseXx > bx && mouseXx < bx +75 && mouseYy > by  && mouseYy < by+25)
				return i;

			bx += 100;
		}
		return -1;
	}
	public int csx = this.leftPos + -163,csy =  this.topPos + 43;
	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		guiGraphics.blit(new ResourceLocation("exmoxl:textures/screens/backround.png"), 0, 0, 0, 0, width, height, width, height);

		guiGraphics.blit(new ResourceLocation("exmoxl:textures/screens/backround.png"), this.leftPos + -197, this.topPos + -29, 0, 0, 50, 50, 50, 50);

		guiGraphics.blit(new ResourceLocation("exmoxl:textures/screens/backround2.png"), this.leftPos + -181, this.topPos + 25, 0, 0, 350, 175, 350, 175);

		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		return false;
	}

	public static void InitTalent(LivingEntity entity)
	{
		Random random = new Random();
		if ((entity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ExmoxlModVariables.PlayerVariables())).SelectTalent.isEmpty()){
			for(int i = 0;i<10;i++){
				ExmoxlMod.LOGGER.debug("初始化天赋"+TalentList.TalentList.size());
				int index = random.nextInt(TalentList.TalentList.size());
				{
					entity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						List<String> list = capability.SelectTalent;
						list.add(TalentList.TalentList.get(index));
						capability.SelectTalent = list;
						Map<String, Integer> smap = capability.TalentSz;
						for (String s : TalentList.TalentList) {
							smap.put(s,0);
						}
						capability.TalentSz = smap;
						capability.syncPlayerVariables(entity);
					});
				}

			}
			ExmoxlMod.LOGGER.debug("初始化成功");
			System.out.printf("cushihua");
			for (String s : TalentList.TalentList) {
				ExmoxlMod.LOGGER.debug("先天天赋:"+ s);

			}
		}
	}
	@Override
	public void containerTick() {

		super.containerTick();
	}
	public static int xz;
	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		String zz = "无";
		int zzindex = (int) (entity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ExmoxlModVariables.PlayerVariables())).classes;
		switch (zzindex){
			case 1:
				zz = "仙道";
				break;
			case 2:
				zz = "妖道";
				break;
			case 3:
				zz = "人道";
				break;
			case 4:
				zz = "魔道";
				break;
		}

		Map<String, Integer> ts = entity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ExmoxlModVariables.PlayerVariables()).TalentSz;
		List<String> tl = entity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ExmoxlModVariables.PlayerVariables()).SelectTalent;
		xz = 0;
		ts.forEach((k, v) -> {
			xz += TalentList.TalentQlist.get((k)) * v;
		});

//		for (	int i = 0;
//				 i<
//						 ts.size();
//				 i++
//		)
//		{
//			if (ts.containsKey(tl.get(i))) {
//                xz += TalentList.TalentQlist.get((tl.get(i))) * ts.get((tl.get(i)));
//			}
//		}
		guiGraphics.pose().pushPose();
		guiGraphics.pose().scale(1.5f,1.5f,0f);
		guiGraphics.drawString(this.font, Component.literal(xz + " / 12"), -55, 120, -3355444, false);
		guiGraphics.drawString(this.font, Component.translatable("大道:"+zz), -90, 8, -3355444, false);
		guiGraphics.drawString(this.font, "天选者:"+entity.getDisplayName().getString(), -90, -12, -3355444, false);
		guiGraphics.pose().popPose();
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
		imagebutton_backround2 = new ImageButton(this.leftPos + -181, this.topPos + 25, 350, 175, 0, 0, 175, new ResourceLocation("exmoxl:textures/screens/atlas/imagebutton_backround2.png"), 350, 350, e -> {
			if (true) {
				ExmoxlMod.PACKET_HANDLER.sendToServer(new CharacterxttalentButtonMessage(0, x, y, z));
				CharacterxttalentButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:imagebutton_backround2", imagebutton_backround2);
		this.addRenderableWidget(imagebutton_backround2);
		imagebutton_enterp = new ImageButton(this.leftPos + 170, this.topPos + 169, 50, 25, 0, 0, 25, new ResourceLocation("exmoxl:textures/screens/atlas/imagebutton_enterp.png"), 50, 50, e -> {
			if (true) {
				ExmoxlMod.PACKET_HANDLER.sendToServer(new CharacterxttalentButtonMessage(1, x, y, z));
				CharacterxttalentButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:imagebutton_enterp", imagebutton_enterp);
		this.addRenderableWidget(imagebutton_enterp);
	}
}
