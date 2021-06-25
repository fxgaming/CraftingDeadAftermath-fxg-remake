package com.ferullogaming.craftingdead.item.gun;

public enum EnumFireMode {
   AUTO(1),
   SEMI(2),
   BURST(3);

   public int firemodeID;

   private EnumFireMode(int par1) {
      this.firemodeID = par1;
   }
}
