package com.fxg.decoration.model.block;

import com.fxg.decoration.model.IModel;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelFlagPoll extends ModelBase implements IModel {
    int x = 0;
    ModelRenderer Part_0;
    ModelRenderer Part_1;
    ModelRenderer Part_2;
    ModelRenderer Part_3;

    public ModelFlagPoll() {
        this.textureWidth = 256;
        this.textureHeight = 256;
        this.Part_0 = new ModelRenderer((ModelBase)this, 137, 1);
        this.Part_0.addBox(-1.0f, 0.0f, -1.0f, 2, 128, 2);
        this.Part_0.setRotationPoint(0.0f, -128.0f, 0.0f);
        this.Part_0.setTextureSize(256, 256);
        this.Part_0.mirror = true;
        this.setRotation(this.Part_0, 0.0f, 0.0f, 0.0f);
        this.Part_1 = new ModelRenderer((ModelBase)this, 1, 1);
        this.Part_1.addBox(-0.5f, 0.0f, -1.0f, 1, 1, 2);
        this.Part_1.setRotationPoint(0.0f, -125.0f, -2.0f);
        this.Part_1.setTextureSize(256, 256);
        this.Part_1.mirror = true;
        this.setRotation(this.Part_1, 0.0f, 0.0f, 0.0f);
        this.Part_2 = new ModelRenderer((ModelBase)this, 9, 1);
        this.Part_2.addBox(-0.5f, 0.0f, -1.0f, 1, 1, 2);
        this.Part_2.setRotationPoint(0.0f, -115.0f, -2.0f);
        this.Part_2.setTextureSize(256, 256);
        this.Part_2.mirror = true;
        this.setRotation(this.Part_2, 0.0f, 0.0f, 0.0f);
        this.Part_3 = new ModelRenderer((ModelBase)this, 153, 1);
        this.Part_3.addBox(0.0f, 0.0f, -1.0f, 0, 13, 24);
        this.Part_3.setRotationPoint(0.0f, -126.0f, -25.0f);
        this.Part_3.setTextureSize(256, 256);
        this.Part_3.mirror = true;
        this.setRotation(this.Part_3, 0.0f, 0.0f, 0.0f);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void setRotationAngles(Entity par7Entity, float par2, float par3, float par4, float par5, float par6, float par1) {
    }

	@Override
	public void render() {
        this.Part_0.render(f5);
        this.Part_1.render(f5);
        this.Part_2.render(f5);
        this.Part_3.render(f5);
	}
}

