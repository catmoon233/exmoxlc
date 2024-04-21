package net.mcreator.exmoxl.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.network.chat.Component;

import net.mcreator.exmoxl.entity.AsEntity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class AsDangShiTiShouShangShiProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingHurtEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getSource(), event.getEntity(), event.getAmount());
		}
	}

	public static void execute(LevelAccessor world, DamageSource damagesource, Entity entity, double amount) {
		execute(null, world, damagesource, entity, amount);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, DamageSource damagesource, Entity entity, double amount) {
		if (damagesource == null || entity == null)
			return;
		if (entity instanceof AsEntity) {
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("\u53D7\u4F24\u4E8B\u4EF6:" + damagesource + amount)), false);
		}
	}
}
