package com.ferullogaming.craftingdead.damage;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ChatMessageComponent;

public class DamageSourceZombie extends DamageSourceCD {
   private Entity damageSourceEntity;

   public DamageSourceZombie(Entity par2Entity) {
      super("zombie");
      this.damageSourceEntity = par2Entity;
   }

   public Entity getEntity() {
      return this.damageSourceEntity;
   }

   public ChatMessageComponent getDeathMessage(EntityLivingBase par1EntityLivingBase) {
      return ChatMessageComponent.createFromText("§8Игрок §7" + par1EntityLivingBase.getEntityName() + " §8был §4сьеден§8.");
   }
}
