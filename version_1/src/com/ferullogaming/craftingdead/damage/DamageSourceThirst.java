package com.ferullogaming.craftingdead.damage;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ChatMessageComponent;

public class DamageSourceThirst extends DamageSourceCD {
   public DamageSourceThirst() {
      super("thirst");
   }
   
   public ChatMessageComponent getDeathMessage(EntityLivingBase par1EntityLivingBase) {
	   return ChatMessageComponent.createFromText("§8Игрок §7" + par1EntityLivingBase.getEntityName() + " §8умер от §9жажды§8.");
   }
}
