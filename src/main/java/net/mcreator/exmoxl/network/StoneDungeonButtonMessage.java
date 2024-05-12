
package net.mcreator.exmoxl.network;

import net.mcreator.exmoxl.client.gui.StoneDungeonScreen;
import net.mcreator.exmoxl.utils.dungeon;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.exmoxl.world.inventory.StoneDungeonMenu;
import net.mcreator.exmoxl.procedures.ShmoveProcedure;
import net.mcreator.exmoxl.ExmoxlMod;

import java.util.List;
import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class StoneDungeonButtonMessage {
	private final int buttonID, x, y, z;

	public StoneDungeonButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public StoneDungeonButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(StoneDungeonButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(StoneDungeonButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> {
			Player entity = context.getSender();
			int buttonID = message.buttonID;
			int x = message.x;
			int y = message.y;
			int z = message.z;
			handleButtonAction(entity, buttonID, x, y, z);
		});
		context.setPacketHandled(true);
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		int MouseX = StoneDungeonScreen.MouseX
		,MouseY = StoneDungeonScreen.MouseY
				,sx = StoneDungeonScreen.sx,
					sy = StoneDungeonScreen.sy;
		Level world = entity.level();
		HashMap guistate = StoneDungeonMenu.guistate;
		String dungeonindex = (entity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ExmoxlModVariables.PlayerVariables())).StoneSignIndex;
		List<dungeon.Dungeon> dungeons = dungeon.getDungeons(dungeonindex);
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {
			for(int i = 0; i < 6; i++){
				if (i<dungeons.size()){
				if(MouseX <sx+90 && MouseX >sx && MouseY <sy+i*47 && MouseY >sy+(i+1)*47) {
					{
						int finalI = i;
						entity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {

							capability.SelectDungeon = finalI;
							capability.syncPlayerVariables(entity);
						});
					}
				}
				}
			}

		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		ExmoxlMod.addNetworkMessage(StoneDungeonButtonMessage.class, StoneDungeonButtonMessage::buffer, StoneDungeonButtonMessage::new, StoneDungeonButtonMessage::handler);
	}
}
