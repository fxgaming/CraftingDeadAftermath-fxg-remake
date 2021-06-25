package by.fxg.craftingdead.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelBaseCenter extends ModelBase {
   ModelRenderer Shape1;
   ModelRenderer Shape2;
   ModelRenderer Shape3;
   ModelRenderer Shape4;
   ModelRenderer Shape5;
   ModelRenderer Shape6;
   ModelRenderer Shape7;

   public ModelBaseCenter() {
      super.textureWidth = 128;
      super.textureHeight = 64;
      this.Shape1 = new ModelRenderer(this, 0, 40);
      this.Shape1.addBox(0.0F, 0.0F, 0.0F, 16, 2, 16);
      this.Shape1.setRotationPoint(-8.0F, 22.0F, -8.0F);
      this.Shape1.setTextureSize(128, 64);
      this.Shape1.mirror = true;
      this.setRotation(this.Shape1, 0.0F, 0.0F, 0.0F);
      this.Shape2 = new ModelRenderer(this, 0, 21);
      this.Shape2.addBox(0.0F, 0.0F, 0.0F, 8, 10, 8);
      this.Shape2.setRotationPoint(-4.0F, 12.0F, -4.0F);
      this.Shape2.setTextureSize(128, 64);
      this.Shape2.mirror = true;
      this.setRotation(this.Shape2, 0.0F, 0.0F, 0.0F);
      this.Shape3 = new ModelRenderer(this, 0, 0);
      this.Shape3.addBox(0.0F, 0.0F, 0.0F, 16, 4, 16);
      this.Shape3.setRotationPoint(-8.0F, 8.0F, -8.0F);
      this.Shape3.setTextureSize(128, 64);
      this.Shape3.mirror = true;
      this.setRotation(this.Shape3, 0.0F, 0.0F, 0.0F);
      this.Shape4 = new ModelRenderer(this, 33, 21);
      this.Shape4.addBox(0.0F, 0.0F, 0.0F, 1, 10, 1);
      this.Shape4.setRotationPoint(7.0F, 12.0F, 7.0F);
      this.Shape4.setTextureSize(128, 64);
      this.Shape4.mirror = true;
      this.setRotation(this.Shape4, 0.0F, 0.0F, 0.0F);
      this.Shape5 = new ModelRenderer(this, 33, 21);
      this.Shape5.addBox(0.0F, 0.0F, 0.0F, 1, 10, 1);
      this.Shape5.setRotationPoint(7.0F, 12.0F, -8.0F);
      this.Shape5.setTextureSize(128, 64);
      this.Shape5.mirror = true;
      this.setRotation(this.Shape5, 0.0F, 0.0F, 0.0F);
      this.Shape6 = new ModelRenderer(this, 33, 21);
      this.Shape6.addBox(0.0F, 0.0F, 0.0F, 1, 10, 1);
      this.Shape6.setRotationPoint(-8.0F, 12.0F, 7.0F);
      this.Shape6.setTextureSize(128, 64);
      this.Shape6.mirror = true;
      this.setRotation(this.Shape6, 0.0F, 0.0F, 0.0F);
      this.Shape7 = new ModelRenderer(this, 33, 21);
      this.Shape7.addBox(0.0F, 0.0F, 0.0F, 1, 10, 1);
      this.Shape7.setRotationPoint(-8.0F, 12.0F, -8.0F);
      this.Shape7.setTextureSize(128, 64);
      this.Shape7.mirror = true;
      this.setRotation(this.Shape7, 0.0F, 0.0F, 0.0F);
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
