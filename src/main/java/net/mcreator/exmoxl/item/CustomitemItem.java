
package net.mcreator.exmoxl.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.network.chat.Component;

import java.util.List;

public class CustomitemItem extends Item {
	public CustomitemItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		//this.setTexturePath("items/your_item_texture_name"); // 这部分取决于具体的模组API，有的模组API可能没有直接设置纹理的方法，需要在JSON文件中配置。
	}
}
