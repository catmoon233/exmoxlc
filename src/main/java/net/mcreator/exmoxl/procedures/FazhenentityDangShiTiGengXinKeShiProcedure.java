package net.mcreator.exmoxl.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.exmoxl.init.ExmoxlModEntities;
import net.mcreator.exmoxl.entity.Asksky2flysworldEntity;
import net.mcreator.exmoxl.ExmoxlMod;

import java.util.ArrayList;

public class FazhenentityDangShiTiGengXinKeShiProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double tie = 0;
		if (entity.getPersistentData().getDouble("dietime") == 0) {
			entity.getPersistentData().putDouble("dietime", 101);
		}
		if (entity.getPersistentData().getDouble("dietime") > 1) {
			entity.getPersistentData().putDouble("dietime", (entity.getPersistentData().getDouble("dietime") - 1));
		}
		if (entity.getPersistentData().getDouble("dietime") == 1) {
			if (!entity.level().isClientSide())
				entity.discard();
		}
		if (entity.getPersistentData().getDouble("dietime") == 75) {
			for (Entity entityiterator : new ArrayList<>(world.players())) {
				if ((entityiterator.getStringUUID()).equals(entity.getPersistentData().getString("owner"))) {
					for (int index0 = 0; index0 < 5; index0++) {
						tie = tie + 1;
						ExmoxlMod.queueServerWork((int) (7 * tie), () -> {
							{
								Entity _shootFrom = entity;
								Level projectileLevel = _shootFrom.level();
								if (!projectileLevel.isClientSide()) {
									Projectile _entityToSpawn = new Object() {
										public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
											AbstractArrow entityToSpawn = new Asksky2flysworldEntity(ExmoxlModEntities.ASKSKY_2FLYSWORLD.get(), level);
											entityToSpawn.setOwner(shooter);
											entityToSpawn.setBaseDamage(damage);
											entityToSpawn.setKnockback(knockback);
											entityToSpawn.setSilent(true);
											return entityToSpawn;
										}
									}.getArrow(projectileLevel, entityiterator, (float) (((LivingEntity) entityiterator).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE).getValue() * 0.2), 1);
									_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
									_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 4, 0);
									projectileLevel.addFreshEntity(_entityToSpawn);
								}
							}
						});
					}
				}
			}
		}
	}
}
