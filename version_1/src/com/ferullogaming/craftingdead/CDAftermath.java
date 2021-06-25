package com.ferullogaming.craftingdead;

import com.ferullogaming.craftingdead.block.BlockManager;
import com.ferullogaming.craftingdead.client.ClientEvents;
import com.ferullogaming.craftingdead.client.GuiHandler;
import com.ferullogaming.craftingdead.client.OverlayHandler;
import com.ferullogaming.craftingdead.client.util.ClientManager;
import com.ferullogaming.craftingdead.client.util.SoundHandler;
import com.ferullogaming.craftingdead.commands.CommandManager;
import com.ferullogaming.craftingdead.entity.EntityManager;
import com.ferullogaming.craftingdead.item.ItemManager;
import com.ferullogaming.craftingdead.network.NetworkManager;
import com.ferullogaming.craftingdead.network.PacketHandler;
import com.ferullogaming.craftingdead.network.PacketHandlerClient;
import com.ferullogaming.craftingdead.player.PlayerDataHandler;
import com.ferullogaming.craftingdead.world.WorldManager;

import api.player.render.RenderPlayerAPI;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.event.FMLServerStoppedEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkMod.SidedPacketHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.relauncher.Side;

@Mod(modid = "CDAftermath", name = "Crafting Dead Aftermath", version = "1.2.7")
@NetworkMod(clientSideRequired = false, serverSideRequired = false, clientPacketHandlerSpec = @SidedPacketHandler(channels = { "cdaNetworking" }, packetHandler = PacketHandlerClient.class), serverPacketHandlerSpec = @SidedPacketHandler(channels = { "cdaNetworking" }, packetHandler = PacketHandler.class))
public class CDAftermath {
	public static final String MOD_ID = "CDAftermath";
	public static final String MOD_VERSION = "0.1";
	public static final String MC_VERSION = "1.6.4";
	public static final String MOD_NAME = "Crafting Dead Aftermath";
	public static final String resLocation = "craftingdead";
	public static boolean needUpdate$ = false;
	public static String folderLocation = "";
	@Instance("CDAftermath")
	public static CDAftermath instance;
	@SidedProxy(clientSide = "com.ferullogaming.craftingdead.client.ClientProxy", serverSide = "com.ferullogaming.craftingdead.CommonProxy")
	public static CommonProxy proxy;
	private ClientManager clientManager;
	private ClientEvents clientEvents;
	private SoundHandler soundHandler;
	private GuiHandler guiHandler;
	private ItemManager itemManager;
	private BlockManager blockManager;
	private NetworkManager networkManager;
	private CommonEvents commonEvents;
	private CommonTickHandler commonTick;
	private CommonPlayerTracker playerTracker;
	private EntityManager entityManager;
	private WorldManager worldManager;
	private CommandManager commandManager;
	private ServerManager serverManager;
	private OverlayHandler overlayHandler;
	private RenderPlayerAPI api;
	private PlayerDataHandler playerDataHandler;

	@EventHandler
	public void preLoad(FMLPreInitializationEvent event) {
		log("Loading Mod...");
		folderLocation = event.getModConfigurationDirectory().getParent() + "/craftingdead/aftermath/";
		if (FMLCommonHandler.instance().getSide() == Side.CLIENT) {
			this.clientEvents = new ClientEvents();
			this.clientManager = new ClientManager(event);
			this.clientManager.initMod();
			this.overlayHandler = new OverlayHandler();
		}

		if (FMLCommonHandler.instance().getSide() == Side.SERVER) {
			this.serverManager = new ServerManager();
		}
	}

	@EventHandler
	public void load(FMLInitializationEvent event) {
		this.commonEvents = new CommonEvents();
		this.commonTick = new CommonTickHandler();
		this.itemManager = new ItemManager();
		this.itemManager.init();
		proxy.initMod();
		this.blockManager = new BlockManager();
		this.blockManager.init();
		this.networkManager = new NetworkManager();
		this.networkManager.init();
		this.entityManager = new EntityManager();
		this.entityManager.init();
		this.worldManager = new WorldManager();
		this.guiHandler = new GuiHandler();
		this.commandManager = new CommandManager();
		this.commandManager.init();
		this.playerTracker = new CommonPlayerTracker();
		NetworkRegistry.instance().registerGuiHandler(this, this.guiHandler);
		this.playerDataHandler = new PlayerDataHandler();
	}

	@EventHandler
	public void postLoad(FMLPostInitializationEvent event) {
		if (FMLCommonHandler.instance().getSide() == Side.CLIENT) {
			this.soundHandler = new SoundHandler();
		}
	}

	@EventHandler
	public void onServerStarted(FMLServerStartingEvent event) {
		this.commandManager.onServerStarted(event);
	}

	public ClientManager getClientManager() {
		return this.clientManager;
	}

	public NetworkManager getNetworkManager() {
		return this.networkManager;
	}

	public CommonEvents getCommonEvents() {
		return this.commonEvents;
	}

	public ClientEvents getClientEvents() {
		return this.clientEvents;
	}

	public SoundHandler getSoundHandler() {
		return this.soundHandler;
	}

	public ItemManager getItemManager() {
		return this.itemManager;
	}

	public EntityManager getEntityManager() {
		return this.entityManager;
	}

	public BlockManager getBlockManager() {
		return this.blockManager;
	}

	public WorldManager getWorldManager() {
		return this.worldManager;
	}

	public ServerManager getServerManager() {
		return this.serverManager;
	}

	public CommonTickHandler getCommonTick() {
		return this.commonTick;
	}

	public static void log(boolean par1) {
		System.out.println("[CDA] " + par1);
	}

	public static void log(int par1) {
		System.out.println("[CDA] " + par1);
	}

	public static void log(String par1) {
		System.out.println("[CDA] " + par1);
	}

	public PlayerDataHandler playerDataHandler() {
		return this.playerDataHandler;
	}
}
