package by.fxg.craftingdead.entity;

import by.fxg.craftingdead.events.EventFlamethrowerSetFire;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumMovingObjectType;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;

public class EntityFlameThrowerFire extends EntityThrowable {
   private int lifespan = 0;

   public EntityFlameThrowerFire(World par1World) {
      super(par1World);
      this.setSize(0.25F, 0.25F);
   }

   public EntityFlameThrowerFire(World par1World, EntityLivingBase par2EntityLivingBase) {
      super(par1World, par2EntityLivingBase);
   }

   protected float func_70182_d() {
      return 1.1F;
   }

   public void onUpdate() {
      super.onUpdate();
      if (this.lifespan++ > 10) {
         this.setDead();
      }

   }

   protected void onImpact(MovingObjectPosition movingobjectposition) {
      if (!super.worldObj.isRemote && movingobjectposition != null && movingobjectposition.typeOfHit == EnumMovingObjectType.ENTITY) {
         Entity entityHit = movingobjectposition.entityHit;
         if (!entityHit.isImmuneToFire() && entityHit instanceof EntityLivingBase) {
            EntityLivingBase living = (EntityLivingBase)entityHit;
            if (!living.isEntityInvulnerable()) {
               EventFlamethrowerSetFire event = new EventFlamethrowerSetFire((EntityPlayer)this.getThrower(), living, 1, 8.0D);
               if (MinecraftForge.EVENT_BUS.post(event)) {
                  return;
               }

               if (event.damageDealing > 0) {
                  living.hurtResistantTime = 0;
                  living.attackEntityFrom(DamageSource.onFire, (float)event.damageDealing);
               }

               if (event.fireTime > 0.0D) {
                  living.setFire((int)event.fireTime);
               }
            }
         }
      }

      this.setDead();
   }
}
