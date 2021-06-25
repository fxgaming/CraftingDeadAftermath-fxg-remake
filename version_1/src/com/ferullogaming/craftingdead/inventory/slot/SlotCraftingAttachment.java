package com.ferullogaming.craftingdead.inventory.slot;

import com.ferullogaming.craftingdead.inventory.InventoryCDA;
import com.ferullogaming.craftingdead.item.gun.GunAttachment;
import com.ferullogaming.craftingdead.item.gun.ItemGun;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotCraftingAttachment extends Slot {
   private int slotType = 0;

   public SlotCraftingAttachment(IInventory par1iInventory, int par2, int par3, int par4, int par5) {
      super(par1iInventory, par2, par3, par4);
      this.slotType = par5;
   }

   public boolean isItemValid(ItemStack par1ItemStack) {
      if (super.inventory instanceof InventoryCDA) {
         InventoryCDA inv = (InventoryCDA)super.inventory;
         ItemStack gunstack = inv.getStack("cgun");
         GunAttachment attachment = GunAttachment.getAttachmentFromItem(par1ItemStack.itemID);
         if (gunstack != null && attachment != null) {
            ItemGun itemgun = (ItemGun)gunstack.getItem();
            if (itemgun.isAttachmentAloud(attachment)) {
               if (attachment.isSight && this.slotType == 0) {
                  return true;
               }

               if (attachment.isUnderbarrel && this.slotType == 1) {
                  return true;
               }

               if (attachment.isSupressor && this.slotType == 2 || attachment.isSupressorSlot && this.slotType == 2) {
                  return true;
               }
            }
         }
      }

      return false;
   }
}
