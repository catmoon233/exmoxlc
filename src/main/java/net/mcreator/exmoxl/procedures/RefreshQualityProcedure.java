package net.mcreator.exmoxl.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import org.json.JSONObject;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonElement;
import javax.annotation.Nullable;

import com.google.gson.JsonObject;
import com.google.gson.JsonElement;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraft.nbt.CompoundTag;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.UUID;
import java.util.Map;
import java.util.List;
import java.util.Collections;
import java.util.ArrayList;

import net.minecraft.nbt.NbtIo;

import net.minecraft.nbt.NbtUtils;
import java.nio.file.Paths;

import com.google.common.collect.Multimap;

@Mod.EventBusSubscriber
public class RefreshQualityProcedure {
    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            execute(event, event.player);
        }
    }

    public static void execute(Entity entity) {
        execute(null, entity);
    }

    private static void execute(@Nullable Event event, Entity entity) {
    	            Random ra = new Random();
        if (entity == null)
            return;
        if(!entity.level().isClientSide){



            List<Object> weawash = new ArrayList<>();
            if (!((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem())) {
            	            double attackDamage = 0;
                attackDamage = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getAttributeModifiers(EquipmentSlot.MAINHAND).get(Attributes.ATTACK_DAMAGE).stream()
                        .mapToDouble(attributeModifier -> attributeModifier.getAmount()).sum();
                if (attackDamage > 0) {
            String quaility = "";
            double roll = 0;
            double roll2 = 0;

            double roll3 = 0;
            double roll4 = 0;
            double attackspeed = 0;

                    if (!((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getBoolean("isroll"))) {
                    	
                        if (!((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("level") > 0)) {
                            (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putBoolean("isroll", true);
                            roll = Mth.nextInt(RandomSource.create(), 1, 100);
                            
                            if (roll < 100) {
                                (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("quality", 1);
                                quaility = "\u00A77\u666E\u901A";
                            }
                            if (roll < 70) {
                                (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("quality", 2);
                                quaility = "\u00A72\u4F18\u826F";
                            }
                            if (roll < 50) {
                                (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("quality", 3);
                                quaility = "\u00A79\u7CBE\u826F";
                            }
                            if (roll < 30) {
                                (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("quality", 4);
                                quaility = "\u00A7d\u53F2\u8BD7";
                            }
                            if (roll < 10) {
                                (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("quality", 5);
                                quaility = "\u00A76\u795E\u5316";
                            }
           			double raa = ra.nextInt(3);
            if(raa==0){(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putString("ysattr", "wood");}
            if(raa==1){(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putString("ysattr", "water");}
            if(raa==2){(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putString("ysattr", "fire");}
        
                            (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("level", 1);
                            (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("maxlevel",
                                    ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("quality") * 10));
                            (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("xp", 0);
                            (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("xpneed", 40);
                            (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)
                                    .getOrCreateTag().putString("qua", quaility);
                            roll2 = Mth.nextInt(RandomSource.create(), 1, 10);
                    /*        UUID randomUUID = UUID.randomUUID();

                            List<EquipmentSlot> hand = new ArrayList<EquipmentSlot>();
                            hand.add(EquipmentSlot.MAINHAND);
                            hand.add(EquipmentSlot.OFFHAND);

                            if (entity instanceof LivingEntity _livEnt) for (int i = 0; i < hand.size(); i++) {
                                EquipmentSlot handn = hand.get(i);

                                Multimap<Attribute, AttributeModifier> attributeModifiers = (_livEnt.getMainHandItem()).getAttributeModifiers(handn);
                                for (Map.Entry<Attribute, AttributeModifier> entry : attributeModifiers.entries()) {
                                    Attribute attribute = entry.getKey();
                                    AttributeModifier oldAttributeModifier = entry.getValue();
                                    (_livEnt.getMainHandItem()).addAttributeModifier(attribute,
                                            new AttributeModifier(oldAttributeModifier.getId(), oldAttributeModifier.getName(), oldAttributeModifier.getAmount(), oldAttributeModifier.getOperation()),
                                            handn);
                                }

                            }
*/
                            if (!(entity instanceof LivingEntity)) return;

                            LivingEntity livingEntity = (LivingEntity) entity;
                            ItemStack mainHandItem = livingEntity.getMainHandItem();

                            if (mainHandItem.isEmpty() || mainHandItem.getOrCreateTag().getDouble("roll32") == 1) {
                                return;
                            }

                            String configData;
                            JsonObject jsonObj;

                            try {
                                // 读取配置文件内容
                                configData = new String(Files.readAllBytes(Paths.get(FMLPaths.GAMEDIR.get().toString(), "config", "Citiao.json")));
                                jsonObj = new Gson().fromJson(configData, JsonObject.class);
                            } catch (IOException e) {
                                e.printStackTrace();
                                return; // 返回或适当处理异常
                            }

                            CompoundTag itemTag = mainHandItem.getOrCreateTag();
                            itemTag.putDouble("roll32", 1);

// 从配置中随机选择一个词条
                            List<String> keys = new ArrayList<>(jsonObj.keySet());
                            Collections.shuffle(keys);
                            String randomKey = keys.get(0);
                            JsonObject randomEntry = jsonObj.getAsJsonObject(randomKey);

// 设置显示名称
                            itemTag.putString("roll2s", randomEntry.get("displayname").getAsString());

// 获取并应用属性
                            JsonObject attributesObject = randomEntry.getAsJsonObject("attributes");
                            for (String attrKey : attributesObject.keySet()) {
                                JsonObject attrObj = attributesObject.getAsJsonObject(attrKey);
                                double value = attrObj.get("value").getAsDouble();
                                AttributeModifier.Operation operation;

                                try {
                                    operation = AttributeModifier.Operation.valueOf(attrObj.get("operation").getAsString());
                                } catch (IllegalArgumentException e) {
                                    System.out.println("Warning: Invalid attribute operation for attribute " + attrKey + ": " + attrObj.get("operation").getAsString());
                                    continue;
                                }

                                String[] attributeArray = attrKey.split(":");
                                ResourceLocation rl = new ResourceLocation(attributeArray[0], attributeArray[1]);
                                Attribute attribute = ForgeRegistries.ATTRIBUTES.getValue(rl);

                                if (attribute != null) {
                                    UUID uuid = UUID.randomUUID();
                                    
                                    ChangeattrProcedure.addItemAttributeModifier(mainHandItem,attribute, new AttributeModifier(uuid, randomEntry.get("displayname").getAsString(), value, operation), EquipmentSlot.MAINHAND);
                                } else {
                                    System.out.println("Warning: Attempted to add an attribute modifier for a non-existent attribute: " + attrKey);
                                }
                            }


                            ItemStack	mh = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
                            roll3 = Mth.nextInt(RandomSource.create(), 1, 3);
                            while (roll3 > 0) {
                                roll4 = Mth.nextInt(RandomSource.create(), 1, 10);
                                if (roll4 == 1) {
                                    mh.getOrCreateTag().putDouble(("scdz"),(mh.getOrCreateTag().getDouble("sxdz")+1));

                                    mh.getOrCreateTag().putString(("roll4s" + roll3), "\u53CC\u91CD\u6253\u51FB");
                                }
                                if (roll4 == 2) {
                                    mh.getOrCreateTag().putDouble(("fbjj"),(mh.getOrCreateTag().getDouble("fbjj")+1));
                                    mh.getOrCreateTag().putString(("roll4s" + roll3), "\u98CE\u66B4\u805A\u96C6");
                                }
                                if (roll4 == 3) {
                                    mh.getOrCreateTag().putString(("roll4s" + roll3), "\u55DC\u8840\u6210\u6027");
                                }
                                if (roll4 == 4) {
                                    mh.getOrCreateTag().putString(("roll4s" + roll3), "\u72C2\u6012");
                                }
                                if (roll4 == 5) {
                                    mh.getOrCreateTag().putString(("roll4s" + roll3), "\u91CD\u7532");
                                }
                                if (roll4 == 6) {
                                    mh.getOrCreateTag().putString(("roll4s" + roll3), "\u5F71\u88AD");
                                }
                                if (roll4 == 7) {
                                    mh.getOrCreateTag().putString(("roll4s" + roll3), "\u56FA\u82E5\u91D1\u6C64");
                                }
                                if (roll4 == 8) {
                                    mh.getOrCreateTag().putString(("roll4s" + roll3), "\u72D9\u51FB\u624B");
                                }
                                if (roll4 == 9) {
                                    mh.getOrCreateTag().putString(("roll4s" + roll3), "\u72EE\u5B50\u6838\u5FC3");
                                }
                                if (roll4 == 10) {
                                    mh.getOrCreateTag().putString(("roll4s" + roll3), "\u8346\u68D8\u7532");
                                }

                                roll3 = roll3 - 1;
                            }
                        }
                    }
                }
            }
        }
    }
}
