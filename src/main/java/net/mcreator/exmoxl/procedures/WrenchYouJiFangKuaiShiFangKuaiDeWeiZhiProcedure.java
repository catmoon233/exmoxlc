package net.mcreator.exmoxl.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class WrenchYouJiFangKuaiShiFangKuaiDeWeiZhiProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.BLAST_FURNACE) {
			PdstruProcedure.execute(world, x, y, z);
		}
	}
}
