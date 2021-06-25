package com.ferullogaming.craftingdead.events;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.Event;

public class EventGUIPlayerGenerated extends Event {
   public EntityPlayer fakePlayer;

   public EventGUIPlayerGenerated(EntityPlayer par1) {
      this.fakePlayer = par1;
   }
}
