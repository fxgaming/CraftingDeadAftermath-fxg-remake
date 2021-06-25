package com.ferullogaming.craftingdead.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelCrate extends ModelBase {
   ModelRenderer Shape1;
   ModelRenderer Shape2;
   ModelRenderer Shape21;
   ModelRenderer Shape3;
   ModelRenderer Shape4;
   ModelRenderer Shape5;
   ModelRenderer Shape51;
   ModelRenderer Shape6;

   public ModelCrate() {
      super.textureWidth = 128;
      super.textureHeight = 64;
      this.Shape1 = new ModelRenderer(this, 0, 0);
      this.Shape1.addBox(0.0F, 0.0F, 0.0F, 12, 7, 8);
      this.Shape1.setRotationPoint(-6.0F, 0.0F, -4.0F);
      this.Shape1.setTextureSize(128, 64);
      this.Shape1.mirror = true;
      this.setRotation(this.Shape1, 0.0F, 0.0F, 0.0F);
      this.Shape2 = new ModelRenderer(this, 7, 17);
      this.Shape2.addBox(0.0F, 0.0F, 0.0F, 2, 7, 1);
      this.Shape2.setRotationPoint(3.0F, 0.0F, -4.2F);
      this.Shape2.setTextureSize(128, 64);
      this.Shape2.mirror = true;
      this.setRotation(this.Shape2, 0.0F, 0.0F, 0.0F);
      this.Shape21 = new ModelRenderer(this, 0, 17);
      this.Shape21.addBox(0.0F, 0.0F, 0.0F, 2, 7, 1);
      this.Shape21.setRotationPoint(-5.0F, 0.0F, -4.2F);
      this.Shape21.setTextureSize(128, 64);
      this.Shape21.mirror = true;
      this.setRotation(this.Shape21, 0.0F, 0.0F, 0.0F);
      this.Shape3 = new ModelRenderer(this, 41, 0);
      this.Shape3.addBox(0.0F, 0.0F, 0.0F, 11, 1, 7);
      this.Shape3.setRotationPoint(-5.5F, -0.2F, -3.533333F);
      this.Shape3.setTextureSize(128, 64);
      this.Shape3.mirror = true;
      this.setRotation(this.Shape3, 0.0F, 0.0F, 0.0F);
      this.Shape4 = new ModelRenderer(this, 14, 17);
      this.Shape4.addBox(0.0F, 0.0F, 0.0F, 12, 1, 1);
      this.Shape4.setRotationPoint(-6.0F, 0.5F, -4.2F);
      this.Shape4.setTextureSize(128, 64);
      this.Shape4.mirror = true;
      this.setRotation(this.Shape4, 0.0F, 0.0F, 0.0F);
      this.Shape5 = new ModelRenderer(this, 0, 27);
      this.Shape5.addBox(0.0F, 0.0F, 0.0F, 1, 1, 8);
      this.Shape5.setRotationPoint(5.2F, 0.5F, -4.0F);
      this.Shape5.setTextureSize(128, 64);
      this.Shape5.mirror = true;
      this.setRotation(this.Shape5, 0.0F, 0.0F, 0.0F);
      this.Shape51 = new ModelRenderer(this, 0, 27);
      this.Shape51.addBox(0.0F, 0.0F, 0.0F, 1, 1, 8);
      this.Shape51.setRotationPoint(-6.2F, 0.5F, -4.0F);
      this.Shape51.setTextureSize(128, 64);
      this.Shape51.mirror = true;
      this.setRotation(this.Shape51, 0.0F, 0.0F, 0.0F);
      this.Shape6 = new ModelRenderer(this, 19, 27);
      this.Shape6.addBox(0.0F, 0.0F, 0.0F, 12, 1, 1);
      this.Shape6.setRotationPoint(-6.0F, 0.5F, 3.2F);
      this.Shape6.setTextureSize(128, 64);
      this.Shape6.mirror = true;
      this.setRotation(this.Shape6, 0.0F, 0.0F, 0.0F);
   }

   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      super.render(entity, f, f1, f2, f3, f4, f5);
      this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
      this.Shape1.render(f5);
      this.Shape2.render(f5);
      this.Shape21.render(f5);
      this.Shape3.render(f5);
      this.Shape4.render(f5);
      this.Shape5.render(f5);
      this.Shape51.render(f5);
      this.Shape6.render(f5);
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
