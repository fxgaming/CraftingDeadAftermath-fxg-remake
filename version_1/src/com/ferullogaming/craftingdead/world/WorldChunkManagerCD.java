package com.ferullogaming.craftingdead.world;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeCache;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.WorldTypeEvent.InitBiomeGens;

public class WorldChunkManagerCD extends WorldChunkManager {
   public static ArrayList allowedBiomes;
   private GenLayer d;
   private GenLayer e;
   private BiomeCache f;
   private List g;

   protected WorldChunkManagerCD() {
      this.f = new BiomeCache(this);
      this.g = new ArrayList();
      this.g.addAll(allowedBiomes);
   }

   public WorldChunkManagerCD(long par1, WorldType par3WorldType) {
      this();
      GenLayer[] var4 = GenLayer.initializeAllBiomeGenerators(par1, par3WorldType);
      var4 = this.getModdedBiomeGenerators(par3WorldType, par1, var4);
      this.d = var4[0];
      this.e = var4[1];
   }

   public WorldChunkManagerCD(World par1World) {
      this(par1World.getSeed(), par1World.getWorldInfo().getTerrainType());
   }

   public List getBiomesToSpawnIn() {
      return this.g;
   }

   public BiomeGenBase getBiomeGenAt(int par1, int par2) {
      return this.f.getBiomeGenAt(par1, par2);
   }

   public float[] getRainfall(float[] par1ArrayOfFloat, int par2, int par3, int par4, int par5) {
      IntCache.resetIntCache();
      if (par1ArrayOfFloat == null || par1ArrayOfFloat.length < par4 * par5) {
         par1ArrayOfFloat = new float[par4 * par5];
      }

      int[] var6 = this.e.getInts(par2, par3, par4, par5);

      for(int var7 = 0; var7 < par4 * par5; ++var7) {
         float var8 = (float)BiomeGenBase.biomeList[var6[var7]].getIntRainfall() / 65536.0F;
         if (var8 > 1.0F) {
            var8 = 1.0F;
         }

         par1ArrayOfFloat[var7] = var8;
      }

      return par1ArrayOfFloat;
   }

   @SideOnly(Side.CLIENT)
   public float getTemperatureAtHeight(float par1, int par2) {
      return par1;
   }

   public float[] getTemperatures(float[] par1ArrayOfFloat, int par2, int par3, int par4, int par5) {
      IntCache.resetIntCache();
      if (par1ArrayOfFloat == null || par1ArrayOfFloat.length < par4 * par5) {
         par1ArrayOfFloat = new float[par4 * par5];
      }

      int[] var6 = this.e.getInts(par2, par3, par4, par5);

      for(int var7 = 0; var7 < par4 * par5; ++var7) {
         float var8 = (float)BiomeGenBase.biomeList[var6[var7]].getIntTemperature() / 65536.0F;
         if (var8 > 1.0F) {
            var8 = 1.0F;
         }

         par1ArrayOfFloat[var7] = var8;
      }

      return par1ArrayOfFloat;
   }

   public BiomeGenBase[] getBiomesForGeneration(BiomeGenBase[] par1ArrayOfBiomeGenBase, int par2, int par3, int par4, int par5) {
      IntCache.resetIntCache();
      if (par1ArrayOfBiomeGenBase == null || par1ArrayOfBiomeGenBase.length < par4 * par5) {
         par1ArrayOfBiomeGenBase = new BiomeGenBase[par4 * par5];
      }

      int[] var6 = this.d.getInts(par2, par3, par4, par5);

      for(int var7 = 0; var7 < par4 * par5; ++var7) {
         par1ArrayOfBiomeGenBase[var7] = BiomeGenBase.biomeList[var6[var7]];
      }

      return par1ArrayOfBiomeGenBase;
   }

   public BiomeGenBase[] loadBlockGeneratorData(BiomeGenBase[] par1ArrayOfBiomeGenBase, int par2, int par3, int par4, int par5) {
      return this.getBiomeGenAt(par1ArrayOfBiomeGenBase, par2, par3, par4, par5, true);
   }

   public BiomeGenBase[] getBiomeGenAt(BiomeGenBase[] par1ArrayOfBiomeGenBase, int par2, int par3, int par4, int par5, boolean par6) {
      IntCache.resetIntCache();
      if (par1ArrayOfBiomeGenBase == null || par1ArrayOfBiomeGenBase.length < par4 * par5) {
         par1ArrayOfBiomeGenBase = new BiomeGenBase[par4 * par5];
      }

      if (par6 && par4 == 16 && par5 == 16 && (par2 & 15) == 0 && (par3 & 15) == 0) {
         BiomeGenBase[] var9 = this.f.getCachedBiomes(par2, par3);
         System.arraycopy(var9, 0, par1ArrayOfBiomeGenBase, 0, par4 * par5);
         return par1ArrayOfBiomeGenBase;
      } else {
         int[] var7 = this.e.getInts(par2, par3, par4, par5);

         for(int var8 = 0; var8 < par4 * par5; ++var8) {
            par1ArrayOfBiomeGenBase[var8] = BiomeGenBase.biomeList[var7[var8]];
         }

         return par1ArrayOfBiomeGenBase;
      }
   }

   public boolean areBiomesViable(int par1, int par2, int par3, List par4List) {
      IntCache.resetIntCache();
      int var5 = par1 - par3 >> 2;
      int var6 = par2 - par3 >> 2;
      int var7 = par1 + par3 >> 2;
      int var8 = par2 + par3 >> 2;
      int var9 = var7 - var5 + 1;
      int var10 = var8 - var6 + 1;
      int[] var11 = this.d.getInts(var5, var6, var9, var10);

      for(int var12 = 0; var12 < var9 * var10; ++var12) {
         BiomeGenBase var13 = BiomeGenBase.biomeList[var11[var12]];
         if (!par4List.contains(var13)) {
            return false;
         }
      }

      return true;
   }

   public ChunkPosition findBiomePosition(int par1, int par2, int par3, List par4List, Random par5Random) {
      IntCache.resetIntCache();
      int var6 = par1 - par3 >> 2;
      int var7 = par2 - par3 >> 2;
      int var8 = par1 + par3 >> 2;
      int var9 = par2 + par3 >> 2;
      int var10 = var8 - var6 + 1;
      int var11 = var9 - var7 + 1;
      int[] var12 = this.d.getInts(var6, var7, var10, var11);
      ChunkPosition var13 = null;
      int var14 = 0;

      for(int var15 = 0; var15 < var10 * var11; ++var15) {
         int var16 = var6 + var15 % var10 << 2;
         int var17 = var7 + var15 / var10 << 2;
         BiomeGenBase var18 = BiomeGenBase.biomeList[var12[var15]];
         if (par4List.contains(var18) && (var13 == null || par5Random.nextInt(var14 + 1) == 0)) {
            var13 = new ChunkPosition(var16, 0, var17);
            ++var14;
         }
      }

      return var13;
   }

   public void cleanupCache() {
      this.f.cleanupCache();
   }

   public GenLayer[] getModdedBiomeGenerators(WorldType worldType, long seed, GenLayer[] original) {
      InitBiomeGens event = new InitBiomeGens(worldType, seed, original);
      MinecraftForge.TERRAIN_GEN_BUS.post(event);
      return event.newBiomeGens;
   }

   static {
      allowedBiomes = new ArrayList(Arrays.asList(BiomeGenBase.beach));
   }
}
