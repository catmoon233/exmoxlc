
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.exmoxl.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;

import net.mcreator.exmoxl.block.entity.WeaworkbeachBlockEntity;
import net.mcreator.exmoxl.block.entity.StoneSignBlockEntity;
import net.mcreator.exmoxl.block.entity.RecastingTableBlockEntity;
import net.mcreator.exmoxl.block.entity.ActivatorBlockEntity;
import net.mcreator.exmoxl.ExmoxlMod;

public class ExmoxlModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, ExmoxlMod.MODID);
	public static final RegistryObject<BlockEntityType<?>> ACTIVATOR = register("activator", ExmoxlModBlocks.ACTIVATOR, ActivatorBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> RECASTING_TABLE = register("recasting_table", ExmoxlModBlocks.RECASTING_TABLE, RecastingTableBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> WEAWORKBEACH = register("weaworkbeach", ExmoxlModBlocks.WEAWORKBEACH, WeaworkbeachBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> STONE_SIGN = register("stone_sign", ExmoxlModBlocks.STONE_SIGN, StoneSignBlockEntity::new);

	private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}
