package com.fxg.decoration.model.block;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import org.lwjgl.opengl.GL11;

import com.fxg.decoration.model.IModel;

public class ModelMonitor extends ModelBase implements IModel {
    ModelRenderer Part_0;
    ModelRenderer Part_1;
    ModelRenderer Part_2;
    ModelRenderer Part_3;
    ModelRenderer Part_4;
    ModelRenderer Part_5;
    ModelRenderer Part_6;
    ModelRenderer Part_7;

    public ModelMonitor() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.Part_0 = new ModelRenderer((ModelBase)this, 1, 1);
        this.Part_0.addBox(0.0f, 0.0f, 0.0f, 12, 1, 6);
        this.Part_0.setRotationPoint(-6.0f, -1.0f, -3.0f);
        this.Part_0.setTextureSize(64, 64);
        this.Part_0.mirror = true;
        this.setRotation(this.Part_0, 0.0f, 0.0f, 0.0f);
        this.Part_1 = new ModelRenderer((ModelBase)this, 33, 1);
        this.Part_1.addBox(0.0f, 0.0f, 0.0f, 2, 1, 2);
        this.Part_1.setRotationPoint(-1.0f, -2.0f, -1.0f);
        this.Part_1.setTextureSize(64, 64);
        this.Part_1.mirror = true;
        this.setRotation(this.Part_1, 0.0f, 0.0f, 0.0f);
        this.Part_2 = new ModelRenderer((ModelBase)this, 1, 9);
        this.Part_2.addBox(0.0f, 0.0f, 0.0f, 16, 14, 7);
        this.Part_2.setRotationPoint(-8.0f, -16.0f, -4.0f);
        this.Part_2.setTextureSize(64, 64);
        this.Part_2.mirror = true;
        this.setRotation(this.Part_2, 0.0f, 0.0f, 0.0f);
        this.Part_3 = new ModelRenderer((ModelBase)this, 1, 33);
        this.Part_3.addBox(0.0f, 0.0f, 0.0f, 14, 11, 4);
        this.Part_3.setRotationPoint(-7.0f, -14.0f, -8.0f);
        this.Part_3.setTextureSize(64, 64);
        this.Part_3.mirror = true;
        this.setRotation(this.Part_3, 0.0f, 0.0f, 0.0f);
        this.Part_4 = new ModelRenderer((ModelBase)this, 49, 1);
        this.Part_4.addBox(0.0f, 0.0f, 0.0f, 2, 14, 1);
        this.Part_4.setRotationPoint(-8.0f, -16.0f, 3.0f);
        this.Part_4.setTextureSize(64, 64);
        this.Part_4.mirror = true;
        this.setRotation(this.Part_4, 0.0f, 0.0f, 0.0f);
        this.Part_5 = new ModelRenderer((ModelBase)this, 57, 1);
        this.Part_5.addBox(0.0f, 0.0f, 0.0f, 2, 14, 1);
        this.Part_5.setRotationPoint(6.0f, -16.0f, 3.0f);
        this.Part_5.setTextureSize(64, 64);
        this.Part_5.mirror = true;
        this.setRotation(this.Part_5, 0.0f, 0.0f, 0.0f);
        this.Part_6 = new ModelRenderer((ModelBase)this, 1, 49);
        this.Part_6.addBox(0.0f, 0.0f, 0.0f, 12, 2, 1);
        this.Part_6.setRotationPoint(-6.0f, -16.0f, 3.0f);
        this.Part_6.setTextureSize(64, 64);
        this.Part_6.mirror = true;
        this.setRotation(this.Part_6, 0.0f, 0.0f, 0.0f);
        this.Part_7 = new ModelRenderer((ModelBase)this, 33, 49);
        this.Part_7.addBox(0.0f, 0.0f, 0.0f, 12, 2, 1);
        this.Part_7.setRotationPoint(-6.0f, -4.0f, 3.0f);
        this.Part_7.setTextureSize(64, 64);
        this.Part_7.mirror = true;
        this.setRotation(this.Part_7, 0.0f, 0.0f, 0.0f);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

	@Override
	public void render() {
        GL11.glRotated((double)-90.0, (double)0.0, (double)1.0, (double)0.0);
        this.Part_0.render(f5);
        this.Part_1.render(f5);
        this.Part_2.render(f5);
        this.Part_3.render(f5);
        this.Part_4.render(f5);
        this.Part_5.render(f5);
        this.Part_6.render(f5);
        this.Part_7.render(f5);
	}
}

