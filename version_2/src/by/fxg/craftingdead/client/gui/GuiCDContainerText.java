package by.fxg.craftingdead.client.gui;

import by.fxg.craftingdead.client.CDRenderHelper;

public class GuiCDContainerText extends GuiCDContainer {
   private String[] text;
   private boolean centerText = false;

   public GuiCDContainerText(int par1, int par2, int par3, int par4, int par5, GuiCDScreen par6) {
      super(par1, par2, par3, par4, par5, par6);
   }

   public GuiCDContainerText setText(String... par1) {
      this.text = par1;
      return this;
   }

   public GuiCDContainerText setCentered() {
      this.centerText = true;
      return this;
   }

   public void drawScreen(int par1, int par2, float par3) {
      this.drawBackground();

      for(int i = 0; i < this.text.length; ++i) {
         String var1 = this.text[i];
         if (this.centerText) {
            CDRenderHelper.renderCenteredText(var1, super.posX + super.width / 2, super.posY + 3 + 10 * i);
         } else {
            CDRenderHelper.renderText(var1, super.posX + 3, super.posY + 3 + 10 * i);
         }
      }

   }
}
