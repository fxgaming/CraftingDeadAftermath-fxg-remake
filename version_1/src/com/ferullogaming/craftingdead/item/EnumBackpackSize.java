package com.ferullogaming.craftingdead.item;

public enum EnumBackpackSize {
   SMALL(9),
   MEDIUM(18),
   LARGE(27),
   GUNBAG(18);

   public int backpackSlots = 0;

   private EnumBackpackSize(int par1) {
      this.backpackSlots = par1;
   }
}
