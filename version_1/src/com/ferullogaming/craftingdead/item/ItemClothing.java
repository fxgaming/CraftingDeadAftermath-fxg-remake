package com.ferullogaming.craftingdead.item;

import com.ferullogaming.craftingdead.entity.EntityGroundItem;
import java.util.List;
import java.util.Random;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

public class ItemClothing extends ItemCD {
   private String clothingTexture = "default";
   private int armorLevel = 0;
   private boolean fireResistance = false;

   public ItemClothing(int par1, String par2) {
      super(par1);
      this.clothingTexture = "clothing_" + par2;
   }

   public ItemClothing setArmorLevel(int par1) {
      this.armorLevel = par1;
      return this;
   }

   public ItemClothing setFireResistance() {
      this.fireResistance = true;
      return this;
   }

   public ItemStack onEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
      if (!par2World.isRemote) {
         Random rand = new Random();
         int var1 = rand.nextInt(3) + 3;

         for(int i = 0; i < var1; ++i) {
            EntityGroundItem item = new EntityGroundItem(par2World, par3EntityPlayer.posX, par3EntityPlayer.posY + 2.0D, par3EntityPlayer.posZ);
            if (rand.nextBoolean()) {
               item.setEntityItemStack(new ItemStack(ItemManager.ragClean));
            } else {
               item.setEntityItemStack(new ItemStack(ItemManager.ragDirty));
            }

            par2World.spawnEntityInWorld(item);
         }
      }

      --par1ItemStack.stackSize;
      return par1ItemStack;
   }

   public int getMaxItemUseDuration(ItemStack par1ItemStack) {
      return 32;
   }

   public EnumAction getItemUseAction(ItemStack par1ItemStack) {
      return EnumAction.block;
   }

   public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
      par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
      return par1ItemStack;
   }

   public static String getClothingTexture(ItemStack par1) {
      return par1 != null && par1.getItem() instanceof ItemClothing ? ((ItemClothing)par1.getItem()).getClothingTexture() : null;
   }

   public static int getClothingArmorLevel(ItemStack par1) {
      return par1 != null && par1.getItem() instanceof ItemClothing ? ((ItemClothing)par1.getItem()).getArmorLevel() : 0;
   }

   public int getArmorLevel() {
      return this.armorLevel;
   }

   public boolean isFireResistant() {
      return this.fireResistance;
   }

   public String getClothingTexture() {
      return this.clothingTexture;
   }

   public String getArmorLevelString() {
      if (this.armorLevel == 0) {
         return "Без защиты";
      } else if (this.armorLevel == 1) {
         return "Слабый";
      } else {
         return this.armorLevel == 2 ? "Средний" : (this.armorLevel == 3 ? "Высокий" : "Очень высокий");
      }
   }

   public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
      super.addInformation(par1ItemStack, par2EntityPlayer, par3List, par4);
      par3List.add("Уровень защиты " + EnumChatFormatting.RED + this.getArmorLevelString());
      par3List.add(EnumChatFormatting.RED + "Удерживайте ПКМ" + EnumChatFormatting.GRAY + " что-бы порвать.");
      if (this.getArmorLevel() >= 2) {
         par3List.add("Уменьшает шанс инфекции / кровотечения.");
      }

      if (this.isFireResistant()) {
         par3List.add("Уменьшает урон от огня!");
      }
   }
}
