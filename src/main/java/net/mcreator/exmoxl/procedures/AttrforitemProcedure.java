package net.mcreator.exmoxl.procedures;
import java.io.File;
import net.minecraftforge.registries.ForgeRegistries;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileReader;
import org.json.JSONObject;
import com.google.gson.Gson;

import com.google.gson.JsonObject;
import com.google.gson.JsonElement;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.loading.FMLPaths;
public class AttrforitemProcedure {
//lw: 1 = mp ,2 = tou,  3 =str ,4 =hardness
public static int getvalueitem(String str, int position) {
    // 文件路径
    File configFile = new File(FMLPaths.GAMEDIR.get().toString() + "/config/exmoxlitem.json");

    try (BufferedReader reader = new BufferedReader(new FileReader(configFile))) {
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(reader, JsonObject.class);

        // 获取内部JSON对象
        JsonObject innerObject = jsonObject.getAsJsonObject(str);

        if (innerObject.has(Integer.toString(position))) { // 检查键是否存在
int value = innerObject.get(Integer.toString(position)).getAsInt();
            System.out.println("The value of '" + str + "' at index '" + position + "' is: " + value);
            return value;
        } else {
            System.out.println("The specified index does not exist in the JSON object.");
        }
    } catch (IOException exception) {
        exception.printStackTrace();
    }
    return 0;
}

		
	public static void execute(ItemStack itemstack) {
	if (!(itemstack.getOrCreateTag().getDouble("isdark") > 0)){
    System.out.println("The 1");
 	String itemid = ForgeRegistries.ITEMS.getKey(itemstack.getItem()).toString();
 	itemstack.getOrCreateTag().putDouble("isdark",1);
 	for(int i =0;i<=4;i++){
 	switch (i){
	case 4:
	itemstack.getOrCreateTag().putDouble("hardness",getvalueitem(itemid, i));
	break;
	case 3:
	itemstack.getOrCreateTag().putDouble("strength",getvalueitem(itemid, i));
	break;
	case 2:
	itemstack.getOrCreateTag().putDouble("toughness",getvalueitem(itemid, i));
	break;
	case 1:
	itemstack.getOrCreateTag().putDouble("melting_point",getvalueitem(itemid, i));
	break;
	}
 	
			//return getvalueitem(itemid, lw);
	}
	}
	}
}
