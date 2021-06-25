package com.ferullogaming.craftingdead.inventory.slot;

import com.ferullogaming.craftingdead.inventory.InventoryCDA;
import com.ferullogaming.craftingdead.item.ItemSpecials;
import com.ferullogaming.craftingdead.item.gun.GunAttachment;
import com.ferullogaming.craftingdead.item.gun.ItemGun;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotCraftingUpgrades extends Slot {
   private int slotType = 0;

   public SlotCraftingUpgrades(IInventory par1iInventory, int par2, int par3, int par4) {
      super(par1iInventory, par2, par3, par4);
   }

   public boolean isItemValid(ItemStack par1ItemStack) {
      if (super.inventory instanceof InventoryCDA) {
         InventoryCDA inv = (InventoryCDA)super.inventory;
         ItemStack gunstack = inv.getStack("cgun");
         if (gunstack != null) {
            if (par1ItemStack.getItem() instanceof ItemSpecials) 
            {
            	return true;
            }
         }
      }

      return false;
   }
}
