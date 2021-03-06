package com.ferullogaming.craftingdead.item;

import com.ferullogaming.craftingdead.CDAftermath;
import com.ferullogaming.craftingdead.client.render.RenderBackpack;
import com.ferullogaming.craftingdead.inventory.InventoryBackpack;
import com.ferullogaming.craftingdead.player.PlayerData;
import com.ferullogaming.craftingdead.player.PlayerDataHandler;
import java.util.Iterator;
import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import org.lwjgl.input.Keyboard;

public class ItemBackpack extends ItemCD {
   private EnumBackpackSize backpackSize;
   private RenderBackpack backpackRendering;

   public ItemBackpack(int par1, EnumBackpackSize par2) {
      super(par1);
      this.backpackSize = par2;
      this.setMaxStackSize(1);
   }

   public ItemBackpack setRenderer(RenderBackpack par1) {
      this.backpackRendering = par1;
      return this;
   }

   public static IInventory getBackpackInventory(EntityPlayer player) {
      IInventory backpackInv = null;
      PlayerData data = CDAftermath.instance.playerDataHandler().getPlayerData(player);
      ItemStack backpack = data.getCDInventory().getStack("backpack");
      if (!player.worldObj.isRemote && backpack != null && backpack.getItem() instanceof ItemBackpack) {
         backpackInv = new InventoryBackpack(getBackpackSize(backpack), backpack);
      }

      return backpackInv;
   }

   public static IInventory getBackpackInventory(ItemStack itemstack) {
      return itemstack != null && itemstack.getItem() instanceof ItemBackpack ? new InventoryBackpack(getBackpackSize(itemstack), itemstack) : null;
   }

   public static EnumBackpackSize getBackpackSize(ItemStack par1) {
      return par1 != null && par1.getItem() instanceof ItemBackpack ? ((ItemBackpack)par1.getItem()).getBackpackSize() : null;
   }

   public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
      super.addInformation(par1ItemStack, par2EntityPlayer, par3List, par4);
      InventoryBackpack backpackInventory = (InventoryBackpack)getBackpackInventory(par1ItemStack);
      if (backpackInventory != null) {
         int var1 = backpackInventory.getInventoryList().size();
         par3List.add("?????????????? 'R' ?????? ?????????????? ????????????????????!");
         par3List.add("???????????????? " + EnumChatFormatting.RED + var1 + EnumChatFormatting.GRAY + " ????????(????)");
         if (Keyboard.isKeyDown(19)) {
            par3List.add(EnumChatFormatting.RED + "-=-=-=- ???????????????????? -=-=-=-");
            Iterator var7 = backpackInventory.getInventoryList().iterator();

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

   public RenderBackpack getBackpackRenderer() {
      return this.backpackRendering;
   }

   public EnumBackpackSize getBackpackSize() {
      return this.backpackSize;
   }
}
