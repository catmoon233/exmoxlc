
package net.mcreator.exmoxl.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.network.chat.Component;

import net.mcreator.exmoxl.procedures.DnzYouJiFangKuaiShiFangKuaiDeWeiZhiProcedure;
import net.mcreator.exmoxl.procedures.DnzShiTiBeiGongJuJiZhongShiProcedure;
import net.mcreator.exmoxl.procedures.DnzGongJuChuXianZaiShouZhongShiMeiKeFaShengProcedure;

import java.util.List;

public class DnzItem extends SwordItem {
	public DnzItem() {
		super(new Tier() {
			public int getUses() {
				return 10000;
			}

			public float getSpeed() {
				return 0f;
			}

			public float getAttackDamageBonus() {
				return 19f;
			}

			public int getLevel() {
				return 0;
			}

			public int getEnchantmentValue() {
				return 0;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of();
			}
		}, 3, -2.2f, new Item.Properties());
	}

	@Override
	public boolean hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
		boolean retval = super.hurtEnemy(itemstack, entity, sourceentity);
		DnzShiTiBeiGongJuJiZhongShiProcedure.execute(itemstack);
		return retval;
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		DnzYouJiFangKuaiShiFangKuaiDeWeiZhiProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, ar.getObject());
		return ar;
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		if (selected)
			DnzGongJuChuXianZaiShouZhongShiMeiKeFaShengProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), itemstack);
	}
}
