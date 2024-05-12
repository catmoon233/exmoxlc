package net.mcreator.exmoxl.procedures;

import net.mcreator.exmoxl.ExmoxlMod;
import net.mcreator.exmoxl.TalentList;
import net.mcreator.exmoxl.network.ExmoxlModVariables;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerEvent;

import javax.annotation.Nullable;
import javax.swing.text.html.parser.Entity;
import java.util.List;
import java.util.Map;

@Mod.EventBusSubscriber
public class ReSpawnTalentSetProcedure {
	@SubscribeEvent
	public static void onPlayerRespawned(PlayerEvent.PlayerRespawnEvent event) {
		Player entity = event.getEntity();
		List<TalentList.Talent> talents = TalentList.TalentCList;
		Map<String, Integer> Sectf;
		Sectf = (entity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ExmoxlModVariables.PlayerVariables())).TalentSz;
		List<Integer> Secint = (entity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ExmoxlModVariables.PlayerVariables())).TalentSz2;
		Level world = entity.level();
		List<String> tl = (entity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ExmoxlModVariables.PlayerVariables())).SelectTalent;
		if (
				!((LevelAccessor) entity.level()).isClientSide()
		) {
			//ExmoxlMod.LOGGER.debug("hiii");
			entity.closeContainer();
			((ServerPlayer) entity).setGameMode(GameType.SURVIVAL);
			for (int i = 0; i < talents.size(); i++){
				if (Sectf.containsKey(talents.get(i).displayname)) {
					if (TalentList.onsec(talents.get(i), entity,Sectf.get(talents.get(i).displayname)) != null) {
//							ExmoxlMod.LOGGER.debug(talents.get(i).displayname);
						TalentList.onsec(talents.get(i), entity,Sectf.get(talents.get(i).displayname)).run();
					}


				}
			}
		}

	}

}
