package by.fxg.craftingdead.client.model.guns;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelSporter22Clip extends ModelBase {
   ModelRenderer Shape7;
   ModelRenderer Shape8;
   ModelRenderer Shape9;

   public ModelSporter22Clip() {
      super.textureWidth = 128;
      super.textureHeight = 64;
      this.Shape7 = new ModelRenderer(this, 49, 45);
      this.Shape7.addBox(0.0F, 0.0F, 0.0F, 2, 2, 2);
      this.Shape7.setRotationPoint(6.0F, 3.0F, 0.5F);
      this.Shape7.setTextureSize(128, 64);
      this.Shape7.mirror = true;
      this.setRotation(this.Shape7, 0.0F, 0.0F, -0.122173F);
      this.Shape8 = new ModelRenderer(this, 49, 50);
      this.Shape8.addBox(0.0F, 0.0F, 0.0F, 2, 2, 2);
      this.Shape8.setRotationPoint(6.25F, 4.95F, 0.5F);
      this.Shape8.setTextureSize(128, 64);
      this.Shape8.mirror = true;
      this.setRotation(this.Shape8, 0.0F, 0.0F, -0.3665191F);
      this.Shape9 = new ModelRenderer(this, 49, 55);
      this.Shape9.addBox(0.0F, 0.0F, 0.0F, 2, 2, 2);
      this.Shape9.setRotationPoint(6.95F, 6.8F, 0.5F);
      this.Shape9.setTextureSize(128, 64);
      this.Shape9.mirror = true;
      this.setRotation(this.Shape9, 0.0F, 0.0F, -0.6108652F);
   }

   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      super.render(entity, f, f1, f2, f3, f4, f5);
      this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
      this.Shape7.render(f5);
      this.Shape8.render(f5);
      this.Shape9.render(f5);
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
