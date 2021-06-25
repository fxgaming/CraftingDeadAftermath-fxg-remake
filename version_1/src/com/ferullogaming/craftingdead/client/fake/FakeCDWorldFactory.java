package com.ferullogaming.craftingdead.client.fake;

import net.minecraft.world.EnumGameType;

public final class FakeCDWorldFactory {
   private static final FakeCDWorld instance;

   public static FakeCDWorld getDefault() {
      return instance;
   }

   static {
      instance = new FakeCDWorld(EnumGameType.SURVIVAL);
   }
}
