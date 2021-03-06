package by.fxg.craftingdead.client.model.guns;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import org.lwjgl.opengl.GL11;

public class ModelAttachmentMuzzleBrake extends ModelBase {
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

   public ModelAttachmentMuzzleBrake() {
      super.textureWidth = 64;
      super.textureHeight = 32;

      Shape1 = new ModelRenderer(this, 0, 6);
      Shape1.addBox(0F, 0F, 0F, 4, 3, 3);
      Shape1.setRotationPoint(0F, 0F, 0F);
      Shape1.setTextureSize(64, 32);
      Shape1.mirror = true;
      setRotation(Shape1, 0F, 0F, 0F);
      Shape2 = new ModelRenderer(this, 0, 0);
      Shape2.addBox(0F, 0F, 0F, 9, 1, 1);
      Shape2.setRotationPoint(5F, 2F, -0.5F);
      Shape2.setTextureSize(64, 32);
      Shape2.mirror = true;
      setRotation(Shape2, 0F, 0F, 0F);
      Shape3 = new ModelRenderer(this, 0, 0);
      Shape3.addBox(0F, 0F, 0F, 9, 1, 1);
      Shape3.setRotationPoint(5F, 2F, 2.5F);
      Shape3.setTextureSize(64, 32);
      Shape3.mirror = true;
      setRotation(Shape3, 0F, 0F, 0F);
      Shape4 = new ModelRenderer(this, 0, 0);
      Shape4.addBox(0F, 0F, 0F, 9, 1, 1);
      Shape4.setRotationPoint(5F, 2F, 1F);
      Shape4.setTextureSize(64, 32);
      Shape4.mirror = true;
      setRotation(Shape4, 0F, 0F, 0F);
      Shape5 = new ModelRenderer(this, 0, 0);
      Shape5.addBox(0F, 0F, 0F, 9, 1, 1);
      Shape5.setRotationPoint(5F, 0F, -0.5F);
      Shape5.setTextureSize(64, 32);
      Shape5.mirror = true;
      setRotation(Shape5, 0F, 0F, 0F);
      Shape6 = new ModelRenderer(this, 0, 0);
      Shape6.addBox(0F, 0F, 0F, 9, 1, 1);
      Shape6.setRotationPoint(5F, 0F, 2.5F);
      Shape6.setTextureSize(64, 32);
      Shape6.mirror = true;
      setRotation(Shape6, 0F, 0F, 0F);
      Shape7 = new ModelRenderer(this, 0, 0);
      Shape7.addBox(0F, 0F, 0F, 9, 1, 1);
      Shape7.setRotationPoint(5F, 0F, 1F);
      Shape7.setTextureSize(64, 32);
      Shape7.mirror = true;
      setRotation(Shape7, 0F, 0F, 0F);
      Shape8 = new ModelRenderer(this, 0, 0);
      Shape8.addBox(0F, 0F, 0F, 1, 3, 4);
      Shape8.setRotationPoint(4F, 0F, -0.5F);
      Shape8.setTextureSize(64, 32);
      Shape8.mirror = true;
      setRotation(Shape8, 0F, 0F, 0F);
      Shape9 = new ModelRenderer(this, 0, 12);
      Shape9.addBox(0F, 0F, 0F, 1, 3, 4);
      Shape9.setRotationPoint(6.5F, 0F, -0.5F);
      Shape9.setTextureSize(64, 32);
      Shape9.mirror = true;
      setRotation(Shape9, 0F, 0F, 0F);
      Shape10 = new ModelRenderer(this, 0, 12);
      Shape10.addBox(0F, 0F, 0F, 1, 3, 4);
      Shape10.setRotationPoint(9.5F, 0F, -0.5F);
      Shape10.setTextureSize(64, 32);
      Shape10.mirror = true;
      setRotation(Shape10, 0F, 0F, 0F);
      Shape11 = new ModelRenderer(this, 0, 12);
      Shape11.addBox(0F, 0F, 0F, 1, 1, 4);
      Shape11.setRotationPoint(13F, 0F, -0.5F);
      Shape11.setTextureSize(64, 32);
      Shape11.mirror = true;
      setRotation(Shape11, 0F, 0F, 0F);
      Shape12 = new ModelRenderer(this, 0, 12);
      Shape12.addBox(0F, 0F, 0F, 1, 1, 4);
      Shape12.setRotationPoint(13F, 2F, -0.5F);
      Shape12.setTextureSize(64, 32);
      Shape12.mirror = true;
      setRotation(Shape12, 0F, 0F, 0F);
      Shape13 = new ModelRenderer(this, 0, 12);
      Shape13.addBox(0F, 0F, 0F, 1, 3, 1);
      Shape13.setRotationPoint(13F, 0F, -0.5F);
      Shape13.setTextureSize(64, 32);
      Shape13.mirror = true;
      setRotation(Shape13, 0F, 0F, 0F);
      Shape14 = new ModelRenderer(this, 0, 12);
      Shape14.addBox(0F, 0F, 0F, 1, 3, 1);
      Shape14.setRotationPoint(13F, 0F, 2.5F);
      Shape14.setTextureSize(64, 32);
      Shape14.mirror = true;
      setRotation(Shape14, 0F, 0F, 0F);
   }

   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      super.render(entity, f, f1, f2, f3, f4, f5);
      double scale = 0.7D;
      //GL11.glScaled(scale, scale, scale);
      //GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
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
