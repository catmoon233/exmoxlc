
package net.mcreator.exmoxl.client.screens;

import net.mcreator.exmoxl.ExmoxlMod;
import net.mcreator.exmoxl.Uiutil;
import net.mcreator.exmoxl.client.gui.StoneDungeonScreen;
import net.mcreator.exmoxl.network.ExmoxlModVariables;
import net.mcreator.exmoxl.utils.dungeon;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;
import org.checkerframework.checker.units.qual.h;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.client.event.ScreenEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.client.gui.screens.TitleScreen;
import net.minecraft.client.Minecraft;

import java.util.List;

@Mod.EventBusSubscriber({Dist.CLIENT})
public class StoneDungeonAddonOverlay {

	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public static void eventHandler(ScreenEvent.Render.Post event) {
		if (event.getScreen() instanceof StoneDungeonScreen) {
			int w = event.getScreen().width;
			int h = event.getScreen().height;
			Level world = null;
			double x = 0;
			double y = 0;
			double z = 0;
			Player entity = Minecraft.getInstance().player;
			if (entity != null) {
				world = entity.level();
				x = entity.getX();
				y = entity.getY();
				z = entity.getZ();
			}
			Font font = Minecraft.getInstance().font;
			GuiGraphics gg =event.getGuiGraphics();
//			ExmoxlMod.LOGGER.debug("dungeonindex: " + (entity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ExmoxlModVariables.PlayerVariables())).SelectDungeon);
			int  Select = (int) ((entity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ExmoxlModVariables.PlayerVariables())).SelectDungeon);
			String dungeonindex = (entity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ExmoxlModVariables.PlayerVariables())).StoneSignIndex;
			List<dungeon.Dungeon> dungeons = dungeon.getDungeons(dungeonindex);

//				ExmoxlMod.LOGGER.debug("dungeonindex2: " + dungeonindex);
//				ExmoxlMod.LOGGER.debug("dungeons: " + dungeons);
				gg.blit(new ResourceLocation("exmoxl:textures/screens/"  + dungeons.get(Select).picturename + ".png"), w / 2 + -200 + 93, h / 2 + -120 , 0, 0, 306, 103, 306, 103);

					gg.drawString(font, dungeons.get(Select).dungeonname, w / 2 + -200 + 93  + (((306-(font.width(dungeons.get(Select).dungeonname)))) / 2), h / 2 + -121 +2, -16777216, false);

				String  des = dungeons.get(Select).dungeonDecription;

				 List<String> rl = Uiutil.linefeed(des, 305, font);
				 for(int i = 0; i < rl.size(); i++){
					 gg.drawString(font, rl.get(i),w / 2 + -200 + 93, h / 2 + -121 +107  + i *font.lineHeight   , -1, false);
				 }


				for(int i = 0; i < dungeons.size(); i++) {
					gg.blit(new ResourceLocation("exmoxl:textures/screens/talentselect.png"), w / 2 + -198, h / 2 + -121 +i*47, 0, 0, 90, 47, 90, 47);
					int finalI = i;
						gg.drawString(font, dungeons.get(finalI).dungeonname, w / 2 + -198 + (((89-(font.width(dungeons.get(finalI).dungeonname)))) / 2), h / 2 + -121 + finalI *47 + 20, -1, false);
				}



        }
	}
}
