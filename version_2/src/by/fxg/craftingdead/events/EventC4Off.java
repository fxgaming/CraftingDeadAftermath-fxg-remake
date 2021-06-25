package by.fxg.craftingdead.events;

import by.fxg.craftingdead.entity.EntityC4;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.Cancelable;
import net.minecraftforge.event.Event;

@Cancelable
public class EventC4Off extends Event {
   public String touchOffType = "touched";
   public EntityPlayer playerSettingOff;
   public EntityC4 entityC4;

   public EventC4Off(String par1, EntityC4 par2, EntityPlayer par3) {
      this.touchOffType = par1;
      this.entityC4 = par2;
      this.playerSettingOff = par3;
   }
}
