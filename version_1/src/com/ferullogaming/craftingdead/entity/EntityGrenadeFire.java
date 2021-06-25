package com.ferullogaming.craftingdead.entity;

import cpw.mods.fml.common.FMLCommonHandler;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntityGrenadeFire extends EntityGrenade {
   public boolean initFire = false;
   private Random ab = new Random();
   public int fireFuse = 200;
   public boolean fireSpawned = false;

   public EntityGrenadeFire(World world) {
      super(world);
      super.fuseLength = -1;
   }

   public EntityGrenadeFire(World par1World, EntityLivingBase par2EntityLiving, double force, int fuseLength) {
      super(par1World, par2EntityLiving, force, fuseLength);
      super.fuseLength = -1;
   }

   public void onUpdate() {
      super.onUpdate();
      if (this.initFire && this.fireFuse-- <= 0) {
         this.setDead();
         int fireRadius = 4;

         for(double x = (double)(-fireRadius); x < (double)fireRadius; ++x) {
            for(double y = (double)(-fireRadius); y < (double)fireRadius; ++y) {
               for(double z = (double)(-fireRadius); z < (double)fireRadius; ++z) {
                  int blockid = super.worldObj.getBlockId((int)(super.posX + x), (int)(super.posY + y), (int)(super.posZ + z));
                  if (blockid == 51 && !super.worldObj.isRemote) {
                     super.worldObj.setBlock((int)(super.posX + x), (int)(super.posY + y), (int)(super.posZ + z), 0);
                  }
               }
            }
         }

         if (!super.worldObj.isRemote) {
            this.setDead();
         }

      }
   }

   public void spawnFire() {
      int fireRadius = 3;

      for(double x = (double)(-fireRadius); x < (double)fireRadius; ++x) {
         for(double y = -2.0D; y < 0.0D; ++y) {
            for(double z = (double)(-fireRadius); z < (double)fireRadius; ++z) {
               int blockid = super.worldObj.getBlockId((int)(super.posX + x), (int)(super.posY + y), (int)(super.posZ + z));
               int blockidabove = super.worldObj.getBlockId((int)(super.posX + x), (int)(super.posY + y + 1.0D), (int)(super.posZ + z));
               if (blockid != 0 && blockidabove == 0 && !super.worldObj.isRemote && this.ab.nextInt(3) == 0) {
                  super.worldObj.setBlock((int)(super.posX + x), (int)(super.posY + y + 1.0D), (int)(super.posZ + z), Block.fire.blockID);
               }
            }
         }
      }

   }

   public void spawnFireParticles() {
      for(double i = 0.0D; i < 2.0D; i += 0.25D) {
         double radius = i;

         for(double x = -i; x < radius; ++x) {
            for(double y = -radius; y < radius; ++y) {
               for(double z = -radius; z < radius; ++z) {
                  double mx = (-0.5D + this.ab.nextDouble()) / 4.0D;
                  double my = (-0.5D + this.ab.nextDouble()) / 4.0D;
                  double mz = (-0.5D + this.ab.nextDouble()) / 4.0D;
                  EntityManager.spawnParticle("flame", super.posX + x, super.posY + y, super.posZ + z, 0.0D + mx, 0.0D + my, 0.0D + mz);
               }
            }
         }
      }

      double d7;
      double d3;
      double d4;
      double d5;
      double d6;
      int k1;
      for(k1 = 0; k1 < 100; ++k1) {
         d7 = this.ab.nextDouble() * 0.2D;
         d3 = this.ab.nextDouble() * 3.141592653589793D * 2.0D;
         d4 = Math.cos(d3) * d7;
         d5 = 0.01D + this.ab.nextDouble() * 0.3D;
         d6 = Math.sin(d3) * d7;
         EntityManager.spawnParticle("flame", super.posX + d4 * 0.1D, super.posY + 0.1D, super.posZ + d6 * 0.1D, d4, d5, d6);
      }

      for(k1 = 0; k1 < 100; ++k1) {
         d7 = this.ab.nextDouble() * 0.5D;
         d3 = this.ab.nextDouble() * 3.141592653589793D * 2.0D;
         d4 = Math.cos(d3) * d7;
         d5 = 0.01D + this.ab.nextDouble() * 0.1D;
         d6 = Math.sin(d3) * d7;
         EntityManager.spawnParticle("flame", super.posX + d4 * 0.1D, super.posY + 0.3D, super.posZ + d6 * 0.1D, d4, -d5, d6);
      }

   }

   public void onFirstBounce() {
      super.worldObj.playSoundAtEntity(this, "random.glass", 1.0F, 0.9F);
      this.spawnFireParticles();
      if (!super.worldObj.isRemote && !this.fireSpawned) {
         FMLCommonHandler.instance().getMinecraftServerInstance().worldServers[0].getGameRules().setOrCreateGameRule("doFireTick", "false");
         this.spawnFire();
         this.fireSpawned = true;
      }

      this.initFire = true;
   }

   public boolean onImpactLockPosition() {
      return true;
   }

   public void explode() {
   }

   public void writeEntityToNBT(NBTTagCompound nbttagcompound) {
   }

   public void readEntityFromNBT(NBTTagCompound nbttagcompound) {
      this.setDead();
   }
}
