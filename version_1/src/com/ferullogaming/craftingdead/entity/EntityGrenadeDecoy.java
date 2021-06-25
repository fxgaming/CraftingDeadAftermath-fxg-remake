package com.ferullogaming.craftingdead.entity;

import java.util.Random;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;

public class EntityGrenadeDecoy extends EntityGrenade {
   public boolean initDecoy = false;
   public String gunsound = "akmshoot";
   private Random ab = new Random();
   public int decoyFuse = 300;

   public EntityGrenadeDecoy(World world) {
      super(world);
   }

   public EntityGrenadeDecoy(World par1World, EntityLivingBase par2EntityLiving, double force, int fuseLength) {
      super(par1World, par2EntityLiving, force, fuseLength);
   }

   public EntityGrenadeDecoy setDecoySound(String par1) {
      this.gunsound = par1;
      return this;
   }

   public void onUpdate() {
      super.onUpdate();
      if (this.initDecoy) {
         if (this.ab.nextInt(20) == 0) {
            super.worldObj.playSoundAtEntity(this, "craftingdead:" + this.gunsound, 1.0F, 1.0F);

            for(int i = 0; i < 6; ++i) {
               EntityManager.spawnParticle("smoke", super.posX, super.posY + 0.1D, super.posZ, 0.0D, 0.0D, 0.0D);
            }
         }

         if (this.decoyFuse-- <= 0) {
            this.setDead();
            super.worldObj.createExplosion((Entity)null, super.posX, super.posY, super.posZ, 0.2F, false);
         }
      }

   }

   public void onMotionStopped() {
      this.initDecoy = true;
   }

   public void explode() {
   }
}
