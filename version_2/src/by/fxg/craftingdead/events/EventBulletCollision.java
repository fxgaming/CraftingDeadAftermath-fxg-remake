package by.fxg.craftingdead.events;

import by.fxg.craftingdead.item.gun.ItemGun;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraftforge.event.Cancelable;
import net.minecraftforge.event.Event;

@Cancelable
public class EventBulletCollision extends Event {
   private World worldObj;
   private Entity entityHit;
   private DamageSource damageSource;
   private int damageDealt;
   private EntityPlayer entityShooter;
   private ItemStack gunStack;
   private int blockX;
   private int blockY;
   private int blockZ;
   private EnumBulletCollision collisionType;

   public EventBulletCollision(EnumBulletCollision par1, EntityPlayer par2, ItemStack par3, World par4) {
      this.collisionType = par1;
      this.entityShooter = par2;
      this.gunStack = par3;
      this.worldObj = par4;
   }

   public EventBulletCollision setDamageSource(DamageSource par1, int par2) {
      this.damageSource = par1;
      this.damageDealt = par2;
      return this;
   }

   public EventBulletCollision setEntityHit(Entity par1) {
      this.entityHit = par1;
      return this;
   }

   public EventBulletCollision setBlockHit(int par1, int par2, int par3) {
      this.blockX = par1;
      this.blockY = par2;
      this.blockZ = par3;
      return this;
   }

   public EnumBulletCollision getCollisionType() {
      return this.collisionType;
   }

   public ItemStack getGunStack() {
      return this.gunStack;
   }

   public ItemGun getItemGunReference() {
      return (ItemGun)this.gunStack.getItem();
   }

   public DamageSource getDamageSource() {
      return this.damageSource;
   }

   public int getDamageDealt() {
      return this.damageDealt;
   }

   public void setDamageDealt(int par1) {
      this.damageDealt = par1;
   }

   public int getBlockX() {
      return this.blockX;
   }

   public int getBlockY() {
      return this.blockY;
   }

   public int getBlockZ() {
      return this.blockZ;
   }

   public Entity getEntityHit() {
      return this.entityHit;
   }

   public EntityPlayer getPlayerHit() {
      return (EntityPlayer)this.entityHit;
   }

   public EntityPlayer getShooter() {
      return this.entityShooter;
   }

   public World getWorldObject() {
      return this.worldObj;
   }

   public String getPlayerFiredName() {
      return this.damageSource.getSourceOfDamage().getEntityName();
   }

   public String getHitType() {
      if (this.getCollisionType() == EnumBulletCollision.PLAYER) {
         return "player";
      } else if (this.getCollisionType() == EnumBulletCollision.ENTITY) {
         return "entity";
      } else {
         return this.getCollisionType() == EnumBulletCollision.BLOCK ? "block" : "none";
      }
   }

   public String getPlayerHitName() {
      return this.getCollisionType() == EnumBulletCollision.PLAYER ? this.getPlayerHit().username : null;
   }

   public int getEntityHitID() {
      return this.getCollisionType() == EnumBulletCollision.ENTITY ? this.entityHit.entityId : 0;
   }

   public int[] getBlockHitCoords() {
      return this.getCollisionType() == EnumBulletCollision.BLOCK ? new int[]{this.blockX, this.blockY, this.blockZ} : null;
   }
}
