package com.fxg.decoration.model.block;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import org.lwjgl.opengl.GL11;

import com.fxg.decoration.model.IModel;

public class ModelBarrier extends ModelBase implements IModel {
    int x = 0;
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

    public ModelBarrier() {
        this.textureWidth = 512;
        this.textureHeight = 512;
        this.Shape1 = new ModelRenderer((ModelBase)this, 41, 91);
        this.Shape1.addBox(0.0f, 0.0f, 0.0f, 18, 1, 9);
        this.Shape1.setRotationPoint(-9.0f, -1.0f, -4.0f);
        this.Shape1.setTextureSize(64, 32);
        this.Shape1.mirror = true;
        this.setRotation(this.Shape1, 0.0f, 0.0f, 0.0f);
        this.Shape2 = new ModelRenderer((ModelBase)this, 10, 74);
        this.Shape2.addBox(0.0f, 0.0f, 0.0f, 4, 1, 9);
        this.Shape2.setRotationPoint(12.0f, -1.0f, -4.0f);
        this.Shape2.setTextureSize(64, 32);
        this.Shape2.mirror = true;
        this.setRotation(this.Shape2, 0.0f, 0.0f, 0.0f);
        this.Shape3 = new ModelRenderer((ModelBase)this, 45, 73);
        this.Shape3.addBox(0.0f, 0.0f, 0.0f, 4, 1, 9);
        this.Shape3.setRotationPoint(-16.0f, -1.0f, -4.0f);
        this.Shape3.setTextureSize(64, 32);
        this.Shape3.mirror = true;
        this.setRotation(this.Shape3, 0.0f, 0.0f, 0.0f);
        this.Shape4 = new ModelRenderer((ModelBase)this, 0, 73);
        this.Shape4.addBox(0.0f, 0.0f, 0.0f, 32, 2, 9);
        this.Shape4.setRotationPoint(-16.0f, -3.0f, -4.0f);
        this.Shape4.setTextureSize(64, 32);
        this.Shape4.mirror = true;
        this.setRotation(this.Shape4, 0.0f, 0.0f, 0.0f);
        this.Shape5 = new ModelRenderer((ModelBase)this, 0, 56);
        this.Shape5.addBox(0.0f, 0.0f, 0.0f, 32, 2, 5);
        this.Shape5.setRotationPoint(-16.0f, -3.0f, -4.0f);
        this.Shape5.setTextureSize(64, 32);
        this.Shape5.mirror = true;
        this.setRotation(this.Shape5, 1.169371f, 0.0f, 0.0f);
        this.Shape6 = new ModelRenderer((ModelBase)this, 0, 36);
        this.Shape6.addBox(0.0f, 0.0f, 0.0f, 32, 5, 5);
        this.Shape6.setRotationPoint(-16.0f, -8.0f, -2.0f);
        this.Shape6.setTextureSize(64, 32);
        this.Shape6.mirror = true;
        this.setRotation(this.Shape6, 0.0f, 0.0f, 0.0f);
        this.Shape7 = new ModelRenderer((ModelBase)this, 0, 19);
        this.Shape7.addBox(0.0f, 0.0f, 0.0f, 32, 2, 5);
        this.Shape7.setRotationPoint(-16.0f, -7.6f, 3.0f);
        this.Shape7.setTextureSize(64, 32);
        this.Shape7.mirror = true;
        this.setRotation(this.Shape7, -1.169371f, 0.0f, 0.0f);
        this.Shape8 = new ModelRenderer((ModelBase)this, 104, 18);
        this.Shape8.addBox(0.0f, 0.0f, -2.0f, 32, 9, 2);
        this.Shape8.setRotationPoint(-16.0f, -16.0f, 2.0f);
        this.Shape8.setTextureSize(64, 32);
        this.Shape8.mirror = true;
        this.setRotation(this.Shape8, 0.1396263f, 0.0f, 0.0f);
        this.Shape9 = new ModelRenderer((ModelBase)this, 104, 0);
        this.Shape9.addBox(0.0f, 0.0f, 0.0f, 32, 9, 2);
        this.Shape9.setRotationPoint(-16.0f, -16.0f, -1.0f);
        this.Shape9.setTextureSize(64, 32);
        this.Shape9.mirror = true;
        this.setRotation(this.Shape9, -0.1396263f, 0.0f, 0.0f);
        this.Shape10 = new ModelRenderer((ModelBase)this, 0, 0);
        this.Shape10.addBox(0.0f, 0.0f, 0.0f, 32, 8, 3);
        this.Shape10.setRotationPoint(-16.0f, -16.0f, -1.0f);
        this.Shape10.setTextureSize(64, 32);
        this.Shape10.mirror = true;
        this.setRotation(this.Shape10, 0.0f, 0.0f, 0.0f);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void setRotationAngles(Entity par7Entity, float par2, float par3, float par4, float par5, float par6, float par1) {
    }

	@Override
	public void render() {
        GL11.glRotatef((float)90.0f, (float)0.0f, (float)1.0f, (float)0.0f);
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
	}
}

