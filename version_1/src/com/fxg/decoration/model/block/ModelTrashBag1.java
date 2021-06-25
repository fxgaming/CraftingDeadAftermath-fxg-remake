package com.fxg.decoration.model.block;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import org.lwjgl.opengl.GL11;

import com.fxg.decoration.model.IModel;

public class ModelTrashBag1 extends ModelBase implements IModel {
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

    public ModelTrashBag1() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.Part_0 = new ModelRenderer((ModelBase)this, 1, 1);
        this.Part_0.addBox(0.0f, 0.0f, 0.0f, 8, 3, 8);
        this.Part_0.setRotationPoint(-4.0f, -8.0f, -3.0f);
        this.Part_0.setTextureSize(128, 64);
        this.Part_0.mirror = true;
        this.setRotation(this.Part_0, 0.0f, 0.2268928f, 0.0f);
        this.Part_1 = new ModelRenderer((ModelBase)this, 41, 1);
        this.Part_1.addBox(-0.5f, 3.0f, -0.5f, 10, 4, 9);
        this.Part_1.setRotationPoint(-4.0f, -8.0f, -3.0f);
        this.Part_1.setTextureSize(128, 64);
        this.Part_1.mirror = true;
        this.setRotation(this.Part_1, 0.0f, 0.2443461f, 0.0f);
        this.Part_2 = new ModelRenderer((ModelBase)this, 81, 1);
        this.Part_2.addBox(0.0f, -2.0f, 0.6f, 6, 5, 7);
        this.Part_2.setRotationPoint(-4.0f, -8.0f, -3.0f);
        this.Part_2.setTextureSize(128, 64);
        this.Part_2.mirror = true;
        this.setRotation(this.Part_2, 0.0f, 0.31415927f, 0.08726646f);
        this.Part_3 = new ModelRenderer((ModelBase)this, 105, 1);
        this.Part_3.addBox(0.0f, -3.0f, 2.0f, 5, 2, 4);
        this.Part_3.setRotationPoint(-4.0f, -8.0f, -3.0f);
        this.Part_3.setTextureSize(128, 64);
        this.Part_3.mirror = true;
        this.setRotation(this.Part_3, 0.0f, 0.4886922f, 0.0f);
        this.Part_4 = new ModelRenderer((ModelBase)this, 33, 1);
        this.Part_4.addBox(1.0f, -4.0f, 3.5f, 2, 1, 2);
        this.Part_4.setRotationPoint(-4.0f, -8.0f, -3.0f);
        this.Part_4.setTextureSize(128, 64);
        this.Part_4.mirror = true;
        this.setRotation(this.Part_4, 0.0f, 0.61086524f, 0.08726646f);
        this.Part_5 = new ModelRenderer((ModelBase)this, 1, 17);
        this.Part_5.addBox(0.0f, 7.0f, 0.0f, 9, 1, 8);
        this.Part_5.setRotationPoint(-4.0f, -8.0f, -3.0f);
        this.Part_5.setTextureSize(128, 64);
        this.Part_5.mirror = true;
        this.setRotation(this.Part_5, 0.0f, 0.2443461f, 0.0f);
        this.Part_6 = new ModelRenderer((ModelBase)this, 1, 1);
        this.Part_6.addBox(0.75f, -4.75f, 4.5f, 1, 1, 1);
        this.Part_6.setRotationPoint(-4.0f, -8.0f, -3.0f);
        this.Part_6.setTextureSize(128, 64);
        this.Part_6.mirror = true;
        this.setRotation(this.Part_6, 0.0f, 0.7853982f, 0.12217305f);
        this.Part_7 = new ModelRenderer((ModelBase)this, 105, 9);
        this.Part_7.addBox(8.0f, 1.0f, 1.0f, 1, 2, 6);
        this.Part_7.setRotationPoint(-4.0f, -8.0f, -3.0f);
        this.Part_7.setTextureSize(128, 64);
        this.Part_7.mirror = true;
        this.setRotation(this.Part_7, 0.0f, 0.13962634f, 0.0f);
        this.Part_8 = new ModelRenderer((ModelBase)this, 73, 1);
        this.Part_8.addBox(6.0f, -1.5f, 0.6f, 1, 1, 4);
        this.Part_8.setRotationPoint(-4.0f, -8.0f, -2.0f);
        this.Part_8.setTextureSize(128, 64);
        this.Part_8.mirror = true;
        this.setRotation(this.Part_8, 0.0f, 0.40142572f, 0.08726646f);
        this.Part_9 = new ModelRenderer((ModelBase)this, 81, 1);
        this.Part_9.addBox(1.0f, -2.5f, 6.0f, 2, 1, 1);
        this.Part_9.setRotationPoint(-4.0f, -8.0f, -3.0f);
        this.Part_9.setTextureSize(128, 64);
        this.Part_9.mirror = true;
        this.setRotation(this.Part_9, 0.0f, 0.57595867f, 0.0f);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

	@Override
	public void render() {
        GL11.glScaled((double)1.3, (double)1.3, (double)1.3);
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
	}
}

