package com.fxg.decoration.model.block;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import org.lwjgl.opengl.GL11;

import com.fxg.decoration.model.IModel;

public class ModelVendingMachine extends ModelBase implements IModel {
    int x = 0;
    ModelRenderer Part_0;
    ModelRenderer Part_1;
    ModelRenderer Part_2;
    ModelRenderer Part_3;
    ModelRenderer Part_4;
    ModelRenderer Part_5;

    public ModelVendingMachine() {
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.Part_0 = new ModelRenderer((ModelBase)this, 1, 1);
        this.Part_0.addBox(-8.0f, 0.0f, -8.0f, 16, 8, 16);
        this.Part_0.setRotationPoint(0.0f, -8.0f, 0.0f);
        this.Part_0.setTextureSize(128, 128);
        this.Part_0.mirror = true;
        this.setRotation(this.Part_0, 0.0f, 0.0f, 0.0f);
        this.Part_1 = new ModelRenderer((ModelBase)this, 57, 1);
        this.Part_1.addBox(-8.0f, 0.0f, -8.0f, 14, 6, 1);
        this.Part_1.setRotationPoint(1.0f, -7.0f, 15.5f);
        this.Part_1.setTextureSize(128, 128);
        this.Part_1.mirror = true;
        this.setRotation(this.Part_1, 0.0f, 0.0f, 0.0f);
        this.Part_2 = new ModelRenderer((ModelBase)this, 57, 17);
        this.Part_2.addBox(-8.0f, 0.0f, -8.0f, 14, 24, 15);
        this.Part_2.setRotationPoint(1.0f, -32.0f, 0.0f);
        this.Part_2.setTextureSize(128, 128);
        this.Part_2.mirror = true;
        this.setRotation(this.Part_2, 0.0f, 0.0f, 0.0f);
        this.Part_3 = new ModelRenderer((ModelBase)this, 1, 33);
        this.Part_3.addBox(-8.0f, 0.0f, -8.0f, 1, 24, 16);
        this.Part_3.setRotationPoint(0.0f, -32.0f, 0.0f);
        this.Part_3.setTextureSize(128, 128);
        this.Part_3.mirror = true;
        this.setRotation(this.Part_3, 0.0f, 0.0f, 0.0f);
        this.Part_4 = new ModelRenderer((ModelBase)this, 41, 57);
        this.Part_4.addBox(-8.0f, 0.0f, -8.0f, 1, 24, 16);
        this.Part_4.setRotationPoint(15.0f, -32.0f, 0.0f);
        this.Part_4.setTextureSize(128, 128);
        this.Part_4.mirror = true;
        this.setRotation(this.Part_4, 0.0f, 0.0f, 0.0f);
        this.Part_5 = new ModelRenderer((ModelBase)this, 1, 105);
        this.Part_5.addBox(-8.0f, 0.0f, -8.0f, 16, 5, 16);
        this.Part_5.setRotationPoint(0.0f, -37.0f, 0.0f);
        this.Part_5.setTextureSize(128, 128);
        this.Part_5.mirror = true;
        this.setRotation(this.Part_5, 0.0f, 0.0f, 0.0f);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

	@Override
	public void render() {
        GL11.glRotatef((float)-90.0f, (float)0.0f, (float)1.0f, (float)0.0f);
        this.Part_0.render(f5);
        this.Part_1.render(f5);
        this.Part_2.render(f5);
        this.Part_3.render(f5);
        this.Part_4.render(f5);
        this.Part_5.render(f5);
	}
}

