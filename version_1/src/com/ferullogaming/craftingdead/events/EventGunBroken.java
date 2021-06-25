package com.ferullogaming.craftingdead.events;

import com.ferullogaming.craftingdead.item.gun.ItemGun;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.Event;

public class EventGunBroken extends Event {
   private ItemStack gunStack;
   private EntityPlayer player;
   private boolean onReload;

   public EventGunBroken(ItemStack par1, EntityPlayer par2, boolean par3) {
      this.gunStack = par1;
      this.player = par2;
      this.onReload = par3;
   }

   public ItemStack getGunStack() {
      return this.gunStack;
   }
   
   public EntityPlayer getPlayer() { 
	   return this.player;
   }
   
   public boolean getOnReload() {
	   return this.onReload;
   }

   public ItemGun getItemGunReference() {
      return (ItemGun)this.gunStack.getItem();
   }
}
