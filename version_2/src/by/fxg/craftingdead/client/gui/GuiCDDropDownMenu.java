package by.fxg.craftingdead.client.gui;

import java.util.ArrayList;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;

public abstract class GuiCDDropDownMenu extends GuiCDScreen {
   private GuiScreen parentGui;
   private boolean isButtonClicked = false;
   private boolean isOpened = false;
   private ArrayList optionsList = new ArrayList();
   private int buttonX;
   private int buttonY;
   private int buttonWidth = 85;
   private int buttonHeight = 20;

   public GuiCDDropDownMenu(GuiScreen par1, int par2, int par3, int par4, int par5) {
      this.parentGui = par1;
      this.buttonX = par2;
      this.buttonY = par3;
      this.buttonWidth = par4;
      this.buttonHeight = par5;
      this.optionsList.clear();
   }

   public GuiCDDropDownMenu addOption(String par1) {
      this.optionsList.add(par1);
      return this;
   }

   public void initGui() {
      for(int i = 0; i < this.optionsList.size(); ++i) {
         int y = i * (this.buttonHeight + 1);
         GuiCDButton button = new GuiCDButton(i + 1, this.buttonX, this.buttonY + y, this.buttonWidth, this.buttonHeight, (String)this.optionsList.get(i));
         super.buttonList.add(button);
      }

      if (this.isOpened) {
         super.mc.displayGuiScreen(this.parentGui);
      }

      this.isOpened = true;
   }

   public void actionPerformed(GuiButton guibutton) {
      this.onOptionClicked(guibutton.id);
   }

   public abstract void onOptionClicked(int var1);

   protected void mouseClicked(int par1, int par2, int par3) {
      super.mouseClicked(par1, par2, par3);
      if (!this.isButtonClicked && super.mc.currentScreen == this) {
         super.mc.displayGuiScreen(this.parentGui);
      }

   }

   public void drawScreen(int i, int j, float f) {
      for(int k = 0; k < super.buttonList.size(); ++k) {
         GuiButton guibutton = (GuiButton)super.buttonList.get(k);
         guibutton.drawButton(super.mc, i, j);
      }

   }
}
