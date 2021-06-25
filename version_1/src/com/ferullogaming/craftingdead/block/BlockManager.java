package com.ferullogaming.craftingdead.block;

import com.ferullogaming.craftingdead.item.ItemCDBlockAntiBlueprint;
import com.ferullogaming.craftingdead.item.ItemCDBlockLoot;
import com.ferullogaming.craftingdead.item.LootManager;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockHalfSlab;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemSlab;
import net.minecraft.item.ItemStack;

public class BlockManager {
   public static int renderLootID;
   public static int renderBaseCenterID;
   public static int renderCampfireID;
   public static int renderSandBarrierID;
   public static final int baseCenterRadiCus = 7;
   public static final int antiBlueprintRadius = 100;
   public static final int[] acceptedBlocks = new int[]{0, 1, 2, 3, 31, 12, 24, 1225};
   public static final int[] acceptedBuildingBlocks = new int[]{0, 31};
   public static final int[] buildingMaterials;
   public static final int[] oldBlockIDs;
   public static final int[] oldBlockIDsReplacements;
   public static Block lootResidential;
   public static Block lootResidentialRare;
   public static Block lootMedical;
   public static Block lootPolice;
   public static Block lootMilitary;
   public static Block lootSpawnerResidential;
   public static Block lootSpawnerResidentialRare;
   public static Block lootSpawnerMedical;
   public static Block lootSpawnerPolice;
   public static Block lootSpawnerMilitary;
   public static Block
   lPoor,
   lPalatkas,
   lFoodshop,
   lClothshop,
   lCity,
   lBadcity,
   lMedical,
   lMilitary,
   lSMilitary,
   lsPoor,
   lsPalatkas,
   lsFoodshop,
   lsClothshop,
   lsCity,
   lsBadcity,
   lsMedical,
   lsMilitary,
   lsSMilitary;
   public static Block baseCenter;
   public static Block baseAnitBlueprintPlacer;
   public static Block road;
   public static Block roadLineBroken;
   public static Block roadLineSolid;
   public static Block cosmeticStoneWhite;
   public static Block cosmeticSandbag;
   public static Block OLDcommonLootSpawner;
   public static Block OLDrareLootSpawner;
   public static Block OLDveryRareLootSpawner;
   public static Block OLDextremeLootSpawner;
   public static Block OLDmilitaryLootSpawner;
   public static Block OLDmedicalLootSpawner;
   public static Block OLDpoliceLootSpawner;
   public static Block OLDsandbag;
   public static Block OLDwhiteStoneBrick;
   public static BlockHalfSlab stainedClayDoubleSlab;
   public static BlockHalfSlab stainedClaySlab;
   public static BlockHalfSlab stainedClayDoubleSlab2;
   public static BlockHalfSlab stainedClaySlab2;
   public static Block campfire;
   public static Block barbedWire;
   public static Block barbedWireInforced;
   public static Block sandBarrier;

