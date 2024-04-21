
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.exmoxl.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.mcreator.exmoxl.ExmoxlMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ExmoxlModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ExmoxlMod.MODID);
	public static final RegistryObject<CreativeModeTab> EXMOXL = REGISTRY.register("exmoxl",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.exmoxl.exmoxl")).icon(() -> new ItemStack(ExmoxlModItems.IRONP.get())).displayItems((parameters, tabData) -> {
				tabData.accept(ExmoxlModItems.WANDAO.get());
				tabData.accept(ExmoxlModItems.ASKSKY.get());
				tabData.accept(ExmoxlModBlocks.ACTIVATOR.get().asItem());
				tabData.accept(ExmoxlModItems.STAR_FLAME_POWDER.get());
				tabData.accept(ExmoxlModItems.MISCELLANEOUS_DUST.get());
				tabData.accept(ExmoxlModItems.THREEFLAME.get());
				tabData.accept(ExmoxlModItems.SMELTING_STONE.get());
				tabData.accept(ExmoxlModItems.WASHSTONE.get());
				tabData.accept(ExmoxlModBlocks.RECASTING_TABLE.get().asItem());
				tabData.accept(ExmoxlModItems.IRONP.get());
				tabData.accept(ExmoxlModBlocks.BLACK_FURNACE.get().asItem());
				tabData.accept(ExmoxlModItems.WRENCH.get());
				tabData.accept(ExmoxlModBlocks.BLACKFURNACEMAIN.get().asItem());
				tabData.accept(ExmoxlModBlocks.BLACKFURNACESTEP.get().asItem());
				tabData.accept(ExmoxlModItems.CUSTOMITEM.get());
				tabData.accept(ExmoxlModBlocks.WEAWORKBEACH.get().asItem());
				tabData.accept(ExmoxlModItems.DNZ.get());
				tabData.accept(ExmoxlModItems.ASKSKY_2.get());
			})

					.build());

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {

		if (tabData.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
			tabData.accept(ExmoxlModItems.XUMI_RING.get());
		}
	}
}
