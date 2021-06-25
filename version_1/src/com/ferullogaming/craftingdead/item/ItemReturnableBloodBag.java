package com.ferullogaming.craftingdead.item;

import com.ferullogaming.craftingdead.damage.DamageSourceBleeding;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class ItemReturnableBloodBag extends ItemReturnable {
   public ItemReturnableBloodBag(int par1, int par2) {
      super(par1, par2);
   }

   public boolean itemInteractionForEntity(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, EntityLivingBase par3EntityLivingBase) {
      if (super.onPlayerClicked) {
         if (par3EntityLivingBase instanceof EntityPlayer) {
            EntityPlayer playerClicked = (EntityPlayer)par3EntityLivingBase;
            if (playerClicked.getHealth() <= 4.0F) {
               return false;
            }

            playerClicked.attackEntityFrom(new DamageSourceBleeding(), 2.0F);
            --par1ItemStack.stackSize;
            if (!par2EntityPlayer.inventory.addItemStackToInventory(new ItemStack(super.returnItem + 256, 1, 0))) {
               par2EntityPlayer.dropPlayerItem(new ItemStack(super.returnItem + 256, 1, 0));
            }
         }

         return true;
      } else {
         return false;
      }
   }
}
