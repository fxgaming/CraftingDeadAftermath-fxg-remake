package com.fxg.decoration.model.block;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import org.lwjgl.opengl.GL11;

import com.fxg.decoration.model.IModel;

public class ModelNewsStand2 extends ModelBase implements IModel {
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
    ModelRenderer Part_14;

    public ModelNewsStand2() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.Part_0 = new ModelRenderer((ModelBase)this, 1, 1);
        this.Part_0.addBox(0.0f, 0.0f, 0.0f, 16, 1, 10);
        this.Part_0.setRotationPoint(-8.0f, -1.0f, -5.0f);
        this.Part_0.setTextureSize(128, 64);
        this.Part_0.mirror = true;
        this.setRotation(this.Part_0, 0.0f, 0.0f, 0.0f);
        this.Part_1 = new ModelRenderer((ModelBase)this, 57, 1);
        this.Part_1.addBox(0.0f, 0.0f, 0.0f, 3, 13, 3);
        this.Part_1.setRotationPoint(-1.5f, -14.0f, -1.5f);
        this.Part_1.setTextureSize(128, 64);
        this.Part_1.mirror = true;
        this.setRotation(this.Part_1, 0.0f, 0.0f, 0.0f);
        this.Part_2 = new ModelRenderer((ModelBase)this, 73, 1);
        this.Part_2.addBox(0.0f, 0.0f, 0.0f, 13, 1, 8);
        this.Part_2.setRotationPoint(-6.5f, -15.0f, -4.0f);
        this.Part_2.setTextureSize(128, 64);
        this.Part_2.mirror = true;
        this.setRotation(this.Part_2, 0.0f, 0.0f, 0.0f);
        this.Part_3 = new ModelRenderer((ModelBase)this, 1, 17);
        this.Part_3.addBox(0.0f, 0.0f, 0.0f, 1, 7, 7);
        this.Part_3.setRotationPoint(-6.5f, -22.0f, -4.0f);
        this.Part_3.setTextureSize(128, 64);
        this.Part_3.mirror = true;
        this.setRotation(this.Part_3, 0.0f, 0.0f, 0.0f);
        this.Part_4 = new ModelRenderer((ModelBase)this, 25, 17);
        this.Part_4.addBox(0.0f, 0.0f, 0.0f, 1, 7, 7);
        this.Part_4.setRotationPoint(5.5f, -22.0f, -4.0f);
        this.Part_4.setTextureSize(128, 64);
        this.Part_4.mirror = true;
        this.setRotation(this.Part_4, 0.0f, 0.0f, 0.0f);
        this.Part_5 = new ModelRenderer((ModelBase)this, 73, 17);
        this.Part_5.addBox(0.0f, 0.0f, 0.0f, 11, 7, 1);
        this.Part_5.setRotationPoint(-5.5f, -22.0f, -4.0f);
        this.Part_5.setTextureSize(128, 64);
        this.Part_5.mirror = true;
        this.setRotation(this.Part_5, 0.0f, 0.0f, 0.0f);
        this.Part_6 = new ModelRenderer((ModelBase)this, 1, 33);
        this.Part_6.addBox(0.0f, 0.0f, 0.0f, 13, 1, 7);
        this.Part_6.setRotationPoint(-6.5f, -23.0f, -4.0f);
        this.Part_6.setTextureSize(128, 64);
        this.Part_6.mirror = true;
        this.setRotation(this.Part_6, 0.0f, 0.0f, 0.0f);
        this.Part_7 = new ModelRenderer((ModelBase)this, 1, 1);
        this.Part_7.addBox(0.0f, 0.0f, -1.0f, 1, 7, 1);
        this.Part_7.setRotationPoint(5.51f, -21.94f, 3.0f);
        this.Part_7.setTextureSize(128, 64);
        this.Part_7.mirror = true;
        this.setRotation(this.Part_7, 0.13875368f, 0.0f, 0.0f);
        this.Part_8 = new ModelRenderer((ModelBase)this, 49, 1);
        this.Part_8.addBox(0.0f, 0.0f, -1.0f, 1, 7, 1);
        this.Part_8.setRotationPoint(-6.49f, -21.94f, 3.0f);
        this.Part_8.setTextureSize(128, 64);
        this.Part_8.mirror = true;
        this.setRotation(this.Part_8, 0.13875368f, 0.0f, 0.0f);
        this.Part_9 = new ModelRenderer((ModelBase)this, 49, 25);
        this.Part_9.addBox(0.0f, 0.0f, -1.0f, 11, 7, 1);
        this.Part_9.setRotationPoint(-5.5f, -21.94f, 2.5f);
        this.Part_9.setTextureSize(128, 64);
        this.Part_9.mirror = true;
        this.setRotation(this.Part_9, 0.13875368f, 0.0f, 0.0f);
        this.Part_10 = new ModelRenderer((ModelBase)this, 113, 1);
        this.Part_10.addBox(0.15f, 0.25f, -0.8f, 5, 6, 1);
        this.Part_10.setRotationPoint(-2.5f, -22.0f, 2.5f);
        this.Part_10.setTextureSize(128, 64);
        this.Part_10.mirror = true;
        this.setRotation(this.Part_10, 0.13875368f, 0.0f, 0.08726646f);
        this.Part_11 = new ModelRenderer((ModelBase)this, 113, 9);
        this.Part_11.addBox(0.0f, 0.0f, 0.0f, 1, 4, 3);
        this.Part_11.setRotationPoint(-3.5f, -14.0f, -1.52f);
        this.Part_11.setTextureSize(128, 64);
        this.Part_11.mirror = true;
        this.setRotation(this.Part_11, 0.0f, 0.0f, -0.54105204f);
        this.Part_12 = new ModelRenderer((ModelBase)this, 49, 17);
        this.Part_12.addBox(-1.0f, 0.0f, 0.0f, 1, 4, 3);
        this.Part_12.setRotationPoint(3.5f, -14.0f, -1.52f);
        this.Part_12.setTextureSize(128, 64);
        this.Part_12.mirror = true;
        this.setRotation(this.Part_12, 0.0f, 0.0f, 0.54105204f);
        this.Part_13 = new ModelRenderer((ModelBase)this, 97, 25);
        this.Part_13.addBox(0.0f, 0.0f, 0.0f, 13, 1, 1);
        this.Part_13.setRotationPoint(-6.51f, -14.0f, 3.01f);
        this.Part_13.setTextureSize(128, 64);
        this.Part_13.mirror = true;
        this.setRotation(this.Part_13, 0.08726646f, 0.0f, 0.0f);
        this.Part_14 = new ModelRenderer((ModelBase)this, 73, 33);
        this.Part_14.addBox(0.0f, 0.0f, 0.0f, 12, 1, 6);
        this.Part_14.setRotationPoint(-6.0f, -23.5f, -3.5f);
        this.Part_14.setTextureSize(128, 64);
        this.Part_14.mirror = true;
        this.setRotation(this.Part_14, 0.0f, 0.0f, 0.0f);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

	@Override
	public void render() {
        GL11.glRotatef((float)270.0f, (float)0.0f, (float)1.0f, (float)0.0f);
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
        this.Part_14.render(f5);
	}
}

