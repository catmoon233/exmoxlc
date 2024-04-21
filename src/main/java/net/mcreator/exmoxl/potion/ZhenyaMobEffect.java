
package net.mcreator.exmoxl.potion;

import net.minecraftforge.client.extensions.common.IClientMobEffectExtensions;

import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.client.gui.screens.inventory.EffectRenderingInventoryScreen;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.exmoxl.procedures.ZhenyaXiaoGuoChiXuShiMeiKeFaShengProcedure;
import net.mcreator.exmoxl.procedures.ZhenyaDangXiaoGuoJieShuProcedure;

public class ZhenyaMobEffect extends MobEffect {
	public ZhenyaMobEffect() {
		super(MobEffectCategory.NEUTRAL, -16777216);
	}

	@Override
	public String getDescriptionId() {
		return "effect.exmoxl.zhenya";
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		ZhenyaXiaoGuoChiXuShiMeiKeFaShengProcedure.execute(entity.level(), entity);
	}

	@Override
	public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		super.removeAttributeModifiers(entity, attributeMap, amplifier);
		ZhenyaDangXiaoGuoJieShuProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}

	@Override
	public void initializeClient(java.util.function.Consumer<IClientMobEffectExtensions> consumer) {
		consumer.accept(new IClientMobEffectExtensions() {
			@Override
			public boolean isVisibleInInventory(MobEffectInstance effect) {
				return false;
			}

			@Override
			public boolean renderInventoryText(MobEffectInstance instance, EffectRenderingInventoryScreen<?> screen, GuiGraphics guiGraphics, int x, int y, int blitOffset) {
				return false;
			}

			@Override
			public boolean isVisibleInGui(MobEffectInstance effect) {
				return false;
			}
		});
	}
}
