package com.fxg.decoration.model.block;

import com.fxg.decoration.model.IModel;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelTireStack extends ModelBase implements IModel {
    int x = 0;
    ModelRenderer Part_0;
    ModelRenderer Part_1;
    ModelRenderer Part_2;
    ModelRenderer Part_3;
    ModelRenderer Part_4;
    ModelRenderer Part_5;
    ModelRenderer Part_6;
    ModelRenderer Part_7;
    ModelRenderer Part_8;
    ModelRenderer Part_9;
    ModelRenderer Part_10;

    public ModelTireStack() {
        this.textureWidth = 256;
        this.textureHeight = 128;
        this.Part_0 = new ModelRenderer((ModelBase)this, 1, 1);
        this.Part_0.addBox(0.0f, 0.0f, 0.0f, 16, 1, 16);
        this.Part_0.setRotationPoint(-8.0f, -1.0f, -8.0f);
        this.Part_0.setTextureSize(256, 128);
        this.Part_0.mirror = true;
        this.setRotation(this.Part_0, 0.0f, 0.0f, 0.0f);
        this.Part_1 = new ModelRenderer((ModelBase)this, 73, 1);
        this.Part_1.addBox(0.0f, 0.0f, 0.0f, 15, 1, 15);
        this.Part_1.setRotationPoint(-7.5f, -2.0f, -7.5f);
        this.Part_1.setTextureSize(256, 128);
        this.Part_1.mirror = true;
        this.setRotation(this.Part_1, 0.0f, 0.0f, 0.0f);
        this.Part_2 = new ModelRenderer((ModelBase)this, 137, 1);
        this.Part_2.addBox(0.0f, 0.0f, 0.0f, 16, 1, 16);
        this.Part_2.setRotationPoint(-8.0f, -3.0f, -8.0f);
        this.Part_2.setTextureSize(256, 128);
        this.Part_2.mirror = true;
        this.setRotation(this.Part_2, 0.0f, 0.0f, 0.0f);
        this.Part_3 = new ModelRenderer((ModelBase)this, 193, 9);
        this.Part_3.addBox(-7.5f, 0.0f, -7.5f, 15, 3, 15);
        this.Part_3.setRotationPoint(0.0f, -6.0f, 0.0f);
        this.Part_3.setTextureSize(256, 128);
        this.Part_3.mirror = true;
        this.setRotation(this.Part_3, 0.0f, 0.2443461f, 0.0f);
        this.Part_4 = new ModelRenderer((ModelBase)this, 1, 25);
        this.Part_4.addBox(-7.5f, 0.0f, -7.5f, 15, 3, 15);
        this.Part_4.setRotationPoint(0.0f, -9.0f, 0.0f);
        this.Part_4.setTextureSize(256, 128);
        this.Part_4.mirror = true;
        this.setRotation(this.Part_4, 0.0f, -0.31415927f, 0.0f);
        this.Part_5 = new ModelRenderer((ModelBase)this, 65, 25);
        this.Part_5.addBox(-7.5f, 0.0f, -7.5f, 15, 3, 15);
        this.Part_5.setRotationPoint(0.0f, -12.0f, 0.0f);
        this.Part_5.setTextureSize(256, 128);
        this.Part_5.mirror = true;
        this.setRotation(this.Part_5, 0.0f, -1.012291f, 0.0f);
        this.Part_6 = new ModelRenderer((ModelBase)this, 1, 1);
        this.Part_6.addBox(0.0f, 0.0f, 0.0f, 1, 13, 1);
        this.Part_6.setRotationPoint(-7.5f, -16.0f, -7.5f);
        this.Part_6.setTextureSize(256, 128);
        this.Part_6.mirror = true;
        this.setRotation(this.Part_6, 0.0f, 0.0f, 0.0f);
        this.Part_7 = new ModelRenderer((ModelBase)this, 9, 1);
        this.Part_7.addBox(0.0f, 0.0f, 0.0f, 1, 13, 1);
        this.Part_7.setRotationPoint(6.5f, -16.0f, -7.5f);
        this.Part_7.setTextureSize(256, 128);
        this.Part_7.mirror = true;
        this.setRotation(this.Part_7, 0.0f, 0.0f, 0.0f);
        this.Part_8 = new ModelRenderer((ModelBase)this, 57, 1);
        this.Part_8.addBox(0.0f, 0.0f, 0.0f, 1, 13, 1);
        this.Part_8.setRotationPoint(6.5f, -16.0f, 6.5f);
        this.Part_8.setTextureSize(256, 128);
        this.Part_8.mirror = true;
        this.setRotation(this.Part_8, 0.0f, 0.0f, 0.0f);
        this.Part_9 = new ModelRenderer((ModelBase)this, 65, 1);
        this.Part_9.addBox(0.0f, 0.0f, 0.0f, 1, 13, 1);
        this.Part_9.setRotationPoint(-7.5f, -16.0f, 6.5f);
        this.Part_9.setTextureSize(256, 128);
        this.Part_9.mirror = true;
        this.setRotation(this.Part_9, 0.0f, 0.0f, 0.0f);
        this.Part_10 = new ModelRenderer((ModelBase)this, 129, 25);
        this.Part_10.addBox(-7.5f, 0.0f, -7.5f, 15, 3, 15);
        this.Part_10.setRotationPoint(0.0f, -15.0f, 0.0f);
        this.Part_10.setTextureSize(256, 128);
        this.Part_10.mirror = true;
        this.setRotation(this.Part_10, 0.0f, -1.3089969f, 0.0f);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

	@Override
	public void render() {
        this.Part_0.render(f5);
        this.Part_1.render(f5);
        this.Part_2.render(f5);
        this.Part_3.render(f5);
        this.Part_4.render(f5);
        this.Part_5.render(f5);
        this.Part_6.render(f5);
        this.Part_7.render(f5);
        this.Part_8.render(f5);
        this.Part_9.render(f5);
        this.Part_10.render(f5);
	}
}

