package com.ferullogaming.craftingdead.item;

import com.ferullogaming.craftingdead.CDAftermath;
import com.ferullogaming.craftingdead.client.model.ModelFuelTanks;
import com.ferullogaming.craftingdead.client.render.RenderFuelTanks;
import com.ferullogaming.craftingdead.inventory.InventoryFuelTanks;
import com.ferullogaming.craftingdead.player.PlayerData;
import com.ferullogaming.craftingdead.player.PlayerDataHandler;
import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

public class ItemFuelTankBackpack extends ItemCD {
   private RenderFuelTanks tankRenderer;

   public ItemFuelTankBackpack(int par1) {
      super(par1);
      this.setMaxStackSize(1);
      this.setRenderer(new RenderFuelTanks("modelfueltanks", new ModelFuelTanks()));
   }

   public ItemFuelTankBackpack setRenderer(RenderFuelTanks par1) {
      this.tankRenderer = par1;
      return this;
   }

   public static IInventory getTanksInventory(EntityPlayer player) {
      IInventory inv = null;
      PlayerData data = CDAftermath.instance.playerDataHandler().getPlayerData(player);
      ItemStack tankStack = data.getCDInventory().getStack("backpack");
      if (!player.worldObj.isRemote && tankStack != null && tankStack.getItem() instanceof ItemFuelTankBackpack) {
         inv = new InventoryFuelTanks(tankStack);
      }

      return inv;
   }

   public static ItemStack getPotentialFuelStack(EntityPlayer player) {
      InventoryFuelTanks inv = (InventoryFuelTanks)getTanksInventory(player);
      if (inv != null && !player.worldObj.isRemote) {
         for(int i = 0; i < inv.getSizeInventory(); ++i) {
            ItemStack stack = inv.getStackInSlot(i);
            if (stack != null && stack.getItem() instanceof ItemFuelTank) {
               ItemFuelTank item = (ItemFuelTank)stack.getItem();
               if (stack.getItemDamage() < item.clipSize) {
                  return stack;
               }
            }
         }
      }

      return null;
   }

   public boolean getShareTag() {
      return true;
   }

   public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
      super.addInformation(par1ItemStack, par2EntityPlayer, par3List, par4);
      par3List.add("?????????????????? ???????????????????? ??????????????.");
   }

   public RenderFuelTanks getRenderer() {
      return this.tankRenderer;
   }
}
