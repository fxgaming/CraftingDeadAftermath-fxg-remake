package by.fxg.craftingdead.events;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.Event;

public class EventBaseMaterialHarvested extends Event {
   private Item toolUsed;
   private ItemStack materialDropped;

   public EventBaseMaterialHarvested(Item par1, ItemStack par2) {
      this.toolUsed = par1;
      this.materialDropped = par2;
   }

   public ItemStack getMaterialDropped() {
      return this.materialDropped;
   }

   public Item getToolUsed() {
      return this.toolUsed;
   }
}
