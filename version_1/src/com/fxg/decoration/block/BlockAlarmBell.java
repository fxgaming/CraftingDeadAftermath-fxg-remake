package com.fxg.decoration.block;

import com.fxg.decoration.tile.TileBaseProp;
import com.fxg.decoration.tile.block.TileAlarmBell;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class BlockAlarmBell extends BlockBaseProp {
	public BlockAlarmBell(int id) {
		super(id, "TileAlarmBell");
		this.setRotateable().install("BlockAlarmBell");
		GameRegistry.registerBlock(this, "BlockAlarmBell");
		GameRegistry.registerTileEntity(TileAlarmBell.class, "TileAlarmBell");
		LanguageRegistry.addName(this, "Колокол");
	}

	@Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float subX, float subY, float subZ) {
		super.onBlockActivated(world, x, y, z, player, side, subX, subY, subZ);
        if (!world.isRemote) {
            world.playSoundEffect((double)x + 0.5, (double)y + 0.5, (double)z + 0.5, "craftingdead:block.bell", 1.0f, 1.0f);
            world.playSoundEffect((double)x + 0.5, (double)y + 0.5, (double)z + 0.5, "craftingdead:block.belldistant", 6.0f, 1.0f);
        }
		return true;
	}
}
