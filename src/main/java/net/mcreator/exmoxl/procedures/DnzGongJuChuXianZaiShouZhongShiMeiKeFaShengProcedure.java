package net.mcreator.exmoxl.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;

public class DnzGongJuChuXianZaiShouZhongShiMeiKeFaShengProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, ItemStack itemstack) {
		double aa = 0;
		if (itemstack.getOrCreateTag().getDouble("dnzz") == 10) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.LARGE_SMOKE, x, (y + 1), z, 10, 0.2, 0.2, 0.2, 0.4);
		}
	}
}
