package com.fxg.decoration.model.block;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import org.lwjgl.opengl.GL11;

import com.fxg.decoration.model.IModel;

public class ModelChair extends ModelBase implements IModel {
    int x = 0;
    ModelRenderer Box_0;
    ModelRenderer Box_1;
    ModelRenderer Box_2;
    ModelRenderer Box_3;
    ModelRenderer Box_4;
    ModelRenderer Box_5;
    ModelRenderer Box_6;
    ModelRenderer Box_7;
    ModelRenderer Box_8;
    ModelRenderer Box_9;

    public ModelChair() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.Box_0 = new ModelRenderer((ModelBase)this, 1, 1);
        this.Box_0.addBox(0.0f, 0.0f, 0.0f, 1, 11, 1);
        this.Box_0.setRotationPoint(5.0f, -11.0f, 5.0f);
        this.Box_0.setTextureSize(64, 32);
        this.Box_0.mirror = true;
        this.setRotation(this.Box_0, 0.0f, 0.0f, 0.0f);
        this.Box_1 = new ModelRenderer((ModelBase)this, 9, 1);
        this.Box_1.addBox(0.0f, 0.0f, 0.0f, 1, 11, 1);
        this.Box_1.setRotationPoint(5.0f, -11.0f, -6.0f);
        this.Box_1.setTextureSize(64, 32);
        this.Box_1.mirror = true;
        this.setRotation(this.Box_1, 0.0f, 0.0f, 0.0f);
        this.Box_2 = new ModelRenderer((ModelBase)this, 17, 1);
        this.Box_2.addBox(0.0f, 0.0f, 0.0f, 1, 24, 1);
        this.Box_2.setRotationPoint(-6.0f, -24.0f, -6.0f);
        this.Box_2.setTextureSize(64, 32);
        this.Box_2.mirror = true;
        this.setRotation(this.Box_2, 0.0f, 0.0f, 0.0f);
        this.Box_3 = new ModelRenderer((ModelBase)this, 25, 1);
        this.Box_3.addBox(0.0f, 0.0f, 0.0f, 1, 24, 1);
        this.Box_3.setRotationPoint(-6.0f, -24.0f, 5.0f);
        this.Box_3.setTextureSize(64, 32);
        this.Box_3.mirror = true;
        this.setRotation(this.Box_3, 0.0f, 0.0f, 0.0f);
        this.Box_4 = new ModelRenderer((ModelBase)this, 33, 1);
        this.Box_4.addBox(0.0f, 0.0f, 0.0f, 12, 1, 14);
        this.Box_4.setRotationPoint(-5.0f, -12.0f, -7.0f);
        this.Box_4.setTextureSize(64, 32);
        this.Box_4.mirror = true;
        this.setRotation(this.Box_4, 0.0f, 0.0f, 0.0f);
        this.Box_5 = new ModelRenderer((ModelBase)this, 73, 1);
        this.Box_5.addBox(0.0f, 0.0f, 0.0f, 1, 1, 10);
        this.Box_5.setRotationPoint(-6.0f, -11.0f, -5.0f);
        this.Box_5.setTextureSize(64, 32);
        this.Box_5.mirror = true;
        this.setRotation(this.Box_5, 0.0f, 0.0f, 0.0f);
        this.Box_6 = new ModelRenderer((ModelBase)this, 97, 1);
        this.Box_6.addBox(0.0f, 0.0f, 0.0f, 1, 1, 10);
        this.Box_6.setRotationPoint(5.0f, -11.0f, -5.0f);
        this.Box_6.setTextureSize(64, 32);
        this.Box_6.mirror = true;
        this.setRotation(this.Box_6, 0.0f, 0.0f, 0.0f);
        this.Box_7 = new ModelRenderer((ModelBase)this, 33, 17);
        this.Box_7.addBox(0.0f, 0.0f, 0.0f, 10, 1, 1);
        this.Box_7.setRotationPoint(-5.0f, -11.0f, -6.0f);
        this.Box_7.setTextureSize(64, 32);
        this.Box_7.mirror = true;
        this.setRotation(this.Box_7, 0.0f, 0.0f, 0.0f);
        this.Box_8 = new ModelRenderer((ModelBase)this, 57, 17);
        this.Box_8.addBox(0.0f, 0.0f, 0.0f, 10, 1, 1);
        this.Box_8.setRotationPoint(-5.0f, -11.0f, 5.0f);
        this.Box_8.setTextureSize(64, 32);
        this.Box_8.mirror = true;
        this.setRotation(this.Box_8, 0.0f, 0.0f, 0.0f);
        this.Box_9 = new ModelRenderer((ModelBase)this, 1, 17);
        this.Box_9.addBox(0.0f, 0.0f, 0.0f, 1, 11, 13);
        this.Box_9.setRotationPoint(-5.0f, -26.0f, -6.5f);
        this.Box_9.setTextureSize(64, 32);
        this.Box_9.mirror = true;
        this.setRotation(this.Box_9, 0.0f, 0.0f, 0.0f);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

	@Override
	public void render() {
        GL11.glScaled((double)0.8, (double)0.8, (double)0.8);
        GL11.glRotatef((float)180.0f, (float)0.0f, (float)1.0f, (float)0.0f);
        this.Box_0.render(f5);
        this.Box_1.render(f5);
        this.Box_2.render(f5);
        this.Box_3.render(f5);
        this.Box_4.render(f5);
        this.Box_5.render(f5);
        this.Box_6.render(f5);
        this.Box_7.render(f5);
        this.Box_8.render(f5);
        this.Box_9.render(f5);
	}
}

