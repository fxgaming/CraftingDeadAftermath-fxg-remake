package by.fxg.craftingdead.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;

public class EntityGrenadePipeBomb extends EntityGrenade {
   public boolean isBeeping = false;

   public EntityGrenadePipeBomb(World par1World, EntityLivingBase par2EntityLiving, double force, int fuseLength) {
      super(par1World, par2EntityLiving.posX, par2EntityLiving.posY + 1.5D, par2EntityLiving.posZ, par2EntityLiving.rotationYaw, par2EntityLiving.rotationPitch, force, fuseLength);
      super.grenadeThrower = par2EntityLiving;
   }

   public EntityGrenadePipeBomb(World world) {
      super(world);
      super.fuseLength = 60;
   }
}
