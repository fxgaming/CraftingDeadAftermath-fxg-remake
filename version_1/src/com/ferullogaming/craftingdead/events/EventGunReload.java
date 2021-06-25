package com.ferullogaming.craftingdead.events;

import com.ferullogaming.craftingdead.item.gun.ItemGun;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.Cancelable;
import net.minecraftforge.event.Event;

@Cancelable
public class EventGunReload extends Event {
   private ItemGun itemGun;
   private ItemStack loadedStack;
   private ItemStack loadingStack;
   private EntityPlayer playerReloading;

   public EventGunReload(ItemGun par1, EntityPlayer par2) {
      this.itemGun = par1;
      this.playerReloading = par2;
   }

   public void setLoadedStack(ItemStack par1) {
      this.loadedStack = par1;
   }

   public void setLoadingStack(ItemStack par1) {
      this.loadingStack = par1;
   }

   public ItemStack getAmmoStackLoading() {
      return this.loadingStack;
   }

   public ItemStack getAmmoStackLoaded() {
      return this.loadedStack;
   }

   public ItemGun getItemGunReference() {
      return this.itemGun;
   }

   public String getPlayerReloading() {
      return this.playerReloading.username;
   }
}
