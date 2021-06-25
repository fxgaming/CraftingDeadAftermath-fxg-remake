package com.fxg.decoration.model.block;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import org.lwjgl.opengl.GL11;

import com.fxg.decoration.model.IModel;

public class ModelSkeletonWall extends ModelBase implements IModel {
    ModelRenderer Part_0;
    ModelRenderer Part_1;
    ModelRenderer Part_2;
    ModelRenderer Part_3;
    ModelRenderer Part_4;
    ModelRenderer Part_5;

    public ModelSkeletonWall() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.Part_0 = new ModelRenderer((ModelBase)this, 0, 0);
        this.Part_0.addBox(0.0f, 0.0f, 0.0f, 8, 8, 8);
        this.Part_0.setRotationPoint(-4.0f, -5.01f, 12.0f);
        this.Part_0.setTextureSize(64, 32);
        this.Part_0.mirror = true;
        this.setRotation(this.Part_0, -0.6981317f, 0.03490659f, -0.01745329f);
        this.Part_1 = new ModelRenderer((ModelBase)this, 40, 16);
        this.Part_1.addBox(0.0f, 0.0f, 0.0f, 2, 12, 2);
        this.Part_1.setRotationPoint(-5.5f, 5.99f, 10.0f);
        this.Part_1.setTextureSize(64, 32);
        this.Part_1.mirror = true;
        this.setRotation(this.Part_1, 0.5934119f, -0.2617994f, 0.0f);
        this.Part_2 = new ModelRenderer((ModelBase)this, 40, 16);
        this.Part_2.addBox(0.0f, 0.0f, 0.0f, 2, 12, 2);
        this.Part_2.setRotationPoint(3.5f, 5.99f, 9.0f);
        this.Part_2.setTextureSize(64, 32);
        this.Part_2.mirror = true;
        this.setRotation(this.Part_2, 0.5934119f, 0.2617994f, 0.0f);
        this.Part_3 = new ModelRenderer((ModelBase)this, 16, 16);
        this.Part_3.addBox(0.0f, 0.0f, 0.0f, 8, 12, 4);
        this.Part_3.setRotationPoint(-4.0f, 3.99f, 8.0f);
        this.Part_3.setTextureSize(64, 32);
        this.Part_3.mirror = true;
        this.setRotation(this.Part_3, 0.0f, 0.0f, 0.0f);
        this.Part_4 = new ModelRenderer((ModelBase)this, 0, 16);
        this.Part_4.addBox(0.0f, 0.0f, 0.0f, 2, 12, 2);
        this.Part_4.setRotationPoint(-3.0f, 15.99f, 11.0f);
        this.Part_4.setTextureSize(64, 32);
        this.Part_4.mirror = true;
        this.setRotation(this.Part_4, 1.5358897f, -0.17453294f, 0.0f);
        this.Part_5 = new ModelRenderer((ModelBase)this, 0, 16);
        this.Part_5.addBox(0.0f, 0.0f, 0.0f, 2, 12, 2);
        this.Part_5.setRotationPoint(1.0f, 15.99f, 11.0f);
        this.Part_5.setTextureSize(64, 32);
        this.Part_5.mirror = true;
        this.setRotation(this.Part_5, 1.553343f, 0.08726646f, 0.0f);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

	@Override
	public void render() {
        GL11.glTranslated((double)1.0, (double)-1.0, (double)0.0);
        GL11.glRotatef((float)270.0f, (float)0.0f, (float)1.0f, (float)0.0f);
        this.Part_0.render(f5);
        this.Part_1.render(f5);
        this.Part_2.render(f5);
        this.Part_3.render(f5);
        this.Part_4.render(f5);
        this.Part_5.render(f5);
	}
}

