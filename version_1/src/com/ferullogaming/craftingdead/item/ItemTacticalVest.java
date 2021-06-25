package com.ferullogaming.craftingdead.item;

import com.ferullogaming.craftingdead.CDAftermath;
import com.ferullogaming.craftingdead.client.render.RenderTacticalVest;
import com.ferullogaming.craftingdead.inventory.InventoryTacticalVest;
import com.ferullogaming.craftingdead.player.PlayerData;
import com.ferullogaming.craftingdead.player.PlayerDataHandler;
import java.util.Iterator;
import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import org.lwjgl.input.Keyboard;

public class ItemTacticalVest extends ItemCD {
   private RenderTacticalVest vestRenderer;

   public ItemTacticalVest(int par1) {
      super(par1);
      this.setMaxStackSize(1);
   }

   public ItemTacticalVest setRenderer(RenderTacticalVest par1) {
      this.vestRenderer = par1;
      return this;
   }

   public static IInventory getVestInventory(EntityPlayer player) {
      IInventory vestInv = null;
      if (!player.worldObj.isRemote) {
         PlayerData data = CDAftermath.instance.playerDataHandler().getPlayerData(player);
         ItemStack vestStack = data.getCDInventory().getStack("vest");
         if (vestStack != null && vestStack.getItem() instanceof ItemTacticalVest) {
            vestInv = new InventoryTacticalVest(vestStack);
         }
      }

      return vestInv;
   }

   public static IInventory getTacticalVestInventory(ItemStack itemstack) {
      return itemstack != null && itemstack.getItem() instanceof ItemTacticalVest ? new InventoryTacticalVest(itemstack) : null;
   }

   public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
      super.addInformation(par1ItemStack, par2EntityPlayer, par3List, par4);
      par3List.add("Уменьшает урон от пуль в тело на 20%");
      InventoryTacticalVest vestInventory = (InventoryTacticalVest)getTacticalVestInventory(par1ItemStack);
      if (vestInventory != null) {
         int var1 = vestInventory.getInventoryList().size();
         par3List.add("Нажмите 'R' для большей информации!");
         par3List.add("Содержит " + EnumChatFormatting.RED + var1 + EnumChatFormatting.GRAY + " вещь(ей)");
         if (Keyboard.isKeyDown(19)) {
            par3List.add(EnumChatFormatting.RED + "-=-=- Содержание -=-=-");
            Iterator var7 = vestInventory.getInventoryList().iterator();

            while(var7.hasNext()) {
               ItemStack stack = (ItemStack)var7.next();
               par3List.add(stack.getDisplayName());
            }
         }
      }

   }

   public boolean getShareTag() {
      return true;
   }

   public RenderTacticalVest getTacticalVestRenderer() {
      return this.vestRenderer;
   }
}
