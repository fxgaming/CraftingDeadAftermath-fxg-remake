package com.ferullogaming.craftingdead.block;

import net.minecraft.item.ItemStack;

public class LootContent {
   public int contentItemID;
   public double contentChance;

   public LootContent(int par1, double par2) {
      this.contentItemID = par1;
      this.contentChance = (double)((int)par2 / 2);
   }

   public ItemStack getItemStack() {
      return new ItemStack(this.contentItemID, 1, 0);
   }
}
