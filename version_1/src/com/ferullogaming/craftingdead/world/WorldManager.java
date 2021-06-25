package com.ferullogaming.craftingdead.world;

import com.ferullogaming.craftingdead.world.biome.BiomeGenZombieDesert;
import com.ferullogaming.craftingdead.world.biome.BiomeGenZombieForest;
import com.ferullogaming.craftingdead.world.biome.BiomeGenZombiePlains;
import com.ferullogaming.craftingdead.world.biome.BiomeGenZombieSnow;
import com.ferullogaming.craftingdead.world.biome.BiomeGenZombieWasteland;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeGenBase;

public class WorldManager {
   public static final BiomeGenBase zombieForest = (new BiomeGenZombieForest(28)).setBiomeName("Zombie Forest");
   public static final BiomeGenBase zombieDesert = (new BiomeGenZombieDesert(29)).setBiomeName("Zombie Desert").setMinMaxHeight(0.2F, 0.2F).setDisableRain().setTemperatureRainfall(2.0F, 0.0F);
   public static final BiomeGenBase zombiePlains = (new BiomeGenZombiePlains(30)).setBiomeName("Zombie Plains").setMinMaxHeight(0.1F, 0.2F);
   public static final BiomeGenBase zombieSnow = (new BiomeGenZombieSnow(31)).setBiomeName("Zombie Snow").setMinMaxHeight(0.1F, 0.3F).setEnableSnow().setTemperatureRainfall(0.0F, 0.5F);
   public static final BiomeGenBase zombieWasteland = (new BiomeGenZombieWasteland(32)).setBiomeName("Zombie Wasteland").setColor(13786898).setDisableRain().setTemperatureRainfall(2.0F, 0.0F);
   public static final BiomeGenBase[] craftingDeadBiomes;
   public static final WorldType CD;

   public WorldManager() {
      LanguageRegistry.instance().addStringLocalization("generator.CD", "en_US", "Crafting Dead");
   }

   static {
      craftingDeadBiomes = new BiomeGenBase[]{zombieForest, zombieDesert, zombiePlains, zombieSnow, zombieWasteland};
      CD = new WorldTypeCD(14, "CD");
   }
}
