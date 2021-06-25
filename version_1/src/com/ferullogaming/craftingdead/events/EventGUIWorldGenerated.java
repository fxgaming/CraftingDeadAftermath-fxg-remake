package com.ferullogaming.craftingdead.events;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.event.Event;

public class EventGUIWorldGenerated extends Event {
   public World fakeWorld;

   public EventGUIWorldGenerated(World par1) {
      this.fakeWorld = par1;
   }
}
