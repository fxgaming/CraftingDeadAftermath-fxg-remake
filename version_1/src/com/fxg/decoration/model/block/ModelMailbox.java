package com.fxg.decoration.model.block;

import com.fxg.decoration.model.IModel;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelMailbox extends ModelBase implements IModel {
    int x = 0;
    ModelRenderer Box_0;
    ModelRenderer Box_1;
    ModelRenderer Box_2;
    ModelRenderer Box_3;
    ModelRenderer Box_4;
    ModelRenderer Box_5;
    ModelRenderer Box_6;
    ModelRenderer Box_8;
    ModelRenderer Box_9;
    ModelRenderer Box_11;
    ModelRenderer Box_12;

    public ModelMailbox() {
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.Box_0 = new ModelRenderer((ModelBase)this, 1, 1);
        this.Box_0.addBox(0.0f, 0.0f, 0.0f, 1, 7, 1);
        this.Box_0.setRotationPoint(7.0f, -7.0f, 7.0f);
        this.Box_0.setTextureSize(64, 32);
        this.Box_0.mirror = true;
        this.setRotation(this.Box_0, 0.0f, 0.0f, 0.0f);
        this.Box_1 = new ModelRenderer((ModelBase)this, 9, 1);
        this.Box_1.addBox(0.0f, 0.0f, 0.0f, 1, 7, 1);
        this.Box_1.setRotationPoint(-8.0f, -7.0f, 7.0f);
        this.Box_1.setTextureSize(64, 32);
        this.Box_1.mirror = true;
        this.setRotation(this.Box_1, 0.0f, 0.0f, 0.0f);
        this.Box_2 = new ModelRenderer((ModelBase)this, 17, 1);
        this.Box_2.addBox(0.0f, 0.0f, 0.0f, 1, 7, 1);
        this.Box_2.setRotationPoint(-8.0f, -7.0f, -8.0f);
        this.Box_2.setTextureSize(64, 32);
        this.Box_2.mirror = true;
        this.setRotation(this.Box_2, 0.0f, 0.0f, 0.0f);
        this.Box_3 = new ModelRenderer((ModelBase)this, 25, 1);
        this.Box_3.addBox(0.0f, 0.0f, 0.0f, 1, 7, 1);
        this.Box_3.setRotationPoint(7.0f, -7.0f, -8.0f);
        this.Box_3.setTextureSize(64, 32);
        this.Box_3.mirror = true;
        this.setRotation(this.Box_3, 0.0f, 0.0f, 0.0f);
        this.Box_4 = new ModelRenderer((ModelBase)this, 17, 1);
        this.Box_4.addBox(0.0f, 0.0f, 0.0f, 16, 12, 16);
        this.Box_4.setRotationPoint(-8.0f, -19.0f, -8.0f);
        this.Box_4.setTextureSize(64, 32);
        this.Box_4.mirror = true;
        this.setRotation(this.Box_4, 0.0f, 0.0f, 0.0f);
        this.Box_5 = new ModelRenderer((ModelBase)this, 89, 1);
        this.Box_5.addBox(0.0f, 0.0f, 0.0f, 1, 6, 16);
        this.Box_5.setRotationPoint(-8.0f, -25.0f, -8.0f);
        this.Box_5.setTextureSize(64, 32);
        this.Box_5.mirror = true;
        this.setRotation(this.Box_5, 0.0f, 0.0f, 0.0f);
        this.Box_6 = new ModelRenderer((ModelBase)this, 73, 25);
        this.Box_6.addBox(0.0f, 0.0f, 0.0f, 1, 6, 16);
        this.Box_6.setRotationPoint(7.0f, -25.0f, -8.0f);
        this.Box_6.setTextureSize(64, 32);
        this.Box_6.mirror = true;
        this.setRotation(this.Box_6, 0.0f, 0.0f, 0.0f);
        this.Box_8 = new ModelRenderer((ModelBase)this, 1, 33);
        this.Box_8.addBox(0.0f, 0.0f, 0.0f, 16, 3, 14);
        this.Box_8.setRotationPoint(-8.0f, -28.0f, -7.0f);
        this.Box_8.setTextureSize(64, 32);
        this.Box_8.mirror = true;
        this.setRotation(this.Box_8, 0.0f, 0.0f, 0.0f);
        this.Box_9 = new ModelRenderer((ModelBase)this, 57, 49);
        this.Box_9.addBox(0.0f, 0.0f, 0.0f, 16, 1, 10);
        this.Box_9.setRotationPoint(-8.0f, -29.0f, -5.0f);
        this.Box_9.setTextureSize(64, 32);
        this.Box_9.mirror = true;
        this.setRotation(this.Box_9, 0.0f, 0.0f, 0.0f);
        this.Box_11 = new ModelRenderer((ModelBase)this, 1, 57);
        this.Box_11.addBox(0.0f, 0.0f, 0.0f, 14, 5, 12);
        this.Box_11.setRotationPoint(-7.0f, -24.0f, -6.0f);
        this.Box_11.setTextureSize(64, 32);
        this.Box_11.mirror = true;
        this.setRotation(this.Box_11, 0.0f, 0.0f, 0.0f);
        this.Box_12 = new ModelRenderer((ModelBase)this, 41, 65);
        this.Box_12.addBox(0.0f, 0.0f, 0.0f, 14, 1, 16);
        this.Box_12.setRotationPoint(-7.0f, -25.0f, -8.0f);
        this.Box_12.setTextureSize(64, 32);
        this.Box_12.mirror = true;
        this.setRotation(this.Box_12, 0.0f, 0.0f, 0.0f);
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
        this.Box_0.render(f5);
        this.Box_1.render(f5);
        this.Box_2.render(f5);
        this.Box_3.render(f5);
        this.Box_4.render(f5);
        this.Box_5.render(f5);
        this.Box_6.render(f5);
        this.Box_8.render(f5);
        this.Box_9.render(f5);
        this.Box_11.render(f5);
        this.Box_12.render(f5);
	}
}

