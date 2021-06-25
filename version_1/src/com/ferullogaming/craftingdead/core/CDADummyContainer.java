package com.ferullogaming.craftingdead.core;

import com.google.common.eventbus.Subscribe;
import cpw.mods.fml.common.DummyModContainer;
import cpw.mods.fml.common.LoadController;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.event.FMLConstructionEvent;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import java.util.Arrays;
import net.minecraftforge.event.EventBus;

public class CDADummyContainer extends DummyModContainer {
   public CDADummyContainer() {
      super(new ModMetadata());
      ModMetadata meta = this.getMetadata();
      meta.modId = "CDAftermathCore";
      meta.name = "CDA";
      meta.version = "1.0.0";
      meta.credits = "Extended CDA.";
      meta.authorList = Arrays.asList("F3RULLO14", "FXG");
      meta.description = "";
      meta.url = "http://";
      meta.updateUrl = "";
      meta.screenshots = new String[0];
      meta.logoFile = "";
   }

   @Subscribe
   public boolean registerBus(EventBus bus, LoadController controller) {
      return false;
   }

   @Subscribe
   public void modConstruction(FMLConstructionEvent evt) {
   }

   @Subscribe
   public void preInit(FMLPreInitializationEvent evt) {
   }

   @Subscribe
   public void init(FMLInitializationEvent evt) {
   }

   @Subscribe
   public void postInit(FMLPostInitializationEvent evt) {
   }

   public static void log(String par1) {
      System.out.println("[CDA] " + par1);
   }
}
