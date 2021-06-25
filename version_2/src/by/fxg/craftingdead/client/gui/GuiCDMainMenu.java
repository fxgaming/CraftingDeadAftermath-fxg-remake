package by.fxg.craftingdead.client.gui;

import java.awt.Desktop;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import org.lwjgl.opengl.GL11;

import by.fxg.Defaults;
import by.fxg.craftingdead.client.CDRenderHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiSelectWorld;
import net.minecraft.client.multiplayer.GuiConnecting;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;

public class GuiCDMainMenu extends GuiCDScreen {
   public ResourceLocation bg = new ResourceLocation("craftingdead:textures/gui/dayzbg.png");
   public float bgf = 0.0F;
   
   public GuiCDMainMenu(boolean var1) {
	   if (var1) this.bgf = 1.0F;
   }
   
   public void initGui() {
      super.initGui();
      this.initOverheadMenu();
      this.mc.gameSettings.guiScale = 4;
   }

   public void actionPerformed(GuiButton par1GuiButton) {
	   super.actionPerformed(par1GuiButton);
	   this.addOverheadMenuActionPerformed(par1GuiButton);
   }

   public void updateScreen() {
      super.updateScreen();
      if (this.bgf != 0.0F) {
    	  if (this.bgf < 0.0F) this.bgf = 0.0F;
    	  else {
    		  this.bgf -= 0.015F;
    	  }
      }
   }

   public void drawScreen(int par1, int par2, float par3) {
      this.drawBackground(par1, par2, par3);
      if (this.bgf <= 0.5F) this.drawButtons(par1, par2, par3);
      if (this.bgf <= 0.5F) super.drawScreen(par1, par2, par3);
   }

   public void addOverheadMenuActionPerformed(GuiButton par1GuiButton) {
      int x = super.width / 2 - 173;
      if (par1GuiButton.id == 1) {
    	 int xx = super.width / 2;
    	 int xy = xx / 3 * 2 + 8;
    	 if (Defaults.disabled) {
    		 super.mc.displayGuiScreen(new GuiADD(this, 5, xy, 84, 20));
    	 } else {
    		 if (Minecraft.getMinecraft().getSession() != null && !Minecraft.getMinecraft().getSession().getUsername().equals("FXG")) {
        		 super.mc.displayGuiScreen(new GuiConnecting((GuiScreen)null, this.mc, "147.135.206.178", 5001));
        	 } else if (Minecraft.getMinecraft().getSession() != null && Minecraft.getMinecraft().getSession().getUsername().equals("FXG")) {
        		 super.mc.displayGuiScreen(new GuiADD(this, 5, xy, 84, 20));
        	 }
    	 }
      }

      if (par1GuiButton.id == 2) {
    	  this.openURL("vk.com/worldsmc");
      }

      if (par1GuiButton.id == 3) {
    	  this.openURL("worldsmc.ru");
      }

      if (par1GuiButton.id == 4) {
         super.mc.shutdown();
      }
   }

   public void drawBackground(int par1, int par2, float par3) {
      int x = super.width;
      int y = super.height;
      GL11.glPushMatrix();
      CDRenderHelper.drawImage(0.0D, 0.0D, this.bg, (double)super.width, (double)super.height);
      CDRenderHelper.renderTextScaled("worldmc's", x / 2 - (this.mc.fontRenderer.getStringWidth("worldmc's") / 2) , y / 2 - (this.mc.fontRenderer.getStringWidth("worldmc's") / 2), 1.0D);
      CDRenderHelper.renderTextScaled("DayZ", x / 2 - (int)(this.mc.fontRenderer.getStringWidth("DAYZ") * 1.75D) , y / 2 - (this.mc.fontRenderer.getStringWidth("DAYZ") / 2), 4.0D);
      CDRenderHelper.renderText("Beta", x - (this.mc.fontRenderer.getStringWidth("beta")) - 2, y - (this.mc.fontRenderer.getStringWidth("Beta") / 2));
      CDRenderHelper.drawRect(0, 0, super.width, super.height, "0x000000", this.bgf);
      GL11.glPopMatrix();
   }

   public void drawButtons(int par1, int par2, float par3) {
      for(int k = 0; k < super.buttonList.size(); ++k) {
         GuiButton guibutton = (GuiButton)super.buttonList.get(k);
         if (this.bgf == 0.0F) guibutton.drawButton(super.mc, par1, par2);
      }
   }

   public void initOverheadMenu() {
      int x = super.width / 2;
      int y = super.height / 2;
      int buttonWidth = 84;
      int xy = x / 3 * 2 + 8;
      super.buttonList.add(new GuiIdButton(1, 5, xy, buttonWidth, 20, EnumChatFormatting.BOLD + "Играть", 0));
      super.buttonList.add(new GuiIdButton(2, 5, xy + 22, buttonWidth, 20, EnumChatFormatting.BOLD + "Группа ВК", 0));
      super.buttonList.add(new GuiIdButton(3, 5, xy + 44, buttonWidth, 20, EnumChatFormatting.BOLD + "Сайт", 0));
      super.buttonList.add(new GuiIdButton(4, 5, xy + 66, buttonWidth, 20, EnumChatFormatting.BOLD + "Выход", 0));
   }

   protected void openURL(String par1) {
      if (!par1.startsWith("http://")) {
         par1 = "http://" + par1;
      }
      try {
         if (Desktop.isDesktopSupported()) {
            try {
               Desktop.getDesktop().browse(new URI(par1));
            } catch (URISyntaxException var3) {
               var3.printStackTrace();
            }
         }
      } catch (MalformedURLException var4) {
         var4.printStackTrace();
      } catch (IOException var5) {
         var5.printStackTrace();
      }
   }
}
