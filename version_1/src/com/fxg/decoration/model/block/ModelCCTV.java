package com.fxg.decoration.model.block;

import com.fxg.decoration.model.IModel;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelCCTV extends ModelBase implements IModel {
    int x = 0;
    ModelRenderer Part_0;
    ModelRenderer Part_1;

    public ModelCCTV() {
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.Part_0 = new ModelRenderer((ModelBase)this, 1, 1);
        this.Part_0.addBox(0.0f, 0.0f, 0.0f, 1, 4, 1);
        this.Part_0.setRotationPoint(0.0f, -16.0f, 0.0f);
        this.Part_0.setTextureSize(32, 32);
        this.Part_0.mirror = true;
        this.setRotation(this.Part_0, 0.0f, 0.0f, 0.0f);
        this.Part_1 = new ModelRenderer((ModelBase)this, 1, 1);
        this.Part_1.addBox(-1.5f, 0.0f, -1.5f, 3, 3, 7);
        this.Part_1.setRotationPoint(-0.5f, -13.0f, -0.5f);
        this.Part_1.setTextureSize(32, 32);
        this.Part_1.mirror = true;
        this.setRotation(this.Part_1, -0.38397244f, 0.7853982f, 0.0f);
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
	}
}

