package by.fxg.craftingdead.client.model.guns;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelM9 extends ModelBase {
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

   public ModelM9() {
      super.textureWidth = 128;
      super.textureHeight = 64;
      this.Shape1 = new ModelRenderer(this, 50, 30);
      this.Shape1.addBox(0.0F, 0.0F, 0.0F, 6, 2, 2);
      this.Shape1.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.Shape1.setTextureSize(128, 64);
      this.Shape1.mirror = true;
      this.setRotation(this.Shape1, 0.0F, 0.0F, 0.0F);
      this.Shape2 = new ModelRenderer(this, 37, 30);
      this.Shape2.addBox(0.0F, 0.0F, 0.0F, 4, 1, 2);
      this.Shape2.setRotationPoint(6.0F, 0.0F, 0.0F);
      this.Shape2.setTextureSize(128, 64);
      this.Shape2.mirror = true;
      this.setRotation(this.Shape2, 0.0F, 0.0F, 0.0F);
      this.Shape3 = new ModelRenderer(this, 39, 34);
      this.Shape3.addBox(0.0F, 0.0F, 0.0F, 4, 1, 1);
      this.Shape3.setRotationPoint(6.0F, 1.0F, 0.5F);
      this.Shape3.setTextureSize(128, 64);
      this.Shape3.mirror = true;
      this.setRotation(this.Shape3, 0.0F, 0.0F, 0.0F);
      this.Shape4 = new ModelRenderer(this, 55, 27);
      this.Shape4.addBox(0.0F, 0.0F, 0.0F, 4, 1, 1);
      this.Shape4.setRotationPoint(0.5F, -0.5F, 0.5F);
      this.Shape4.setTextureSize(128, 64);
      this.Shape4.mirror = true;
      this.setRotation(this.Shape4, 0.0F, 0.0F, 0.0F);
      this.Shape5 = new ModelRenderer(this, 67, 31);
      this.Shape5.addBox(0.0F, 0.0F, 0.0F, 1, 1, 2);
      this.Shape5.setRotationPoint(-0.5F, 1.5F, 0.0F);
      this.Shape5.setTextureSize(128, 64);
      this.Shape5.mirror = true;
      this.setRotation(this.Shape5, 0.0F, 0.0F, 0.0F);
      this.Shape6 = new ModelRenderer(this, 58, 35);
      this.Shape6.addBox(-2.0F, 0.0F, 0.0F, 2, 5, 2);
      this.Shape6.setRotationPoint(2.5F, 2.0F, 0.0F);
      this.Shape6.setTextureSize(128, 64);
      this.Shape6.mirror = true;
      this.setRotation(this.Shape6, 0.0F, 0.0F, 0.122173F);
      this.Shape7 = new ModelRenderer(this, 67, 28);
      this.Shape7.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1);
      this.Shape7.setRotationPoint(-0.2F, -0.2F, 0.5F);
      this.Shape7.setTextureSize(128, 64);
      this.Shape7.mirror = true;
      this.setRotation(this.Shape7, 0.0F, 0.0F, 0.4712389F);
      this.Shape8 = new ModelRenderer(this, 42, 40);
      this.Shape8.addBox(0.0F, 0.0F, 0.0F, 2, 1, 2);
      this.Shape8.setRotationPoint(2.5F, 3.0F, 0.0F);
      this.Shape8.setTextureSize(128, 64);
      this.Shape8.mirror = true;
      this.setRotation(this.Shape8, 0.0F, 0.0F, 0.0F);
      this.Shape9 = new ModelRenderer(this, 35, 40);
      this.Shape9.addBox(0.0F, 0.0F, 0.0F, 1, 1, 2);
      this.Shape9.setRotationPoint(4.5F, 2.0F, 0.0F);
      this.Shape9.setTextureSize(128, 64);
      this.Shape9.mirror = true;
      this.setRotation(this.Shape9, 0.0F, 0.0F, 0.0F);
      this.Shape10 = new ModelRenderer(this, 32, 30);
      this.Shape10.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1);
      this.Shape10.setRotationPoint(9.5F, -0.3F, 0.5F);
      this.Shape10.setTextureSize(128, 64);
      this.Shape10.mirror = true;
      this.setRotation(this.Shape10, 0.0F, 0.0F, 0.0F);
      this.Shape11 = new ModelRenderer(this, 42, 27);
      this.Shape11.addBox(0.0F, 0.0F, 0.0F, 5, 1, 1);
      this.Shape11.setRotationPoint(4.0F, -0.3F, 0.5F);
      this.Shape11.setTextureSize(128, 64);
      this.Shape11.mirror = true;
      this.setRotation(this.Shape11, 0.0F, 0.0F, 0.0F);
      this.Shape12 = new ModelRenderer(this, 37, 27);
      this.Shape12.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1);
      this.Shape12.setRotationPoint(9.0F, -0.5F, 0.5F);
      this.Shape12.setTextureSize(128, 64);
      this.Shape12.mirror = true;
      this.setRotation(this.Shape12, 0.0F, 0.0F, 0.0F);
      this.Shape13 = new ModelRenderer(this, 51, 35);
      this.Shape13.addBox(-0.5F, 0.0F, 0.0F, 1, 5, 2);
      this.Shape13.setRotationPoint(2.5F, 2.0F, 0.0F);
      this.Shape13.setTextureSize(128, 64);
      this.Shape13.mirror = true;
      this.setRotation(this.Shape13, 0.0F, 0.0F, 0.122173F);
      this.Shape14 = new ModelRenderer(this, 46, 37);
      this.Shape14.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1);
      this.Shape14.setRotationPoint(3.0F, 1.5F, 0.5F);
      this.Shape14.setTextureSize(128, 64);
      this.Shape14.mirror = true;
      this.setRotation(this.Shape14, 0.0F, 0.0F, 0.0F);
      this.Shape16 = new ModelRenderer(this, 67, 35);
      this.Shape16.addBox(-1.75F, 0.0F, 0.0F, 2, 5, 1);
      this.Shape16.setRotationPoint(2.5F, 2.0F, 1.2F);
      this.Shape16.setTextureSize(128, 64);
      this.Shape16.mirror = true;
      this.setRotation(this.Shape16, 0.0F, 0.0F, 0.122173F);
      this.Shape17 = new ModelRenderer(this, 67, 35);
      this.Shape17.addBox(-1.75F, 0.0F, 0.0F, 2, 5, 1);
      this.Shape17.setRotationPoint(2.5F, 2.0F, -0.2F);
      this.Shape17.setTextureSize(128, 64);
      this.Shape17.mirror = true;
      this.setRotation(this.Shape17, 0.0F, 0.0F, 0.122173F);
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
      this.Shape16.render(f5);
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
