package by.fxg.craftingdead.entity;

import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.common.network.Player;
import java.util.Iterator;
import java.util.List;

import by.fxg.craftingdead.network.CDAPacketGrenadeFlash;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class EntityGrenadeFlash extends EntityGrenade {
   public EntityGrenadeFlash(World world) {
      super(world);
      this.setSize(0.5F, 0.5F);
      super.yOffset = super.height / 2.0F;
      super.fuse = 0;
   }

   public EntityGrenadeFlash(World par1World, EntityLivingBase par2EntityLiving, double force, int fuseLength) {
      super(par1World, par2EntityLiving, force, fuseLength);
   }

   public void explode() {
      double flashRadius = 18.0D;
      super.worldObj.playSoundAtEntity(this, "random.explode", 2.0F, 1.5F);
      AxisAlignedBB axisalignedbb = super.boundingBox.expand(flashRadius, flashRadius, flashRadius);
      List list1 = super.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, axisalignedbb);
      if (list1 != null && !list1.isEmpty()) {
         Iterator iterator = list1.iterator();

         while(iterator.hasNext()) {
            EntityLivingBase entitylivingbase = (EntityLivingBase)iterator.next();
            double dist = (double)this.getDistanceToEntity(entitylivingbase);
            if (entitylivingbase instanceof EntityPlayer && entitylivingbase.canEntityBeSeen(this) && dist < flashRadius) {
               EntityPlayer player = (EntityPlayer)entitylivingbase;
               PacketDispatcher.sendPacketToPlayer(CDAPacketGrenadeFlash.buildPacket(dist, super.entityId), (Player)player);
            }
         }
      }

      this.setDead();
   }
}
