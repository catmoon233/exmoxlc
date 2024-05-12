
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.exmoxl.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import net.mcreator.exmoxl.world.inventory.WeawordkbeachguiMenu;
import net.mcreator.exmoxl.world.inventory.TaskguiMenu;
import net.mcreator.exmoxl.world.inventory.StoneDungeonMenu;
import net.mcreator.exmoxl.world.inventory.RecastingMenu;
import net.mcreator.exmoxl.world.inventory.LotteryweaponMenu;
import net.mcreator.exmoxl.world.inventory.LotteryshiMenu;
import net.mcreator.exmoxl.world.inventory.LotterydanMenu;
import net.mcreator.exmoxl.world.inventory.LotteryMainMenu;
import net.mcreator.exmoxl.world.inventory.ChooseclassguiMenu;
import net.mcreator.exmoxl.world.inventory.CharacterxttalentMenu;
import net.mcreator.exmoxl.world.inventory.CharacterPanelMenu;
import net.mcreator.exmoxl.world.inventory.AttrmbMenu;
import net.mcreator.exmoxl.world.inventory.ActivatiguiMenu;
import net.mcreator.exmoxl.ExmoxlMod;

public class ExmoxlModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, ExmoxlMod.MODID);
	public static final RegistryObject<MenuType<CharacterPanelMenu>> CHARACTER_PANEL = REGISTRY.register("character_panel", () -> IForgeMenuType.create(CharacterPanelMenu::new));
	public static final RegistryObject<MenuType<ActivatiguiMenu>> ACTIVATIGUI = REGISTRY.register("activatigui", () -> IForgeMenuType.create(ActivatiguiMenu::new));
	public static final RegistryObject<MenuType<RecastingMenu>> RECASTING = REGISTRY.register("recasting", () -> IForgeMenuType.create(RecastingMenu::new));
	public static final RegistryObject<MenuType<ChooseclassguiMenu>> CHOOSECLASSGUI = REGISTRY.register("chooseclassgui", () -> IForgeMenuType.create(ChooseclassguiMenu::new));
	public static final RegistryObject<MenuType<AttrmbMenu>> ATTRMB = REGISTRY.register("attrmb", () -> IForgeMenuType.create(AttrmbMenu::new));
	public static final RegistryObject<MenuType<WeawordkbeachguiMenu>> WEAWORDKBEACHGUI = REGISTRY.register("weawordkbeachgui", () -> IForgeMenuType.create(WeawordkbeachguiMenu::new));
	public static final RegistryObject<MenuType<LotteryMainMenu>> LOTTERY_MAIN = REGISTRY.register("lottery_main", () -> IForgeMenuType.create(LotteryMainMenu::new));
	public static final RegistryObject<MenuType<LotteryweaponMenu>> LOTTERYWEAPON = REGISTRY.register("lotteryweapon", () -> IForgeMenuType.create(LotteryweaponMenu::new));
	public static final RegistryObject<MenuType<LotterydanMenu>> LOTTERYDAN = REGISTRY.register("lotterydan", () -> IForgeMenuType.create(LotterydanMenu::new));
	public static final RegistryObject<MenuType<LotteryshiMenu>> LOTTERYSHI = REGISTRY.register("lotteryshi", () -> IForgeMenuType.create(LotteryshiMenu::new));
	public static final RegistryObject<MenuType<TaskguiMenu>> TASKGUI = REGISTRY.register("taskgui", () -> IForgeMenuType.create(TaskguiMenu::new));
	public static final RegistryObject<MenuType<CharacterxttalentMenu>> CHARACTERXTTALENT = REGISTRY.register("characterxttalent", () -> IForgeMenuType.create(CharacterxttalentMenu::new));
	public static final RegistryObject<MenuType<StoneDungeonMenu>> STONE_DUNGEON = REGISTRY.register("stone_dungeon", () -> IForgeMenuType.create(StoneDungeonMenu::new));
}
