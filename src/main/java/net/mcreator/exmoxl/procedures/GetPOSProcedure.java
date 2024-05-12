package net.mcreator.exmoxl.procedures;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.mcreator.exmoxl.ExmoxlMod;
import net.mcreator.exmoxl.network.ExmoxlModVariables;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraft.world.phys.Vec3;

import java.util.List;
import java.util.ArrayList;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class
GetPOSProcedure {
	public static void execute(LevelAccessor world) {
		if(!world.isClientSide()){
			File configFile = new File(FMLPaths.GAMEDIR.get().toString() + "/config", "hospo.json");
			List<Vec3> vecList = new ArrayList<>();
			List<Object> worldnamelist = new ArrayList<>();
			List<Object> levelList = new ArrayList<>();
			if (configFile.exists()) {
				try (FileReader reader = new FileReader(configFile)) {
					Gson gson = new Gson();
					JsonObject jsonObject = gson.fromJson(reader, JsonObject.class);

					JsonArray positionsArray = jsonObject.getAsJsonArray("positions");
					for (int i = 0; i < positionsArray.size(); i++) {
						JsonObject positionObject = positionsArray.get(i).getAsJsonObject();
						int level = positionObject.get("level").getAsInt();
						String worldname = positionObject.get("world").getAsString();
						// Parse x1, y1, z1 and create Vec3 object
						int x1 = positionObject.get("x1").getAsInt();
						int y1 = positionObject.get("y1").getAsInt();
						int z1 = positionObject.get("z1").getAsInt();
						Vec3 vec1 = new Vec3(x1, y1, z1);
						vecList.add(vec1);
						ExmoxlMod.LOGGER.debug(((Level)world).dimension().location().toString());
						// Parse x2, y2, z2 and create Vec3 object
						int x2 = positionObject.get("x2").getAsInt();
						int y2 = positionObject.get("y2").getAsInt();
						int z2 = positionObject.get("z2").getAsInt();
						Vec3 vec2 = new Vec3(x2, y2, z2);
						vecList.add(vec2);
						levelList.add(level);
						worldnamelist.add(worldname);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			ExmoxlModVariables.spawnhosworld = worldnamelist;
			ExmoxlModVariables.spawnhoslevel = levelList;
			ExmoxlModVariables.MapVariables.get(world).spawnpos = vecList;
			ExmoxlModVariables.MapVariables.get(world).syncData(world);
			for (int i = 0; i < vecList.size(); i++) {
				ExmoxlMod.LOGGER.debug(vecList.get(i));
				ExmoxlMod.LOGGER.debug(levelList.get(i));
				ExmoxlMod.LOGGER.debug(worldnamelist.get(i));
			}
		}
	}
}