package com.fxg.decoration.model.block;

import com.fxg.decoration.model.IModel;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelMetroRailing1 extends ModelBase implements IModel {
    int x = 0;
    ModelRenderer Box0;
    ModelRenderer Box1;
    ModelRenderer Box2;

    public ModelMetroRailing1() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.Box0 = new ModelRenderer((ModelBase)this, 1, 1);
        this.Box0.addBox(0.0f, 0.0f, 0.0f, 8, 1, 8);
        this.Box0.setRotationPoint(-4.0f, -1.0f, -4.0f);
        this.Box0.setTextureSize(64, 32);
        this.Box0.mirror = true;
        this.setRotation(this.Box0, 0.0f, 0.0f, 0.0f);
        this.Box1 = new ModelRenderer((ModelBase)this, 41, 1);
        this.Box1.addBox(0.0f, 0.0f, 0.0f, 2, 14, 2);
        this.Box1.setRotationPoint(-1.0f, -15.0f, -1.0f);
        this.Box1.setTextureSize(64, 32);
        this.Box1.mirror = true;
        this.setRotation(this.Box1, 0.0f, 0.0f, 0.0f);
        this.Box2 = new ModelRenderer((ModelBase)this, 1, 17);
        this.Box2.addBox(0.0f, 0.0f, 0.0f, 10, 1, 4);
        this.Box2.setRotationPoint(-8.0f, -16.0f, -2.0f);
        this.Box2.setTextureSize(64, 32);
        this.Box2.mirror = true;
        this.setRotation(this.Box2, 0.0f, 0.0f, 0.0f);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

	@Override
	public void render() {
        this.Box0.render(f5);
        this.Box1.render(f5);
        this.Box2.render(f5);
	}
}