   public void loadBlocks() {
      OLDcommonLootSpawner = (new BlockCD(1004)).setCreativeTab((CreativeTabs)null).setUnlocalizedName("commonLootSpawner");
      OLDrareLootSpawner = (new BlockCD(1005)).setCreativeTab((CreativeTabs)null).setUnlocalizedName("rareLootSpawner");
      OLDveryRareLootSpawner = (new BlockCD(1006)).setCreativeTab((CreativeTabs)null).setUnlocalizedName("veryRareLootSpawner");
      OLDextremeLootSpawner = (new BlockCD(1007)).setCreativeTab((CreativeTabs)null).setUnlocalizedName("extremeLootSpawner");
      OLDmilitaryLootSpawner = (new BlockCD(1012)).setCreativeTab((CreativeTabs)null).setUnlocalizedName("militaryLootSpawner");
      OLDmedicalLootSpawner = (new BlockCD(1013)).setCreativeTab((CreativeTabs)null).setUnlocalizedName("medicalLootSpawner");
      OLDpoliceLootSpawner = (new BlockCD(1015)).setCreativeTab((CreativeTabs)null).setUnlocalizedName("policeLootSpawner");
      OLDsandbag = (new BlockCD(1026)).setCreativeTab((CreativeTabs)null).setUnlocalizedName("sandbag");
      OLDwhiteStoneBrick = (new BlockCD(1030)).setCreativeTab((CreativeTabs)null).setUnlocalizedName("whitestonebrick");
      //lootResidential = (new BlockLoot(1200, LootManager.LOOT_RESIDENTIAL)).setUnlocalizedName("loot.residential").setCreativeTab((CreativeTabs)null);
      //lootResidentialRare = (new BlockLoot(1201, LootManager.LOOT_RESIDENTIAL_RARE)).setUnlocalizedName("loot.residentialrare").setCreativeTab((CreativeTabs)null);
      //lootMedical = (new BlockLoot(1202, LootManager.LOOT_MEDICAL)).setUnlocalizedName("loot.medical").setCreativeTab((CreativeTabs)null);
      //lootPolice = (new BlockLoot(1203, LootManager.LOOT_POLICE)).setUnlocalizedName("loot.police").setCreativeTab((CreativeTabs)null);
      //lootMilitary = (new BlockLoot(1204, LootManager.LOOT_MILITARY)).setUnlocalizedName("loot.military").setCreativeTab((CreativeTabs)null);
      //lootSpawnerResidential = (new BlockLootSpawner(1210, "residential", lootResidential.blockID)).setUnlocalizedName("loot.residential.spawner").setCreativeTab((CreativeTabs)null);
      //lootSpawnerResidentialRare = (new BlockLootSpawner(1211, "residentialrare", lootResidentialRare.blockID)).setUnlocalizedName("loot.residentialrare.spawner").setCreativeTab((CreativeTabs)null);
      //lootSpawnerMedical = (new BlockLootSpawner(1212, "medical", lootMedical.blockID)).setUnlocalizedName("loot.medical.spawner").setCreativeTab((CreativeTabs)null);
      //lootSpawnerPolice = (new BlockLootSpawner(1213, "police", lootPolice.blockID)).setUnlocalizedName("loot.police.spawner").setCreativeTab((CreativeTabs)null);
      //lootSpawnerMilitary = (new BlockLootSpawner(1214, "military", lootMilitary.blockID)).setUnlocalizedName("loot.military.spawner").setCreativeTab((CreativeTabs)null);
      lPoor = (new BlockLoot(1260, LootManager.poor)).setUnlocalizedName("loot.poor").setCreativeTab(CreativeTabs.tabBlock);
      lPalatkas = (new BlockLoot(1261, LootManager.palatkas)).setUnlocalizedName("loot.palatkas").setCreativeTab(CreativeTabs.tabBlock);
      lFoodshop = (new BlockLoot(1262, LootManager.foodshop)).setUnlocalizedName("loot.foodshop").setCreativeTab(CreativeTabs.tabBlock);
      lClothshop = (new BlockLoot(1263, LootManager.clothshop)).setUnlocalizedName("loot.clothshop").setCreativeTab(CreativeTabs.tabBlock);
      lCity = (new BlockLoot(1264, LootManager.city)).setUnlocalizedName("loot.city").setCreativeTab(CreativeTabs.tabBlock);
      lBadcity = (new BlockLoot(1265, LootManager.badcity)).setUnlocalizedName("loot.badcity").setCreativeTab(CreativeTabs.tabBlock);
      lMedical = (new BlockLoot(1266, LootManager.medical)).setUnlocalizedName("loot.medical").setCreativeTab(CreativeTabs.tabBlock);
      lMilitary = (new BlockLoot(1267, LootManager.military)).setUnlocalizedName("loot.military").setCreativeTab(CreativeTabs.tabBlock);
      lSMilitary = (new BlockLoot(1268, LootManager.smilitary)).setUnlocalizedName("loot.smilitary").setCreativeTab(CreativeTabs.tabBlock);
      lsPoor = (new BlockLootSpawner(1269, "Poor", lPoor.blockID)).setUnlocalizedName("loot.poor.spawner").setCreativeTab(CreativeTabs.tabBlock);
      lsPalatkas = (new BlockLootSpawner(1270, "Palatkas", lPalatkas.blockID)).setUnlocalizedName("loot.palatkas.spawner").setCreativeTab(CreativeTabs.tabBlock);
      lsFoodshop = (new BlockLootSpawner(1271, "Foodshop", lFoodshop.blockID)).setUnlocalizedName("loot.foodshop.spawner").setCreativeTab(CreativeTabs.tabBlock);
      lsClothshop = (new BlockLootSpawner(1272, "Clothshop", lClothshop.blockID)).setUnlocalizedName("loot.clothshop.spawner").setCreativeTab(CreativeTabs.tabBlock);
      lsCity = (new BlockLootSpawner(1273, "City", lCity.blockID)).setUnlocalizedName("loot.city.spawner").setCreativeTab(CreativeTabs.tabBlock);
      lsBadcity = (new BlockLootSpawner(1274, "Badcity", lBadcity.blockID)).setUnlocalizedName("loot.badcity.spawner").setCreativeTab(CreativeTabs.tabBlock);
      lsMedical = (new BlockLootSpawner(1275, "Medical", lMedical.blockID)).setUnlocalizedName("loot.medical.spawner").setCreativeTab(CreativeTabs.tabBlock);
      lsMilitary = (new BlockLootSpawner(1276, "Military", lMilitary.blockID)).setUnlocalizedName("loot.military.spawner").setCreativeTab(CreativeTabs.tabBlock);
      lsSMilitary = (new BlockLootSpawner(1277, "SMilitary", lSMilitary.blockID)).setUnlocalizedName("loot.smilitary.spawner").setCreativeTab(CreativeTabs.tabBlock);
      baseCenter = (new BlockBaseCenter(1220)).setUnlocalizedName("base.center");
      baseAnitBlueprintPlacer = (new BlockCD(1221)).setCDTexture("antibase").setUnlocalizedName("base.antiplacer");
      campfire = (new BlockCampfire(1225)).setUnlocalizedName("campfire");
      barbedWire = (new BlockBarbedWire(1226, 1)).setCDTexture("barbedwire").setUnlocalizedName("barbedWire");
      barbedWireInforced = (new BlockBarbedWire(1227, 3)).setCDTexture("barbedwire2").setUnlocalizedName("barbedWireInforced");
      sandBarrier = (new BlockSandBarrier(1228)).setUnlocalizedName("sandbarrier");
      cosmeticStoneWhite = (new BlockCD(1250)).setCDTexture("stonewhite").setUnlocalizedName("cosmetic.whitestone");
      cosmeticSandbag = (new BlockCD(1251)).setCDTexture("sandbag").setUnlocalizedName("cosmetic.sandbag");
      stainedClayDoubleSlab = (BlockHalfSlab)(new BlockClaySlab(1050, true, true)).setUnlocalizedName("stainedclaydoubleslab");
      stainedClaySlab = (BlockHalfSlab)(new BlockClaySlab(1051, false, true)).setUnlocalizedName("stainedclayslab");
      stainedClayDoubleSlab2 = (BlockHalfSlab)(new BlockClaySlab(1052, true, false)).setSecond().setUnlocalizedName("stainedclaydoubleslab2");
      stainedClaySlab2 = (BlockHalfSlab)(new BlockClaySlab(1053, false, false)).setSecond().setUnlocalizedName("stainedclayslab2");
      Item.itemsList[stainedClaySlab.blockID] = (new ItemSlab(stainedClaySlab.blockID - 256, stainedClaySlab, stainedClayDoubleSlab, false)).setUnlocalizedName("stainedClaySlab");
      Item.itemsList[stainedClayDoubleSlab.blockID] = (new ItemSlab(stainedClayDoubleSlab.blockID - 256, stainedClaySlab, stainedClayDoubleSlab, true)).setUnlocalizedName("stainedClayDoubleSlab");
      Item.itemsList[stainedClaySlab2.blockID] = (new ItemSlab(stainedClaySlab2.blockID - 256, stainedClaySlab2, stainedClayDoubleSlab2, false)).setUnlocalizedName("stainedClaySlab2");
      Item.itemsList[stainedClayDoubleSlab2.blockID] = (new ItemSlab(stainedClayDoubleSlab2.blockID - 256, stainedClaySlab2, stainedClayDoubleSlab2, true)).setUnlocalizedName("stainedClayDoubleSlab2");
      road = (new BlockCD(1040)).setCDTexture("road").setUnlocalizedName("road");
      roadLineBroken = (new BlockRoad(1041, "broken")).setUnlocalizedName("road.lined.broken");
      roadLineSolid = (new BlockRoad(1042, "solid")).setUnlocalizedName("road.lined");
   }

