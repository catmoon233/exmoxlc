package net.mcreator.exmoxl.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
public class AxeacProcedure {
    @SubscribeEvent
    public static void onCommonSetup(FMLCommonSetupEvent event) {
        createEntityConfigFile();
    }

    private static void createEntityConfigFile() {
        File configFile = new File(FMLPaths.GAMEDIR.get().toString() + "/config/Axeac.json");
        if (!configFile.exists()) {
            try {
                configFile.getParentFile().mkdirs();
                configFile.createNewFile();
                FileWriter writer = new FileWriter(configFile);
                BufferedWriter bw = new BufferedWriter(writer);

                // 写入指定的内容
                bw.write("{\n\"minecraft:iron_axe\": {\n\"axea\": 25\n}\n}");

                bw.close();
                writer.close();
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
    }
}