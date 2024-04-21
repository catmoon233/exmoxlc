package net.mcreator.exmoxl.procedures;
import net.mcreator.exmoxl.network.ExmoxlModVariables;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.mcreator.exmoxl.network.ExmoxlModVariables;
import javax.annotation.Nullable;
import net.minecraft.world.entity.LivingEntity;
import net.mcreator.exmoxl.Capmap;
import java.util.UUID;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import java.util.HashMap;
import java.util.Map;
@Mod.EventBusSubscriber
public class OnmobdeathProcedure {
public static void changeisboss(UUID uuid ,boolean is){
Capmap.isboss.put(uuid,is);
	}
/*public static void changecitiao(UUID uuid ,String st){
Capmap.citiao.put(uuid,st);
	}*/	
	
public static void changecitiao(UUID uuid ,String st, LevelAccessor world){
ExmoxlModVariables.MapVariables.get(world).bossstring.put(uuid,st);
ExmoxlModVariables.MapVariables.get(world).syncData(world);

	}	
/*public static void deletedm (Map<UUID,String> map = new HashMap<UUID,String>()){

for (UUID key : map.keySet()) {
 if(){}
}
	}*/
	@SubscribeEvent
	public static void onEntityDeath(LivingDeathEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event,event.getEntity());
		}
	}


	private static void execute(@Nullable Event event, LivingEntity le) {
	
LevelAccessor world = le.level();
	if(ExmoxlModVariables.MapVariables.get(world).bossstring.containsKey(le.getUUID()))
{

ExmoxlModVariables.MapVariables.get(world).bossstring.remove(le.getUUID());
	}

}}
