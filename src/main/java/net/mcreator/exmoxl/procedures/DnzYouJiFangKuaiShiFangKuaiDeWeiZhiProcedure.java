package net.mcreator.exmoxl.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;

import net.mcreator.exmoxl.ExmoxlMod;

import java.util.List;
import java.util.Comparator;
import net.minecraft.world.effect.MobEffect;

public class DnzYouJiFangKuaiShiFangKuaiDeWeiZhiProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (itemstack.getOrCreateTag().getDouble("dnzz") == 10) {
			itemstack.getOrCreateTag().putDouble("dnzz", 0);
			entity.setDeltaMovement(new Vec3(0, 1, 0));
			ExmoxlMod.queueServerWork(10, () -> {
				for (int index0 = 0; index0 < 4; index0++) {
					if (world instanceof Level _level && !_level.isClientSide())
						_level.explode(null, x, y, z, 2, Level.ExplosionInteraction.NONE);
					{
						final Vec3 _center = new Vec3(x, y, z);
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
						for (Entity entityiterator : _entfound) {
							if (!(entity == entityiterator)) {
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()){
			_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 150, 3));
		}
		

								if ((entityiterator instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > 0) {
									entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("exmoxl:wood"))), entity),
											(float) (2.5 * ((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE).getValue()));
								LivingEntity entityl = (LivingEntity)entity;
								entityl.heal((float)(entityl.getMaxHealth()*0.1));
								
								}
							}
						}
					}
				}
			});
		}
	}
}
