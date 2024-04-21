
package net.mcreator.exmoxl.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class DoubleWhammyMobEffect extends MobEffect {
	public DoubleWhammyMobEffect() {
		super(MobEffectCategory.NEUTRAL, -26368);
	}

	@Override
	public String getDescriptionId() {
		return "effect.exmoxl.double_whammy";
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
