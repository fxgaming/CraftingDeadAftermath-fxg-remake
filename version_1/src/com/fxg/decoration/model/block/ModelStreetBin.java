package com.fxg.decoration.model.block;

import com.fxg.decoration.model.IModel;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelStreetBin extends ModelBase implements IModel {
	ModelRenderer Part_0;
	ModelRenderer Part_1;
	ModelRenderer Part_2;
	ModelRenderer Part_3;
	ModelRenderer Part_4;
	ModelRenderer Part_5;
	ModelRenderer Part_6;
	ModelRenderer Part_7;
	ModelRenderer Part_8;

	public ModelStreetBin() {
		this.textureWidth = 128;
		this.textureHeight = 128;
		this.Part_0 = new ModelRenderer((ModelBase) this, 73, 1);
		this.Part_0.addBox(0.0f, 0.0f, 0.0f, 1, 13, 14);
		this.Part_0.setRotationPoint(-7.0f, -15.0f, -7.0f);
		this.Part_0.setTextureSize(128, 128);
		this.Part_0.mirror = true;
		this.setRotation(this.Part_0, 0.0f, 0.0f, 0.0f);
		this.Part_1 = new ModelRenderer((ModelBase) this, 97, 17);
		this.Part_1.addBox(0.0f, 0.0f, 0.0f, 1, 13, 14);
		this.Part_1.setRotationPoint(6.0f, -15.0f, -7.0f);
		this.Part_1.setTextureSize(128, 128);
		this.Part_1.mirror = true;
		this.setRotation(this.Part_1, 0.0f, 0.0f, 0.0f);
		this.Part_2 = new ModelRenderer((ModelBase) this, 65, 33);
		this.Part_2.addBox(0.0f, 0.0f, 0.0f, 12, 13, 1);
		this.Part_2.setRotationPoint(-6.0f, -15.0f, -7.0f);
		this.Part_2.setTextureSize(128, 128);
		this.Part_2.mirror = true;
		this.setRotation(this.Part_2, 0.0f, 0.0f, 0.0f);
		this.Part_3 = new ModelRenderer((ModelBase) this, 1, 41);
		this.Part_3.addBox(0.0f, 0.0f, 0.0f, 12, 13, 1);
		this.Part_3.setRotationPoint(-6.0f, -15.0f, 6.0f);
		this.Part_3.setTextureSize(128, 128);
		this.Part_3.mirror = true;
		this.setRotation(this.Part_3, 0.0f, 0.0f, 0.0f);
		this.Part_4 = new ModelRenderer((ModelBase) this, 17, 49);
		this.Part_4.addBox(0.0f, 0.0f, 0.0f, 13, 12, 13);
		this.Part_4.setRotationPoint(-6.5f, -12.0f, -6.5f);
		this.Part_4.setTextureSize(128, 128);
		this.Part_4.mirror = true;
		this.setRotation(this.Part_4, 0.0f, 0.0f, 0.0f);
		this.Part_5 = new ModelRenderer((ModelBase) this, 57, 49);
		this.Part_5.addBox(0.0f, 0.0f, 0.0f, 13, 1, 6);
		this.Part_5.setRotationPoint(-6.5f, -14.8f, -6.5f);
		this.Part_5.setTextureSize(128, 128);
		this.Part_5.mirror = true;
		this.setRotation(this.Part_5, 0.0f, 0.0f, 0.0f);
		this.Part_6 = new ModelRenderer((ModelBase) this, 57, 1);
		this.Part_6.addBox(-2.0f, 0.0f, 0.0f, 2, 1, 7);
		this.Part_6.setRotationPoint(-4.5f, -14.8f, -0.5f);
		this.Part_6.setTextureSize(128, 128);
		this.Part_6.mirror = true;
		this.setRotation(this.Part_6, 0.0f, -0.03490659f, 0.0f);
		this.Part_7 = new ModelRenderer((ModelBase) this, 97, 1);
		this.Part_7.addBox(0.0f, 0.0f, 0.0f, 2, 1, 7);
		this.Part_7.setRotationPoint(4.5f, -14.8f, -0.5f);
		this.Part_7.setTextureSize(128, 128);
		this.Part_7.mirror = true;
		this.setRotation(this.Part_7, 0.0f, 0.03490659f, 0.0f);
		this.Part_8 = new ModelRenderer((ModelBase) this, 57, 65);
		this.Part_8.addBox(0.0f, 0.0f, 0.0f, 15, 1, 15);
		this.Part_8.setRotationPoint(-7.5f, -11.9f, -7.5f);
		this.Part_8.setTextureSize(128, 128);
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
