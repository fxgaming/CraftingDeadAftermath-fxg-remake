package by.fxg.craftingdead.damage;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatMessageComponent;

public class DamageSourceMelee extends DamageSourceCD {
   private Entity damageSourceEntity;
   private ItemStack melee;

   public DamageSourceMelee(Entity par2Entity, ItemStack par3Stack) {
      super("knife");
      this.damageSourceEntity = par2Entity;
      this.melee = par3Stack;
   }

   public Entity getEntity() {
      return this.damageSourceEntity;
   }

   public ItemStack getWeaponUsed() {
      return this.melee;
   }

   public ItemStack getItemStack() {
      return this.melee;
   }

   public ChatMessageComponent getDeathMessage(EntityLivingBase par1EntityLivingBase) {
      return ChatMessageComponent.createFromText("§8Игрок §7" + par1EntityLivingBase.getEntityName() + " §8умер от §4смертельного удара игроком§7 " + this.damageSourceEntity.getEntityName() + "§8.");
   }
}
