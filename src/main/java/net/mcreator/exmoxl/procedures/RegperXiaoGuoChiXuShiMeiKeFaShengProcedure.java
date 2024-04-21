package net.mcreator.exmoxl.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.exmoxl.init.ExmoxlModMobEffects;
import net.mcreator.exmoxl.ExmoxlMod;

public class RegperXiaoGuoChiXuShiMeiKeFaShengProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double health = 0;
		Entity a2 = null;
		health = (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1)
				* (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ExmoxlModMobEffects.REGPER.get()) ? _livEnt.getEffect(ExmoxlModMobEffects.REGPER.get()).getAmplifier() : 0) * 0.01;// 假设这段代码位于某个事件处理方法中
		if (entity instanceof LivingEntity) {
			LivingEntity livingEntity = (LivingEntity) entity;
			if (!entity.getPersistentData().getBoolean("isheal")) {
				livingEntity.heal((float) health);
				entity.getPersistentData().putBoolean("isheal", true);
				ExmoxlMod.queueServerWork(20, () -> {
					entity.getPersistentData().putBoolean("isheal", false);
				});
			}
		}
	}
}
