package net.mcreator.exmoxl.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.exmoxl.network.ExmoxlModVariables;

public class TfdsxProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "\u53EF\u7528\u5929\u8D4B\u70B9\u6570\uFF1A" + (entity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ExmoxlModVariables.PlayerVariables())).tfd;
	}
}
