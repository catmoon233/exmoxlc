package net.mcreator.exmoxl.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.player.AbstractClientPlayer;

import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationRegistry;
import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationAccess;
import dev.kosmx.playerAnim.api.layered.ModifierLayer;
import dev.kosmx.playerAnim.api.layered.KeyframeAnimationPlayer;
import dev.kosmx.playerAnim.api.layered.IAnimation;

public class OnattackProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (itemstack.getOrCreateTag().getDouble("attzt") == 0) {
			itemstack.getOrCreateTag().putDouble("attzt", 1);
		}
		if (itemstack.getOrCreateTag().getDouble("attzt") == 1) {
			if (itemstack.getOrCreateTag().getDouble("attzt2cq") == 0) {
				itemstack.getOrCreateTag().putDouble("attzt", 2);
				if (world.isClientSide()) {
					if (entity instanceof AbstractClientPlayer player) {
						var animation = (ModifierLayer<IAnimation>) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("exmoxl", "player_animation"));
						if (animation != null) {
							animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("exmoxl", "kann"))));
						}
					}
				}
				itemstack.getOrCreateTag().putDouble("attzt1cq", 24);
			}
		}
		if (itemstack.getOrCreateTag().getDouble("attzt") == 2) {
			if (itemstack.getOrCreateTag().getDouble("attzt1cq") == 0) {
				itemstack.getOrCreateTag().putDouble("attzt", 1);
				if (world.isClientSide()) {
					if (entity instanceof AbstractClientPlayer player) {
						var animation = (ModifierLayer<IAnimation>) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("exmoxl", "player_animation"));
						if (animation != null) {
							animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("exmoxl", "kannt"))));
						}
					}
				}
				itemstack.getOrCreateTag().putDouble("attzt2cq", 10);
			}
		}
	}
}
