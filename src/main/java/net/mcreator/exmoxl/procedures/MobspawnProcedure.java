package net.mcreator.exmoxl.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.network.chat.Component;
import net.minecraft.nbt.CompoundTag;

import net.mcreator.exmoxl.network.ExmoxlModVariables;
import net.mcreator.exmoxl.init.ExmoxlModMobEffects;
import net.mcreator.exmoxl.init.ExmoxlModAttributes;
import net.mcreator.exmoxl.ExmoxlMod;

import java.util.List;
import java.util.ArrayList;

public class MobspawnProcedure {
	public static void execute(LevelAccessor world, double x, double z, Entity entity) {
		if (entity == null)
			return;
		String ij = "";
		Entity player = null;
		List<Object> kk = new ArrayList<>();
		if (!(entity instanceof Player)) {
			if (entity instanceof LivingEntity && ((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE) != null) {
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > 0) {
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) > 0) {
						if (!entity.getPersistentData().getBoolean("nolevel")) {
							ExmoxlMod.queueServerWork(1, () -> {
								if (Isl2holevelProcedure.isl2lv(entity)) {
									if (!(entity.getPersistentData().getDouble("level") > 0)) {
										for (Entity entityiterator : new ArrayList<>(world.players())) {
											entity.getPersistentData().putDouble("sl", (entity.getPersistentData().getDouble("sl") + (entityiterator instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) * 0.1));
										}
										entity.getPersistentData().putDouble("level", Math.round((Math.abs(z - world.getLevelData().getZSpawn()) + Math.abs(x - world.getLevelData().getXSpawn())) * Mth.nextInt(RandomSource.create(), 10, 40) * 0.0005
												+ 1 + entity.getPersistentData().getDouble("sl")));
									}
									if (!(entity.getPersistentData().getDouble("level") > 0) || entity.getPersistentData().getBoolean("haslevel")) {
										if (entity instanceof LivingEntity && ((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH) != null) {
											((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH)
													.setBaseValue((((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).getValue() * 0.05 * entity.getPersistentData().getDouble("level")
															* Mth.nextDouble(RandomSource.create(), 80, 120) * 0.01 + ((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).getValue()));
											if (entity instanceof LivingEntity _entity)
												_entity.setHealth((float) ((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).getValue());
										}
										if (entity instanceof LivingEntity && ((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR) != null) {
											((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR)
													.setBaseValue((((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR).getValue() * 0.1 * entity.getPersistentData().getDouble("level")
															* Mth.nextDouble(RandomSource.create(), 80, 120) * 0.01));
										}
										if (entity instanceof LivingEntity && ((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR_TOUGHNESS) != null) {
											((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR_TOUGHNESS)
													.setBaseValue((((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR_TOUGHNESS).getValue() * 0.1 * entity.getPersistentData().getDouble("level")
															* Mth.nextDouble(RandomSource.create(), 80, 120) * 0.01));
										}
										if (entity instanceof LivingEntity && ((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE) != null) {
											((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE)
													.setBaseValue((((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE).getValue() * 0.1 * entity.getPersistentData().getDouble("level")
															* Mth.nextDouble(RandomSource.create(), 80, 120) * 0.01));
										}
									}
								}
							});
							if (!entity.getPersistentData().getBoolean("isnospe")) {
								if (Math.random() < 0.3 || entity.getPersistentData().getDouble("gudct") == 1) {
									entity.getPersistentData().putBoolean("bossa", true);
									if (!entity.getPersistentData().getBoolean("gudct")) {
										entity.getPersistentData().putDouble("limbit", (Mth.nextInt(RandomSource.create(), 1, 7)));
									}
									if (entity.getPersistentData().getDouble("suppress") >= 1) {
										entity.getPersistentData().putString("citiao", (entity.getPersistentData().getString("citiao") + " " + "\u00A70\u00A7l\u9547\u538B" + (int) entity.getPersistentData().getDouble("suppress") + "\u00A7r "));
									}
									if (entity.getPersistentData().getDouble("assassin") >= 1) {
										if (entity instanceof LivingEntity && ((LivingEntity) entity).getAttribute(ExmoxlModAttributes.EVASION.get()) != null) {
											((LivingEntity) entity).getAttribute(ExmoxlModAttributes.EVASION.get())
													.setBaseValue((((LivingEntity) entity).getAttribute(ExmoxlModAttributes.EVASION.get()).getValue() + entity.getPersistentData().getDouble("assassin") * 15));
										}
										entity.getPersistentData().putString("citiao", (entity.getPersistentData().getString("citiao") + " " + "\u00A70\u00A7l\u523A\u5BA2" + (int) entity.getPersistentData().getDouble("assassin") + "\u00A7r "));
									}
									if (entity.getPersistentData().getDouble("protect") >= 1) {
										entity.getPersistentData().putDouble("protectcooldown", (entity.getPersistentData().getDouble("protect") * 250));
										entity.getPersistentData().putDouble("protecttime", (entity.getPersistentData().getDouble("protect") * 250));
										entity.getPersistentData().putString("citiao", (entity.getPersistentData().getString("citiao") + " " + "\u00A7f\u00A7l\u4FDD\u62A4" + (int) entity.getPersistentData().getDouble("protect") + "\u00A7r "));
									}
									if (entity.getPersistentData().getDouble("fenlie") >= 1) {
										entity.getPersistentData().putString("citiao", (entity.getPersistentData().getString("citiao") + " " + "\u00A7a\u00A7l\u5206\u88C2" + (int) entity.getPersistentData().getDouble("fenlie") + "\u00A7r "));
									}
									if (entity.getPersistentData().getDouble("shanbi") >= 1) {
										if (entity instanceof LivingEntity && ((LivingEntity) entity).getAttribute(ExmoxlModAttributes.EVASION.get()) != null) {
											((LivingEntity) entity).getAttribute(ExmoxlModAttributes.EVASION.get())
													.setBaseValue((((LivingEntity) entity).getAttribute(ExmoxlModAttributes.EVASION.get()).getValue() + entity.getPersistentData().getDouble("shanbi") * 20));
										}
										entity.getPersistentData().putString("citiao", (entity.getPersistentData().getString("citiao") + " " + "\u00A7d\u00A7l\u95EA\u907F" + (int) entity.getPersistentData().getDouble("shanbi") + "\u00A7r "));
									}
									if (entity.getPersistentData().getDouble("Rebirth") >= 1) {
										entity.getPersistentData().putString("citiao", (entity.getPersistentData().getString("citiao") + " " + "\u00A7d\u00A7l\u590D\u751F" + (int) entity.getPersistentData().getDouble("Rebirth") + "\u00A7r "));
									}
									if (entity.getPersistentData().getDouble("DyingLight") >= 1) {
										entity.getPersistentData().putString("citiao",
												(entity.getPersistentData().getString("citiao") + " " + "\u00A7e\u00A7l\u6FD2\u6B7B\u4E4B\u5149" + (int) entity.getPersistentData().getDouble("DyingLight") + "\u00A7r "));
									}
									if (entity.getPersistentData().getDouble("attup") >= 1) {
										entity.getPersistentData().putString("citiao", (entity.getPersistentData().getString("citiao") + " " + "\u00A75\u00A7l\u731B\u51FB" + (int) entity.getPersistentData().getDouble("attup") + "\u00A7r "));
										if (entity instanceof LivingEntity && ((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE) != null) {
											((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE)
													.setBaseValue((((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE).getValue() * (1 + entity.getPersistentData().getDouble("attup") * 0.5)));
										}
									}
									if (entity.getPersistentData().getDouble("hitup") >= 1) {
										entity.getPersistentData().putString("citiao", (entity.getPersistentData().getString("citiao") + " " + "\u00A7a\u00A7l\u7CBE\u51C6" + (int) entity.getPersistentData().getDouble("hitup") + "\u00A7r "));
										if (entity instanceof LivingEntity && ((LivingEntity) entity).getAttribute(ExmoxlModAttributes.HITRATE.get()) != null) {
											((LivingEntity) entity).getAttribute(ExmoxlModAttributes.HITRATE.get())
													.setBaseValue((((LivingEntity) entity).getAttribute(ExmoxlModAttributes.HITRATE.get()).getValue() + entity.getPersistentData().getDouble("hitup") * 40));
										}
										if (entity instanceof LivingEntity && ((LivingEntity) entity).getAttribute(ExmoxlModAttributes.CRIT.get()) != null) {
											((LivingEntity) entity).getAttribute(ExmoxlModAttributes.CRIT.get())
													.setBaseValue((((LivingEntity) entity).getAttribute(ExmoxlModAttributes.CRIT.get()).getValue() + entity.getPersistentData().getDouble("hitup") * 30));
										}
										if (entity instanceof LivingEntity && ((LivingEntity) entity).getAttribute(ExmoxlModAttributes.CRITDAMAGE.get()) != null) {
											((LivingEntity) entity).getAttribute(ExmoxlModAttributes.CRITDAMAGE.get())
													.setBaseValue((((LivingEntity) entity).getAttribute(ExmoxlModAttributes.CRITDAMAGE.get()).getValue() + entity.getPersistentData().getDouble("hitup") * 25));
										}
									}
									if (entity.getPersistentData().getDouble("fanshe") >= 1) {
										entity.getPersistentData().putString("citiao", (entity.getPersistentData().getString("citiao") + " " + "\u00A7a\u00A7l\u53CD\u5C04" + (int) entity.getPersistentData().getDouble("fanshe") + "\u00A7r "));
										if (entity instanceof LivingEntity && ((LivingEntity) entity).getAttribute(ExmoxlModAttributes.REBOUND.get()) != null) {
											((LivingEntity) entity).getAttribute(ExmoxlModAttributes.REBOUND.get())
													.setBaseValue((((LivingEntity) entity).getAttribute(ExmoxlModAttributes.REBOUND.get()).getValue() + entity.getPersistentData().getDouble("fanshe") * 20));
										}
										if (entity instanceof LivingEntity && ((LivingEntity) entity).getAttribute(ExmoxlModAttributes.REBOUNDLV.get()) != null) {
											((LivingEntity) entity).getAttribute(ExmoxlModAttributes.REBOUNDLV.get())
													.setBaseValue((((LivingEntity) entity).getAttribute(ExmoxlModAttributes.REBOUNDLV.get()).getValue() + entity.getPersistentData().getDouble("fanshe") * 15));
										}
									}
									if (entity.getPersistentData().getDouble("speede") >= 1) {
										if (entity instanceof LivingEntity && ((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED) != null) {
											((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED)
													.setBaseValue((((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED).getValue() * (1 + entity.getPersistentData().getDouble("speede") * 0.4)));
										}
										entity.getPersistentData().putString("citiao", (entity.getPersistentData().getString("citiao") + " " + "\u00A7b\u00A7l\u8FC5\u6377" + (int) entity.getPersistentData().getDouble("speede") + "\u00A7r "));
									}
									if (entity.getPersistentData().getDouble("savage") >= 1) {
										if (entity instanceof LivingEntity && ((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE) != null) {
											((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE)
													.setBaseValue((((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE).getValue() * (1 + entity.getPersistentData().getDouble("savage") * 0.25)));
										}
										entity.getPersistentData().putString("citiao", (entity.getPersistentData().getString("citiao") + " " + "\u00A74\u00A7l\u72C2\u6012" + (int) entity.getPersistentData().getDouble("savage") + "\u00A7r "));
									}
									if (entity.getPersistentData().getDouble("healper") >= 1) {
										if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
											_entity.addEffect(new MobEffectInstance(ExmoxlModMobEffects.REGPER.get(), 9999999, (int) entity.getPersistentData().getDouble("healper")));
										entity.getPersistentData().putString("citiao", (entity.getPersistentData().getString("citiao") + " " + "\u00A76\u00A7l\u518D\u751F" + (int) entity.getPersistentData().getDouble("healper") + "\u00A7r "));
									}
									if (entity.getPersistentData().getDouble("plated") >= 1) {
										if (entity instanceof LivingEntity && ((LivingEntity) entity).getAttribute(ExmoxlModAttributes.MIANSHAN.get()) != null) {
											((LivingEntity) entity).getAttribute(ExmoxlModAttributes.MIANSHAN.get())
													.setBaseValue((((LivingEntity) entity).getAttribute(ExmoxlModAttributes.MIANSHAN.get()).getValue() + entity.getPersistentData().getDouble("plated") * 20));
											entity.getPersistentData().putString("citiao",
													(entity.getPersistentData().getString("citiao") + " " + "\u00A76\u00A7l\u76AE\u7CD9\u8089\u539A" + (int) entity.getPersistentData().getDouble("plated") + "\u00A7r "));
										}
									}
									if (entity.getPersistentData().getDouble("massive") >= 1) {
										if (entity instanceof LivingEntity && ((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH) != null) {
											((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH)
													.setBaseValue((((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).getValue() * (1 + entity.getPersistentData().getDouble("massive") * 0.4)));
											entity.getPersistentData().putString("citiao",
													(entity.getPersistentData().getString("citiao") + " " + "\u00A74\u00A7l\u989D\u5916\u751F\u547D" + (int) entity.getPersistentData().getDouble("massive") + "\u00A7r "));
											if (entity instanceof LivingEntity _entity)
												_entity.setHealth((float) ((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).getValue());
										}
									}
								}
								CompoundTag dataIndex148 = new CompoundTag();
								entity.saveWithoutId(dataIndex148);
								dataIndex148.putBoolean("bossa", true);
								entity.load(dataIndex148);
								OnmobdeathProcedure.changecitiao(entity.getUUID(), entity.getPersistentData().getString("citiao"), world);
								if (ExmoxlModVariables.MapVariables.get(entity.level()).bossstring.size() > ExmoxlModVariables.MapVariables.get(world).bossstringyz) {
									ExmoxlModVariables.MapVariables.get(world).bossstringyz = ExmoxlModVariables.MapVariables.get(entity.level()).bossstring.size() + 50;
									ExmoxlModVariables.MapVariables.get(world).syncData(world);
								}
							}
							if (!(entity.getPersistentData().getDouble("level") == 0)) {
								if (entity.getPersistentData().getBoolean("bossa")) {
									entity.setCustomName(Component.literal(("LV." + (int) (entity.getPersistentData().getDouble("level")) + " \u00A7d\u7CBE\u82F1\u602A\u00A7r" + entity.getDisplayName().getString())));
								} else {
									entity.setCustomName(Component.literal(("LV." + (int) (entity.getPersistentData().getDouble("level")) + " " + entity.getDisplayName().getString())));
								}
							}
						}
					}
				}
			}
		}
	}
}
