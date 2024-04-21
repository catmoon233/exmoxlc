
package net.mcreator.exmoxl.item;

import top.theillusivec4.curios.api.type.capability.ICurioItem;
import top.theillusivec4.curios.api.SlotContext;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.network.chat.Component;

import net.mcreator.exmoxl.procedures.XumiRingDangZhuangBeiLiaoShiWuShiProcedure;
import net.mcreator.exmoxl.procedures.XumiRingDangMeiYouZhuangBeiShiWuShiProcedure;

import java.util.List;

public class XumiRingItem extends Item implements ICurioItem {
	public XumiRingItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.EPIC));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("\u00A77\u00A7l\u51CF\u5C11\u522B\u4EBA\u5BF9\u4F60\u768450%\u53CD\u4F24\u6982\u7387"));
	}

	@Override
	public void onEquip(SlotContext slotContext, ItemStack prevStack, ItemStack stack) {
		XumiRingDangZhuangBeiLiaoShiWuShiProcedure.execute(slotContext.entity());
	}

	@Override
	public void onUnequip(SlotContext slotContext, ItemStack newStack, ItemStack stack) {
		XumiRingDangMeiYouZhuangBeiShiWuShiProcedure.execute(slotContext.entity());
	}
}
