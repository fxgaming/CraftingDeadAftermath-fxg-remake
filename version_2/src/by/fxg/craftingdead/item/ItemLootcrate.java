package by.fxg.craftingdead.item;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import org.lwjgl.input.Keyboard;

import by.fxg.craftingdead.entity.EntityGroundItem;
import by.fxg.craftingdead.item.gun.ItemGun;

public class ItemLootcrate extends ItemCD {
   public ArrayList crateContent = new ArrayList();

   public ItemLootcrate(int par1) {
      super(par1);
      this.setMaxStackSize(16);
      this.addInformation("Нажпите ПКМ что-бы открыть!");
   }

   public ItemLootcrate addContent(Item par1Item, int par2Weight) {
      this.crateContent.add(new CrateContent(par1Item.itemID, par2Weight));
      return this;
   }

   public ItemStack getRandomItemStack(EntityPlayer par3EntityPlayer) {
      ArrayList list = new ArrayList();

      for(int i = 0; i < this.crateContent.size(); ++i) {
         CrateContent content = (CrateContent)this.crateContent.get(i);

         for(int i1 = 0; i1 < content.weight; ++i1) {
            ItemStack itemstack = new ItemStack(content.itemID, 1, 0);
            list.add(itemstack);
         }
      }

      Random rand = new Random();
      ItemStack randStack = ((ItemStack)list.get(rand.nextInt(list.size()))).copy();
      if (randStack.getItem() instanceof ItemGun) {
         ItemGun gunitem = (ItemGun)randStack.getItem();
         gunitem.loadClipIntoGun(par3EntityPlayer, randStack, new ItemStack(Item.itemsList[gunitem.getDefaultAllowedClip()]));
      }

      return randStack;
   }

   public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
      if (!par2World.isRemote) {
         par2World.playSoundAtEntity(par3EntityPlayer, "random.pop", 1.0F, 1.0F);
         par2World.playSoundAtEntity(par3EntityPlayer, "random.pop", 0.5F, 1.5F);
         par2World.playSoundAtEntity(par3EntityPlayer, "random.pop", 0.7F, 2.0F);
         ItemStack randStack = this.getRandomItemStack(par3EntityPlayer);
         --par1ItemStack.stackSize;
         if (!par3EntityPlayer.inventory.addItemStackToInventory(randStack)) {
            EntityGroundItem entity = new EntityGroundItem(par2World, par3EntityPlayer.posX, par3EntityPlayer.posY, par3EntityPlayer.posZ);
            entity.setEntityItemStack(randStack);
            par2World.spawnEntityInWorld(entity);
         }

         return par1ItemStack;
      } else {
         return par1ItemStack;
      }
   }

   public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
      super.addInformation(par1ItemStack, par2EntityPlayer, par3List, par4);
      if (Keyboard.isKeyDown(19)) {
         par3List.add(EnumChatFormatting.RED + "-=-=-=- Что внутри? -=-=-=-");

         for(int i = 0; i < this.crateContent.size(); ++i) {
            CrateContent content = (CrateContent)this.crateContent.get(i);
            ItemStack stack = new ItemStack(content.itemID, 1, 0);
            par3List.add(EnumChatFormatting.RED + "" + content.weight + " " + EnumChatFormatting.GRAY + stack.getDisplayName());
         }
      } else {
         par3List.add(EnumChatFormatting.RED + "Нажмите 'R' что-бы посмотреть что внутри!");
      }

   }
}
