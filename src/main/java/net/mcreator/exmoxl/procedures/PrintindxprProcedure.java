package net.mcreator.exmoxl.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.exmoxl.network.ExmoxlModVariables;
public class PrintindxprProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player && !_player.level().isClientSide())
_player.displayClientMessage(Component.literal(String.valueOf(ExmoxlModVariables.MapVariables.get(entity.level()).bossstring.size())), false);
	}
}
