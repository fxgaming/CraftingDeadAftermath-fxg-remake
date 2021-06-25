package com.ferullogaming.craftingdead.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;

public class ContainerInventoryCDACrafting extends Container {
   public InventoryCrafting craftMatrix = new InventoryCrafting(this, 3, 3);
   public IInventory craftResult = new InventoryCraftResult();
   protected final EntityPlayer thePlayer;

   public ContainerInventoryCDACrafting(InventoryPlayer par1InventoryPlayer, EntityPlayer par3EntityPlayer) {
      this.thePlayer = par3EntityPlayer;
      this.addSlotToContainer(new SlotCrafting(par1InventoryPlayer.player, this.craftMatrix, this.craftResult, 0, 145, 36));
      int deltaY = 0;

      int i;
      int j;
      for(i = 0; i < 3; ++i) {
         for(j = 0; j < 3; ++j) {
            this.addSlotToContainer(new Slot(this.craftMatrix, j + i * 3, 72 + j * 18, 18 + i * 18));
         }
      }

      for(i = 0; i < 3; ++i) {
         for(j = 0; j < 9; ++j) {
            this.addSlotToContainer(new Slot(par1InventoryPlayer, j + (i + 1) * 9, 8 + j * 18, 84 + i * 18 + deltaY));
         }
      }

      for(i = 0; i < 9; ++i) {
         this.addSlotToContainer(new Slot(par1InventoryPlayer, i, 8 + i * 18, 142 + deltaY));
      }

      this.onCraftMatrixChanged(this.craftMatrix);
   }

   public void onCraftMatrixChanged(IInventory par1IInventory) {
      this.craftResult.setInventorySlotContents(0, CraftingManager.getInstance().findMatchingRecipe(this.craftMatrix, this.thePlayer.worldObj));
   }

   public void onContainerClosed(EntityPlayer par1EntityPlayer) {
      super.onContainerClosed(par1EntityPlayer);

      for(int i = 0; i < 9; ++i) {
         ItemStack itemstack = this.craftMatrix.getStackInSlotOnClosing(i);
         if (itemstack != null) {
            par1EntityPlayer.dropPlayerItem(itemstack);
         }
      }

      this.craftResult.setInventorySlotContents(0, (ItemStack)null);
   }

   public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2) {
      ItemStack itemstack = null;
      Slot slot = (Slot)super.inventorySlots.get(par2);
      if (slot != null && slot.getHasStack()) {
         ItemStack itemstack1 = slot.getStack();
         itemstack = itemstack1.copy();
         if (par2 == 0) {
            if (!this.mergeItemStack(itemstack1, 10, 46, true)) {
               return null;
            }

            slot.onSlotChange(itemstack1, itemstack);
         } else if (par2 >= 10 && par2 < 37) {
            if (!this.mergeItemStack(itemstack1, 37, 46, false)) {
               return null;
            }
         } else if (par2 >= 37 && par2 < 46) {
            if (!this.mergeItemStack(itemstack1, 10, 37, false)) {
               return null;
            }
         } else if (!this.mergeItemStack(itemstack1, 10, 46, false)) {
            return null;
         }

         if (itemstack1.stackSize == 0) {
            slot.putStack((ItemStack)null);
         } else {
            slot.onSlotChanged();
         }

         if (itemstack1.stackSize == itemstack.stackSize) {
            return null;
         }

         slot.onPickupFromSlot(par1EntityPlayer, itemstack1);
      }

      return itemstack;
   }

   public boolean func_94530_a(ItemStack par1ItemStack, Slot par2Slot) {
      return par2Slot.inventory != this.craftResult && super.func_94530_a(par1ItemStack, par2Slot);
   }

   public boolean canInteractWith(EntityPlayer entityplayer) {
      return true;
   }
}
