package net.mcreator.exmoxl.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.exmoxl.init.ExmoxlModAttributes;

public class AgisxProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "" + Math.round(((LivingEntity) entity).getAttribute(ExmoxlModAttributes.AGILE.get()).getValue());
	}
}
