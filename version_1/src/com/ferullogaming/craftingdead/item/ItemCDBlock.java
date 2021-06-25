package com.ferullogaming.craftingdead.item;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemCDBlock extends ItemBlock {
   protected ArrayList basicInformation = new ArrayList();

   public ItemCDBlock(int par1) {
      super(par1);
   }

   public ItemCDBlock addInformation(String par1) {
      this.basicInformation.add(par1);
      return this;
   }

   public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
      if (this.basicInformation.size() > 0) {
         par3List.addAll(this.basicInformation);
      }

   }
}
