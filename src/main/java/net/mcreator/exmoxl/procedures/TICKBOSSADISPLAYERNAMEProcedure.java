package net.mcreator.exmoxl.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.entity.LivingEntity;
import java.util.List;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.Level;
import net.mcreator.exmoxl.network.ExmoxlModVariables;
import net.minecraft.world.entity.Entity;

import javax.annotation.Nullable;


@Mod.EventBusSubscriber
public class TICKBOSSADISPLAYERNAMEProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player);
		}
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity2) {
	/*	if (entity2 == null)
			return;

        // Get the level in which the player is present
        Level world = entity2.level();

        // Get the range in which to search for entities
        double range = 12.0;

        // Get the player's eye position and look vector
        Vec3 eyePosition = entity2.getEyePosition(1F);
        Vec3 lookVector = entity2.getViewVector(1F);

        // Calculate the end position by extending the look vector by the range
        Vec3 endPosition = eyePosition.add(lookVector.x * range, lookVector.y * range, lookVector.z * range);

        // Create an AABB around the end position to check for entities
        AABB aabb = new AABB(eyePosition, endPosition);

        // Get all entities within the AABB
        List<Entity> entities = world.getEntities(entity2, aabb, entity -> entity instanceof LivingEntity);

        // Closest entity and its squared distance (initialize with max value)
        Entity closestEntity = null;
        double closestDistanceSq = Double.MAX_VALUE;

        // Iterate over all entities to find the closest to the look vector
        for (Entity entity : entities) {
            // Skip if the entity is the player themselves
            if (entity == entity2) continue;

            // Calculate the squared distance to the player's look vector
            Vec3 entityPosition = entity.position();
            double distanceSq = eyePosition.distanceToSqr(entityPosition);

            // Check if this entity is closer than the current closest entity
            if (distanceSq < closestDistanceSq) {
                closestEntity = entity;
                closestDistanceSq = distanceSq;
            }
        }
        if (closestEntity instanceof LivingEntity) {
            boolean isBoss = closestEntity.getPersistentData().getBoolean("bossa");
            String citiao = closestEntity.getPersistentData().getString("citiao");

            // 只有当生物是Boss并且citiao不为空时才进行操作
            if (isBoss && !citiao.isEmpty()) {
                Player player = (Player)entity2;
                ExmoxlModVariables.PlayerVariables playerVariables = player.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY)
                        .orElseGet(() -> new ExmoxlModVariables.PlayerVariables());

                String combinedName = citiao ;//+ closestEntity.getDisplayName().getString();
                if (!combinedName.equals(playerVariables.bossastring)) {
                    playerVariables.bossastring = combinedName;
                    playerVariables.syncPlayerVariables(player); // 假设syncPlayerVariables方法用于同步玩家的自定义变量
                }
            }
        }
        //return "";
    
		
	*/}
}
