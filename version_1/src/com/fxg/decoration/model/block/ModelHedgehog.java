package com.fxg.decoration.model.block;

import com.fxg.decoration.model.IModel;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelHedgehog extends ModelBase implements IModel {
    ModelRenderer Part_0;
    ModelRenderer Part_1;
    ModelRenderer Part_2;
    ModelRenderer Part_3;
    ModelRenderer Part_4;
    ModelRenderer Part_5;
    ModelRenderer Part_6;
    ModelRenderer Part_7;
    ModelRenderer Part_8;

    public ModelHedgehog() {
        this.textureWidth = 32;
        this.textureHeight = 64;
        this.Part_0 = new ModelRenderer((ModelBase)this, 1, 1);
        this.Part_0.addBox(0.5f, -6.0f, -0.75f, 5, 33, 1);
        this.Part_0.setRotationPoint(-4.0f, -16.0f, -4.0f);
        this.Part_0.setTextureSize(32, 64);
        this.Part_0.mirror = true;
        this.setRotation(this.Part_0, 0.7853982f, 0.87266463f, -6.0039325f);
        this.Part_1 = new ModelRenderer((ModelBase)this, 15, 1);
        this.Part_1.addBox(0.5f, -6.0f, 0.25f, 1, 33, 1);
        this.Part_1.setRotationPoint(-4.0f, -16.0f, -4.0f);
        this.Part_1.setTextureSize(32, 64);
        this.Part_1.mirror = true;
        this.setRotation(this.Part_1, 0.7853982f, 0.87266463f, -6.0039325f);
        this.Part_2 = new ModelRenderer((ModelBase)this, 15, 1);
        this.Part_2.addBox(4.5f, -6.0f, 0.25f, 1, 33, 1);
        this.Part_2.setRotationPoint(-4.0f, -16.0f, -4.0f);
        this.Part_2.setTextureSize(32, 64);
        this.Part_2.mirror = true;
        this.setRotation(this.Part_2, 0.7853982f, 0.87266463f, -6.0039325f);
        this.Part_3 = new ModelRenderer((ModelBase)this, 15, 1);
        this.Part_3.addBox(-1.8f, -6.0f, 0.2f, 1, 33, 1);
        this.Part_3.setRotationPoint(5.0f, -18.0f, 2.5f);
        this.Part_3.setTextureSize(32, 64);
        this.Part_3.mirror = true;
        this.setRotation(this.Part_3, 0.4712389f, 5.2883477f, -5.550147f);
        this.Part_4 = new ModelRenderer((ModelBase)this, 1, 1);
        this.Part_4.addBox(-1.8f, -6.0f, -0.8f, 5, 33, 1);
        this.Part_4.setRotationPoint(5.0f, -18.0f, 2.5f);
        this.Part_4.setTextureSize(32, 64);
        this.Part_4.mirror = true;
        this.setRotation(this.Part_4, 0.4712389f, 5.2883477f, -5.550147f);
        this.Part_5 = new ModelRenderer((ModelBase)this, 15, 1);
        this.Part_5.addBox(2.2f, -6.0f, 0.2f, 1, 33, 1);
        this.Part_5.setRotationPoint(5.0f, -18.0f, 2.5f);
        this.Part_5.setTextureSize(32, 64);
        this.Part_5.mirror = true;
        this.setRotation(this.Part_5, 0.4712389f, 5.2883477f, -5.550147f);
        this.Part_6 = new ModelRenderer((ModelBase)this, 15, 1);
        this.Part_6.addBox(-3.0f, 0.0f, 1.5f, 1, 33, 1);
        this.Part_6.setRotationPoint(-8.0f, -12.0f, 13.0f);
        this.Part_6.setTextureSize(32, 64);
        this.Part_6.mirror = true;
        this.setRotation(this.Part_6, 5.1661744f, 5.2185345f, -5.5850534f);
        this.Part_7 = new ModelRenderer((ModelBase)this, 1, 1);
        this.Part_7.addBox(-3.0f, 0.0f, 0.5f, 5, 33, 1);
        this.Part_7.setRotationPoint(-8.0f, -12.0f, 13.0f);
        this.Part_7.setTextureSize(32, 64);
        this.Part_7.mirror = true;
        this.setRotation(this.Part_7, 5.1661744f, 5.2185345f, -5.5850534f);
        this.Part_8 = new ModelRenderer((ModelBase)this, 15, 1);
        this.Part_8.addBox(1.0f, 0.0f, 1.5f, 1, 33, 1);
        this.Part_8.setRotationPoint(-8.0f, -12.0f, 13.0f);
        this.Part_8.setTextureSize(32, 64);
        this.Part_8.mirror = true;
        this.setRotation(this.Part_8, 5.1661744f, 5.2185345f, -5.5850534f);
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

