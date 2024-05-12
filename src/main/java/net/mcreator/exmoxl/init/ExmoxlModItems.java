
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.exmoxl.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.item.ItemProperties;

import net.mcreator.exmoxl.procedures.IronpShuXingZhiTiGongQiProcedure;
import net.mcreator.exmoxl.item.XumiRingItem;
import net.mcreator.exmoxl.item.WrenchItem;
import net.mcreator.exmoxl.item.WashstoneItem;
import net.mcreator.exmoxl.item.WandaoItem;
import net.mcreator.exmoxl.item.ThreeflameItem;
import net.mcreator.exmoxl.item.StarFlamePowderItem;
import net.mcreator.exmoxl.item.SmeltingStoneItem;
import net.mcreator.exmoxl.item.MiscellaneousDustItem;
import net.mcreator.exmoxl.item.IronpItem;
import net.mcreator.exmoxl.item.DnzItem;
import net.mcreator.exmoxl.item.CustomitemItem;
import net.mcreator.exmoxl.item.AskskyItem;
import net.mcreator.exmoxl.item.Asksky2Item;
import net.mcreator.exmoxl.ExmoxlMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ExmoxlModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, ExmoxlMod.MODID);
	public static final RegistryObject<Item> WANDAO = REGISTRY.register("wandao", () -> new WandaoItem());
	public static final RegistryObject<Item> ASKSKY = REGISTRY.register("asksky", () -> new AskskyItem());
	public static final RegistryObject<Item> ACTIVATOR = block(ExmoxlModBlocks.ACTIVATOR);
	public static final RegistryObject<Item> STAR_FLAME_POWDER = REGISTRY.register("star_flame_powder", () -> new StarFlamePowderItem());
	public static final RegistryObject<Item> MISCELLANEOUS_DUST = REGISTRY.register("miscellaneous_dust", () -> new MiscellaneousDustItem());
	public static final RegistryObject<Item> THREEFLAME = REGISTRY.register("threeflame", () -> new ThreeflameItem());
	public static final RegistryObject<Item> SMELTING_STONE = REGISTRY.register("smelting_stone", () -> new SmeltingStoneItem());
	public static final RegistryObject<Item> WASHSTONE = REGISTRY.register("washstone", () -> new WashstoneItem());
	public static final RegistryObject<Item> RECASTING_TABLE = block(ExmoxlModBlocks.RECASTING_TABLE);
	public static final RegistryObject<Item> XUMI_RING = REGISTRY.register("xumi_ring", () -> new XumiRingItem());
	public static final RegistryObject<Item> IRONP = REGISTRY.register("ironp", () -> new IronpItem());
	public static final RegistryObject<Item> BLACK_FURNACE = block(ExmoxlModBlocks.BLACK_FURNACE);
	public static final RegistryObject<Item> WRENCH = REGISTRY.register("wrench", () -> new WrenchItem());
	public static final RegistryObject<Item> BLACKFURNACEMAIN = block(ExmoxlModBlocks.BLACKFURNACEMAIN);
	public static final RegistryObject<Item> BLACKFURNACESTEP = block(ExmoxlModBlocks.BLACKFURNACESTEP);
	public static final RegistryObject<Item> CUSTOMITEM = REGISTRY.register("customitem", () -> new CustomitemItem());
	public static final RegistryObject<Item> WEAWORKBEACH = block(ExmoxlModBlocks.WEAWORKBEACH);
	public static final RegistryObject<Item> DNZ = REGISTRY.register("dnz", () -> new DnzItem());
	public static final RegistryObject<Item> ASKSKY_2 = REGISTRY.register("asksky_2", () -> new Asksky2Item());
	public static final RegistryObject<Item> STONE_SIGN = block(ExmoxlModBlocks.STONE_SIGN);

	private static RegistryObject<Item> block(RegistryObject<Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}

	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			ItemProperties.register(IRONP.get(), new ResourceLocation("exmoxl:ironp_dark"), (itemStackToRender, clientWorld, entity, itemEntityId) -> (float) IronpShuXingZhiTiGongQiProcedure.execute(itemStackToRender));
		});
	}
}
