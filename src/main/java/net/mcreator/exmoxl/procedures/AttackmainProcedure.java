package net.mcreator.exmoxl.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.exmoxl.network.ExmoxlModVariables;
import net.mcreator.exmoxl.init.ExmoxlModMobEffects;
import net.mcreator.exmoxl.init.ExmoxlModEnchantments;
import net.mcreator.exmoxl.init.ExmoxlModAttributes;

import javax.annotation.Nullable;


import java.util.UUID;

@Mod.EventBusSubscriber
public class AttackmainProcedure {
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
		
		String entityid = "";
		double damage = 0;
		double attackDamage = 0;
		double quality = 0;
		double attackSpeed = 0;
		double pierce = 0;
		double hitratea = 0;
		double defsgl = 0;
		double shdamage = 0;
		boolean pda = false;
		boolean ispiercekill = false;
		boolean iseva = false;
		String yuansu = "null";
		yuansu = ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getString("ysattr"));
		boolean shanbi = false;
		double yssh = AtdamageProcedure.execute(damagesource,entity,sourceentity,amount);
		damage = yssh;
		if (!damagesource.is(DamageTypes.GENERIC_KILL)) {
		if (sourceentity instanceof Player) {
				if (AttackcancleProcedure.execute(sourceentity)) {
					pda = true;
				}
			}

		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > 0) {
				if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > 0) {
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) * 0.1) {
						if (entity.getPersistentData().getDouble("DyingLight") > 0) {
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.totem.use")), SoundSource.NEUTRAL, 1, 1);
								}
							}
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.END_ROD, x, y, z, 30, 3, 3, 3, 0.7);
							if (event != null && event.isCancelable()) {
								event.setCanceled(true);
							}
							((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH)
									.setBaseValue((((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).getValue() * 1.2));
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 9999999,
										(int) Math.round(entity.getPersistentData().getDouble("DyingLight") * ((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).getValue() * 0.1), false, false));
							if (entity instanceof LivingEntity _entity)
								_entity.setHealth(entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
							entity.getPersistentData().putDouble("DyingLight", (entity.getPersistentData().getDouble("DyingLight") - 1));
						}
					}
					if (entity instanceof LivingEntity && ((LivingEntity) sourceentity).getAttribute(ExmoxlModAttributes.HITRATE.get()) != null) {
						hitratea = ((LivingEntity) sourceentity).getAttribute(ExmoxlModAttributes.HITRATE.get()).getValue();
					}
					if (entity instanceof LivingEntity && ((LivingEntity) entity).getAttribute(ExmoxlModAttributes.EVASION.get()) != null) {
						if (((LivingEntity) entity).getAttribute(ExmoxlModAttributes.EVASION.get()).getValue() - hitratea > 0) {
							iseva = true;
						} else {
							if (!(hitratea - ((LivingEntity) entity).getAttribute(ExmoxlModAttributes.EVASION.get()).getValue() == 0)) {
								if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, (int) ((hitratea - ((LivingEntity) entity).getAttribute(ExmoxlModAttributes.EVASION.get()).getValue()) * 2),
											(int) Math.round((hitratea - ((LivingEntity) entity).getAttribute(ExmoxlModAttributes.EVASION.get()).getValue()) * 0.1)));
							}
							iseva = false;
						}
					} else {
						iseva = false;
					}
					if (iseva) {
						if (Math.random() > (((LivingEntity) entity).getAttribute(ExmoxlModAttributes.EVASION.get()).getValue() - hitratea) * 0.01) {
							iseva = false;
						} else {
							shanbi = true;
							if (event != null && event.isCancelable()) {
								event.setCanceled(true);
							}
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.LARGE_SMOKE, x, (y + 1), z, 20, 1, 1, 1, 0.1);
							if (entity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal(("\u4F60\u8EB2\u907F\u4E86\u4E00\u6B21" + sourceentity.getDisplayName().getString() + "\u7684\u653B\u51FB")), true);
							if (sourceentity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal((entity.getDisplayName().getString() + "\u8EB2\u907F\u4E86\u4E00\u6B21\u4F60\u7684\u653B\u51FB")), true);
						}
					}
					if ((!(sourceentity instanceof Player) || pda) && !shanbi) {
						entityid = EntityType.getKey(entity.getType()).toString();;
						if (sourceentity instanceof LivingEntity) {
							LivingEntity livingEntity = (LivingEntity) sourceentity;
							ItemStack heldItemStack = livingEntity.getItemBySlot(EquipmentSlot.MAINHAND); // 获取主手中的物品
							if (!heldItemStack.isEmpty()) {
								Item heldItem = heldItemStack.getItem();
								// 这是获取攻击伤害的属性值的途径
								attackDamage = heldItemStack.getAttributeModifiers(EquipmentSlot.MAINHAND).get(Attributes.ATTACK_DAMAGE).stream().mapToDouble(attributeModifier -> attributeModifier.getAmount()).sum();
								// 这里只是为了获取基础伤害
								// 如果你想要实际的伤害（包括附魔等影响），你可能需要更复杂的逻辑
								// 这里输出攻击伤害的值
							}
						}
						if (!(entityid).equals("dummmmmmy:target_dummy")) {
							if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getBoolean("isroll")) {
								(sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("xp",
										((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("xp")
												+ (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("quality")));
							}
							if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag()
									.getDouble("xp") > (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("xpneed")) {
								quality = (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("quality");
								(sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("level",
										((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("level") + 1));
								(sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("xp", 0);
								shdamage = (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("quality") * attackDamage * 0.1;
								AttributeModifier qhmor = new AttributeModifier(UUID.fromString("164aba86-cce2-432a-b123-0669ce5ee6df"), "等级伤害加成", shdamage, AttributeModifier.Operation.ADDITION);
								if (ChangeattrProcedure.hasAttributeModifierCompoundTag((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), Attributes.ATTACK_DAMAGE, qhmor,
										net.minecraft.world.entity.EquipmentSlot.MAINHAND)) {
									CompoundTag oldcompoundTag = ChangeattrProcedure.getAttributeModifierCompoundTag(Attributes.ATTACK_DAMAGE, qhmor, EquipmentSlot.MAINHAND);
									AttributeModifier oldattr = ChangeattrProcedure.getAttributeModifierFromCompoundTag(oldcompoundTag);
									double oldvalueofattr = oldattr.getAmount();
									qhmor = new AttributeModifier(UUID.fromString("164aba86-cce2-432a-b123-0669ce5ee6df"), "等级伤害加成", shdamage + oldvalueofattr, AttributeModifier.Operation.ADDITION);
									ChangeattrProcedure.removeAttributeModifier((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), Attributes.ATTACK_DAMAGE, qhmor, EquipmentSlot.MAINHAND);
									ChangeattrProcedure.addItemAttributeModifier((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), Attributes.ATTACK_DAMAGE, qhmor, EquipmentSlot.MAINHAND);
								} else {
									ChangeattrProcedure.addItemAttributeModifier((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), Attributes.ATTACK_DAMAGE, qhmor, EquipmentSlot.MAINHAND);
								}
								if (sourceentity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal(
											("" + ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getDisplayName().getString()) + "\u6211\u5347\u7EA7\u4E86\uFF0C\u5F53\u524D\u7B49\u7EA7:\u00A7a\u00A7l"
													+ ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("level")))),
											false);
								(sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("xpneed",
										((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("xpneed")
												* (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("level")));
							}
						}
						if (EnchantmentHelper.getItemEnchantmentLevel(ExmoxlModEnchantments.BLOODTHIRSTY.get(), (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) != 0) {
							if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 40,
										(int) (1 + (sourceentity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.REGENERATION) ? _livEnt.getEffect(MobEffects.REGENERATION).getAmplifier() : 0)), false, false));
							if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40,
										(int) (1 + (sourceentity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.MOVEMENT_SPEED) ? _livEnt.getEffect(MobEffects.MOVEMENT_SPEED).getAmplifier() : 0)), false, false));
						}
						if (EnchantmentHelper.getItemEnchantmentLevel(ExmoxlModEnchantments.FOCUS_IMPACT.get(), (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) != 0) {
							damage = damage * (4 / attackSpeed) * (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(ExmoxlModEnchantments.FOCUS_IMPACT.get()) * 2;
						}
						damage = amount;
						if (entity.getPersistentData().getDouble("assassin") > 0) {
							if (Math.random() < 0.5) {
								if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 180, 1));
								{
									Entity _ent = entity;
									_ent.teleportTo((sourceentity.getX()), (sourceentity.getY()), (sourceentity.getZ()));
									if (_ent instanceof ServerPlayer _serverPlayer)
										_serverPlayer.connection.teleport((sourceentity.getX()), (sourceentity.getY()), (sourceentity.getZ()), _ent.getYRot(), _ent.getXRot());
								}
							}
						}
						if (entity instanceof LivingEntity && ((LivingEntity) sourceentity).getAttribute(ExmoxlModAttributes.PIERCE.get()) != null) {
							pierce = ((LivingEntity) sourceentity).getAttribute(ExmoxlModAttributes.PIERCE.get()).getValue();
						}
						if (entity instanceof LivingEntity && ((LivingEntity) sourceentity).getAttribute(ExmoxlModAttributes.CRIT.get()) != null) {
							if (Math.random() < ((LivingEntity) sourceentity).getAttribute(ExmoxlModAttributes.CRIT.get()).getValue() * 0.01) {
								damage = damage * (1 + ((LivingEntity) sourceentity).getAttribute(ExmoxlModAttributes.CRITDAMAGE.get()).getValue() * 0.01);
								pierce = pierce * (1 + ((LivingEntity) sourceentity).getAttribute(ExmoxlModAttributes.CRITDAMAGE.get()).getValue() * 0.01);
								if (sourceentity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("\u00A76\u00A7l\u4F60\u9020\u6210\u4E86\u4E00\u6B21\u66B4\u51FB"), true);
								{
									Entity _ent = entity;
									if (!_ent.level().isClientSide() && _ent.getServer() != null) {
										_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
												_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
												"particle minecraft:explosion ~ ~1 ~ 0 0 0 0.3 1");
									}
								}
							}
						}
						if (entity instanceof LivingEntity && ((LivingEntity) entity).getAttribute(ExmoxlModAttributes.MIANSHAN.get()) != null) {
							if (1 - ((LivingEntity) entity).getAttribute(ExmoxlModAttributes.MIANSHAN.get()).getValue() * 0.01 > 0) {
								damage = damage * (1 - ((LivingEntity) entity).getAttribute(ExmoxlModAttributes.MIANSHAN.get()).getValue() * 0.01);
								pierce = pierce * (1 - ((LivingEntity) entity).getAttribute(ExmoxlModAttributes.MIANSHAN.get()).getValue() * 0.01);
							} else {
								pierce = 0;
								damage = 0;
							}
						}
						if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
							if (pierce > 0) {
								if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) - pierce > 0) {
									if (entity instanceof LivingEntity _entity)
										_entity.setHealth((float) ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) - pierce));
								} else {
									ispiercekill = true;
								}
							}
						}
						if (entity instanceof LivingEntity && ((LivingEntity) entity).getAttribute(ExmoxlModAttributes.REBOUND.get()) != null) {
							if (entity instanceof LivingEntity && ((LivingEntity) entity).getAttribute(ExmoxlModAttributes.REBOUNDLV.get()) != null) {
								if (((LivingEntity) entity).getAttribute(ExmoxlModAttributes.REBOUND.get()).getValue() > 0) {
									if ((sourceentity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ExmoxlModVariables.PlayerVariables())).wearonxumiring) {
										defsgl = 50;
									}
									if (Math.random() < (((LivingEntity) entity).getAttribute(ExmoxlModAttributes.REBOUNDLV.get()).getValue() - defsgl) * 0.01) {
										sourceentity.hurt(damagesource, (float) (damage * ((LivingEntity) entity).getAttribute(ExmoxlModAttributes.REBOUND.get()).getValue() * 0.01));
									}
								}
							}
						}
						if (entity instanceof LivingEntity _livEnt104 && _livEnt104.hasEffect(ExmoxlModMobEffects.YISHANG.get())) {
							damage = damage * (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ExmoxlModMobEffects.YISHANG.get()) ? _livEnt.getEffect(ExmoxlModMobEffects.YISHANG.get()).getAmplifier() : 0);
						}
						((LivingHurtEvent) event).setAmount(((float) damage));
						if (entity.isAlive()) {
							if (ispiercekill) {
								{
									Entity _ent = entity;
									if (!_ent.level().isClientSide() && _ent.getServer() != null) {
										_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
												_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "kill");
									}
								}
							}
						}
					} else {
						if (!shanbi) {
							if (sourceentity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal("\u4EE5\u4F60\u7684\u80FD\u529B\u65E0\u6CD5\u4F7F\u7528\u6B64\u7269"), true);
						}
						if (event != null && event.isCancelable()) {
							event.setCanceled(true);
						}
					}
				}
			}
		}
	}
}
