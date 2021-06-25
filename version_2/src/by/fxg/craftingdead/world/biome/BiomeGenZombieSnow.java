package by.fxg.craftingdead.world.biome;

import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenTaiga1;
import net.minecraft.world.gen.feature.WorldGenTaiga2;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BiomeGenZombieSnow extends BiomeGenZombie {
   public BiomeGenZombieSnow(int par1) {
      super(par1);
      super.spawnableCreatureList.clear();
      super.spawnableMonsterList.clear();
   }

   public WorldGenerator getRandomWorldGenForTrees(Random par1Random) {
      return (WorldGenerator)(par1Random.nextInt(18) == 1 ? new WorldGenTaiga1() : new WorldGenTaiga2(false));
   }

   public void decorate(World world, Random rand, int blockX, int blockZ) {
      super.decorate(world, rand, blockX, blockZ);
   }
}
