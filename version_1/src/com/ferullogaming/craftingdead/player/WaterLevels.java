package com.ferullogaming.craftingdead.player;

import com.ferullogaming.craftingdead.damage.DamageSourceThirst;
import com.ferullogaming.craftingdead.events.EventThirst;
import com.ferullogaming.craftingdead.item.EnumBackpackSize;
import com.ferullogaming.craftingdead.item.ItemBackpack;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;

public class WaterLevels {
   private int waterLevels = 36000;
   private int waterLevelsMax = 36000;
   private PlayerData playerData;
   private int delayWaterDamage = 0;

   public WaterLevels(PlayerData par1) {
      this.playerData = par1;
   }

   public void applyWaterUpdate(EntityPlayer par1) {
      if (!par1.capabilities.isCreativeMode) {
         if (this.waterLevels > 0) {
            this.decreaseWaterLevels(1);
            ItemStack backpackStack = this.playerData.getCDInventory().getStack("backpack");
            if (backpackStack != null && backpackStack.getItem() instanceof ItemBackpack) {
               ItemBackpack backpackItem = (ItemBackpack)backpackStack.getItem();
               if (backpackItem.getBackpackSize() == EnumBackpackSize.LARGE || backpackItem.getBackpackSize() == EnumBackpackSize.GUNBAG) {
                  this.decreaseWaterLevels(1);
               }
            }

            if (par1.isSprinting()) {
               this.decreaseWaterLevels(1);
            }
         }

         if (this.waterLevels == 1) {
            EventThirst event = new EventThirst(this.playerData.username);
            MinecraftForge.EVENT_BUS.post(event);
         }

         if (this.waterLevels == 0 && this.delayWaterDamage++ >= 120) {
            par1.attackEntityFrom(new DamageSourceThirst(), 1.0F);
            this.delayWaterDamage = 0;
         }
      }

   }

   public void setWaterLevel(int par1) {
      this.waterLevels = par1;
   }

   public void decreaseWaterLevels(int par1) {
      this.waterLevels -= par1;
      if (this.waterLevels < 0) {
         this.waterLevels = 0;
      }

   }

   public int getWaterLevels() {
      return this.waterLevels;
   }

   public int getWaterLevelsScaled() {
      int var1 = (int)(20.0D * this.getWaterLevelsPercentage());
      return var1;
   }

   public void addWaterLevels(int par1) {
      int var1 = this.waterLevelsMax / 40;
      this.increaseWaterLevels(par1 * var1);
   }

   public boolean needsWater() {
      return this.waterLevels < this.waterLevelsMax - 20;
   }

   public void increaseWaterLevels(int par1) {
      this.waterLevels += par1;
      if (this.waterLevels > this.waterLevelsMax) {
         this.waterLevels = this.waterLevelsMax;
      }

   }

   public double getWaterLevelsPercentage() {
      return (double)this.waterLevels / (double)this.waterLevelsMax;
   }

   public int getWaterLevelMax() {
      return this.waterLevelsMax;
   }
}
