package com.ferullogaming.craftingdead.damage;

import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;

public class DamageSourceCD extends DamageSource {
   protected DamageSourceCD(String par1Str) {
      super(par1Str);
   }

   public int getDamageID() {
      return 0;
   }

   public ItemStack getWeaponUsed() {
      return null;
   }
}
