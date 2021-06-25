package by.fxg.craftingdead.client.model.guns;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelAKM extends ModelBase {
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
   ModelRenderer Shape17;
   ModelRenderer Shape18;
   ModelRenderer Shape19;
   ModelRenderer Shape20;
   ModelRenderer Shape21;
   ModelRenderer Shape22;
   ModelRenderer Shape23;

   public ModelAKM() {
      super.textureWidth = 128;
      super.textureHeight = 64;
      this.Shape1 = new ModelRenderer(this, 0, 54);
      this.Shape1.addBox(-10.0F, 0.0F, 0.0F, 10, 2, 3);
      this.Shape1.setRotationPoint(10.0F, 0.0F, 0.0F);
      this.Shape1.setTextureSize(128, 64);
      this.Shape1.mirror = true;
      this.setRotation(this.Shape1, 0.0F, 0.0F, -0.0349066F);
      this.Shape2 = new ModelRenderer(this, 25, 47);
      this.Shape2.addBox(0.0F, 0.0F, 0.0F, 6, 2, 3);
      this.Shape2.setRotationPoint(4.0F, -2.5F, 0.0F);
      this.Shape2.setTextureSize(128, 64);
      this.Shape2.mirror = true;
      this.setRotation(this.Shape2, 0.0F, 0.0F, 0.0F);
      this.Shape3 = new ModelRenderer(this, 44, 53);
      this.Shape3.addBox(0.0F, 0.0F, 0.0F, 14, 3, 3);
      this.Shape3.setRotationPoint(-14.0F, -1.0F, 0.0F);
      this.Shape3.setTextureSize(128, 64);
      this.Shape3.mirror = true;
      this.setRotation(this.Shape3, 0.0F, 0.0F, 0.0F);
      this.Shape4 = new ModelRenderer(this, 31, 53);
      this.Shape4.addBox(0.0F, 0.0F, 0.0F, 4, 4, 2);
      this.Shape4.setRotationPoint(0.0F, -3.0F, 0.5F);
      this.Shape4.setTextureSize(128, 64);
      this.Shape4.mirror = true;
      this.setRotation(this.Shape4, 0.0F, 0.0F, 0.0F);
      this.Shape5 = new ModelRenderer(this, 44, 48);
      this.Shape5.addBox(0.0F, 0.0F, 0.0F, 13, 2, 2);
      this.Shape5.setRotationPoint(-13.0F, -2.5F, 0.5F);
      this.Shape5.setTextureSize(128, 64);
      this.Shape5.mirror = true;
      this.setRotation(this.Shape5, 0.0F, 0.0F, 0.0F);
      this.Shape6 = new ModelRenderer(this, 79, 43);
      this.Shape6.addBox(0.0F, 0.0F, 0.0F, 1, 3, 3);
      this.Shape6.setRotationPoint(-15.0F, -1.0F, 0.0F);
      this.Shape6.setTextureSize(128, 64);
      this.Shape6.mirror = true;
      this.setRotation(this.Shape6, 0.0F, 0.0F, 0.0F);
      this.Shape7 = new ModelRenderer(this, 14, 46);
      this.Shape7.addBox(0.0F, 0.0F, 0.0F, 2, 4, 3);
      this.Shape7.setRotationPoint(9.0F, -2.0F, 0.0F);
      this.Shape7.setTextureSize(128, 64);
      this.Shape7.mirror = true;
      this.setRotation(this.Shape7, 0.0F, 0.0F, 0.0F);
      this.Shape8 = new ModelRenderer(this, 14, 36);
      this.Shape8.addBox(0.0F, 0.0F, 0.0F, 10, 1, 1);
      this.Shape8.setRotationPoint(11.0F, 0.0F, 1.0F);
      this.Shape8.setTextureSize(128, 64);
      this.Shape8.mirror = true;
      this.setRotation(this.Shape8, 0.0F, 0.0F, 0.0F);
      this.Shape9 = new ModelRenderer(this, 0, 34);
      this.Shape9.addBox(0.0F, 0.0F, 0.0F, 4, 1, 1);
      this.Shape9.setRotationPoint(11.0F, -1.5F, 1.0F);
      this.Shape9.setTextureSize(128, 64);
      this.Shape9.mirror = true;
      this.setRotation(this.Shape9, 0.0F, 0.0F, 0.0F);
      this.Shape10 = new ModelRenderer(this, 0, 36);
      this.Shape10.addBox(0.0F, 0.0F, 0.0F, 2, 1, 1);
      this.Shape10.setRotationPoint(15.0F, -1.5F, 1.0F);
      this.Shape10.setTextureSize(128, 64);
      this.Shape10.mirror = true;
      this.setRotation(this.Shape10, 0.0F, 0.0F, 0.9075712F);
      this.Shape11 = new ModelRenderer(this, 7, 39);
      this.Shape11.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1);
      this.Shape11.setRotationPoint(11.0F, -1.0F, 1.0F);
      this.Shape11.setTextureSize(128, 64);
      this.Shape11.mirror = true;
      this.setRotation(this.Shape11, 0.0F, 0.0F, 0.0F);
      this.Shape12 = new ModelRenderer(this, 43, 61);
      this.Shape12.addBox(0.0F, 0.0F, 0.0F, 16, 1, 2);
      this.Shape12.setRotationPoint(-14.0F, 1.466667F, 0.5F);
      this.Shape12.setTextureSize(128, 64);
      this.Shape12.mirror = true;
      this.setRotation(this.Shape12, 0.0F, 0.0F, 0.0F);
      this.Shape13 = new ModelRenderer(this, 79, 50);
      this.Shape13.addBox(0.0F, -1.0F, 0.0F, 3, 6, 3);
      this.Shape13.setRotationPoint(-13.0F, 2.0F, 0.0F);
      this.Shape13.setTextureSize(128, 64);
      this.Shape13.mirror = true;
      this.setRotation(this.Shape13, 0.0F, 0.0F, 0.2094395F);
      this.Shape14 = new ModelRenderer(this, 44, 43);
      this.Shape14.addBox(0.0F, 0.0F, 0.0F, 5, 1, 2);
      this.Shape14.setRotationPoint(4.0F, -3.0F, 0.5F);
      this.Shape14.setTextureSize(128, 64);
      this.Shape14.mirror = true;
      this.setRotation(this.Shape14, 0.0F, 0.0F, 0.0F);
      this.Shape15 = new ModelRenderer(this, 59, 43);
      this.Shape15.addBox(0.0F, 0.0F, 0.0F, 1, 1, 2);
      this.Shape15.setRotationPoint(-14.0F, -2.0F, 0.5F);
      this.Shape15.setTextureSize(128, 64);
      this.Shape15.mirror = true;
      this.setRotation(this.Shape15, 0.0F, 0.0F, 0.0F);
      this.Shape16 = new ModelRenderer(this, 92, 53);
      this.Shape16.addBox(-5.0F, 0.0F, 0.0F, 5, 3, 3);
      this.Shape16.setRotationPoint(-15.0F, -1.0F, 0.0F);
      this.Shape16.setTextureSize(128, 64);
      this.Shape16.mirror = true;
      this.setRotation(this.Shape16, 0.0F, 0.0F, -0.2443461F);
      this.Shape17 = new ModelRenderer(this, 99, 45);
      this.Shape17.addBox(-10.0F, -1.0F, 0.0F, 5, 4, 3);
      this.Shape17.setRotationPoint(-15.0F, -1.0F, 0.0F);
      this.Shape17.setTextureSize(128, 64);
      this.Shape17.mirror = true;
      this.setRotation(this.Shape17, 0.0F, 0.0F, -0.2443461F);
      this.Shape18 = new ModelRenderer(this, 0, 38);
      this.Shape18.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1);
      this.Shape18.setRotationPoint(19.5F, -2.0F, 1.0F);
      this.Shape18.setTextureSize(128, 64);
      this.Shape18.mirror = true;
      this.setRotation(this.Shape18, 0.0F, 0.0F, 0.0F);
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
      this.Shape22 = new ModelRenderer(this, 89, 60);
      this.Shape22.addBox(0.0F, 0.0F, 0.0F, 3, 1, 2);
      this.Shape22.setRotationPoint(-11.0F, 4.0F, 0.5F);
      this.Shape22.setTextureSize(128, 64);
      this.Shape22.mirror = true;
      this.setRotation(this.Shape22, 0.0F, 0.0F, 0.0F);
      this.Shape23 = new ModelRenderer(this, 81, 60);
      this.Shape23.addBox(0.0F, 0.0F, 0.0F, 1, 2, 2);
      this.Shape23.setRotationPoint(-8.0F, 2.0F, 0.5F);
      this.Shape23.setTextureSize(128, 64);
      this.Shape23.mirror = true;
      this.setRotation(this.Shape23, 0.0F, 0.0F, 0.0F);
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
      this.Shape16.render(f5);
      this.Shape17.render(f5);
      this.Shape18.render(f5);
      this.Shape22.render(f5);
      this.Shape23.render(f5);
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
