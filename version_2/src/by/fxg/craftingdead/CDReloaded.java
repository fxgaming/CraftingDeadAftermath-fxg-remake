package by.fxg.craftingdead;

import api.player.render.RenderPlayerAPI;
import by.fxg.craftingdead.block.BlockManager;
import by.fxg.craftingdead.client.ClientEvents;
import by.fxg.craftingdead.client.GuiHandler;
import by.fxg.craftingdead.client.OverlayHandler;
import by.fxg.craftingdead.client.util.ClientManager;
import by.fxg.craftingdead.client.util.SoundHandler;
import by.fxg.craftingdead.commands.CommandManager;
import by.fxg.craftingdead.entity.EntityManager;
import by.fxg.craftingdead.item.ItemManager;
import by.fxg.craftingdead.network.NetworkManager;
import by.fxg.craftingdead.network.PacketHandler;
import by.fxg.craftingdead.network.PacketHandlerClient;
import by.fxg.craftingdead.player.PlayerDataHandler;
import by.fxg.craftingdead.world.WorldManager;
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

@Mod(modid = CDReloaded.MOD_ID, name = CDReloaded.MOD_NAME, version = CDReloaded.MOD_VERSION)
@NetworkMod(clientSideRequired = false, serverSideRequired = false, clientPacketHandlerSpec = @SidedPacketHandler(channels = { "cdrNetworking" }, packetHandler = PacketHandlerClient.class), serverPacketHandlerSpec = @SidedPacketHandler(channels = { "cdrNetworking" }, packetHandler = PacketHandler.class))
public class CDReloaded {
	public static final String MOD_ID = "CDR";
	public static final String MOD_VERSION = "0.0.0.1";
	public static final String MC_VERSION = "1.6.4";
	public static final String MOD_NAME = "Crafting Dead Reloaded";
	public static final String resLocation = "craftingdead";
	public static boolean needUpdate$ = false;
	public static String folderLocation = "";
	@Instance(MOD_ID)
	public static CDReloaded instance;
	@SidedProxy(clientSide = "by.fxg.craftingdead.client.ClientProxy", serverSide = "by.fxg.craftingdead.CommonProxy")
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
		folderLocation = event.getModConfigurationDirectory().getParent() + "/craftingdead/reloaded/";
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
		System.out.println("[CDR] " + par1);
	}

	public static void log(int par1) {
		System.out.println("[CDR] " + par1);
	}

	public static void log(String par1) {
		System.out.println("[CDR] " + par1);
	}

	public PlayerDataHandler playerDataHandler() {
		return this.playerDataHandler;
	}
}
