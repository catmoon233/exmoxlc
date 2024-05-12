/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.exmoxl.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLConstructModEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.EntityAttributeModificationEvent;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

import net.mcreator.exmoxl.ExmoxlMod;

import java.util.List;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ExmoxlModAttributes {
	public static final DeferredRegister<Attribute> ATTRIBUTES = DeferredRegister.create(ForgeRegistries.ATTRIBUTES, ExmoxlMod.MODID);
	public static final RegistryObject<Attribute> CRIT = ATTRIBUTES.register("crit", () -> (new RangedAttribute("attribute." + ExmoxlMod.MODID + ".crit", 0, 0, 100000000)).setSyncable(true));
	public static final RegistryObject<Attribute> CRITDAMAGE = ATTRIBUTES.register("critdamage", () -> (new RangedAttribute("attribute." + ExmoxlMod.MODID + ".critdamage", 0, 0, 100000000)).setSyncable(true));
	public static final RegistryObject<Attribute> PIERCE = ATTRIBUTES.register("pierce", () -> (new RangedAttribute("attribute." + ExmoxlMod.MODID + ".pierce", 0, 0, 100000000)).setSyncable(true));
	public static final RegistryObject<Attribute> AXEAPTITUDE = ATTRIBUTES.register("axeaptitude", () -> (new RangedAttribute("attribute." + ExmoxlMod.MODID + ".axeaptitude", 0, 0, 100000000)).setSyncable(true));
	public static final RegistryObject<Attribute> SWORDAPTITUDE = ATTRIBUTES.register("swordaptitude", () -> (new RangedAttribute("attribute." + ExmoxlMod.MODID + ".swordaptitude", 0, 0, 100000000)).setSyncable(true));
	public static final RegistryObject<Attribute> STICKAPTITUDE = ATTRIBUTES.register("stickaptitude", () -> (new RangedAttribute("attribute." + ExmoxlMod.MODID + ".stickaptitude", 0, 0, 100000000)).setSyncable(true));
	public static final RegistryObject<Attribute> KNIFEAPTITUDE = ATTRIBUTES.register("knifeaptitude", () -> (new RangedAttribute("attribute." + ExmoxlMod.MODID + ".knifeaptitude", 0, 0, 100000000)).setSyncable(true));
	public static final RegistryObject<Attribute> LIGHTWEAPONSAPTITUDE = ATTRIBUTES.register("lightweaponsaptitude", () -> (new RangedAttribute("attribute." + ExmoxlMod.MODID + ".lightweaponsaptitude", 0, 0, 100000000)).setSyncable(true));
	public static final RegistryObject<Attribute> ATOMICTANKAPTITUDE = ATTRIBUTES.register("atomictankaptitude", () -> (new RangedAttribute("attribute." + ExmoxlMod.MODID + ".atomictankaptitude", 0, 0, 100000000)).setSyncable(true));
	public static final RegistryObject<Attribute> LONGWEAPONAPTITUDE = ATTRIBUTES.register("longweaponaptitude", () -> (new RangedAttribute("attribute." + ExmoxlMod.MODID + ".longweaponaptitude", 0, 0, 100000000)).setSyncable(true));
	public static final RegistryObject<Attribute> SHORTWEAPONAPTITUDE = ATTRIBUTES.register("shortweaponaptitude", () -> (new RangedAttribute("attribute." + ExmoxlMod.MODID + ".shortweaponaptitude", 0, 0, 100000000)).setSyncable(true));
	public static final RegistryObject<Attribute> REMOTEWEAPONSAPTITUDE = ATTRIBUTES.register("remoteweaponsaptitude", () -> (new RangedAttribute("attribute." + ExmoxlMod.MODID + ".remoteweaponsaptitude", 0, 0, 100000000)).setSyncable(true));
	public static final RegistryObject<Attribute> EVASION = ATTRIBUTES.register("evasion", () -> (new RangedAttribute("attribute." + ExmoxlMod.MODID + ".evasion", 0, 0, 100000000)).setSyncable(true));
	public static final RegistryObject<Attribute> MIANSHAN = ATTRIBUTES.register("mianshan", () -> (new RangedAttribute("attribute." + ExmoxlMod.MODID + ".mianshan", 0, 0, 100000000)).setSyncable(true));
	public static final RegistryObject<Attribute> REBOUND = ATTRIBUTES.register("rebound", () -> (new RangedAttribute("attribute." + ExmoxlMod.MODID + ".rebound", 0, 0, 100000000)).setSyncable(true));
	public static final RegistryObject<Attribute> REBOUNDLV = ATTRIBUTES.register("reboundlv", () -> (new RangedAttribute("attribute." + ExmoxlMod.MODID + ".reboundlv", 0, 0, 100000000)).setSyncable(true));
	public static final RegistryObject<Attribute> HITRATE = ATTRIBUTES.register("hitrate", () -> (new RangedAttribute("attribute." + ExmoxlMod.MODID + ".hitrate", 0, 0, 100000000)).setSyncable(true));
	public static final RegistryObject<Attribute> INTELLIGENCE = ATTRIBUTES.register("intelligence", () -> (new RangedAttribute("attribute." + ExmoxlMod.MODID + ".intelligence", 0, 0, 100000000)).setSyncable(true));
	public static final RegistryObject<Attribute> STRENGTH = ATTRIBUTES.register("strength", () -> (new RangedAttribute("attribute." + ExmoxlMod.MODID + ".strength", 0, 0, 100000000)).setSyncable(true));
	public static final RegistryObject<Attribute> AGILE = ATTRIBUTES.register("agile", () -> (new RangedAttribute("attribute." + ExmoxlMod.MODID + ".agile", 0, 0, 100000000)).setSyncable(true));
	public static final RegistryObject<Attribute> SPIRIT = ATTRIBUTES.register("spirit", () -> (new RangedAttribute("attribute." + ExmoxlMod.MODID + ".spirit", 0, 0, 100000000)).setSyncable(true));
	public static final RegistryObject<Attribute> SPRITATTACK = ATTRIBUTES.register("sprit_attack", () -> (new RangedAttribute("attribute." + ExmoxlMod.MODID + ".sprit_attack", 0, 0, 100000000)).setSyncable(true));
	public static final RegistryObject<Attribute> WOODDAMAGE = ATTRIBUTES.register("wood_damage", () -> (new RangedAttribute("attribute." + ExmoxlMod.MODID + ".wood_damage", 0, 0, 100000000)).setSyncable(true));
	public static final RegistryObject<Attribute> WATERDAMAGE = ATTRIBUTES.register("water_damage", () -> (new RangedAttribute("attribute." + ExmoxlMod.MODID + ".water_damage", 0, 0, 100000000)).setSyncable(true));
	public static final RegistryObject<Attribute> FIREADAMAGE = ATTRIBUTES.register("fire_a_damage", () -> (new RangedAttribute("attribute." + ExmoxlMod.MODID + ".fire_a_damage", 0, 0, 100000000)).setSyncable(true));
	public static final RegistryObject<Attribute> WOODDEFENSE = ATTRIBUTES.register("wood_defense", () -> (new RangedAttribute("attribute." + ExmoxlMod.MODID + ".wood_defense", 0, 0, 100000000)).setSyncable(true));
	public static final RegistryObject<Attribute> WATERDEFENSE = ATTRIBUTES.register("water_defense", () -> (new RangedAttribute("attribute." + ExmoxlMod.MODID + ".water_defense", 0, 0, 100000000)).setSyncable(true));
	public static final RegistryObject<Attribute> FIREDEFENSE = ATTRIBUTES.register("fire_defense", () -> (new RangedAttribute("attribute." + ExmoxlMod.MODID + ".fire_defense", 0, 0, 100000000)).setSyncable(true));
	public static final RegistryObject<Attribute> WOODPERCENTDAMAGE = ATTRIBUTES.register("wood_percent_damage", () -> (new RangedAttribute("attribute." + ExmoxlMod.MODID + ".wood_percent_damage", 0, 0, 100000000)).setSyncable(true));
	public static final RegistryObject<Attribute> FIREPERCENTDAMAGE = ATTRIBUTES.register("fire_percent_damage", () -> (new RangedAttribute("attribute." + ExmoxlMod.MODID + ".fire_percent_damage", 0, 0, 100000000)).setSyncable(true));
	public static final RegistryObject<Attribute> WATERPERCENTDAMAGE = ATTRIBUTES.register("water_percent_damage", () -> (new RangedAttribute("attribute." + ExmoxlMod.MODID + ".water_percent_damage", 0, 0, 100000000)).setSyncable(true));
	public static final RegistryObject<Attribute> CHARM = ATTRIBUTES.register("charm", () -> (new RangedAttribute("attribute." + ExmoxlMod.MODID + ".charm", 0, 0, 100000000)).setSyncable(true));

	@SubscribeEvent
	public static void register(FMLConstructModEvent event) {
		event.enqueueWork(() -> {
			ATTRIBUTES.register(FMLJavaModLoadingContext.get().getModEventBus());
		});
	}

	@SubscribeEvent
	public static void addAttributes(EntityAttributeModificationEvent event) {
		List<EntityType<? extends LivingEntity>> entityTypes = event.getTypes();
		entityTypes.forEach((e) -> {
			Class<? extends Entity> baseClass = e.getBaseClass();
			if (baseClass.isAssignableFrom(Mob.class)) {
				event.add(e, CRIT.get());
			}
		});
		entityTypes.forEach((e) -> {
			Class<? extends Entity> baseClass = e.getBaseClass();
			if (baseClass.isAssignableFrom(Mob.class)) {
				event.add(e, CRITDAMAGE.get());
			}
		});
		entityTypes.forEach((e) -> {
			Class<? extends Entity> baseClass = e.getBaseClass();
			if (baseClass.isAssignableFrom(Mob.class)) {
				event.add(e, PIERCE.get());
			}
		});
		event.add(EntityType.ZOMBIE, AXEAPTITUDE.get());
		event.add(EntityType.PLAYER, AXEAPTITUDE.get());
		event.add(EntityType.ZOMBIE, SWORDAPTITUDE.get());
		event.add(EntityType.PLAYER, SWORDAPTITUDE.get());
		event.add(EntityType.ZOMBIE, STICKAPTITUDE.get());
		event.add(EntityType.PLAYER, STICKAPTITUDE.get());
		event.add(EntityType.ZOMBIE, KNIFEAPTITUDE.get());
		event.add(EntityType.PLAYER, KNIFEAPTITUDE.get());
		event.add(EntityType.ZOMBIE, LIGHTWEAPONSAPTITUDE.get());
		event.add(EntityType.PLAYER, LIGHTWEAPONSAPTITUDE.get());
		event.add(EntityType.ZOMBIE, ATOMICTANKAPTITUDE.get());
		event.add(EntityType.PLAYER, ATOMICTANKAPTITUDE.get());
		event.add(EntityType.ZOMBIE, LONGWEAPONAPTITUDE.get());
		event.add(EntityType.PLAYER, LONGWEAPONAPTITUDE.get());
		event.add(EntityType.ZOMBIE, SHORTWEAPONAPTITUDE.get());
		event.add(EntityType.PLAYER, SHORTWEAPONAPTITUDE.get());
		event.add(EntityType.ZOMBIE, REMOTEWEAPONSAPTITUDE.get());
		event.add(EntityType.PLAYER, REMOTEWEAPONSAPTITUDE.get());
		entityTypes.forEach((e) -> {
			Class<? extends Entity> baseClass = e.getBaseClass();
			if (baseClass.isAssignableFrom(Animal.class) || baseClass.isAssignableFrom(Mob.class)) {
				event.add(e, EVASION.get());
			}
		});
		entityTypes.forEach((e) -> {
			Class<? extends Entity> baseClass = e.getBaseClass();
			if (baseClass.isAssignableFrom(Animal.class) || baseClass.isAssignableFrom(Mob.class)) {
				event.add(e, MIANSHAN.get());
			}
		});
		entityTypes.forEach((e) -> {
			Class<? extends Entity> baseClass = e.getBaseClass();
			if (baseClass.isAssignableFrom(Animal.class) || baseClass.isAssignableFrom(Mob.class)) {
				event.add(e, REBOUND.get());
			}
		});
		entityTypes.forEach((e) -> {
			Class<? extends Entity> baseClass = e.getBaseClass();
			if (baseClass.isAssignableFrom(Animal.class) || baseClass.isAssignableFrom(Mob.class)) {
				event.add(e, REBOUNDLV.get());
			}
		});
		entityTypes.forEach((e) -> {
			Class<? extends Entity> baseClass = e.getBaseClass();
			if (baseClass.isAssignableFrom(Animal.class) || baseClass.isAssignableFrom(Mob.class)) {
				event.add(e, HITRATE.get());
			}
		});
		event.add(EntityType.PLAYER, INTELLIGENCE.get());
		event.add(EntityType.PLAYER, STRENGTH.get());
		event.add(EntityType.PLAYER, AGILE.get());
		event.add(EntityType.PLAYER, SPIRIT.get());
		event.add(EntityType.PLAYER, SPRITATTACK.get());
		entityTypes.forEach((e) -> {
			Class<? extends Entity> baseClass = e.getBaseClass();
			if (baseClass.isAssignableFrom(Mob.class)) {
				event.add(e, WOODDAMAGE.get());
			}
		});
		entityTypes.forEach((e) -> {
			Class<? extends Entity> baseClass = e.getBaseClass();
			if (baseClass.isAssignableFrom(Mob.class)) {
				event.add(e, WATERDAMAGE.get());
			}
		});
		event.add(EntityType.PLAYER, FIREADAMAGE.get());
		entityTypes.forEach((e) -> {
			Class<? extends Entity> baseClass = e.getBaseClass();
			if (baseClass.isAssignableFrom(Mob.class)) {
				event.add(e, WOODDEFENSE.get());
			}
		});
		entityTypes.forEach((e) -> {
			Class<? extends Entity> baseClass = e.getBaseClass();
			if (baseClass.isAssignableFrom(Mob.class)) {
				event.add(e, WATERDEFENSE.get());
			}
		});
		entityTypes.forEach((e) -> {
			Class<? extends Entity> baseClass = e.getBaseClass();
			if (baseClass.isAssignableFrom(Mob.class)) {
				event.add(e, FIREDEFENSE.get());
			}
		});
		entityTypes.forEach((e) -> {
			Class<? extends Entity> baseClass = e.getBaseClass();
			if (baseClass.isAssignableFrom(Mob.class)) {
				event.add(e, WOODPERCENTDAMAGE.get());
			}
		});
		entityTypes.forEach((e) -> {
			Class<? extends Entity> baseClass = e.getBaseClass();
			if (baseClass.isAssignableFrom(Mob.class)) {
				event.add(e, FIREPERCENTDAMAGE.get());
			}
		});
		entityTypes.forEach((e) -> {
			Class<? extends Entity> baseClass = e.getBaseClass();
			if (baseClass.isAssignableFrom(Mob.class)) {
				event.add(e, WATERPERCENTDAMAGE.get());
			}
		});
		event.add(EntityType.PLAYER, CHARM.get());
	}

	@Mod.EventBusSubscriber
	private class Utils {
		@SubscribeEvent
		public static void persistAttributes(PlayerEvent.Clone event) {
			Player oldP = event.getOriginal();
			Player newP = (Player) event.getEntity();
			newP.getAttribute(CRIT.get()).setBaseValue(oldP.getAttribute(CRIT.get()).getBaseValue());
			newP.getAttribute(CRITDAMAGE.get()).setBaseValue(oldP.getAttribute(CRITDAMAGE.get()).getBaseValue());
			newP.getAttribute(PIERCE.get()).setBaseValue(oldP.getAttribute(PIERCE.get()).getBaseValue());
			newP.getAttribute(AXEAPTITUDE.get()).setBaseValue(oldP.getAttribute(AXEAPTITUDE.get()).getBaseValue());
			newP.getAttribute(SWORDAPTITUDE.get()).setBaseValue(oldP.getAttribute(SWORDAPTITUDE.get()).getBaseValue());
			newP.getAttribute(STICKAPTITUDE.get()).setBaseValue(oldP.getAttribute(STICKAPTITUDE.get()).getBaseValue());
			newP.getAttribute(KNIFEAPTITUDE.get()).setBaseValue(oldP.getAttribute(KNIFEAPTITUDE.get()).getBaseValue());
			newP.getAttribute(LIGHTWEAPONSAPTITUDE.get()).setBaseValue(oldP.getAttribute(LIGHTWEAPONSAPTITUDE.get()).getBaseValue());
			newP.getAttribute(ATOMICTANKAPTITUDE.get()).setBaseValue(oldP.getAttribute(ATOMICTANKAPTITUDE.get()).getBaseValue());
			newP.getAttribute(LONGWEAPONAPTITUDE.get()).setBaseValue(oldP.getAttribute(LONGWEAPONAPTITUDE.get()).getBaseValue());
			newP.getAttribute(SHORTWEAPONAPTITUDE.get()).setBaseValue(oldP.getAttribute(SHORTWEAPONAPTITUDE.get()).getBaseValue());
			newP.getAttribute(REMOTEWEAPONSAPTITUDE.get()).setBaseValue(oldP.getAttribute(REMOTEWEAPONSAPTITUDE.get()).getBaseValue());
			newP.getAttribute(EVASION.get()).setBaseValue(oldP.getAttribute(EVASION.get()).getBaseValue());
			newP.getAttribute(MIANSHAN.get()).setBaseValue(oldP.getAttribute(MIANSHAN.get()).getBaseValue());
			newP.getAttribute(REBOUND.get()).setBaseValue(oldP.getAttribute(REBOUND.get()).getBaseValue());
			newP.getAttribute(REBOUNDLV.get()).setBaseValue(oldP.getAttribute(REBOUNDLV.get()).getBaseValue());
			newP.getAttribute(HITRATE.get()).setBaseValue(oldP.getAttribute(HITRATE.get()).getBaseValue());
			newP.getAttribute(INTELLIGENCE.get()).setBaseValue(oldP.getAttribute(INTELLIGENCE.get()).getBaseValue());
			newP.getAttribute(STRENGTH.get()).setBaseValue(oldP.getAttribute(STRENGTH.get()).getBaseValue());
			newP.getAttribute(AGILE.get()).setBaseValue(oldP.getAttribute(AGILE.get()).getBaseValue());
			newP.getAttribute(SPIRIT.get()).setBaseValue(oldP.getAttribute(SPIRIT.get()).getBaseValue());
			newP.getAttribute(SPRITATTACK.get()).setBaseValue(oldP.getAttribute(SPRITATTACK.get()).getBaseValue());
			newP.getAttribute(WOODDAMAGE.get()).setBaseValue(oldP.getAttribute(WOODDAMAGE.get()).getBaseValue());
			newP.getAttribute(WATERDAMAGE.get()).setBaseValue(oldP.getAttribute(WATERDAMAGE.get()).getBaseValue());
			newP.getAttribute(FIREADAMAGE.get()).setBaseValue(oldP.getAttribute(FIREADAMAGE.get()).getBaseValue());
			newP.getAttribute(WOODDEFENSE.get()).setBaseValue(oldP.getAttribute(WOODDEFENSE.get()).getBaseValue());
			newP.getAttribute(WATERDEFENSE.get()).setBaseValue(oldP.getAttribute(WATERDEFENSE.get()).getBaseValue());
			newP.getAttribute(FIREDEFENSE.get()).setBaseValue(oldP.getAttribute(FIREDEFENSE.get()).getBaseValue());
			newP.getAttribute(WOODPERCENTDAMAGE.get()).setBaseValue(oldP.getAttribute(WOODPERCENTDAMAGE.get()).getBaseValue());
			newP.getAttribute(FIREPERCENTDAMAGE.get()).setBaseValue(oldP.getAttribute(FIREPERCENTDAMAGE.get()).getBaseValue());
			newP.getAttribute(WATERPERCENTDAMAGE.get()).setBaseValue(oldP.getAttribute(WATERPERCENTDAMAGE.get()).getBaseValue());
			newP.getAttribute(CHARM.get()).setBaseValue(oldP.getAttribute(CHARM.get()).getBaseValue());
		}
	}
}
