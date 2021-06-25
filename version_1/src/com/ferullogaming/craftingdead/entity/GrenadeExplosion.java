package com.ferullogaming.craftingdead.entity;

import com.ferullogaming.craftingdead.network.CDAPacketGrenadeExplosion;
import cpw.mods.fml.common.network.PacketDispatcher;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class GrenadeExplosion extends Explosion {
   public boolean a;
   public boolean b = true;
   private int i = 16;
   private Random j = new Random();
   private World k;
   public double c;
   public double d;
   public double e;
   public Entity f;
   public float g;

   public GrenadeExplosion(World par1World, EntityLivingBase par2Entity, double par3, double par5, double par7, float par9) {
      super(par1World, par2Entity, par3, par5, par7, par9);
      this.k = par1World;
      this.f = par2Entity;
      this.g = par9;
      this.c = par3;
      this.d = par5;
      this.e = par7;
   }

   public void doExplosionA() {
      if (!this.k.isRemote) {
         PacketDispatcher.sendPacketToAllAround(this.c, this.d, this.e, 50.0D, 0, CDAPacketGrenadeExplosion.buildPacket(this.c, this.d, this.e, this.g));
         this.k.playSoundEffect(this.c, this.d, this.e, "random.explode", 4.0F, (1.0F + (this.k.rand.nextFloat() - this.k.rand.nextFloat()) * 0.2F) * 0.7F);
         float f = this.g;
         this.g *= 2.0F;
         int i = MathHelper.floor_double(this.c - (double)this.g - 1.0D);
         int j = MathHelper.floor_double(this.c + (double)this.g + 1.0D);
         int k = MathHelper.floor_double(this.d - (double)this.g - 1.0D);
         int l1 = MathHelper.floor_double(this.d + (double)this.g + 1.0D);
         int i2 = MathHelper.floor_double(this.e - (double)this.g - 1.0D);
         int j2 = MathHelper.floor_double(this.e + (double)this.g + 1.0D);
         List list = this.k.getEntitiesWithinAABBExcludingEntity(this.f, AxisAlignedBB.getAABBPool().getAABB((double)i, (double)k, (double)i2, (double)j, (double)l1, (double)j2));
         Vec3 vec3 = this.k.getWorldVec3Pool().getVecFromPool(this.c, this.d, this.e);

         for(int k2 = 0; k2 < list.size(); ++k2) {
            Entity entity = (Entity)list.get(k2);
            double d7 = entity.getDistance(this.c, this.d, this.e) / (double)this.g;
            if (d7 <= 1.0D) {
               double d0 = entity.posX - this.c;
               double d1 = entity.posY + (double)entity.getEyeHeight() - this.d;
               double d2 = entity.posZ - this.e;
               double d8 = (double)MathHelper.sqrt_double(d0 * d0 + d1 * d1 + d2 * d2);
               if (d8 != 0.0D) {
                  double var10000 = d0 / d8;
                  var10000 = d1 / d8;
                  var10000 = d2 / d8;
                  double d9 = (double)this.k.getBlockDensity(vec3, entity.boundingBox);
                  double d10 = (1.0D - d7) * d9;
                  entity.attackEntityFrom(DamageSource.setExplosionSource(this), (float)((int)((d10 * d10 + d10) / 2.0D * 8.0D * (double)this.g + 1.0D)));
                  entity.motionX = 0.0D;
                  entity.motionY = 0.0D;
                  entity.motionZ = 0.0D;
               }
            }
         }

         this.g = f;
      }
   }

   public void doExplosionB(boolean par1) {
      if (this.k.isRemote) {
         if (this.g >= 2.0F && this.b) {
            EntityManager.spawnParticle("hugeexplosion", this.c, this.d, this.e, 1.0D, 0.0D, 0.0D);
         } else {
            EntityManager.spawnParticle("largeexplode", this.c, this.d, this.e, 1.0D, 0.0D, 0.0D);
         }
      }

      if (this.b) {
         Iterator iterator = super.affectedBlockPositions.iterator();

         while(iterator.hasNext()) {
            ChunkPosition chunkposition = (ChunkPosition)iterator.next();
            int i = chunkposition.x;
            int j = chunkposition.y;
            int k = chunkposition.z;
            if (par1) {
               double d0 = (double)((float)i + this.k.rand.nextFloat());
               double d1 = (double)((float)j + this.k.rand.nextFloat());
               double d2 = (double)((float)k + this.k.rand.nextFloat());
               double d3 = d0 - this.c;
               double d4 = d1 - this.d;
               double d5 = d2 - this.e;
               double d6 = (double)MathHelper.sqrt_double(d3 * d3 + d4 * d4 + d5 * d5);
               d3 /= d6;
               d4 /= d6;
               d5 /= d6;
               double d7 = 0.5D / (d6 / (double)this.g + 0.1D);
               d7 *= (double)(this.k.rand.nextFloat() * this.k.rand.nextFloat() + 0.3F);
               d3 *= d7;
               d4 *= d7;
               d5 *= d7;
               EntityManager.spawnParticle("explode", (d0 + this.c * 1.0D) / 2.0D, (d1 + this.d * 1.0D) / 2.0D, (d2 + this.e * 1.0D) / 2.0D, d3, d4, d5);
               EntityManager.spawnParticle("smoke", d0, d1, d2, d3, d4, d5);
            }
         }
      }

   }
}
