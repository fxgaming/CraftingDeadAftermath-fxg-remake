package by.fxg.craftingdead.item;

import java.util.List;
import java.util.Random;

import by.fxg.craftingdead.entity.EntityGroundItem;
import by.fxg.craftingdead.events.EventBaseMaterialHarvested;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;

public class ItemCDPickaxe extends ItemMeleeWeapon {
   public int dropRate = 1;
   public float pickaxeStrength = 1.2F;

   public ItemCDPickaxe(int par1, int par2, int par3) {
      super(par1, par2, par3);
   }

   public ItemCDPickaxe setPickaxeDropRate(int par1) {
      this.dropRate = par1;
      return this;
   }

   public ItemCDPickaxe setPickaxeStrength(float par1) {
      this.pickaxeStrength = par1;
      return this;
   }

   public boolean onBlockStartBreak(ItemStack itemstack, int X, int Y, int Z, EntityPlayer player) {
      World world = player.worldObj;
      int blockid = world.getBlockId(X, Y, Z);
      if (player.capabilities.isCreativeMode) {
         return false;
      } else if (blockid != 0 && blockid == Block.stone.blockID) {
         Random rand = new Random();
         if (!world.isRemote) {
            int dropAmount = rand.nextInt(this.dropRate) + 1;
            ItemStack dropStack = new ItemStack(ItemManager.stonePebble.itemID, dropAmount, 0);
            EventBaseMaterialHarvested event = new EventBaseMaterialHarvested(this, dropStack);
            MinecraftForge.EVENT_BUS.post(event);
            if (!player.inventory.addItemStackToInventory(dropStack)) {
               EntityGroundItem entityItem = new EntityGroundItem(world, (double)X, (double)Y, (double)Z);
               entityItem.setEntityItemStack(dropStack);
               world.spawnEntityInWorld(entityItem);
            } else {
               world.playSoundAtEntity(player, "random.pop", 0.2F, ((rand.nextFloat() - rand.nextFloat()) * 0.7F + 1.0F) * 2.0F);
            }
         }

         this.damageItemStack(itemstack, player, 2);
         return true;
      } else if (blockid != 0 && this.isBlockIDAllowed(blockid)) {
         this.damageItemStack(itemstack, player, 1);
         return true;
      } else {
         return false;
      }
   }

   public void damageItemStack(ItemStack par1, EntityPlayer par2, int par3) {
      int itemDamage = par1.getItemDamage();
      par1.damageItem(par3, par2);
      if (itemDamage + par3 >= par1.getMaxDamage()) {
         par2.playSound("random.break", 0.8F, 0.8F + par2.worldObj.rand.nextFloat() * 0.4F);
         par2.destroyCurrentEquippedItem();
      }

   }

   public float getStrVsBlock(ItemStack par1ItemStack, Block par2Block) {
      return this.isBlockIDAllowed(par2Block.blockID) ? this.pickaxeStrength : 1.0F;
   }

   public boolean canHarvestBlock(Block par1Block) {
      return this.isBlockIDAllowed(par1Block.blockID);
   }

   public boolean isBlockIDAllowed(int par1) {
      int[] var2 = ItemManager.destroyablePickaxeIDs;
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         int var1 = var2[var4];
         if (var1 == par1) {
            return true;
         }
      }

      return false;
   }

   @SideOnly(Side.CLIENT)
   public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
      par3List.add("Копайте что-бы добыть камень!");
      super.addInformation(par1ItemStack, par2EntityPlayer, par3List, par4);
   }
}
