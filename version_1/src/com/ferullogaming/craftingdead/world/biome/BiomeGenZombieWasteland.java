package com.ferullogaming.craftingdead.world.biome;

import com.ferullogaming.craftingdead.world.WorldGenCD;
import java.util.Random;
import net.minecraft.world.World;

public class BiomeGenZombieWasteland extends BiomeGenZombie {
   public BiomeGenZombieWasteland(int par1) {
      super(par1);
      super.theBiomeDecorator.deadBushPerChunk = 2;
      super.theBiomeDecorator.generateLakes = false;
      super.theBiomeDecorator.treesPerChunk = -999;
      super.spawnableCreatureList.clear();
      super.spawnableMonsterList.clear();
   }

   public void decorate(World world, Random rand, int blockX, int blockZ) {
      super.decorate(world, rand, blockX, blockZ);
      WorldGenCD.genDeadTree(world, rand, blockX, blockZ, 2);
      WorldGenCD.genDeadTree(world, rand, blockX, blockZ, 2);
   }
}
