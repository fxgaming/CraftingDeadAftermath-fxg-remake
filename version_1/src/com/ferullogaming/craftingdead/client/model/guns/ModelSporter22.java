package com.ferullogaming.craftingdead.client.model.guns;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelSporter22 extends ModelBase {
   ModelRenderer Shape1;
   ModelRenderer Shape2;
   ModelRenderer Shape3;
   ModelRenderer Shape5;
   ModelRenderer Shape6;
   ModelRenderer Shape10;
   ModelRenderer Shape11;
   ModelRenderer Shape14;
   ModelRenderer Shape16;
   ModelRenderer Shape17;
   ModelRenderer Shape18;
   ModelRenderer Shape19;
   ModelRenderer Shape20;
   ModelRenderer Shape21;

   public ModelSporter22() {
      super.textureWidth = 128;
      super.textureHeight = 64;
      this.Shape1 = new ModelRenderer(this, 49, 34);
      this.Shape1.addBox(0.0F, 0.0F, 0.0F, 9, 3, 2);
      this.Shape1.setRotationPoint(0.0F, 0.0F, 0.5F);
      this.Shape1.setTextureSize(128, 64);
      this.Shape1.mirror = true;
      this.setRotation(this.Shape1, 0.0F, 0.0F, 0.0F);
      this.Shape2 = new ModelRenderer(this, 10, 31);
      this.Shape2.addBox(0.0F, 0.0F, 0.0F, 22, 1, 1);
      this.Shape2.setRotationPoint(6.0F, -0.5F, 1.0F);
      this.Shape2.setTextureSize(128, 64);
      this.Shape2.mirror = true;
      this.setRotation(this.Shape2, 0.0F, 0.0F, 0.0F);
      this.Shape3 = new ModelRenderer(this, 57, 30);
      this.Shape3.addBox(0.0F, 0.0F, 0.0F, 5, 1, 2);
      this.Shape3.setRotationPoint(1.0F, -0.5F, 0.5F);
      this.Shape3.setTextureSize(128, 64);
      this.Shape3.mirror = true;
      this.setRotation(this.Shape3, 0.0F, 0.0F, 0.0F);
      this.Shape5 = new ModelRenderer(this, 72, 39);
      this.Shape5.addBox(0.0F, 0.0F, 0.0F, 2, 5, 2);
      this.Shape5.setRotationPoint(0.0F, 1.0F, 0.5F);
      this.Shape5.setTextureSize(128, 64);
      this.Shape5.mirror = true;
      this.setRotation(this.Shape5, 0.0F, 0.0F, 0.7504916F);
      this.Shape6 = new ModelRenderer(this, 81, 39);
      this.Shape6.addBox(-7.0F, 0.0F, 0.0F, 9, 4, 2);
      this.Shape6.setRotationPoint(-3.0F, 1.0F, 0.5F);
      this.Shape6.setTextureSize(128, 64);
      this.Shape6.mirror = true;
      this.setRotation(this.Shape6, 0.0F, 0.0F, 0.0F);
      this.Shape10 = new ModelRenderer(this, 100, 46);
      this.Shape10.addBox(0.0F, 0.0F, 0.0F, 1, 1, 2);
      this.Shape10.setRotationPoint(-10.0F, 5.0F, 0.5F);
      this.Shape10.setTextureSize(128, 64);
      this.Shape10.mirror = true;
      this.setRotation(this.Shape10, 0.0F, 0.0F, 0.0F);
      this.Shape11 = new ModelRenderer(this, 81, 46);
      this.Shape11.addBox(0.0F, -1.0F, 0.0F, 7, 1, 2);
      this.Shape11.setRotationPoint(-9.0F, 6.0F, 0.5F);
      this.Shape11.setTextureSize(128, 64);
      this.Shape11.mirror = true;
      this.setRotation(this.Shape11, 0.0F, 0.0F, -0.1570796F);
      this.Shape14 = new ModelRenderer(this, 62, 40);
      this.Shape14.addBox(0.0F, 0.0F, 0.0F, 2, 2, 1);
      this.Shape14.setRotationPoint(1.5F, 2.0F, 1.0F);
      this.Shape14.setTextureSize(128, 64);
      this.Shape14.mirror = true;
      this.setRotation(this.Shape14, 0.0F, 0.0F, 0.0F);
      this.Shape16 = new ModelRenderer(this, 72, 34);
      this.Shape16.addBox(-4.0F, 0.0F, 0.0F, 4, 2, 2);
      this.Shape16.setRotationPoint(1.0F, -0.5F, 0.5F);
      this.Shape16.setTextureSize(128, 64);
      this.Shape16.mirror = true;
      this.setRotation(this.Shape16, 0.0F, 0.0F, -0.4363323F);
      this.Shape17 = new ModelRenderer(this, 67, 27);
      this.Shape17.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1);
      this.Shape17.setRotationPoint(1.0F, -1.0F, 1.0F);
      this.Shape17.setTextureSize(128, 64);
      this.Shape17.mirror = true;
      this.setRotation(this.Shape17, 0.0F, 0.0F, 0.0F);
      this.Shape18 = new ModelRenderer(this, 57, 27);
      this.Shape18.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1);
      this.Shape18.setRotationPoint(5.0F, -1.0F, 1.0F);
      this.Shape18.setTextureSize(128, 64);
      this.Shape18.mirror = true;
      this.setRotation(this.Shape18, 0.0F, 0.0F, 0.0F);
      this.Shape19 = new ModelRenderer(this, 10, 28);
      this.Shape19.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1);
      this.Shape19.setRotationPoint(26.0F, -1.0F, 1.0F);
      this.Shape19.setTextureSize(128, 64);
      this.Shape19.mirror = true;
      this.setRotation(this.Shape19, 0.0F, 0.0F, 0.0F);
      this.Shape20 = new ModelRenderer(this, 30, 39);
      this.Shape20.addBox(0.0F, -1.0F, 0.0F, 7, 1, 2);
      this.Shape20.setRotationPoint(9.0F, 3.0F, 0.5F);
      this.Shape20.setTextureSize(128, 64);
      this.Shape20.mirror = true;
      this.setRotation(this.Shape20, 0.0F, 0.0F, -0.1396263F);
      this.Shape21 = new ModelRenderer(this, 30, 34);
      this.Shape21.addBox(0.0F, 0.0F, 0.0F, 7, 2, 2);
      this.Shape21.setRotationPoint(9.0F, 0.0F, 0.5F);
      this.Shape21.setTextureSize(128, 64);
      this.Shape21.mirror = true;
      this.setRotation(this.Shape21, 0.0F, 0.0F, 0.0F);
   }

   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      super.render(entity, f, f1, f2, f3, f4, f5);
      this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
      this.Shape1.render(f5);
      this.Shape2.render(f5);
      this.Shape3.render(f5);
      this.Shape5.render(f5);
      this.Shape6.render(f5);
      this.Shape10.render(f5);
      this.Shape11.render(f5);
      this.Shape14.render(f5);
      this.Shape16.render(f5);
      this.Shape17.render(f5);
      this.Shape18.render(f5);
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
