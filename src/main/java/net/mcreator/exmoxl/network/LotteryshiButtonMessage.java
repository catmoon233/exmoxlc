
package net.mcreator.exmoxl.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.LevelAccessor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.exmoxl.procedures.OpenlotteryofwaponProcedure;
import net.mcreator.exmoxl.network.ExmoxlModVariables;
import net.mcreator.exmoxl.world.inventory.LotteryshiMenu;
import net.mcreator.exmoxl.procedures.RandomkashiProcedure;
import net.mcreator.exmoxl.ExmoxlMod;

import java.util.function.Supplier;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class LotteryshiButtonMessage {
    private final int buttonID, x, y, z;

    //public static double clevel = 0;
    //	public static double cnum =0;
    //public static List<Integer> chou = new ArrayList<>() ;
    public LotteryshiButtonMessage(FriendlyByteBuf buffer) {
        this.buttonID = buffer.readInt();
        this.x = buffer.readInt();
        this.y = buffer.readInt();
        this.z = buffer.readInt();
    }

    public LotteryshiButtonMessage(int buttonID, int x, int y, int z) {
        this.buttonID = buttonID;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public static void buffer(LotteryshiButtonMessage message, FriendlyByteBuf buffer) {
        buffer.writeInt(message.buttonID);
        buffer.writeInt(message.x);
        buffer.writeInt(message.y);
        buffer.writeInt(message.z);
    }

    public static void handler(LotteryshiButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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
        Level world = entity.level();
        HashMap guistate = LotteryshiMenu.guistate;
        // security measure to prevent arbitrary chunk generation
        if (!world.hasChunkAt(new BlockPos(x, y, z)))
            return;
        if (buttonID == 0) {

            //put button event

            LevelAccessor level = (LevelAccessor) world;
            if ((entity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ExmoxlModVariables.PlayerVariables())).chou != null) {
                if ((entity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ExmoxlModVariables.PlayerVariables())).cnum == 9) {

            OpenlotteryofwaponProcedure.execute(world, x, y, z, entity);
                    {
                        double _setval = 0;
                        entity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                            capability.cnum = _setval;
                            capability.clevel = _setval;
                            capability.syncPlayerVariables(entity);
                        });
                    }
                } else {
                    
                    		//	System.out.printf("+1");

                        entity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                            capability.cnum = 1 + (entity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ExmoxlModVariables.PlayerVariables())).cnum;
                            capability.syncPlayerVariables(entity);
                        });
                    
                }
            }
           // if ((entity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ExmoxlModVariables.PlayerVariables())).cnum == 10)

        }

    }


    @SubscribeEvent
    public static void registerMessage(FMLCommonSetupEvent event) {
        ExmoxlMod.addNetworkMessage(LotteryshiButtonMessage.class, LotteryshiButtonMessage::buffer, LotteryshiButtonMessage::new, LotteryshiButtonMessage::handler);
    }
}
