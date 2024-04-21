package net.mcreator.exmoxl.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.Level;
import net.mcreator.exmoxl.network.ExmoxlModVariables;
import java.util.List;

public class TickbossProcedure {

    public static void execute(Player player) {
        // Get the level in which the player is present
    /*    Level world = player.getCommandSenderWorld();

        // Get the range in which to search for entities
        double range = 12.0;

        // Get the player's eye position and look vector
        Vec3 eyePosition = player.getEyePosition(0.75F);
        Vec3 lookVector = player.getViewVector(0.75F);

        // Calculate the end position by extending the look vector by the range
        Vec3 endPosition = eyePosition.add(lookVector.x * range, lookVector.y * range, lookVector.z * range);

        // Create an AABB around the end position to check for entities
        AABB aabb = new AABB(eyePosition, endPosition);

        // Get all entities within the AABB
        List<Entity> entities = world.getEntities(player, aabb, entity -> entity instanceof LivingEntity);

        // Closest entity and its squared distance (initialize with max value)
        Entity closestEntity = null;
        double closestDistanceSq = Double.MAX_VALUE;

        // Iterate over all entities to find the closest to the look vector
        for (Entity entity : entities) {
            // Skip if the entity is the player themselves
            if (entity == player) continue;

            // Calculate the squared distance to the player's look vector
            Vec3 entityPosition = entity.position();
            double distanceSq = eyePosition.distanceToSqr(entityPosition);

            // Check if this entity is closer than the current closest entity
            if (distanceSq < closestDistanceSq) {
                closestEntity = entity;
                closestDistanceSq = distanceSq;
            }
        }

        // Check if the closest entity is a living entity
        if (closestEntity instanceof LivingEntity) {
            // Here you can use your check. For example:
            if (closestEntity.getPersistentData().getBoolean("bossa")) {
                // Debug information

		
			player.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.islookbossabar = true;
				capability.syncPlayerVariables(player);
			});

            
        } 
        else {
		
			player.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.islookbossabar = false;
				capability.syncPlayerVariables(player);
			});

            
        	}


    }
*/}
}
