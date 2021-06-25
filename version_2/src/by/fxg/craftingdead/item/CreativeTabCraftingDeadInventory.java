package by.fxg.craftingdead.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class CreativeTabCraftingDeadInventory extends CreativeTabs {
   public CreativeTabCraftingDeadInventory(String label) {
      super(label);
   }

   public ItemStack getIconItemStack() {
      return new ItemStack(ItemManager.backpackMediumBlue);
   }
}
