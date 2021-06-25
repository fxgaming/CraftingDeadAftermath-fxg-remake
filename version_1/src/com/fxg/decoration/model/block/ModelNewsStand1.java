package com.fxg.decoration.model.block;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import org.lwjgl.opengl.GL11;

import com.fxg.decoration.model.IModel;

public class ModelNewsStand1 extends ModelBase implements IModel {
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

    public ModelNewsStand1() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.Part_0 = new ModelRenderer((ModelBase)this, 1, 1);
        this.Part_0.addBox(0.0f, 0.0f, 0.0f, 6, 1, 6);
        this.Part_0.setRotationPoint(-3.0f, -1.0f, -3.0f);
        this.Part_0.setTextureSize(128, 64);
        this.Part_0.mirror = true;
        this.setRotation(this.Part_0, 0.0f, 0.0f, 0.0f);
        this.Part_1 = new ModelRenderer((ModelBase)this, 33, 1);
        this.Part_1.addBox(0.0f, 0.0f, 0.0f, 3, 7, 3);
        this.Part_1.setRotationPoint(-1.5f, -8.0f, -1.5f);
        this.Part_1.setTextureSize(128, 64);
        this.Part_1.mirror = true;
        this.setRotation(this.Part_1, 0.0f, 0.0f, 0.0f);
        this.Part_2 = new ModelRenderer((ModelBase)this, 49, 1);
        this.Part_2.addBox(0.0f, 0.0f, 0.0f, 13, 1, 8);
        this.Part_2.setRotationPoint(-6.5f, -12.0f, -4.0f);
        this.Part_2.setTextureSize(128, 64);
        this.Part_2.mirror = true;
        this.setRotation(this.Part_2, 0.0f, 0.0f, 0.0f);
        this.Part_3 = new ModelRenderer((ModelBase)this, 97, 1);
        this.Part_3.addBox(0.0f, 0.0f, 0.0f, 5, 6, 7);
        this.Part_3.setRotationPoint(-6.5f, -18.0f, -3.99f);
        this.Part_3.setTextureSize(128, 64);
        this.Part_3.mirror = true;
        this.setRotation(this.Part_3, 0.0f, 0.0f, 0.0f);
        this.Part_4 = new ModelRenderer((ModelBase)this, 1, 9);
        this.Part_4.addBox(0.0f, 0.0f, 0.0f, 1, 6, 7);
        this.Part_4.setRotationPoint(5.5f, -18.0f, -4.0f);
        this.Part_4.setTextureSize(128, 64);
        this.Part_4.mirror = true;
        this.setRotation(this.Part_4, 0.0f, 0.0f, 0.0f);
        this.Part_5 = new ModelRenderer((ModelBase)this, 25, 17);
        this.Part_5.addBox(0.0f, 0.0f, 0.0f, 11, 6, 1);
        this.Part_5.setRotationPoint(-5.5f, -18.0f, -4.0f);
        this.Part_5.setTextureSize(128, 64);
        this.Part_5.mirror = true;
        this.setRotation(this.Part_5, 0.0f, 0.0f, 0.0f);
        this.Part_6 = new ModelRenderer((ModelBase)this, 57, 17);
        this.Part_6.addBox(0.0f, 0.0f, 0.0f, 13, 1, 7);
        this.Part_6.setRotationPoint(-6.5f, -19.0f, -4.0f);
        this.Part_6.setTextureSize(128, 64);
        this.Part_6.mirror = true;
        this.setRotation(this.Part_6, 0.0f, 0.0f, 0.0f);
        this.Part_7 = new ModelRenderer((ModelBase)this, 49, 1);
        this.Part_7.addBox(0.0f, 0.0f, -1.0f, 1, 6, 1);
        this.Part_7.setRotationPoint(5.51f, -17.94f, 3.0f);
        this.Part_7.setTextureSize(128, 64);
        this.Part_7.mirror = true;
        this.setRotation(this.Part_7, 0.13875368f, 0.0f, 0.0f);
        this.Part_8 = new ModelRenderer((ModelBase)this, 105, 17);
        this.Part_8.addBox(0.0f, 0.0f, -1.0f, 5, 6, 1);
        this.Part_8.setRotationPoint(-6.49f, -17.94f, 3.0f);
        this.Part_8.setTextureSize(128, 64);
        this.Part_8.mirror = true;
        this.setRotation(this.Part_8, 0.13875368f, 0.0f, 0.0f);
        this.Part_9 = new ModelRenderer((ModelBase)this, 1, 25);
        this.Part_9.addBox(0.0f, 0.0f, -1.0f, 7, 6, 1);
        this.Part_9.setRotationPoint(-1.5f, -17.94f, -0.5f);
        this.Part_9.setTextureSize(128, 64);
        this.Part_9.mirror = true;
        this.setRotation(this.Part_9, 0.13875368f, 0.0f, 0.0f);
        this.Part_10 = new ModelRenderer((ModelBase)this, 25, 25);
        this.Part_10.addBox(0.0f, 0.0f, 0.0f, 11, 1, 1);
        this.Part_10.setRotationPoint(-5.51f, -8.0f, 3.01f);
        this.Part_10.setTextureSize(128, 64);
        this.Part_10.mirror = true;
        this.setRotation(this.Part_10, 0.08726646f, 0.0f, 0.0f);
        this.Part_11 = new ModelRenderer((ModelBase)this, 1, 33);
        this.Part_11.addBox(0.0f, 0.0f, 0.0f, 11, 3, 8);
        this.Part_11.setRotationPoint(-5.5f, -11.0f, -4.0f);
        this.Part_11.setTextureSize(128, 64);
        this.Part_11.mirror = true;
        this.setRotation(this.Part_11, 0.0f, 0.0f, 0.0f);
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
	}
}

