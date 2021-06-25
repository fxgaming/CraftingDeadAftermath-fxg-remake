package com.fxg.decoration.model.block;

import com.fxg.decoration.model.IModel;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelTicketGate_Open extends ModelBase implements IModel {
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
    ModelRenderer Box_10;
    ModelRenderer Box_11;

    public ModelTicketGate_Open() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.textureWidth = 64;
        this.textureHeight = 128;
        this.Box_0 = new ModelRenderer((ModelBase)this, 1, 1);
        this.Box_0.addBox(0.0f, 0.0f, 0.0f, 2, 16, 16);
        this.Box_0.setRotationPoint(6.0f, -16.0f, -8.0f);
        this.Box_0.setTextureSize(64, 32);
        this.Box_0.mirror = true;
        this.setRotation(this.Box_0, 0.0f, 0.0f, 0.0f);
        this.Box_1 = new ModelRenderer((ModelBase)this, 25, 25);
        this.Box_1.addBox(0.0f, 0.0f, 0.0f, 2, 16, 16);
        this.Box_1.setRotationPoint(-8.0f, -16.0f, -8.0f);
        this.Box_1.setTextureSize(64, 32);
        this.Box_1.mirror = true;
        this.setRotation(this.Box_1, 0.0f, 0.0f, 0.0f);
        this.Box_2 = new ModelRenderer((ModelBase)this, 1, 1);
        this.Box_2.addBox(0.0f, 0.0f, 0.0f, 1, 4, 4);
        this.Box_2.setRotationPoint(-6.0f, -14.0f, -2.0f);
        this.Box_2.setTextureSize(64, 32);
        this.Box_2.mirror = true;
        this.setRotation(this.Box_2, 0.0f, 0.0f, 0.0f);
        this.Box_3 = new ModelRenderer((ModelBase)this, 25, 1);
        this.Box_3.addBox(0.0f, -0.5f, -0.5f, 11, 1, 1);
        this.Box_3.setRotationPoint(-5.0f, -12.0f, 0.0f);
        this.Box_3.setTextureSize(64, 32);
        this.Box_3.mirror = true;
        this.setRotation(this.Box_3, 0.5061455f, 0.4014257f, -0.3490659f);
        this.Box_4 = new ModelRenderer((ModelBase)this, 25, 9);
        this.Box_4.addBox(0.0f, -0.5f, -0.5f, 11, 1, 1);
        this.Box_4.setRotationPoint(-5.0f, -12.0f, 0.0f);
        this.Box_4.setTextureSize(64, 32);
        this.Box_4.mirror = true;
        this.setRotation(this.Box_4, 0.5061455f, -0.4712389f, -0.3490659f);
        this.Box_5 = new ModelRenderer((ModelBase)this, 1, 57);
        this.Box_5.addBox(0.0f, -0.5f, -0.5f, 11, 1, 1);
        this.Box_5.setRotationPoint(-5.0f, -12.0f, 0.0f);
        this.Box_5.setTextureSize(64, 32);
        this.Box_5.mirror = true;
        this.setRotation(this.Box_5, 0.5061455f, -0.0174533f, 0.6283185f);
        this.Box_6 = new ModelRenderer((ModelBase)this, 57, 1);
        this.Box_6.addBox(-0.5f, 0.0f, 0.0f, 1, 13, 1);
        this.Box_6.setRotationPoint(7.0f, -15.0f, 8.0f);
        this.Box_6.setTextureSize(64, 32);
        this.Box_6.mirror = true;
        this.setRotation(this.Box_6, 0.0f, 0.0f, 0.0f);
        this.Box_7 = new ModelRenderer((ModelBase)this, 49, 17);
        this.Box_7.addBox(-0.5f, 0.0f, 0.0f, 1, 13, 1);
        this.Box_7.setRotationPoint(-7.0f, -15.0f, 8.0f);
        this.Box_7.setTextureSize(64, 32);
        this.Box_7.mirror = true;
        this.setRotation(this.Box_7, 0.0f, 0.0f, 0.0f);
        this.Box_8 = new ModelRenderer((ModelBase)this, 57, 17);
        this.Box_8.addBox(-0.5f, 0.0f, 0.0f, 1, 13, 1);
        this.Box_8.setRotationPoint(-7.0f, -15.0f, -9.0f);
        this.Box_8.setTextureSize(64, 32);
        this.Box_8.mirror = true;
        this.setRotation(this.Box_8, 0.0f, 0.0f, 0.0f);
        this.Box_9 = new ModelRenderer((ModelBase)this, 1, 41);
        this.Box_9.addBox(-0.5f, 0.0f, 0.0f, 1, 13, 1);
        this.Box_9.setRotationPoint(7.0f, -15.0f, -9.0f);
        this.Box_9.setTextureSize(64, 32);
        this.Box_9.mirror = true;
        this.setRotation(this.Box_9, 0.0f, 0.0f, 0.0f);
        this.Box_10 = new ModelRenderer((ModelBase)this, 1, 65);
        this.Box_10.addBox(0.0f, 0.0f, 0.0f, 1, 4, 10);
        this.Box_10.setRotationPoint(-8.0f, -20.0f, -5.0f);
        this.Box_10.setTextureSize(64, 32);
        this.Box_10.mirror = true;
        this.setRotation(this.Box_10, 0.0f, 0.0f, 0.0f);
        this.Box_11 = new ModelRenderer((ModelBase)this, 25, 65);
        this.Box_11.addBox(0.0f, 0.0f, 0.0f, 1, 4, 10);
        this.Box_11.setRotationPoint(7.0f, -20.0f, -5.0f);
        this.Box_11.setTextureSize(64, 32);
        this.Box_11.mirror = true;
        this.setRotation(this.Box_11, 0.0f, 0.0f, 0.0f);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

	@Override
	public void render() {
        this.Box_0.render(f5);
        this.Box_1.render(f5);
        this.Box_2.render(f5);
        this.Box_6.render(f5);
        this.Box_7.render(f5);
        this.Box_8.render(f5);
        this.Box_9.render(f5);
        this.Box_10.render(f5);
        this.Box_11.render(f5);
	}
}

