package com.fxg.decoration.model.block;

import org.lwjgl.opengl.GL11;

import com.fxg.decoration.model.IModel;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelAlarmBell extends ModelBase implements IModel {
    ModelRenderer Part_0;
    ModelRenderer Part_1;
    ModelRenderer Part_2;
    ModelRenderer Part_3;
    ModelRenderer Part_4;
    ModelRenderer Part_5;

    public ModelAlarmBell() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.Part_0 = new ModelRenderer((ModelBase)this, 1, 1);
        this.Part_0.addBox(-0.5f, -23.0f, -0.5f, 1, 23, 1);
        this.Part_0.setRotationPoint(0.0f, 0.0f, 8.0f);
        this.Part_0.setTextureSize(64, 32);
        this.Part_0.mirror = true;
        this.setRotation(this.Part_0, 0.33161256f, 0.0f, 0.0f);
        this.Part_1 = new ModelRenderer((ModelBase)this, 9, 1);
        this.Part_1.addBox(-0.5f, -23.0f, -0.5f, 1, 23, 1);
        this.Part_1.setRotationPoint(0.0f, 0.0f, -8.0f);
        this.Part_1.setTextureSize(64, 32);
        this.Part_1.mirror = true;
        this.setRotation(this.Part_1, -0.33161256f, 0.0f, 0.0f);
        this.Part_2 = new ModelRenderer((ModelBase)this, 17, 1);
        this.Part_2.addBox(-0.5f, -23.0f, -0.5f, 1, 23, 1);
        this.Part_2.setRotationPoint(8.0f, 0.0f, 0.0f);
        this.Part_2.setTextureSize(64, 32);
        this.Part_2.mirror = true;
        this.setRotation(this.Part_2, 0.0f, 0.0f, -0.33161256f);
        this.Part_3 = new ModelRenderer((ModelBase)this, 25, 1);
        this.Part_3.addBox(-0.5f, -23.0f, -0.5f, 1, 23, 1);
        this.Part_3.setRotationPoint(-8.0f, 0.0f, 0.0f);
        this.Part_3.setTextureSize(64, 32);
        this.Part_3.mirror = true;
        this.setRotation(this.Part_3, 0.0f, 0.0f, 0.33161256f);
        this.Part_4 = new ModelRenderer((ModelBase)this, 33, 1);
        this.Part_4.addBox(-0.5f, 0.0f, -0.5f, 1, 19, 1);
        this.Part_4.setRotationPoint(0.0f, -21.5f, 0.0f);
        this.Part_4.setTextureSize(64, 32);
        this.Part_4.mirror = true;
        this.setRotation(this.Part_4, 0.0f, 0.7853982f, 0.0f);
        this.Part_5 = new ModelRenderer((ModelBase)this, 41, 1);
        this.Part_5.addBox(-1.5f, 0.0f, -1.0f, 3, 8, 2);
        this.Part_5.setRotationPoint(0.0f, -13.5f, 0.0f);
        this.Part_5.setTextureSize(64, 32);
        this.Part_5.mirror = true;
        this.setRotation(this.Part_5, 0.0f, 0.7853982f, 0.0f);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

	@Override
	public void render() {
        GL11.glScaled((double)1.2, (double)1.2, (double)1.2);
        GL11.glTranslated((double)0.0, (double)-0.05, (double)0.0);
        GL11.glRotatef((float)90.0f, (float)0.0f, (float)1.0f, (float)0.0f);
        this.Part_0.render(f5);
        this.Part_1.render(f5);
        this.Part_2.render(f5);
        this.Part_3.render(f5);
        this.Part_4.render(f5);
        this.Part_5.render(f5);
	}
}

