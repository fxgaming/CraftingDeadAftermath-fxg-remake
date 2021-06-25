package com.fxg.decoration.model.block;

import com.fxg.decoration.model.IModel;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelHazardbarrier extends ModelBase implements IModel {
    int x = 0;
    ModelRenderer Part_0;
    ModelRenderer Part_1;
    ModelRenderer Part_2;
    ModelRenderer Part_3;
    ModelRenderer Part_4;
    ModelRenderer Part_5;

    public ModelHazardbarrier() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.Part_0 = new ModelRenderer((ModelBase)this, 1, 1);
        this.Part_0.addBox(0.0f, 1.0f, 0.0f, 1, 13, 1);
        this.Part_0.setRotationPoint(-8.0f, -13.0f, 0.0f);
        this.Part_0.setTextureSize(64, 64);
        this.Part_0.mirror = true;
        this.setRotation(this.Part_0, 0.34906584f, 0.0f, 0.0f);
        this.Part_1 = new ModelRenderer((ModelBase)this, 9, 1);
        this.Part_1.addBox(0.0f, 1.0f, 0.0f, 1, 13, 1);
        this.Part_1.setRotationPoint(8.0f, -13.0f, 0.0f);
        this.Part_1.setTextureSize(64, 64);
        this.Part_1.mirror = true;
        this.setRotation(this.Part_1, 0.34906584f, 0.0f, 0.0f);
        this.Part_2 = new ModelRenderer((ModelBase)this, 17, 1);
        this.Part_2.addBox(0.0f, 1.0f, 0.0f, 1, 13, 1);
        this.Part_2.setRotationPoint(9.0f, -13.0f, 1.0f);
        this.Part_2.setTextureSize(64, 64);
        this.Part_2.mirror = true;
        this.setRotation(this.Part_2, 0.34906584f, 3.1415927f, 0.0f);
        this.Part_3 = new ModelRenderer((ModelBase)this, 25, 1);
        this.Part_3.addBox(0.0f, 1.0f, 0.0f, 1, 13, 1);
        this.Part_3.setRotationPoint(-7.0f, -13.0f, 1.0f);
        this.Part_3.setTextureSize(64, 64);
        this.Part_3.mirror = true;
        this.setRotation(this.Part_3, 0.34906584f, 3.1415927f, 0.0f);
        this.Part_4 = new ModelRenderer((ModelBase)this, 1, 17);
        this.Part_4.addBox(0.0f, 1.0f, 0.0f, 15, 7, 1);
        this.Part_4.setRotationPoint(-7.0f, -11.0f, 0.0f);
        this.Part_4.setTextureSize(64, 64);
        this.Part_4.mirror = true;
        this.setRotation(this.Part_4, 0.34906584f, 0.0f, 0.0f);
        this.Part_5 = new ModelRenderer((ModelBase)this, 1, 33);
        this.Part_5.addBox(0.0f, 1.0f, 0.0f, 15, 7, 1);
        this.Part_5.setRotationPoint(-7.0f, -11.3f, 0.0f);
        this.Part_5.setTextureSize(64, 64);
        this.Part_5.mirror = true;
        this.setRotation(this.Part_5, -0.34906584f, 0.0f, 0.0f);
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
        this.Part_3.render(f5);
        this.Part_4.render(f5);
        this.Part_5.render(f5);
	}
}

