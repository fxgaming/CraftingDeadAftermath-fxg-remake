package by.fxg.craftingdead.item;

import by.fxg.craftingdead.entity.EntityC4;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemC4 extends ItemGrenade {
   public ItemC4(int par1) {
      super(par1);
   }

   public void onGrenadeThrown(ItemStack itemstack, World world, EntityPlayer player, double force) {
      world.spawnEntityInWorld(new EntityC4(world, player, force));
      if (!player.capabilities.isCreativeMode) {
         player.inventory.setInventorySlotContents(player.inventory.currentItem, (ItemStack)null);
      }

   }
}
