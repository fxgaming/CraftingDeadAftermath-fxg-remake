package com.fxg.decoration.render;

import org.lwjgl.opengl.GL11;

import com.fxg.decoration.model.IModel;
import com.fxg.decoration.tile.TileBaseProp;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class RenderBaseProp extends TileEntitySpecialRenderer {
	private ModelBase model;
	private String texture;

	public RenderBaseProp(ModelBase Model, String texture) {
		this.model = Model;
		this.texture = texture;
	}

	public void renderTileEntityAt(TileEntity tileentity, double d1, double d2, double d3, float f) {
		this.renderTileEntity((TileBaseProp)tileentity, d1, d2, d3, f);
	}

	public void renderTileEntity(TileBaseProp tile, double dl, double d2, double d3, float f) {
		int ii = tile.getFacing();
		GL11.glPushMatrix();
		GL11.glTranslatef((float) dl + 0.5F, (float) d2, (float) d3 + 0.5F);
		GL11.glRotatef(180F, 0F, 0F, 1F);
		GL11.glRotatef((float) (ii * 90), 0.0F, 1.0F, 0.0F);
		Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("craftingdead:textures/props/" + texture + (tile.texture.equals("") ? "" : "_" + tile.texture) + ".png"));
		GL11.glRotatef(tile.rotateX, 1F, 0F, 0F);
		GL11.glRotatef(tile.rotateY, 0F, 1F, 0F);
		GL11.glRotatef(tile.rotateZ, 0F, 0F, 1F);
		GL11.glScalef(tile.scaleX, tile.scaleY, tile.scaleZ);
		GL11.glTranslatef(tile.translateX, tile.translateY, tile.translateZ);
		((IModel)this.model).render();
		GL11.glPopMatrix();
	}
}
