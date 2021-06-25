package com.fxg.decoration.block;

import com.fxg.decoration.tile.block.TileCanTrap;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class BlockCanTrap extends BlockBaseProp {
	public BlockCanTrap(int id) {
		super(id, "TileCanTrap");
		this.setRotateable().install("BlockCanTrap");
		GameRegistry.registerBlock(this, "BlockCanTrap");
		GameRegistry.registerTileEntity(TileCanTrap.class, "TileCanTrap");
		LanguageRegistry.addName(this, "Звуковая ловушка");
	}

    public void onEntityCollidedWithBlock(World worldIn, int x, int y, int z, Entity entityIn) {
        if (entityIn instanceof EntityPlayer && ((EntityPlayer)entityIn).capabilities.isCreativeMode) {
            return;
        }
        if (!worldIn.isRemote) {
            double d = entityIn.isSprinting() ? 0.1 : 0.05;
            if (Math.random() < d) {
                worldIn.playSoundEffect((double)x, (double)y, (double)z, "craftingdead:block.tinhit", entityIn.isSprinting() ? 1.5f : 1.0f, 1.0f);
            }
        }
    }

    public AxisAlignedBB getCollisionBoundingBoxFromPool(World worldIn, int x, int y, int z) {
        return null;
    }
}
