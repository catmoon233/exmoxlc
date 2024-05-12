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

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;
import org.jetbrains.annotations.Nullable;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

public class Uiutil {
public enum displaystyle {
		normal ,
		center
}
public static void RenScaleText(GuiGraphics gg,float p1, float p2,float p3,Runnable runnable) {
		gg.pose().pushPose();
		gg.pose().scale(p1, p2, p3);
		runnable.run();
		gg.pose().popPose();

	}
	public static void renderLineStr(GuiGraphics graphics, List<String> list, Font font, int x, int y, int color, @Nullable int jiange ,@Nullable displaystyle ds)  {
			jiange = 0;
			int Drawy = y;
			int Drawx = x;

			for (int i = 0; i < list.size(); i++) {
				if (ds == displaystyle.center) {
					//	Drawx = x - (list.get(0).length() * font.width(" ")) / 2;\
					Drawx = x - (font.width(list.get(i)) / 2);
				}
				graphics.drawString(font, list.get(i), Drawx, Drawy, color);
				Drawy += font.lineHeight+jiange;

		}
	}

	public static List<String> linefeed(String string,int width,Font font){
		List<String> list = new ArrayList<>();
		String xxnr = string;
		int indexm = (int) Math.floor(font.width(xxnr)/width);
		for (int i =0; i < indexm ;i++) {
			xxnr = font.plainSubstrByWidth(string, width);
			string = string.substring(xxnr.length());
			list.add(xxnr);

		}
		list.add(string);
		return list;
	}
	public static String generateTextC(String a, String b) {
		StringBuilder c = new StringBuilder();
		for (char charB : b.toCharArray()) {
			if (a.indexOf(charB) == -1) {
				c.append(charB);
			}
		}
		return c.toString();
	}
	public static void after(Runnable runnable,int time){
		new Thread(() -> {
			try {
				Thread.sleep(time);
				runnable.run();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}).start();
	}

	public static  void sustained(Runnable runnable, Entity entity, int time,boolean isReload){
	if(isReload& entity.getPersistentData().getDouble(runnable.toString()) == -1){
		entity.getPersistentData().putDouble(runnable.toString(),time);
	}
		if(entity.getPersistentData().getDouble(runnable.toString()) >0){
			if(entity.getPersistentData().getDouble(runnable.toString()) -1 == 0){entity.getPersistentData().putDouble(runnable.toString(),-1);}
			else entity.getPersistentData().putDouble(runnable.toString(),entity.getPersistentData().getDouble(runnable.toString())-1);
			runnable.run();
		}
		else if(entity.getPersistentData().getDouble(runnable.toString()) == 0){
			entity.getPersistentData().putDouble(runnable.toString(),time);
		}
	}

}
