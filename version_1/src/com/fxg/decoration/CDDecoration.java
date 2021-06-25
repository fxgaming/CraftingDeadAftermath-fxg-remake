package com.fxg.decoration;

import java.lang.reflect.Field;

import com.fxg.decoration.block.BlockAlarmBell;
import com.fxg.decoration.block.BlockBaseProp;
import com.fxg.decoration.block.BlockCanFire;
import com.fxg.decoration.block.BlockCanTrap;
import com.fxg.decoration.block.BlockElectricBox1;
import com.fxg.decoration.block.BlockElectricBox2;
import com.fxg.decoration.block.BlockElectricBoxBin;
import com.fxg.decoration.block.BlockHangingPlayer;
import com.fxg.decoration.command.CommandWG;
import com.fxg.decoration.network.NetworkManager;
import com.fxg.decoration.network.PacketHandler;
import com.fxg.decoration.tile.TileBaseProp;
import com.fxg.decoration.tile.block.TileAmmoCrateLarge;
import com.fxg.decoration.tile.block.TileBarrel;
import com.fxg.decoration.tile.block.TileBarrier;
import com.fxg.decoration.tile.block.TileBicycle;
import com.fxg.decoration.tile.block.TileBodyBag;
import com.fxg.decoration.tile.block.TileCCTV;
import com.fxg.decoration.tile.block.TileCarePackage;
import com.fxg.decoration.tile.block.TileCeilingVent;
import com.fxg.decoration.tile.block.TileCeilingVentCorner;
import com.fxg.decoration.tile.block.TileChair;
import com.fxg.decoration.tile.block.TileChesstable;
import com.fxg.decoration.tile.block.TileCone;
import com.fxg.decoration.tile.block.TileCrate;
import com.fxg.decoration.tile.block.TileDebug;
import com.fxg.decoration.tile.block.TileDumpster;
import com.fxg.decoration.tile.block.TileExitLight;
import com.fxg.decoration.tile.block.TileFlagPoll;
import com.fxg.decoration.tile.block.TileFlatscreenTV;
import com.fxg.decoration.tile.block.TileHazardLamp;
import com.fxg.decoration.tile.block.TileHazardLight;
import com.fxg.decoration.tile.block.TileHazardbarrier;
import com.fxg.decoration.tile.block.TileHazardpole;
import com.fxg.decoration.tile.block.TileHedgehog;
import com.fxg.decoration.tile.block.TileLantern;
import com.fxg.decoration.tile.block.TileLight;
import com.fxg.decoration.tile.block.TileMailbox;
import com.fxg.decoration.tile.block.TileMaintenanceScreen;
import com.fxg.decoration.tile.block.TileMechWreckage;
import com.fxg.decoration.tile.block.TileTrashbox1;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.ServerStarting;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;

//@Mod(modid = "CDDecoration", name = "Crafting Dead Decoration", version = "0")
//@NetworkMod(clientSideRequired = true, serverSideRequired = false, channels = {"cddNetworking"}, packetHandler = PacketHandler.class)
public class CDDecoration {
	public CDDecoration() {
	}
	
	@Instance("CDDecoration")
	public static CDDecoration instance;
	@SidedProxy(clientSide = "com.fxg.decoration.ClientProxy", serverSide = "com.fxg.decoration.ServerProxy")
	public static ServerProxy proxy;
	public static NetworkManager networkManager;
	public static GuiHandler guiHandler;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent e) {
		this.instance = this;
		this.networkManager = new NetworkManager();
		this.guiHandler = new GuiHandler();
		NetworkRegistry.instance().registerGuiHandler(this, this.guiHandler);
		this.networkManager.init();
	}
	
