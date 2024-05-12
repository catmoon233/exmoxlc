
package net.mcreator.exmoxl.network;

import net.mcreator.exmoxl.Talent;
import net.mcreator.exmoxl.TalentList;
import net.mcreator.exmoxl.client.gui.CharacterxttalentScreen;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.exmoxl.world.inventory.CharacterxttalentMenu;
import net.mcreator.exmoxl.ExmoxlMod;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class CharacterxttalentButtonMessage {
	private final int buttonID, x, y, z;

	public CharacterxttalentButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public CharacterxttalentButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(CharacterxttalentButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(CharacterxttalentButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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
		Map<String, Integer> Sectf;

		List<TalentList.Talent> talents = TalentList.TalentCList;
		Sectf = (entity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ExmoxlModVariables.PlayerVariables())).TalentSz;
		List<Integer> Secint = (entity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ExmoxlModVariables.PlayerVariables())).TalentSz2;
		Level world = entity.level();
		List<String> tl = (entity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ExmoxlModVariables.PlayerVariables())).SelectTalent;
		HashMap guistate = CharacterxttalentMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if(buttonID==1) {
			if (
					!((LevelAccessor) entity.level()).isClientSide()
			) {
				{
					entity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {

						Boolean a =true;
						capability.istianfuSe = a;
						capability.syncPlayerVariables(entity);
					});
				}
				//ExmoxlMod.LOGGER.debug("hiii");
				entity.closeContainer();
				((ServerPlayer) entity).setGameMode(GameType.SURVIVAL);

				for (int i = 0; i < talents.size(); i++){
					if (Sectf.containsKey(talents.get(i).displayname)) {
						if (TalentList.onsec(talents.get(i), entity,Sectf.get(talents.get(i).displayname)) != null) {
//							ExmoxlMod.LOGGER.debug(talents.get(i).displayname);
							TalentList.onsec(talents.get(i), entity,Sectf.get(talents.get(i).displayname)).run();
						}


					}
				}
			}


		}
		if (buttonID == 0) {
			if (!((LevelAccessor) (entity.level())).isClientSide()) {
				int xz= CharacterxttalentScreen.xz;
//				int xz = 0;
//				for (int i = 0;
//					 i <
//							 Sectf.size();
//					 i++
//				) {
//					if (Sectf.containsKey(tl.get(i))) {
//						xz += TalentList.TalentQlist.get((tl.get(i))) * Sectf.get((tl.get(i)));
//					}
//				}
				int sz = CharacterxttalentScreen.Selectioningtf();

				if (sz != -1) {


						//if (!Sectf.containsKey(tl.get(sz))) {
							//ExmoxlMod.LOGGER.debug(Sectf.get(tl.get(sz)));
//							Secint.add(sz);
//							Sectf.put(tl.get(sz), 1);

					//	} else {

							ExmoxlMod.LOGGER.debug(xz);
							if (Secint.contains(sz)) {


								for (int i = 0; i < Secint.size(); i++) {
									if (Secint.get(i) == sz) {
										Secint.remove(i);
										Sectf.put(tl.get(sz), Sectf.get(tl.get(sz)) - 1);
										break;

									}
								}

							} else {
								if (xz + TalentList.TalentQlist.get(tl.get(sz)) <= 12) {

									Secint.add(sz);
									//if (Sectf.get(tl.get(sz)) > 0) {
									Sectf.put(tl.get(sz), 1 + Sectf.get(tl.get(sz)));
									//}

								}
							}

							{
								entity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									;
									capability.TalentSz = Sectf;
									capability.TalentSz2 = Secint;
									capability.syncPlayerVariables(entity);
								});
							}

							ExmoxlMod.LOGGER.debug("touch button");
							for (int i = 0; i < Sectf.size(); i++) {
								ExmoxlMod.LOGGER.debug(Sectf.get(i));
							}
					//	}

				}else ExmoxlMod.LOGGER.debug("Something went wrong");
			}
		}

	}
	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		ExmoxlMod.addNetworkMessage(CharacterxttalentButtonMessage.class, CharacterxttalentButtonMessage::buffer, CharacterxttalentButtonMessage::new, CharacterxttalentButtonMessage::handler);
	}
}
