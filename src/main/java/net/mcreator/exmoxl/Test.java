
package net.mcreator.exmoxl;
import net.mcreator.exmoxl.procedures.ChangeattrProcedure;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraft.world.entity.ai.attributes.Attributes;
@Mod.EventBusSubscriber({Dist.CLIENT})
public class Test {
    public static boolean islook;
	public static double damage;
	public static String distext;
    @SubscribeEvent
    public static void isrentop(ItemTooltipEvent event){
        islook = true;
        distext = ChangeattrProcedure.getattrstringamount(event.getItemStack(),EquipmentSlot.MAINHAND,Attributes.ATTACK_DAMAGE);

    }
}
