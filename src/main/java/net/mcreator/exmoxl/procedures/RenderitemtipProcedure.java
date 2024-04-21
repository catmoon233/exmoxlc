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
public class RenderitemtipProcedure {
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
		if (itemstack.getOrCreateTag().getDouble("isdark") > 0) {
			tooltip.add(Component.literal(("\u00A7l\u00A77\u7194\u70B9:" + itemstack.getOrCreateTag().getDouble("melting_point") + "\u2103")));
			tooltip.add(Component.literal(("\u00A7l\u00A77\u97E7\u6027:" + itemstack.getOrCreateTag().getDouble("toughness"))));
			tooltip.add(Component.literal(("\u00A7l\u00A77\u5F3A\u5EA6:" + itemstack.getOrCreateTag().getDouble("strength"))));
			tooltip.add(Component.literal(("\u00A7l\u00A77\u786C\u5EA6:" + itemstack.getOrCreateTag().getDouble("hardness"))));
		}
	}
}
