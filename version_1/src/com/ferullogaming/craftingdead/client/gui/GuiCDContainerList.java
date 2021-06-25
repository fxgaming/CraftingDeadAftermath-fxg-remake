package com.ferullogaming.craftingdead.client.gui;

import com.ferullogaming.craftingdead.client.CDRenderHelper;
import java.awt.Rectangle;
import java.util.ArrayList;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.input.Mouse;

public class GuiCDContainerList extends GuiCDContainer {
   private ArrayList slots = new ArrayList();
   private int mouseX;
   private int mouseY;
   private Rectangle scollerBox;
   private int scollerMinY = 0;
   private int scollerMaxY = 0;
   private boolean isScollerClicked = false;
   private int slotHeight = 11;
   private int selectedSlot = -1;

   public GuiCDContainerList(int par1, int par2, int par3, int par4, int par5, GuiCDScreen par6) {
      super(par1, par2, par3, par4, par5, par6);
   }

   public GuiCDContainerList setContent(ArrayList par1) {
      this.updateDisplayedSlots(par1);
      return this;
   }

   public GuiCDContainerList setSlotHeight(int par1) {
      this.slotHeight = par1;
      return this;
   }

   public void initGui() {
      this.scollerBox = new Rectangle(super.posX + super.width - 21, super.posY + 1, 20, 40);
      this.scollerMinY = super.posY + 2;
      this.scollerMaxY = super.posY + super.height - 2 - this.scollerBox.height;
   }

   public void updateScreen() {
      this.updateScollerStatus();

      int newY;
      for(newY = 0; newY < this.slots.size(); ++newY) {
         GuiCDContainerListSlot slot = (GuiCDContainerListSlot)this.slots.get(newY);
         slot.onUpdate();
      }

      if (this.isScollerClicked) {
         newY = this.mouseY - this.scollerBox.height / 2;
         if (newY > this.scollerMaxY) {
            newY = this.scollerMaxY;
         }

         if (newY < this.scollerMinY) {
            newY = this.scollerMinY;
         }

         this.scollerBox = new Rectangle(this.scollerBox.x, newY, this.scollerBox.width, this.scollerBox.height);
      }

   }

   public void mouseClicked(int par1, int par2, int par3) {
      for(int i = 0; i < this.slots.size(); ++i) {
         GuiCDContainerListSlot slot = (GuiCDContainerListSlot)this.slots.get(i);
         Rectangle rect = new Rectangle(slot.posX, slot.posY, super.width - 20, this.slotHeight);
         if (rect.contains(par1, par2) && slot.canSelect()) {
            if (this.selectedSlot == i) {
               slot.onDoubleClick();
            }

            this.selectedSlot = i;
         }
      }

   }

   public void scrollUp() {
   }

   public void scrollDown() {
   }

   public void updateScollerStatus() {
      if (Mouse.isButtonDown(0)) {
         if (this.scollerBox.contains(this.mouseX, this.mouseY)) {
            this.isScollerClicked = true;
         }
      } else {
         this.isScollerClicked = false;
      }

   }

   public int getScollerPercentage() {
      int var1 = this.scollerMaxY - this.scollerMinY;
      int var2 = this.scollerBox.y - this.scollerBox.height / 2 - (this.scollerMinY - this.scollerBox.height / 2);
      float var3 = (float)(var2 * 100 / var1);
      return (int)var3;
   }

   public void drawScreen(int par1, int par2, float par3) {
      this.drawBackground();
      this.mouseX = par1;
      this.mouseY = par2;
      this.updateScrollWheel();
      int textHeight = this.slots.size() * this.slotHeight;
      int textPercentage = (textHeight - super.height) * this.getScollerPercentage() / 100;
      if (textHeight > super.height) {
         CDRenderHelper.drawRect(super.posX + super.width - 18, super.posY + 4, this.scollerBox.width - 6, super.height - 7, "0x000000", 1.0F);
         CDRenderHelper.drawImage((double)this.scollerBox.x, (double)this.scollerBox.y, new ResourceLocation("craftingdead:textures/gui/menu/scoller.png"), (double)this.scollerBox.width, (double)this.scollerBox.height);
      }

      for(int i = 0; i < this.slots.size(); ++i) {
         boolean flag = this.selectedSlot == i;
         int textPosY = super.posY + 2 + this.slotHeight * i - (textHeight > super.height ? textPercentage : 0);
         int var1 = textPosY - super.posY - 2;
         if (var1 % this.slotHeight != 0) {
            textPosY -= var1 % this.slotHeight;
         }

         if (var1 >= 0) {
            ((GuiCDContainerListSlot)this.slots.get(i)).posX = super.posX;
            ((GuiCDContainerListSlot)this.slots.get(i)).posY = textPosY;
            if (textPosY >= super.posY - 2 && textPosY <= super.posY + super.height - 2 - (this.slotHeight - 6)) {
               ((GuiCDContainerListSlot)this.slots.get(i)).doRender(super.posX + 4, textPosY, flag, super.width - 30, this.slotHeight);
            }
         }
      }

   }

   public void updateScrollWheel() {
      int l2 = 0;
      if (!Mouse.isButtonDown(0)) {
         Rectangle rect = new Rectangle(super.posX, super.posY, super.width, super.height);
         if (rect.contains(this.mouseX, this.mouseY)) {
            int newY;
            for(; Mouse.next() && (l2 = Mouse.getEventDWheel()) != 0; this.scollerBox = new Rectangle(this.scollerBox.x, newY, this.scollerBox.width, this.scollerBox.height)) {
               if (l2 > 0) {
                  l2 = -1;
               } else if (l2 < 0) {
                  l2 = 1;
               }

               newY = this.scollerBox.y + l2 * this.slotHeight;
               if (newY > this.scollerMaxY) {
                  newY = this.scollerMaxY;
               }

               if (newY < this.scollerMinY) {
                  newY = this.scollerMinY;
               }
            }

         }
      }
   }

   public GuiCDContainerListSlot getSlectedSlot() {
      return this.selectedSlot == -1 ? null : (GuiCDContainerListSlot)this.slots.get(this.selectedSlot);
   }

   public void updateDisplayedSlots(ArrayList par1) {
      this.slots.clear();
      this.slots.addAll(par1);
   }
}
