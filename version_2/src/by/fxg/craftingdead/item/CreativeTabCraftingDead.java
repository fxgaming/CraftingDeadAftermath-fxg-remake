package by.fxg.craftingdead.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class CreativeTabCraftingDead extends CreativeTabs {
   public CreativeTabCraftingDead(String label) {
      super(label);
   }

   public ItemStack getIconItemStack() {
      return new ItemStack(ItemManager.backpackLargeTan);
   }
}
