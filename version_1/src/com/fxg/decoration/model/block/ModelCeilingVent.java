package com.fxg.decoration.model.block;

import com.fxg.decoration.model.IModel;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelCeilingVent extends ModelBase implements IModel {
    int x = 0;
    ModelRenderer Part_0;
    ModelRenderer Part_1;
    ModelRenderer Part_2;
    ModelRenderer Part_3;

    public ModelCeilingVent() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.Part_0 = new ModelRenderer((ModelBase)this, 1, 1);
        this.Part_0.addBox(0.0f, 0.0f, 0.0f, 1, 8, 1);
        this.Part_0.setRotationPoint(-1.0f, -16.0f, 7.0f);
        this.Part_0.setTextureSize(64, 64);
        this.Part_0.mirror = true;
        this.setRotation(this.Part_0, 0.0f, 0.0f, 0.0f);
        this.Part_1 = new ModelRenderer((ModelBase)this, 9, 1);
        this.Part_1.addBox(0.0f, 0.0f, 0.0f, 1, 8, 1);
        this.Part_1.setRotationPoint(-1.0f, -16.0f, -8.0f);
        this.Part_1.setTextureSize(64, 64);
        this.Part_1.mirror = true;
        this.setRotation(this.Part_1, 0.0f, 0.0f, 0.0f);
        this.Part_2 = new ModelRenderer((ModelBase)this, 1, 1);
        this.Part_2.addBox(0.0f, 0.0f, 0.0f, 16, 7, 14);
        this.Part_2.setRotationPoint(-8.0f, -16.0f, -7.0f);
        this.Part_2.setTextureSize(64, 64);
        this.Part_2.mirror = true;
        this.setRotation(this.Part_2, 0.0f, 0.0f, 0.0f);
        this.Part_3 = new ModelRenderer((ModelBase)this, 1, 25);
        this.Part_3.addBox(0.0f, 0.0f, 0.0f, 1, 1, 14);
        this.Part_3.setRotationPoint(-1.0f, -9.0f, -7.0f);
        this.Part_3.setTextureSize(64, 64);
        this.Part_3.mirror = true;
        this.setRotation(this.Part_3, 0.0f, 0.0f, 0.0f);
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
	}
}

