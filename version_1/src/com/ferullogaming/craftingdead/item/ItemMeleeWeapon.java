package com.ferullogaming.craftingdead.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

public class ItemMeleeWeapon extends ItemCD {
   private int weaponDamage;

   public ItemMeleeWeapon(int par1, int par2, int par3) {
      super(par1);
      this.weaponDamage = par2;
      this.setMaxDamage(par3);
      this.setMaxStackSize(1);
   }

   public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLiving, EntityLivingBase par3EntityLiving) {
      par1ItemStack.damageItem(1, par3EntityLiving);
      if (!par3EntityLiving.worldObj.isRemote) {
         DamageSource var10001 = DamageSource.generic;
         par2EntityLiving.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer)par3EntityLiving), (float)this.weaponDamage);
      }

      return true;
   }

   public boolean isFull3D() {
      return true;
   }

   public EnumAction getItemUseAction(ItemStack par1ItemStack) {
      return EnumAction.block;
   }

   public int getMaxItemUseDuration(ItemStack par1ItemStack) {
      return 72000;
   }

   public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
      par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
      return par1ItemStack;
   }

   @SideOnly(Side.CLIENT)
   public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
      super.addInformation(par1ItemStack, par2EntityPlayer, par3List, par4);
      par3List.add("Урон " + EnumChatFormatting.RED + this.weaponDamage);
      par3List.add("Прочность " + EnumChatFormatting.RED + this.getMaxDamage());
   }
}
