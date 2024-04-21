package net.mcreator.exmoxl.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.item.ItemTossEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.BlockPos;

import net.mcreator.exmoxl.init.ExmoxlModItems;
import net.mcreator.exmoxl.init.ExmoxlModEnchantments;
import net.mcreator.exmoxl.Removeuuid;

import javax.annotation.Nullable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;
import java.util.Map;
import java.util.List;
import java.util.Collections;
import java.util.ArrayList;

import java.nio.file.Paths;

import java.io.IOException;

import com.google.gson.JsonObject;
import com.google.gson.Gson;

@Mod.EventBusSubscriber
public class WashTickProcedure {
	@SubscribeEvent
	public static void onGemDropped(ItemTossEvent event) {
		execute(event, event.getPlayer().level(), event.getPlayer().getX(), event.getPlayer().getY(), event.getPlayer().getZ(), event.getPlayer(), event.getEntity().getItem());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		execute(null, world, x, y, z, entity, itemstack);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		String quaility = "";
		double attackspeed = 0;
		double roll = 0;
		double roll3 = 0;
		double roll4 = 0;
		double attackDamage = 0;
		double roll2 = 0;
		if (itemstack.getOrCreateTag().getDouble("quality") > 0) {
			if (entity.isInWaterRainOrBubble()) {
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == ExmoxlModItems.WASHSTONE.get()) {
					(entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).shrink(1);
					{
						Map<Enchantment, Integer> _enchantments = EnchantmentHelper.getEnchantments(itemstack);
						if (_enchantments.containsKey(ExmoxlModEnchantments.BLOODTHIRSTY.get())) {
							_enchantments.remove(ExmoxlModEnchantments.BLOODTHIRSTY.get());
							EnchantmentHelper.setEnchantments(_enchantments, itemstack);
						}
					}
					if (world instanceof ServerLevel _level) {
						LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
						entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x, y, z)));
						entityToSpawn.setVisualOnly(true);
						_level.addFreshEntity(entityToSpawn);
					}
					roll2 = Mth.nextInt(RandomSource.create(), 1, 10);
					List<UUID> uuidList = new ArrayList<>();
					// 添加所有UUID到列表中
					uuidList.add(UUID.fromString("53ac20d1-466c-4eda-9edc-35e28ca99e1d"));
					uuidList.add(UUID.fromString("792ad939-3991-41d5-9f80-c63ddeaf481f"));
					uuidList.add(UUID.fromString("c0bea00b-39c2-4d0c-8dd5-ae6cc100679d"));
					uuidList.add(UUID.fromString("32de96f7-af82-44e9-9c59-63299d4661b4"));
					uuidList.add(UUID.fromString("5f26a925-2e57-49c9-9591-22de84ccb50f"));
					uuidList.add(UUID.fromString("f319da94-521b-499b-aa07-be5ca509aa39"));
					uuidList.add(UUID.fromString("2398e7d0-c3b1-4a4d-a757-291838f84b27"));
					uuidList.add(UUID.fromString("60f4c25e-51d1-4414-80ec-7a2e3c38f658"));
					uuidList.add(UUID.fromString("6125781e-9546-42de-92ad-120c1c2604c6"));
					uuidList.add(UUID.fromString("6256229a-4664-4399-95d2-dba9288cd8a4"));
					uuidList.add(UUID.fromString("b6bea985-7ecc-4630-88d1-c5148cd50e47"));
					uuidList.add(UUID.fromString("0c6ae271-0027-4e71-8b23-125042c35cc7"));
					uuidList.add(UUID.fromString("5c59b41a-08ab-4695-96c0-35d3a5a5a979"));
					uuidList.add(UUID.fromString("b5f6a5ec-6c8d-4094-bc52-0f72acdf5108"));
					uuidList.add(UUID.fromString("29f57f99-3d4a-4777-b607-89f8e9f32cc0"));
					uuidList.add(UUID.fromString("f47a12fd-2c83-4ac0-be2e-877df94c402e"));
					Removeuuid.removeAttributeModifiersFromList(itemstack, uuidList);
					if (!(entity instanceof LivingEntity))
						return;
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
							mainHandItem.addAttributeModifier(attribute, new AttributeModifier(uuid, randomEntry.get("displayname").getAsString(), value, operation), EquipmentSlot.MAINHAND);
						} else {
							System.out.println("Warning: Attempted to add an attribute modifier for a non-existent attribute: " + attrKey);
						}
					}
				}
			}
		}
	}
}
