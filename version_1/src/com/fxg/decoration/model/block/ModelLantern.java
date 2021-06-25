package com.fxg.decoration.model.block;

import com.ferullogaming.craftingdead.client.util.FancyLightHelper;
import com.fxg.decoration.model.IModel;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

public class ModelLantern extends ModelBase implements IModel {
    ModelRenderer Part_0;
    ModelRenderer Part_1;
    ModelRenderer Part_2;
    ModelRenderer Part_3;
    ModelRenderer Part_4;

    public ModelLantern() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.Part_0 = new ModelRenderer((ModelBase)this, 1, 1);
        this.Part_0.addBox(0.0f, 0.0f, 0.0f, 6, 2, 6);
        this.Part_0.setRotationPoint(-3.0f, -2.0f, -3.0f);
        this.Part_0.setTextureSize(64, 32);
        this.Part_0.mirror = true;
        this.setRotation(this.Part_0, 0.0f, 0.0f, 0.0f);
        this.Part_1 = new ModelRenderer((ModelBase)this, 33, 1);
        this.Part_1.addBox(0.0f, 0.0f, 0.0f, 5, 1, 5);
        this.Part_1.setRotationPoint(-2.5f, -3.0f, -2.5f);
        this.Part_1.setTextureSize(64, 32);
        this.Part_1.mirror = true;
        this.setRotation(this.Part_1, 0.0f, 0.0f, 0.0f);
        this.Part_2 = new ModelRenderer((ModelBase)this, 25, 9);
        this.Part_2.addBox(0.0f, 0.0f, 0.0f, 4, 6, 4);
        this.Part_2.setRotationPoint(-2.0f, -9.0f, -2.0f);
        this.Part_2.setTextureSize(64, 32);
        this.Part_2.mirror = true;
        this.setRotation(this.Part_2, 0.0f, 0.0f, 0.0f);
        this.Part_3 = new ModelRenderer((ModelBase)this, 1, 17);
        this.Part_3.addBox(0.0f, 0.0f, 0.0f, 5, 1, 5);
        this.Part_3.setRotationPoint(-2.5f, -10.0f, -2.5f);
        this.Part_3.setTextureSize(64, 32);
        this.Part_3.mirror = true;
        this.setRotation(this.Part_3, 0.0f, 0.0f, 0.0f);
        this.Part_4 = new ModelRenderer((ModelBase)this, 41, 17);
        this.Part_4.addBox(0.0f, 0.0f, 0.0f, 4, 1, 4);
        this.Part_4.setRotationPoint(-2.0f, -10.5f, -2.0f);
        this.Part_4.setTextureSize(64, 32);
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
        this.Part_0.render(f5);
        this.Part_1.render(f5);
        this.Part_2.render(f5);
        this.Part_3.render(f5);
        this.Part_4.render(f5);
	}
}