   public void registerBlocks() {
      GameRegistry.registerBlock(OLDcommonLootSpawner, "cd.commonLootSpawner");
      GameRegistry.registerBlock(OLDrareLootSpawner, "cd.rareLootSpawner");
      GameRegistry.registerBlock(OLDveryRareLootSpawner, "cd.veryRareLootSpawner");
      GameRegistry.registerBlock(OLDextremeLootSpawner, "cd.extremeLootSpawner");
      GameRegistry.registerBlock(OLDmilitaryLootSpawner, "cd.militaryLootSpawner");
      GameRegistry.registerBlock(OLDmedicalLootSpawner, "cd.medicalLootSpawner");
      GameRegistry.registerBlock(OLDpoliceLootSpawner, "cd.policeLootSpawner");
      GameRegistry.registerBlock(OLDsandbag, "cd.sandbag");
      GameRegistry.registerBlock(OLDwhiteStoneBrick, "cd.whitestone");
      //GameRegistry.registerBlock(lootResidential, ItemCDBlockLoot.class, "cda.block.loot.oresidential");
      //GameRegistry.registerBlock(lootResidentialRare, ItemCDBlockLoot.class, "cda.block.loot.oresidentialrare");
      //GameRegistry.registerBlock(lootMedical, ItemCDBlockLoot.class, "cda.block.loot.omedical");
      //GameRegistry.registerBlock(lootPolice, ItemCDBlockLoot.class, "cda.block.loot.opolice");
      //GameRegistry.registerBlock(lootMilitary, ItemCDBlockLoot.class, "cda.block.loot.omilitary");
      //GameRegistry.registerBlock(lootSpawnerResidential, "cda.block.loot.oresidential.spawner");
      //GameRegistry.registerBlock(lootSpawnerResidentialRare, "cda.block.loot.oresidentialrare.spawner");
      //GameRegistry.registerBlock(lootSpawnerMedical, "cda.block.loot.omedical.spawner");
      //GameRegistry.registerBlock(lootSpawnerPolice, "cda.block.loot.opolice.spawner");
      //GameRegistry.registerBlock(lootSpawnerMilitary, "cda.block.loot.omilitary.spawner");
      GameRegistry.registerBlock(lPoor, ItemCDBlockLoot.class, "cda.block.loot.poor");
      GameRegistry.registerBlock(lPalatkas, ItemCDBlockLoot.class, "cda.block.loot.palatkas");
      GameRegistry.registerBlock(lFoodshop, ItemCDBlockLoot.class, "cda.block.loot.foodshop");
      GameRegistry.registerBlock(lClothshop, ItemCDBlockLoot.class, "cda.block.loot.clothshop");
      GameRegistry.registerBlock(lCity, ItemCDBlockLoot.class, "cda.block.loot.city");
      GameRegistry.registerBlock(lBadcity, ItemCDBlockLoot.class, "cda.block.loot.badcity");
      GameRegistry.registerBlock(lMedical, ItemCDBlockLoot.class, "cda.block.loot.medical");
      GameRegistry.registerBlock(lMilitary, ItemCDBlockLoot.class, "cda.block.loot.military");
      GameRegistry.registerBlock(lSMilitary, ItemCDBlockLoot.class, "cda.block.loot.smilitary");
      GameRegistry.registerBlock(lsPoor, "cda.block.loot.poor.spawner");
      GameRegistry.registerBlock(lsPalatkas, "cda.block.loot.palatkas.spawner");
      GameRegistry.registerBlock(lsFoodshop, "cda.block.loot.foodshop.spawner");
      GameRegistry.registerBlock(lsClothshop, "cda.block.loot.clothshop.spawner");
      GameRegistry.registerBlock(lsCity, "cda.block.loot.city.spawner");
      GameRegistry.registerBlock(lsBadcity, "cda.block.loot.badcity.spawner");
      GameRegistry.registerBlock(lsMedical, "cda.block.loot.medical.spawner");
      GameRegistry.registerBlock(lsMilitary, "cda.block.loot.military.spawner");
      GameRegistry.registerBlock(lsSMilitary, "cda.block.loot.smilitary.spawner");
      GameRegistry.registerBlock(baseCenter, "cda.block.base.center");
      GameRegistry.registerBlock(baseAnitBlueprintPlacer, ItemCDBlockAntiBlueprint.class, "cda.block.base.antiplacer");
      GameRegistry.registerBlock(campfire, "cda.block.campfire");
      GameRegistry.registerBlock(barbedWire, "cda.block.barbedwire");
      GameRegistry.registerBlock(barbedWireInforced, "cda.block.barbedwireinforced");
      GameRegistry.registerBlock(sandBarrier, "cda.block.sandbarrier");
      GameRegistry.registerBlock(cosmeticStoneWhite, "cda.block.cosmetic.whitestone");
      GameRegistry.registerBlock(cosmeticSandbag, "cda.block.cosmetic.sandbag");
      GameRegistry.registerBlock(road, "cda.block.road");
      GameRegistry.registerBlock(roadLineBroken, "cda.block.road.broken");
      GameRegistry.registerBlock(roadLineSolid, "cda.block.road.solid");
      GameRegistry.registerTileEntity(TileEntityLoot.class, "loot");
      GameRegistry.registerTileEntity(TileEntityLootSpawner.class, "lootspawner");
      GameRegistry.registerTileEntity(TileEntityBaseCenter.class, "basecenter");
      GameRegistry.registerTileEntity(TileEntityCampfire.class, "campfire");
      GameRegistry.registerTileEntity(TileEntitySandBarrier.class, "sandbarrier");
   }

