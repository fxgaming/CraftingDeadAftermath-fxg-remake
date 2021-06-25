package com.ferullogaming.craftingdead.item;

public class ItemCDBlockAntiBlueprint extends ItemCDBlock {
   public ItemCDBlockAntiBlueprint(int par1) {
      super(par1);
      this.addInformation("Prevents all blueprints within 100 Blocks");
      this.addInformation("from being placed.");
   }
}
