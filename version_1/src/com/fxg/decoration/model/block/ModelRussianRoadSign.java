package com.fxg.decoration.model.block;

import org.lwjgl.opengl.GL11;

import com.fxg.decoration.model.IModel;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

public class ModelRussianRoadSign extends ModelBase implements IModel {
    public final int color;
    int x = 0;
    ModelRenderer Part_0;
    ModelRenderer Part_1;
    ModelRenderer Part_2;

    public ModelRussianRoadSign(int givenColor) {
        this.color = givenColor;
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.Part_0 = new ModelRenderer((ModelBase)this, 1, 1);
        this.Part_0.addBox(-0.5f, 0.0f, -0.5f, 1, 32, 1);
        this.Part_0.setRotationPoint(-0.01f, -32.0f, -14.0f);
        this.Part_0.setTextureSize(64, 64);
        this.Part_0.mirror = true;
        this.setRotation(this.Part_0, 0.0f, 0.0f, 0.0f);
        this.Part_1 = new ModelRenderer((ModelBase)this, 9, 1);
        this.Part_1.addBox(-0.5f, 0.0f, -0.5f, 1, 32, 1);
        this.Part_1.setRotationPoint(-0.01f, -32.0f, 14.0f);
        this.Part_1.setTextureSize(64, 64);
        this.Part_1.mirror = true;
        this.setRotation(this.Part_1, 0.0f, 0.0f, 0.0f);
        this.Part_2 = new ModelRenderer((ModelBase)this, 1, 9);
        this.Part_2.addBox(-0.5f, 0.0f, -0.5f, 0, 9, 31);
        this.Part_2.setRotationPoint(1.0f, -30.0f, -15.0f);
        this.Part_2.setTextureSize(64, 64);
        this.Part_2.mirror = true;
        this.setRotation(this.Part_2, 0.0f, 0.0f, 0.0f);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

	@Override
	public void render() {
        GL11.glRotated((double)180.0, (double)0.0, (double)1.0, (double)0.0);
        this.Part_0.render(f5);
        this.Part_1.render(f5);
        this.Part_2.render(f5);
	}
}

