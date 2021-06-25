package by.fxg.craftingdead.client.gui;

import java.awt.Rectangle;

import by.fxg.craftingdead.client.CDRenderHelper;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;

public class GuiCDYesNoPrompt extends GuiCDScreen {
   protected GuiScreen parentGui;
   private boolean isButtonClicked = false;
   private boolean isOpened = false;
   public String[] promptInformation;
   private int promptX;
   private int promptY;
   public int promptWidth = 200;
   public int promptHeight = 70;
   public int promptID = 0;

   public GuiCDYesNoPrompt(int par1, GuiScreen par2) {
      this.promptID = par1;
      this.parentGui = par2;
   }

   public GuiCDYesNoPrompt addInformation(String... par1) {
      this.promptInformation = par1;
      return this;
   }

   public void initGui() {
      this.promptX = super.width / 2 - this.promptWidth / 2;
      this.promptY = super.height / 2 - this.promptHeight / 2 - 40;
      super.buttonList.add(new GuiCDButton(10, this.promptX + 2, this.promptY + this.promptHeight - 22, 80, 20, "No"));
      super.buttonList.add(new GuiCDButton(11, this.promptX + this.promptWidth - 80 - 2, this.promptY + this.promptHeight - 22, 80, 20, "Yes"));
      if (this.isOpened) {
         super.mc.displayGuiScreen(this.parentGui);
      }

      this.isOpened = true;
   }

   public void actionPerformed(GuiButton guibutton) {
      if (guibutton.id == 11 && this.parentGui instanceof IGuiCDPromptYesNo) {
         ((IGuiCDPromptYesNo)this.parentGui).onResult(this.promptID, true);
      }

      if (guibutton.id == 10 && this.parentGui instanceof IGuiCDPromptYesNo) {
         ((IGuiCDPromptYesNo)this.parentGui).onResult(this.promptID, false);
      }

      if (super.mc.currentScreen == this) {
         super.mc.displayGuiScreen(this.parentGui);
      }

   }

   protected void mouseClicked(int par1, int par2, int par3) {
      super.mouseClicked(par1, par2, par3);
      Rectangle rect = new Rectangle(this.promptX, this.promptY, this.promptWidth, this.promptHeight);
      if (!rect.contains(par1, par2)) {
         if (this.isButtonClicked) {
            this.isButtonClicked = false;
         } else {
            if (super.mc.currentScreen == this) {
               super.mc.displayGuiScreen(this.parentGui);
            }

         }
      }
   }

   public void drawScreen(int i, int j, float f) {
      int margin = 0;
      CDRenderHelper.drawRectWithShadow(this.promptX, this.promptY, this.promptWidth, this.promptHeight, "0x4d4d4d", 1.0F);

      int i1;
      for(i1 = 0; i1 < super.buttonList.size(); ++i1) {
         GuiButton guibutton = (GuiButton)super.buttonList.get(i1);
         guibutton.drawButton(super.mc, i, j);
      }

      if (this.promptInformation != null) {
         for(i1 = 0; i1 < this.promptInformation.length; ++i1) {
            String var1 = this.promptInformation[i1];
            CDRenderHelper.renderCenteredText(var1, this.promptX + this.promptWidth / 2, this.promptY + 5 + i1 * 11);
         }
      }

   }
}
