package com.fxg.decoration.model.block;

import com.fxg.decoration.model.IModel;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelElectricBox1 extends ModelBase implements IModel {
    int x = 0;
    ModelRenderer Part_0;
    ModelRenderer Part_1;
    ModelRenderer Part_2;
    ModelRenderer Part_3;
    ModelRenderer Part_4;
    ModelRenderer Part_5;

    public ModelElectricBox1() {
        this.textureWidth = 128;
        this.textureHeight = 32;
        this.Part_0 = new ModelRenderer((ModelBase)this, 1, 1);
        this.Part_0.addBox(0.0f, 0.0f, 0.0f, 1, 10, 1);
        this.Part_0.setRotationPoint(4.0f, -10.0f, -8.0f);
        this.Part_0.setTextureSize(128, 32);
        this.Part_0.mirror = true;
        this.setRotation(this.Part_0, 0.0f, 0.0f, 0.0f);
        this.Part_1 = new ModelRenderer((ModelBase)this, 9, 1);
        this.Part_1.addBox(0.0f, 0.0f, 0.0f, 14, 7, 3);
        this.Part_1.setRotationPoint(-7.0f, -17.0f, -8.0f);
        this.Part_1.setTextureSize(128, 32);
        this.Part_1.mirror = true;
        this.setRotation(this.Part_1, 0.0f, 0.0f, 0.0f);
        this.Part_2 = new ModelRenderer((ModelBase)this, 49, 1);
        this.Part_2.addBox(0.0f, 0.0f, 0.0f, 1, 13, 1);
        this.Part_2.setRotationPoint(4.0f, -30.0f, -8.0f);
        this.Part_2.setTextureSize(128, 32);
        this.Part_2.mirror = true;
        this.setRotation(this.Part_2, 0.0f, 0.0f, 0.0f);
        this.Part_3 = new ModelRenderer((ModelBase)this, 57, 1);
        this.Part_3.addBox(0.0f, 0.0f, 0.0f, 1, 9, 1);
        this.Part_3.setRotationPoint(-5.0f, -26.0f, -8.0f);
        this.Part_3.setTextureSize(128, 32);
        this.Part_3.mirror = true;
        this.setRotation(this.Part_3, 0.0f, 0.0f, 0.0f);
        this.Part_4 = new ModelRenderer((ModelBase)this, 65, 1);
        this.Part_4.addBox(0.0f, 0.0f, 0.0f, 5, 5, 2);
        this.Part_4.setRotationPoint(-7.0f, -31.0f, -8.0f);
        this.Part_4.setTextureSize(128, 32);
        this.Part_4.mirror = true;
        this.setRotation(this.Part_4, 0.0f, 0.0f, 0.0f);
        this.Part_5 = new ModelRenderer((ModelBase)this, 81, 1);
        this.Part_5.addBox(0.0f, 0.0f, 0.0f, 9, 5, 2);
        this.Part_5.setRotationPoint(-1.0f, -35.0f, -8.0f);
        this.Part_5.setTextureSize(128, 32);
        this.Part_5.mirror = true;
        this.setRotation(this.Part_5, 0.0f, 0.0f, 0.0f);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5) {
    }

	@Override
	public void render() {
        this.Part_0.render(f5);
        this.Part_1.render(f5);
        this.Part_2.render(f5);
        this.Part_3.render(f5);
        this.Part_4.render(f5);
        this.Part_5.render(f5);
	}
}

