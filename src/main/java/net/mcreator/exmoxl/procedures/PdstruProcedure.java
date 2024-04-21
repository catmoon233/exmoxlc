package net.mcreator.exmoxl.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.exmoxl.init.ExmoxlModBlocks;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import java.util.List;


import java.util.ArrayList;
import net.minecraft.world.level.Level;	

public class PdstruProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (!world.isClientSide()){
			BlockPos pos = new BlockPos((int)x, (int)y, (int)z);
			List<BlockPos> blockPositions = new ArrayList<>();

			int needFurnaceCBlock = 25;
			int furnaceBlock = 0;
			for (int xOffset = -1; xOffset <= 1; ++xOffset) {
			    for (int yOffset = -1; yOffset <= 1; ++yOffset) {
			        for (int zOffset = -1; zOffset <= 1; ++zOffset) {
			            BlockPos currentPos = pos.offset(xOffset, yOffset, zOffset);
			            BlockState currentState = world.getBlockState(currentPos);
			            if(currentState.getBlock() == ExmoxlModBlocks.BLACK_FURNACE.get()){
			                furnaceBlock ++;
			            }
			            blockPositions.add(currentPos);
			        }		
			    }
			}
			System.out.println(furnaceBlock);
			if (furnaceBlock == needFurnaceCBlock){
				System.out.println("p1");
BlockPos updatedPos = new BlockPos((int)Math.round(x), (int)Math.round(y), (int)Math.round(z));
				BlockState blockState = world.getBlockState(updatedPos);
				if((world.getBlockState(updatedPos.east())).getBlock() == ExmoxlModBlocks.BLACKFURNACESTEP.get()||
					(world.getBlockState(updatedPos.west())).getBlock() == ExmoxlModBlocks.BLACKFURNACESTEP.get()||
					(world.getBlockState(updatedPos.south())).getBlock() == ExmoxlModBlocks.BLACKFURNACESTEP.get()||
					(world.getBlockState(updatedPos.north())).getBlock() == ExmoxlModBlocks.BLACKFURNACESTEP.get()&&
					blockState.getBlock() == Blocks.BLAST_FURNACE){
						System.out.println("p2");
world.setBlock(BlockPos.containing(x, y, z), ExmoxlModBlocks.BLACKFURNACEMAIN.get().defaultBlockState(), 3);
					}
			}
		}
	}
}
