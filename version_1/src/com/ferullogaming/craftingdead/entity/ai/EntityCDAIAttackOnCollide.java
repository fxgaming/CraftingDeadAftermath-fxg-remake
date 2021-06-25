package com.ferullogaming.craftingdead.entity.ai;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.pathfinding.PathPoint;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityCDAIAttackOnCollide extends EntityAIBase {
   World worldObj;
   EntityCreature attacker;
   int attackTick;
   double speedTowardsTarget;
   boolean longMemory;
   PathEntity entityPathEntity;
   Class classTarget;
   private int field_75445_i;
   private int failedPathFindingPenalty;

   public EntityCDAIAttackOnCollide(EntityCreature par1EntityCreature, Class par2Class, double par3, boolean par5) {
      this(par1EntityCreature, par3, par5);
      this.classTarget = par2Class;
   }

   public EntityCDAIAttackOnCollide(EntityCreature par1EntityCreature, double par2, boolean par4) {
      this.attacker = par1EntityCreature;
      this.worldObj = par1EntityCreature.worldObj;
      this.speedTowardsTarget = par2;
      this.longMemory = par4;
      this.setMutexBits(3);
   }

   public boolean shouldExecute() {
      EntityLivingBase entitylivingbase = this.attacker.getAttackTarget();
      if (entitylivingbase == null) {
         return false;
      } else if (!entitylivingbase.isEntityAlive()) {
         return false;
      } else if (this.classTarget != null && !this.classTarget.isAssignableFrom(entitylivingbase.getClass())) {
         return false;
      } else if (--this.field_75445_i <= 0) {
         this.entityPathEntity = this.attacker.getNavigator().getPathToEntityLiving(entitylivingbase);
         this.field_75445_i = 4 + this.attacker.getRNG().nextInt(7);
         return this.entityPathEntity != null;
      } else {
         return true;
      }
   }

   public boolean continueExecuting() {
      EntityLivingBase entitylivingbase = this.attacker.getAttackTarget();
      return entitylivingbase == null ? false : (!entitylivingbase.isEntityAlive() ? false : (!this.longMemory ? !this.attacker.getNavigator().noPath() : this.attacker.func_110176_b(MathHelper.floor_double(entitylivingbase.posX), MathHelper.floor_double(entitylivingbase.posY), MathHelper.floor_double(entitylivingbase.posZ))));
   }

   public void startExecuting() {
      this.attacker.getNavigator().setPath(this.entityPathEntity, this.speedTowardsTarget);
      this.field_75445_i = 0;
   }

   public void resetTask() {
      this.attacker.getNavigator().clearPathEntity();
   }

   public void updateTask() {
      EntityLivingBase entitylivingbase = this.attacker.getAttackTarget();
      this.attacker.getLookHelper().setLookPositionWithEntity(entitylivingbase, 30.0F, 30.0F);
      if ((this.longMemory || this.attacker.getEntitySenses().canSee(entitylivingbase)) && --this.field_75445_i <= 0) {
         this.field_75445_i = this.failedPathFindingPenalty + 4 + this.attacker.getRNG().nextInt(7);
         this.attacker.getNavigator().tryMoveToEntityLiving(entitylivingbase, this.speedTowardsTarget);
         if (this.attacker.getNavigator().getPath() != null) {
            PathPoint finalPathPoint = this.attacker.getNavigator().getPath().getFinalPathPoint();
            if (finalPathPoint != null && entitylivingbase.getDistanceSq((double)finalPathPoint.xCoord, (double)finalPathPoint.yCoord, (double)finalPathPoint.zCoord) < 1.0D) {
               this.failedPathFindingPenalty = 0;
            } else {
               this.failedPathFindingPenalty += 10;
            }
         } else {
            this.failedPathFindingPenalty += 10;
         }
      }

      this.attackTick = Math.max(this.attackTick - 1, 0);
      if (this.attacker.getDistanceToEntity(entitylivingbase) <= 1.5F && this.attackTick <= 0) {
         this.attackTick = 10;
         if (this.attacker.getHeldItem() != null) {
            this.attacker.swingItem();
         }

         this.attacker.attackEntityAsMob(entitylivingbase);
      }

   }
}
