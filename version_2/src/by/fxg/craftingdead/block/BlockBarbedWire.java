package by.fxg.craftingdead.block;

import by.fxg.craftingdead.item.ItemCDAxe;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class BlockBarbedWire extends BlockCD {
   public int damageToEntity = 1;

   public BlockBarbedWire(int par1, int par2) {
      super(par1, Material.wood);
      this.setHardness(0.5F);
      this.damageToEntity = par2;
   }

   public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity par5Entity) {
      par5Entity.attackEntityFrom(DamageSource.cactus, (float)this.damageToEntity);
      par5Entity.setInWeb();
   }

   public boolean isOpaqueCube() {
      return false;
   }

   public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4) {
      return null;
   }

   public int getRenderType() {
      return 1;
   }

   public boolean removeBlockByPlayer(World world, EntityPlayer player, int x, int y, int z) {
      if (player.capabilities.isCreativeMode) {
         return world.setBlockToAir(x, y, z);
      } else {
         return player.getCurrentEquippedItem() != null && player.getCurrentEquippedItem().getItem() instanceof ItemCDAxe ? world.setBlockToAir(x, y, z) : false;
      }
   }

   public boolean renderAsNormalBlock() {
      return false;
   }
}
