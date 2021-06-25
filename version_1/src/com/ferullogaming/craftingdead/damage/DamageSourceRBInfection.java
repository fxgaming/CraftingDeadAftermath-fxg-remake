package com.ferullogaming.craftingdead.damage;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ChatMessageComponent;

public class DamageSourceRBInfection extends DamageSourceCD {
   public DamageSourceRBInfection() {
      super("infection");
   }

   public ChatMessageComponent getDeathMessage(EntityLivingBase par1EntityLivingBase) {
      return ChatMessageComponent.createFromText("§8Игрок §7" + par1EntityLivingBase.getEntityName() + " §8умер от §4инфекции§8.");
   }
}
