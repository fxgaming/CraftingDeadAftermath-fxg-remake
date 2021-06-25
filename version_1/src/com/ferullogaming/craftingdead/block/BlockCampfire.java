package com.ferullogaming.craftingdead.block;

import com.ferullogaming.craftingdead.item.ItemCDPickaxe;
import com.ferullogaming.craftingdead.item.ItemManager;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockCampfire extends BlockContainer {
   public BlockCampfire(int par1) {
      super(par1, Material.wood);
      this.setLightValue(1.0F);
      this.setHardness(2.0F);
      this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
      this.setCreativeTab(ItemManager.tabCraftingDead);
   }

   public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, int par2, int par3, int par4) {
      this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
   }

   public int getRenderType() {
      return BlockManager.renderCampfireID;
   }

   public boolean isOpaqueCube() {
      return false;
   }

   public boolean renderAsNormalBlock() {
      return false;
   }

   public boolean removeBlockByPlayer(World world, EntityPlayer player, int x, int y, int z) {
      if (player.capabilities.isCreativeMode) {
         return world.setBlockToAir(x, y, z);
      } else {
         return player.getCurrentEquippedItem() != null && player.getCurrentEquippedItem().getItem() instanceof ItemCDPickaxe ? world.setBlockToAir(x, y, z) : false;
      }
   }

   public TileEntity createNewTileEntity(World world) {
      return new TileEntityCampfire();
   }

   public void onEntityWalking(World par1World, int par2, int par3, int par4, Entity par5Entity) {
      if (!par1World.isRemote) {
         par5Entity.setFire(3);
      }

   }

   public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random) {
      int i;
      double vx;
      double vy;
      double vz;
      for(i = 0; i < 2; ++i) {
         vx = (0.5D - par5Random.nextDouble()) / 2.0D;
         vy = par5Random.nextDouble() / 2.0D;
         vz = (0.5D - par5Random.nextDouble()) / 2.0D;
         par1World.spawnParticle("flame", (double)par2 + 0.5D + vx, (double)par3 + 0.25D + vy, (double)par4 + 0.5D + vz, 0.0D, 0.0D, 0.0D);
      }

      for(i = 0; i < 4; ++i) {
         vx = (0.5D - par5Random.nextDouble()) / 2.0D;
         vy = par5Random.nextDouble() / 2.0D;
         vz = (0.5D - par5Random.nextDouble()) / 2.0D;
         par1World.spawnParticle("smoke", (double)par2 + 0.5D + vx, (double)par3 + 0.5D + vy, (double)par4 + 0.5D + vz, 0.0D, 0.0D, 0.0D);
      }

   }

   @SideOnly(Side.CLIENT)
   public void registerIcons(IconRegister par1IconRegister) {
      super.blockIcon = par1IconRegister.registerIcon("craftingdead:lootspawnerresidential");
   }
}
