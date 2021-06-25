package by.fxg.craftingdead;

import by.fxg.craftingdead.events.ItemCraftedEvent;
import by.fxg.craftingdead.item.ItemCanOpener;
import by.fxg.craftingdead.item.ItemChalk;
import by.fxg.craftingdead.item.ItemManager;
import cpw.mods.fml.common.ICraftingHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.common.MinecraftForge;

public class CraftingEvents implements ICraftingHandler {
   public void onCrafting(EntityPlayer player, ItemStack item, IInventory craftMatrix) {
      int canOpenerCount = 0;
      int canOpenerSlot = -1;
      ItemStack canOpenerStack = null;

      ItemStack namingStack;
      for(int i = 0; i < craftMatrix.getSizeInventory(); ++i) {
         if (craftMatrix.getStackInSlot(i) != null) {
            namingStack = craftMatrix.getStackInSlot(i);
            if (namingStack != null && namingStack.getItem() instanceof ItemCanOpener) {
               ++canOpenerCount;
               canOpenerSlot = i;
               canOpenerStack = namingStack;
            }
         }
      }

      ItemStack chalkStack;
      if (canOpenerStack != null && canOpenerCount == 1) {
         chalkStack = new ItemStack(ItemManager.canOpener, 2, canOpenerStack.getItemDamage() + 1);
         if (chalkStack.getItemDamage() <= 0) {
            chalkStack = null;
         }

         craftMatrix.setInventorySlotContents(canOpenerSlot, chalkStack);
         if (craftMatrix.getStackInSlot(canOpenerSlot).getItemDamage() <= 0) {
            craftMatrix.setInventorySlotContents(canOpenerSlot, (ItemStack)null);
         }
      }

      chalkStack = null;
      namingStack = null;
      int chalkCount = 0;

      for(int i = 0; i < craftMatrix.getSizeInventory(); ++i) {
         if (craftMatrix.getStackInSlot(i) != null) {
            ItemStack itemstack = craftMatrix.getStackInSlot(i);
            ++chalkCount;
            if (itemstack.getItem() instanceof ItemChalk) {
               chalkStack = itemstack;
            } else {
               namingStack = itemstack;
            }
         }
      }

      if (item != null && chalkStack != null && chalkCount == 2) {
         String newName = ((ItemChalk)chalkStack.getItem()).getNameTag(chalkStack);
         item.setTagCompound(namingStack.getTagCompound());
         item.setItemDamage(namingStack.getItemDamage());
         if (newName != null && newName.length() > 0) {
            item.setItemName(EnumChatFormatting.RED + "" + EnumChatFormatting.ITALIC + newName);
         } else {
            item.func_135074_t();
         }
      } else {
         ItemCraftedEvent event = new ItemCraftedEvent(item);

         for(int i = 0; i < craftMatrix.getSizeInventory(); ++i) {
            if (craftMatrix.getStackInSlot(i) != null) {
               ItemStack itemstack = craftMatrix.getStackInSlot(i);
               event.materialsCrafting.add(itemstack);
            }
         }

         MinecraftForge.EVENT_BUS.post(event);
      }
   }

   public void onSmelting(EntityPlayer player, ItemStack item) {
   }
}
