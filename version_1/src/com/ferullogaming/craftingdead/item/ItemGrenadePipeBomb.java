package com.ferullogaming.craftingdead.item;

import com.ferullogaming.craftingdead.entity.EntityGrenadePipeBomb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemGrenadePipeBomb extends ItemGrenade {
   public ItemGrenadePipeBomb(int par1) {
      super(par1);
   }

   public void onGrenadeThrown(ItemStack itemstack, World world, EntityPlayer player, double force) {
      double timeSeconds = 3.0D;
      world.spawnEntityInWorld(new EntityGrenadePipeBomb(world, player, force, (int)(timeSeconds * 20.0D)));
      if (!player.capabilities.isCreativeMode) {
         player.inventory.setInventorySlotContents(player.inventory.currentItem, (ItemStack)null);
      }

   }
}
