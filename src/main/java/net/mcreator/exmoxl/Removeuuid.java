package net.mcreator.exmoxl;

import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import net.minecraft.nbt.Tag;
public class Removeuuid {

public static void removeAttributeModifiersFromList(ItemStack itemStack, List<UUID> uuidsToRemove) {
    if (!itemStack.isEmpty()) {
        CompoundTag tag = itemStack.getTag();
        if (tag == null) {
            return; // 如果标签为空，则无需进行任何操作
        }

        ListTag modifiersTagList = tag.getList("AttributeModifiers", 10);

        // 创建新的修饰符列表，只添加不包含在待删除UUID列表中的属性修饰符
        ListTag newModifiersTagList = new ListTag();
        for (int i = 0; i < modifiersTagList.size(); i++) {
            Tag t = modifiersTagList.get(i);

            if (t instanceof CompoundTag) {
                CompoundTag modifierTag = (CompoundTag) t;
                if (modifierTag.contains("UUID")) {
                    UUID currentUuid = modifierTag.getUUID("UUID");

                    // 只有当UUID不在待删除列表中时，才添加到新列表
                    if (!uuidsToRemove.contains(currentUuid)) {
                        newModifiersTagList.add(modifierTag.copy());
                    }
                }
            }
        }

        // 更新物品堆栈的标签
        tag.put("AttributeModifiers", newModifiersTagList);
        itemStack.setTag(tag);
    }
}
}