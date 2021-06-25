package com.ferullogaming.craftingdead.inventory;

import com.ferullogaming.craftingdead.inventory.slot.SlotOpenFuelTanks;
import com.ferullogaming.craftingdead.item.ItemFuelTank;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerFuelTanks extends Container {
   private int slotRows;
   private InventoryFuelTanks tacticalVestInventory;

   public ContainerFuelTanks(IInventory par1PlayerIvnentory, IInventory par2TacticalVestInventory) {
      this.tacticalVestInventory = (InventoryFuelTanks)par2TacticalVestInventory;
      this.slotRows = par2TacticalVestInventory.getSizeInventory() / 9;
      par2TacticalVestInventory.openChest();
      int i = (this.slotRows - 4) * 18;

      int j;
      int k;
      for(j = 0; j < this.slotRows; ++j) {
         for(k = 0; k < 9; ++k) {
            this.addSlotToContainer(new SlotOpenFuelTanks(par2TacticalVestInventory, k + j * 9, 8 + k * 18, 18 + j * 18));
         }
      }

      for(j = 0; j < 3; ++j) {
         for(k = 0; k < 9; ++k) {
            this.addSlotToContainer(new Slot(par1PlayerIvnentory, k + j * 9 + 9, 8 + k * 18, 103 + j * 18 + i));
         }
      }

      for(j = 0; j < 9; ++j) {
         this.addSlotToContainer(new Slot(par1PlayerIvnentory, j, 8 + j * 18, 161 + i));
      }

   }

   public boolean canInteractWith(EntityPlayer var1) {
      return true;
   }

   public ItemStack transferStackInSlot(EntityPlayer player, int slot) {
      ItemStack stack = null;
      Slot slotObject = (Slot)super.inventorySlots.get(slot);
      if (slotObject != null && slotObject.getHasStack()) {
         ItemStack stackInSlot = slotObject.getStack();
         stack = stackInSlot.copy();
         if (!(stackInSlot.getItem() instanceof ItemFuelTank)) {
            return null;
         }

         if (slot < this.slotRows * 9) {
            if (!this.mergeItemStack(stackInSlot, this.slotRows * 9, super.inventorySlots.size(), true)) {
               return null;
            }
         } else if (!this.mergeItemStack(stackInSlot, 0, this.slotRows * 9, false)) {
            return null;
         }

         if (stackInSlot.stackSize == 0) {
            slotObject.putStack((ItemStack)null);
         } else {
            slotObject.onSlotChanged();
         }

         if (stackInSlot.stackSize == stack.stackSize) {
            return null;
         }

         slotObject.onPickupFromSlot(player, stackInSlot);
      }

      return stack;
   }
}
