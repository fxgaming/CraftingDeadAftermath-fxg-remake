package by.fxg.craftingdead.item;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import org.lwjgl.input.Keyboard;

import by.fxg.craftingdead.ModSettings;
import by.fxg.craftingdead.block.BlockLoot;
import by.fxg.craftingdead.block.LootType;
import by.fxg.craftingdead.client.util.KeyBindingManager;

public class ItemCDBlockLoot extends ItemCDBlock {
   public ItemCDBlockLoot(int par1) {
      super(par1);
   }

   public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
      Block block = Block.blocksList[this.getBlockID()];
   }
}
