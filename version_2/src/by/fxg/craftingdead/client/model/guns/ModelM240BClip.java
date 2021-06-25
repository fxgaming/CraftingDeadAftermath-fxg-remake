package by.fxg.craftingdead.client.model.guns;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelM240BClip extends ModelBase {
   ModelRenderer Shape22;
   ModelRenderer Shape23;

   public ModelM240BClip() {
      super.textureWidth = 128;
      super.textureHeight = 64;
      this.Shape22 = new ModelRenderer(this, 32, 44);
      this.Shape22.addBox(0.0F, 0.0F, 0.0F, 4, 5, 5);
      this.Shape22.setRotationPoint(8.0F, 1.0F, 3.0F);
      this.Shape22.setTextureSize(128, 64);
      this.Shape22.mirror = true;
      this.setRotation(this.Shape22, 0.0F, 0.0F, 0.0F);
      this.Shape23 = new ModelRenderer(this, 32, 55);
      this.Shape23.addBox(0.0F, 0.0F, 0.0F, 2, 1, 4);
      this.Shape23.setRotationPoint(9.0F, 0.5F, 3.0F);
      this.Shape23.setTextureSize(128, 64);
      this.Shape23.mirror = true;
      this.setRotation(this.Shape23, 0.0F, 0.0F, 0.0F);
   }

   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      super.render(entity, f, f1, f2, f3, f4, f5);
      this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
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
