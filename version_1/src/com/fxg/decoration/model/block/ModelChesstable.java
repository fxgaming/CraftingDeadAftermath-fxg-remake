package com.fxg.decoration.model.block;

import com.fxg.decoration.model.IModel;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelChesstable extends ModelBase implements IModel {
    int x = 0;
    ModelRenderer Box_0;
    ModelRenderer Box_1;
    ModelRenderer Box_2;
    ModelRenderer Box_3;
    ModelRenderer Box_4;
    ModelRenderer Box_5;
    ModelRenderer Box_6;
    ModelRenderer Box_7;
    ModelRenderer Box_8;
    ModelRenderer Box_9;
    ModelRenderer Box_10;
    ModelRenderer Box_11;
    ModelRenderer Box_12;
    ModelRenderer Box_13;
    ModelRenderer Box_14;

    public ModelChesstable() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.Box_0 = new ModelRenderer((ModelBase)this, 1, 1);
        this.Box_0.addBox(0.0f, 0.0f, 0.0f, 14, 2, 14);
        this.Box_0.setRotationPoint(-7.0f, -2.0f, -7.0f);
        this.Box_0.setTextureSize(64, 32);
        this.Box_0.mirror = true;
        this.setRotation(this.Box_0, 0.0f, 0.0f, 0.0f);
        this.Box_1 = new ModelRenderer((ModelBase)this, 65, 1);
        this.Box_1.addBox(0.0f, 0.0f, 0.0f, 6, 15, 6);
        this.Box_1.setRotationPoint(-3.0f, -17.0f, -3.0f);
        this.Box_1.setTextureSize(64, 32);
        this.Box_1.mirror = true;
        this.setRotation(this.Box_1, 0.0f, 0.0f, 0.0f);
        this.Box_2 = new ModelRenderer((ModelBase)this, 1, 25);
        this.Box_2.addBox(0.0f, 0.0f, 0.0f, 20, 1, 20);
        this.Box_2.setRotationPoint(-10.0f, -18.0f, -10.0f);
        this.Box_2.setTextureSize(64, 32);
        this.Box_2.mirror = true;
        this.setRotation(this.Box_2, 0.0f, 0.0f, 0.0f);
        this.Box_3 = new ModelRenderer((ModelBase)this, 73, 9);
        this.Box_3.addBox(0.0f, 0.0f, 0.0f, 1, 1, 18);
        this.Box_3.setRotationPoint(-11.0f, -18.0f, -9.0f);
        this.Box_3.setTextureSize(64, 32);
        this.Box_3.mirror = true;
        this.setRotation(this.Box_3, 0.0f, 0.0f, 0.0f);
        this.Box_4 = new ModelRenderer((ModelBase)this, 65, 33);
        this.Box_4.addBox(0.0f, 0.0f, 0.0f, 1, 1, 18);
        this.Box_4.setRotationPoint(10.0f, -18.0f, -9.0f);
        this.Box_4.setTextureSize(64, 32);
        this.Box_4.mirror = true;
        this.setRotation(this.Box_4, 0.0f, 0.0f, 0.0f);
        this.Box_5 = new ModelRenderer((ModelBase)this, 89, 1);
        this.Box_5.addBox(0.0f, 0.0f, 0.0f, 18, 1, 1);
        this.Box_5.setRotationPoint(-9.0f, -18.0f, -11.0f);
        this.Box_5.setTextureSize(64, 32);
        this.Box_5.mirror = true;
        this.setRotation(this.Box_5, 0.0f, 0.0f, 0.0f);
        this.Box_6 = new ModelRenderer((ModelBase)this, 89, 33);
        this.Box_6.addBox(0.0f, 0.0f, 0.0f, 18, 1, 1);
        this.Box_6.setRotationPoint(-9.0f, -18.0f, 10.0f);
        this.Box_6.setTextureSize(64, 32);
        this.Box_6.mirror = true;
        this.setRotation(this.Box_6, 0.0f, 0.0f, 0.0f);
        this.Box_7 = new ModelRenderer((ModelBase)this, 1, 1);
        this.Box_7.addBox(0.0f, 0.0f, 0.0f, 4, 4, 1);
        this.Box_7.setRotationPoint(-2.0f, -6.0f, -4.0f);
        this.Box_7.setTextureSize(64, 32);
        this.Box_7.mirror = true;
        this.setRotation(this.Box_7, 0.0f, 0.0f, 0.0f);
        this.Box_8 = new ModelRenderer((ModelBase)this, 49, 1);
        this.Box_8.addBox(0.0f, 0.0f, 0.0f, 4, 4, 1);
        this.Box_8.setRotationPoint(-2.0f, -6.0f, 3.0f);
        this.Box_8.setTextureSize(64, 32);
        this.Box_8.mirror = true;
        this.setRotation(this.Box_8, 0.0f, 0.0f, 0.0f);
        this.Box_9 = new ModelRenderer((ModelBase)this, 97, 9);
        this.Box_9.addBox(0.0f, 0.0f, 0.0f, 1, 4, 4);
        this.Box_9.setRotationPoint(-4.0f, -6.0f, -2.0f);
        this.Box_9.setTextureSize(64, 32);
        this.Box_9.mirror = true;
        this.setRotation(this.Box_9, 0.0f, 0.0f, 0.0f);
        this.Box_10 = new ModelRenderer((ModelBase)this, 113, 9);
        this.Box_10.addBox(0.0f, 0.0f, 0.0f, 1, 4, 4);
        this.Box_10.setRotationPoint(3.0f, -6.0f, -2.0f);
        this.Box_10.setTextureSize(64, 32);
        this.Box_10.mirror = true;
        this.setRotation(this.Box_10, 0.0f, 0.0f, 0.0f);
        this.Box_11 = new ModelRenderer((ModelBase)this, 1, 9);
        this.Box_11.addBox(0.0f, 0.0f, 0.0f, 4, 2, 1);
        this.Box_11.setRotationPoint(-2.0f, -17.0f, 3.0f);
        this.Box_11.setTextureSize(64, 32);
        this.Box_11.mirror = true;
        this.setRotation(this.Box_11, 0.0f, 0.0f, 0.0f);
        this.Box_12 = new ModelRenderer((ModelBase)this, 105, 17);
        this.Box_12.addBox(0.0f, 0.0f, 0.0f, 1, 2, 4);
        this.Box_12.setRotationPoint(-4.0f, -17.0f, -2.0f);
        this.Box_12.setTextureSize(64, 32);
        this.Box_12.mirror = true;
        this.setRotation(this.Box_12, 0.0f, 0.0f, 0.0f);
        this.Box_13 = new ModelRenderer((ModelBase)this, 49, 9);
        this.Box_13.addBox(0.0f, 0.0f, 0.0f, 4, 2, 1);
        this.Box_13.setRotationPoint(-2.0f, -17.0f, -4.0f);
        this.Box_13.setTextureSize(64, 32);
        this.Box_13.mirror = true;
        this.setRotation(this.Box_13, 0.0f, 0.0f, 0.0f);
        this.Box_14 = new ModelRenderer((ModelBase)this, 1, 25);
        this.Box_14.addBox(0.0f, 0.0f, 0.0f, 1, 2, 4);
        this.Box_14.setRotationPoint(3.0f, -17.0f, -2.0f);
        this.Box_14.setTextureSize(64, 32);
        this.Box_14.mirror = true;
        this.setRotation(this.Box_14, 0.0f, 0.0f, 0.0f);
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
        this.Box_7.render(f5);
        this.Box_8.render(f5);
        this.Box_9.render(f5);
        this.Box_10.render(f5);
        this.Box_11.render(f5);
        this.Box_12.render(f5);
        this.Box_13.render(f5);
        this.Box_14.render(f5);
	}
}

