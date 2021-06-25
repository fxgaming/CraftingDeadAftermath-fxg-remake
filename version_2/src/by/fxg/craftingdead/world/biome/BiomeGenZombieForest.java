package by.fxg.craftingdead.world.biome;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenTaiga1;
import net.minecraft.world.gen.feature.WorldGenTaiga2;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BiomeGenZombieForest extends BiomeGenZombie {
   public BiomeGenZombieForest(int par1) {
      super(par1);
      super.spawnableCreatureList.clear();
      super.spawnableMonsterList.clear();
      super.theBiomeDecorator.treesPerChunk = 4;
      super.theBiomeDecorator.grassPerChunk = 5;
      super.theBiomeDecorator.flowersPerChunk = 0;
      super.theBiomeDecorator.generateLakes = false;
      super.topBlock = (byte)Block.grass.blockID;
      super.fillerBlock = (byte)Block.dirt.blockID;
      super.maxHeight = 0.12F;
      super.minHeight = 0.11F;
      super.waterColorMultiplier = 51614;
   }

   public WorldGenerator getRandomWorldGenForTrees(Random par1Random) {
      return (WorldGenerator)(par1Random.nextInt(14) == 1 ? new WorldGenTaiga1() : new WorldGenTaiga2(false));
   }

   public void decorate(World world, Random rand, int blockX, int blockZ) {
      super.decorate(world, rand, blockX, blockZ);
   }
}
