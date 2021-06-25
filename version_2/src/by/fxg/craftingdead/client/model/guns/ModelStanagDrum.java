package by.fxg.craftingdead.client.model.guns;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelStanagDrum extends ModelBase {
   ModelRenderer Shape1;
   ModelRenderer Shape2;
   ModelRenderer Shape3;
   ModelRenderer Shape4;
   ModelRenderer Shape5;
   ModelRenderer Shape6;
   ModelRenderer Shape7;
   ModelRenderer Shape8;
   ModelRenderer Shape9;

   public ModelStanagDrum() {
      super.textureWidth = 64;
      super.textureHeight = 32;
      this.Shape1 = new ModelRenderer(this, 27, 0);
      this.Shape1.addBox(0.0F, 0.0F, 0.0F, 3, 3, 4);
      this.Shape1.setRotationPoint(0.0F, 0.0F, 0.5F);
      this.Shape1.setTextureSize(64, 32);
      this.Shape1.mirror = true;
      this.setRotation(this.Shape1, 0.0F, 0.0F, 0.0F);
      this.Shape2 = new ModelRenderer(this, 25, 8);
      this.Shape2.addBox(0.0F, 0.0F, 0.0F, 4, 9, 5);
      this.Shape2.setRotationPoint(-0.5F, 3.0F, 0.0F);
      this.Shape2.setTextureSize(64, 32);
      this.Shape2.mirror = true;
      this.setRotation(this.Shape2, 0.0F, 0.0F, 0.0F);
      this.Shape3 = new ModelRenderer(this, 8, 10);
      this.Shape3.addBox(0.0F, 0.0F, 0.0F, 3, 4, 5);
      this.Shape3.setRotationPoint(-3.0F, 5.5F, 0.0F);
      this.Shape3.setTextureSize(64, 32);
      this.Shape3.mirror = true;
      this.setRotation(this.Shape3, 0.0F, 0.0F, 0.0F);
      this.Shape4 = new ModelRenderer(this, 27, 23);
      this.Shape4.addBox(0.0F, 0.0F, 0.0F, 2, 2, 5);
      this.Shape4.setRotationPoint(3.0F, 4.0F, 0.0F);
      this.Shape4.setTextureSize(64, 32);
      this.Shape4.mirror = true;
      this.setRotation(this.Shape4, 0.0F, 0.0F, 0.0F);
      this.Shape5 = new ModelRenderer(this, 27, 23);
      this.Shape5.addBox(0.0F, 0.0F, 0.0F, 2, 2, 5);
      this.Shape5.setRotationPoint(-2.0F, 4.0F, 0.0F);
      this.Shape5.setTextureSize(64, 32);
      this.Shape5.mirror = true;
      this.setRotation(this.Shape5, 0.0F, 0.0F, 0.0F);
      this.Shape6 = new ModelRenderer(this, 27, 23);
      this.Shape6.addBox(0.0F, 0.0F, 0.0F, 2, 2, 5);
      this.Shape6.setRotationPoint(3.0F, 9.0F, 0.0F);
      this.Shape6.setTextureSize(64, 32);
      this.Shape6.mirror = true;
      this.setRotation(this.Shape6, 0.0F, 0.0F, 0.0F);
      this.Shape7 = new ModelRenderer(this, 27, 23);
      this.Shape7.addBox(0.0F, 0.0F, 0.0F, 2, 2, 5);
      this.Shape7.setRotationPoint(-2.0F, 9.0F, 0.0F);
      this.Shape7.setTextureSize(64, 32);
      this.Shape7.mirror = true;
      this.setRotation(this.Shape7, 0.0F, 0.0F, 0.0F);
      this.Shape8 = new ModelRenderer(this, 0, 0);
      this.Shape8.addBox(0.0F, 0.0F, 0.0F, 6, 6, 1);
      this.Shape8.setRotationPoint(-1.5F, 4.5F, 4.2F);
      this.Shape8.setTextureSize(64, 32);
      this.Shape8.mirror = true;
      this.setRotation(this.Shape8, 0.0F, 0.0F, 0.0F);
      this.Shape9 = new ModelRenderer(this, 44, 10);
      this.Shape9.addBox(0.0F, 0.0F, 0.0F, 3, 4, 5);
      this.Shape9.setRotationPoint(3.0F, 5.5F, 0.0F);
      this.Shape9.setTextureSize(64, 32);
      this.Shape9.mirror = true;
      this.setRotation(this.Shape9, 0.0F, 0.0F, 0.0F);
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
