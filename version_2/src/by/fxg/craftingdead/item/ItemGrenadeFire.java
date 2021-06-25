package by.fxg.craftingdead.item;

import by.fxg.craftingdead.entity.EntityGrenadeFire;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemGrenadeFire extends ItemGrenade {
   public ItemGrenadeFire(int par1) {
      super(par1);
   }

   public void onGrenadeThrown(ItemStack itemstack, World world, EntityPlayer player, double force) {
      double timeSeconds = 1.4D;
      world.spawnEntityInWorld(new EntityGrenadeFire(world, player, force, (int)(timeSeconds * 20.0D)));
      if (!player.capabilities.isCreativeMode) {
         player.inventory.setInventorySlotContents(player.inventory.currentItem, (ItemStack)null);
      }

   }
}
