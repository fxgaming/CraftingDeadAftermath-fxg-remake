package com.fxg.decoration.block;

import java.util.Random;

import com.fxg.decoration.tile.block.TileHangingPlayer;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class BlockHangingPlayer extends BlockBaseProp {
	public BlockHangingPlayer(int id) {
		super(id, "TileHangingPlayer");
		this.setRotateable().install("BlockHangingPlayer");
		GameRegistry.registerBlock(this, "BlockHangingPlayer");
		GameRegistry.registerTileEntity(TileHangingPlayer.class, "TileHangingPlayer");
		LanguageRegistry.addName(this, "Повешанный игрок");
		this.setBlockBounds(0.25f, 0.75f, 0.25f, 0.75f, 1.0f, 0.75f);
		this.setNoCollide();
	}

    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World world, int x, int y, int z, Random random) {
        double d = Math.random();
        Random r = new Random();
        if (d < 0.4) {
            world.spawnParticle("dripLava", (double)x + 0.5 + (double)(r.nextDouble() / 2.5D), (double)y - 0.5, (double)z + 0.7, 0.0, -5.0, 0.0);
        }
    }

    public AxisAlignedBB getCollisionBoundingBoxFromPool(World worldIn, int x, int y, int z) {
        return null;
    }
}
