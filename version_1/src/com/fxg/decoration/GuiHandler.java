package com.fxg.decoration;

import com.fxg.decoration.gui.GuiEditTile;
import com.fxg.decoration.gui.GuiEditTile;
import com.fxg.decoration.tile.TileBaseProp;

import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class GuiHandler implements IGuiHandler {
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if (ID == 10) {
			TileBaseProp tile = (TileBaseProp)world.getBlockTileEntity(x, y, z);
			return new GuiEditTile(tile);
		}
		return null;
	}
}
