package net.mcreator.exmoxl.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.CommandSourceStack;

import net.mcreator.exmoxl.network.ExmoxlModVariables;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class TfdsetProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		if ((StringArgumentType.getString(arguments, "name3")).equals("set")) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("\u6210\u529F\u8BBE\u7F6E\u5929\u8D4B\u70B9:" + DoubleArgumentType.getDouble(arguments, "name"))), false);
			{
				double _setval = DoubleArgumentType.getDouble(arguments, "name");
				(new Object() {
					public Entity getEntity() {
						try {
							return EntityArgument.getEntity(arguments, "name2");
						} catch (CommandSyntaxException e) {
							e.printStackTrace();
							return null;
						}
					}
				}.getEntity()).getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.tfd = _setval;
					capability.syncPlayerVariables((new Object() {
						public Entity getEntity() {
							try {
								return EntityArgument.getEntity(arguments, "name2");
							} catch (CommandSyntaxException e) {
								e.printStackTrace();
								return null;
							}
						}
					}.getEntity()));
				});
			}
		}
		if ((StringArgumentType.getString(arguments, "name3")).equals("add")) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("\u6210\u529F\u589E\u52A0\u5929\u8D4B\u70B9:" + DoubleArgumentType.getDouble(arguments, "name"))), false);
			{
				double _setval = ((new Object() {
					public Entity getEntity() {
						try {
							return EntityArgument.getEntity(arguments, "name2");
						} catch (CommandSyntaxException e) {
							e.printStackTrace();
							return null;
						}
					}
				}.getEntity()).getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ExmoxlModVariables.PlayerVariables())).tfd + DoubleArgumentType.getDouble(arguments, "name");
				(new Object() {
					public Entity getEntity() {
						try {
							return EntityArgument.getEntity(arguments, "name2");
						} catch (CommandSyntaxException e) {
							e.printStackTrace();
							return null;
						}
					}
				}.getEntity()).getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.tfd = _setval;
					capability.syncPlayerVariables((new Object() {
						public Entity getEntity() {
							try {
								return EntityArgument.getEntity(arguments, "name2");
							} catch (CommandSyntaxException e) {
								e.printStackTrace();
								return null;
							}
						}
					}.getEntity()));
				});
			}
		}
		if ((StringArgumentType.getString(arguments, "name3")).equals("get")) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("\u5929\u8D4B\u70B9:" + ((new Object() {
					public Entity getEntity() {
						try {
							return EntityArgument.getEntity(arguments, "name2");
						} catch (CommandSyntaxException e) {
							e.printStackTrace();
							return null;
						}
					}
				}.getEntity()).getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ExmoxlModVariables.PlayerVariables())).tfd)), false);
		}
	}
}
