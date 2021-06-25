package by.fxg.craftingdead.client.model.guns;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelM9Clip extends ModelBase {
   ModelRenderer Shape15;

   public ModelM9Clip() {
      super.textureWidth = 128;
      super.textureHeight = 64;
      this.Shape15 = new ModelRenderer(this, 60, 44);
      this.Shape15.addBox(-1.75F, 1.5F, 0.0F, 2, 4, 1);
      this.Shape15.setRotationPoint(2.5F, 2.0F, 0.5F);
      this.Shape15.setTextureSize(128, 64);
      this.Shape15.mirror = true;
   }

   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      super.render(entity, f, f1, f2, f3, f4, f5);
      this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
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
