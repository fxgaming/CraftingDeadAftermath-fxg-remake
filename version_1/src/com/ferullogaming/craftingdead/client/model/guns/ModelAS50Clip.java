package com.ferullogaming.craftingdead.client.model.guns;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelAS50Clip extends ModelBase {
   ModelRenderer Shape17;

   public ModelAS50Clip() {
      super.textureWidth = 128;
      super.textureHeight = 64;
      this.Shape17 = new ModelRenderer(this, 45, 41);
      this.Shape17.addBox(-4.0F, 0.0F, 0.0F, 4, 3, 1);
      this.Shape17.setRotationPoint(9.5F, 3.0F, 0.5F);
      this.Shape17.setTextureSize(128, 64);
      this.Shape17.mirror = true;
   }

   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      super.render(entity, f, f1, f2, f3, f4, f5);
      this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
      this.Shape17.render(f5);
   }

   private void setRotation(ModelRenderer model, float x, float y, float z) {
      model.rotateAngleX = x;
      model.rotateAngleY = y;
      model.rotateAngleZ = z;
   }

   public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
      super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
   }
}
