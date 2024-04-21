package net.mcreator.exmoxl.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerEvent;

import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.exmoxl.network.ExmoxlModVariables;

import javax.annotation.Nullable;

import java.util.UUID;

@Mod.EventBusSubscriber
public class FIRSTATTProcedure {
	@SubscribeEvent
	public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (!((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE).hasModifier((new AttributeModifier(UUID.fromString("01d39f67-32f1-420d-b0fb-76d884db52e8"), "\u521D\u59CB\u653B\u51FB",
				((entity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ExmoxlModVariables.PlayerVariables())).playerattack - 1), AttributeModifier.Operation.ADDITION)))) {
			if (!(((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).hasModifier((new AttributeModifier(UUID.fromString("01d39f67-32f1-420d-b0fb-76d884db52e9"), "\u521D\u59CB\u751F\u547D",
					((entity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ExmoxlModVariables.PlayerVariables())).playermaxhealth - 20), AttributeModifier.Operation.ADDITION)))))
				((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).addPermanentModifier((new AttributeModifier(UUID.fromString("01d39f67-32f1-420d-b0fb-76d884db52e9"), "\u521D\u59CB\u751F\u547D",
						((entity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ExmoxlModVariables.PlayerVariables())).playermaxhealth - 20), AttributeModifier.Operation.ADDITION)));
		}
		if (!((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).hasModifier((new AttributeModifier(UUID.fromString("01d39f67-32f1-420d-b0fb-76d884db52e9"), "\u521D\u59CB\u751F\u547D",
				((entity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ExmoxlModVariables.PlayerVariables())).playermaxhealth - 20), AttributeModifier.Operation.ADDITION)))) {
			if (!(((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE).hasModifier((new AttributeModifier(UUID.fromString("01d39f67-32f1-420d-b0fb-76d884db52e8"), "\u521D\u59CB\u653B\u51FB",
					((entity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ExmoxlModVariables.PlayerVariables())).playerattack - 1), AttributeModifier.Operation.ADDITION)))))
				((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE).addPermanentModifier((new AttributeModifier(UUID.fromString("01d39f67-32f1-420d-b0fb-76d884db52e8"), "\u521D\u59CB\u653B\u51FB",
						((entity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ExmoxlModVariables.PlayerVariables())).playerattack - 1), AttributeModifier.Operation.ADDITION)));
		}
	}
}
