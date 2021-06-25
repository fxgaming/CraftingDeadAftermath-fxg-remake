package com.ferullogaming.craftingdead.block;

import com.ferullogaming.craftingdead.item.ItemManager;
import com.ferullogaming.craftingdead.item.gun.ItemAmmo;
import com.ferullogaming.craftingdead.item.gun.ItemGun;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockLoot extends BlockContainer {
   private LootType lootType;

   protected BlockLoot(int par1, LootType par2) {
      super(par1, Material.rock);
      this.lootType = par2;
      this.setBlockUnbreakable();
      this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.25F, 1.0F);
      this.setCreativeTab(ItemManager.tabCraftingDead);
   }

   public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9) {
      TileEntityLoot tile = (TileEntityLoot)par1World.getBlockTileEntity(par2, par3, par4);
      if (tile == null) {
         return false;
      } else {
         if (tile.getItemStack() != null) {
            if (par5EntityPlayer.getDistance((double)par2, (double)par3, (double)par4) <= 5.0D && par5EntityPlayer.inventory.addItemStackToInventory(tile.getItemStack())) {
               Random rand = new Random();
               par1World.playSoundAtEntity(par5EntityPlayer, "random.pop", 0.2F, ((rand.nextFloat() - rand.nextFloat()) * 0.7F + 1.0F) * 2.0F);
            } else if (!par1World.isRemote) {
               ItemStack lootStack = tile.getItemStack();
               EntityItem entityItem = new EntityItem(par1World, (double)par2 + 0.5D, (double)par3 + 0.5D, (double)par4 + 0.5D, lootStack);
               par1World.spawnEntityInWorld(entityItem);
               if (lootStack.getItem() instanceof ItemGun) {
                  Random rand = new Random();
                  if (rand.nextInt(8) == 0) {
                     ItemAmmo ammoitem = (ItemAmmo)Item.itemsList[((ItemGun)lootStack.getItem()).getDefaultAllowedClip()];
                     if (ammoitem != null) {
                        ItemStack ammoStack = tile.getItemStack();
                        EntityItem ammoDrop = new EntityItem(par1World, (double)par2, (double)par3, (double)par4, ammoStack);
                        par1World.spawnEntityInWorld(ammoDrop);
                     }
                  }
               }
            }
         }

         par1World.removeBlockTileEntity(par2, par3, par4);
         par1World.setBlock(par2, par3, par4, 0);
         return true;
      }
   }

   public int getRenderType() {
      return BlockManager.renderLootID;
   }

   public LootType getLootType() {
      return this.lootType;
   }

   public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, int par2, int par3, int par4) {
      this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.25F, 1.0F);
   }

   public boolean isOpaqueCube() {
      return false;
   }

   public boolean renderAsNormalBlock() {
      return false;
   }

   @SideOnly(Side.CLIENT)
   public void registerIcons(IconRegister par1IconRegister) {
      super.blockIcon = par1IconRegister.registerIcon("craftingdead:lootspawnerresidential");
   }

   public TileEntity createNewTileEntity(World world) {
      return new TileEntityLoot(this.lootType);
   }
}
