package com.fxg.decoration.model.block;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import org.lwjgl.opengl.GL11;

import com.fxg.decoration.model.IModel;

public class ModelStreetLightMiddle extends ModelBase implements IModel {
    ModelRenderer Part_0;
    ModelRenderer Part_1;
    ModelRenderer Part_2;
    ModelRenderer Part_3;
    ModelRenderer Part_4;
    ModelRenderer Part_5;
    ModelRenderer Part_6;
    ModelRenderer Part_7;
    ModelRenderer Part_8;
    ModelRenderer Part_9;
    ModelRenderer Part_10;
    ModelRenderer Part_11;
    ModelRenderer Part_12;
    ModelRenderer Part_13;

    public ModelStreetLightMiddle() {
        this.textureWidth = 256;
        this.textureHeight = 128;
        this.Part_0 = new ModelRenderer((ModelBase)this, 1, 1);
        this.Part_0.addBox(0.0f, 0.0f, 0.0f, 2, 96, 2);
        this.Part_0.setRotationPoint(-1.0f, -96.0f, -1.0f);
        this.Part_0.setTextureSize(256, 128);
        this.Part_0.mirror = true;
        this.setRotation(this.Part_0, 0.0f, 0.0f, 0.0f);
        this.Part_1 = new ModelRenderer((ModelBase)this, 17, 1);
        this.Part_1.addBox(0.0f, 0.0f, 0.0f, 3, 15, 3);
        this.Part_1.setRotationPoint(-1.5f, -96.5f, -1.5f);
        this.Part_1.setTextureSize(256, 128);
        this.Part_1.mirror = true;
        this.setRotation(this.Part_1, 0.0f, 0.0f, 0.0f);
        this.Part_2 = new ModelRenderer((ModelBase)this, 33, 1);
        this.Part_2.addBox(0.0f, -6.0f, 0.0f, 1, 9, 2);
        this.Part_2.setRotationPoint(-0.5f, -99.5f, -1.0f);
        this.Part_2.setTextureSize(256, 128);
        this.Part_2.mirror = true;
        this.setRotation(this.Part_2, 0.0f, 0.0f, 0.08726646f);
        this.Part_3 = new ModelRenderer((ModelBase)this, 249, 1);
        this.Part_3.addBox(0.0f, -24.0f, 0.0f, 1, 24, 2);
        this.Part_3.setRotationPoint(0.05f, -105.5f, -1.01f);
        this.Part_3.setTextureSize(256, 128);
        this.Part_3.mirror = true;
        this.setRotation(this.Part_3, 0.0f, 0.0f, 0.7853982f);
        this.Part_4 = new ModelRenderer((ModelBase)this, 41, 1);
        this.Part_4.addBox(0.0f, -20.0f, 0.0f, 1, 20, 2);
        this.Part_4.setRotationPoint(17.05f, -122.5f, -1.0f);
        this.Part_4.setTextureSize(256, 128);
        this.Part_4.mirror = true;
        this.setRotation(this.Part_4, 0.0f, 0.0f, 1.4835298f);
        this.Part_5 = new ModelRenderer((ModelBase)this, 49, 1);
        this.Part_5.addBox(-1.0f, -23.0f, -1.0f, 3, 5, 4);
        this.Part_5.setRotationPoint(17.05f, -122.5f, -1.0f);
        this.Part_5.setTextureSize(256, 128);
        this.Part_5.mirror = true;
        this.setRotation(this.Part_5, 0.0f, 0.0f, 1.4835298f);
        this.Part_6 = new ModelRenderer((ModelBase)this, 65, 1);
        this.Part_6.addBox(-1.0f, -24.0f, -0.5f, 3, 1, 3);
        this.Part_6.setRotationPoint(17.05f, -122.5f, -1.0f);
        this.Part_6.setTextureSize(256, 128);
        this.Part_6.mirror = true;
        this.setRotation(this.Part_6, 0.0f, 0.0f, 1.4835298f);
        this.Part_7 = new ModelRenderer((ModelBase)this, 81, 1);
        this.Part_7.addBox(2.5f, -22.5f, -0.5f, 1, 4, 3);
        this.Part_7.setRotationPoint(17.05f, -123.5f, -1.0f);
        this.Part_7.setTextureSize(256, 128);
        this.Part_7.mirror = true;
        this.setRotation(this.Part_7, 0.0f, 0.0f, 1.4835298f);
        this.Part_8 = new ModelRenderer((ModelBase)this, 33, 1);
        this.Part_8.addBox(-1.0f, -6.0f, 0.0f, 1, 9, 2);
        this.Part_8.setRotationPoint(0.5f, -99.5f, -1.01f);
        this.Part_8.setTextureSize(256, 128);
        this.Part_8.mirror = true;
        this.setRotation(this.Part_8, 0.0f, 0.0f, -0.08726646f);
        this.Part_9 = new ModelRenderer((ModelBase)this, 249, 1);
        this.Part_9.addBox(-1.0f, -24.0f, 0.0f, 1, 24, 2);
        this.Part_9.setRotationPoint(0.05f, -105.5f, -1.02f);
        this.Part_9.setTextureSize(256, 128);
        this.Part_9.mirror = true;
        this.setRotation(this.Part_9, 0.0f, 0.0f, -0.7853982f);
        this.Part_10 = new ModelRenderer((ModelBase)this, 41, 1);
        this.Part_10.addBox(-1.0f, -20.0f, 0.0f, 1, 20, 2);
        this.Part_10.setRotationPoint(-16.95f, -122.5f, -1.0f);
        this.Part_10.setTextureSize(256, 128);
        this.Part_10.mirror = true;
        this.setRotation(this.Part_10, 0.0f, 0.0f, -1.4835298f);
        this.Part_11 = new ModelRenderer((ModelBase)this, 49, 1);
        this.Part_11.addBox(-0.25f, -23.0f, -1.0f, 3, 5, 4);
        this.Part_11.setRotationPoint(-18.95f, -121.0f, -1.0f);
        this.Part_11.setTextureSize(256, 128);
        this.Part_11.mirror = true;
        this.setRotation(this.Part_11, 0.0f, 0.0f, -1.4835298f);
        this.Part_12 = new ModelRenderer((ModelBase)this, 65, 1);
        this.Part_12.addBox(-0.25f, -24.0f, -0.5f, 3, 1, 3);
        this.Part_12.setRotationPoint(-18.95f, -121.0f, -1.0f);
        this.Part_12.setTextureSize(256, 128);
        this.Part_12.mirror = true;
        this.setRotation(this.Part_12, 0.0f, 0.0f, -1.4835298f);
        this.Part_13 = new ModelRenderer((ModelBase)this, 81, 1);
        this.Part_13.addBox(0.75f, -23.0f, -0.5f, 1, 4, 3);
        this.Part_13.setRotationPoint(-18.95f, -119.5f, -1.0f);
        this.Part_13.setTextureSize(256, 128);
        this.Part_13.mirror = true;
        this.setRotation(this.Part_13, 0.0f, 0.0f, -1.4835298f);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

	@Override
	public void render() {
        GL11.glRotatef((float)180.0f, (float)0.0f, (float)1.0f, (float)0.0f);
        this.Part_0.render(f5);
        this.Part_1.render(f5);
        this.Part_2.render(f5);
        this.Part_3.render(f5);
        this.Part_4.render(f5);
        this.Part_5.render(f5);
        this.Part_6.render(f5);
        this.Part_7.render(f5);
        this.Part_8.render(f5);
        this.Part_9.render(f5);
        this.Part_10.render(f5);
        this.Part_11.render(f5);
        this.Part_12.render(f5);
        this.Part_13.render(f5);
	}
}

