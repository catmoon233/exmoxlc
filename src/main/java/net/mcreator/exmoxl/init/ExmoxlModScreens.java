
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.exmoxl.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import net.mcreator.exmoxl.client.gui.WeawordkbeachguiScreen;
import net.mcreator.exmoxl.client.gui.TaskguiScreen;
import net.mcreator.exmoxl.client.gui.StoneDungeonScreen;
import net.mcreator.exmoxl.client.gui.RecastingScreen;
import net.mcreator.exmoxl.client.gui.LotteryweaponScreen;
import net.mcreator.exmoxl.client.gui.LotteryshiScreen;
import net.mcreator.exmoxl.client.gui.LotterydanScreen;
import net.mcreator.exmoxl.client.gui.LotteryMainScreen;
import net.mcreator.exmoxl.client.gui.ChooseclassguiScreen;
import net.mcreator.exmoxl.client.gui.CharacterxttalentScreen;
import net.mcreator.exmoxl.client.gui.CharacterPanelScreen;
import net.mcreator.exmoxl.client.gui.AttrmbScreen;
import net.mcreator.exmoxl.client.gui.ActivatiguiScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ExmoxlModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(ExmoxlModMenus.CHARACTER_PANEL.get(), CharacterPanelScreen::new);
			MenuScreens.register(ExmoxlModMenus.ACTIVATIGUI.get(), ActivatiguiScreen::new);
			MenuScreens.register(ExmoxlModMenus.RECASTING.get(), RecastingScreen::new);
			MenuScreens.register(ExmoxlModMenus.CHOOSECLASSGUI.get(), ChooseclassguiScreen::new);
			MenuScreens.register(ExmoxlModMenus.ATTRMB.get(), AttrmbScreen::new);
			MenuScreens.register(ExmoxlModMenus.WEAWORDKBEACHGUI.get(), WeawordkbeachguiScreen::new);
			MenuScreens.register(ExmoxlModMenus.LOTTERY_MAIN.get(), LotteryMainScreen::new);
			MenuScreens.register(ExmoxlModMenus.LOTTERYWEAPON.get(), LotteryweaponScreen::new);
			MenuScreens.register(ExmoxlModMenus.LOTTERYDAN.get(), LotterydanScreen::new);
			MenuScreens.register(ExmoxlModMenus.LOTTERYSHI.get(), LotteryshiScreen::new);
			MenuScreens.register(ExmoxlModMenus.TASKGUI.get(), TaskguiScreen::new);
			MenuScreens.register(ExmoxlModMenus.CHARACTERXTTALENT.get(), CharacterxttalentScreen::new);
			MenuScreens.register(ExmoxlModMenus.STONE_DUNGEON.get(), StoneDungeonScreen::new);
		});
	}
}
