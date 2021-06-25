package com.ferullogaming.craftingdead.item;

import com.ferullogaming.craftingdead.CDAftermath;
import com.ferullogaming.craftingdead.player.PlayerData;
import com.ferullogaming.craftingdead.player.PlayerDataHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

public class ItemHandcuffs extends ItemCD {
   public ItemHandcuffs(int par1) {
      super(par1);
      this.addInformation("Нажмите ПКМ по игроку!");
   }

   public boolean itemInteractionForEntity(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, EntityLivingBase par3EntityLivingBase) {
      World world = par2EntityPlayer.worldObj;
      if (!world.isRemote && par3EntityLivingBase instanceof EntityPlayer) {
         EntityPlayer playerHit = (EntityPlayer)par3EntityLivingBase;
         PlayerData playerHitData = CDAftermath.instance.playerDataHandler().getPlayerData(playerHit);
         if (playerHit.capabilities.isCreativeMode) {
            return false;
         }

         if (!playerHitData.isHandCuffed && par1ItemStack.stackSize > 0) {
            playerHitData.isHandCuffed = true;
            playerHitData.handcuffDamage = par1ItemStack.getItemDamage();
            playerHit.sendChatToPlayer(ChatMessageComponent.createFromText(EnumChatFormatting.RED + "Вы были закованы в наручники игроком " + par2EntityPlayer.getDisplayName()));
            --par1ItemStack.stackSize;
         }
      }

      return false;
   }

   @SideOnly(Side.CLIENT)
   public boolean isFull3D() {
      return false;
   }
}
