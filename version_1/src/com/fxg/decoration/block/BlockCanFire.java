package com.fxg.decoration.block;

import java.util.Random;

import com.fxg.decoration.tile.block.TileCanFire;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.world.World;

public class BlockCanFire extends BlockBaseProp {
	public BlockCanFire(int id) {
		super(id, "TileCanFire");
		this.setRotateable().install("BlockCanFire");
		GameRegistry.registerBlock(this, "BlockCanFire");
		GameRegistry.registerTileEntity(TileCanFire.class, "TileCanFire");
		LanguageRegistry.addName(this, "Горшок с огнем");
		this.setLightValue(1.0F);
	}
	
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World worldIn, int x, int y, int z, Random random) {
        if (random.nextInt(20) == 0) {
            worldIn.playSound((double)((float)x + 0.5f), (double)((float)y + 0.5f), (double)((float)z + 0.5f), "fire.fire", 1.0f + random.nextFloat(), random.nextFloat() * 0.7f + 0.3f, false);
        }
        if (Math.random() < 0.5) {
            worldIn.spawnParticle("smoke", (double)x + 0.5, (double)y + 0.25, (double)z + 0.5, 0.0, 0.0, 0.0);
            worldIn.spawnParticle("flame", (double)x + 0.5, (double)y + 0.25, (double)z + 0.5, 0.0, 0.0, 0.0);
            for (int i = 0; i < 3; ++i) {
                worldIn.spawnParticle("flame", (double)x + 0.5 + (Math.random() < 0.5 ? 0.1 : -0.1), (double)y + 0.3, (double)z + 0.5 + (Math.random() < 0.5 ? 0.1 : -0.1), 0.0, 0.0, 0.0);
            }
        }
    }
}
