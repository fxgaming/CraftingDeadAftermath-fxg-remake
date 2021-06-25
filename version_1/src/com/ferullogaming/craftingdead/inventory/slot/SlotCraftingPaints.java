package com.ferullogaming.craftingdead.inventory.slot;

import com.ferullogaming.craftingdead.inventory.InventoryCDA;
import com.ferullogaming.craftingdead.item.gun.GunPaint;
import com.ferullogaming.craftingdead.item.gun.ItemGun;
import com.ferullogaming.craftingdead.item.gun.ItemPaint;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotCraftingPaints extends Slot {
   public SlotCraftingPaints(IInventory par1iInventory, int par2, int par3, int par4) {
      super(par1iInventory, par2, par3, par4);
   }

   public boolean isItemValid(ItemStack par1ItemStack) {
      if (par1ItemStack.getItem() instanceof ItemPaint && super.inventory instanceof InventoryCDA) {
         InventoryCDA inv = (InventoryCDA)super.inventory;
         ItemStack gunstack = inv.getStack("cgun");
         if (gunstack != null) {
            ItemGun gunItem = (ItemGun)gunstack.getItem();
            GunPaint paint = ((ItemPaint)par1ItemStack.getItem()).paintReference;
            if (gunItem.isSkinAllowed(paint)) {
               return true;
            }
         }
      }

      return false;
   }
}
