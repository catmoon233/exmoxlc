package net.mcreator.exmoxl.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;

import javax.annotation.Nullable;

import java.util.List;

@Mod.EventBusSubscriber
public class RendertoolqualityProcedure {
	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public static void onItemTooltip(ItemTooltipEvent event) {
		execute(event, event.getItemStack(), event.getToolTip());
	}

	public static void execute(ItemStack itemstack, List<Component> tooltip) {
		execute(null, itemstack, tooltip);
	}

	private static void execute(@Nullable Event event, ItemStack itemstack, List<Component> tooltip) {
		if (tooltip == null)
			return;
		if (itemstack.getOrCreateTag().getBoolean("isroll")) {
			if ((itemstack.getOrCreateTag().getString("ysattr")).equals("wood")) {
				tooltip.add(Component.literal("\u00A72\u6728\u5C5E\u6027"));
			}
			if ((itemstack.getOrCreateTag().getString("ysattr")).equals("water")) {
				tooltip.add(Component.literal("\u00A73\u6C34\u5C5E\u6027"));
			}
			if ((itemstack.getOrCreateTag().getString("ysattr")).equals("fire")) {
				tooltip.add(Component.literal("\u00A74\u706B\u5C5E\u6027"));
			}
			tooltip.add(Component.literal("\u00A77\u5F53\u524D\u7B49\u7EA7:"));
			tooltip.add(Component.literal(("\u00A77 " + itemstack.getOrCreateTag().getDouble("level") + "/" + itemstack.getOrCreateTag().getDouble("maxlevel"))));
			tooltip.add(Component.literal(("\u00A7l\u54C1\u8D28:" + itemstack.getOrCreateTag().getString("qua"))));
			tooltip.add(Component.literal("\u00A77\u5347\u7EA7\u7ECF\u9A8C:"));
			tooltip.add(Component.literal(("\u00A77 " + itemstack.getOrCreateTag().getDouble("xp") + "/" + itemstack.getOrCreateTag().getDouble("xpneed"))));
			tooltip.add(Component.literal(("\u00A77\u72EC\u6709\u8BCD\u6761:" + itemstack.getOrCreateTag().getString("roll2s"))));
			tooltip.add(Component.literal(("\u00A77\u6D17\u7EC3\u6B21\u6570:" + itemstack.getOrCreateTag().getDouble("zizhi"))));
			if (!(itemstack.getOrCreateTag().getString("roll4s1.0")).equals("")) {
				tooltip.add(Component.literal("\u00A77\u6838\u5FC3:"));
				tooltip.add(Component.literal(("\u00A77" + itemstack.getOrCreateTag().getString("roll4s1.0"))));
				if (!(itemstack.getOrCreateTag().getString("roll4s2.0")).equals("")) {
					tooltip.add(Component.literal(("\u00A77" + itemstack.getOrCreateTag().getString("roll4s2.0"))));
				}
				if (!(itemstack.getOrCreateTag().getString("roll4s3.0")).equals("")) {
					tooltip.add(Component.literal(("\u00A77" + itemstack.getOrCreateTag().getString("roll4s3.0"))));
				}
			}
		}
	}
}
