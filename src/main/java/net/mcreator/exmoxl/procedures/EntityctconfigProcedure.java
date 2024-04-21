package net.mcreator.exmoxl.procedures;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
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
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
public class EntityctconfigProcedure {
    public static Map<String, Integer> toolItemProperties;
    
public static List<String> entityctlist() {
    List<String> objectNamesList = new ArrayList<>();
    Path configFilePath = FMLPaths.GAMEDIR.get().resolve("config/entityct.json");

    if (Files.exists(configFilePath)) {
        try (FileReader reader = new FileReader(configFilePath.toFile())) {
            Gson gson = new Gson();
            JsonParser parser = new JsonParser();

            // 首先检查解析结果是否为null或者是一个JsonObject
            JsonElement parsedJson = parser.parse(reader);
            if (parsedJson != null && parsedJson.isJsonObject()) {
                JsonObject jsonObject = parsedJson.getAsJsonObject();

                for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
                    objectNamesList.add(entry.getKey()); // 添加对象名称到列表中
                }
            } else {
                System.err.println("Error: 'entityct.json' does not contain a valid JSON object or is empty.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } 
    }

    return objectNamesList;
}
    public static Map<String, Integer> entityct(String objectName) {
        Map<String, Integer> propertiesMap = new HashMap<>();
        Path configFilePath = FMLPaths.GAMEDIR.get().resolve("config/entityct.json");

        if (Files.exists(configFilePath)) {
            try (FileReader reader = new FileReader(configFilePath.toFile())) {
                Gson gson = new Gson();
                JsonParser parser = new JsonParser();
                JsonObject jsonObject = parser.parse(reader).getAsJsonObject();

                JsonObject targetObject = jsonObject.getAsJsonObject(objectName);
                if (targetObject != null) {
                    for (Map.Entry<String, JsonElement> entry : targetObject.entrySet()) {
                        if (entry.getValue().isJsonPrimitive() && entry.getValue().getAsJsonPrimitive().isNumber()) {
                            propertiesMap.put(entry.getKey(), entry.getValue().getAsInt());
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return propertiesMap;
    }
}
