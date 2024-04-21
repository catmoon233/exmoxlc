package net.mcreator.exmoxl.procedures;

import net.minecraftforge.network.NetworkHooks;
import net.mcreator.exmoxl.network.LotterydanButtonMessage;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.MenuProvider;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.exmoxl.network.ExmoxlModVariables;
import net.mcreator.exmoxl.world.inventory.LotterydanMenu;

import io.netty.buffer.Unpooled;

public class DanchouProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		LotterydanButtonMessage.clevel =0;
		if ((entity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ExmoxlModVariables.PlayerVariables())).piao2 >= 1) {
			{
				double _setval = (entity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ExmoxlModVariables.PlayerVariables())).piao2 - 1;
				entity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.piao2 = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		if (entity instanceof ServerPlayer _ent) {
			BlockPos _bpos = BlockPos.containing(x, y, z);
			NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
				@Override
				public Component getDisplayName() {
					return Component.literal("Lotterydan");
				}

				@Override
				public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
					return new LotterydanMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
				}
			}, _bpos);
		}
	}
	}
}
