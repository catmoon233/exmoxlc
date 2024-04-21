package net.mcreator.exmoxl.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.exmoxl.network.ExmoxlModVariables;

public class RamdomkaProcedure {
	public static double execute(Entity entity) {
		if (entity == null)
			return 0;
		double re = 0;
		{
			double _setval = (entity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ExmoxlModVariables.PlayerVariables())).f1chn + 1;
			entity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.f1chn = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		if ((entity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ExmoxlModVariables.PlayerVariables())).f1chn == 90) {
			{
				double _setval = 0;
				entity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.f1chn = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			re = 4;
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "loot give @s loot exmoxl:yellowweapon");
				}
			}
		} else {
			if (Math.random() < 0.0006 * (entity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ExmoxlModVariables.PlayerVariables())).f1chn) {
				{
					double _setval = 0;
					entity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.f1chn = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				re = 4;
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "loot give @s loot exmoxl:yellowweapon");
					}
				}
			} else {
				if (Math.round((entity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ExmoxlModVariables.PlayerVariables())).f1chn
						/ 10) == (entity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ExmoxlModVariables.PlayerVariables())).f1chn / 10) {
					re = 3;
					{
						Entity _ent = entity;
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
									_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "loot give @s loot exmoxl:purpurweapon");
						}
					}
				} else {
					if (Math.random() < 0.1) {
						re = 3;
					} else {
						if (Math.random() < 0.7) {
							{
								Entity _ent = entity;
								if (!_ent.level().isClientSide() && _ent.getServer() != null) {
									_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null,
											4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "loot give @s loot exmoxl:blueweapon");
								}
							}
							re = 2;
						} else {
							re = 1;
						}
					}
				}
			}
		}
		return re;
	}
}
