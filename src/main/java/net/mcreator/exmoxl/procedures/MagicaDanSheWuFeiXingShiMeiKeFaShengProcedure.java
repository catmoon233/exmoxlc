package net.mcreator.exmoxl.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.exmoxl.entity.MagicaEntity;

import java.util.List;
import java.util.Comparator;

public class MagicaDanSheWuFeiXingShiMeiKeFaShengProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity immediatesourceentity) {
		if (entity == null || immediatesourceentity == null)
			return;
		((Projectile) immediatesourceentity).setNoGravity(true);
		if (!(immediatesourceentity.getPersistentData().getDouble("livetime") > 1)) {
			immediatesourceentity.getPersistentData().putDouble("livetime", 100);
		}
		if (immediatesourceentity.getPersistentData().getDouble("livetime") > 1) {
			immediatesourceentity.getPersistentData().putDouble("livetime", (immediatesourceentity.getPersistentData().getDouble("livetime") - 1));
		}
		if (immediatesourceentity.getPersistentData().getDouble("livetime") == 1) {
			{
				Entity _ent = immediatesourceentity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "kill");
				}
			}
		}
		if (!immediatesourceentity.getPersistentData().getBoolean("ismz")) {
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (!(entityiterator == immediatesourceentity)) {
						if (!(entityiterator == entity)) {
							if (!(entityiterator instanceof MagicaEntity)) {
								if (world instanceof ServerLevel _level) {
									_level.getServer().getCommands()
											.performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(0, 0, 0), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(), "execute as "
													+ entityiterator.getStringUUID() + " at " + entityiterator.getStringUUID() + " anchored feet run particle " + "LAVA".replaceAll("(?i)CUSTOM:", "exmoxl:").toLowerCase() + " ~ ~1 ~ 0 0 0 0.00001 10");
								}
								entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("exmoxl:firedamage"))),
										immediatesourceentity, entity), 10);
							}
						}
					}
				}
			}
		}
	}
}
