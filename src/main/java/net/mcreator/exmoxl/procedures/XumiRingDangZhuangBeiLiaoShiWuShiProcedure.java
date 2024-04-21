package net.mcreator.exmoxl.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.exmoxl.network.ExmoxlModVariables;

public class XumiRingDangZhuangBeiLiaoShiWuShiProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			boolean _setval = true;
			entity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.wearonxumiring = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
