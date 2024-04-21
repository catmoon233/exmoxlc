package net.mcreator.exmoxl.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.exmoxl.ExmoxlMod;

public class ZhenyaXiaoGuoChiXuShiMeiKeFaShengProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity.isAlive()) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > 0) {
				entity.setAirSupply(0);
				entity.setTicksFrozen(20);
				entity.setDeltaMovement(new Vec3(0, (-10), 0));
				if (!(entity.getPersistentData().getDouble("zyhe1") > 1)) {
					entity.getPersistentData().putDouble("zyhe1", (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1));
				}
				ExmoxlMod.queueServerWork(1, () -> {
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > 0) {
						if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) < entity.getPersistentData().getDouble("zyhe1")) {
							entity.getPersistentData().putDouble("zyhe1", (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1));
						}
						if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > entity.getPersistentData().getDouble("zyhe1")) {
							if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > entity.getPersistentData().getDouble("zyhe1")) {
								if (entity instanceof LivingEntity _entity)
									_entity.setHealth((float) entity.getPersistentData().getDouble("zyhe1"));
							}
						}
					}
				});
			}
		}
	}
}
