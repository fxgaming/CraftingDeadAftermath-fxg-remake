package by.fxg.craftingdead.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerCDChest extends Container {
   private IInventory lowerChestInventory;
   private int numRows;

   public ContainerCDChest(IInventory par1IInventory, IInventory par2IInventory) {
      this.lowerChestInventory = par2IInventory;
      this.numRows = par2IInventory.getSizeInventory() / 9;
      par2IInventory.openChest();
      int i = (this.numRows - 4) * 18;

      int j;
      int k;
      for(j = 0; j < this.numRows; ++j) {
         for(k = 0; k < 9; ++k) {
            this.addSlotToContainer(new Slot(par2IInventory, k + j * 9, 8 + k * 18, 18 + j * 18));
         }
      }

      for(j = 0; j < 3; ++j) {
         for(k = 0; k < 9; ++k) {
            this.addSlotToContainer(new Slot(par1IInventory, k + j * 9 + 9, 8 + k * 18, 103 + j * 18 + i));
         }
      }

      for(j = 0; j < 9; ++j) {
         this.addSlotToContainer(new Slot(par1IInventory, j, 8 + j * 18, 161 + i));
      }

   }

   public boolean canInteractWith(EntityPlayer par1EntityPlayer) {
      return this.lowerChestInventory.isUseableByPlayer(par1EntityPlayer);
   }

   public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2) {
      ItemStack itemstack = null;
      Slot slot = (Slot)super.inventorySlots.get(par2);
      if (slot != null && slot.getHasStack()) {
         ItemStack itemstack1 = slot.getStack();
         itemstack = itemstack1.copy();
         if (par2 < this.numRows * 9) {
            if (!this.mergeItemStack(itemstack1, this.numRows * 9, super.inventorySlots.size(), true)) {
               return null;
            }
         } else if (!this.mergeItemStack(itemstack1, 0, this.numRows * 9, false)) {
            return null;
         }

         if (itemstack1.stackSize == 0) {
            slot.putStack((ItemStack)null);
         } else {
            slot.onSlotChanged();
         }
      }

      return itemstack;
   }

   public void onContainerClosed(EntityPlayer par1EntityPlayer) {
      super.onContainerClosed(par1EntityPlayer);
      this.lowerChestInventory.closeChest();
   }

   public IInventory getLowerChestInventory() {
      return this.lowerChestInventory;
   }
}
