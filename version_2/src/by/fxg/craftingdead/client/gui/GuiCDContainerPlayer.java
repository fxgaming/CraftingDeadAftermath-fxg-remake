package by.fxg.craftingdead.client.gui;

import by.fxg.craftingdead.client.CDRenderHelper;
import by.fxg.craftingdead.client.util.ClientManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumChatFormatting;

public class GuiCDContainerPlayer extends GuiCDContainer {
   private EntityPlayer player = ClientManager.instance().getFakePlayerManager().getFakePlayer();
   private float playerRotation = 0.0F;

   public GuiCDContainerPlayer(int par1, int par2, int par3, int par4, int par5, GuiCDScreen par6) {
      super(par1, par2, par3, par4, par5, par6);
   }

   public void updateScreen() {
      ++this.playerRotation;
   }

   public void drawScreen(int par1, int par2, float par3) {
      this.drawBackground();
      int px = 0;
      int py = 10;
      CDRenderHelper.renderCenteredText(EnumChatFormatting.BOLD + this.player.username, super.posX + super.width / 2, super.posY + 8);
      CDRenderHelper.drawRectWithShadow(super.posX + 10 + px, super.posY + 12 + py, 80, 130, "0x000000", 1.0F);
      if (this.player != null) {
         CDRenderHelper.renderPlayerModel(this.player, super.posX + super.width / 2 + px, super.posY + super.height - 20 + py, 60.0F, this.playerRotation);
      }

   }
}
