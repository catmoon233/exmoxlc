package net.mcreator.exmoxl.procedures;

import io.netty.buffer.Unpooled;
import net.mcreator.exmoxl.client.gui.CharacterxttalentScreen;
import net.mcreator.exmoxl.world.inventory.CharacterxttalentMenu;
import net.mcreator.exmoxl.world.inventory.ChooseclassguiMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;

import net.mcreator.exmoxl.network.ExmoxlModVariables;
import net.minecraftforge.network.NetworkHooks;

public class ChangeclassProcedure {
	public static void execute(Entity entity,double abc) {
		if (entity == null)
			return;
		{
			double _setval = abc;
			entity.getCapability(ExmoxlModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.classes = _setval;
				capability.syncPlayerVariables(entity);
			});
		}

		if (entity instanceof Player _player)
			_player.closeContainer();
		if (entity instanceof ServerPlayer _ent) {
			BlockPos _bpos = BlockPos.containing(entity.getX(), entity.getY(), entity.getZ());
			NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
				@Override
				public Component getDisplayName() {
					return Component.literal("Characterxttalent");
				}

				@Override
				public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
					return new CharacterxttalentMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
				}
			}, _bpos);
		}

		CharacterxttalentScreen.InitTalent((LivingEntity) entity);

	}
}
