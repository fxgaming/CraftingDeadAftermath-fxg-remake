package com.ferullogaming.craftingdead.damage;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ChatMessageComponent;

public class DamageSourceTemperature extends DamageSourceCD {
   private boolean type;
   
   public DamageSourceTemperature(boolean type) {
      super("temperature");
      this.type = type;
   }
   
   public ChatMessageComponent getDeathMessage(EntityLivingBase par1EntityLivingBase) {
	   if (this.type)
		   return ChatMessageComponent.createFromText("§8Игрок §7" + par1EntityLivingBase.getEntityName() + " §4сгорел от высокой температуры§8.");
	   else 
		   return ChatMessageComponent.createFromText("§8Игрок §7" + par1EntityLivingBase.getEntityName() + " §4заледенел и умер§8.");
   }
}
