package net.mcreator.exmoxl.utils;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.mcreator.exmoxl.ExmoxlMod;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.loading.FMLPaths;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

@Mod.EventBusSubscriber
public class dungeon {

    public static Map<String,List<Dungeon>> StoneSignData = new java.util.HashMap<>();
    public static List<Dungeon> dungeons= new ArrayList<>();
    public static class Dungeon {
        public String picturename;

        public Vec3 spawnpo;
        public Vec3 teleportpos;
        public double cooldown;
        public String dungeonname;
        public String dungeonDecription;

        public Vec3 dungeosfirstpos;
        public Vec3 dungeoslastpos;
        public String dungeosworld;
        public String Teleportworld;

    }
    public static List<Dungeon> readconfig()
    {
        List<Dungeon> dungeons1 = new ArrayList<>();
        File configFile = new File(FMLPaths.GAMEDIR.get().toString() + "/config/exmoxl/", "dungeons.json");
        if (configFile.exists()) {
            try (FileReader reader = new FileReader(configFile)) {
                Dungeon dungeonz = new Dungeon();
                Gson gson = new Gson();
                JsonObject jsonObject = gson.fromJson(reader, JsonObject.class);

                JsonArray positionsArray = jsonObject.getAsJsonArray("copy");
                for (int i = 0; i < positionsArray.size(); i++) {
                 String dungeonname = positionsArray.get(i).getAsJsonObject().get("dungeonname").getAsString();
                 String dungeonDecription = positionsArray.get(i).getAsJsonObject().get("dungeonDecription").getAsString();
                 Double dx1 = positionsArray.get(i).getAsJsonObject().get("dx1").getAsDouble();
                 Double dy1 = positionsArray.get(i).getAsJsonObject().get("dy1").getAsDouble();
                 Double dz1 = positionsArray.get(i).getAsJsonObject().get("dz1").getAsDouble();
                 Double dx2 = positionsArray.get(i).getAsJsonObject().get("dx2").getAsDouble();
                 Double dy2 = positionsArray.get(i).getAsJsonObject().get("dy2").getAsDouble();
                 Double dz2 = positionsArray.get(i).getAsJsonObject().get("dz2").getAsDouble();
                 String dungeonworld = positionsArray.get(i).getAsJsonObject().get("dungeonworld").getAsString();
                 String Teleportworld = positionsArray.get(i).getAsJsonObject().get("Teleportworld").getAsString();
                 Double teleportx = positionsArray.get(i).getAsJsonObject().get("teleportx").getAsDouble();
                 Double teleporty = positionsArray.get(i).getAsJsonObject().get("teleporty").getAsDouble();
                 Double teleportz = positionsArray.get(i).getAsJsonObject().get("teleportz").getAsDouble();
                 Double cooldown = positionsArray.get(i).getAsJsonObject().get("cooldown").getAsDouble();
                 String picturename = positionsArray.get(i).getAsJsonObject().get("picturename").getAsString();
                 dungeonz.cooldown = cooldown;
                 dungeonz.dungeonname = dungeonname;
                 dungeonz.dungeonDecription = dungeonDecription;
                 dungeonz.picturename = picturename;
                 dungeonz.dungeosfirstpos = new Vec3(dx1, dy1, dz1);
                 dungeonz.dungeoslastpos = new Vec3(dx2, dy2, dz2);
                 dungeonz.dungeosworld = dungeonworld;
                 dungeonz.Teleportworld = Teleportworld;
                 dungeonz.teleportpos = new Vec3(teleportx, teleporty, teleportz);
                 dungeons1.add(dungeonz);
                 ExmoxlMod.LOGGER.debug("dungeon " + dungeonname + " loaded");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
            return dungeons1;
    }
    public static List<Dungeon>  getDungeons(String s)
    {
         AtomicReference<List<Dungeon>> dungeons1 = new AtomicReference<>(new ArrayList<>());
        StoneSignData.forEach((key, value) -> {
            if (key.equals(s)) {
               // ExmoxlMod.LOGGER.debug("dungeon" + key + "loaded");

                dungeons1.set(value);
            }
        });
        return dungeons1.get();
    }
    public static Dungeon FindDungeon(String dungeonname)
    {
        for (Dungeon dungeonz : dungeons) {
            ExmoxlMod.LOGGER.debug("FINDING " +dungeonz.dungeonname);
            if (dungeonz.dungeonname.equalsIgnoreCase(dungeonname)) {
                ExmoxlMod.LOGGER.debug("dungeon " + dungeonname + " Find");
                return dungeonz;
            }
        }
        return null;
    }
    public static  void  DungeonSettingOnGame(){
        dungeons = readconfig();
        List<Dungeon> dungeonz = new ArrayList<>();
        dungeonz.add(FindDungeon("\u9752\u6728\u79D8\u5883"));
        dungeonz.add(FindDungeon("\u9752\u6728\u79D8\u5883"));
        StoneSignData.put("QMFB", dungeonz);

    }

    }


