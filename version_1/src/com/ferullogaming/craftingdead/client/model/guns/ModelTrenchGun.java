package com.ferullogaming.craftingdead.client.model.guns;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelTrenchGun extends ModelBase {
   ModelRenderer Shape1;
   ModelRenderer Shape2;
   ModelRenderer Shape3;
   ModelRenderer Shape4;
   ModelRenderer Shape5;
   ModelRenderer Shape6;
   ModelRenderer Shape7;
   ModelRenderer Shape8;
   ModelRenderer Shape9;
   ModelRenderer Shape10;
   ModelRenderer Shape11;
   ModelRenderer Shape12;
   ModelRenderer Shape13;
   ModelRenderer Shape14;
   ModelRenderer Shape15;
   ModelRenderer Shape16;

   public ModelTrenchGun() {
      super.textureWidth = 128;
      super.textureHeight = 64;
      this.Shape1 = new ModelRenderer(this, 1, 30);
      this.Shape1.addBox(0.0F, 0.0F, 0.0F, 28, 2, 2);
      this.Shape1.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.Shape1.setTextureSize(128, 64);
      this.Shape1.mirror = true;
      this.setRotation(this.Shape1, 0.0F, 0.0F, 0.0F);
      this.Shape2 = new ModelRenderer(this, 19, 38);
      this.Shape2.addBox(0.0F, 0.0F, 0.0F, 19, 2, 2);
      this.Shape2.setRotationPoint(0.0F, 3.0F, 0.0F);
      this.Shape2.setTextureSize(128, 64);
      this.Shape2.mirror = true;
      this.setRotation(this.Shape2, 0.0F, 0.0F, 0.0F);
      this.Shape3 = new ModelRenderer(this, 17, 35);
      this.Shape3.addBox(0.0F, 0.0F, 0.0F, 21, 1, 1);
      this.Shape3.setRotationPoint(0.0F, 2.0F, 0.5F);
      this.Shape3.setTextureSize(128, 64);
      this.Shape3.mirror = true;
      this.setRotation(this.Shape3, 0.0F, 0.0F, 0.0F);
      this.Shape4 = new ModelRenderer(this, 62, 30);
      this.Shape4.addBox(0.0F, 0.0F, 0.0F, 9, 5, 2);
      this.Shape4.setRotationPoint(-9.0F, 0.0F, 0.0F);
      this.Shape4.setTextureSize(128, 64);
      this.Shape4.mirror = true;
      this.setRotation(this.Shape4, 0.0F, 0.0F, 0.0F);
      this.Shape5 = new ModelRenderer(this, 85, 30);
      this.Shape5.addBox(-8.0F, 0.0F, 0.0F, 8, 3, 2);
      this.Shape5.setRotationPoint(-9.0F, 0.0F, 0.0F);
      this.Shape5.setTextureSize(128, 64);
      this.Shape5.mirror = true;
      this.setRotation(this.Shape5, 0.0F, 0.0F, -0.4537856F);
      this.Shape6 = new ModelRenderer(this, 19, 43);
      this.Shape6.addBox(0.0F, 0.0F, 0.0F, 9, 3, 3);
      this.Shape6.setRotationPoint(4.0F, 2.5F, -0.5F);
      this.Shape6.setTextureSize(128, 64);
      this.Shape6.mirror = true;
      this.setRotation(this.Shape6, 0.0F, 0.0F, 0.0F);
      this.Shape7 = new ModelRenderer(this, 62, 27);
      this.Shape7.addBox(0.0F, 0.0F, 0.0F, 10, 1, 1);
      this.Shape7.setRotationPoint(-8.0F, -0.5F, 0.5F);
      this.Shape7.setTextureSize(128, 64);
      this.Shape7.mirror = true;
      this.setRotation(this.Shape7, 0.0F, 0.0F, 0.0F);
      this.Shape8 = new ModelRenderer(this, 85, 36);
      this.Shape8.addBox(-7.0F, 0.0F, 0.0F, 7, 3, 2);
      this.Shape8.setRotationPoint(-9.0F, 2.0F, 0.0F);
      this.Shape8.setTextureSize(128, 64);
      this.Shape8.mirror = true;
      this.setRotation(this.Shape8, 0.0F, 0.0F, -0.296706F);
      this.Shape9 = new ModelRenderer(this, 104, 36);
      this.Shape9.addBox(0.0F, 0.0F, 0.0F, 10, 4, 2);
      this.Shape9.setRotationPoint(-23.0F, 2.0F, 0.0F);
      this.Shape9.setTextureSize(128, 64);
      this.Shape9.mirror = true;
      this.setRotation(this.Shape9, 0.0F, 0.0F, 0.0F);
      this.Shape10 = new ModelRenderer(this, 104, 43);
      this.Shape10.addBox(0.0F, 0.0F, 0.0F, 9, 2, 2);
      this.Shape10.setRotationPoint(-23.0F, 6.0F, 0.0F);
      this.Shape10.setTextureSize(128, 64);
      this.Shape10.mirror = true;
      this.setRotation(this.Shape10, 0.0F, 0.0F, -0.0698132F);
      this.Shape11 = new ModelRenderer(this, 76, 38);
      this.Shape11.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1);
      this.Shape11.setRotationPoint(-10.0F, 5.0F, 0.5F);
      this.Shape11.setTextureSize(128, 64);
      this.Shape11.mirror = true;
      this.setRotation(this.Shape11, 0.0F, 0.0F, 0.0F);
      this.Shape12 = new ModelRenderer(this, 69, 38);
      this.Shape12.addBox(0.0F, 0.0F, 0.0F, 2, 1, 1);
      this.Shape12.setRotationPoint(-9.0F, 6.0F, 0.5F);
      this.Shape12.setTextureSize(128, 64);
      this.Shape12.mirror = true;
      this.setRotation(this.Shape12, 0.0F, 0.0F, 0.0F);
      this.Shape13 = new ModelRenderer(this, 64, 38);
      this.Shape13.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1);
      this.Shape13.setRotationPoint(-7.0F, 5.0F, 0.5F);
      this.Shape13.setTextureSize(128, 64);
      this.Shape13.mirror = true;
      this.setRotation(this.Shape13, 0.0F, 0.0F, 0.0F);
      this.Shape14 = new ModelRenderer(this, 1, 35);
      this.Shape14.addBox(0.0F, 0.0F, 0.0F, 3, 1, 1);
      this.Shape14.setRotationPoint(24.0F, 2.0F, 0.5F);
      this.Shape14.setTextureSize(128, 64);
      this.Shape14.mirror = true;
      this.setRotation(this.Shape14, 0.0F, 0.0F, 0.0F);
      this.Shape15 = new ModelRenderer(this, 1, 27);
      this.Shape15.addBox(0.0F, 0.0F, 0.0F, 6, 1, 1);
      this.Shape15.setRotationPoint(21.0F, -0.5F, 0.5F);
      this.Shape15.setTextureSize(128, 64);
      this.Shape15.mirror = true;
      this.setRotation(this.Shape15, 0.0F, 0.0F, 0.0F);
      this.Shape16 = new ModelRenderer(this, 1, 24);
      this.Shape16.addBox(0.0F, 0.0F, 0.0F, 3, 1, 1);
      this.Shape16.setRotationPoint(-2.0F, 3.9F, 0.5F);
      this.Shape16.setTextureSize(128, 64);
      this.Shape16.mirror = true;
      this.setRotation(this.Shape16, 0.0F, 0.0F, 0.0F);
   }

   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      super.render(entity, f, f1, f2, f3, f4, f5);
      this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
      this.Shape1.render(f5);
      this.Shape2.render(f5);
      this.Shape3.render(f5);
      this.Shape4.render(f5);
      this.Shape5.render(f5);
      this.Shape6.render(f5);
      this.Shape7.render(f5);
      this.Shape8.render(f5);
      this.Shape9.render(f5);
      this.Shape10.render(f5);
      this.Shape11.render(f5);
      this.Shape12.render(f5);
      this.Shape13.render(f5);
      this.Shape14.render(f5);
      this.Shape15.render(f5);
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
