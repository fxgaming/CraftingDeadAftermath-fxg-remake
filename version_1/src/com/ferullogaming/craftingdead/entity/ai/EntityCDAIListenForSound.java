package com.ferullogaming.craftingdead.entity.ai;

import com.ferullogaming.craftingdead.CDAftermath;
import com.ferullogaming.craftingdead.entity.EntityCDZombie;
import com.ferullogaming.craftingdead.player.PlayerData;
import com.ferullogaming.craftingdead.player.PlayerDataHandler;
import java.util.Iterator;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.player.EntityPlayer;

public class EntityCDAIListenForSound extends EntityAIBase {
   private EntityPlayer targetEntity;
   protected EntityCDZombie taskOwner;
   private double viewDistance = 12.5D;

   public EntityCDAIListenForSound(EntityCDZombie par1, double par2) {
      this.taskOwner = par1;
      this.viewDistance = par2;
   }

   public boolean shouldExecute() {
      List list = this.taskOwner.worldObj.getEntitiesWithinAABBExcludingEntity(this.taskOwner, this.taskOwner.boundingBox.expand(this.viewDistance, this.viewDistance, this.viewDistance));
      if (!list.isEmpty()) {
         Iterator var2 = list.iterator();

         while(var2.hasNext()) {
            Entity entity = (Entity)var2.next();
            if (entity instanceof EntityPlayer) {
               EntityPlayer player = (EntityPlayer)entity;
               PlayerData data = CDAftermath.instance.playerDataHandler().getPlayerData(player);
               if ((float)data.getSoundTravelDistance() >= this.taskOwner.getDistanceToEntity(player)) {
                  this.targetEntity = player;
                  return true;
               }
            }
         }
      }

      return false;
   }

   public void startExecuting() {
      this.taskOwner.setAttackTarget(this.targetEntity);
   }
}