//	public static CreativeTabs tabDecor = new CreativeTabs("CDDecoration.tabDecor") {
//	    public int getTabIconItemIndex() {
//	        return 32;
//	    }
//	    @SideOnly(Side.CLIENT)
//	    public String getTabLabel() {
//	        return "CD Decorations";
//	    }
//	};
	public static BlockBaseProp debugBlock;
	public static BlockBaseProp a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z,aa,ab,ac,ad,ae,af,ag,ah,ai,aj,ak,al,am,an,ao,ap,aq,ar,as,at,au,av,aw,ax,ay,az;
	@EventHandler
	public void init(FMLInitializationEvent e) {
		registerBlock(TileDebug.class, "TileDebug", "debugBlock", "Дебаг блок", 1999);
		registerBlock(TileTrashbox1.class, "TileTrashbox1", "a", "Мусорный бак", 2000);
		b = new BlockAlarmBell(2001);
		registerBlock(TileAmmoCrateLarge.class, "TileAmmoCrateLarge", "c", "Ящик с патронами", 2003);
		registerBlock(TileBarrier.class, "TileBarrier", "d", "Бетонная ограда", 2004);
		registerBlock(TileBicycle.class, "TileBicycle", "e", "Велосипед", 2005).setNoCollide();
		registerBlock(TileBarrel.class, "TileBarrel", "f", "Бочка", 2006);
		g = new BlockCanFire(2007);
		h = new BlockCanTrap(2008);
		registerBlock(TileBodyBag.class, "TileBodyBag", "i", "Завернутый труп", 2009);
		registerBlock(TileCarePackage.class, "TileCarePackage", "j", "Хрупкий груз", 2010);
		registerBlock(TileCCTV.class, "TileCCTV", "k", "CCTV", 2011);
		registerBlock(TileCeilingVent.class, "TileCeilingVent", "l", "Вентиляция", 2012);
		registerBlock(TileCeilingVentCorner.class, "TileCeilingVentCorner", "m", "Вентиляция угол", 2013);
		registerBlock(TileChair.class, "TileChair", "n", "Стул", 2014);
		registerBlock(TileChesstable.class, "TileChessTable", "o", "Стол для шахмат", 2015);
		registerBlock(TileCone.class, "TileCone", "p", "Конус", 2016);
		registerBlock(TileCrate.class, "TileCrate", "q", "Ящик", 2017);
		registerBlock(TileDumpster.class, "TileDumpster", "r", "Мусорный ящик", 2018);
		s = new BlockElectricBox1(2019);
		t = new BlockElectricBox2(2020);
		u = new BlockElectricBoxBin(2021);
		registerBlock(TileExitLight.class, "TileExitLight", "v", "Лампа ВЫХОД", 2022).setNoCollide().setLightValue(1.0F);
		registerBlock(TileFlagPoll.class, "TileFlagPoll", "w", "Флагшток с флагом", 2023).setNoCollide();
		registerBlock(TileFlatscreenTV.class, "TileFlatscreenTV", "x", "Телевизор", 2024).setNoCollide();
		y = new BlockHangingPlayer(2025);
		registerBlock(TileHazardbarrier.class, "TileHazardbarrier", "z", "Барьер", 2026).setNoCollide();
		registerBlock(TileHazardLamp.class, "TileHazardLamp", "aa", "Лампа", 2027);
		registerBlock(TileHazardLight.class, "TileHazardLight", "ab", "Свет", 2028);
		registerBlock(TileHazardpole.class, "TileHazardpole", "ac", "Полюс", 2029);
		registerBlock(TileHedgehog.class, "TileHedgehog", "ad", "Дорожный ёж", 2030);
		registerBlock(TileLantern.class, "TileLantern", "ae", "Лампа", 2031).setLightValue(1.0F);
		registerBlock(TileLight.class, "TileLight", "af", "Свет", 2032).setNoCollide().setLightValue(1.0F);
		registerBlock(TileMailbox.class, "TileMailbox", "ag", "Почтовая коробка", 2033);
		registerBlock(TileMaintenanceScreen.class, "TileMaintenanceScreen", "ah", "Maintenance screen", 2034);
		registerBlock(TileMechWreckage.class, "TileMechWreckage", "ai", "Mech Wreckage", 2035);
		
		this.proxy.init();
	}
	/*
	 * Trashboxes - 2000-2010
	 * Hydrants - 2011-2020
	 * Trash - 2021-2040
	 * Cars - 2041-2055
	 * Killed Persons - 2056-2065
	 * Killed Zombies - 2066-2075
	 * Skeletons - 2076-2085
	 * Doors[INACTIVE] - 2086-2100
	 * Doors[ACTIVE] - 2101-2110
	 * Windows/Glass - 2111-2125
	 * Closets - 2126-2135
	 * Road Tabs - 2136-2145
	 * Road Tabs[ACTIVE] 2146-2155
	 * 
	 * 
	 * <RP>
	 * Radioactive Materials - 2501-2510
	 * Gore - 2511-2530
	 * House destructions - 2531-2600
	 * Windows destructions - 2601-2610
	 * Decorations - 2611-2750
	 * 
	 */
	
	private int next = 1999;
	private int next() {
		this.next++;
		return this.next;
	}
	
	private BlockBaseProp registerBlock(Class tile, TileBaseProp tileobj, String field, String name, int id) {
		try {
			GameRegistry.registerTileEntity(tile, tile.getSimpleName());
			Field f = this.getClass().getField(field);
			Object fo = f.get(this.getClass());
			GameRegistry.registerBlock((Block)(fo = new BlockBaseProp(id, tileobj).setRotateable().install(tile.getSimpleName() + ".block")), tile.getSimpleName() + ".item");
			LanguageRegistry.addName(fo, name); 
			f.set(this.getClass(), fo);
			return (BlockBaseProp)fo;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private BlockBaseProp registerBlock(Class tile, String tileobj, String field, String name, int id) {
		try {
			GameRegistry.registerTileEntity(tile, tile.getSimpleName());
			Field f = this.getClass().getField(field);
			Object fo = f.get(this.getClass());
			GameRegistry.registerBlock((Block)(fo = new BlockBaseProp(id, tileobj).setRotateable().install(tile.getSimpleName() + ".block")), tile.getSimpleName() + ".item");
			LanguageRegistry.addName(fo, name); 
			f.set(this.getClass(), fo);
			return (BlockBaseProp)fo;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@ServerStarting
	public void serv(FMLServerStartingEvent e) {
		e.registerServerCommand(new CommandWG());
	}
}
