package net.mcreator.exmoxl.procedures;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;
import java.util.function.Supplier;
import java.util.Map;
import com.google.gson.Gson;
import java.nio.file.Files;
import java.nio.file.Paths;
import net.minecraftforge.fml.loading.FMLPaths;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.JsonSyntaxException;
public class Recastinglc2Procedure {
    public static void execute(Entity entity) {
        if (entity == null)
            return;

        Player player = (Player) entity;

        // 读取配置文件并转换为字符串
        String configData;
        try {
            configData = new String(Files.readAllBytes(Paths.get(FMLPaths.GAMEDIR.get().toString(), "config", "recasting_config.json")));
        } catch (Exception e) {
            System.err.println("Failed to read recasting_config.json: " + e.getMessage());
            return;
        }

        // 将字符串转换为JSON对象
        Gson gson = new Gson();
        Map<String, Double> configMap; // 更改为 Double 类型
        try {
            configMap = gson.fromJson(configData, new TypeToken<Map<String, Double>>(){}.getType());
        } catch (JsonSyntaxException e) {
            System.err.println("Failed to parse recasting_config.json: " + e.getMessage());
            return;
        }

        // 获取槽位信息
        Slot slot0 = player.containerMenu.slots.get(0);
        Slot slot2 = player.containerMenu.slots.get(2);

        // 获取槽位中的物品
        ItemStack slot0Item = slot0.getItem();
        ItemStack slot2Item = slot2.getItem();

        // 如果槽位0中的物品是装备
        if (slot0Item.getItem() instanceof ArmorItem) {
            // 获取对应物品的值
            if (slot2Item.getItem() instanceof net.minecraft.world.item.Item) {
                ResourceLocation registryName = ForgeRegistries.ITEMS.getKey(slot2Item.getItem());
                if (registryName != null) {
                    Double recastingValueDouble = configMap.getOrDefault(registryName.toString(), 0.0); // 获取 Double 值
                    int recastingValue = recastingValueDouble.intValue(); // 转换为 Integer

                    // 将值写入物品的 NBT
                    CompoundTag tag = slot0Item.getOrCreateTag();
                    tag.putInt("recasting", recastingValue); // 根据需求调整为 putInt 或者保留 putDouble
                }
            }
        }
    }
}