   public void registerNames() {
      LanguageRegistry.addName(OLDcommonLootSpawner, "OLD Common Loot Spawner");
      LanguageRegistry.addName(OLDrareLootSpawner, "OLD Rare Loot Spawner");
      LanguageRegistry.addName(OLDveryRareLootSpawner, "OLD Very Rare Loot Spawner");
      LanguageRegistry.addName(OLDextremeLootSpawner, "OLD Extremely Rare Loot Spawner");
      LanguageRegistry.addName(OLDmilitaryLootSpawner, "Military Loot Spawner");
      LanguageRegistry.addName(OLDmedicalLootSpawner, "Medical Loot Spawner");
      LanguageRegistry.addName(OLDpoliceLootSpawner, "Police Loot Spawner");
      //LanguageRegistry.addName(lootResidential, "Residential Loot");
      //LanguageRegistry.addName(lootResidentialRare, "Rare Residential Loot");
      //LanguageRegistry.addName(lootMedical, "Medical Loot");
      //LanguageRegistry.addName(lootPolice, "Police Loot");
      //LanguageRegistry.addName(lootMilitary, "Military Loot");
      //LanguageRegistry.addName(lootSpawnerResidential, "Residential Loot Spawner");
      //LanguageRegistry.addName(lootSpawnerResidentialRare, "Rare Residential Loot Spawner");
      //LanguageRegistry.addName(lootSpawnerMedical, "Medical Loot Spawner");
      //LanguageRegistry.addName(lootSpawnerPolice, "Police Loot Spawner");
      //LanguageRegistry.addName(lootSpawnerMilitary, "Military Loot Spawner");
      LanguageRegistry.addName(baseCenter, "Base Center");
      LanguageRegistry.addName(baseAnitBlueprintPlacer, "Anti-Base Spawner");
      LanguageRegistry.addName(campfire, "Campfire");
      LanguageRegistry.addName(barbedWire, "Barbed Wire");
      LanguageRegistry.addName(barbedWireInforced, "Reinforced Barbed Wire");
      LanguageRegistry.addName(sandBarrier, "Sand Barrier");
      LanguageRegistry.addName(cosmeticStoneWhite, "White Stone Brick");
      LanguageRegistry.addName(cosmeticSandbag, "Sand Bag");
      LanguageRegistry.addName(road, "Road");
      LanguageRegistry.addName(roadLineBroken, "Broken Lined Road");
      LanguageRegistry.addName(roadLineSolid, "Solid Lined Road");

      for(int i = 0; i < 16; ++i) {
         String var1 = ItemDye.dyeColorNames[~i & 15].toUpperCase();
         if (i < 7) {
            LanguageRegistry.addName(new ItemStack(stainedClaySlab.blockID, 1, i), var1 + " Stained Clay Slab");
         } else {
            LanguageRegistry.addName(new ItemStack(stainedClaySlab2.blockID, 1, i - 7), var1 + " Stained Clay Slab");
         }
      }

   }

   public static int isBlockIDOldSpawner(int par1) {
      for(int i = 0; i < oldBlockIDs.length; ++i) {
         if (oldBlockIDs[i] == par1) {
            return oldBlockIDsReplacements[i];
         }
      }

      return -1;
   }

   public void init() {
      this.loadBlocks();
      this.registerBlocks();
      this.registerNames();
   }

   static {
      buildingMaterials = new int[]{5, Block.stoneBrick.blockID, Block.doorWood.blockID, 54, 1225, 1226, 1227, 1228};
      oldBlockIDs = new int[]{1004, 1005, 1006, 1007, 1012, 1013, 1015, 1026, 1030};
      oldBlockIDsReplacements = new int[]{1210, 1210, 1211, 1211, 1214, 1212, 1213, 1251, 1250};
   }
}
