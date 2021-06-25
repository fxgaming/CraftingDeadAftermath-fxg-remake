package com.fxg.decoration.model.block;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import org.lwjgl.opengl.GL11;

import com.fxg.decoration.model.IModel;

public class ModelRedlight extends ModelBase implements IModel {
    int x = 0;
    ModelRenderer Box_0;
    ModelRenderer Box_1;
    ModelRenderer Box_2;

    public ModelRedlight() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.Box_0 = new ModelRenderer((ModelBase)this, 1, 1);
        this.Box_0.addBox(0.0f, 0.0f, 0.0f, 4, 16, 4);
        this.Box_0.setRotationPoint(-2.0f, -16.0f, -2.0f);
        this.Box_0.setTextureSize(64, 32);
        this.Box_0.mirror = true;
        this.setRotation(this.Box_0, 0.0f, 0.0f, 0.0f);
        this.Box_1 = new ModelRenderer((ModelBase)this, 25, 1);
        this.Box_1.addBox(0.0f, 0.0f, 0.0f, 5, 6, 5);
        this.Box_1.setRotationPoint(-2.5f, -15.0f, -2.5f);
        this.Box_1.setTextureSize(64, 32);
        this.Box_1.mirror = true;
        this.setRotation(this.Box_1, 0.0f, 0.0f, 0.0f);
        this.Box_2 = new ModelRenderer((ModelBase)this, 41, 9);
        this.Box_2.addBox(0.0f, 0.0f, 0.0f, 5, 2, 5);
        this.Box_2.setRotationPoint(-2.5f, -2.0f, -2.5f);
        this.Box_2.setTextureSize(64, 32);
        this.Box_2.mirror = true;
        this.setRotation(this.Box_2, 0.0f, 0.0f, 0.0f);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

	@Override
	public void render() {
        GL11.glScaled((double)1.3, (double)1.3, (double)1.3);
        this.Box_0.render(f5);
        this.Box_2.render(f5);
        this.Box_1.render(f5);
	}
}

