package net.mcreator.exmoxl.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.exmoxl.network.ExmoxlModVariables;

public class LevelxsProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "\u7B49\u7EA7:" + (entity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ExmoxlModVariables.PlayerVariables())).playerllvl;
	}
}
