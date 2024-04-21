package net.mcreator.exmoxl.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.exmoxl.network.ExmoxlModVariables;

public class Textofchou2Procedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "\u6781\u00B7\u88C2\u7269:" + Math.round((entity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ExmoxlModVariables.PlayerVariables())).piao2);
	}
}
