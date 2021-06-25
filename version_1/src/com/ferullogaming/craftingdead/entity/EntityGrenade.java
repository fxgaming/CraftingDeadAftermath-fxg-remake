package com.ferullogaming.craftingdead.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityGrenade extends EntityThrowable {
   public float damage;
   public int fuse;
   public int fuseLength;
   public float rotationTick;
   public float bounceFactor;
   public boolean exploded;
   private boolean firstBounce;
   public EntityLivingBase grenadeThrower;
   private boolean lockPosition;

   public EntityGrenade(World world, double x, double y, double z, float yaw, float pitch, double force, int fuseLength) {
      super(world);
      this.fuse = 0;
      this.fuseLength = 28;
      this.rotationTick = 0.0F;
      this.bounceFactor = 0.25F;
      this.firstBounce = true;
      this.lockPosition = false;
      this.setSize(0.25F, 0.25F);
      this.setRotation(yaw, 0.0F);
      double xHeading = (double)(-MathHelper.sin(yaw * 3.141593F / 180.0F));
      double zHeading = (double)MathHelper.cos(yaw * 3.141593F / 180.0F);
      super.motionX = force * xHeading * (double)MathHelper.cos(pitch / 180.0F * 3.141593F);
      super.motionY = -force * (double)MathHelper.sin(pitch / 180.0F * 3.141593F);
      super.motionZ = force * zHeading * (double)MathHelper.cos(pitch / 180.0F * 3.141593F);
      this.setPosition(x + xHeading * 0.8D, y, z + zHeading * 0.8D);
      super.prevPosX = super.posX;
      super.prevPosY = super.posY;
      super.prevPosZ = super.posZ;
      this.fuseLength = fuseLength;
   }

   public EntityGrenade(World par1World, EntityLivingBase par2EntityLiving, double force, int fuseLength) {
      this(par1World, par2EntityLiving.posX, par2EntityLiving.posY + 1.5D, par2EntityLiving.posZ, par2EntityLiving.rotationYaw, par2EntityLiving.rotationPitch, force, fuseLength);
      this.grenadeThrower = par2EntityLiving;
   }

   public EntityGrenade(World world) {
      super(world);
      this.fuse = 0;
      this.fuseLength = 28;
      this.rotationTick = 0.0F;
      this.bounceFactor = 0.25F;
      this.firstBounce = true;
      this.lockPosition = false;
      this.setSize(0.25F, 0.25F);
      super.yOffset = super.height / 2.0F;
      this.fuse = 0;
      this.fuseLength = 28;
   }

   public EntityGrenade(World par1World, double par2, double par4, double par6) {
      super(par1World, par2, par4, par6);
      this.fuse = 0;
      this.fuseLength = 28;
      this.rotationTick = 0.0F;
      this.bounceFactor = 0.25F;
      this.firstBounce = true;
      this.lockPosition = false;
   }

   public void onUpdate() {
      super.prevPosX = super.posX;
      super.prevPosY = super.posY;
      super.prevPosZ = super.posZ;
      double prevVelX = super.motionX;
      double prevVelY = super.motionY;
      double prevVelZ = super.motionZ;
      this.moveEntity(super.motionX, super.motionY, super.motionZ);
      if (super.motionX != prevVelX) {
         this.onBounce();
         super.motionX = (double)(-this.bounceFactor) * prevVelX;
      }

      if (super.motionY != prevVelY) {
         this.onBounce();
         super.motionY = (double)(-this.bounceFactor) * prevVelY;
      }

      if (super.motionZ != prevVelZ) {
         this.onBounce();
         super.motionZ = (double)(-this.bounceFactor) * prevVelZ;
      } else {
         super.motionY -= 0.04D;
      }

      super.motionX *= 0.9800000190734863D;
      super.motionY *= 0.9800000190734863D;
      super.motionZ *= 0.9800000190734863D;
      if (super.onGround) {
         super.motionX *= 0.699999988079071D;
         super.motionZ *= 0.699999988079071D;
         super.motionY *= 1.699999988079071D;
      }

      if (super.onGround && super.motionX * super.motionX + super.motionY * super.motionY + super.motionZ * super.motionZ < 0.02D) {
         super.motionX = 0.0D;
         super.motionY = 0.0D;
         super.motionZ = 0.0D;
      }

      if (super.onGround && super.motionX == 0.0D && super.motionY == 0.0D && super.motionZ == 0.0D) {
         this.onMotionStopped();
      }

      if (this.lockPosition) {
         super.motionX = 0.0D;
         super.motionY = 0.0D;
         super.motionZ = 0.0D;
      }

      if (super.worldObj.isRemote && !super.onGround && super.motionX != 0.0D && super.motionY != 0.0D && super.motionZ != 0.0D) {
         int rotationTicks = 60;

         for(int i = 0; i < rotationTicks; ++i) {
            this.rotationTick += 0.5F;
         }
      }

      if (this.fuseLength != -1 && this.fuse++ >= this.fuseLength) {
         this.explode();
      }

   }

   public void onFirstBounce() {
   }

   public void onMotionStopped() {
   }

   public void explode() {
      if (!this.exploded) {
         this.exploded = true;
         if (!super.worldObj.isRemote) {
            this.createExplosion(super.posX, super.posY, super.posZ, 3.0F);
         }
      }

      this.setDead();
   }

   public boolean onImpactLockPosition() {
      return false;
   }

   public String getBounceSound() {
      return "random.break";
   }

   public void onBounce() {
      if (this.firstBounce) {
         this.onFirstBounce();
         this.firstBounce = false;
         if (this.onImpactLockPosition()) {
            this.lockPosition = true;
         }
      }

      if (!super.worldObj.isRemote && (super.motionX != 0.0D || super.motionY != 0.0D || super.motionZ != 0.0D)) {
         super.worldObj.playSoundAtEntity(this, this.getBounceSound(), 1.0F, 1.5F);
      }

   }

   public void createExplosion(double par2, double par4, double par6, float par8) {
      GrenadeExplosion explosion = new GrenadeExplosion(super.worldObj, this.grenadeThrower, par2, par4, par6, par8);
      explosion.a = false;
      explosion.b = true;
      explosion.doExplosionA();
   }

   public void writeEntityToNBT(NBTTagCompound nbttagcompound) {
      super.writeEntityToNBT(nbttagcompound);
   }

   public void readEntityFromNBT(NBTTagCompound nbttagcompound) {
      super.readEntityFromNBT(nbttagcompound);
   }

   public void onCollideWithPlayer(EntityPlayer entityplayer) {
   }

   protected void onImpact(MovingObjectPosition var1) {
   }
}
