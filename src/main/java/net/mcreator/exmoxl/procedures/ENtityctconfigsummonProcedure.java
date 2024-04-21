package net.mcreator.exmoxl.procedures;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.TagKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;

import javax.annotation.Nullable;
import java.util.Map;
import java.util.HashMap;

import java.util.ArrayList;
import net.minecraft.world.entity.Entity;
import java.util.List;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.StringTag;
import net.minecraft.nbt.Tag;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.LivingEntity;

@Mod.EventBusSubscriber
public class ENtityctconfigsummonProcedure {
	@SubscribeEvent
public static void onEntitySpawned(EntityJoinLevelEvent event) {
    Map<String, Integer> entityct = new HashMap<>();
    Entity entity = event.getEntity();

    List<String> entityctlist = EntityctconfigProcedure.entityctlist();
    if (entityctlist != null) {
        for (String tagname : entityctlist) {
           // System.out.println(tagname);

            if (entity != null && entity.getType() != null) {
              //  boolean isEntityTypeMatched = entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("minecraft:" + tagname)));
              	    if (entity instanceof LivingEntity) {
        LivingEntity livingEntity = (LivingEntity) entity;  
        	CompoundTag nbt = livingEntity.getPersistentData(); // 或者 livingEntity.serializeNBT()，取决于具体的实体类型和Minecraft版本
        	
            if (nbt.contains("Tags", Tag.TAG_LIST)) {
            ListTag tagsList = nbt.getList("Tags", Tag.TAG_STRING);
            if (tagsList.contains(StringTag.valueOf(tagname))) {
                    entityct = EntityctconfigProcedure.entityct(tagname);
                    
                    if (entityct != null) {
                        for (Map.Entry<String, Integer> entry : entityct.entrySet()) {
                            String key = entry.getKey();
                            Integer value = entry.getValue();
                            
                            if (entity.getPersistentData() != null) {
                                entity.getPersistentData().putDouble(key, (double) value);
                                
                                if (event.getLevel() != null) {
                                    MobspawnProcedure.execute((LevelAccessor) event.getLevel(), entity.getX(), entity.getZ(), entity);
                                }
                            }
                        }
                        }
                    }
                }
            }
        }
    }
}

}
}
