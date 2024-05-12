package net.mcreator.exmoxl.procedures;

import net.mcreator.exmoxl.network.ExmoxlModVariables;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.mcreator.exmoxl.world.inventory.TaskguiMenu;
import net.mcreator.exmoxl.client.gui.TaskguiScreen;

import java.util.HashMap;
import java.util.List;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
public class TaskszcProcedure {
	public static void execute(Player entity) {

            //130 36
			//System.out.printf("66666666666666666666666666666666666666666");
            List<String> pl;
            pl = (entity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ExmoxlModVariables.PlayerVariables())).task;
            int mx = TaskguiScreen.mx;
            int my = TaskguiScreen.my;
            int px = TaskguiScreen.px ;
            int py = TaskguiScreen.py + 15;

            if (mx <px+130&mx > px){
                for (int i = 0; i < pl.size(); i++){
                    if (my < py+36*i&my > py+36*(i-1)){

                        int finalI = i;
                        entity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                            capability.taskxz = finalI;
                            capability.taskget = pl.get(finalI);
                            capability.syncPlayerVariables(entity);
                        });


                    }
                }
            }
        
	}
}
