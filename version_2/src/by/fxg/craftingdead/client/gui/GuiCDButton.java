package by.fxg.craftingdead.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

import by.fxg.craftingdead.client.CDRenderHelper;

public class GuiCDButton extends GuiButton {
   public int isOver = 2;
   private ResourceLocation iconTexture = null;
   public ItemStack renderStack = null;
   public String hoverText = "";
   public boolean drawBackground = true;
   public boolean drawShadow = true;
   public String buttonColor = "0x333380";
   public boolean centeredText = true;

   public GuiCDButton(int par1, int par2, int par3, int par4, int par5, String par6Str) {
      super(par1, par2, par3, par4, par5, par6Str);
   }

   public GuiCDButton(int par1, int par2, int par3, ItemStack par4Stack) {
      super(par1, par2, par3, 18, 18, "");
      this.renderStack = par4Stack;
   }

   public GuiCDButton(int par1, int par2, int par3, int par4, int par5, ResourceLocation par6) {
      super(par1, par2, par3, par4, par5, "");
      this.iconTexture = par6;
   }

   public GuiCDButton setCenter(boolean par1) {
      this.centeredText = par1;
      return this;
   }

   public void drawButton(Minecraft par1Minecraft, int par2, int par3) {
      if (super.drawButton) {
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         super.field_82253_i = par2 >= super.xPosition && par3 >= super.yPosition && par2 < super.xPosition + super.width && par3 < super.yPosition + super.height;
         this.isOver = this.getHoverState(super.field_82253_i);
         if (this.drawBackground) {
            if (this.drawShadow) {
               CDRenderHelper.drawRectWithShadow(super.xPosition, super.yPosition, super.width, super.height, this.buttonColor, 1.0F);
            } else {
               CDRenderHelper.drawRect(super.xPosition, super.yPosition, super.width, super.height, this.buttonColor, 1.0F);
            }
         }

         this.mouseDragged(par1Minecraft, par2, par3);
         String displayText = super.displayString;
         if (this.iconTexture != null) {
            if (this.isOver == 2) {
               CDRenderHelper.renderColor(8421504);
            }

            CDRenderHelper.drawImage((double)(super.xPosition + super.width / 2 - 8), (double)(super.yPosition + (super.height - 8) - 10), this.iconTexture, 16.0D, 16.0D);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            return;
         }

         if (this.renderStack != null) {
            CDRenderHelper.renderItemStackIntoGUI(this.renderStack, super.xPosition, super.yPosition + 1);
            return;
         }

         if (!super.enabled) {
            displayText = EnumChatFormatting.GRAY + displayText;
         }

         if (!this.centeredText) {
            CDRenderHelper.renderText(displayText, super.xPosition + 2, super.yPosition + (super.height - 8) / 2, this.isOver == 2 ? 8421504 : 16777215);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            return;
         }

         CDRenderHelper.renderCenteredText(displayText, super.xPosition + super.width / 2, super.yPosition + (super.height - 8) / 2, this.isOver == 2 ? 8421504 : 16777215);
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      }

   }
}
