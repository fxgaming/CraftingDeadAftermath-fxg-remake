package com.ferullogaming.craftingdead.item.potion;

import com.ferullogaming.craftingdead.CDAftermath;
import com.ferullogaming.craftingdead.client.util.ClientManager;
import com.ferullogaming.craftingdead.damage.DamageSourceBleeding;
import com.ferullogaming.craftingdead.damage.DamageSourceRBInfection;
import com.ferullogaming.craftingdead.entity.EntityManager;
import com.ferullogaming.craftingdead.player.PlayerData;
import com.ferullogaming.craftingdead.player.PlayerDataHandler;
import cpw.mods.fml.common.registry.LanguageRegistry;
import java.util.Random;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;

public class PotionManager {
   public static Potion RBInfection;
   public static Potion bleeding;
   public static Potion brokenLeg;
   public static Potion adrenaline;
   public static Potion juggernautEffect;
   public static final int INFECTION_CHANCE = 10;
   public static final int BLEED_CHANCE = 22;

   public void init() {
      RBInfection = (new PotionRBInfection(27, false, 0)).setIconIndex(0, 0).setPotionName("potion.rbinfection");
      bleeding = (new PotionBleeding(28, false, 0)).setIconIndex(0, 0).setPotionName("potion.bleeding");
      brokenLeg = (new PotionBrokenLeg(29, false, 0)).setIconIndex(0, 0).setPotionName("potion.brokenleg").func_111184_a(SharedMonsterAttributes.movementSpeed, "7107DE5E-7CE8-4532-940E-514C1F160890", -0.15000000596046448D, 2);
      adrenaline = (new PotionBleeding(30, false, 0)).setIconIndex(0, 0).setPotionName("potion.adrenaline").func_111184_a(SharedMonsterAttributes.movementSpeed, "91AEAA56-376B-4498-935B-2F7F68070635", 0.20000000298023224D, 2);
      juggernautEffect = (new PotionBleeding(31, false, 0)).setIconIndex(0, 0).setPotionName("potion.juggernaut").func_111184_a(SharedMonsterAttributes.movementSpeed, "7107DE5E-7CE8-4532-940E-514C1F160891", -0.15000000596046448D, 1);
      LanguageRegistry.instance().addStringLocalization("potion.rbinfection", "Инфекция RBI");
      LanguageRegistry.instance().addStringLocalization("potion.bleeding", "Кровотечение");
      LanguageRegistry.instance().addStringLocalization("potion.brokenleg", "Сломана нога");
      LanguageRegistry.instance().addStringLocalization("potion.adrenaline", "Адреналин");
      LanguageRegistry.instance().addStringLocalization("potion.juggernaut", "Джаггернаут");
   }

   public void onClientPlayerTick(EntityPlayer player) {
      Minecraft mc = Minecraft.getMinecraft();
      int particles = 0;
      double vx = player.posX;
      double vy = player.posY;
      double vz = player.posZ;
      PlayerData data = CDAftermath.instance.playerDataHandler().getPlayerData(player);
      Random rand = new Random();
      if (player != null && player.username != null) {
         if (!player.username.equals(mc.thePlayer.username)) {
            ++vy;
         }

         int var1 = 15;
         int var2 = 2;
         if (var2 == 0) {
            var1 = 2;
         }

         if (var2 == 1) {
            var1 = 8;
         }

         if (var2 == 2) {
            var1 = 16;
         }

         if (var2 == 3) {
            var1 = 32;
         }

         int i;
         double mutli;
         double randxpos;
         double randypos;
         double randzpos;
         double vyd;
         if ((data.isPotionInfected || player.worldObj.isRemote && player.username.equals(mc.thePlayer.username) && player.isPotionActive(RBInfection)) && data.potionParticleRBIDelay-- <= 0) {
            for(i = 0; i < var1; ++i) {
               mutli = rand.nextDouble();
               randxpos = mutli * (double)(0.5F - rand.nextFloat());
               randypos = mutli * (double)(0.5F - rand.nextFloat());
               randzpos = mutli * (double)(0.5F - rand.nextFloat());
               vyd = -0.4D;
               EntityManager.spawnParticle("tilecrack_35_5", vx + randxpos, vy + vyd + randypos, vz + randzpos, 0.0D, 0.0D, 0.0D);
            }

            data.potionParticleRBIDelay = 10 + rand.nextInt(7);
         }

         if ((data.isPotionBleeding || player.worldObj.isRemote && player.username.equals(mc.thePlayer.username) && player.isPotionActive(bleeding)) && data.potionParticleBleedingDelay-- <= 0) {
            for(i = 0; i < var1; ++i) {
               mutli = rand.nextDouble();
               randxpos = mutli * (double)(0.5F - rand.nextFloat());
               randypos = mutli * (double)(0.5F - rand.nextFloat());
               randzpos = mutli * (double)(0.5F - rand.nextFloat());
               vyd = -0.4D;
               EntityManager.spawnParticle("tilecrack_152_0", vx + randxpos, vy + vyd + randypos, vz + randzpos, 0.0D, 0.0D, 0.0D);
            }

            data.potionParticleBleedingDelay = 2 + rand.nextInt(7);
         }

         if ((data.isPotionLegBroken || player.worldObj.isRemote && player.username.equals(mc.thePlayer.username) && player.isPotionActive(brokenLeg)) && data.potionParticleBrokenLegDelay-- <= 0) {
            for(i = 0; i < 3; ++i) {
               mutli = rand.nextDouble();
               randxpos = mutli * (double)(0.5F - rand.nextFloat());
               randypos = mutli * (double)(0.5F - rand.nextFloat());
               randzpos = mutli * (double)(0.5F - rand.nextFloat());
               vyd = -0.7D;
               EntityManager.spawnParticle("tilecrack_152_0", vx + randxpos, vy + vyd + randypos, vz + randzpos, 0.0D, 0.0D, 0.0D);
            }

            data.potionParticleBrokenLegDelay = 5 + rand.nextInt(20);
         }

      }
   }

   public void onEntityUpdate(LivingUpdateEvent event) {
      EntityLivingBase living = event.entityLiving;
      if (living != null && !living.isDead && living instanceof EntityPlayer) {
         EntityPlayer player = (EntityPlayer)living;
         PlayerData data = CDAftermath.instance.playerDataHandler().getPlayerData(player);
         Random random = new Random();
         if (player.isPotionActive(RBInfection.id) && data.canTakeInfectionDamage && data.potionRBIDelay-- <= 0) {
            living.attackEntityFrom(new DamageSourceRBInfection(), 1.0F);
            data.potionRBIDelay = 200 + random.nextInt(120);
         }

         if (player.isPotionActive(bleeding.id) && data.canTakeBloodDamage && data.potionBleedingDelay-- <= 0) {
            living.attackEntityFrom(new DamageSourceBleeding(), 1.0F);
            data.potionBleedingDelay = 100 + random.nextInt(120);
         }
      }

   }
}
