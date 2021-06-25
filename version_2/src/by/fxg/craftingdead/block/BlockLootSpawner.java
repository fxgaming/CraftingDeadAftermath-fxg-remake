package by.fxg.craftingdead.block;

import by.fxg.craftingdead.item.ItemManager;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockLootSpawner extends BlockContainer {
   private String texture = "";
   public int lootBlockID = 0;

   public BlockLootSpawner(int par1, String par2, int par3) {
      super(par1, Material.wood);
      this.texture = par2;
      this.lootBlockID = par3;
      this.setBlockUnbreakable();
      this.setCreativeTab(ItemManager.tabCraftingDead);
   }

   @SideOnly(Side.CLIENT)
   public Icon getBlockTexture(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5) {
      TileEntityLootSpawner tile = (TileEntityLootSpawner)par1IBlockAccess.getBlockTileEntity(par2, par3, par4);
      tile.getLocalBlocks();
      return tile != null && tile.blockID != 0 ? Block.blocksList[tile.blockID].getIcon(par5, tile.blockMETA) : this.getIcon(par5, par1IBlockAccess.getBlockMetadata(par2, par3, par4));
   }

   public boolean canSpawnLoot() {
      LootType type = ((BlockLoot)Block.blocksList[this.lootBlockID]).getLootType();
      return type.canSpawn();
   }

   @SideOnly(Side.CLIENT)
   public int colorMultiplier(IBlockAccess par1IBlockAccess, int par2, int par3, int par4) {
      TileEntityLootSpawner lootspawner = (TileEntityLootSpawner)par1IBlockAccess.getBlockTileEntity(par2, par3, par4);
      lootspawner.getLocalBlocks();
      if (lootspawner != null && lootspawner.blockID != 0) {
         Block b = Block.blocksList[lootspawner.blockID];
         if (!(b instanceof BlockLootSpawner)) {
            return b != null ? b.colorMultiplier(par1IBlockAccess, par2, par3, par4) : 16777215;
         }
      }

      return 16777215;
   }

   @SideOnly(Side.CLIENT)
   public Icon getIcon(int par1, int par2) {
      return super.blockIcon;
   }

   @SideOnly(Side.CLIENT)
   public void registerIcons(IconRegister par1IconRegister) {
      super.blockIcon = par1IconRegister.registerIcon("craftingdead:lootspawner" + this.texture);
   }

   public TileEntity createNewTileEntity(World world) {
      return new TileEntityLootSpawner();
   }
}
