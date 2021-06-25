package by.fxg.craftingdead.entity;

import java.util.ArrayList;

import by.fxg.craftingdead.events.EventC4Off;
import by.fxg.craftingdead.item.ItemManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;

public class EntityC4 extends EntityGrenade {
   private boolean isLanded = false;
   private int c4LifeSpan = 12000;
   private int c4Life = 0;
   private boolean isClicked = false;
   private String c4Placer = "";
   private boolean isTouchedOff = false;

   public EntityC4(World world) {
      super(world);
      super.fuseLength = -1;
   }

   public EntityC4(World par1World, EntityLivingBase par2EntityLiving, double force) {
      super(par1World, par2EntityLiving, force > 0.800000011920929D ? 0.800000011920929D : force, -1);
      this.c4Placer = par2EntityLiving.getEntityName();
      super.fuseLength = -1;
   }

   public void onUpdate() {
      super.onUpdate();
      if (!super.worldObj.isRemote && this.isLanded && this.c4Life++ >= this.c4LifeSpan) {
         this.setDead();
      }

   }

   public boolean interactFirst(EntityPlayer par1EntityPlayer) {
      if (!super.worldObj.isRemote && !this.isClicked && this.c4Life > 10 && this.canPickupItem(par1EntityPlayer) && par1EntityPlayer.inventory.addItemStackToInventory(new ItemStack(ItemManager.c4))) {
         this.isClicked = true;
         this.playSound("random.pop", 0.2F, ((super.rand.nextFloat() - super.rand.nextFloat()) * 0.7F + 1.0F) * 2.0F);
         this.setDead();
         return true;
      } else {
         return false;
      }
   }

   public boolean canPickupItem(EntityPlayer par1EntityPlayer) {
      InventoryPlayer inv = par1EntityPlayer.inventory;

      for(int i = 0; i < inv.mainInventory.length - 1; ++i) {
         if (inv.mainInventory[i] == null) {
            return true;
         }
      }

      return false;
   }

   public boolean onImpactLockPosition() {
      this.isLanded = true;
      return true;
   }

   public String getBounceSound() {
      return "damage.fallsmall";
   }

   public void forceSetOffC4(EntityPlayer par1, String par2) {
      EventC4Off event = new EventC4Off(par2, this, par1);
      if (!MinecraftForge.EVENT_BUS.post(event)) {
         this.createExplosion(par1);
      }
   }

   public boolean setOffC4(EntityPlayer player) {
      if (this.c4Placer.equals(player.username)) {
         EventC4Off event = new EventC4Off("touched", this, player);
         if (MinecraftForge.EVENT_BUS.post(event)) {
            return false;
         } else {
            this.createExplosion(player);
            return true;
         }
      } else {
         return false;
      }
   }

   private void createExplosion(EntityPlayer player) {
      if (!this.isTouchedOff) {
         this.isTouchedOff = true;
         this.createExplosion(super.posX, super.posY, super.posZ, 5.0F);
         double radius = 2.5D;
         ArrayList entities = (ArrayList)super.worldObj.getEntitiesWithinAABB(EntityC4.class, AxisAlignedBB.getBoundingBox(super.posX - radius, super.posY - radius, super.posZ - radius, super.posX + radius, super.posY + radius, super.posZ + radius));
         if (entities.size() > 0) {
            for(int i = 0; i < entities.size(); ++i) {
               EntityC4 nextC4 = (EntityC4)entities.get(i);
               if (nextC4 != this && nextC4.entityId != super.entityId) {
                  nextC4.forceSetOffC4(player, "chain");
               }
            }
         }

         this.setDead();
      }

   }

   public boolean canBeCollidedWith() {
      return true;
   }

   public void writeEntityToNBT(NBTTagCompound nbttagcompound) {
      super.writeEntityToNBT(nbttagcompound);
      nbttagcompound.setInteger("life", this.c4Life);
      nbttagcompound.setString("user", this.c4Placer);
   }

   public void readEntityFromNBT(NBTTagCompound nbttagcompound) {
      super.readEntityFromNBT(nbttagcompound);
      this.c4Life = nbttagcompound.getInteger("life");
      this.c4Placer = nbttagcompound.getString("user");
   }
}
