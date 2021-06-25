package by.fxg.craftingdead.inventory.slot;

import by.fxg.craftingdead.inventory.InventoryBackpack;
import by.fxg.craftingdead.item.EnumBackpackSize;
import by.fxg.craftingdead.item.ItemBackpack;
import by.fxg.craftingdead.item.ItemTacticalVest;
import by.fxg.craftingdead.item.gun.ItemGun;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotOpenBackpack extends Slot {
   public SlotOpenBackpack(IInventory par1iInventory, int par2, int par3, int par4) {
      super(par1iInventory, par2, par3, par4);
   }

   public boolean isItemValid(ItemStack par1ItemStack) {
      if (par1ItemStack.getItem() instanceof ItemGun && ((InventoryBackpack)super.inventory).getBackpackSizeType() == EnumBackpackSize.GUNBAG) {
         return true;
      } else {
         return !(par1ItemStack.getItem() instanceof ItemBackpack) && !(par1ItemStack.getItem() instanceof ItemGun) && !(par1ItemStack.getItem() instanceof ItemTacticalVest);
      }
   }
}
