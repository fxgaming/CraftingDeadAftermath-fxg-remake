package com.ferullogaming.craftingdead.util;

import com.ferullogaming.craftingdead.CDAftermath;
import com.ferullogaming.craftingdead.player.PlayerDataHandler;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.entity.player.EntityPlayer;

public class BukkitUtils {
   public static void removePotionCustom(String username, int par2) {
      if (FMLCommonHandler.instance().getSide() == Side.SERVER) {
         EntityPlayer player = FMLCommonHandler.instance().getMinecraftServerInstance().getConfigurationManager().getPlayerForUsername(username);
         if (player != null) {
            try {
               player.removePotionEffect(par2);
            } catch (Exception var4) {
               System.out.println("Failed to remove a potion effect from Bukkit Utils...");
            }
         }
      }
   }

   public static void increaseWaterLevelsToPlayer(String par1, int par2) {
      if (FMLCommonHandler.instance().getSide() == Side.SERVER) {
    	  CDAftermath.instance.playerDataHandler().getPlayerData(par1).getWaterLevels().increaseWaterLevels(par2);
      }
   }

   public static void setCanViewPlayerTag(String par1, boolean par2) {
      if (FMLCommonHandler.instance().getSide() == Side.SERVER) {
    	  CDAftermath.instance.playerDataHandler().getPlayerData(par1).canViewUsername = par2;
      }
   }

   public static void setCanTakeBulletDamage(String par1, boolean par2) {
      if (FMLCommonHandler.instance().getSide() == Side.SERVER) {
    	  CDAftermath.instance.playerDataHandler().getPlayerData(par1).canTakeBulletDamage = par2;
      }
   }

   public static void setCanTakeBloodDamage(String par1, boolean par2) {
      if (FMLCommonHandler.instance().getSide() == Side.SERVER) {
    	  CDAftermath.instance.playerDataHandler().getPlayerData(par1).canTakeBloodDamage = par2;
      }
   }

   public static void setCanTakeInfectionDamage(String par1, boolean par2) {
      if (FMLCommonHandler.instance().getSide() == Side.SERVER) {
    	  CDAftermath.instance.playerDataHandler().getPlayerData(par1).canTakeInfectionDamage = par2;
      }
   }

   public static void setCanThrowGrenades(String par1, boolean par2) {
      if (FMLCommonHandler.instance().getSide() == Side.SERVER) {
    	  CDAftermath.instance.playerDataHandler().getPlayerData(par1).canThrowGrenades = par2;
      }
   }
}
