package by.fxg.craftingdead.item;

import by.fxg.craftingdead.client.render.hat.RenderHat;

public class ItemHat extends ItemCD {
   private RenderHat hatRenderer;
   private boolean reducesFlashes = false;

   public ItemHat(int par1) {
      super(par1);
   }

   public ItemHat setReducesFlahes() {
      this.reducesFlashes = true;
      this.addInformation("Уменьшает ослепление от слеповой гранаты");
      return this;
   }

   public ItemHat setRenderer(RenderHat par1) {
      this.hatRenderer = par1;
      return this;
   }

   public boolean canReduceFlahes() {
      return this.reducesFlashes;
   }

   public RenderHat getHatRenderer() {
      return this.hatRenderer;
   }
}
