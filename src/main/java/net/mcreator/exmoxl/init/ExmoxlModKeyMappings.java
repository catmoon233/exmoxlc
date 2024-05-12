
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.exmoxl.init;

import org.lwjgl.glfw.GLFW;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

import net.mcreator.exmoxl.network.TwMessage;
import net.mcreator.exmoxl.network.OpenlotteryMessage;
import net.mcreator.exmoxl.network.OpenattrmbMessage;
import net.mcreator.exmoxl.ExmoxlMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class ExmoxlModKeyMappings {
	public static final KeyMapping TW = new KeyMapping("key.exmoxl.tw", GLFW.GLFW_KEY_UNKNOWN, "key.categories.misc") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				ExmoxlMod.PACKET_HANDLER.sendToServer(new TwMessage(0, 0));
				TwMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping OPENATTRMB = new KeyMapping("key.exmoxl.openattrmb", GLFW.GLFW_KEY_G, "key.categories.misc") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				ExmoxlMod.PACKET_HANDLER.sendToServer(new OpenattrmbMessage(0, 0));
				OpenattrmbMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping OPENLOTTERY = new KeyMapping("key.exmoxl.openlottery", GLFW.GLFW_KEY_J, "key.categories.misc") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				ExmoxlMod.PACKET_HANDLER.sendToServer(new OpenlotteryMessage(0, 0));
				OpenlotteryMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};

	@SubscribeEvent
	public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(TW);
		event.register(OPENATTRMB);
		event.register(OPENLOTTERY);
	}

	@Mod.EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onClientTick(TickEvent.ClientTickEvent event) {
			if (Minecraft.getInstance().screen == null) {
				TW.consumeClick();
				OPENATTRMB.consumeClick();
				OPENLOTTERY.consumeClick();
			}
		}
	}
}
