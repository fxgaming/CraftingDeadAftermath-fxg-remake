package by.fxg.craftingdead.events;

import net.minecraftforge.event.Event;

public class EventThirst extends Event {
   private String playerData;

   public EventThirst(String par1) {
      this.playerData = par1;
   }

   public String getPlayerData() {
      return this.playerData;
   }
}
