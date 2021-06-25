package com.ferullogaming.craftingdead.client.gui;

import com.ferullogaming.craftingdead.client.CDRenderHelper;
import com.ferullogaming.craftingdead.client.util.ClientManager;

import net.minecraft.client.Minecraft;
import net.minecraft.util.EnumChatFormatting;

public class GuiCDContainerPlayerInfo extends GuiCDContainer {
   public GuiCDContainerPlayerInfo(int par1, int par2, int par3, int par4, int par5, GuiCDScreen par6) {
      super(par1, par2, par3, par4, par5, par6);
   }

   public void drawScreen(int par1, int par2, float par3) {
      this.drawBackground();
      String username = Minecraft.getMinecraft().getSession().getUsername();
      CDRenderHelper.renderPlayerHead(username, super.posX + 4, super.posY + 4);
      CDRenderHelper.renderText(username, super.posX + 26, super.posY + 4);
      //CDRenderHelper.renderText("V", super.posX + 26, super.posY + 15);
      //int var1 = ClientManager.PLAYERS_ONLINE;
      //String var1a = ClientManager.PLAYERS_POPULATIONAR1;
      //CDRenderHelper.renderText(EnumChatFormatting.GRAY + "Users Online " + EnumChatFormatting.AQUA + var1a, super.posX + 4, super.posY + 28);
   }
}
