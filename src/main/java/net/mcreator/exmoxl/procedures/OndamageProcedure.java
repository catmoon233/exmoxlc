package net.mcreator.exmoxl.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

import net.mcreator.exmoxl.init.ExmoxlModMobEffects;
import net.mcreator.exmoxl.ExmoxlMod;

import javax.annotation.Nullable;



@Mod.EventBusSubscriber
public class OndamageProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingHurtEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getSource(), event.getEntity(), event.getSource().getEntity(), event.getAmount());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, DamageSource damagesource, Entity entity, Entity sourceentity, double amount) {
		execute(null, world, x, y, z, damagesource, entity, sourceentity, amount);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, DamageSource damagesource, Entity entity, Entity sourceentity, double amount) {
		if (damagesource == null || entity == null || sourceentity == null)
			return;
		ItemStack mainhand = ItemStack.EMPTY;
		double attackdamage = 0;
		if (!damagesource.is(DamageTypes.GENERIC_KILL)) {
			mainhand = (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
			attackdamage = mainhand.getAttributeModifiers(EquipmentSlot.MAINHAND).get(Attributes.ATTACK_DAMAGE).stream().mapToDouble(attributeModifier -> attributeModifier.getAmount()).sum();
			if (mainhand.getOrCreateTag().getDouble("quality") > 0) {
				if (!(sourceentity instanceof Player _plrCldCheck4 && _plrCldCheck4.getCooldowns().isOnCooldown((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()))) {
					if (mainhand.getOrCreateTag().getDouble("fbjj") > 0) {
						if (!(sourceentity instanceof Player _plrCldCheck7 && _plrCldCheck7.getCooldowns().isOnCooldown((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()))) {
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.creeper.hurt")), SoundSource.NEUTRAL, 1, 2);
								} else {
									_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.creeper.hurt")), SoundSource.NEUTRAL, 1, 2, false);
								}
							}
							FbjjProcedure.execute(sourceentity, mainhand, x, y, z);
						}
					}
					if (mainhand.getOrCreateTag().getDouble("scdz") > 0) {
						ExmoxlMod.queueServerWork(2, () -> {
							if (sourceentity instanceof Player _player)
								_player.getCooldowns().addCooldown((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem(), 15);
							entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MAGIC)),
									(float) (amount * 0.25 * (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("scdz")));
						});
					}
				}
			}
			if (entity.getPersistentData().getDouble("suppress") > 0) {
				if (Math.random() < 0.3 * entity.getPersistentData().getDouble("suppress")) {
					sourceentity.setDeltaMovement(new Vec3((entity.getLookAngle().x), (entity.getLookAngle().y), (entity.getZ())));
					sourceentity.makeStuckInBlock(Blocks.AIR.defaultBlockState(), new Vec3(0.25, 0.05, 0.25));
					if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 3));
				}
			}
			if (sourceentity.getPersistentData().getDouble("suppress") > 0) {
				if (Math.random() < 0.3 * sourceentity.getPersistentData().getDouble("suppress")) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, (int) (2 * sourceentity.getPersistentData().getDouble("suppress"))));
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(ExmoxlModMobEffects.ZHENYA.get(), (int) (60 * sourceentity.getPersistentData().getDouble("suppress")), 3));
				}
			}
		}
	}
}
