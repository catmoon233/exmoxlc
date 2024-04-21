package net.mcreator.exmoxl.procedures;

import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;

import net.mcreator.exmoxl.network.ExmoxlModVariables;

public class ChangeclassProcedure {
	public static void execute(Entity entity,double abc) {
		if (entity == null)
			return;
		{
			double _setval = abc;
			entity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.classes = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		if (entity instanceof ServerPlayer _player)
			_player.setGameMode(GameType.SURVIVAL);
	}
}
