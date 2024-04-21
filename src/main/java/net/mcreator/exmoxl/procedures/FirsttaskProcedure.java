package net.mcreator.exmoxl.procedures;

import net.mcreator.exmoxl.network.ExmoxlModVariables;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerEvent;

import javax.annotation.Nullable;
import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber
public class FirsttaskProcedure {
    @SubscribeEvent
    public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
        Player entity = event.getEntity();

        List<String> pl = new ArrayList<>();
        pl = (entity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ExmoxlModVariables.PlayerVariables())).task;
        List<String> pl2 = new ArrayList<>();
        pl2 = (entity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ExmoxlModVariables.PlayerVariables())).taskfinnishi;
		System.out.printf("pl.get(index)");

        if (!pl.contains("第一章-初出茅庐")&!pl2.contains("第一章-初出茅庐")){
            entity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
        List<String> pla = new ArrayList<>();

             pla = (entity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ExmoxlModVariables.PlayerVariables())).task;       	
            	pla.add("第一章-初出茅庐");
            	pla.add("第二章-蓝色魏空");
               capability.task = pla;
                capability.syncPlayerVariables(entity);
            });




        }
    }
}