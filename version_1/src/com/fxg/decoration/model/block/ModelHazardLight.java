package com.fxg.decoration.model.block;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import org.lwjgl.opengl.GL11;

import com.fxg.decoration.model.IModel;

public class ModelHazardLight extends ModelBase implements IModel {
    int x = 0;
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

    public ModelHazardLight() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.Box_1 = new ModelRenderer((ModelBase)this, 1, 1);
        this.Box_1.addBox(0.0f, 0.0f, 0.0f, 1, 6, 1);
        this.Box_1.setRotationPoint(7.0f, -6.0f, 7.0f);
        this.Box_1.setTextureSize(64, 32);
        this.Box_1.mirror = true;
        this.setRotation(this.Box_1, 0.0f, 0.0f, 0.0f);
        this.Box_2 = new ModelRenderer((ModelBase)this, 9, 1);
        this.Box_2.addBox(0.0f, 0.0f, 0.0f, 1, 6, 1);
        this.Box_2.setRotationPoint(7.0f, -6.0f, -8.0f);
        this.Box_2.setTextureSize(64, 32);
        this.Box_2.mirror = true;
        this.setRotation(this.Box_2, 0.0f, 0.0f, 0.0f);
        this.Box_3 = new ModelRenderer((ModelBase)this, 17, 1);
        this.Box_3.addBox(0.0f, 0.0f, 0.0f, 1, 6, 1);
        this.Box_3.setRotationPoint(-8.0f, -6.0f, -8.0f);
        this.Box_3.setTextureSize(64, 32);
        this.Box_3.mirror = true;
        this.setRotation(this.Box_3, 0.0f, 0.0f, 0.0f);
        this.Box_4 = new ModelRenderer((ModelBase)this, 25, 1);
        this.Box_4.addBox(0.0f, 0.0f, 0.0f, 1, 6, 1);
        this.Box_4.setRotationPoint(-8.0f, -6.0f, 7.0f);
        this.Box_4.setTextureSize(64, 32);
        this.Box_4.mirror = true;
        this.setRotation(this.Box_4, 0.0f, 0.0f, 0.0f);
        this.Box_5 = new ModelRenderer((ModelBase)this, 17, 1);
        this.Box_5.addBox(0.0f, 0.0f, 0.0f, 14, 9, 14);
        this.Box_5.setRotationPoint(-7.0f, -12.0f, -7.0f);
        this.Box_5.setTextureSize(64, 32);
        this.Box_5.mirror = true;
        this.setRotation(this.Box_5, 0.0f, 0.0f, 0.0f);
        this.Box_6 = new ModelRenderer((ModelBase)this, 1, 25);
        this.Box_6.addBox(0.0f, 0.0f, 0.0f, 16, 1, 16);
        this.Box_6.setRotationPoint(-8.0f, -7.0f, -8.0f);
        this.Box_6.setTextureSize(64, 32);
        this.Box_6.mirror = true;
        this.setRotation(this.Box_6, 0.0f, 0.0f, 0.0f);
        this.Box_7 = new ModelRenderer((ModelBase)this, 81, 1);
        this.Box_7.addBox(0.0f, 0.0f, 0.0f, 1, 25, 1);
        this.Box_7.setRotationPoint(-0.5f, -37.0f, -0.5f);
        this.Box_7.setTextureSize(64, 32);
        this.Box_7.mirror = true;
        this.setRotation(this.Box_7, 0.0f, 0.0f, 0.0f);
        this.Box_8 = new ModelRenderer((ModelBase)this, 89, 1);
        this.Box_8.addBox(-8.0f, 0.0f, 0.0f, 16, 1, 2);
        this.Box_8.setRotationPoint(-0.5f, -38.0f, -0.5f);
        this.Box_8.setTextureSize(64, 32);
        this.Box_8.mirror = true;
        this.setRotation(this.Box_8, -0.3839724f, 0.7853982f, 0.0f);
        this.Box_9 = new ModelRenderer((ModelBase)this, 65, 1);
        this.Box_9.addBox(-8.0f, 0.0f, 0.0f, 5, 4, 2);
        this.Box_9.setRotationPoint(0.5f, -39.0f, 1.5f);
        this.Box_9.setTextureSize(64, 32);
        this.Box_9.mirror = true;
        this.setRotation(this.Box_9, -0.3839724f, 0.7853982f, 0.0f);
        this.Box_10 = new ModelRenderer((ModelBase)this, 1, 9);
        this.Box_10.addBox(-8.0f, 0.0f, 0.0f, 5, 4, 2);
        this.Box_10.setRotationPoint(9.5f, -39.0f, -7.5f);
        this.Box_10.setTextureSize(64, 32);
        this.Box_10.mirror = true;
        this.setRotation(this.Box_10, -0.3839724f, 0.7853982f, 0.0f);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

	@Override
	public void render() {
        GL11.glRotatef((float)270.0f, (float)0.0f, (float)1.0f, (float)0.0f);
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
	}
}

