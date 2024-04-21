package net.mcreator.exmoxl.procedures;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonElement;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import java.nio.file.Path;
import java.nio.file.Files;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import net.minecraft.world.item.AxeItem;
@Mod.EventBusSubscriber

public class ReadaxeacProcedure {
    public static Map<String, Map<String, Integer>> toolitema;
    @SubscribeEvent
    public static void onWorldLoad(net.minecraftforge.event.level.LevelEvent.Load event) {
        toolitema = readEntityConfigFile();
        // 在这里可以使用toolitema进行后续操作
    }

    public static Map<String, Map<String, Integer>> readEntityConfigFile() {
        Map<String, Map<String, Integer>> itemsMap = new HashMap<>();
        Path configFilePath = FMLPaths.GAMEDIR.get().resolve("config/Axeac.json");

        if (Files.exists(configFilePath)) {
            try (FileReader reader = new FileReader(configFilePath.toFile())) {
                Gson gson = new Gson();
                JsonObject jsonObject = gson.fromJson(reader, JsonObject.class);

                for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
                    String itemName = entry.getKey();
                    JsonObject itemObject = entry.getValue().getAsJsonObject();

                    Map<String, Integer> propertiesMap = new HashMap<>();
                    for (Map.Entry<String, JsonElement> property : itemObject.entrySet()) {
                        if (property.getValue().isJsonPrimitive() && property.getValue().getAsJsonPrimitive().isNumber()) {
                            propertiesMap.put(property.getKey(), property.getValue().getAsInt());
                        }
                    }
                    itemsMap.put(itemName, propertiesMap);
                }
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        return itemsMap;
    }
}