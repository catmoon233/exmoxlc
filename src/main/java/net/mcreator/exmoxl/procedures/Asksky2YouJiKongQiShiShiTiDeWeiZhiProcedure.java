package net.mcreator.exmoxl.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.exmoxl.init.ExmoxlModEntities;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.Vec3;

import net.mcreator.exmoxl.init.ExmoxlModEntities;

import java.util.Random;
import net.minecraft.world.entity.LivingEntity;
public class Asksky2YouJiKongQiShiShiTiDeWeiZhiProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
        Random random = new Random();
        int yr = random.nextInt(3)+1;
        double fz = 1;
        double fz1 = -1;
        if (entity != null) {
            if (!(entity instanceof Player _plrCldCheck15 && _plrCldCheck15.getCooldowns().isOnCooldown(itemstack.getItem()))) {
                if (entity instanceof Player _player)
                    _player.getCooldowns().addCooldown(itemstack.getItem(), 50);



                for (int index0 = 0; index0 < 4; index0++) {
                    if(index0==1)fz1 = fz1*-1;if(index0==2)fz = fz*-1;if(index0==3)fz1 = fz1*-1;
                    Vec3 lookVec = entity.getLookAngle();
                    x = entity.getX() + (Math.cos(Math.toRadians(entity.getYRot())) * 2) * fz;
                    y = entity.getY() + (1 + fz1);;;
                    z = entity.getZ() + (Math.sin(Math.toRadians(entity.getYRot())) * 2) * fz;
                    if (world instanceof ServerLevel _level) {
                        Entity entityToSpawn = ExmoxlModEntities.FAZHENENTITY.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                        if (entityToSpawn != null) {
                            entityToSpawn.getPersistentData().putString("owner", entity.getStringUUID());
						{
							Entity _ent = entityToSpawn;
							_ent.setYRot(entity.getYRot());
							_ent.setXRot(entity.getXRot());
							_ent.setYBodyRot(_ent.getYRot());
							_ent.setYHeadRot(_ent.getYRot());
							_ent.yRotO = _ent.getYRot();
							_ent.xRotO = _ent.getXRot();
							if (_ent instanceof LivingEntity _entity) {
								_entity.yBodyRotO = _entity.getYRot();
								_entity.yHeadRotO = _entity.getYRot();
							}
						}

                        }
                    }
                }
            }
        }
    }
}
