package com.ferullogaming.craftingdead.inventory;

import com.ferullogaming.craftingdead.inventory.slot.SlotBackpack;
import com.ferullogaming.craftingdead.inventory.slot.SlotClothing;
import com.ferullogaming.craftingdead.inventory.slot.SlotCraftingAttachment;
import com.ferullogaming.craftingdead.inventory.slot.SlotCraftingGun;
import com.ferullogaming.craftingdead.inventory.slot.SlotCraftingPaints;
import com.ferullogaming.craftingdead.inventory.slot.SlotCraftingUpgrades;
import com.ferullogaming.craftingdead.inventory.slot.SlotHat;
import com.ferullogaming.craftingdead.inventory.slot.SlotHeldGun;
import com.ferullogaming.craftingdead.inventory.slot.SlotHeldMelee;
import com.ferullogaming.craftingdead.inventory.slot.SlotUpgrades;
import com.ferullogaming.craftingdead.inventory.slot.SlotVest;
import com.ferullogaming.craftingdead.item.gun.ItemGun;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerInventoryCDA extends Container {
   public InventoryPlayer inventoryPlayer;
   public InventoryCDA inventoryCDA;

   public ContainerInventoryCDA(EntityPlayer thePlayer, InventoryCDA par2extendedInventory) {
      this.inventoryPlayer = thePlayer.inventory;
      this.inventoryCDA = par2extendedInventory;
      int deltaY = 20;

      int i;
      for(i = 0; i < 3; ++i) {
         for(int j = 0; j < 9; ++j) {
            this.addSlotToContainer(new Slot(this.inventoryPlayer, j + (i + 1) * 9, 8 + j * 18, 84 + i * 18 + deltaY));
         }
      }

      for(i = 0; i < 9; ++i) {
         this.addSlotToContainer(new Slot(this.inventoryPlayer, i, 8 + i * 18, 142 + deltaY));
      }

      this.addSlotToContainer(new SlotHeldMelee(this.inventoryCDA, this.inventoryCDA.getStackSlot("melee"), 26, 9));
      this.addSlotToContainer(new SlotHeldGun(this.inventoryCDA, this.inventoryCDA.getStackSlot("gun"), 44, 9));
      this.addSlotToContainer(new SlotClothing(this.inventoryCDA, this.inventoryCDA.getStackSlot("clothing"), 65, 9));
      this.addSlotToContainer(new SlotHat(this.inventoryCDA, this.inventoryCDA.getStackSlot("hat"), 65, 30));
      this.addSlotToContainer(new SlotBackpack(this.inventoryCDA, this.inventoryCDA.getStackSlot("backpack"), 65, 48));
      this.addSlotToContainer(new SlotVest(this.inventoryCDA, this.inventoryCDA.getStackSlot("vest"), 65, 66));
      this.addSlotToContainer(new SlotUpgrades(this.inventoryCDA, this.inventoryCDA.getStackSlot("upgrade"), 65, 85));
      this.addSlotToContainer(new SlotCraftingGun(this.inventoryCDA, this.inventoryCDA.getStackSlot("cgun"), 125, 48));
      this.addSlotToContainer(new SlotCraftingAttachment(this.inventoryCDA, this.inventoryCDA.getStackSlot("cattach3"), 104, 48, 2));
      this.addSlotToContainer(new SlotCraftingAttachment(this.inventoryCDA, this.inventoryCDA.getStackSlot("cattach2"), 125, 69, 1));
      this.addSlotToContainer(new SlotCraftingAttachment(this.inventoryCDA, this.inventoryCDA.getStackSlot("cattach1"), 125, 27, 0));
      this.addSlotToContainer(new SlotCraftingPaints(this.inventoryCDA, this.inventoryCDA.getStackSlot("cpaint"), 146, 48));
      this.addSlotToContainer(new SlotCraftingUpgrades(this.inventoryCDA, this.inventoryCDA.getStackSlot("cupgrade"), 146, 69));
   }

   public void putStackInSlot(int par1, ItemStack par2ItemStack) {
      if (par1 < super.inventorySlots.size()) {
         this.getSlot(par1).putStack(par2ItemStack);
      }

   }

   public Slot getSlot(int par1) {
      return (Slot)super.inventorySlots.get(par1);
   }

   @SideOnly(Side.CLIENT)
   public void putStacksInSlots(ItemStack[] par1ArrayOfItemStack) {
      for(int i = 0; i < par1ArrayOfItemStack.length; ++i) {
         if (i < 49) {
            this.getSlot(i).putStack(par1ArrayOfItemStack[i]);
         }
      }

   }

   public boolean canInteractWith(EntityPlayer var1) {
      return true;
   }

   public void onContainerClosed(EntityPlayer par1EntityPlayer) {
      super.onContainerClosed(par1EntityPlayer);

      for(int i = this.inventoryCDA.getStackSlot("cattach1"); i <= this.inventoryCDA.getStackSlot("cattach3"); ++i) {
         if (!par1EntityPlayer.worldObj.isRemote) {
            ItemStack itemstack = this.inventoryCDA.getStackInSlot(i);
            if (itemstack != null) {
               par1EntityPlayer.dropPlayerItem(itemstack);
            }
         }

         this.inventoryCDA.setInventorySlotContents(i, (ItemStack)null);
      }

      if (this.inventoryCDA.getStack("cgun") != null) {
         par1EntityPlayer.dropPlayerItem(this.inventoryCDA.getStack("cgun"));
         this.inventoryCDA.setInventorySlotContents(this.inventoryCDA.getStackSlot("cgun"), (ItemStack)null);
      }

      if (this.inventoryCDA.getStack("cpaint") != null) {
         par1EntityPlayer.dropPlayerItem(this.inventoryCDA.getStack("cpaint"));
         this.inventoryCDA.setInventorySlotContents(this.inventoryCDA.getStackSlot("cpaint"), (ItemStack)null);
      }
      
      if (this.inventoryCDA.getStack("cupgrade") != null) {
          par1EntityPlayer.dropPlayerItem(this.inventoryCDA.getStack("cupgrade"));
          //((ItemGun)this.inventoryCDA.getStack("cupgrade").getItem()).setGunSpecials(this.inventoryCDA.getStack("cupgrade"), 0);
          this.inventoryCDA.setInventorySlotContents(this.inventoryCDA.getStackSlot("cupgrade"), (ItemStack)null);
       }

   }

   public ItemStack slotClick(int par1, int par2, int par3, EntityPlayer par4EntityPlayer) {
      return super.slotClick(par1, par2, par3, par4EntityPlayer);
   }

   public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2) {
      ItemStack itemstack = null;
      Slot slot = (Slot)super.inventorySlots.get(par2);
      if (slot != null && slot.getHasStack()) {
         ItemStack itemstack1 = slot.getStack();
         itemstack = itemstack1.copy();
         if (par2 >= 0 && par2 < 27) {
            if (!this.mergeItemStack(itemstack1, 27, 36, false)) {
               return null;
            }
         } else if (par2 >= 27 && par2 < 36 && !this.mergeItemStack(itemstack1, 0, 27, false)) {
            return null;
         }

         if (par2 == 42) {
            this.inventoryCDA.craftGun(itemstack1);
            if (!this.mergeItemStack(itemstack1, 0, 27, false)) {
               return null;
            }
         } else if (par2 >= 36 && par2 <= 49 && !this.mergeItemStack(itemstack1, 0, 27, false)) {
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
}
