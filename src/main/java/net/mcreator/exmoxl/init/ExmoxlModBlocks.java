
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.exmoxl.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import net.mcreator.exmoxl.block.WeaworkbeachBlock;
import net.mcreator.exmoxl.block.RecastingTableBlock;
import net.mcreator.exmoxl.block.BlackfurnacestepBlock;
import net.mcreator.exmoxl.block.BlackfurnacemainBlock;
import net.mcreator.exmoxl.block.BlackFurnaceBlock;
import net.mcreator.exmoxl.block.ActivatorBlock;
import net.mcreator.exmoxl.ExmoxlMod;

public class ExmoxlModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, ExmoxlMod.MODID);
	public static final RegistryObject<Block> ACTIVATOR = REGISTRY.register("activator", () -> new ActivatorBlock());
	public static final RegistryObject<Block> RECASTING_TABLE = REGISTRY.register("recasting_table", () -> new RecastingTableBlock());
	public static final RegistryObject<Block> BLACK_FURNACE = REGISTRY.register("black_furnace", () -> new BlackFurnaceBlock());
	public static final RegistryObject<Block> BLACKFURNACEMAIN = REGISTRY.register("blackfurnacemain", () -> new BlackfurnacemainBlock());
	public static final RegistryObject<Block> BLACKFURNACESTEP = REGISTRY.register("blackfurnacestep", () -> new BlackfurnacestepBlock());
	public static final RegistryObject<Block> WEAWORKBEACH = REGISTRY.register("weaworkbeach", () -> new WeaworkbeachBlock());
}
