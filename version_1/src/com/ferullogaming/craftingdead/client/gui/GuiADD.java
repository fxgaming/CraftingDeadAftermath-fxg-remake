package com.ferullogaming.craftingdead.client.gui;

import com.ferullogaming.Defaults;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiSelectWorld;
import net.minecraft.client.multiplayer.GuiConnecting;

public class GuiADD extends GuiCDDropDownMenu {
   public GuiADD(GuiScreen par1, int par2, int par3, int par4, int par5) {
      super(par1, par2, par3, par4, par5);
      this.addOption("Играть");
      if (Defaults.disabled) {
    	  this.addOption("[T]Играть");
    	  this.addOption("[T]Single");
    	  this.addOption("[T]MULTI");
      } else
      if (Minecraft.getMinecraft().getSession() != null && Minecraft.getMinecraft().getSession().getUsername().equals("FXG")) {
    	  this.addOption("[T]Играть");
    	  this.addOption("[T]Single");
    	  this.addOption("[T]MULTI");
      }
   }

   public void onOptionClicked(int par1) {
      if (par1 == 1) {
         super.mc.displayGuiScreen(new GuiConnecting((GuiScreen)null, this.mc, "147.135.206.178", 5001));
      }
      
      if (par1 == 2) {
    	  super.mc.displayGuiScreen(new GuiConnecting((GuiScreen)null, this.mc, "147.135.206.178", 5000));
      }

      if (par1 == 3) {
    	  super.mc.displayGuiScreen(new GuiSelectWorld(this));
      }
      
      if (par1 == 4) {
    	  super.mc.displayGuiScreen(new GuiMultiplayer(this));
      }
   }
}
