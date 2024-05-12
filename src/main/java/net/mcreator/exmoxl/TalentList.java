/**
 * The code of this mod element is always locked.
 *
 * You can register new events in this class too.
 *
 * If you want to make a plain independent class, create it using
 * Project Browser -> New... and make sure to make the class
 * outside net.mcreator.exmoxl as this package is managed by MCreator.
 *
 * If you change workspace package, modid or prefix, you will need
 * to manually adapt this file to these changes or remake it.
 *
 * This class will be added in the mod root package.
*/
package net.mcreator.exmoxl;

import net.mcreator.exmoxl.init.ExmoxlModAttributes;
import net.mcreator.exmoxl.network.ExmoxlModVariables;
import net.mcreator.exmoxl.procedures.AddAttrSProcedure;
import net.mcreator.exmoxl.procedures.ChangeattrProcedure;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;
import org.jetbrains.annotations.Nullable;

import java.util.*;

import static net.mcreator.exmoxl.utils.dungeon.DungeonSettingOnGame;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class TalentList {
	public static Map<String, Integer> TalentQlist = new HashMap<>();
	public  static List<String> TalentList = new ArrayList<>();
	public static List<Talent> TalentCList = new ArrayList<>();
	//public static Map<String, Runnable> TalentRunList = new HashMap<>();

	public static Map<String,String> TalenDecription = new HashMap<>();
	public static class Talent {
		public  String displayname = "无";
		public  String ds = "无描述";
		public  int q = 0;
		public  int level = 0;
		public  Runnable FisrtAdd ;
		public Runnable Onup;

		public Talent(String displayname, int q, int level, String ds,  Runnable runnable){
			this.displayname = displayname;
			this.q = q;
			this.level = level;
			this.ds = ds;
			this.FisrtAdd = runnable;
		}


	}
	public static void registerTalent(Talent talent) {
		TalentCList.add(talent);
		TalentQlist.put(talent.displayname, talent.q);
		TalentList.add(talent.displayname);
		TalenDecription.put(talent.displayname, talent.ds);


	}
	public static void addtalent(String string,int q,String ds,Runnable run){
		TalentList.add(string);
		TalentQlist.put(string, q);
		TalenDecription.put(string, ds);
	}


	public static Runnable onupr(Talent talent, LivingEntity livingEntity,int number){
		Map<String, Integer> Sectf = (livingEntity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ExmoxlModVariables.PlayerVariables())).TalentSz;

		Runnable runnable = null;
		switch (talent.displayname) {
			case "§1天生巨力":
				runnable = () -> {
					AddAttrSProcedure.addStr(livingEntity, number);
				};
				break;
			case "§1身轻如燕":
				runnable = () -> {
					AddAttrSProcedure.addAGA(livingEntity, number);
				};
				break;
			case "§1才智过人":
				runnable = () -> {
					AddAttrSProcedure.addAgi(livingEntity,number);
				};
				break;
				case "§1体壮如牛":
					runnable = () -> {
						{
							double _setval = (livingEntity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ExmoxlModVariables.PlayerVariables())).playermaxhealth + 5*number;
							livingEntity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.playermaxhealth = _setval;
								capability.syncPlayerVariables(livingEntity);
							});
						}
						AddAttrSProcedure.addStr(livingEntity,0);
					};
					break;
			case "§1皮糙肉厚":
				runnable = () -> {
					{
						if (livingEntity.getAttribute(Attributes.ARMOR).hasModifier((new AttributeModifier(UUID.fromString("9cf6a146-d7ae-41e6-8dfc-b322017ad124"), "\u62A4\u7532\u5C5E\u6027",
								((livingEntity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ExmoxlModVariables.PlayerVariables())).playerllvl * 0.5*number), AttributeModifier.Operation.ADDITION)))) {
							livingEntity.getAttribute(Attributes.ARMOR).removePermanentModifier((new AttributeModifier(UUID.fromString("9cf6a146-d7ae-41e6-8dfc-b322017ad124"), "\u62A4\u7532\u5C5E\u6027",
									((livingEntity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ExmoxlModVariables.PlayerVariables())).playerllvl * 0.5*number), AttributeModifier.Operation.ADDITION)).getId());
							if (!(livingEntity.getAttribute(Attributes.ARMOR).hasModifier((new AttributeModifier(UUID.fromString("9cf6a146-d7ae-41e6-8dfc-b322017ad124"), "\u62A4\u7532\u5C5E\u6027",
									(((livingEntity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ExmoxlModVariables.PlayerVariables())).playerllvl + 1) * 0.5*number), AttributeModifier.Operation.ADDITION)))))
								livingEntity.getAttribute(Attributes.ARMOR).addPermanentModifier((new AttributeModifier(UUID.fromString("9cf6a146-d7ae-41e6-8dfc-b322017ad124"), "\u62A4\u7532\u5C5E\u6027",
										(((livingEntity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ExmoxlModVariables.PlayerVariables())).playerllvl + 1) * 0.5*number), AttributeModifier.Operation.ADDITION)));
						}
					}
				};
				break;
		}
		return runnable;
	}
	public static Runnable onsec(Talent talent, LivingEntity livingEntity,int number){
		switch (talent.displayname){
			case "§1刚毅者":
				return () -> {
					{
						ChangeattrProcedure.EntityAddAttr(livingEntity, UUID.fromString("a0a0a0a0-a0a0-a0a0-a0a0-a0a0a0a0a0a1"),"刚毅者:增加5点护甲",5 + 2.5 * number, Attributes.ARMOR, AttributeModifier.Operation.ADDITION);

					}
				};
				case "§1好手":
					return () -> {
						{
							ChangeattrProcedure.EntityAddAttr(livingEntity, UUID.fromString("a0a0a0a0-a0a0-a0a0-a0a0-a0a0a0a0a0a2"),"好手:增加5点攻击伤害",5 + number, Attributes.ATTACK_DAMAGE, AttributeModifier.Operation.ADDITION);
						}
					};
					case "§l不亢":
						return () -> {
							ChangeattrProcedure.EntityAddAttr(livingEntity, UUID.fromString("a0a0a0a0-a0a0-a0a0-a0a0-a0a0a0a0a0a3"),"不亢:增加0.3点击退抗性",0.3 + 0.1* number, Attributes.KNOCKBACK_RESISTANCE, AttributeModifier.Operation.ADDITION);

						};
						case "§7完颜之子":
							return () -> {
								ChangeattrProcedure.EntityAddAttr(livingEntity, UUID.fromString("a0a0a0a0-a0a0-a0a0-a0a0-a0a0a0a0a0a4"),"完颜之子:增加1点魅力",number, ExmoxlModAttributes.CHARM.get(), AttributeModifier.Operation.ADDITION);

							};
		}
		return null;
	}
	@SubscribeEvent
	public static void RegisterDungeon(FMLCommonSetupEvent event){
		ExmoxlMod.LOGGER.debug("Start Load dungeonconfig");
		DungeonSettingOnGame();

	}
	@SubscribeEvent
	public static void TalentSetup(FMLCommonSetupEvent event) {
		ExmoxlMod.LOGGER.info("Registering Talent");

		Talent t1 = new Talent("§1天生巨力", 1, 0, "每升一级力量属性额外加1",()->{});

		Talent t2 = new Talent("§1身轻如燕", 1, 0, "每升一级灵敏属性额外加1",()->{});

		Talent t3 = new Talent("§1才智过人", 1, 0, "每升一级智慧属性额外加1",()->{});

		Talent t4 = new Talent("§1体壮如牛", 1, 0, "每升一级生命上限额外加5",()->{});

		Talent t5 = new Talent("§1皮糙肉厚", 1, 0, "每升一级护甲值加额外加0.5",()->{});
		registerTalent(t1);
		registerTalent(t2);
		registerTalent(t3);
		registerTalent(t4);
		registerTalent(t5);

		registerTalent(new Talent("§1刚毅者", 1, 0, "增加5点护甲",()->{

		}));
		registerTalent(new Talent( "§7好手", 1, 0, "增加5点攻击伤害",()->{
		}));
		registerTalent(new Talent("§l不亢", 1, 0, "增加0.3点击退抗性",()->{
		}));
		registerTalent(new Talent("§7完颜之子", 1, 0, "增加10点魅力",()->{
		}));
		//TalentQlist.put("§1刚毅者", 1)
//		System.out.println("TalentList");
		ExmoxlMod.LOGGER.debug("TalentList OK");

	}

}
