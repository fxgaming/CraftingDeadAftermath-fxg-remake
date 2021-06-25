package com.ferullogaming.craftingdead.damage;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatMessageComponent;

public class DamageSourceBullet extends DamageSourceCD {
   private Entity damageSourceEntity;
   private ItemStack gunstack;

   public DamageSourceBullet(Entity par2Entity, ItemStack par3GunStack) {
      super("bullet");
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
      return ChatMessageComponent.createFromText("§8Игрок §7" + par1EntityLivingBase.getEntityName() + " §8умер от §4смертельного выстрела игрока§7 " + this.damageSourceEntity.getEntityName() + "§8.");
   }
}
