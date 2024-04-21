
package net.mcreator.exmoxl.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.exmoxl.procedures.RegperXiaoGuoChiXuShiMeiKeFaShengProcedure;

public class RegperMobEffect extends MobEffect {
	public RegperMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -65485);
	}

	@Override
	public String getDescriptionId() {
		return "effect.exmoxl.regper";
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		RegperXiaoGuoChiXuShiMeiKeFaShengProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
