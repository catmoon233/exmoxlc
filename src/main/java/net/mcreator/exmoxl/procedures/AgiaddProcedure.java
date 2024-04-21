package net.mcreator.exmoxl.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.exmoxl.network.ExmoxlModVariables;
import net.mcreator.exmoxl.init.ExmoxlModAttributes;

import java.util.UUID;

public class AgiaddProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ExmoxlModVariables.PlayerVariables())).tfd > 0) {
			((LivingEntity) entity).getAttribute(ExmoxlModAttributes.AGILE.get()).setBaseValue((((LivingEntity) entity).getAttribute(ExmoxlModAttributes.AGILE.get()).getValue() + 1));
			{
				double _setval = (entity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ExmoxlModVariables.PlayerVariables())).tfd - 1;
				entity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.tfd = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_SPEED).hasModifier((new AttributeModifier(UUID.fromString("98f541b9-26e8-46ed-910b-3bc53889a460"),
					"\u5929\u8D4B\u70B9\u653B\u51FB\u901F\u5EA6", (0.01 * (((LivingEntity) entity).getAttribute(ExmoxlModAttributes.AGILE.get()).getValue() - 1)), AttributeModifier.Operation.ADDITION)))) {
				((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_SPEED).removePermanentModifier((new AttributeModifier(UUID.fromString("98f541b9-26e8-46ed-910b-3bc53889a460"),
						"\u5929\u8D4B\u70B9\u653B\u51FB\u901F\u5EA6", (0.01 * (((LivingEntity) entity).getAttribute(ExmoxlModAttributes.AGILE.get()).getValue() - 1)), AttributeModifier.Operation.ADDITION)).getId());
				if (!(((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_SPEED).hasModifier((new AttributeModifier(UUID.fromString("98f541b9-26e8-46ed-910b-3bc53889a460"),
						"\u5929\u8D4B\u70B9\u653B\u51FB\u901F\u5EA6", (0.01 * ((LivingEntity) entity).getAttribute(ExmoxlModAttributes.AGILE.get()).getValue()), AttributeModifier.Operation.ADDITION)))))
					((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_SPEED).addPermanentModifier((new AttributeModifier(UUID.fromString("98f541b9-26e8-46ed-910b-3bc53889a460"),
							"\u5929\u8D4B\u70B9\u653B\u51FB\u901F\u5EA6", (0.01 * ((LivingEntity) entity).getAttribute(ExmoxlModAttributes.AGILE.get()).getValue()), AttributeModifier.Operation.ADDITION)));
			}
			if (((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED).hasModifier((new AttributeModifier(UUID.fromString("98f541b9-26e8-46ed-910b-3bc53889a461"), "\u79FB\u52A8\u901F\u5EA6",
					(0.001 * (((LivingEntity) entity).getAttribute(ExmoxlModAttributes.AGILE.get()).getValue() - 1)), AttributeModifier.Operation.ADDITION)))) {
				((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED).removePermanentModifier((new AttributeModifier(UUID.fromString("98f541b9-26e8-46ed-910b-3bc53889a461"),
						"\u79FB\u52A8\u901F\u5EA6", (0.001 * (((LivingEntity) entity).getAttribute(ExmoxlModAttributes.AGILE.get()).getValue() - 1)), AttributeModifier.Operation.ADDITION)).getId());
				if (!(((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED).hasModifier((new AttributeModifier(UUID.fromString("98f541b9-26e8-46ed-910b-3bc53889a461"), "\u79FB\u52A8\u901F\u5EA6",
						(0.001 * ((LivingEntity) entity).getAttribute(ExmoxlModAttributes.AGILE.get()).getValue()), AttributeModifier.Operation.ADDITION)))))
					((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED).addPermanentModifier((new AttributeModifier(UUID.fromString("98f541b9-26e8-46ed-910b-3bc53889a461"),
							"\u79FB\u52A8\u901F\u5EA6", (0.001 * ((LivingEntity) entity).getAttribute(ExmoxlModAttributes.AGILE.get()).getValue()), AttributeModifier.Operation.ADDITION)));
			}
			if (entity instanceof LivingEntity && ((LivingEntity) entity).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("attributeslib:arrow_damage"))) != null) {
				((LivingEntity) entity).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("attributeslib:arrow_damage")))
						.setBaseValue((((LivingEntity) entity).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("attributeslib:arrow_damage"))).getValue() + 1));
			}
		}
	}
}
