package com.fxg.decoration.model.block;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import org.lwjgl.opengl.GL11;

import com.fxg.decoration.model.IModel;

public class ModelElectricBox2 extends ModelBase implements IModel {
    ModelRenderer Part_0;
    ModelRenderer Part_1;
    ModelRenderer Part_2;
    ModelRenderer Part_3;
    ModelRenderer Part_4;
    ModelRenderer Part_5;
    ModelRenderer Part_6;
    ModelRenderer Part_7;
    ModelRenderer Part_8;

    public ModelElectricBox2() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.Part_0 = new ModelRenderer((ModelBase)this, 1, 1);
        this.Part_0.addBox(0.0f, 0.0f, 0.0f, 7, 10, 2);
        this.Part_0.setRotationPoint(-3.0f, -23.0f, 0.0f);
        this.Part_0.setTextureSize(128, 64);
        this.Part_0.mirror = true;
        this.setRotation(this.Part_0, 0.0f, 0.0f, 0.0f);
        this.Part_1 = new ModelRenderer((ModelBase)this, 25, 1);
        this.Part_1.addBox(0.0f, 0.0f, 0.0f, 4, 5, 1);
        this.Part_1.setRotationPoint(-0.5f, -20.5f, 2.5f);
        this.Part_1.setTextureSize(128, 64);
        this.Part_1.mirror = true;
        this.setRotation(this.Part_1, 0.0f, 0.0f, 0.0f);
        this.Part_2 = new ModelRenderer((ModelBase)this, 41, 1);
        this.Part_2.addBox(0.0f, 0.0f, 0.0f, 1, 48, 1);
        this.Part_2.setRotationPoint(-3.0f, -48.0f, 0.0f);
        this.Part_2.setTextureSize(128, 64);
        this.Part_2.mirror = true;
        this.setRotation(this.Part_2, 0.0f, 0.0f, 0.0f);
        this.Part_3 = new ModelRenderer((ModelBase)this, 49, 1);
        this.Part_3.addBox(0.0f, 0.0f, 0.0f, 1, 48, 1);
        this.Part_3.setRotationPoint(-1.0f, -48.0f, 0.0f);
        this.Part_3.setTextureSize(128, 64);
        this.Part_3.mirror = true;
        this.setRotation(this.Part_3, 0.0f, 0.0f, 0.0f);
        this.Part_4 = new ModelRenderer((ModelBase)this, 57, 1);
        this.Part_4.addBox(0.0f, 0.0f, 0.0f, 6, 11, 2);
        this.Part_4.setRotationPoint(-4.5f, -44.0f, 0.0f);
        this.Part_4.setTextureSize(128, 64);
        this.Part_4.mirror = true;
        this.setRotation(this.Part_4, 0.0f, 0.0f, 0.0f);
        this.Part_5 = new ModelRenderer((ModelBase)this, 81, 1);
        this.Part_5.addBox(0.0f, 0.0f, 0.0f, 6, 11, 1);
        this.Part_5.setRotationPoint(-4.5f, -44.0f, 1.75f);
        this.Part_5.setTextureSize(128, 64);
        this.Part_5.mirror = true;
        this.setRotation(this.Part_5, 0.0f, 0.0f, 0.0f);
        this.Part_6 = new ModelRenderer((ModelBase)this, 97, 1);
        this.Part_6.addBox(0.0f, 0.0f, 0.0f, 1, 1, 1);
        this.Part_6.setRotationPoint(-2.5f, -20.0f, 2.0f);
        this.Part_6.setTextureSize(128, 64);
        this.Part_6.mirror = true;
        this.setRotation(this.Part_6, 0.0f, 0.0f, 0.0f);
        this.Part_7 = new ModelRenderer((ModelBase)this, 105, 1);
        this.Part_7.addBox(0.0f, 0.0f, 0.0f, 1, 2, 1);
        this.Part_7.setRotationPoint(-4.0f, -39.0f, 1.75f);
        this.Part_7.setTextureSize(128, 64);
        this.Part_7.mirror = true;
        this.setRotation(this.Part_7, 0.0f, 0.0f, 0.0f);
        this.Part_8 = new ModelRenderer((ModelBase)this, 97, 9);
        this.Part_8.addBox(0.0f, 0.0f, 0.0f, 7, 10, 1);
        this.Part_8.setRotationPoint(-3.0f, -23.0f, 1.75f);
        this.Part_8.setTextureSize(128, 64);
        this.Part_8.mirror = true;
        this.setRotation(this.Part_8, 0.0f, 0.0f, 0.0f);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

	@Override
	public void render() {
        GL11.glRotatef((float)270.0f, (float)0.0f, (float)1.0f, (float)0.0f);
        GL11.glTranslated((double)0.0, (double)0.0, (double)-0.5);
        this.Part_0.render(f5);
        this.Part_1.render(f5);
        this.Part_2.render(f5);
        this.Part_3.render(f5);
        this.Part_4.render(f5);
        this.Part_5.render(f5);
        this.Part_6.render(f5);
        this.Part_7.render(f5);
        this.Part_8.render(f5);
	}
}

