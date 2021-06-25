package by.fxg.craftingdead.player;

import by.fxg.craftingdead.damage.DamageSourceThirst;
import by.fxg.craftingdead.events.EventThirst;
import by.fxg.craftingdead.item.EnumBackpackSize;
import by.fxg.craftingdead.item.ItemBackpack;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;

public class StaminaLevels {
   private int stamina = 200;
   private int staminaMax = 200;
   private PlayerData playerData;
   private int delaySprint = 0;

   public StaminaLevels(PlayerData par1) {
      this.playerData = par1;
   }

   public void applyStaminaUpdate(EntityPlayer par1) {
      if (!par1.capabilities.isCreativeMode) {
         if (this.stamina > 30) {
        	 if (par1.isSprinting()) {
        		 this.decreaseWaterLevels(1);
        		 this.delaySprint = 0;
        	 } else if (par1.jumpMovementFactor == 0.025999999F) {
        		 this.decreaseWaterLevels(3);
        		 this.delaySprint = 0;
        	 } else {
        		 if (this.delaySprint < 50) {
        			 this.delaySprint++;
        		 } else {
        			 this.increaseBy(1, 2);
        		 }
        	 }
         } else {
        	 if (this.stamina > 0) {
        		 if (par1.isSprinting()) {
            		 this.decreaseWaterLevels(2);
            		 this.delaySprint = 0;
        		 } else if (par1.jumpMovementFactor == 0.025999999F) {
            		 this.decreaseWaterLevels(5);
            		 this.delaySprint = 0;
            	 } else {
            		 if (this.delaySprint < 60) {
            			 this.delaySprint++;
            		 } else {
            			 this.increaseBy(1, 1);
            		 }
            	 }
        	 } else {
            	 if (par1.isSprinting()) {
            		 par1.setSprinting(false);
            		 this.delaySprint = 0;
            	 } else if (par1.jumpMovementFactor == 0.025999999F) {
            		 par1.setSprinting(false);
            		 par1.jumpMovementFactor = 0.02F;
            		 par1.setJumping(false);
            		 this.delaySprint = 0;
            	 } else {
            		 if (this.delaySprint < 120) {
            			 this.delaySprint++;
            		 } else {
            			 this.increaseBy(1, 1);
            		 }
            	 }
        	 }
         }
      }
   }

   public void setStamina(int par1) {
      this.stamina = par1;
   }

   public void decreaseWaterLevels(int par1) {
      this.stamina -= par1;
      if (this.stamina < 0) {
         this.stamina = 0;
      }
   }

   public int getStamina() {
      return this.stamina;
   }

   public void increaseBy(int par1, int par2) {
      this.increaseStamina(par1 * par2);
   }

   public void increaseStamina(int par1) {
      this.stamina += par1;
      if (this.stamina > this.staminaMax) {
         this.stamina = this.staminaMax;
      }
   }

   public double getStaminaPercentage() {
      return (double)this.stamina / (double)this.staminaMax;
   }

   public int getStaminaMax() {
      return this.staminaMax;
   }
}
