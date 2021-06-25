package com.ferullogaming.craftingdead.client.render;

import com.ferullogaming.craftingdead.client.model.ModelSupplyDrop;
import com.ferullogaming.craftingdead.entity.EntitySupplyDrop;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderSupplyDrop extends Render {
   private ModelSupplyDrop mainModel = new ModelSupplyDrop();

   public void renderEntityCoprse(EntitySupplyDrop par1SupplyDrop, double par2, double par3, double par4, float f, float f1) {
      super.renderManager.renderEngine.bindTexture(this.getEntityTexture(par1SupplyDrop));
      GL11.glPushMatrix();
      GL11.glTranslatef((float)par2, (float)par3 + 1.5F, (float)par4);
      double scale = 0.1D;
      GL11.glScaled(scale, scale, scale);
      GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
      float par7 = 0.625F;
      this.mainModel.render(par1SupplyDrop, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.625F);
      GL11.glPopMatrix();
   }

   public void doRender(Entity entity, double d0, double d1, double d2, float f, float f1) {
      this.renderEntityCoprse((EntitySupplyDrop)entity, d0, d1, d2, f, f1);
   }

   protected ResourceLocation getEntityTexture(Entity entity) {
      return new ResourceLocation("craftingdead:textures/models/supplydrop.png");
   }
}
