package by.fxg.craftingdead.entity;

import java.util.Random;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;

public class EntityGrenadeSmoke extends EntityGrenade {
   public boolean initSmoke = false;
   private Random ab = new Random();
   public int smokeFuse = 300;
   public double radius = 0.2D;
   public double maxRadius = 2.25D;

   public EntityGrenadeSmoke(World world) {
      super(world);
      super.fuseLength = -1;
   }

   public EntityGrenadeSmoke(World par1World, EntityLivingBase par2EntityLiving, double force, int fuseLength) {
      super(par1World, par2EntityLiving, force, fuseLength);
      super.fuseLength = -1;
   }

   public void onUpdate() {
      super.onUpdate();
      if (this.initSmoke) {
         if (this.smokeFuse % 10 == 0 && this.radius < this.maxRadius) {
            this.radius += 0.25D;
         }

         if (super.worldObj.isRemote && this.smokeFuse % 6 == 0) {
            for(double x = -this.radius; x < this.radius; ++x) {
               for(double y = -this.radius; y < this.radius; ++y) {
                  for(double z = -this.radius; z < this.radius; ++z) {
                     double mx = (-0.5D + this.ab.nextDouble()) / 4.0D;
                     double my = (-0.5D + this.ab.nextDouble()) / 4.0D;
                     double mz = (-0.5D + this.ab.nextDouble()) / 4.0D;
                     EntityManager.spawnParticle("explode", super.posX + x, super.posY + y + 1.0D, super.posZ + z, 0.0D + mx, 0.0D + my, 0.0D + mz);
                     mx = (-0.5D + this.ab.nextDouble()) / 4.0D;
                     my = (-0.5D + this.ab.nextDouble()) / 4.0D;
                     mz = (-0.5D + this.ab.nextDouble()) / 4.0D;
                     EntityManager.spawnParticle("largesmoke", super.posX + x, super.posY + y + 1.0D, super.posZ + z, 0.0D + mx, 0.0D + my, 0.0D + mz);
                  }
               }
            }
         }

         if (this.smokeFuse-- <= 0) {
            this.setDead();
         }
      }

   }

   public void onMotionStopped() {
      this.initSmoke = true;
   }

   public void explode() {
   }
}
