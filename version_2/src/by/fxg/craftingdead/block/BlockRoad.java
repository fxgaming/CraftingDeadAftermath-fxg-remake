package by.fxg.craftingdead.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockRoad extends BlockCD {
   @SideOnly(Side.CLIENT)
   protected Icon blockIconSide;
   @SideOnly(Side.CLIENT)
   protected Icon blockIconTop;
   protected Icon blockIconTop1;
   private String blockType;

   public BlockRoad(int par1, String par2) {
      super(par1);
      this.blockType = par2;
   }

   public void onBlockAdded(World par1World, int par2, int par3, int par4) {
      super.onBlockAdded(par1World, par2, par3, par4);
      this.setDefaultDirection(par1World, par2, par3, par4);
   }

   private void setDefaultDirection(World par1World, int par2, int par3, int par4) {
      if (!par1World.isRemote) {
         int l = par1World.getBlockId(par2, par3, par4 - 1);
         int i1 = par1World.getBlockId(par2, par3, par4 + 1);
         int j1 = par1World.getBlockId(par2 - 1, par3, par4);
         int k1 = par1World.getBlockId(par2 + 1, par3, par4);
         byte b0 = 3;
         if (Block.opaqueCubeLookup[l] && !Block.opaqueCubeLookup[i1]) {
            b0 = 3;
         }

         if (Block.opaqueCubeLookup[i1] && !Block.opaqueCubeLookup[l]) {
            b0 = 2;
         }

         if (Block.opaqueCubeLookup[j1] && !Block.opaqueCubeLookup[k1]) {
            b0 = 5;
         }

         if (Block.opaqueCubeLookup[k1] && !Block.opaqueCubeLookup[j1]) {
            b0 = 4;
         }

         par1World.setBlockMetadataWithNotify(par2, par3, par4, b0, 2);
      }

   }

   public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLivingBase par5EntityLivingBase, ItemStack par6ItemStack) {
      int l = MathHelper.floor_double((double)(par5EntityLivingBase.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
      if (l == 0) {
         par1World.setBlockMetadataWithNotify(par2, par3, par4, 2, 2);
      }

      if (l == 1) {
         par1World.setBlockMetadataWithNotify(par2, par3, par4, 5, 2);
      }

      if (l == 2) {
         par1World.setBlockMetadataWithNotify(par2, par3, par4, 3, 2);
      }

      if (l == 3) {
         par1World.setBlockMetadataWithNotify(par2, par3, par4, 4, 2);
      }

   }

   @SideOnly(Side.CLIENT)
   public Icon getIcon(int par1, int par2) {
      if ((par2 == 4 || par2 == 5) && par1 == 1) {
         return this.blockIconTop1;
      } else if ((par2 == 2 || par2 == 3) && par1 == 1) {
         return this.blockIconTop;
      } else {
         return par1 == 1 ? this.blockIconTop : this.blockIconSide;
      }
   }

   @SideOnly(Side.CLIENT)
   public void registerIcons(IconRegister par1IconRegister) {
      this.blockIconTop = par1IconRegister.registerIcon("craftingdead:road_" + this.blockType);
      this.blockIconTop1 = par1IconRegister.registerIcon("craftingdead:road_" + this.blockType + "_1");
      this.blockIconSide = par1IconRegister.registerIcon("craftingdead:road");
   }
}
