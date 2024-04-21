package net.mcreator.exmoxl.procedures;

import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.entity.Entity;

import net.mcreator.exmoxl.network.ExmoxlModVariables;

import javax.annotation.Nullable;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import com.google.gson.Gson;
import net.minecraft.world.level.LevelAccessor;

@Mod.EventBusSubscriber
public class GettasknrProcedure {
    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            execute(event, event.player);
        }
    }

    public static void execute(Entity entity) {
        execute(null, entity);
    }

    private static void execute(@Nullable Event event, Entity entity) {
        if (entity == null)
            return;
        LevelAccessor le = (LevelAccessor) (entity.level());
        if (!le.isClientSide()) {
            File taskn = new File("");
            String filename = "";
            com.google.gson.JsonObject jo = new com.google.gson.JsonObject();
            if (!((entity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ExmoxlModVariables.PlayerVariables())).taskget).equals("")) {
                taskn = new File((FMLPaths.GAMEDIR.get().toString() + "/tasks"), File.separator + ((entity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ExmoxlModVariables.PlayerVariables())).taskget + ".json"));
                {
                    try {
                        BufferedReader bufferedReader = new BufferedReader(new FileReader(taskn));
                        StringBuilder jsonstringbuilder = new StringBuilder();
                        String line;
                        while ((line = bufferedReader.readLine()) != null) {
                            jsonstringbuilder.append(line);
                        }
                        bufferedReader.close();
                        jo = new Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
                        {
                            String _setval = jo.get("tasktitle").getAsString();
                            entity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                capability.tasktitle = _setval;
                                capability.syncPlayerVariables(entity);
                            });
                        }
                        {
                            String _setval = jo.get("tasknr").getAsString();
                            entity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                capability.tasknr = _setval;
                                capability.syncPlayerVariables(entity);
                            });
                        }
                        {
                            String _setval = jo.get("taskftitle").getAsString();
                            entity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                capability.taskftitle = _setval;
                                capability.syncPlayerVariables(entity);
                            });
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                {
                    String _setval = "";
                    entity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.taskget = _setval;
                        capability.syncPlayerVariables(entity);
                    });
                }
            }
        }
    }
}