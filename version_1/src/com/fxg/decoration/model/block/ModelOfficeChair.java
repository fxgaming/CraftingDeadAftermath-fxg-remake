package com.fxg.decoration.model.block;

import com.fxg.decoration.model.IModel;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelOfficeChair extends ModelBase implements IModel {
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

    public ModelOfficeChair() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.Part_0 = new ModelRenderer((ModelBase)this, 1, 1);
        this.Part_0.addBox(-1.0f, 0.0f, -1.0f, 2, 2, 2);
        this.Part_0.setRotationPoint(-6.0f, -2.0f, 0.0f);
        this.Part_0.setTextureSize(64, 64);
        this.Part_0.mirror = true;
        this.setRotation(this.Part_0, 0.0f, 0.80285144f, 0.0f);
        this.Part_1 = new ModelRenderer((ModelBase)this, 17, 1);
        this.Part_1.addBox(0.0f, 0.0f, 0.0f, 14, 1, 2);
        this.Part_1.setRotationPoint(-7.0f, -3.0f, -1.0f);
        this.Part_1.setTextureSize(64, 64);
        this.Part_1.mirror = true;
        this.setRotation(this.Part_1, 0.0f, 0.0f, 0.0f);
        this.Part_2 = new ModelRenderer((ModelBase)this, 1, 9);
        this.Part_2.addBox(0.0f, 0.0f, 0.0f, 2, 1, 14);
        this.Part_2.setRotationPoint(-1.0f, -3.0f, -7.0f);
        this.Part_2.setTextureSize(64, 64);
        this.Part_2.mirror = true;
        this.setRotation(this.Part_2, 0.0f, 0.0f, 0.0f);
        this.Part_3 = new ModelRenderer((ModelBase)this, 1, 9);
        this.Part_3.addBox(-1.0f, 0.0f, -1.0f, 2, 6, 2);
        this.Part_3.setRotationPoint(0.0f, -9.0f, 0.0f);
        this.Part_3.setTextureSize(64, 64);
        this.Part_3.mirror = true;
        this.setRotation(this.Part_3, 0.0f, 0.7853982f, 0.0f);
        this.Part_4 = new ModelRenderer((ModelBase)this, 1, 25);
        this.Part_4.addBox(0.0f, 0.0f, 0.0f, 10, 1, 10);
        this.Part_4.setRotationPoint(-5.0f, -10.0f, -5.0f);
        this.Part_4.setTextureSize(64, 64);
        this.Part_4.mirror = true;
        this.setRotation(this.Part_4, 0.0f, 0.0f, 0.0f);
        this.Part_5 = new ModelRenderer((ModelBase)this, 25, 9);
        this.Part_5.addBox(-1.0f, 0.0f, -1.0f, 2, 2, 2);
        this.Part_5.setRotationPoint(0.0f, -2.0f, 6.0f);
        this.Part_5.setTextureSize(64, 64);
        this.Part_5.mirror = true;
        this.setRotation(this.Part_5, 0.0f, 0.80285144f, 0.0f);
        this.Part_6 = new ModelRenderer((ModelBase)this, 41, 9);
        this.Part_6.addBox(-1.0f, 0.0f, -1.0f, 2, 2, 2);
        this.Part_6.setRotationPoint(0.0f, -2.0f, -6.0f);
        this.Part_6.setTextureSize(64, 64);
        this.Part_6.mirror = true;
        this.setRotation(this.Part_6, 0.0f, 0.80285144f, 0.0f);
        this.Part_7 = new ModelRenderer((ModelBase)this, 25, 17);
        this.Part_7.addBox(-1.0f, 0.0f, -1.0f, 2, 2, 2);
        this.Part_7.setRotationPoint(6.0f, -2.0f, 0.0f);
        this.Part_7.setTextureSize(64, 64);
        this.Part_7.mirror = true;
        this.setRotation(this.Part_7, 0.0f, 0.80285144f, 0.0f);
        this.Part_8 = new ModelRenderer((ModelBase)this, 41, 17);
        this.Part_8.addBox(0.0f, 0.0f, 0.0f, 4, 10, 1);
        this.Part_8.setRotationPoint(-2.0f, -19.0f, -6.0f);
        this.Part_8.setTextureSize(64, 64);
        this.Part_8.mirror = true;
        this.setRotation(this.Part_8, 0.0f, 0.0f, 0.0f);
        this.Part_9 = new ModelRenderer((ModelBase)this, 1, 41);
        this.Part_9.addBox(0.0f, 0.0f, 0.0f, 10, 10, 1);
        this.Part_9.setRotationPoint(-5.0f, -24.0f, -5.0f);
        this.Part_9.setTextureSize(64, 64);
        this.Part_9.mirror = true;
        this.setRotation(this.Part_9, 0.0f, 0.0f, 0.0f);
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
	}
}

