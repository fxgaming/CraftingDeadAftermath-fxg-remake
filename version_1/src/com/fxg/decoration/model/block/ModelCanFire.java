package com.fxg.decoration.model.block;

import org.lwjgl.opengl.GL11;

import com.ferullogaming.craftingdead.client.util.FancyLightHelper;
import com.fxg.decoration.model.IModel;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelCanFire extends ModelBase implements IModel {
    ModelRenderer Part_0;
    ModelRenderer Part_1;
    ModelRenderer Part_2;
    ModelRenderer Part_3;
    ModelRenderer Part_4;

    public ModelCanFire() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.Part_0 = new ModelRenderer((ModelBase)this, 1, 1);
        this.Part_0.addBox(0.0f, 0.0f, 0.0f, 14, 11, 14);
        this.Part_0.setRotationPoint(-7.0f, -10.0f, -7.0f);
        this.Part_0.setTextureSize(128, 64);
        this.Part_0.mirror = true;
        this.setRotation(this.Part_0, 0.0f, 0.0f, 0.0f);
        this.Part_1 = new ModelRenderer((ModelBase)this, 65, 1);
        this.Part_1.addBox(0.0f, 0.0f, 0.0f, 1, 16, 14);
        this.Part_1.setRotationPoint(-8.0f, -15.0f, -7.0f);
        this.Part_1.setTextureSize(128, 64);
        this.Part_1.mirror = true;
        this.setRotation(this.Part_1, 0.0f, 0.0f, 0.0f);
        this.Part_2 = new ModelRenderer((ModelBase)this, 97, 1);
        this.Part_2.addBox(0.0f, 0.0f, 0.0f, 1, 16, 14);
        this.Part_2.setRotationPoint(7.0f, -15.0f, -7.0f);
        this.Part_2.setTextureSize(128, 64);
        this.Part_2.mirror = true;
        this.setRotation(this.Part_2, 0.0f, 0.0f, 0.0f);
        this.Part_3 = new ModelRenderer((ModelBase)this, 1, 33);
        this.Part_3.addBox(0.0f, 0.0f, 0.0f, 14, 16, 1);
        this.Part_3.setRotationPoint(-7.0f, -15.0f, -8.0f);
        this.Part_3.setTextureSize(128, 64);
        this.Part_3.mirror = true;
        this.setRotation(this.Part_3, 0.0f, 0.0f, 0.0f);
        this.Part_4 = new ModelRenderer((ModelBase)this, 33, 33);
        this.Part_4.addBox(0.0f, 0.0f, 0.0f, 14, 16, 1);
        this.Part_4.setRotationPoint(-7.0f, -15.0f, 7.0f);
        this.Part_4.setTextureSize(128, 64);
        this.Part_4.mirror = true;
        this.setRotation(this.Part_4, 0.0f, 0.0f, 0.0f);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

	@Override
	public void render() {
        FancyLightHelper.useBrightLight();
        GL11.glScalef((float)0.5f, (float)0.5f, (float)0.5f);
        this.Part_0.render(f5);
        this.Part_1.render(f5);
        this.Part_2.render(f5);
        this.Part_3.render(f5);
        this.Part_4.render(f5);
	}
}

