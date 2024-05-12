
package net.mcreator.exmoxl.client.screens;

import net.mcreator.exmoxl.ExmoxlMod;
import net.mcreator.exmoxl.TalentList;
import net.mcreator.exmoxl.client.gui.CharacterxttalentScreen;
import net.mcreator.exmoxl.network.CharacterxttalentButtonMessage;
import net.mcreator.exmoxl.network.ExmoxlModVariables;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.LevelAccessor;
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

import java.awt.*;
import java.util.List;
import java.util.Map;

@Mod.EventBusSubscriber({Dist.CLIENT})
public class CharacetexttalentsOverlay {

	static void reny(GuiGraphics guiGraphics,int x,int y,int style){
		String picture = "";
		switch (style){
			case 1:
				picture = "exmoxl:textures/screens/talentw.png";

				break;
			case 2:
				picture = "exmoxl:textures/screens/talent-b.png";

				break;
			case 3:
				picture = "exmoxl:textures/screens/talent-p.png";

				break;
			case 4:
				picture = "exmoxl:textures/screens/talent-y.png";
				break;
			default: return;
		}
		guiGraphics.blit(new ResourceLocation(picture), x, y, 0, 0, 75, 25, 75, 25);

	}

	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public static void eventHandler(ScreenEvent.Render.Post event) {
		int w = event.getScreen().width;
		int h = event.getScreen().height;


		int mx = w / 2 + -144 ,my =h / 2 + -49;
		Player entity = Minecraft.getInstance().player;

		if (event.getScreen() instanceof CharacterxttalentScreen cs) {

			Level world = null;

			List<String> tl = (entity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ExmoxlModVariables.PlayerVariables())).SelectTalent;
			double x = 0;
			double y = 0;
			double z = 0;
			Map<String, Integer> Sectf = (entity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ExmoxlModVariables.PlayerVariables())).TalentSz;
			List<Integer> Secint = (entity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ExmoxlModVariables.PlayerVariables())).TalentSz2;
			if (entity != null) {
				world = entity.level();
				x = entity.getX();
				y = entity.getY();
				z = entity.getZ();
			}
			if (
					((LevelAccessor) world).isClientSide()
			) {
				Font font = Minecraft.getInstance().font;

				int renx = mx;
				int reny = my;
				if (true) {
					for (int i = 0; i < 9; i++) {
						if (i == 3 || i == 6) {
							reny += 30;
							renx = mx;

						} else {
						}
						GuiGraphics guiGraphics = event.getGuiGraphics();
						//guiGraphics.blit(new ResourceLocation("exmoxl:textures/screens/talent-y.png"), 100, 100, 0, 0, 75, 25, 75, 25);

						if (!tl.isEmpty()) {
							if (TalentList.TalentQlist.containsKey(tl.get(i))) {
								reny(guiGraphics, renx, reny, TalentList.TalentQlist.get(tl.get(i)));
								guiGraphics.drawString(font, tl.get(i), renx + (75 - font.width(tl.get(i))) / 2, reny + 5, -1);
//								if (Secint.containsKey(i)) {
//									ExmoxlMod.LOGGER.debug("pepren " + Secint.get(i));
									if (Secint.contains(i)) {
										//ExmoxlMod.LOGGER.debug("ren" + i);
										guiGraphics.blit(new ResourceLocation("exmoxl:textures/screens/talentselect.png"), renx + 1, reny + 1, 0, 0, 78, 28, 78, 28);
									}
							//	}
							}
						}
						renx += 100;

						//	ExmoxlMod.LOGGER.debug("tl.get(i)");
						//
//					guiGraphics.blit(new ResourceLocation("exmoxl:textures/screens/talent-y.png"), cs.csx, cs.csy, 0, 0, 75, 25, 75, 25);
//
					}
				}
			}
		}
	}
}
