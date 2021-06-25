package by.fxg.craftingdead.client.particle;

import java.util.Random;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFlameFX;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityFlameThrowerFX extends EntityFlameFX {
   private float gravity;
   private float randomMotionX;
   private float randomMotionZ;

   public EntityFlameThrowerFX(World par1World, double par2, double par4, double par6, double par8, double par10, double par12) {
      super(par1World, par2, par4, par6, par8, par10, par12);
   }

   public EntityFlameThrowerFX(EntityPlayer par1) {
      super(par1.worldObj, par1.posX, par1.posY + 1.4D, par1.posZ, 0.0D, 0.0D, 0.0D);
      if (par1.username.equals(Minecraft.getMinecraft().thePlayer.username)) {
         this.setPosition(super.posX, super.posY - 1.5D, super.posZ);
      }

      this.setLocationAndAngles(par1.posX, par1.posY + (double)par1.getEyeHeight(), par1.posZ, par1.rotationYaw, par1.rotationPitch);
      super.posX -= (double)(MathHelper.cos(super.rotationYaw / 180.0F * 3.1415927F) * 0.16F);
      super.posY -= 0.3D;
      super.posZ -= (double)(MathHelper.sin(super.rotationYaw / 180.0F * 3.1415927F) * 0.16F);
      this.setPosition(super.posX, super.posY, super.posZ);
      Random rand = new Random();
      float force = (1.0F + (0.5F - rand.nextFloat())) * 1.2F;
      float yaw = par1.rotationYaw + (0.5F - rand.nextFloat()) * 4.0F;
      float pitch = par1.rotationPitch + (0.5F - rand.nextFloat()) * 4.0F;
      double xHeading = (double)(-MathHelper.sin(yaw * 3.141593F / 180.0F));
      double zHeading = (double)MathHelper.cos(yaw * 3.141593F / 180.0F);
      super.motionX = (double)force * xHeading * (double)MathHelper.cos(pitch / 180.0F * 3.141593F);
      super.motionY = (double)(-force * MathHelper.sin(pitch / 180.0F * 3.141593F));
      super.motionZ = (double)force * zHeading * (double)MathHelper.cos(pitch / 180.0F * 3.141593F);
      super.particleMaxAge = 20;
      this.gravity = 0.03F + rand.nextFloat() / 50.0F;
      super.noClip = false;
      this.randomMotionX = (0.5F - rand.nextFloat()) / 35.0F;
      this.randomMotionZ = (0.5F - rand.nextFloat()) / 35.0F;
   }

   public void onUpdate() {
      super.prevPosX = super.posX;
      super.prevPosY = super.posY;
      super.prevPosZ = super.posZ;
      if (super.particleAge++ >= super.particleMaxAge) {
         this.setDead();
      }

      this.moveEntity(super.motionX, super.motionY, super.motionZ);
      super.motionX *= 0.9800000190734863D;
      super.motionY *= 0.9800000190734863D;
      super.motionZ *= 0.9800000190734863D;
      super.motionY -= (double)this.gravity;
      super.motionX += (double)this.randomMotionX;
      super.motionZ += (double)this.randomMotionZ;
      this.randomMotionX *= 1.01F;
      this.randomMotionZ *= 1.01F;
      if (super.onGround) {
         super.motionX *= 0.099999988079071D;
         super.motionZ *= 0.099999988079071D;
         super.motionY = 0.0D;
      }

   }

   public int getBrightnessForRender(float par1) {
      return 15728880;
   }

   public float getBrightness(float par1) {
      return 1.0F;
   }
}
