package com.fxg.decoration.model.block;

import com.fxg.decoration.model.IModel;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelPowerPole extends ModelBase implements IModel {
    int x = 0;
    ModelRenderer Part_0;
    ModelRenderer Part_1;
    ModelRenderer Part_2;

    public ModelPowerPole() {
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.Part_0 = new ModelRenderer((ModelBase)this, 1, 1);
        this.Part_0.addBox(0.0f, 0.0f, 0.0f, 2, 65, 2);
        this.Part_0.setRotationPoint(-1.0f, -65.0f, 0.0f);
        this.Part_0.setTextureSize(128, 128);
        this.Part_0.mirror = true;
        this.setRotation(this.Part_0, 0.0f, 0.7853982f, 0.0f);
        this.Part_1 = new ModelRenderer((ModelBase)this, 17, 1);
        this.Part_1.addBox(-2.5f, 0.0f, 0.5f, 16, 1, 1);
        this.Part_1.setRotationPoint(-0.5f, -63.0f, 5.5f);
        this.Part_1.setTextureSize(128, 128);
        this.Part_1.mirror = true;
        this.setRotation(this.Part_1, 0.0f, 1.5882496f, 0.0f);
        this.Part_2 = new ModelRenderer((ModelBase)this, 57, 1);
        this.Part_2.addBox(-1.5f, 0.0f, 0.5f, 14, 1, 1);
        this.Part_2.setRotationPoint(-0.5f, -57.0f, 5.5f);
        this.Part_2.setTextureSize(128, 128);
        this.Part_2.mirror = true;
        this.setRotation(this.Part_2, 0.0f, 1.5882496f, 0.0f);
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
        this.Part_0.render(f5);
        this.Part_1.render(f5);
        this.Part_2.render(f5);
	}
}

