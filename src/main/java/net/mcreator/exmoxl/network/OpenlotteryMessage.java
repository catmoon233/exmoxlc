
package net.mcreator.exmoxl.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;

import net.mcreator.exmoxl.procedures.OpenlotteryAnXiaAnJianShiProcedure;
import net.mcreator.exmoxl.ExmoxlMod;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class OpenlotteryMessage {
	int type, pressedms;

	public OpenlotteryMessage(int type, int pressedms) {
		this.type = type;
		this.pressedms = pressedms;
	}

	public OpenlotteryMessage(FriendlyByteBuf buffer) {
		this.type = buffer.readInt();
		this.pressedms = buffer.readInt();
	}

	public static void buffer(OpenlotteryMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.type);
		buffer.writeInt(message.pressedms);
	}

	public static void handler(OpenlotteryMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> {
			pressAction(context.getSender(), message.type, message.pressedms);
		});
		context.setPacketHandled(true);
	}

	public static void pressAction(Player entity, int type, int pressedms) {
		Level world = entity.level();
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(entity.blockPosition()))
			return;
		if (type == 0) {

			OpenlotteryAnXiaAnJianShiProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		ExmoxlMod.addNetworkMessage(OpenlotteryMessage.class, OpenlotteryMessage::buffer, OpenlotteryMessage::new, OpenlotteryMessage::handler);
	}
}
