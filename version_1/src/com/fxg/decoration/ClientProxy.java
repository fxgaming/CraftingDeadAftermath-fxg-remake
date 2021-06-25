package com.fxg.decoration;

import com.fxg.decoration.model.ModelDebug;
import com.fxg.decoration.model.block.ModelAlarmBell;
import com.fxg.decoration.model.block.ModelAmmoCrateLarge;
import com.fxg.decoration.model.block.ModelBarrel;
import com.fxg.decoration.model.block.ModelBarrier;
import com.fxg.decoration.model.block.ModelBicycle;
import com.fxg.decoration.model.block.ModelBodyBag;
import com.fxg.decoration.model.block.ModelCCTV;
import com.fxg.decoration.model.block.ModelCanFire;
import com.fxg.decoration.model.block.ModelCanTrap;
import com.fxg.decoration.model.block.ModelCarePackage;
import com.fxg.decoration.model.block.ModelCeilingVent;
import com.fxg.decoration.model.block.ModelCeilingVentCorner;
import com.fxg.decoration.model.block.ModelChair;
import com.fxg.decoration.model.block.ModelChesstable;
import com.fxg.decoration.model.block.ModelCone;
import com.fxg.decoration.model.block.ModelCrate;
import com.fxg.decoration.model.block.ModelDumpster;
import com.fxg.decoration.model.block.ModelElectricBox1;
import com.fxg.decoration.model.block.ModelElectricBox2;
import com.fxg.decoration.model.block.ModelElectricBoxBin;
import com.fxg.decoration.model.block.ModelExitLight;
import com.fxg.decoration.model.block.ModelFlagPoll;
import com.fxg.decoration.model.block.ModelFlatscreenTV;
import com.fxg.decoration.model.block.ModelHangingPlayer;
import com.fxg.decoration.model.block.ModelHazardLamp;
import com.fxg.decoration.model.block.ModelHazardLight;
import com.fxg.decoration.model.block.ModelHazardbarrier;
import com.fxg.decoration.model.block.ModelHazardpole;
import com.fxg.decoration.model.block.ModelHedgehog;
import com.fxg.decoration.model.block.ModelLantern;
import com.fxg.decoration.model.block.ModelLight;
import com.fxg.decoration.model.block.ModelMailbox;
import com.fxg.decoration.model.block.ModelMaintenanceScreen;
import com.fxg.decoration.model.block.ModelMechWreckage;
import com.fxg.decoration.model.block.ModelTrashbox1;
import com.fxg.decoration.render.RenderBaseProp;
import com.fxg.decoration.render.RenderPropAsItem;
import com.fxg.decoration.tile.block.TileAlarmBell;
import com.fxg.decoration.tile.block.TileAmmoCrateLarge;
import com.fxg.decoration.tile.block.TileBarrel;
import com.fxg.decoration.tile.block.TileBarrier;
import com.fxg.decoration.tile.block.TileBicycle;
import com.fxg.decoration.tile.block.TileBodyBag;
import com.fxg.decoration.tile.block.TileCCTV;
import com.fxg.decoration.tile.block.TileCanFire;
import com.fxg.decoration.tile.block.TileCanTrap;
import com.fxg.decoration.tile.block.TileCarePackage;
import com.fxg.decoration.tile.block.TileCeilingVent;
import com.fxg.decoration.tile.block.TileCeilingVentCorner;
import com.fxg.decoration.tile.block.TileChair;
import com.fxg.decoration.tile.block.TileChesstable;
import com.fxg.decoration.tile.block.TileCone;
import com.fxg.decoration.tile.block.TileCrate;
import com.fxg.decoration.tile.block.TileDebug;
import com.fxg.decoration.tile.block.TileDumpster;
import com.fxg.decoration.tile.block.TileElectricBox1;
import com.fxg.decoration.tile.block.TileElectricBox2;
import com.fxg.decoration.tile.block.TileElectricBoxBin;
import com.fxg.decoration.tile.block.TileExitLight;
import com.fxg.decoration.tile.block.TileFlagPoll;
import com.fxg.decoration.tile.block.TileFlatscreenTV;
import com.fxg.decoration.tile.block.TileHangingPlayer;
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

