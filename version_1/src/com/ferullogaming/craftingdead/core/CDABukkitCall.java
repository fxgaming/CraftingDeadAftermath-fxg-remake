package com.ferullogaming.craftingdead.core;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public final class CDABukkitCall {
   public static final boolean canBreak(EntityPlayer player, World world, int x, int y, int z) {
	   return true;
   }

   public static final boolean canAttack(EntityPlayer player, EntityPlayer target) {
      return true;
   }
}
