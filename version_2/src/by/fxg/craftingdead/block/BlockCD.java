package by.fxg.craftingdead.block;

import by.fxg.craftingdead.item.ItemManager;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;

public class BlockCD extends Block {
   private String blockTexture = "defaultcdblock";

   public BlockCD(int par1) {
      super(par1, Material.rock);
      this.setBlockUnbreakable();
      this.setCreativeTab(ItemManager.tabCraftingDead);
   }

   public BlockCD(int par1, Material par2) {
      super(par1, par2);
      this.setCreativeTab(ItemManager.tabCraftingDead);
   }

   @SideOnly(Side.CLIENT)
   public Icon getIcon(int par1, int par2) {
      return super.blockIcon;
   }

   public BlockCD setCDTexture(String par1) {
      this.blockTexture = par1;
      return this;
   }

   @SideOnly(Side.CLIENT)
   public void registerIcons(IconRegister par1IconRegister) {
      super.blockIcon = par1IconRegister.registerIcon("craftingdead:" + this.blockTexture);
   }
}
