package com.fxg.decoration.model.block;

import com.fxg.decoration.model.IModel;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelStreetBench extends ModelBase implements IModel {
    int x = 0;
    ModelRenderer Box_0;
    ModelRenderer Box_1;
    ModelRenderer Box_2;
    ModelRenderer Box_3;
    ModelRenderer Box_4;
    ModelRenderer Box_5;

    public ModelStreetBench() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.Box_0 = new ModelRenderer((ModelBase)this, 1, 1);
        this.Box_0.addBox(0.0f, 0.0f, 0.0f, 3, 1, 2);
        this.Box_0.setRotationPoint(1.0f, -1.0f, -1.0f);
        this.Box_0.setTextureSize(64, 32);
        this.Box_0.mirror = true;
        this.setRotation(this.Box_0, 0.0f, 0.0f, 0.0f);
        this.Box_1 = new ModelRenderer((ModelBase)this, 17, 1);
        this.Box_1.addBox(0.0f, 0.0f, 0.0f, 3, 9, 1);
        this.Box_1.setRotationPoint(-1.0f, -9.0f, -0.5f);
        this.Box_1.setTextureSize(64, 32);
        this.Box_1.mirror = true;
        this.setRotation(this.Box_1, 0.0f, 0.0f, -0.2094395f);
        this.Box_2 = new ModelRenderer((ModelBase)this, 33, 1);
        this.Box_2.addBox(0.0f, 0.0f, 0.0f, 9, 1, 2);
        this.Box_2.setRotationPoint(-6.0f, -10.0f, -1.0f);
        this.Box_2.setTextureSize(64, 32);
        this.Box_2.mirror = true;
        this.setRotation(this.Box_2, 0.0f, 0.0f, 0.0f);
        this.Box_3 = new ModelRenderer((ModelBase)this, 41, 1);
        this.Box_3.addBox(0.0f, 0.0f, 0.0f, 9, 1, 16);
        this.Box_3.setRotationPoint(-4.0f, -11.0f, -8.0f);
        this.Box_3.setTextureSize(64, 32);
        this.Box_3.mirror = true;
        this.setRotation(this.Box_3, 0.0f, 0.0f, 0.0f);
        this.Box_4 = new ModelRenderer((ModelBase)this, 81, 1);
        this.Box_4.addBox(0.0f, 0.0f, 0.0f, 1, 9, 1);
        this.Box_4.setRotationPoint(-8.0f, -18.0f, -0.5f);
        this.Box_4.setTextureSize(64, 32);
        this.Box_4.mirror = true;
        this.setRotation(this.Box_4, 0.0f, 0.0f, -0.2094395f);
        this.Box_5 = new ModelRenderer((ModelBase)this, 17, 9);
        this.Box_5.addBox(0.0f, 0.0f, 0.0f, 1, 9, 16);
        this.Box_5.setRotationPoint(-8.0f, -21.0f, -8.0f);
        this.Box_5.setTextureSize(64, 32);
        this.Box_5.mirror = true;
        this.setRotation(this.Box_5, 0.0f, 0.0f, -0.2094395f);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
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

