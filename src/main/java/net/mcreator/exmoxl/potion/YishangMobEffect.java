
package net.mcreator.exmoxl.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class YishangMobEffect extends MobEffect {
	public YishangMobEffect() {
		super(MobEffectCategory.HARMFUL, -16777216);
	}

	@Override
	public String getDescriptionId() {
		return "effect.exmoxl.yishang";
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
