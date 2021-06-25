package com.ferullogaming.craftingdead.world.biome;

import java.util.Random;
import net.minecraft.world.World;

public class BiomeGenZombiePlains extends BiomeGenZombie {
   public BiomeGenZombiePlains(int par1) {
      super(par1);
      super.theBiomeDecorator.treesPerChunk = -999;
      super.theBiomeDecorator.flowersPerChunk = 0;
      super.theBiomeDecorator.grassPerChunk = 5;
      super.theBiomeDecorator.generateLakes = false;
      super.waterColorMultiplier = 51614;
      super.spawnableCreatureList.clear();
      super.spawnableMonsterList.clear();
   }

   public void decorate(World world, Random rand, int blockX, int blockZ) {
      super.decorate(world, rand, blockX, blockZ);
   }
}
