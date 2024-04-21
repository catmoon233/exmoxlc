package net.mcreator.exmoxl.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.exmoxl.procedures.ReadaxeacProcedure;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.mcreator.exmoxl.init.ExmoxlModAttributes;
import net.minecraft.resources.ResourceLocation;
import java.util.Map;
import java.util.Iterator;
import java.util.Map.Entry;
import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.ArrayList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.exmoxl.init.ExmoxlModAttributes;

import javax.annotation.Nullable;

import java.util.List;

@Mod.EventBusSubscriber
public class AxeitemaProcedure {
public static class jh {
    public String v1; // remove static keyword
    public String v2; // remove static keyword
    public double v3; // remove static keyword
}

	public static List<jh> jhList = new ArrayList<>();
	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public static void onItemTooltip(ItemTooltipEvent event) {
		execute(event, event.getEntity(), event.getItemStack(), event.getToolTip());
	}

	public static void execute(Entity entity, ItemStack itemstack, List<Component> tooltip) {
		execute(null, entity, itemstack, tooltip);
	}
private static void execute(@Nullable Event event, Entity entity, ItemStack itemstack, List<Component> tooltip) {
    if (entity == null || tooltip == null) {
        return;
    }

    // 创建斧和剑类资质对象
// 创建斧和剑类资质对象
jh axe = new jh();
axe.v1 = "Axea";
axe.v2 = "斧类兵器资质";
axe.v3 = ((LivingEntity) entity).getAttribute(ExmoxlModAttributes.AXEAPTITUDE.get()).getValue();

jh sword = new jh();
sword.v1 = "Sworda";
sword.v2 = "剑类兵器资质";
sword.v3 = ((LivingEntity) entity).getAttribute(ExmoxlModAttributes.SWORDAPTITUDE.get()).getValue();

jh stick = new jh();
stick.v1 = "Sticka";
stick.v2 = "棍类兵器资质";
stick.v3 = ((LivingEntity) entity).getAttribute(ExmoxlModAttributes.STICKAPTITUDE.get()).getValue();

jh knife = new jh();
knife.v1 = "Knifea";
knife.v2 = "刀类兵器资质";
knife.v3 = ((LivingEntity) entity).getAttribute(ExmoxlModAttributes.KNIFEAPTITUDE.get()).getValue();

jh LightWeapons = new jh();
LightWeapons.v1 = "LightWeaponsa";
LightWeapons.v2 = "轻型兵器类资质";
LightWeapons.v3 = ((LivingEntity) entity).getAttribute(ExmoxlModAttributes.LIGHTWEAPONSAPTITUDE.get()).getValue();

jh AtomicTank = new jh();
AtomicTank.v1 = "AtomicTanka";
AtomicTank.v2 = "重型兵器类资质";
AtomicTank.v3 = ((LivingEntity) entity).getAttribute(ExmoxlModAttributes.ATOMICTANKAPTITUDE.get()).getValue();

jh LongWeapons = new jh();
LongWeapons.v1 = "LongWeaponsa";
LongWeapons.v2 = "长型类兵器资质";
LongWeapons.v3 = ((LivingEntity) entity).getAttribute(ExmoxlModAttributes.LONGWEAPONAPTITUDE.get()).getValue();

jh ShortWeapons = new jh();
ShortWeapons.v1 = "ShortWeaponsa";
ShortWeapons.v2 = "短型类兵器资质";
ShortWeapons.v3 = ((LivingEntity) entity).getAttribute(ExmoxlModAttributes.SHORTWEAPONAPTITUDE.get()).getValue();

jh RemoteWeapons = new jh();
RemoteWeapons.v1 = "RemoteWeaponsa";
RemoteWeapons.v2 = "远程类兵器资质";
RemoteWeapons.v3 = ((LivingEntity) entity).getAttribute(ExmoxlModAttributes.REMOTEWEAPONSAPTITUDE.get()).getValue();

    jhList.clear();
    jhList.add(knife);
    jhList.add(stick);
    jhList.add(axe);
    jhList.add(sword);
    jhList.add(LightWeapons);
    jhList.add(AtomicTank);
    jhList.add(LongWeapons);
    jhList.add(ShortWeapons);
    jhList.add(RemoteWeapons);
    
    

    // 获取工具资质的映射
    Map<String, Map<String, Integer>> axeItemaMap = ReadaxeacProcedure.toolitema;
    if (axeItemaMap == null) {
        return;
    }

    ResourceLocation itemResourceLocation = ForgeRegistries.ITEMS.getKey(itemstack.getItem());
    if (itemResourceLocation == null) {
        return;
    }
    String itemResourceLocationString = itemResourceLocation.toString();

    Map<String, Integer> itemProperties = axeItemaMap.get(itemResourceLocationString);
    if (itemProperties != null) {
        itemProperties.forEach((propertyName, requiredValue) -> {
            jhList.stream()
                    .filter(jhItem -> propertyName.equals(jhItem.v1))
                    .findFirst()
                    .ifPresent(jhItem -> {
                        String tooltipText = (jhItem.v3 >= requiredValue) ?
                                String.format("§f§l √ 需要 §a%d §f§l%s", requiredValue, jhItem.v2) :
                                String.format("§8§l × 需要 §l§4%d §8§l%s", requiredValue, jhItem.v2);
                        tooltip.add(Component.literal(tooltipText));
                    });
        });
    }
}
}
