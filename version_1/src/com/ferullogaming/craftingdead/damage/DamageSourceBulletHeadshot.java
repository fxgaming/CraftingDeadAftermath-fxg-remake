package com.ferullogaming.craftingdead.damage;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatMessageComponent;

public class DamageSourceBulletHeadshot extends DamageSourceCD {
   private Entity damageSourceEntity;
   private ItemStack gunstack;

   public DamageSourceBulletHeadshot(Entity par2Entity, ItemStack par3GunStack) {
      super("bullethead");
      this.damageSourceEntity = par2Entity;
      this.gunstack = par3GunStack;
   }

   public Entity getEntity() {
      return this.damageSourceEntity;
   }

   public ItemStack getWeaponUsed() {
      return this.gunstack;
   }

   public ChatMessageComponent getDeathMessage(EntityLivingBase par1EntityLivingBase) {
      return ChatMessageComponent.createFromText("§8Игрок §7" + par1EntityLivingBase.getEntityName() + " §8умер от §4смертельного выстрела в голову игрока§7 " + this.damageSourceEntity.getEntityName() + "§8.");
   }
}
