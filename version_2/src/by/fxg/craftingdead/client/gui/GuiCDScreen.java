package by.fxg.craftingdead.client.gui;

import java.util.ArrayList;
import java.util.Iterator;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;

public class GuiCDScreen extends GuiScreen {
   private ArrayList guiContainers = new ArrayList();

   public void initGui() {
      this.guiContainers.clear();
   }

   public void actionPerformed(GuiButton par1GuiButton) {
      this.addContainerAction(par1GuiButton);
   }

   public void updateScreen() {
      this.addContainerUpdate();
   }

   public void onGuiClosed() {
   }

   public void addContainer(GuiCDContainer par1) {
      par1.initGui();
      this.guiContainers.add(par1);
   }

   public void addContainerUpdate() {
      Iterator var1 = this.guiContainers.iterator();

      while(var1.hasNext()) {
         GuiCDContainer gui = (GuiCDContainer)var1.next();
         gui.updateScreen();
      }

   }

   public void addContainerAction(GuiButton par1GuiButton) {
      Iterator var2 = this.guiContainers.iterator();

      while(var2.hasNext()) {
         GuiCDContainer gui = (GuiCDContainer)var2.next();
         gui.actionPerformed(par1GuiButton);
      }

   }

   public void addContainerDrawing(int par1, int par2, float par3) {
      Iterator var4 = this.guiContainers.iterator();

      while(var4.hasNext()) {
         GuiCDContainer gui = (GuiCDContainer)var4.next();
         gui.drawScreen(par1, par2, par3);
      }

   }

   public GuiCDContainer getContainer(int par1) {
      Iterator var2 = this.guiContainers.iterator();

      GuiCDContainer cont;
      do {
         if (!var2.hasNext()) {
            return null;
         }

         cont = (GuiCDContainer)var2.next();
      } while(cont.containerID != par1);

      return cont;
   }

   public boolean doesGuiPauseGame() {
      return true;
   }

   protected void mouseClicked(int par1, int par2, int par3) {
      super.mouseClicked(par1, par2, par3);
      Iterator var4 = this.guiContainers.iterator();

      while(var4.hasNext()) {
         GuiCDContainer gui = (GuiCDContainer)var4.next();
         gui.mouseClicked(par1, par2, par3);
      }

   }

   public void drawScreen(int par1, int par2, float par3) {
      super.drawScreen(par1, par2, par3);
      this.addContainerDrawing(par1, par2, par3);
   }
}
