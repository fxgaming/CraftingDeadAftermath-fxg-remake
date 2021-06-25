package com.ferullogaming.craftingdead.events;

import java.util.ArrayList;
import java.util.Iterator;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.Event;

public class ItemCraftedEvent extends Event {
   public ArrayList materialsCrafting = new ArrayList();
   public ItemStack craftedStack;

   public ItemCraftedEvent(ItemStack par1) {
      this.craftedStack = par1;
   }

   public boolean isCrafted(Class par1) {
      Iterator var2 = this.materialsCrafting.iterator();

      ItemStack stack;
      do {
         if (!var2.hasNext()) {
            return false;
         }

         stack = (ItemStack)var2.next();
      } while(!stack.getItem().getClass().isAssignableFrom(par1));

      return true;
   }
}
