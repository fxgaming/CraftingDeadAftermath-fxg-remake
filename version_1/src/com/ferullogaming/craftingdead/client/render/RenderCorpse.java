package com.ferullogaming.craftingdead.client.render;

import com.ferullogaming.craftingdead.ModSettings;
import com.ferullogaming.craftingdead.entity.EntityCorpse;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderCorpse extends Render {
   private ModelBiped mainModel = new ModelBiped();

   public void doRenderCorpse(EntityCorpse entity, double d0, double d1, double d2, float f, float f1) {
      String var1 = entity.getUsernameKilled();
      ResourceLocation resourcelocation = AbstractClientPlayer.locationStevePng;
      this.bindTexture(resourcelocation);
      GL11.glPushMatrix();
      GL11.glTranslatef((float)d0, (float)d1 + 0.2F, (float)d2 - 0.4F);
      double scale = 0.1D;
      GL11.glScaled(scale, scale, scale);
      GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
      float par7 = 0.625F;
      int var11 = entity.getLifeStage();
      this.mainModel.setRotationAngles(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, entity);
      this.mainModel.bipedHead.render(par7);
      this.mainModel.bipedBody.render(par7);
      if (var11 < 4) {
         this.mainModel.bipedRightArm.render(par7);
      }

      if (var11 < 3) {
         this.mainModel.bipedLeftArm.render(par7);
      }

      if (var11 < 2) {
         this.mainModel.bipedRightLeg.render(par7);
      }

      if (var11 < 1) {
         this.mainModel.bipedLeftLeg.render(par7);
      }

      this.mainModel.bipedHeadwear.render(par7);
      GL11.glPopMatrix();
   }

   public void doRender(Entity entity, double d0, double d1, double d2, float f, float f1) {
      this.doRenderCorpse((EntityCorpse)entity, d0, d1, d2, f, f1);
   }

   protected ResourceLocation getEntityTexture(Entity entity) {
      return new ResourceLocation("craftingdead:textures/models/defaultcorpse.png");
   }
}
