package com.ferullogaming.craftingdead.inventory.slot;

import com.ferullogaming.craftingdead.item.ItemTacticalVest;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotVest extends Slot {
   public SlotVest(IInventory par1iInventory, int par2, int par3, int par4) {
      super(par1iInventory, par2, par3, par4);
   }

   public boolean isItemValid(ItemStack par1ItemStack) {
      return par1ItemStack.getItem() instanceof ItemTacticalVest;
   }
}
