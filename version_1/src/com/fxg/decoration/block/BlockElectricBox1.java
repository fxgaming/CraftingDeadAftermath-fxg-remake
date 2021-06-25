package com.fxg.decoration.block;

import java.util.Random;

import com.fxg.decoration.tile.block.TileElectricBox1;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class BlockElectricBox1 extends BlockBaseProp {
	public BlockElectricBox1(int id) {
		super(id, "TileElectricBox1");
		this.setRotateable().install("BlockElectricBox1");
		GameRegistry.registerBlock(this, "BlockElectricBox1");
		GameRegistry.registerTileEntity(TileElectricBox1.class, "TileElectricBox1");
		LanguageRegistry.addName(this, "Электрическая коробка 1");
	}

    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World world, int x, int y, int z, Random random) {
        if (random.nextBoolean()) {
            world.playSound((double)((float)x + 0.5f), (double)((float)y + 0.5f), (double)((float)z + 0.5f), "craftingdead:block.electricbox1_", 0.05f, 1.0f, false);
        }
    }

    public AxisAlignedBB getCollisionBoundingBoxFromPool(World worldIn, int x, int y, int z) {
        return null;
    }
}
