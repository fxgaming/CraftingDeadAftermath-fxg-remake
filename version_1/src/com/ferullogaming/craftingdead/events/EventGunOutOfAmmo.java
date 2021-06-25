package com.ferullogaming.craftingdead.events;

import com.ferullogaming.craftingdead.item.gun.ItemGun;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.Event;

public class EventGunOutOfAmmo extends Event {
   private ItemStack gunStack;

   public EventGunOutOfAmmo(ItemStack par1) {
      this.gunStack = par1;
   }

   public ItemStack getGunStack() {
      return this.gunStack;
   }

   public ItemGun getItemGunReference() {
      return (ItemGun)this.gunStack.getItem();
   }
}
