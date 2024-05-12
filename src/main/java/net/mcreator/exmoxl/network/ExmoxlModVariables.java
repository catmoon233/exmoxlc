package net.mcreator.exmoxl.network;

import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.Capability;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.saveddata.SavedData;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.nbt.Tag;
import net.minecraft.nbt.StringTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.IntTag;
import net.minecraft.nbt.DoubleTag;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.Direction;
import net.minecraft.client.Minecraft;

import net.mcreator.exmoxl.ExmoxlMod;

import java.util.function.Supplier;
import java.util.UUID;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ExmoxlModVariables {
	public static List<Object> mixins = new ArrayList<>();
	public static List<Object> spawnhoslevel = new ArrayList<>();
	public static List<Object> spawnhosworld = new ArrayList<>();

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		ExmoxlMod.addNetworkMessage(SavedDataSyncMessage.class, SavedDataSyncMessage::buffer, SavedDataSyncMessage::new, SavedDataSyncMessage::handler);
		ExmoxlMod.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new, PlayerVariablesSyncMessage::handler);
	}

	@SubscribeEvent
	public static void init(RegisterCapabilitiesEvent event) {
		event.register(PlayerVariables.class);
	}

	@Mod.EventBusSubscriber
	public static class EventBusVariableHandlers {
		@SubscribeEvent
		public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getEntity().level().isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
			if (!event.getEntity().level().isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getEntity().level().isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void clonePlayer(PlayerEvent.Clone event) {
			event.getOriginal().revive();
			PlayerVariables original = ((PlayerVariables) event.getOriginal().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			PlayerVariables clone = ((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			clone.playerxp = original.playerxp;
			clone.playerllvl = original.playerllvl;
			clone.playerupxp = original.playerupxp;
			clone.playermaxhealth = original.playermaxhealth;
			clone.playerattack = original.playerattack;
			clone.classes = original.classes;
			clone.bossastring = original.bossastring;
			clone.tfd = original.tfd;
			clone.f1chn = original.f1chn;
			clone.piao2 = original.piao2;
			clone.spritnow = original.spritnow;
			clone.hd = original.hd;
			clone.chou = original.chou;
			clone.clevel = original.clevel;
			clone.cnum = original.cnum;
			clone.task = original.task;
			clone.taskfinnishi = original.taskfinnishi;
			clone.tasktitle = original.tasktitle;
			clone.tasknr = original.tasknr;
			clone.taskftitle = original.taskftitle;
			clone.taskget = original.taskget;
			clone.taskxz = original.taskxz;
			clone.lingwu = original.lingwu;
			clone.Innatetalent = original.Innatetalent;
			clone.SelectTalent = original.SelectTalent;
			clone.istianfuSe = original.istianfuSe;
			clone.TalentSz2 = original.TalentSz2;
			clone.TalentSz = original.TalentSz;
			clone.StoneSignIndex = original.StoneSignIndex;
			clone.SelectDungeon = original.SelectDungeon;
			if (!event.isWasDeath()) {
				clone.wearonxumiring = original.wearonxumiring;
			}
		}

		@SubscribeEvent
		public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getEntity().level().isClientSide()) {
				SavedData mapdata = MapVariables.get(event.getEntity().level());
				SavedData worlddata = WorldVariables.get(event.getEntity().level());
				if (mapdata != null)
					ExmoxlMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()), new SavedDataSyncMessage(0, mapdata));
				if (worlddata != null)
					ExmoxlMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()), new SavedDataSyncMessage(1, worlddata));
			}
		}

		@SubscribeEvent
		public static void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getEntity().level().isClientSide()) {
				SavedData worlddata = WorldVariables.get(event.getEntity().level());
				if (worlddata != null)
					ExmoxlMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()), new SavedDataSyncMessage(1, worlddata));
			}
		}
	}

	public static class WorldVariables extends SavedData {
		public static final String DATA_NAME = "exmoxl_worldvars";

		public static WorldVariables load(CompoundTag tag) {
			WorldVariables data = new WorldVariables();
			data.read(tag);
			return data;
		}

		public void read(CompoundTag nbt) {
		}

		@Override
		public CompoundTag save(CompoundTag nbt) {
			return nbt;
		}

		public void syncData(LevelAccessor world) {
			this.setDirty();
			if (world instanceof Level level && !level.isClientSide())
				ExmoxlMod.PACKET_HANDLER.send(PacketDistributor.DIMENSION.with(level::dimension), new SavedDataSyncMessage(1, this));
		}

		static WorldVariables clientSide = new WorldVariables();

		public static WorldVariables get(LevelAccessor world) {
			if (world instanceof ServerLevel level) {
				return level.getDataStorage().computeIfAbsent(e -> WorldVariables.load(e), WorldVariables::new, DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class MapVariables extends SavedData {
		public static final String DATA_NAME = "exmoxl_mapvars";
		public boolean isserver = false;
		public Map<UUID, String> bossstring = new HashMap<UUID, String>();
		public double bossstringyz = 50.0;
		public List<Vec3> spawnpos = new ArrayList<>();

		public static MapVariables load(CompoundTag tag) {
			MapVariables data = new MapVariables();
			data.read(tag);
			return data;
		}

		public void read(CompoundTag nbt) {
			isserver = nbt.getBoolean("isserver");
			CompoundTag uuidMapTag = nbt.getCompound("bossstring");
			for (String key : uuidMapTag.getAllKeys()) {
				UUID uuid = UUID.fromString(key);
				String value = uuidMapTag.getString(key);
				bossstring.put(uuid, value);
			}
			bossstringyz = nbt.getDouble("bossstringyz");
			{
				ListTag spawnposParentListTag = nbt.getList("spawnpos", 9);
				List<Vec3> list = new ArrayList<>();
				for (int i = 0; i < spawnposParentListTag.size(); ++i) {
					ListTag spawnposChildListTag = spawnposParentListTag.getList(i);
					list.add(new Vec3(spawnposChildListTag.getDouble(0), spawnposChildListTag.getDouble(1), spawnposChildListTag.getDouble(2)));
				}
				spawnpos = list;
			}
		}

		@Override
		public CompoundTag save(CompoundTag nbt) {
			nbt.putBoolean("isserver", isserver);
			CompoundTag uuidMapTag = new CompoundTag();
			for (Map.Entry<UUID, String> entry : bossstring.entrySet()) {
				uuidMapTag.putString(entry.getKey().toString(), entry.getValue());
			}
			nbt.put("bossstring", uuidMapTag);
			nbt.putDouble("bossstringyz", bossstringyz);
			{
				ListTag spawnposParentListTag = new ListTag();
				for (Vec3 vec3 : spawnpos) {
					ListTag spawnposChildListTag = new ListTag();
					spawnposChildListTag.add(DoubleTag.valueOf(vec3.x()));
					spawnposChildListTag.add(DoubleTag.valueOf(vec3.y()));
					spawnposChildListTag.add(DoubleTag.valueOf(vec3.z()));
					spawnposParentListTag.add(spawnposChildListTag);
				}
				nbt.put("spawnpos", spawnposParentListTag);
			}
			return nbt;
		}

		public void syncData(LevelAccessor world) {
			this.setDirty();
			if (world instanceof Level && !world.isClientSide())
				ExmoxlMod.PACKET_HANDLER.send(PacketDistributor.ALL.noArg(), new SavedDataSyncMessage(0, this));
		}

		static MapVariables clientSide = new MapVariables();

		public static MapVariables get(LevelAccessor world) {
			if (world instanceof ServerLevelAccessor serverLevelAcc) {
				return serverLevelAcc.getLevel().getServer().getLevel(Level.OVERWORLD).getDataStorage().computeIfAbsent(e -> MapVariables.load(e), MapVariables::new, DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class SavedDataSyncMessage {
		private final int type;
		private SavedData data;

		public SavedDataSyncMessage(FriendlyByteBuf buffer) {
			this.type = buffer.readInt();
			CompoundTag nbt = buffer.readNbt();
			if (nbt != null) {
				this.data = this.type == 0 ? new MapVariables() : new WorldVariables();
				if (this.data instanceof MapVariables mapVariables)
					mapVariables.read(nbt);
				else if (this.data instanceof WorldVariables worldVariables)
					worldVariables.read(nbt);
			}
		}

		public SavedDataSyncMessage(int type, SavedData data) {
			this.type = type;
			this.data = data;
		}

		public static void buffer(SavedDataSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeInt(message.type);
			if (message.data != null)
				buffer.writeNbt(message.data.save(new CompoundTag()));
		}

		public static void handler(SavedDataSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer() && message.data != null) {
					if (message.type == 0)
						MapVariables.clientSide = (MapVariables) message.data;
					else
						WorldVariables.clientSide = (WorldVariables) message.data;
				}
			});
			context.setPacketHandled(true);
		}
	}

	public static final Capability<PlayerVariables> PLAYER_VARIABLES_CAPABILITY = CapabilityManager.get(new CapabilityToken<PlayerVariables>() {
	});

	@Mod.EventBusSubscriber
	private static class PlayerVariablesProvider implements ICapabilitySerializable<Tag> {
		@SubscribeEvent
		public static void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
			if (event.getObject() instanceof Player && !(event.getObject() instanceof FakePlayer))
				event.addCapability(new ResourceLocation("exmoxl", "player_variables"), new PlayerVariablesProvider());
		}

		private final PlayerVariables playerVariables = new PlayerVariables();
		private final LazyOptional<PlayerVariables> instance = LazyOptional.of(() -> playerVariables);

		@Override
		public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
			return cap == PLAYER_VARIABLES_CAPABILITY ? instance.cast() : LazyOptional.empty();
		}

		@Override
		public Tag serializeNBT() {
			return playerVariables.writeNBT();
		}

		@Override
		public void deserializeNBT(Tag nbt) {
			playerVariables.readNBT(nbt);
		}
	}

	public static class PlayerVariables {
		public double playerxp = 0;
		public double playerllvl = 1.0;
		public double playerupxp = 100.0;
		public double playermaxhealth = 100.0;
		public double playerattack = 1.0;
		public double classes = 0;
		public String bossastring = "\"\"";
		public boolean wearonxumiring = false;
		public double tfd = 0;
		public double f1chn = 0;
		public double piao2 = 0;
		public double spritnow = 0;
		public double hd = 0;
		public List<Integer> chou = new ArrayList<>();
		public double clevel = 0;
		public double cnum = 0.0;
		public List<String> task = new ArrayList<>();
		public List<String> taskfinnishi = new ArrayList<>();
		public String tasktitle = "\"\"";
		public String tasknr = "\"\"";
		public String taskftitle = "\"\"";
		public String taskget = "\u65E0";
		public double taskxz = 0;
		public ItemStack lingwu = ItemStack.EMPTY;
		public List<String> Innatetalent = new ArrayList<>();
		public List<String> SelectTalent = new ArrayList<>();
		public boolean istianfuSe = false;
		public List<Integer> TalentSz2 = new ArrayList<>();
		public Map<String, Integer> TalentSz = new HashMap();
		public String StoneSignIndex = "\"\"";
		public double SelectDungeon = 0;

		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayer serverPlayer)
				ExmoxlMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> serverPlayer), new PlayerVariablesSyncMessage(this));
		}

		public Tag writeNBT() {
			CompoundTag nbt = new CompoundTag();
			nbt.putDouble("playerxp", playerxp);
			nbt.putDouble("playerllvl", playerllvl);
			nbt.putDouble("playerupxp", playerupxp);
			nbt.putDouble("playermaxhealth", playermaxhealth);
			nbt.putDouble("playerattack", playerattack);
			nbt.putDouble("classes", classes);
			nbt.putString("bossastring", bossastring);
			nbt.putBoolean("wearonxumiring", wearonxumiring);
			nbt.putDouble("tfd", tfd);
			nbt.putDouble("f1chn", f1chn);
			nbt.putDouble("piao2", piao2);
			nbt.putDouble("spritnow", spritnow);
			nbt.putDouble("hd", hd);
			ListTag chouListTag = new ListTag();
			for (Integer value : chou) {
				chouListTag.add(IntTag.valueOf(value));
			}
			nbt.put("chou", chouListTag);
			nbt.putDouble("clevel", clevel);
			nbt.putDouble("cnum", cnum);
			ListTag taskListTag = new ListTag();
			for (String value : task) {
				taskListTag.add(StringTag.valueOf(value));
			}
			nbt.put("task", taskListTag);
			ListTag taskfinnishiListTag = new ListTag();
			for (String value : taskfinnishi) {
				taskfinnishiListTag.add(StringTag.valueOf(value));
			}
			nbt.put("taskfinnishi", taskfinnishiListTag);
			nbt.putString("tasktitle", tasktitle);
			nbt.putString("tasknr", tasknr);
			nbt.putString("taskftitle", taskftitle);
			nbt.putString("taskget", taskget);
			nbt.putDouble("taskxz", taskxz);
			nbt.put("lingwu", lingwu.save(new CompoundTag()));
			ListTag InnatetalentListTag = new ListTag();
			for (String value : Innatetalent) {
				InnatetalentListTag.add(StringTag.valueOf(value));
			}
			nbt.put("Innatetalent", InnatetalentListTag);
			ListTag SelectTalentListTag = new ListTag();
			for (String value : SelectTalent) {
				SelectTalentListTag.add(StringTag.valueOf(value));
			}
			nbt.put("SelectTalent", SelectTalentListTag);
			nbt.putBoolean("istianfuSe", istianfuSe);
			ListTag TalentSz2ListTag = new ListTag();
			for (Integer value : TalentSz2) {
				TalentSz2ListTag.add(IntTag.valueOf(value));
			}
			nbt.put("TalentSz2", TalentSz2ListTag);
			CompoundTag uuidMapTag = new CompoundTag();
			for (Map.Entry<String, Integer> entry : TalentSz.entrySet()) {
				uuidMapTag.putString(entry.getKey(), entry.getValue().toString());
			}
			nbt.put("TalentSz", uuidMapTag);
			nbt.putString("StoneSignIndex", StoneSignIndex);
			nbt.putDouble("SelectDungeon", SelectDungeon);
			return nbt;
		}

		public void readNBT(Tag Tag) {
			CompoundTag nbt = (CompoundTag) Tag;
			playerxp = nbt.getDouble("playerxp");
			playerllvl = nbt.getDouble("playerllvl");
			playerupxp = nbt.getDouble("playerupxp");
			playermaxhealth = nbt.getDouble("playermaxhealth");
			playerattack = nbt.getDouble("playerattack");
			classes = nbt.getDouble("classes");
			bossastring = nbt.getString("bossastring");
			wearonxumiring = nbt.getBoolean("wearonxumiring");
			tfd = nbt.getDouble("tfd");
			f1chn = nbt.getDouble("f1chn");
			piao2 = nbt.getDouble("piao2");
			spritnow = nbt.getDouble("spritnow");
			hd = nbt.getDouble("hd");
			{
				ListTag chouListTag = nbt.getList("chou", 3);
				List<Integer> list = new ArrayList<>();
				for (int i = 0; i < chouListTag.size(); ++i) {
					list.add(chouListTag.getInt(i));
				}
				chou = list;
			}
			clevel = nbt.getDouble("clevel");
			cnum = nbt.getDouble("cnum");
			ListTag taskListTag = nbt.getList("task", 8);
			List<String> tasklist = new ArrayList<>();
			for (int i = 0; i < taskListTag.size(); ++i) {
				tasklist.add(taskListTag.getString(i));
			}
			task = tasklist;
			ListTag taskfinnishiListTag = nbt.getList("taskfinnishi", 8);
			List<String> taskfinnishilist = new ArrayList<>();
			for (int i = 0; i < taskfinnishiListTag.size(); ++i) {
				taskfinnishilist.add(taskfinnishiListTag.getString(i));
			}
			taskfinnishi = taskfinnishilist;
			tasktitle = nbt.getString("tasktitle");
			tasknr = nbt.getString("tasknr");
			taskftitle = nbt.getString("taskftitle");
			taskget = nbt.getString("taskget");
			taskxz = nbt.getDouble("taskxz");
			lingwu = ItemStack.of(nbt.getCompound("lingwu"));
			ListTag InnatetalentListTag = nbt.getList("Innatetalent", 8);
			List<String> Innatetalentlist = new ArrayList<>();
			for (int i = 0; i < InnatetalentListTag.size(); ++i) {
				Innatetalentlist.add(InnatetalentListTag.getString(i));
			}
			Innatetalent = Innatetalentlist;
			ListTag SelectTalentListTag = nbt.getList("SelectTalent", 8);
			List<String> SelectTalentlist = new ArrayList<>();
			for (int i = 0; i < SelectTalentListTag.size(); ++i) {
				SelectTalentlist.add(SelectTalentListTag.getString(i));
			}
			SelectTalent = SelectTalentlist;
			istianfuSe = nbt.getBoolean("istianfuSe");
			{
				ListTag TalentSz2ListTag = nbt.getList("TalentSz2", 3);
				List<Integer> list = new ArrayList<>();
				for (int i = 0; i < TalentSz2ListTag.size(); ++i) {
					list.add(TalentSz2ListTag.getInt(i));
				}
				TalentSz2 = list;
			}
			CompoundTag uuidMapTag = nbt.getCompound("TalentSz");
			for (String key : uuidMapTag.getAllKeys()) {
				String value = uuidMapTag.getString(key);
				TalentSz.put(key, Integer.parseInt(value));
			}
			StoneSignIndex = nbt.getString("StoneSignIndex");
			SelectDungeon = nbt.getDouble("SelectDungeon");
		}
	}

	public static class PlayerVariablesSyncMessage {
		private final PlayerVariables data;

		public PlayerVariablesSyncMessage(FriendlyByteBuf buffer) {
			this.data = new PlayerVariables();
			this.data.readNBT(buffer.readNbt());
		}

		public PlayerVariablesSyncMessage(PlayerVariables data) {
			this.data = data;
		}

		public static void buffer(PlayerVariablesSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeNbt((CompoundTag) message.data.writeNBT());
		}

		public static void handler(PlayerVariablesSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					PlayerVariables variables = ((PlayerVariables) Minecraft.getInstance().player.getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
					variables.playerxp = message.data.playerxp;
					variables.playerllvl = message.data.playerllvl;
					variables.playerupxp = message.data.playerupxp;
					variables.playermaxhealth = message.data.playermaxhealth;
					variables.playerattack = message.data.playerattack;
					variables.classes = message.data.classes;
					variables.bossastring = message.data.bossastring;
					variables.wearonxumiring = message.data.wearonxumiring;
					variables.tfd = message.data.tfd;
					variables.f1chn = message.data.f1chn;
					variables.piao2 = message.data.piao2;
					variables.spritnow = message.data.spritnow;
					variables.hd = message.data.hd;
					variables.chou = message.data.chou;
					variables.clevel = message.data.clevel;
					variables.cnum = message.data.cnum;
					variables.task = message.data.task;
					variables.taskfinnishi = message.data.taskfinnishi;
					variables.tasktitle = message.data.tasktitle;
					variables.tasknr = message.data.tasknr;
					variables.taskftitle = message.data.taskftitle;
					variables.taskget = message.data.taskget;
					variables.taskxz = message.data.taskxz;
					variables.lingwu = message.data.lingwu;
					variables.Innatetalent = message.data.Innatetalent;
					variables.SelectTalent = message.data.SelectTalent;
					variables.istianfuSe = message.data.istianfuSe;
					variables.TalentSz2 = message.data.TalentSz2;
					variables.TalentSz = message.data.TalentSz;
					variables.StoneSignIndex = message.data.StoneSignIndex;
					variables.SelectDungeon = message.data.SelectDungeon;
				}
			});
			context.setPacketHandled(true);
		}
	}
}
