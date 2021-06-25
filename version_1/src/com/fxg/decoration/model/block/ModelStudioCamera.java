package com.fxg.decoration.model.block;

import com.fxg.decoration.model.IModel;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelStudioCamera extends ModelBase implements IModel {
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
    ModelRenderer Box_15;

    public ModelStudioCamera() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.Box_0 = new ModelRenderer((ModelBase)this, 1, 1);
        this.Box_0.addBox(-0.5f, 0.0f, -0.5f, 1, 22, 1);
        this.Box_0.setRotationPoint(0.0f, -20.0f, 0.0f);
        this.Box_0.setTextureSize(64, 32);
        this.Box_0.mirror = true;
        this.setRotation(this.Box_0, 0.0f, 0.0f, -0.3490659f);
        this.Box_1 = new ModelRenderer((ModelBase)this, 9, 1);
        this.Box_1.addBox(-0.5f, 0.0f, -0.5f, 1, 22, 1);
        this.Box_1.setRotationPoint(0.0f, -20.0f, 0.0f);
        this.Box_1.setTextureSize(64, 32);
        this.Box_1.mirror = true;
        this.setRotation(this.Box_1, 0.0f, 0.0f, 0.3490659f);
        this.Box_2 = new ModelRenderer((ModelBase)this, 17, 1);
        this.Box_2.addBox(-0.5f, 0.0f, -0.5f, 1, 22, 1);
        this.Box_2.setRotationPoint(0.0f, -20.0f, 0.0f);
        this.Box_2.setTextureSize(64, 32);
        this.Box_2.mirror = true;
        this.setRotation(this.Box_2, 0.3490659f, 0.0f, 0.0f);
        this.Box_3 = new ModelRenderer((ModelBase)this, 25, 1);
        this.Box_3.addBox(-0.5f, 0.0f, -0.5f, 1, 22, 1);
        this.Box_3.setRotationPoint(0.0f, -20.0f, 0.0f);
        this.Box_3.setTextureSize(64, 32);
        this.Box_3.mirror = true;
        this.setRotation(this.Box_3, -0.3490659f, 0.0f, 0.0f);
        this.Box_4 = new ModelRenderer((ModelBase)this, 33, 1);
        this.Box_4.addBox(0.0f, 0.0f, 0.0f, 2, 2, 2);
        this.Box_4.setRotationPoint(-1.0f, -21.0f, -1.0f);
        this.Box_4.setTextureSize(64, 32);
        this.Box_4.mirror = true;
        this.setRotation(this.Box_4, 0.0f, 0.0f, 0.0f);
        this.Box_5 = new ModelRenderer((ModelBase)this, 49, 1);
        this.Box_5.addBox(-1.0f, 0.0f, -1.0f, 2, 1, 2);
        this.Box_5.setRotationPoint(0.0f, -19.5f, 0.0f);
        this.Box_5.setTextureSize(64, 32);
        this.Box_5.mirror = true;
        this.setRotation(this.Box_5, 0.0f, 0.7853982f, 0.0f);
        this.Box_6 = new ModelRenderer((ModelBase)this, 33, 9);
        this.Box_6.addBox(-1.0f, -1.0f, 0.0f, 1, 1, 1);
        this.Box_6.setRotationPoint(1.0f, -21.0f, -2.0f);
        this.Box_6.setTextureSize(64, 32);
        this.Box_6.mirror = true;
        this.setRotation(this.Box_6, 0.0f, 0.0f, -0.7853982f);
        this.Box_7 = new ModelRenderer((ModelBase)this, 41, 9);
        this.Box_7.addBox(0.0f, 0.0f, 0.0f, 4, 1, 2);
        this.Box_7.setRotationPoint(-2.0f, -22.0f, -1.0f);
        this.Box_7.setTextureSize(64, 32);
        this.Box_7.mirror = true;
        this.setRotation(this.Box_7, 0.0f, 0.0f, 0.0f);
        this.Box_8 = new ModelRenderer((ModelBase)this, 33, 17);
        this.Box_8.addBox(0.0f, 0.0f, 0.0f, 6, 3, 3);
        this.Box_8.setRotationPoint(-3.0f, -25.0f, -1.5f);
        this.Box_8.setTextureSize(64, 32);
        this.Box_8.mirror = true;
        this.setRotation(this.Box_8, 0.0f, 0.0f, 0.0f);
        this.Box_9 = new ModelRenderer((ModelBase)this, 1, 25);
        this.Box_9.addBox(0.0f, 0.0f, 0.0f, 1, 3, 4);
        this.Box_9.setRotationPoint(-3.5f, -25.5f, -2.0f);
        this.Box_9.setTextureSize(64, 32);
        this.Box_9.mirror = true;
        this.setRotation(this.Box_9, 0.0f, 0.0f, 0.0f);
        this.Box_10 = new ModelRenderer((ModelBase)this, 49, 17);
        this.Box_10.addBox(0.0f, 0.0f, 0.0f, 5, 1, 1);
        this.Box_10.setRotationPoint(-2.5f, -25.5f, -0.5f);
        this.Box_10.setTextureSize(64, 32);
        this.Box_10.mirror = true;
        this.setRotation(this.Box_10, 0.0f, 0.0f, 0.0f);
        this.Box_11 = new ModelRenderer((ModelBase)this, 57, 9);
        this.Box_11.addBox(0.0f, 0.0f, 0.0f, 1, 1, 1);
        this.Box_11.setRotationPoint(2.5f, -23.5f, -0.75f);
        this.Box_11.setTextureSize(64, 32);
        this.Box_11.mirror = true;
        this.setRotation(this.Box_11, 0.7853982f, 0.0f, 0.0f);
        this.Box_12 = new ModelRenderer((ModelBase)this, 17, 25);
        this.Box_12.addBox(0.0f, -1.0f, -1.0f, 1, 2, 2);
        this.Box_12.setRotationPoint(3.5f, -23.5f, 0.0f);
        this.Box_12.setTextureSize(64, 32);
        this.Box_12.mirror = true;
        this.setRotation(this.Box_12, 0.7853982f, 0.0f, 0.0f);
        this.Box_13 = new ModelRenderer((ModelBase)this, 9, 25);
        this.Box_13.addBox(0.0f, 0.0f, 0.0f, 1, 1, 2);
        this.Box_13.setRotationPoint(0.5f, -25.5f, -2.5f);
        this.Box_13.setTextureSize(64, 32);
        this.Box_13.mirror = true;
        this.setRotation(this.Box_13, 0.0f, 0.0f, 0.0f);
        this.Box_14 = new ModelRenderer((ModelBase)this, 25, 25);
        this.Box_14.addBox(0.0f, 0.0f, 0.0f, 1, 1, 1);
        this.Box_14.setRotationPoint(0.5f, -26.5f, -2.5f);
        this.Box_14.setTextureSize(64, 32);
        this.Box_14.mirror = true;
        this.setRotation(this.Box_14, 0.0f, 0.0f, 0.0f);
        this.Box_15 = new ModelRenderer((ModelBase)this, 33, 25);
        this.Box_15.addBox(0.0f, -0.5f, -0.5f, 3, 1, 1);
        this.Box_15.setRotationPoint(1.5f, -26.0f, -2.0f);
        this.Box_15.setTextureSize(64, 32);
        this.Box_15.mirror = true;
        this.setRotation(this.Box_15, 0.7853982f, 0.0f, 0.0f);
    }
    
    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
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
        this.Box_10.render(f5);
        this.Box_11.render(f5);
        this.Box_12.render(f5);
        this.Box_13.render(f5);
        this.Box_14.render(f5);
        this.Box_15.render(f5);
        this.Box_9.render(f5);
	}
}

