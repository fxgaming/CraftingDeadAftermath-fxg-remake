package com.ferullogaming.craftingdead.item;

import com.ferullogaming.craftingdead.ModSettings;
import com.ferullogaming.craftingdead.block.BlockLoot;
import com.ferullogaming.craftingdead.block.LootType;
import com.ferullogaming.craftingdead.client.util.KeyBindingManager;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import org.lwjgl.input.Keyboard;

public class ItemCDBlockLoot extends ItemCDBlock {
   public ItemCDBlockLoot(int par1) {
      super(par1);
   }

   public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
      Block block = Block.blocksList[this.getBlockID()];
   }
}
