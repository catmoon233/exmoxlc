package net.mcreator.exmoxl.procedures;

import net.mcreator.exmoxl.ExmoxlMod;
import net.mcreator.exmoxl.network.ExmoxlModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

@Mod.EventBusSubscriber
public class HositymobspawnProcedure {
    @SubscribeEvent
    public static void onEntitySpawned(EntityJoinLevelEvent event) {
        if(!(((LevelAccessor)event.getLevel()).isClientSide())){
            if(event.getEntity() instanceof LivingEntity livingEntity) {
                Vec3 pos = event.getEntity().position();
                List<Object> levellist = ExmoxlModVariables.spawnhoslevel;
                List<Object> worldlist = ExmoxlModVariables.spawnhosworld;
                List<Vec3> poslist = ExmoxlModVariables.MapVariables.get(event.getLevel()).spawnpos;
                Level level = event.getLevel();

                for (int i = 0; i < levellist.size(); i++) {
                    Vec3 pos1 = poslist.get(i*2);
                    Vec3 pos2 = poslist.get(i*2+1);

                   /* ExmoxlMod.LOGGER.debug(pos1);
                    ExmoxlMod.LOGGER.debug(pos2);
                    ExmoxlMod.LOGGER.debug(pos);
                    ExmoxlMod.LOGGER.debug(levellist.get(i));
                    ExmoxlMod.LOGGER.debug(worldlist.get(i));*/
                    if (level.dimension().location().toString().equals(worldlist.get(i).toString()) && pos.x >= pos1.x && pos.x <= pos2.x && pos.y >= pos1.y && pos.y <= pos2.y && pos.z >= pos1.z && pos.z <= pos2.z) {

                      //  ExmoxlMod.LOGGER.debug("HositymobspawnProcedure");

                        {

                            Entity _ent = livingEntity;
                            if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
                                        _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "hostility mobs @s level setAndRerollTrait "+levellist.get(i));
                            }
                        }

                    }
                }

            }
    }
    }
}
