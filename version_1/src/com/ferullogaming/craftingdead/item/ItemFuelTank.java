package com.ferullogaming.craftingdead.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

public class ItemFuelTank extends ItemCD {
   public int clipSize = -1;

   public ItemFuelTank(int par1, int par2) {
      super(par1);
      this.clipSize = par2;
      this.setMaxDamage(par2 + 1);
      this.setMaxStackSize(1);
   }

   public void onUpdate(ItemStack par1ItemStack, World par2World, Entity par3Entity, int par4, boolean par5) {
      if (par3Entity instanceof EntityPlayer) {
         EntityPlayer player = (EntityPlayer)par3Entity;
         if (player.getCurrentEquippedItem() == par1ItemStack && this.getDamage(par1ItemStack) > this.clipSize) {
            player.inventory.setInventorySlotContents(player.inventory.currentItem, (ItemStack)null);
         }
      }

   }

   @SideOnly(Side.CLIENT)
   public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
      super.addInformation(par1ItemStack, par2EntityPlayer, par3List, par4);
      int var1 = this.clipSize - par1ItemStack.getItemDamage();
      par3List.add("Топлива " + EnumChatFormatting.RED + var1);
   }
}
