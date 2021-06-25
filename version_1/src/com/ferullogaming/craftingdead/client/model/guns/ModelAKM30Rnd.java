package com.ferullogaming.craftingdead.client.model.guns;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelAKM30Rnd extends ModelBase {
   ModelRenderer Shape19;
   ModelRenderer Shape20;
   ModelRenderer Shape21;

   public ModelAKM30Rnd() {
      super.textureWidth = 128;
      super.textureHeight = 64;
      this.Shape19 = new ModelRenderer(this, 44, 31);
      this.Shape19.addBox(0.0F, 0.0F, 0.0F, 4, 4, 3);
      this.Shape19.setRotationPoint(-6.0F, 2.0F, 0.0F);
      this.Shape19.setTextureSize(128, 64);
      this.Shape19.mirror = true;
      this.setRotation(this.Shape19, 0.0F, 0.0F, -0.1745329F);
      this.Shape20 = new ModelRenderer(this, 59, 31);
      this.Shape20.addBox(0.0F, 0.0F, 0.0F, 4, 4, 3);
      this.Shape20.setRotationPoint(-5.3F, 5.9F, 0.0F);
      this.Shape20.setTextureSize(128, 64);
      this.Shape20.mirror = true;
      this.setRotation(this.Shape20, 0.0F, 0.0F, -0.3490659F);
      this.Shape21 = new ModelRenderer(this, 74, 31);
      this.Shape21.addBox(0.0F, 0.0F, 0.0F, 4, 4, 3);
      this.Shape21.setRotationPoint(-4.0F, 9.5F, 0.0F);
      this.Shape21.setTextureSize(128, 64);
      this.Shape21.mirror = true;
      this.setRotation(this.Shape21, 0.0F, 0.0F, -0.5235988F);
   }

   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      super.render(entity, f, f1, f2, f3, f4, f5);
      this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
      this.Shape19.render(f5);
      this.Shape20.render(f5);
      this.Shape21.render(f5);
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
