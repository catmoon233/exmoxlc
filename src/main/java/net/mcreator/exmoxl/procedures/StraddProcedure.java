package net.mcreator.exmoxl.procedures;

import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.exmoxl.network.ExmoxlModVariables;
import net.mcreator.exmoxl.init.ExmoxlModAttributes;

import java.util.UUID;

public class StraddProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ExmoxlModVariables.PlayerVariables())).tfd > 0) {
			((LivingEntity) entity).getAttribute(ExmoxlModAttributes.STRENGTH.get()).setBaseValue((((LivingEntity) entity).getAttribute(ExmoxlModAttributes.STRENGTH.get()).getValue() + 1));
			((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE).removePermanentModifier((new AttributeModifier(UUID.fromString("01d39f67-32f1-420d-b0fb-76d884db52e8"), "\u521D\u59CB\u653B\u51FB",
					((entity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ExmoxlModVariables.PlayerVariables())).playerattack - 1), AttributeModifier.Operation.ADDITION)).getId());
			{
				double _setval = (entity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ExmoxlModVariables.PlayerVariables())).playerattack + 1;
				entity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.playerattack = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (!(((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE).hasModifier((new AttributeModifier(UUID.fromString("01d39f67-32f1-420d-b0fb-76d884db52e8"), "\u521D\u59CB\u653B\u51FB",
					((entity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ExmoxlModVariables.PlayerVariables())).playerattack - 1), AttributeModifier.Operation.ADDITION)))))
				((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE).addPermanentModifier((new AttributeModifier(UUID.fromString("01d39f67-32f1-420d-b0fb-76d884db52e8"), "\u521D\u59CB\u653B\u51FB",
						((entity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ExmoxlModVariables.PlayerVariables())).playerattack - 1), AttributeModifier.Operation.ADDITION)));
			((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).removePermanentModifier((new AttributeModifier(UUID.fromString("01d39f67-32f1-420d-b0fb-76d884db52e9"), "\u521D\u59CB\u751F\u547D",
					((entity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ExmoxlModVariables.PlayerVariables())).playermaxhealth - 20), AttributeModifier.Operation.ADDITION)).getId());
			{
				double _setval = (entity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ExmoxlModVariables.PlayerVariables())).playermaxhealth + 3;
				entity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.playermaxhealth = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (!(((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).hasModifier((new AttributeModifier(UUID.fromString("01d39f67-32f1-420d-b0fb-76d884db52e9"), "\u521D\u59CB\u751F\u547D",
					((entity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ExmoxlModVariables.PlayerVariables())).playermaxhealth - 20), AttributeModifier.Operation.ADDITION)))))
				((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).addPermanentModifier((new AttributeModifier(UUID.fromString("01d39f67-32f1-420d-b0fb-76d884db52e9"), "\u521D\u59CB\u751F\u547D",
						((entity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ExmoxlModVariables.PlayerVariables())).playermaxhealth - 20), AttributeModifier.Operation.ADDITION)));
			{
				double _setval = (entity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ExmoxlModVariables.PlayerVariables())).tfd - 1;
				entity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.tfd = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
