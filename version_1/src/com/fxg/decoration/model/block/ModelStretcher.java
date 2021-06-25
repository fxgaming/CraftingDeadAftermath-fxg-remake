package com.fxg.decoration.model.block;

import com.fxg.decoration.model.IModel;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelStretcher extends ModelBase implements IModel {
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
    ModelRenderer Part_12;
    ModelRenderer Part_13;
    ModelRenderer Part_14;
    ModelRenderer Part_15;
    ModelRenderer Part_16;
    ModelRenderer Part_17;
    ModelRenderer Part_18;
    ModelRenderer Part_19;
    ModelRenderer Part_20;
    ModelRenderer Part_21;
    ModelRenderer Part_22;
    ModelRenderer Part_23;
    ModelRenderer Part_24;
    ModelRenderer Part_25;
    ModelRenderer Part_26;

    public ModelStretcher() {
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.Part_0 = new ModelRenderer((ModelBase)this, 1, 1);
        this.Part_0.addBox(0.0f, 0.0f, 0.0f, 10, 1, 30);
        this.Part_0.setRotationPoint(-5.0f, -8.15f, -15.0f);
        this.Part_0.setTextureSize(128, 128);
        this.Part_0.mirror = true;
        this.setRotation(this.Part_0, 0.0f, 0.0f, 0.0f);
        this.Part_1 = new ModelRenderer((ModelBase)this, 57, 1);
        this.Part_1.addBox(0.0f, 0.0f, 0.0f, 1, 1, 32);
        this.Part_1.setRotationPoint(-8.0f, -8.5f, -16.0f);
        this.Part_1.setTextureSize(128, 128);
        this.Part_1.mirror = true;
        this.setRotation(this.Part_1, 0.0f, 0.0f, 0.0f);
        this.Part_2 = new ModelRenderer((ModelBase)this, 1, 33);
        this.Part_2.addBox(0.0f, 0.0f, 0.0f, 1, 1, 32);
        this.Part_2.setRotationPoint(7.0f, -8.5f, -16.0f);
        this.Part_2.setTextureSize(128, 128);
        this.Part_2.mirror = true;
        this.setRotation(this.Part_2, 0.0f, 0.0f, 0.0f);
        this.Part_3 = new ModelRenderer((ModelBase)this, 57, 1);
        this.Part_3.addBox(0.0f, 0.0f, 0.0f, 14, 1, 1);
        this.Part_3.setRotationPoint(-7.0f, -8.5f, -16.0f);
        this.Part_3.setTextureSize(128, 128);
        this.Part_3.mirror = true;
        this.setRotation(this.Part_3, 0.0f, 0.0f, 0.0f);
        this.Part_4 = new ModelRenderer((ModelBase)this, 97, 1);
        this.Part_4.addBox(0.0f, 0.0f, 0.0f, 14, 1, 1);
        this.Part_4.setRotationPoint(-7.0f, -8.5f, 15.0f);
        this.Part_4.setTextureSize(128, 128);
        this.Part_4.mirror = true;
        this.setRotation(this.Part_4, 0.0f, 0.0f, 0.0f);
        this.Part_5 = new ModelRenderer((ModelBase)this, 1, 1);
        this.Part_5.addBox(-1.0f, 0.0f, 0.0f, 1, 1, 1);
        this.Part_5.setRotationPoint(-8.0f, -8.5f, -15.99f);
        this.Part_5.setTextureSize(128, 128);
        this.Part_5.mirror = true;
        this.setRotation(this.Part_5, 0.0f, 0.0f, -0.34906584f);
        this.Part_6 = new ModelRenderer((ModelBase)this, 9, 1);
        this.Part_6.addBox(0.0f, 0.0f, 0.0f, 1, 1, 1);
        this.Part_6.setRotationPoint(8.0f, -8.5f, 15.01f);
        this.Part_6.setTextureSize(128, 128);
        this.Part_6.mirror = true;
        this.setRotation(this.Part_6, 0.0f, 0.0f, 0.34906584f);
        this.Part_7 = new ModelRenderer((ModelBase)this, 17, 1);
        this.Part_7.addBox(-1.0f, 0.0f, 0.0f, 1, 1, 1);
        this.Part_7.setRotationPoint(-8.0f, -8.5f, 15.01f);
        this.Part_7.setTextureSize(128, 128);
        this.Part_7.mirror = true;
        this.setRotation(this.Part_7, 0.0f, 0.0f, -0.34906584f);
        this.Part_8 = new ModelRenderer((ModelBase)this, 25, 1);
        this.Part_8.addBox(0.0f, 0.0f, 0.0f, 1, 1, 1);
        this.Part_8.setRotationPoint(8.0f, -8.5f, -15.99f);
        this.Part_8.setTextureSize(128, 128);
        this.Part_8.mirror = true;
        this.setRotation(this.Part_8, 0.0f, 0.0f, 0.34906584f);
        this.Part_9 = new ModelRenderer((ModelBase)this, 1, 9);
        this.Part_9.addBox(-0.12f, -1.0f, 0.0f, 6, 1, 1);
        this.Part_9.setRotationPoint(-5.4f, -7.5f, 15.5f);
        this.Part_9.setTextureSize(128, 128);
        this.Part_9.mirror = true;
        this.setRotation(this.Part_9, 0.0f, 0.0f, 0.8813913f);
        this.Part_10 = new ModelRenderer((ModelBase)this, 57, 9);
        this.Part_10.addBox(-12.0f, -1.0f, 0.0f, 12, 1, 1);
        this.Part_10.setRotationPoint(5.5f, -7.5f, 15.5f);
        this.Part_10.setTextureSize(128, 128);
        this.Part_10.mirror = true;
        this.setRotation(this.Part_10, 0.0f, 0.0f, -0.6806784f);
        this.Part_11 = new ModelRenderer((ModelBase)this, 97, 9);
        this.Part_11.addBox(6.88f, -4.75f, 0.0f, 6, 1, 1);
        this.Part_11.setRotationPoint(-5.4f, -7.5f, 15.5f);
        this.Part_11.setTextureSize(128, 128);
        this.Part_11.mirror = true;
        this.setRotation(this.Part_11, 0.0f, 0.0f, 0.8813913f);
        this.Part_12 = new ModelRenderer((ModelBase)this, 17, 9);
        this.Part_12.addBox(6.0f, -4.72f, 0.25f, 1, 1, 1);
        this.Part_12.setRotationPoint(-5.4f, -7.5f, 15.5f);
        this.Part_12.setTextureSize(128, 128);
        this.Part_12.mirror = true;
        this.setRotation(this.Part_12, 0.0f, 0.0f, 0.8813913f);
        this.Part_13 = new ModelRenderer((ModelBase)this, 25, 9);
        this.Part_13.addBox(0.0f, -1.0f, 0.0f, 1, 1, 1);
        this.Part_13.setRotationPoint(4.5f, -7.51f, 15.51f);
        this.Part_13.setTextureSize(128, 128);
        this.Part_13.mirror = true;
        this.setRotation(this.Part_13, 0.0f, 0.0f, 0.0f);
        this.Part_14 = new ModelRenderer((ModelBase)this, 113, 9);
        this.Part_14.addBox(0.0f, -1.0f, 0.0f, 1, 1, 1);
        this.Part_14.setRotationPoint(-5.5f, -7.51f, 15.51f);
        this.Part_14.setTextureSize(128, 128);
        this.Part_14.mirror = true;
        this.setRotation(this.Part_14, 0.0f, 0.0f, 0.0f);
        this.Part_15 = new ModelRenderer((ModelBase)this, 121, 9);
        this.Part_15.addBox(0.0f, -1.0f, 0.0f, 1, 1, 1);
        this.Part_15.setRotationPoint(4.5f, -7.51f, -16.51f);
        this.Part_15.setTextureSize(128, 128);
        this.Part_15.mirror = true;
        this.setRotation(this.Part_15, 0.0f, 0.0f, 0.0f);
        this.Part_16 = new ModelRenderer((ModelBase)this, 1, 17);
        this.Part_16.addBox(0.0f, -1.0f, 0.0f, 1, 1, 1);
        this.Part_16.setRotationPoint(-5.5f, -7.51f, -16.51f);
        this.Part_16.setTextureSize(128, 128);
        this.Part_16.mirror = true;
        this.setRotation(this.Part_16, 0.0f, 0.0f, 0.0f);
        this.Part_17 = new ModelRenderer((ModelBase)this, 9, 17);
        this.Part_17.addBox(-0.12f, -1.0f, 0.0f, 6, 1, 1);
        this.Part_17.setRotationPoint(-5.4f, -7.5f, -16.5f);
        this.Part_17.setTextureSize(128, 128);
        this.Part_17.mirror = true;
        this.setRotation(this.Part_17, 0.0f, 0.0f, 0.8813913f);
        this.Part_18 = new ModelRenderer((ModelBase)this, 57, 17);
        this.Part_18.addBox(-12.0f, -1.0f, 0.0f, 12, 1, 1);
        this.Part_18.setRotationPoint(5.5f, -7.5f, -16.5f);
        this.Part_18.setTextureSize(128, 128);
        this.Part_18.mirror = true;
        this.setRotation(this.Part_18, 0.0f, 0.0f, -0.6806784f);
        this.Part_19 = new ModelRenderer((ModelBase)this, 97, 17);
        this.Part_19.addBox(6.88f, -4.75f, 0.0f, 6, 1, 1);
        this.Part_19.setRotationPoint(-5.4f, -7.5f, -16.5f);
        this.Part_19.setTextureSize(128, 128);
        this.Part_19.mirror = true;
        this.setRotation(this.Part_19, 0.0f, 0.0f, 0.8813913f);
        this.Part_20 = new ModelRenderer((ModelBase)this, 25, 17);
        this.Part_20.addBox(6.0f, -4.72f, -0.25f, 1, 1, 1);
        this.Part_20.setRotationPoint(-5.4f, -7.5f, -16.5f);
        this.Part_20.setTextureSize(128, 128);
        this.Part_20.mirror = true;
        this.setRotation(this.Part_20, 0.0f, 0.0f, 0.8813913f);
        this.Part_21 = new ModelRenderer((ModelBase)this, 41, 41);
        this.Part_21.addBox(-1.0f, -1.0f, 0.0f, 1, 1, 30);
        this.Part_21.setRotationPoint(-5.0f, -7.15f, -15.0f);
        this.Part_21.setTextureSize(128, 128);
        this.Part_21.mirror = true;
        this.setRotation(this.Part_21, 0.0f, 0.0f, 0.17453294f);
        this.Part_22 = new ModelRenderer((ModelBase)this, 1, 73);
        this.Part_22.addBox(0.0f, -1.0f, 0.0f, 1, 1, 30);
        this.Part_22.setRotationPoint(5.0f, -7.15f, -15.0f);
        this.Part_22.setTextureSize(128, 128);
        this.Part_22.mirror = true;
        this.setRotation(this.Part_22, 0.0f, 0.0f, -0.17453294f);
        this.Part_23 = new ModelRenderer((ModelBase)this, 1, 33);
        this.Part_23.addBox(-3.0f, -1.0f, 4.0f, 2, 1, 10);
        this.Part_23.setRotationPoint(-5.0f, -7.15f, -15.0f);
        this.Part_23.setTextureSize(128, 128);
        this.Part_23.mirror = true;
        this.setRotation(this.Part_23, 0.0f, 0.0f, 0.17453294f);
        this.Part_24 = new ModelRenderer((ModelBase)this, 41, 33);
        this.Part_24.addBox(-3.0f, -1.0f, 16.0f, 2, 1, 10);
        this.Part_24.setRotationPoint(-5.0f, -7.15f, -15.0f);
        this.Part_24.setTextureSize(128, 128);
        this.Part_24.mirror = true;
        this.setRotation(this.Part_24, 0.0f, 0.0f, 0.17453294f);
        this.Part_25 = new ModelRenderer((ModelBase)this, 81, 41);
        this.Part_25.addBox(1.0f, -1.0f, 4.0f, 2, 1, 10);
        this.Part_25.setRotationPoint(5.0f, -7.15f, -15.0f);
        this.Part_25.setTextureSize(128, 128);
        this.Part_25.mirror = true;
        this.setRotation(this.Part_25, 0.0f, 0.0f, -0.17453294f);
        this.Part_26 = new ModelRenderer((ModelBase)this, 1, 49);
        this.Part_26.addBox(1.0f, -1.0f, 16.0f, 2, 1, 10);
        this.Part_26.setRotationPoint(5.0f, -7.15f, -15.0f);
        this.Part_26.setTextureSize(128, 128);
        this.Part_26.mirror = true;
        this.setRotation(this.Part_26, 0.0f, 0.0f, -0.17453294f);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

	@Override
	public void render() {
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
        this.Part_12.render(f5);
        this.Part_13.render(f5);
        this.Part_14.render(f5);
        this.Part_15.render(f5);
        this.Part_16.render(f5);
        this.Part_17.render(f5);
        this.Part_18.render(f5);
        this.Part_19.render(f5);
        this.Part_20.render(f5);
        this.Part_21.render(f5);
        this.Part_22.render(f5);
        this.Part_23.render(f5);
        this.Part_24.render(f5);
        this.Part_25.render(f5);
        this.Part_26.render(f5);
	}
}
