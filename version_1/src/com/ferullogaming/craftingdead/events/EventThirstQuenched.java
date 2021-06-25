package com.ferullogaming.craftingdead.events;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.Cancelable;
import net.minecraftforge.event.Event;

@Cancelable
public class EventThirstQuenched extends Event {
   private EntityPlayer playerDrinking;
   private ItemStack drinkStack;
   private int lastWaterLevel;
   private int amountRestoring;

   public EventThirstQuenched(EntityPlayer par1, ItemStack par2, int par3, int par4) {
      this.playerDrinking = par1;
      this.drinkStack = par2;
      this.lastWaterLevel = par3;
      this.amountRestoring = par3;
   }

   public EntityPlayer getPlayerDrinking() {
      return this.playerDrinking;
   }

   public ItemStack getItemStackDrinking() {
      return this.drinkStack;
   }

   public int getLastWaterLevel() {
      return this.lastWaterLevel;
   }

   public int getRestoringAmount() {
      return this.amountRestoring;
   }

   public int getPotentialRestoredWaterLevel() {
      int var1 = this.lastWaterLevel + this.amountRestoring;
      return var1 > 20 ? 20 : var1;
   }
}
