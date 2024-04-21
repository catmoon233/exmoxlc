package net.mcreator.exmoxl.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.exmoxl.network.ExmoxlModVariables;
import net.mcreator.exmoxl.init.ExmoxlModAttributes;

public class IgiaddProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ExmoxlModVariables.PlayerVariables())).tfd > 0) {
			((LivingEntity) entity).getAttribute(ExmoxlModAttributes.INTELLIGENCE.get()).setBaseValue((((LivingEntity) entity).getAttribute(ExmoxlModAttributes.INTELLIGENCE.get()).getValue() + 1));
			{
				double _setval = (entity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ExmoxlModVariables.PlayerVariables())).tfd - 1;
				entity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.tfd = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			((LivingEntity) entity).getAttribute(ExmoxlModAttributes.SPRITATTACK.get()).setBaseValue((((LivingEntity) entity).getAttribute(ExmoxlModAttributes.SPRITATTACK.get()).getValue() + 2.5));
			((LivingEntity) entity).getAttribute(ExmoxlModAttributes.SPIRIT.get()).setBaseValue((((LivingEntity) entity).getAttribute(ExmoxlModAttributes.SPIRIT.get()).getValue() + 25));
		}
	}
}
