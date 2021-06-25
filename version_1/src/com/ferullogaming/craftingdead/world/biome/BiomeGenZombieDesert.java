package com.ferullogaming.craftingdead.world.biome;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.world.World;

public class BiomeGenZombieDesert extends BiomeGenZombie {
   public BiomeGenZombieDesert(int par1) {
      super(par1);
      super.topBlock = (byte)Block.sand.blockID;
      super.fillerBlock = (byte)Block.sand.blockID;
      super.theBiomeDecorator.treesPerChunk = -999;
      super.theBiomeDecorator.deadBushPerChunk = 0;
      super.theBiomeDecorator.reedsPerChunk = 0;
      super.theBiomeDecorator.cactiPerChunk = 0;
      super.spawnableCreatureList.clear();
      super.spawnableMonsterList.clear();
   }

   public void decorate(World world, Random rand, int blockX, int blockZ) {
      super.decorate(world, rand, blockX, blockZ);
   }
}
