package com.ferullogaming.craftingdead.client.gui;

import com.ferullogaming.craftingdead.client.CDRenderHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class GuiIdButton extends GuiButton {
   public int isOver = 2;
   public String hoverText = "";
   public boolean drawBackground = true;
   public boolean drawShadow = true;
   public boolean centeredText = true;
   public int id;

   public GuiIdButton(int par1, int par2, int par3, int par4, int par5, String par6Str, int id) {
      super(par1, par2, par3, par4, par5, par6Str);
      this.id = id;
   }

   public GuiIdButton setCenter(boolean par1) {
      this.centeredText = par1;
      return this;
   }

   public void drawButton(Minecraft par1Minecraft, int par2, int par3) {
      if (super.drawButton) {
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         super.field_82253_i = par2 >= super.xPosition && par3 >= super.yPosition && par2 < super.xPosition + super.width && par3 < super.yPosition + super.height;
         this.isOver = this.getHoverState(super.field_82253_i);
         if (this.id == 0) {
        	 this.drawBackground = false;
        	 if (this.isOver == 1) CDRenderHelper.drawRect(super.xPosition, super.yPosition, super.width, super.height, "0x444444", 0.1F);
        	 else if (!super.enabled) CDRenderHelper.drawRect(super.xPosition, super.yPosition, super.width, super.height, "0x111111", 0.9F);
        	 else CDRenderHelper.drawRect(super.xPosition, super.yPosition, super.width, super.height, "0xFF2626", 0.3F);
         } else if (this.id == 1) {
        	 this.drawBackground = false;
        	 
         }
         
         this.mouseDragged(par1Minecraft, par2, par3);
         String displayText = super.displayString;

         if (!super.enabled) {
            displayText = EnumChatFormatting.WHITE + displayText;
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
