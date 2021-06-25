package com.ferullogaming.craftingdead.item;

import com.ferullogaming.craftingdead.CDAftermath;
import com.ferullogaming.craftingdead.entity.EntityCDZombie;
import com.ferullogaming.craftingdead.player.PlayerData;
import com.ferullogaming.craftingdead.player.PlayerDataHandler;
import java.util.Random;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumMovingObjectType;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class ItemReturnable extends ItemCD {
   protected int returnItem;
   protected boolean onWaterClicked = false;
   protected boolean onPlayerClicked = false;
   protected boolean onZombieClicked = false;
   protected int zombieClickedChance;

   public ItemReturnable(int par1, int par2) {
      super(par1);
      this.returnItem = par2;
   }

   public ItemReturnable setWaterClicked() {
      this.onWaterClicked = true;
      return this;
   }

   public ItemReturnable setPlayerClicked() {
      this.onPlayerClicked = true;
      return this;
   }

   public ItemReturnable setZombieClicked(int par1) {
      this.onZombieClicked = true;
      this.zombieClickedChance = par1;
      return this;
   }

   public boolean itemInteractionForEntity(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, EntityLivingBase par3EntityLivingBase) {
      PlayerData data = CDAftermath.instance.playerDataHandler().getPlayerData(par2EntityPlayer);
      if (data.isHandCuffed) {
         return false;
      } else if (this.onPlayerClicked) {
         if (par3EntityLivingBase instanceof EntityPlayer) {
            --par1ItemStack.stackSize;
            if (!par2EntityPlayer.inventory.addItemStackToInventory(new ItemStack(this.returnItem + 256, 1, 0))) {
               par2EntityPlayer.dropPlayerItem(new ItemStack(this.returnItem + 256, 1, 0));
            }
         }

         return true;
      } else if (this.onZombieClicked) {
         Random rand = new Random();
         if (par3EntityLivingBase instanceof EntityCDZombie && rand.nextInt(100) <= this.zombieClickedChance) {
            --par1ItemStack.stackSize;
            if (!par2EntityPlayer.inventory.addItemStackToInventory(new ItemStack(this.returnItem + 256, 1, 0))) {
               par2EntityPlayer.dropPlayerItem(new ItemStack(this.returnItem + 256, 1, 0));
            }
         }

         return true;
      } else {
         return false;
      }
   }

   public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
      MovingObjectPosition var4 = this.getMovingObjectPositionFromPlayer(par2World, par3EntityPlayer, true);
      if (var4 == null) {
         return par1ItemStack;
      } else {
         if (var4.typeOfHit == EnumMovingObjectType.TILE) {
            int var5 = var4.blockX;
            int var6 = var4.blockY;
            int var7 = var4.blockZ;
            if (!par2World.canMineBlock(par3EntityPlayer, var5, var6, var7)) {
               return par1ItemStack;
            }

            if (!par3EntityPlayer.canPlayerEdit(var5, var6, var7, var4.sideHit, par1ItemStack)) {
               return par1ItemStack;
            }

            if (par2World.getBlockMaterial(var5, var6, var7) == Material.water && this.onWaterClicked) {
               --par1ItemStack.stackSize;
               if (par1ItemStack.stackSize <= 0) {
                  return new ItemStack(this.returnItem + 256, 1, 0);
               }

               if (!par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(this.returnItem + 256, 1, 0))) {
                  par3EntityPlayer.dropPlayerItem(new ItemStack(this.returnItem + 256, 1, 0));
               }
            }
         }

         return par1ItemStack;
      }
   }
}
