package com.ferullogaming.craftingdead.events;

import com.ferullogaming.craftingdead.item.gun.ItemGun;

import net.minecraft.item.ItemStack;
import net.minecraftforge.event.Event;

public class EventGunFired extends Event {
   private ItemStack gunStack;
   private String shooter;

   public EventGunFired(String par1, ItemStack par2) {
      this.shooter = par1;
      this.gunStack = par2;
   }

   public String getShooter() {
      return this.shooter;
   }

   public ItemStack getGunStack() {
      return this.gunStack;
   }

   public ItemGun getItemGunReference() {
      return (ItemGun)this.gunStack.getItem();
   }

   public int getGunID() {
      return this.gunStack.itemID;
   }

   public String getPlayerFiring() {
      return this.shooter;
   }
}
