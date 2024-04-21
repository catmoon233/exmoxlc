package net.mcreator.exmoxl.procedures;


import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import com.google.common.collect.Multimap;
import java.util.function.Supplier;
import java.util.UUID;
import java.util.Map;
import net.minecraft.world.entity.ai.attributes.Attribute;
public class RecastinglcProcedure {
    public static void execute(Player entity, double jishu) {
        if (entity == null)
            return;

        ItemStack armor = ItemStack.EMPTY;
        double armorvalue = 0;
        double armorvalue2 = 0;
        double weijie = 0;
        double suiji = 0;

        // 确保玩家在GUI中并获取相关数据
        if (entity.containerMenu instanceof Supplier && ((Supplier<?>) entity.containerMenu).get() instanceof Map) {
            Map<Integer, Slot> slots = (Map<Integer, Slot>) ((Supplier<?>) entity.containerMenu).get();
            Slot slot0 = slots.get(0);
            Slot slot1 = slots.get(1);
            Slot slot2 = slots.get(2);

            if (slot0.getItem().getItem() instanceof ArmorItem &&
                    slot0.getItem().getOrCreateTag().getDouble("roll") ==0&&
                    slot1.getItem().getCount() >= jishu &&
                    slot2.getItem().getCount() >= jishu * 3) {

                armor = slot0.getItem().copy(); // 复制盔甲以避免修改原始物品堆叠
                weijie = armor.getTag().getDouble("recasting") * jishu;
                suiji = Mth.nextInt(RandomSource.create(), 60, 120) * 0.005;

                EquipmentSlot equipmentSlot = ((ArmorItem)armor.getItem()).getEquipmentSlot();

                armorvalue = armor.getAttributeModifiers(equipmentSlot).get(Attributes.ARMOR).stream().mapToDouble(attributeModifier -> attributeModifier.getAmount()).sum();
                armorvalue2 = armor.getAttributeModifiers(equipmentSlot).get(Attributes.ARMOR_TOUGHNESS).stream().mapToDouble(attributeModifier -> attributeModifier.getAmount()).sum();

                double adjustedArmorValue = armorvalue * 0.03 * weijie * suiji;
                double adjustedToughnessValue = armorvalue2 * 0.03 * weijie * suiji;

                UUID uuid_armor = UUID.fromString("0e692122-de94-11ee-a179-325096b39f47");
                UUID uuid_toughness = UUID.fromString("0e692122-de94-11ee-a179-325096b39f46");
                  //  changeattr ChangeattrProcedure=new changeattr();
                if (armorvalue > 0) {
                    ChangeattrProcedure.addItemAttributeModifier2(armor, Attributes.ARMOR, new AttributeModifier(uuid_armor, "\u62A4\u7532", adjustedArmorValue, AttributeModifier.Operation.ADDITION), equipmentSlot);
                    
                }
                if (armorvalue2 > 0) {
                    ChangeattrProcedure.addItemAttributeModifier2(armor, Attributes.ARMOR_TOUGHNESS, new AttributeModifier(uuid_toughness, "\u76D4\u7532\u4EFB\u6027", adjustedToughnessValue, AttributeModifier.Operation.ADDITION), equipmentSlot);

                }

                armor.getOrCreateTag().putDouble("roll", 1);

                slot1.remove((int) jishu);
                slot2.remove((int) (jishu * 3));
                slot0.set(armor); // 设置已更新属性的物品到槽位0

                entity.containerMenu.broadcastChanges();
            }
        }
    }
}