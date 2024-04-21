
package net.mcreator.exmoxl.item;

import software.bernie.geckolib.util.GeckoLibUtil;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animatable.GeoItem;

import net.minecraftforge.client.extensions.common.IClientItemExtensions;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.network.chat.Component;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.network.chat.Component;
import net.mcreator.exmoxl.procedures.Asksky2YouJiKongQiShiShiTiDeWeiZhiProcedure;
import net.mcreator.exmoxl.procedures.Asksky2TeShuXinXiProcedure;
import net.mcreator.exmoxl.item.renderer.Asksky2ItemRenderer;

import java.util.function.Consumer;
import java.util.List;

import com.google.common.collect.Multimap;
import com.google.common.collect.ImmutableMultimap;

public class Asksky2Item extends SwordItem implements GeoItem {
	private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
	public String animationprocedure = "empty";
	public static ItemDisplayContext transformType;
    public Asksky2Item() {
        super(new Tier() {
            public int getUses() {
                return 14000;
            }

            public float getSpeed() {
                return 4f;
            }

            public float getAttackDamageBonus() {
                return 48f;
            }

            public int getLevel() {
                return 1;
            }

            public int getEnchantmentValue() {
                return 30;
            }

            public Ingredient getRepairIngredient() {
                return Ingredient.of();
            }
        }, 3, -1.8f, new Item.Properties());
    }

	@Override
	public void initializeClient(Consumer<IClientItemExtensions> consumer) {
		super.initializeClient(consumer);
		consumer.accept(new IClientItemExtensions() {
			private final BlockEntityWithoutLevelRenderer renderer = new Asksky2ItemRenderer();

			@Override
			public BlockEntityWithoutLevelRenderer getCustomRenderer() {
				return renderer;
			}
		});
	}

	public void getTransformType(ItemDisplayContext type) {
		this.transformType = type;
	}

	private PlayState idlePredicate(AnimationState event) {
		if (this.transformType != null ? true : false) {
			if (this.animationprocedure.equals("empty")) {
				event.getController().setAnimation(RawAnimation.begin().thenLoop("skill1"));
				return PlayState.CONTINUE;
			}
		}
		return PlayState.STOP;
	}

	private PlayState procedurePredicate(AnimationState event) {
		if (this.transformType != null ? true : false) {
			if (!(this.animationprocedure.equals("empty")) && event.getController().getAnimationState() == AnimationController.State.STOPPED) {
				event.getController().setAnimation(RawAnimation.begin().thenPlay(this.animationprocedure));
				if (event.getController().getAnimationState() == AnimationController.State.STOPPED) {
					this.animationprocedure = "empty";
					event.getController().forceAnimationReset();
				}
			}
		}
		return PlayState.CONTINUE;
	}

	@Override
	public void registerControllers(AnimatableManager.ControllerRegistrar data) {
		AnimationController procedureController = new AnimationController(this, "procedureController", 0, this::procedurePredicate);
		data.add(procedureController);
		AnimationController idleController = new AnimationController(this, "idleController", 0, this::idlePredicate);
		data.add(idleController);
	}

	@Override
	public AnimatableInstanceCache getAnimatableInstanceCache() {
		return this.cache;
	}


	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		Entity entity = itemstack.getEntityRepresentation();
		double x = entity != null ? entity.getX() : 0.0;
		double y = entity != null ? entity.getY() : 0.0;
		double z = entity != null ? entity.getZ() : 0.0;
		list.add(Component.literal(Asksky2TeShuXinXiProcedure.execute()));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		ItemStack itemstack = ar.getObject();
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();

		Asksky2YouJiKongQiShiShiTiDeWeiZhiProcedure.execute(world, x, y, z, entity,itemstack);
		return ar;
	}
}
