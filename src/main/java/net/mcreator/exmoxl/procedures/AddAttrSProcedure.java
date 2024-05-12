package net.mcreator.exmoxl.procedures;

import net.mcreator.exmoxl.init.ExmoxlModAttributes;
import net.mcreator.exmoxl.network.ExmoxlModVariables;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.UUID;

public class AddAttrSProcedure {
	public static void addStr(LivingEntity entity,int addnum) {
		((LivingEntity) entity).getAttribute(ExmoxlModAttributes.STRENGTH.get()).setBaseValue((((LivingEntity) entity).getAttribute(ExmoxlModAttributes.STRENGTH.get()).getValue() + addnum));
		((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE).removePermanentModifier((new AttributeModifier(UUID.fromString("01d39f67-32f1-420d-b0fb-76d884db52e8"), "\u521D\u59CB\u653B\u51FB",
				((entity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ExmoxlModVariables.PlayerVariables())).playerattack - addnum), AttributeModifier.Operation.ADDITION)).getId());
		{
			double _setval = (entity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ExmoxlModVariables.PlayerVariables())).playerattack + addnum;
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
			double _setval = (entity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ExmoxlModVariables.PlayerVariables())).playermaxhealth + 3*addnum;
			entity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.playermaxhealth = _setval;
				capability.syncPlayerVariables(entity);
			});
		}

		if (!(((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).hasModifier((new AttributeModifier(UUID.fromString("01d39f67-32f1-420d-b0fb-76d884db52e9"), "\u521D\u59CB\u751F\u547D",
				((entity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ExmoxlModVariables.PlayerVariables())).playermaxhealth - 20), AttributeModifier.Operation.ADDITION)))))
			((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).addPermanentModifier((new AttributeModifier(UUID.fromString("01d39f67-32f1-420d-b0fb-76d884db52e9"), "\u521D\u59CB\u751F\u547D",
					((entity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ExmoxlModVariables.PlayerVariables())).playermaxhealth - 20), AttributeModifier.Operation.ADDITION)));
	}

	public static void addAgi(LivingEntity entity,int addnum) {
		((LivingEntity) entity).getAttribute(ExmoxlModAttributes.SPRITATTACK.get())
				.setBaseValue((((LivingEntity) entity).getAttribute(ExmoxlModAttributes.SPRITATTACK.get()).getValue() - 2.5 * ((LivingEntity) entity).getAttribute(ExmoxlModAttributes.INTELLIGENCE.get()).getValue()));
		((LivingEntity) entity).getAttribute(ExmoxlModAttributes.SPIRIT.get())
				.setBaseValue((((LivingEntity) entity).getAttribute(ExmoxlModAttributes.SPIRIT.get()).getValue() - 25 * ((LivingEntity) entity).getAttribute(ExmoxlModAttributes.INTELLIGENCE.get()).getValue()));
		((LivingEntity) entity).getAttribute(ExmoxlModAttributes.INTELLIGENCE.get()).setBaseValue((((LivingEntity) entity).getAttribute(ExmoxlModAttributes.INTELLIGENCE.get()).getValue() + addnum));
		((LivingEntity) entity).getAttribute(ExmoxlModAttributes.SPRITATTACK.get())
				.setBaseValue((((LivingEntity) entity).getAttribute(ExmoxlModAttributes.SPRITATTACK.get()).getValue() + 2.5 * ((LivingEntity) entity).getAttribute(ExmoxlModAttributes.INTELLIGENCE.get()).getValue()));
		((LivingEntity) entity).getAttribute(ExmoxlModAttributes.SPIRIT.get())
				.setBaseValue((((LivingEntity) entity).getAttribute(ExmoxlModAttributes.SPIRIT.get()).getValue() + 25 * ((LivingEntity) entity).getAttribute(ExmoxlModAttributes.INTELLIGENCE.get()).getValue()));
	}

	public static void addAGA(LivingEntity entity,int addnum) {
		((LivingEntity) entity).getAttribute(ExmoxlModAttributes.AGILE.get()).setBaseValue((((LivingEntity) entity).getAttribute(ExmoxlModAttributes.AGILE.get()).getValue() + addnum));
		if (((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_SPEED).hasModifier((new AttributeModifier(UUID.fromString("98f541b9-26e8-46ed-910b-3bc53889a460"),
				"\u5929\u8D4B\u70B9\u653B\u51FB\u901F\u5EA6", (0.01 * (((LivingEntity) entity).getAttribute(ExmoxlModAttributes.AGILE.get()).getValue() - addnum)), AttributeModifier.Operation.ADDITION)))) {
			((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_SPEED).removePermanentModifier((new AttributeModifier(UUID.fromString("98f541b9-26e8-46ed-910b-3bc53889a460"),
					"\u5929\u8D4B\u70B9\u653B\u51FB\u901F\u5EA6", (0.01 * (((LivingEntity) entity).getAttribute(ExmoxlModAttributes.AGILE.get()).getValue() - addnum)), AttributeModifier.Operation.ADDITION)).getId());
			if (!(((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_SPEED).hasModifier((new AttributeModifier(UUID.fromString("98f541b9-26e8-46ed-910b-3bc53889a460"),
					"\u5929\u8D4B\u70B9\u653B\u51FB\u901F\u5EA6", (0.01 * ((LivingEntity) entity).getAttribute(ExmoxlModAttributes.AGILE.get()).getValue()), AttributeModifier.Operation.ADDITION)))))
				((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_SPEED).addPermanentModifier((new AttributeModifier(UUID.fromString("98f541b9-26e8-46ed-910b-3bc53889a460"),
						"\u5929\u8D4B\u70B9\u653B\u51FB\u901F\u5EA6", (0.01 * ((LivingEntity) entity).getAttribute(ExmoxlModAttributes.AGILE.get()).getValue()), AttributeModifier.Operation.ADDITION)));
		}
		if (((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED).hasModifier((new AttributeModifier(UUID.fromString("98f541b9-26e8-46ed-910b-3bc53889a461"), "\u79FB\u52A8\u901F\u5EA6",
				(0.001 * (((LivingEntity) entity).getAttribute(ExmoxlModAttributes.AGILE.get()).getValue() - addnum)), AttributeModifier.Operation.ADDITION)))) {
			((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED).removePermanentModifier((new AttributeModifier(UUID.fromString("98f541b9-26e8-46ed-910b-3bc53889a461"),
					"\u79FB\u52A8\u901F\u5EA6", (0.001 * (((LivingEntity) entity).getAttribute(ExmoxlModAttributes.AGILE.get()).getValue() - addnum)), AttributeModifier.Operation.ADDITION)).getId());
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



