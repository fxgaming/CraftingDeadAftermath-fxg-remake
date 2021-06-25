package com.fxg.decoration.model.block;

import com.fxg.decoration.model.IModel;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelHazardLamp extends ModelBase implements IModel {
    int x = 0;
    ModelRenderer Box_0;
    ModelRenderer Box_1;
    ModelRenderer Box_2;
    ModelRenderer Box_3;
    ModelRenderer Box_4;
    ModelRenderer Box_5;

    public ModelHazardLamp() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.Box_0 = new ModelRenderer((ModelBase)this, 1, 1);
        this.Box_0.addBox(0.0f, 0.0f, 0.0f, 1, 1, 8);
        this.Box_0.setRotationPoint(4.0f, -1.0f, -4.0f);
        this.Box_0.setTextureSize(64, 32);
        this.Box_0.mirror = true;
        this.setRotation(this.Box_0, 0.0f, 0.0f, 0.0f);
        this.Box_1 = new ModelRenderer((ModelBase)this, 17, 1);
        this.Box_1.addBox(0.0f, 0.0f, 0.0f, 7, 1, 1);
        this.Box_1.setRotationPoint(-3.0f, -1.0f, -4.0f);
        this.Box_1.setTextureSize(64, 32);
        this.Box_1.mirror = true;
        this.setRotation(this.Box_1, 0.0f, 0.0f, 0.0f);
        this.Box_2 = new ModelRenderer((ModelBase)this, 41, 1);
        this.Box_2.addBox(0.0f, 0.0f, 0.0f, 7, 1, 1);
        this.Box_2.setRotationPoint(-3.0f, -1.0f, 3.0f);
        this.Box_2.setTextureSize(64, 32);
        this.Box_2.mirror = true;
        this.setRotation(this.Box_2, 0.0f, 0.0f, 0.0f);
        this.Box_3 = new ModelRenderer((ModelBase)this, 25, 9);
        this.Box_3.addBox(0.0f, 0.0f, 0.0f, 7, 1, 1);
        this.Box_3.setRotationPoint(-3.0f, -7.0f, 3.0f);
        this.Box_3.setTextureSize(64, 32);
        this.Box_3.mirror = true;
        this.setRotation(this.Box_3, 0.0f, 0.0f, 1.117011f);
        this.Box_4 = new ModelRenderer((ModelBase)this, 1, 17);
        this.Box_4.addBox(0.0f, 0.0f, 0.0f, 7, 1, 1);
        this.Box_4.setRotationPoint(-3.0f, -7.0f, -4.0f);
        this.Box_4.setTextureSize(64, 32);
        this.Box_4.mirror = true;
        this.setRotation(this.Box_4, 0.0f, 0.0f, 1.117011f);
        this.Box_5 = new ModelRenderer((ModelBase)this, 9, 17);
        this.Box_5.addBox(0.0f, 0.0f, 0.0f, 7, 4, 9);
        this.Box_5.setRotationPoint(0.0f, -10.0f, -4.5f);
        this.Box_5.setTextureSize(64, 32);
        this.Box_5.mirror = true;
        this.setRotation(this.Box_5, 0.0f, 0.0f, 1.117011f);
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
        this.Box_0.render(f5);
        this.Box_1.render(f5);
        this.Box_2.render(f5);
        this.Box_3.render(f5);
        this.Box_4.render(f5);
        this.Box_5.render(f5);
	}
}

