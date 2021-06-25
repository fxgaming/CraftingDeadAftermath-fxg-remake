package com.fxg.decoration.model.block;

import com.fxg.decoration.model.IModel;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelWashingMachine extends ModelBase implements IModel {
    ModelRenderer Part_0;
    ModelRenderer Part_1;
    ModelRenderer Part_2;
    ModelRenderer Part_3;
    ModelRenderer Part_4;

    public ModelWashingMachine() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.Part_0 = new ModelRenderer((ModelBase)this, 1, 1);
        this.Part_0.addBox(0.0f, 0.0f, 0.0f, 16, 15, 16);
        this.Part_0.setRotationPoint(-8.0f, -15.0f, -8.0f);
        this.Part_0.setTextureSize(128, 64);
        this.Part_0.mirror = true;
        this.setRotation(this.Part_0, 0.0f, 0.0f, 0.0f);
        this.Part_1 = new ModelRenderer((ModelBase)this, 49, 17);
        this.Part_1.addBox(0.0f, 0.0f, 0.0f, 16, 1, 17);
        this.Part_1.setRotationPoint(-8.0f, -16.0f, -8.0f);
        this.Part_1.setTextureSize(128, 64);
        this.Part_1.mirror = true;
        this.setRotation(this.Part_1, 0.0f, 0.0f, 0.0f);
        this.Part_2 = new ModelRenderer((ModelBase)this, 57, 1);
        this.Part_2.addBox(0.0f, 0.0f, 0.0f, 14, 13, 1);
        this.Part_2.setRotationPoint(-7.0f, -14.0f, 7.5f);
        this.Part_2.setTextureSize(128, 64);
        this.Part_2.mirror = true;
        this.setRotation(this.Part_2, 0.0f, 0.0f, 0.0f);
        this.Part_3 = new ModelRenderer((ModelBase)this, 89, 1);
        this.Part_3.addBox(0.0f, 0.0f, 0.0f, 8, 8, 1);
        this.Part_3.setRotationPoint(-5.5f, -7.5f, 8.0f);
        this.Part_3.setTextureSize(128, 64);
        this.Part_3.mirror = true;
        this.setRotation(this.Part_3, 0.0f, 0.0f, -0.7679449f);
        this.Part_4 = new ModelRenderer((ModelBase)this, 1, 33);
        this.Part_4.addBox(0.0f, 0.0f, 0.0f, 16, 1, 1);
        this.Part_4.setRotationPoint(-8.0f, -17.0f, -8.0f);
        this.Part_4.setTextureSize(128, 64);
        this.Part_4.mirror = true;
        this.setRotation(this.Part_4, 0.0f, 0.0f, 0.0f);
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
	}
}

