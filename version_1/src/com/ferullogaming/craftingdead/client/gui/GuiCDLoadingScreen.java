package com.ferullogaming.craftingdead.client.gui;

import org.lwjgl.opengl.GL11;

import com.ferullogaming.craftingdead.client.CDRenderHelper;
import com.ferullogaming.craftingdead.client.util.ClientManager;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.util.ResourceLocation;

public class GuiCDLoadingScreen extends GuiCDScreen {
   private int scrNum = 0;

   public void updateScreen() {
	   if (this.scrNum++ >= 179) {
		   ClientManager.isGameLoading = false;
		   Minecraft.getMinecraft().displayGuiScreen(new GuiCDMainMenu(true));
	   }
   }

   protected void keyTyped(char par1, int par2) {
	   if (par2 == 1) {
		   this.scrNum = 179;
		   ClientManager.isGameLoading = false;
		   Minecraft.getMinecraft().displayGuiScreen(new GuiCDMainMenu(true));
	   }
   }

   protected void mouseClicked(int par1, int par2, int par3) {
   }

   public void drawScreen(int par1, int par2, float par3) {
	   String screen = "bgs_000";
	   screen += (this.scrNum + "").length() == 1 ? "00" + this.scrNum : ((this.scrNum + "").length() == 2 ? "0" + this.scrNum : ((this.scrNum + "").length() == 3 ? "" + this.scrNum : ""));
	   GL11.glPushMatrix();
	   GL11.glEnable(3042);
	   CDRenderHelper.drawImage(0.0D, 0.0D, new ResourceLocation("craftingdead:textures/misc/start/" + screen + ".png"), (double)super.width, (double)super.height);
	   CDRenderHelper.renderText("Нажмите ESC для пропуска.", 1, new ScaledResolution(this.mc.gameSettings, this.mc.displayWidth, this.mc.displayHeight).getScaledHeight() - 8);
	   GL11.glPopMatrix();
   }
}
