package com.fxg.decoration.model.block;

import com.fxg.decoration.model.IModel;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelMetroRailing2 extends ModelBase implements IModel {
    int x = 0;
    ModelRenderer Import_Box0;
    ModelRenderer Import_Box1;
    ModelRenderer Import_Box2;
    ModelRenderer Import_Box3;
    ModelRenderer Import_Box4;
    ModelRenderer Import_Box5;
    ModelRenderer Import_Box6;

    public ModelMetroRailing2() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.Import_Box0 = new ModelRenderer((ModelBase)this, 1, 1);
        this.Import_Box0.addBox(0.0f, 0.0f, 0.0f, 4, 1, 3);
        this.Import_Box0.setRotationPoint(3.0f, -1.0f, -1.5f);
        this.Import_Box0.setTextureSize(64, 32);
        this.Import_Box0.mirror = true;
        this.setRotation(this.Import_Box0, 0.0f, 0.0f, 0.0f);
        this.Import_Box1 = new ModelRenderer((ModelBase)this, 17, 1);
        this.Import_Box1.addBox(0.0f, 0.0f, 0.0f, 2, 14, 1);
        this.Import_Box1.setRotationPoint(4.0f, -15.0f, -0.5f);
        this.Import_Box1.setTextureSize(64, 32);
        this.Import_Box1.mirror = true;
        this.setRotation(this.Import_Box1, 0.0f, 0.0f, 0.0f);
        this.Import_Box2 = new ModelRenderer((ModelBase)this, 1, 17);
        this.Import_Box2.addBox(0.0f, 0.0f, 0.0f, 16, 1, 4);
        this.Import_Box2.setRotationPoint(-8.0f, -16.0f, -2.0f);
        this.Import_Box2.setTextureSize(64, 32);
        this.Import_Box2.mirror = true;
        this.setRotation(this.Import_Box2, 0.0f, 0.0f, 0.0f);
        this.Import_Box3 = new ModelRenderer((ModelBase)this, 25, 1);
        this.Import_Box3.addBox(0.0f, 0.0f, 0.0f, 4, 1, 3);
        this.Import_Box3.setRotationPoint(-2.0f, -1.0f, -1.5f);
        this.Import_Box3.setTextureSize(64, 32);
        this.Import_Box3.mirror = true;
        this.setRotation(this.Import_Box3, 0.0f, 0.0f, 0.0f);
        this.Import_Box4 = new ModelRenderer((ModelBase)this, 41, 1);
        this.Import_Box4.addBox(0.0f, 0.0f, 0.0f, 4, 1, 3);
        this.Import_Box4.setRotationPoint(-7.0f, -1.0f, -1.5f);
        this.Import_Box4.setTextureSize(64, 32);
        this.Import_Box4.mirror = true;
        this.setRotation(this.Import_Box4, 0.0f, 0.0f, 0.0f);
        this.Import_Box5 = new ModelRenderer((ModelBase)this, 57, 1);
        this.Import_Box5.addBox(0.0f, 0.0f, 0.0f, 2, 14, 1);
        this.Import_Box5.setRotationPoint(-1.0f, -15.0f, -0.5f);
        this.Import_Box5.setTextureSize(64, 32);
        this.Import_Box5.mirror = true;
        this.setRotation(this.Import_Box5, 0.0f, 0.0f, 0.0f);
        this.Import_Box6 = new ModelRenderer((ModelBase)this, 49, 9);
        this.Import_Box6.addBox(0.0f, 0.0f, 0.0f, 2, 14, 1);
        this.Import_Box6.setRotationPoint(-6.0f, -15.0f, -0.5f);
        this.Import_Box6.setTextureSize(64, 32);
        this.Import_Box6.mirror = true;
        this.setRotation(this.Import_Box6, 0.0f, 0.0f, 0.0f);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5) {
    }

	@Override
	public void render() {
        this.Import_Box0.render(f5);
        this.Import_Box1.render(f5);
        this.Import_Box2.render(f5);
        this.Import_Box3.render(f5);
        this.Import_Box4.render(f5);
        this.Import_Box5.render(f5);
        this.Import_Box6.render(f5);
	}
}

