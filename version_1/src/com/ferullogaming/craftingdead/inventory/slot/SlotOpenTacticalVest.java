package com.ferullogaming.craftingdead.inventory.slot;

import com.ferullogaming.craftingdead.item.ItemBackpack;
import com.ferullogaming.craftingdead.item.ItemTacticalVest;
import com.ferullogaming.craftingdead.item.gun.ItemGun;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotOpenTacticalVest extends Slot {
   public SlotOpenTacticalVest(IInventory par1iInventory, int par2, int par3, int par4) {
      super(par1iInventory, par2, par3, par4);
   }

   public boolean isItemValid(ItemStack par1ItemStack) {
      return !(par1ItemStack.getItem() instanceof ItemBackpack) && !(par1ItemStack.getItem() instanceof ItemGun) && !(par1ItemStack.getItem() instanceof ItemTacticalVest);
   }
}
