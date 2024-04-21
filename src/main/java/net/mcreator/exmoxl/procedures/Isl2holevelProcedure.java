package net.mcreator.exmoxl.procedures;
import dev.xkmc.l2hostility.content.capability.mob.MobTraitCap;
import net.minecraft.world.entity.Entity;
public class Isl2holevelProcedure {
public static boolean isl2lv(Entity entity) {
    MobTraitCap traitCap = entity.getCapability(MobTraitCap.CAPABILITY).orElse(null);
    if (traitCap != null ){
    if (traitCap.lv > 0) {
        return false;
    }
    }
    return true;
}
	public static double getlv(Entity entity) {
		
	MobTraitCap traitCap = entity.getCapability(MobTraitCap.CAPABILITY).orElse(null);
	if(traitCap!=null){
return traitCap.lv;
}
return 0;
	}

}
