package net.mcreator.exmoxl.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;

public class MagicaDanSheWuJiZhongFangKuaiShiProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity immediatesourceentity) {
		if (immediatesourceentity == null)
			return;
		if (!immediatesourceentity.getPersistentData().getBoolean("ismz")) {
			if (world instanceof Level _level && !_level.isClientSide())
				_level.explode(null, x, y, z, 2, Level.ExplosionInteraction.NONE);
			immediatesourceentity.getPersistentData().putBoolean("ismz", true);
		}
	}
}
