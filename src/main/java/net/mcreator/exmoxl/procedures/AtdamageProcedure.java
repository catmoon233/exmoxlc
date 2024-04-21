package net.mcreator.exmoxl.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;

import net.mcreator.exmoxl.init.ExmoxlModAttributes;

public class AtdamageProcedure {
	public static double execute(DamageSource damagesource, Entity entity, Entity sourceentity, double amount) {
		if (damagesource == null || entity == null || sourceentity == null)
			return 0;
		double redamage = 0;
		if (!damagesource.is(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("exmoxl:wood")))) {
			if (!damagesource.is(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("exmoxl:firedamage")))) {
				if (!damagesource.is(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("exmoxl:waterdamagetype")))) {
					if (((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getString("ysattr")).equals("wood")) {
						if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > 0) {
							if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > 0) {
								double damage = 0;
								double defense = 0;
								double percent = 0;
								if (entity instanceof LivingEntity && ((LivingEntity) sourceentity).getAttribute(ExmoxlModAttributes.WOODDAMAGE.get()) != null) {
									damage = ((LivingEntity) sourceentity).getAttribute(ExmoxlModAttributes.WOODDAMAGE.get()).getValue();
								}
								if (entity instanceof LivingEntity && ((LivingEntity) entity).getAttribute(ExmoxlModAttributes.WOODDEFENSE.get()) != null) {
									defense = ((LivingEntity) sourceentity).getAttribute(ExmoxlModAttributes.WOODDEFENSE.get()).getValue();
								}
								if (entity instanceof LivingEntity && ((LivingEntity) sourceentity).getAttribute(ExmoxlModAttributes.WOODPERCENTDAMAGE.get()) != null) {
									percent = ((LivingEntity) sourceentity).getAttribute(ExmoxlModAttributes.WOODPERCENTDAMAGE.get()).getValue();
								}
								redamage = Math.round((amount + damage) * (1 - defense / (defense + 100)) * (1 + percent * 0.01) * 100) * 0.01;
							}
						}
					}
					if (((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getString("ysattr")).equals("water")) {
						if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > 0) {
							if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > 0) {
								double damage = 0;
								double defense = 0;
								double percent = 0;
								if (entity instanceof LivingEntity && ((LivingEntity) sourceentity).getAttribute(ExmoxlModAttributes.WATERDAMAGE.get()) != null) {
									damage = ((LivingEntity) sourceentity).getAttribute(ExmoxlModAttributes.WATERDAMAGE.get()).getValue();
								}
								if (entity instanceof LivingEntity && ((LivingEntity) entity).getAttribute(ExmoxlModAttributes.WATERDEFENSE.get()) != null) {
									defense = ((LivingEntity) sourceentity).getAttribute(ExmoxlModAttributes.WATERDEFENSE.get()).getValue();
								}
								if (entity instanceof LivingEntity && ((LivingEntity) sourceentity).getAttribute(ExmoxlModAttributes.WATERPERCENTDAMAGE.get()) != null) {
									percent = ((LivingEntity) sourceentity).getAttribute(ExmoxlModAttributes.WATERPERCENTDAMAGE.get()).getValue();
								}
								redamage = Math.round((amount + damage) * (1 - defense / (defense + 100)) * (1 + percent * 0.01) * 100) * 0.01;
							}
						}
					}
					if (((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getString("ysattr")).equals("fire")) {
						if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > 0) {
							if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > 0) {
								double damage = 0;
								double defense = 0;
								double percent = 0;
								if (entity instanceof LivingEntity && ((LivingEntity) sourceentity).getAttribute(ExmoxlModAttributes.FIREADAMAGE.get()) != null) {
									damage = ((LivingEntity) sourceentity).getAttribute(ExmoxlModAttributes.FIREADAMAGE.get()).getValue();
								}
								if (entity instanceof LivingEntity && ((LivingEntity) entity).getAttribute(ExmoxlModAttributes.FIREDEFENSE.get()) != null) {
									defense = ((LivingEntity) sourceentity).getAttribute(ExmoxlModAttributes.FIREDEFENSE.get()).getValue();
								}
								if (entity instanceof LivingEntity && ((LivingEntity) sourceentity).getAttribute(ExmoxlModAttributes.FIREPERCENTDAMAGE.get()) != null) {
									percent = ((LivingEntity) sourceentity).getAttribute(ExmoxlModAttributes.FIREPERCENTDAMAGE.get()).getValue();
								}
								redamage = Math.round((amount + damage) * (1 - defense / (defense + 100)) * (1 + percent * 0.01) * 100) * 0.01;
							}
						}
					}
				}
			}
		}
		return redamage;
	}
}
