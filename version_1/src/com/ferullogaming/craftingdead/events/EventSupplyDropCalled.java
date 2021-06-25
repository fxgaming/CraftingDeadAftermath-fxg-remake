package com.ferullogaming.craftingdead.events;

import com.ferullogaming.craftingdead.entity.EntitySupplyDrop;
import net.minecraftforge.event.Event;

public class EventSupplyDropCalled extends Event {
   public EntitySupplyDrop supplyDrop;

   public EventSupplyDropCalled(EntitySupplyDrop par1) {
      this.supplyDrop = par1;
   }
}
