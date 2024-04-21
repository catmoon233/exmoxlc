package net.mcreator.exmoxl.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.exmoxl.network.ExmoxlModVariables;

public class TextofchouProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "\u5F53\u524D\u62BD\u6570:" + Math.round((entity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ExmoxlModVariables.PlayerVariables())).f1chn);
	}
}
