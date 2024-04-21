package net.mcreator.exmoxl.procedures;

import net.minecraft.world.entity.Entity;

public class ZhenyaDangXiaoGuoJieShuProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putDouble("zyhe1", 0);
	}
}
