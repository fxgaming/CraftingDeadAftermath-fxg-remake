package com.ferullogaming.craftingdead.block;

import java.util.Random;

import com.ferullogaming.craftingdead.entity.EntityGroundItem;
import com.ferullogaming.craftingdead.item.ItemManager;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockBaseCenter extends BlockContainer {
   protected BlockBaseCenter(int par1) {
      super(par1, Material.rock);
      this.setBlockUnbreakable();
      this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
      this.setCreativeTab(ItemManager.tabCraftingDead);
   }

   @SideOnly(Side.CLIENT)
   public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9) {
      TileEntityBaseCenter tile = (TileEntityBaseCenter)par1World.getBlockTileEntity(par2, par3, par4);
      if (par1World.isRemote && tile != null && tile.getFlagOwner() != null && tile.getFlagOwner().equals(par5EntityPlayer.username)) {
      }
      return false;
   }

   public void onBaseRemovalRequested(World par1, int par2, int par3, int par4, EntityPlayer par5) {
      this.removeBaseMaterials(par1, par2, par3, par4, par5);
      par1.destroyBlock(par2, par3, par4, false);
   }

   public void removeBaseMaterials(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer) {
      Random rand = new Random();
      int var1 = 11;
      int var2 = 3;
      int var3 = var1 * 2;

      for(int x = -var1; x < var1; ++x) {
         for(int y = -var2; y < var3; ++y) {
            for(int z = -var1; z < var1; ++z) {
               int blockid = par1World.getBlockId(x + par2, y + par3, z + par4);

               for(int i = 0; i < BlockManager.buildingMaterials.length; ++i) {
                  if (blockid == BlockManager.buildingMaterials[i]) {
                     par1World.destroyBlock(x + par2, y + par3, z + par4, false);
                     EntityGroundItem item;
                     if (blockid == 5) {
                        item = new EntityGroundItem(par1World, (double)(x + par2), (double)(y + par3), (double)(z + par4));
                        item.setEntityItemStack(new ItemStack(ItemManager.logSplit, rand.nextInt(3) + 1, 0));
                        par1World.spawnEntityInWorld(item);
                     }

                     if (blockid == 98) {
                        item = new EntityGroundItem(par1World, (double)(x + par2), (double)(y + par3), (double)(z + par4));
                        item.setEntityItemStack(new ItemStack(ItemManager.stonePebble, rand.nextInt(3) + 1, 0));
                        par1World.spawnEntityInWorld(item);
                     }
                     break;
                  }
               }
            }
         }
      }

   }

   public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, int par2, int par3, int par4) {
      this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
   }

   public int getRenderType() {
      return BlockManager.renderBaseCenterID;
   }

   public boolean isOpaqueCube() {
      return false;
   }

   public boolean renderAsNormalBlock() {
      return false;
   }

   public TileEntity createNewTileEntity(World world) {
      return new TileEntityBaseCenter();
   }

   @SideOnly(Side.CLIENT)
   public void registerIcons(IconRegister par1IconRegister) {
      super.blockIcon = par1IconRegister.registerIcon("craftingdead:lootspawnerresidential");
   }
}
