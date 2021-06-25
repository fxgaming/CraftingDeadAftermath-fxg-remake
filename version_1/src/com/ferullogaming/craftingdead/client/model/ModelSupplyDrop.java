package com.ferullogaming.craftingdead.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelSupplyDrop extends ModelBase {
   ModelRenderer Shape1;
   ModelRenderer Shape2;
   ModelRenderer Shape3;
   ModelRenderer Shape4;
   ModelRenderer Shape5;
   ModelRenderer Shape6;

   public ModelSupplyDrop() {
      super.textureWidth = 256;
      super.textureHeight = 256;
      this.Shape1 = new ModelRenderer(this, 0, 0);
      this.Shape1.addBox(0.0F, 0.0F, 0.0F, 32, 4, 32);
      this.Shape1.setRotationPoint(-16.0F, 20.0F, -16.0F);
      this.Shape1.setTextureSize(256, 256);
      this.Shape1.mirror = true;
      this.setRotation(this.Shape1, 0.0F, 0.0F, 0.0F);
      this.Shape2 = new ModelRenderer(this, 0, 38);
      this.Shape2.addBox(0.0F, 0.0F, 0.0F, 30, 18, 15);
      this.Shape2.setRotationPoint(-15.0F, 2.0F, 0.0F);
      this.Shape2.setTextureSize(256, 256);
      this.Shape2.mirror = true;
      this.setRotation(this.Shape2, 0.0F, 0.0F, 0.0F);
      this.Shape3 = new ModelRenderer(this, 0, 73);
      this.Shape3.addBox(0.0F, 0.0F, 0.0F, 14, 14, 14);
      this.Shape3.setRotationPoint(0.0F, 6.0F, -15.0F);
      this.Shape3.setTextureSize(256, 256);
      this.Shape3.mirror = true;
      this.setRotation(this.Shape3, 0.0F, 0.0F, 0.0F);
      this.Shape4 = new ModelRenderer(this, 0, 105);
      this.Shape4.addBox(0.0F, 0.0F, 0.0F, 11, 6, 6);
      this.Shape4.setRotationPoint(-13.0F, 14.0F, -15.0F);
      this.Shape4.setTextureSize(256, 256);
      this.Shape4.mirror = true;
      this.setRotation(this.Shape4, 0.0F, 0.0F, 0.0F);
      this.Shape5 = new ModelRenderer(this, 0, 119);
      this.Shape5.addBox(0.0F, 0.0F, 0.0F, 11, 6, 6);
      this.Shape5.setRotationPoint(-13.0F, 14.0F, -7.0F);
      this.Shape5.setTextureSize(256, 256);
      this.Shape5.mirror = true;
      this.setRotation(this.Shape5, 0.0F, 0.0F, 0.0F);
      this.Shape6 = new ModelRenderer(this, 0, 133);
      this.Shape6.addBox(0.0F, 0.0F, 0.0F, 40, 30, 40);
      this.Shape6.setRotationPoint(-20.0F, -50.0F, -20.0F);
      this.Shape6.setTextureSize(256, 256);
      this.Shape6.mirror = true;
      this.setRotation(this.Shape6, 0.0F, 0.0F, 0.0F);
   }

   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      super.render(entity, f, f1, f2, f3, f4, f5);
      this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
      this.Shape1.render(f5);
      this.Shape2.render(f5);
      this.Shape3.render(f5);
      this.Shape4.render(f5);
      this.Shape5.render(f5);
      if (entity.fallDistance > 0.0F && !entity.onGround) {
         this.Shape6.render(f5);
      }

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
