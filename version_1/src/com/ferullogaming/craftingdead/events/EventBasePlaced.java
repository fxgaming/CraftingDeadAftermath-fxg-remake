package com.ferullogaming.craftingdead.events;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.Cancelable;
import net.minecraftforge.event.Event;

@Cancelable
public class EventBasePlaced extends Event {
   private EntityPlayer playerPlacing;

   public EventBasePlaced(EntityPlayer par1) {
      this.playerPlacing = par1;
   }

   public EntityPlayer getPlayerPlacingBase() {
      return this.playerPlacing;
   }
}
