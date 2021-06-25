package com.ferullogaming.craftingdead.client.model.guns;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelMAC10Clip extends ModelBase {
   ModelRenderer Shape3;

   public ModelMAC10Clip() {
      super.textureWidth = 128;
      super.textureHeight = 64;
      this.Shape3 = new ModelRenderer(this, 55, 45);
      this.Shape3.addBox(0.0F, 0.0F, 0.0F, 2, 6, 1);
      this.Shape3.setRotationPoint(4.0F, 8.0F, 1.0F);
      this.Shape3.setTextureSize(128, 64);
      this.Shape3.mirror = true;
      this.setRotation(this.Shape3, 0.0F, 0.0F, 0.0F);
   }

   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      super.render(entity, f, f1, f2, f3, f4, f5);
      this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
      this.Shape3.render(f5);
   }

   private void setRotation(ModelRenderer model, float x, float y, float z) {
      model.rotateAngleX = x;
      model.rotateAngleY = y;
      model.rotateAngleZ = z;
   }

   public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity ent) {
      super.setRotationAngles(f, f1, f2, f3, f4, f5, ent);
   }
}
