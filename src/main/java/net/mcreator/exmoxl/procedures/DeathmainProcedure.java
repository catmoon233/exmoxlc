package net.mcreator.exmoxl.procedures;

import net.mcreator.exmoxl.ExmoxlMod;
import net.mcreator.exmoxl.Talent;
import net.mcreator.exmoxl.TalentList;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.exmoxl.network.ExmoxlModVariables;
import net.mcreator.exmoxl.init.ExmoxlModItems;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Map;

@Mod.EventBusSubscriber
public class DeathmainProcedure {
	@SubscribeEvent
	public static void onEntityDeath(LivingDeathEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getSource(), event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, DamageSource damagesource, Entity entity, Entity sourceentity) {
		execute(null, world, x, y, z, damagesource, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, DamageSource damagesource, Entity entity, Entity sourceentity) {
		if (damagesource == null || entity == null || sourceentity == null)
			return;
		Entity cloneentitye = null;
		String uihno = "";
		double levelc = 0;
		double jysl = 0;
		double entitylevel = 0;
		double xljy = 0;
		double xljy2 = 0;
		if (!damagesource.is(DamageTypes.GENERIC_KILL)) {
			if (entity.getPersistentData().getDouble("fenlie") > 0 || entity.getPersistentData().getDouble("Rebirth") > 0) {
				if (entity instanceof LivingEntity _entity)
					_entity.setHealth(entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
				if (event != null && event.isCancelable()) {
					event.setCanceled(true);
				}
			} else {
				if (Math.random() < 0.2) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(ExmoxlModItems.MISCELLANEOUS_DUST.get()));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
				}
				if (sourceentity instanceof Player player) {
					xljy = entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1;
					while (xljy > 100) {
						xljy = xljy * 0.01;
						xljy2 = xljy2 + 1;
					}
					entitylevel = Isl2holevelProcedure.getlv(entity);
					if ((sourceentity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ExmoxlModVariables.PlayerVariables())).playerllvl > entitylevel * 0.1) {
						levelc = Math.pow(0.9, Math.round((sourceentity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ExmoxlModVariables.PlayerVariables())).playerllvl - entitylevel * 0.1));
					} else {
						levelc = Math.pow(1.1, Math.round(entitylevel * 0.1 - (sourceentity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ExmoxlModVariables.PlayerVariables())).playerllvl));
					}
					jysl = Math.round(Math.round(entitylevel * 3 * Mth.nextInt(RandomSource.create(), 5, 10) * 0.1) * levelc * Math.pow(1.5, xljy2));
					{
						double _setval = (sourceentity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ExmoxlModVariables.PlayerVariables())).playerxp + jysl;
						sourceentity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.playerxp = _setval;
							capability.syncPlayerVariables(sourceentity);
						});
					}
					List<TalentList.Talent> talents = TalentList.TalentCList;
					Map<String, Integer> Sectf;
					Sectf = (player.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ExmoxlModVariables.PlayerVariables())).TalentSz;
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal(("\u4F60\u83B7\u5F97\u4E86" + jysl + "\u70B9\u7ECF\u9A8C")), false);
					while ((sourceentity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ExmoxlModVariables.PlayerVariables())).playerxp > (sourceentity
							.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ExmoxlModVariables.PlayerVariables())).playerupxp) {
						if(
							!((LevelAccessor)player.level()).isClientSide()
						) {
							//ExmoxlMod.LOGGER.debug("Onup2");

						Sectf.forEach((k, v) -> {
							if(v>0) {
								//ExmoxlMod.LOGGER.debug("Onup");
								for(TalentList.Talent talent : talents){
									if(talent.displayname.equals(k)){
										if(TalentList.onupr(talent, player, v)!=null) {
											TalentList.onupr(talent, player, v).run();
										}
									//	ExmoxlMod.LOGGER.debug("use");

									}

								}
							}

						});
						}
						{
							double _setval = (sourceentity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ExmoxlModVariables.PlayerVariables())).playerxp
									- (sourceentity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ExmoxlModVariables.PlayerVariables())).playerupxp;
							sourceentity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.playerxp = _setval;
								capability.syncPlayerVariables(sourceentity);
							});
						}
						{
							double _setval = (sourceentity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ExmoxlModVariables.PlayerVariables())).playerllvl + 1;
							sourceentity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.playerllvl = _setval;
								capability.syncPlayerVariables(sourceentity);
							});
						}
						{
							double _setval = (sourceentity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ExmoxlModVariables.PlayerVariables())).tfd + 2;
							sourceentity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.tfd = _setval;
								capability.syncPlayerVariables(sourceentity);
							});
						}
						{
							double _setval = 150 * Math.pow(1.2, (sourceentity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ExmoxlModVariables.PlayerVariables())).playerllvl - 1);
							sourceentity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.playerupxp = _setval;
								capability.syncPlayerVariables(sourceentity);
							});
						}
						if (sourceentity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(
									Component.literal(
											("\u4F60\u5347\u7EA7\u4E86!\u5F53\u524D" + (sourceentity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ExmoxlModVariables.PlayerVariables())).playerllvl + "\u7EA7.")),
									false);
					}
				}
			}
			if (entity.getPersistentData().getDouble("fenlie") > 0) {
				if (entity instanceof LivingEntity _entity)
					_entity.setHealth(entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
				entity.getPersistentData().putDouble("fenlie", (entity.getPersistentData().getDouble("fenlie") - 1));
				if (entity instanceof LivingEntity && ((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH) != null) {
					((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH)
							.setBaseValue((((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).getValue() * 0.5));
				}
				if (entity instanceof LivingEntity && ((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR_TOUGHNESS) != null) {
					((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR_TOUGHNESS)
							.setBaseValue((((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR_TOUGHNESS).getValue() * 0.5));
				}
				if (entity instanceof LivingEntity && ((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR) != null) {
					((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR).setBaseValue((((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR).getValue() * 0.5));
				}
				if (entity instanceof LivingEntity && ((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE) != null) {
					((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE)
							.setBaseValue((((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE).getValue() * 0.5));
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.totem.use")), SoundSource.NEUTRAL, 1, 1);
					}
				}
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.END_ROD, x, y, z, 30, 3, 3, 3, 0.7);
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.GLOWING, 9999999, 1, false, false));
				if (entity instanceof LivingEntity _entity)
					_entity.setHealth(entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
				cloneentitye = entity;
				EntityType<?> entityType = entity.getType();
				if (world instanceof ServerLevel _serverLevel) {
					Entity entitytospawn = entityType.spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
					if (entitytospawn != null) {
						entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
					}
				}
			}
			if (entity.getPersistentData().getDouble("Rebirth") > 0 && !(entity.getPersistentData().getDouble("fenlie") > 0)) {
				if (entity instanceof LivingEntity _entity)
					_entity.setHealth(entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.END_ROD, x, y, z, 30, 3, 3, 3, 0.7);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.totem.use")), SoundSource.NEUTRAL, 1, 1);
					}
				}
				entity.getPersistentData().putDouble("Rebirth", (entity.getPersistentData().getDouble("Rebirth") - 1));
			}
		}
	}
}