import cpw.mods.fml.client.registry.ClientRegistry;
import net.minecraft.block.Block;
import net.minecraft.client.model.ModelBase;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends ServerProxy {
	public void init() {
		register(TileDebug.class, CDDecoration.debugBlock, new ModelDebug(), "debug");
		register(TileTrashbox1.class, CDDecoration.a, new ModelTrashbox1(), "trashbox");
		register(TileAlarmBell.class, CDDecoration.b, new ModelAlarmBell(), "alarmbell");
		register(TileAmmoCrateLarge.class, CDDecoration.c, new ModelAmmoCrateLarge(), "ammocratelarge");
		register(TileBarrier.class, CDDecoration.d, new ModelBarrier(), "barrier");
		register(TileBicycle.class, CDDecoration.e, new ModelBicycle(), "bicycle");
		register(TileBarrel.class, CDDecoration.f, new ModelBarrel(), "barrel");
		register(TileCanFire.class, CDDecoration.g, new ModelCanFire(), "canfire");
		register(TileCanTrap.class, CDDecoration.h, new ModelCanTrap(), "cantrap");
		register(TileBodyBag.class, CDDecoration.i, new ModelBodyBag(), "bodybag");
		register(TileCarePackage.class, CDDecoration.j, new ModelCarePackage(), "carepackage");
		register(TileCCTV.class, CDDecoration.k, new ModelCCTV(), "cctv");
		register(TileCeilingVent.class, CDDecoration.l, new ModelCeilingVent(), "vent");
		register(TileCeilingVentCorner.class, CDDecoration.m, new ModelCeilingVentCorner(), "ventc");
		register(TileChair.class, CDDecoration.n, new ModelChair(), "chair");
		register(TileChesstable.class, CDDecoration.o, new ModelChesstable(), "chesstable");
		register(TileCone.class, CDDecoration.p, new ModelCone(), "cone");
		register(TileCrate.class, CDDecoration.q, new ModelCrate(), "crate");
		register(TileDumpster.class, CDDecoration.r, new ModelDumpster(), "dumpster");
		register(TileElectricBox1.class, CDDecoration.s, new ModelElectricBox1(), "electricbox1");
		register(TileElectricBox2.class, CDDecoration.t, new ModelElectricBox2(), "electricbox2");
		register(TileElectricBoxBin.class, CDDecoration.u, new ModelElectricBoxBin(), "electricboxbin");
		register(TileExitLight.class, CDDecoration.v, new ModelExitLight(), "exitlight");
		register(TileFlagPoll.class, CDDecoration.w, new ModelFlagPoll(), "flagpoll");
		register(TileFlatscreenTV.class, CDDecoration.x, new ModelFlatscreenTV(), "flatscreen");
		register(TileHangingPlayer.class, CDDecoration.y, new ModelHangingPlayer(), "hangingplayer");
		register(TileHazardbarrier.class, CDDecoration.z, new ModelHazardbarrier(), "hazardbarrier");
		register(TileHazardLamp.class, CDDecoration.aa, new ModelHazardLamp(), "hazardlamp");
		register(TileHazardLight.class, CDDecoration.ab, new ModelHazardLight(), "hazardlight");
		register(TileHazardpole.class, CDDecoration.ac, new ModelHazardpole(), "hazardpole");
		register(TileHedgehog.class, CDDecoration.ad, new ModelHedgehog(), "hedgehog");
		register(TileLantern.class, CDDecoration.ae, new ModelLantern(), "lantern");
		register(TileLight.class, CDDecoration.af, new ModelLight(), "light");
		register(TileMailbox.class, CDDecoration.ag, new ModelMailbox(), "mailbox");
		register(TileMaintenanceScreen.class, CDDecoration.ah, new ModelMaintenanceScreen(), "maintenancescreen");
		register(TileMechWreckage.class, CDDecoration.ai, new ModelMechWreckage(), "mechwreckage");


		
	}
	
	private void register(Class<? extends TileEntity> tile, Block block, ModelBase model, String texture) {
		ClientRegistry.bindTileEntitySpecialRenderer(tile, new RenderBaseProp(model, texture));
		MinecraftForgeClient.registerItemRenderer(block.blockID, new RenderPropAsItem(model, texture));
	}
}
