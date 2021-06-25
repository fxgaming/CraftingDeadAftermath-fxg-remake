package by.fxg.craftingdead.world;

import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.chunk.IChunkProvider;

public class WorldTypeCD extends WorldType {
   public WorldTypeCD(int par1, String par2Str) {
      super(par1, par2Str);
      super.biomesForWorldType = WorldManager.craftingDeadBiomes;
   }

   public WorldChunkManager getChunkManager(World world) {
      WorldChunkManagerCD chunky = new WorldChunkManagerCD(world);
      WorldChunkManagerCD.allowedBiomes.clear();
      BiomeGenBase[] var3 = WorldManager.craftingDeadBiomes;
      int var4 = var3.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         BiomeGenBase biome = var3[var5];
         WorldChunkManagerCD.allowedBiomes.add(biome);
      }

      return new WorldChunkManagerCD(world);
   }

   public IChunkProvider getChunkGenerator(World world, String generatorOptions) {
      return new ChunkProviderCD(world, world.getSeed(), world.getWorldInfo().isMapFeaturesEnabled());
   }

   public int getSpawnFuzz() {
      return 100;
   }
}
