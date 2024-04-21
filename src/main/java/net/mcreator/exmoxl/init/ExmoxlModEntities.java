
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.exmoxl.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

import net.mcreator.exmoxl.entity.MagicaEntity;
import net.mcreator.exmoxl.entity.FazhenentityEntity;
import net.mcreator.exmoxl.entity.Asksky2flysworldEntity;
import net.mcreator.exmoxl.entity.AsEntity;
import net.mcreator.exmoxl.ExmoxlMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ExmoxlModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, ExmoxlMod.MODID);
	public static final RegistryObject<EntityType<AsEntity>> AS = register("as",
			EntityType.Builder.<AsEntity>of(AsEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(AsEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<MagicaEntity>> MAGICA = register("projectile_magica",
			EntityType.Builder.<MagicaEntity>of(MagicaEntity::new, MobCategory.MISC).setCustomClientFactory(MagicaEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<FazhenentityEntity>> FAZHENENTITY = register("fazhenentity", EntityType.Builder.<FazhenentityEntity>of(FazhenentityEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(FazhenentityEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<Asksky2flysworldEntity>> ASKSKY_2FLYSWORLD = register("projectile_asksky_2flysworld", EntityType.Builder.<Asksky2flysworldEntity>of(Asksky2flysworldEntity::new, MobCategory.MISC)
			.setCustomClientFactory(Asksky2flysworldEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));

	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			AsEntity.init();
			FazhenentityEntity.init();
		});
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(AS.get(), AsEntity.createAttributes().build());
		event.put(FAZHENENTITY.get(), FazhenentityEntity.createAttributes().build());
	}
}
