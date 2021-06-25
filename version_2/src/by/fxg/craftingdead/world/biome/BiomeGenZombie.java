package by.fxg.craftingdead.world.biome;

import net.minecraft.world.biome.BiomeGenBase;

public class BiomeGenZombie extends BiomeGenBase {
   public BiomeGenZombie(int par1) {
      super(par1);
   }

   public float getSpawningChance() {
      return 0.5F;
   }
}
