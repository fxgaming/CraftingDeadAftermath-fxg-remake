package com.fxg.decoration.block;

import java.util.Random;

import com.fxg.decoration.tile.block.TileElectricBoxBin;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class BlockElectricBoxBin extends BlockBaseProp {
	public BlockElectricBoxBin(int id) {
		super(id, "TileElectricBoxBin");
		this.setRotateable().install("BlockElectricBoxBin");
		GameRegistry.registerBlock(this, "BlockElectricBoxBin");
		GameRegistry.registerTileEntity(TileElectricBoxBin.class, "TileElectricBoxBin");
		LanguageRegistry.addName(this, "Электрический ящик");
	}

    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World world, int x, int y, int z, Random random) {
        if (random.nextBoolean()) {
            world.playSound((double)((float)x + 0.5f), (double)((float)y + 0.5f), (double)((float)z + 0.5f), "craftingdead:block.electricbox0_", 0.025f, 0.5f, false);
        }
    }
}
