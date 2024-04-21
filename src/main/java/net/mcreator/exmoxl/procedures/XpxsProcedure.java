package net.mcreator.exmoxl.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.exmoxl.network.ExmoxlModVariables;

public class XpxsProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return Math.floor((entity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ExmoxlModVariables.PlayerVariables())).playerxp) + " / "
				+ Math.floor((entity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ExmoxlModVariables.PlayerVariables())).playerupxp);
	}
}
