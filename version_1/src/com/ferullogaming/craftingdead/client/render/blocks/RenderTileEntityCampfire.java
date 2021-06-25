package com.ferullogaming.craftingdead.client.render.blocks;

import com.ferullogaming.craftingdead.block.TileEntityCampfire;
import com.ferullogaming.craftingdead.client.model.ModelCampfire;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderTileEntityCampfire extends TileEntitySpecialRenderer {
   private ModelBase model = new ModelCampfire();

   public void renderTileEntityCampfire(TileEntityCampfire tile, double d, double d1, double d2, float f) {
      this.bindTexture(new ResourceLocation("craftingdead:textures/models/campfire.png"));
      GL11.glPushMatrix();
      GL11.glTranslatef((float)d + 0.5F, (float)d1 + 1.5F, (float)d2 + 0.5F);
      GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
      GL11.glScalef(1.0F, -1.0F, -1.0F);
      this.model.render((Entity)null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
      GL11.glPopMatrix();
   }

   public void renderTileEntityAt(TileEntity tileentity, double d, double d1, double d2, float f) {
      this.renderTileEntityCampfire((TileEntityCampfire)tileentity, d, d1, d2, f);
   }
}
