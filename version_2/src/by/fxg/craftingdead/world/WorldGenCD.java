package by.fxg.craftingdead.world;

import java.util.Random;
import net.minecraft.world.World;

public class WorldGenCD {
   public static void genDeadTree(World world, Random rand, int blockX, int blockZ, int chance) {
      if (rand.nextInt(chance) == 0) {
         int RandPosX = blockX + rand.nextInt(16);
         int RandPosZ = blockZ + rand.nextInt(16);
         int j1 = world.getHeightValue(RandPosX, RandPosZ);
         (new WorldGenDeadTree(true)).generate(world, rand, RandPosX, j1, RandPosZ);
      }

   }
}
