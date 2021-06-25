package com.fxg.decoration.model.block;

import com.fxg.decoration.model.IModel;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelPhoneBooth extends ModelBase implements IModel {
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

    public ModelPhoneBooth() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.Part_0 = new ModelRenderer((ModelBase)this, 1, 1);
        this.Part_0.addBox(0.0f, 0.0f, 0.0f, 16, 24, 1);
        this.Part_0.setRotationPoint(-8.0f, -24.0f, -8.0f);
        this.Part_0.setTextureSize(128, 64);
        this.Part_0.mirror = true;
        this.setRotation(this.Part_0, 0.0f, 0.0f, 0.0f);
        this.Part_1 = new ModelRenderer((ModelBase)this, 41, 1);
        this.Part_1.addBox(0.0f, 0.0f, 0.0f, 1, 20, 7);
        this.Part_1.setRotationPoint(7.0f, -20.0f, -7.0f);
        this.Part_1.setTextureSize(128, 64);
        this.Part_1.mirror = true;
        this.setRotation(this.Part_1, 0.0f, 0.0f, 0.0f);
        this.Part_2 = new ModelRenderer((ModelBase)this, 65, 1);
        this.Part_2.addBox(0.0f, 0.0f, 0.0f, 1, 20, 7);
        this.Part_2.setRotationPoint(-8.0f, -20.0f, -7.0f);
        this.Part_2.setTextureSize(128, 64);
        this.Part_2.mirror = true;
        this.setRotation(this.Part_2, 0.0f, 0.0f, 0.0f);
        this.Part_3 = new ModelRenderer((ModelBase)this, 89, 1);
        this.Part_3.addBox(0.0f, 0.0f, 0.0f, 5, 15, 2);
        this.Part_3.setRotationPoint(1.0f, -18.0f, -7.0f);
        this.Part_3.setTextureSize(128, 64);
        this.Part_3.mirror = true;
        this.setRotation(this.Part_3, 0.0f, 0.0f, 0.0f);
        this.Part_4 = new ModelRenderer((ModelBase)this, 57, 1);
        this.Part_4.addBox(0.0f, 0.0f, 0.0f, 3, 3, 1);
        this.Part_4.setRotationPoint(2.0f, -16.0f, -5.0f);
        this.Part_4.setTextureSize(128, 64);
        this.Part_4.mirror = true;
        this.setRotation(this.Part_4, 0.0f, 0.0f, 0.0f);
        this.Part_5 = new ModelRenderer((ModelBase)this, 105, 1);
        this.Part_5.addBox(0.0f, 0.0f, 0.0f, 3, 3, 1);
        this.Part_5.setRotationPoint(2.0f, -8.0f, -5.0f);
        this.Part_5.setTextureSize(128, 64);
        this.Part_5.mirror = true;
        this.setRotation(this.Part_5, 0.0f, 0.0f, 0.0f);
        this.Part_6 = new ModelRenderer((ModelBase)this, 105, 9);
        this.Part_6.addBox(0.0f, 0.0f, 0.0f, 3, 9, 1);
        this.Part_6.setRotationPoint(2.0f, -15.0f, -4.0f);
        this.Part_6.setTextureSize(128, 64);
        this.Part_6.mirror = true;
        this.setRotation(this.Part_6, 0.0f, 0.0f, 0.0f);
        this.Part_7 = new ModelRenderer((ModelBase)this, 89, 25);
        this.Part_7.addBox(0.0f, 0.0f, 0.0f, 7, 11, 1);
        this.Part_7.setRotationPoint(-6.0f, -16.0f, -7.0f);
        this.Part_7.setTextureSize(128, 64);
        this.Part_7.mirror = true;
        this.setRotation(this.Part_7, 0.0f, 0.0f, 0.0f);
        this.Part_8 = new ModelRenderer((ModelBase)this, 1, 33);
        this.Part_8.addBox(0.0f, 0.0f, 0.0f, 14, 1, 7);
        this.Part_8.setRotationPoint(-7.0f, -1.0f, -7.0f);
        this.Part_8.setTextureSize(128, 64);
        this.Part_8.mirror = true;
        this.setRotation(this.Part_8, 0.0f, 0.0f, 0.0f);
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
	}
}

