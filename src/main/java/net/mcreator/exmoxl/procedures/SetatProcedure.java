package net.mcreator.exmoxl.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.CommandSourceStack;

import net.mcreator.exmoxl.network.ExmoxlModVariables;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class SetatProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments) {
		{
			double _setval = DoubleArgumentType.getDouble(arguments, "name");
			(new Object() {
				public Entity getEntity() {
					try {
						return EntityArgument.getEntity(arguments, "name");
					} catch (CommandSyntaxException e) {
						e.printStackTrace();
						return null;
					}
				}
			}.getEntity()).getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.playerattack = _setval;
				capability.syncPlayerVariables((new Object() {
					public Entity getEntity() {
						try {
							return EntityArgument.getEntity(arguments, "name");
						} catch (CommandSyntaxException e) {
							e.printStackTrace();
							return null;
						}
					}
				}.getEntity()));
			});
		}
	}
}
