package by.fxg.craftingdead.damage;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ChatMessageComponent;

public class DamageSourceBleeding extends DamageSourceCD {
   public DamageSourceBleeding() {
      super("bleeding");
   }

   public ChatMessageComponent getDeathMessage(EntityLivingBase par1EntityLivingBase) {
      return ChatMessageComponent.createFromText("§8Игрок §7" + par1EntityLivingBase.getEntityName() + " §8умер от §4кровотечения§8.");
   }
}
