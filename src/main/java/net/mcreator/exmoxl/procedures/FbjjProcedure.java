package net.mcreator.exmoxl.procedures;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraftforge.registries.ForgeRegistries;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

import javax.annotation.Nullable;
import net.minecraft.world.entity.EquipmentSlot;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;
import net.minecraft.world.phys.Vec2;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.attributes.Attributes;



import java.util.stream.Collectors;
import java.util.List;
import java.util.Comparator;
import java.util.Random;
import net.minecraft.server.level.ServerLevel;
import dev.xkmc.l2library.init.events.GeneralEventHandler;
public class FbjjProcedure {
    private static void spawnSweepAttackParticle(Entity entity) {
        if (!entity.level().isClientSide && entity.getServer() != null) {
            String particleCommand = String.format("particle minecraft:sweep_attack %s %s %s 0 0 0 2 1", entity.getX(), entity.getY() + 1, entity.getZ());
					entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(entity.getX(), entity.getY(), entity.getZ()), Vec2.ZERO, (ServerLevel)entity.level(), 4, "", Component.literal(""), entity.getServer(), null).withSuppressedOutput(), particleCommand);

        }
    }

    public static void execute(Entity sourceentity, ItemStack itemstack, double x, double y, double z) {
        if (sourceentity == null)
            return;
           double attackDamage = itemstack.getAttributeModifiers(EquipmentSlot.MAINHAND).get(Attributes.ATTACK_DAMAGE).stream()
					.mapToDouble(attributeModifier -> attributeModifier.getAmount()).sum();

		if (itemstack.getOrCreateTag().getDouble("lq") > 0){itemstack.getOrCreateTag().putDouble("lq", itemstack.getOrCreateTag().getDouble("lq")-1);}
        if (itemstack.getOrCreateTag().getDouble("lq") == 0) {
            itemstack.getOrCreateTag().putDouble("lq", 2);
            final Vec3 center = new Vec3(x, y, z);
List<Entity> foundEntities = sourceentity.level().getEntitiesOfClass(Entity.class,
        new AABB(center, center).inflate(8 / 2d), e -> e instanceof LivingEntity && e != sourceentity)
        .stream()
        .filter(e -> ((LivingEntity) e).getHealth() > 0)  // 只选择生命值大于0的实体
        .sorted(Comparator.comparingDouble(e -> e.distanceToSqr(center)))
        .collect(Collectors.toList());

            if (foundEntities.size() > 0) {
                // 对第一个目标应用武器25%伤害
                Entity firstTarget = foundEntities.get(0);
        
                if (firstTarget instanceof LivingEntity) {
                 float damage = (float)(attackDamage*0.25);

                    spawnSweepAttackParticle(firstTarget);

                      GeneralEventHandler.schedule(()->((LivingEntity) firstTarget).hurt(new DamageSource(sourceentity.level().registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MAGIC)), damage));
                }

                if (foundEntities.size() > 1) {
                    // 随机选择一个目标应用额外的武器50%伤害
                    Random random = new Random();
                    int randomIndex = random.nextInt(foundEntities.size());
                    Entity randomTarget = foundEntities.get(randomIndex);
                    if (randomTarget instanceof LivingEntity) {
                        float additionalDamage = (float)(attackDamage *0.5);

                        spawnSweepAttackParticle(randomTarget);         
                      GeneralEventHandler.schedule(()->((LivingEntity)randomTarget).hurt(new DamageSource(sourceentity.level().registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MAGIC)), additionalDamage));


                    }
                }
            }
        }
    }
}
