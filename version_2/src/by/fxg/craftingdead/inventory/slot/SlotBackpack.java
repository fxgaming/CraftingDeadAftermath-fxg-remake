package by.fxg.craftingdead.inventory.slot;

import by.fxg.craftingdead.item.ItemBackpack;
import by.fxg.craftingdead.item.ItemFuelTankBackpack;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotBackpack extends Slot {
   public SlotBackpack(IInventory par1iInventory, int par2, int par3, int par4) {
      super(par1iInventory, par2, par3, par4);
   }

   public boolean isItemValid(ItemStack par1ItemStack) {
      return par1ItemStack.getItem() instanceof ItemBackpack || par1ItemStack.getItem() instanceof ItemFuelTankBackpack;
   }
}
