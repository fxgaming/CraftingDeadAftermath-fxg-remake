package by.fxg.craftingdead.block;

import by.fxg.craftingdead.item.ItemCDPickaxe;
import by.fxg.craftingdead.item.ItemManager;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockSandBarrier extends BlockContainer {
   public BlockSandBarrier(int par1) {
      super(par1, Material.rock);
      this.setHardness(3.0F);
      this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
      this.setCreativeTab(ItemManager.tabCraftingDead);
   }

   public int getRenderType() {
      return BlockManager.renderSandBarrierID;
   }

   public boolean isOpaqueCube() {
      return false;
   }

   public boolean renderAsNormalBlock() {
      return false;
   }

   public TileEntity createNewTileEntity(World world) {
      return new TileEntitySandBarrier();
   }

   public boolean removeBlockByPlayer(World world, EntityPlayer player, int x, int y, int z) {
      if (player.capabilities.isCreativeMode) {
         return world.setBlockToAir(x, y, z);
      } else {
         return player.getCurrentEquippedItem() != null && player.getCurrentEquippedItem().getItem() instanceof ItemCDPickaxe ? world.setBlockToAir(x, y, z) : false;
      }
   }

   @SideOnly(Side.CLIENT)
   public void registerIcons(IconRegister par1IconRegister) {
      super.blockIcon = par1IconRegister.registerIcon("craftingdead:lootspawnerresidential");
   }
}
