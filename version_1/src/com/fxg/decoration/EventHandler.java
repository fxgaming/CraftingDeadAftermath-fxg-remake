package com.fxg.decoration;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.util.EnumMovingObjectType;
import net.minecraft.world.World;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.client.event.RenderGameOverlayEvent.Post;
import net.minecraftforge.event.ForgeSubscribe;

public class EventHandler {
	@ForgeSubscribe
	public void renderGameOverlay(Post event) {
		if (event.type.equals(ElementType.ALL)) {
			World world = Minecraft.getMinecraft().theWorld;
			FontRenderer fr = Minecraft.getMinecraft().fontRenderer;
			int width = event.resolution.getScaledWidth();
			int height = event.resolution.getScaledHeight();
			double hitDistance = 0.0D;
			String text = "";
			String text2 = "";
			double scale;
			if (Minecraft.getMinecraft().objectMouseOver.typeOfHit == EnumMovingObjectType.TILE) {
				int blockX = Minecraft.getMinecraft().objectMouseOver.blockX;
				int blockY = Minecraft.getMinecraft().objectMouseOver.blockY;
				int blockZ = Minecraft.getMinecraft().objectMouseOver.blockZ;
				hitDistance = CDDUtils.getDistanceToClientCamera((double) blockX, (double) blockY, (double) blockZ);
				if (Block.blocksList[world.getBlockId(blockX, blockY, blockZ)] != null) {
					Block theBlock = Block.blocksList[world.getBlockId(blockX, blockY, blockZ)];
//					if (theBlock instanceof BlockProp && thePlayer.capabilities.isCreativeMode && world.getTileEntity(blockX, blockY, blockZ) != null) {
//						TileEntityProp propTile = (TileEntityProp) world.getTileEntity(blockX, blockY, blockZ);
//						text = "x: " + propTile.rotationX + " y: " + propTile.rotationY + " z: " + propTile.rotationZ;
//						text2 = propTile.getName();
//					}
				}
			}

			int x2 = width / 2;
			int y2 = height / 2 - 7 - fr.FONT_HEIGHT - 10;
			scale = (2.0D - hitDistance / 3.0D) * 0.75D;
			if (text != null && scale > 0.0D) {
				CDDUtils.renderCenteredTextScaledWithOutline(text, x2, y2, scale, 16777215);
			}

			if (text2 != null && scale > 0.0D) {
				CDDUtils.renderCenteredTextScaledWithOutline(text2, x2, y2 + 14, scale, 16777215);
			}
		}
	}
}
