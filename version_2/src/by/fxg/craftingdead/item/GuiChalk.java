package by.fxg.craftingdead.item;

import by.fxg.craftingdead.client.CDRenderHelper;
import by.fxg.craftingdead.client.gui.GuiCDButton;
import by.fxg.craftingdead.network.CDAPacketChalk;
import cpw.mods.fml.common.network.PacketDispatcher;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.util.EnumChatFormatting;

public class GuiChalk extends GuiScreen {
   public GuiTextField promptInputText;

   public void initGui() {
      this.promptInputText = new GuiTextField(super.fontRenderer, super.width / 2 - 75, super.height / 2 - 15, 150, 20);
      this.promptInputText.setMaxStringLength(16);
      this.promptInputText.setText("");
      super.buttonList.add(new GuiCDButton(11, super.width / 2 - 50, super.height / 2 + 10, 100, 20, "Confirm"));
   }

   protected void actionPerformed(GuiButton par1GuiButton) {
      if (par1GuiButton.id == 11) {
         String name = this.promptInputText.getText();
         if (name.length() > 0) {
            PacketDispatcher.sendPacketToServer(CDAPacketChalk.buildPacket(name));
         }

         super.mc.displayGuiScreen((GuiScreen)null);
      }

   }

   public void updateScreen() {
      this.promptInputText.updateCursorCounter();
   }

   protected void keyTyped(char par1, int par2) {
      super.keyTyped(par1, par2);
      this.promptInputText.textboxKeyTyped(par1, par2);
   }

   protected void mouseClicked(int par1, int par2, int par3) {
      super.mouseClicked(par1, par2, par3);
      this.promptInputText.mouseClicked(par1, par2, par3);
   }

   public boolean doesGuiPauseGame() {
      return false;
   }

   public void drawScreen(int par1, int par2, float par3) {
      CDRenderHelper.drawRectWithShadow(super.width / 2 - 100, super.height / 2 - 35, 200, 70, "0xf3f3f3", 1.0F);
      CDRenderHelper.renderCenteredText(EnumChatFormatting.DARK_GRAY + "" + EnumChatFormatting.BOLD + "Выгравировать!", super.width / 2, super.height / 2 - 30);
      this.promptInputText.drawTextBox();
      super.drawScreen(par1, par2, par3);
   }
}
