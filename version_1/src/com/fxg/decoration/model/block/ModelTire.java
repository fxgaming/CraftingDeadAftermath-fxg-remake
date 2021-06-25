package com.fxg.decoration.model.block;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import org.lwjgl.opengl.GL11;

import com.fxg.decoration.model.IModel;

public class ModelTire extends ModelBase implements IModel {
    ModelRenderer Part_0;
    ModelRenderer Part_1;

    public ModelTire() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.Part_0 = new ModelRenderer((ModelBase)this, 1, 1);
        this.Part_0.addBox(0.0f, -7.5f, -7.5f, 5, 15, 15);
        this.Part_0.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Part_0.setTextureSize(64, 64);
        this.Part_0.mirror = true;
        this.setRotation(this.Part_0, 0.0f, 0.9250245f, -1.5707964f);
        this.Part_1 = new ModelRenderer((ModelBase)this, 33, 25);
        this.Part_1.addBox(4.25f, -5.0f, -5.0f, 1, 10, 10);
        this.Part_1.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Part_1.setTextureSize(64, 64);
        this.Part_1.mirror = true;
        this.setRotation(this.Part_1, 0.0f, 0.9250245f, -1.5707964f);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

	@Override
	public void render() {
        GL11.glRotatef((float)-52.0f, (float)1.0f, (float)0.0f, (float)0.0f);
        this.Part_0.render(f5);
        this.Part_1.render(f5);
	}
}

