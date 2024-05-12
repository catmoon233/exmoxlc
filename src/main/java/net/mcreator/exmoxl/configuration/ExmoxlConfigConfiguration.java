package net.mcreator.exmoxl.configuration;

import net.minecraftforge.common.ForgeConfigSpec;

public class ExmoxlConfigConfiguration {
	public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
	public static final ForgeConfigSpec SPEC;
	public static final ForgeConfigSpec.ConfigValue<Boolean> CLASSA;
	public static final ForgeConfigSpec.ConfigValue<Double> DEFUALTHELTH;
	static {
		BUILDER.push("function");
		CLASSA = BUILDER.comment("开启种族功能").define("种族功能", false);
		DEFUALTHELTH = BUILDER.comment("玩家开始默认血量").define("玩家默认血量", (double) 20);
		BUILDER.pop();

		SPEC = BUILDER.build();
	}

}
