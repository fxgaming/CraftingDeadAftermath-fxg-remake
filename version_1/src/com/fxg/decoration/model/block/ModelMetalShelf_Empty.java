package com.fxg.decoration.model.block;

import com.fxg.decoration.model.IModel;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelMetalShelf_Empty extends ModelBase implements IModel {
    int x = 0;
    ModelRenderer Import_Box0;
    ModelRenderer Import_Box1;
    ModelRenderer Import_Box2;
    ModelRenderer Import_Box3;
    ModelRenderer Import_Box4;
    ModelRenderer Import_Box5;
    ModelRenderer Import_Box6;
    ModelRenderer Import_Box7;
    ModelRenderer Import_Box8;
    ModelRenderer Import_Box9;
    ModelRenderer Import_Box10;
    ModelRenderer Import_Box11;
    ModelRenderer Import_Box12;
    ModelRenderer Import_Box13;
    ModelRenderer Import_Box14;
    ModelRenderer Import_Box15;

    public ModelMetalShelf_Empty() {
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.Import_Box0 = new ModelRenderer((ModelBase)this, 1, 1);
        this.Import_Box0.addBox(0.0f, 0.0f, 0.0f, 1, 16, 1);
        this.Import_Box0.setRotationPoint(15.0f, -16.0f, 7.0f);
        this.Import_Box0.setTextureSize(64, 32);
        this.Import_Box0.mirror = true;
        this.setRotation(this.Import_Box0, 0.0f, 0.0f, 0.0f);
        this.Import_Box1 = new ModelRenderer((ModelBase)this, 9, 1);
        this.Import_Box1.addBox(0.0f, 0.0f, 0.0f, 1, 16, 1);
        this.Import_Box1.setRotationPoint(15.0f, -16.0f, -8.0f);
        this.Import_Box1.setTextureSize(64, 32);
        this.Import_Box1.mirror = true;
        this.setRotation(this.Import_Box1, 0.0f, 0.0f, 0.0f);
        this.Import_Box2 = new ModelRenderer((ModelBase)this, 17, 1);
        this.Import_Box2.addBox(0.0f, 0.0f, 0.0f, 1, 16, 1);
        this.Import_Box2.setRotationPoint(-16.0f, -16.0f, -8.0f);
        this.Import_Box2.setTextureSize(64, 32);
        this.Import_Box2.mirror = true;
        this.setRotation(this.Import_Box2, 0.0f, 0.0f, 0.0f);
        this.Import_Box3 = new ModelRenderer((ModelBase)this, 25, 1);
        this.Import_Box3.addBox(0.0f, 0.0f, 0.0f, 1, 16, 1);
        this.Import_Box3.setRotationPoint(-16.0f, -16.0f, 7.0f);
        this.Import_Box3.setTextureSize(64, 32);
        this.Import_Box3.mirror = true;
        this.setRotation(this.Import_Box3, 0.0f, 0.0f, 0.0f);
        this.Import_Box4 = new ModelRenderer((ModelBase)this, 17, 9);
        this.Import_Box4.addBox(0.0f, 0.0f, 0.0f, 32, 1, 16);
        this.Import_Box4.setRotationPoint(-16.0f, -17.0f, -8.0f);
        this.Import_Box4.setTextureSize(64, 32);
        this.Import_Box4.mirror = true;
        this.setRotation(this.Import_Box4, 0.0f, 0.0f, 0.0f);
        this.Import_Box5 = new ModelRenderer((ModelBase)this, 1, 33);
        this.Import_Box5.addBox(0.0f, 0.0f, 0.0f, 30, 1, 16);
        this.Import_Box5.setRotationPoint(-15.0f, -4.0f, -8.0f);
        this.Import_Box5.setTextureSize(64, 32);
        this.Import_Box5.mirror = true;
        this.setRotation(this.Import_Box5, 0.0f, 0.0f, 0.0f);
        this.Import_Box6 = new ModelRenderer((ModelBase)this, 105, 1);
        this.Import_Box6.addBox(0.0f, 0.0f, 0.0f, 1, 16, 1);
        this.Import_Box6.setRotationPoint(-16.0f, -33.0f, -8.0f);
        this.Import_Box6.setTextureSize(64, 32);
        this.Import_Box6.mirror = true;
        this.setRotation(this.Import_Box6, 0.0f, 0.0f, 0.0f);
        this.Import_Box7 = new ModelRenderer((ModelBase)this, 113, 1);
        this.Import_Box7.addBox(0.0f, 0.0f, 0.0f, 1, 16, 1);
        this.Import_Box7.setRotationPoint(15.0f, -33.0f, -8.0f);
        this.Import_Box7.setTextureSize(64, 32);
        this.Import_Box7.mirror = true;
        this.setRotation(this.Import_Box7, 0.0f, 0.0f, 0.0f);
        this.Import_Box8 = new ModelRenderer((ModelBase)this, 121, 1);
        this.Import_Box8.addBox(0.0f, 0.0f, 0.0f, 1, 16, 1);
        this.Import_Box8.setRotationPoint(-16.0f, -33.0f, 7.0f);
        this.Import_Box8.setTextureSize(64, 32);
        this.Import_Box8.mirror = true;
        this.setRotation(this.Import_Box8, 0.0f, 0.0f, 0.0f);
        this.Import_Box9 = new ModelRenderer((ModelBase)this, 1, 25);
        this.Import_Box9.addBox(0.0f, 0.0f, 0.0f, 1, 16, 1);
        this.Import_Box9.setRotationPoint(15.0f, -33.0f, 7.0f);
        this.Import_Box9.setTextureSize(64, 32);
        this.Import_Box9.mirror = true;
        this.setRotation(this.Import_Box9, 0.0f, 0.0f, 0.0f);
        this.Import_Box10 = new ModelRenderer((ModelBase)this, 1, 57);
        this.Import_Box10.addBox(0.0f, 0.0f, 0.0f, 32, 1, 16);
        this.Import_Box10.setRotationPoint(-16.0f, -30.0f, -8.0f);
        this.Import_Box10.setTextureSize(64, 32);
        this.Import_Box10.mirror = true;
        this.setRotation(this.Import_Box10, 0.0f, 0.0f, 0.0f);
        this.Import_Box11 = new ModelRenderer((ModelBase)this, 81, 33);
        this.Import_Box11.addBox(-3.0f, 0.0f, -3.0f, 6, 4, 9);
        this.Import_Box11.setRotationPoint(-9.0f, -21.0f, -1.0f);
        this.Import_Box11.setTextureSize(64, 32);
        this.Import_Box11.mirror = true;
        this.setRotation(this.Import_Box11, 0.0f, 1.867502f, 0.0f);
        this.Import_Box12 = new ModelRenderer((ModelBase)this, 89, 49);
        this.Import_Box12.addBox(-3.0f, 0.0f, -3.0f, 5, 4, 7);
        this.Import_Box12.setRotationPoint(5.0f, -21.0f, -1.0f);
        this.Import_Box12.setTextureSize(64, 32);
        this.Import_Box12.mirror = true;
        this.setRotation(this.Import_Box12, 0.0f, 1.064651f, 0.0f);
        this.Import_Box13 = new ModelRenderer((ModelBase)this, 97, 73);
        this.Import_Box13.addBox(-3.0f, 0.0f, -3.0f, 5, 4, 7);
        this.Import_Box13.setRotationPoint(5.0f, -8.0f, -1.0f);
        this.Import_Box13.setTextureSize(64, 32);
        this.Import_Box13.mirror = true;
        this.setRotation(this.Import_Box13, 0.0f, 1.937315f, 0.0f);
        this.Import_Box14 = new ModelRenderer((ModelBase)this, 1, 81);
        this.Import_Box14.addBox(-3.0f, 0.0f, -3.0f, 5, 2, 7);
        this.Import_Box14.setRotationPoint(-9.0f, -6.0f, -1.0f);
        this.Import_Box14.setTextureSize(64, 32);
        this.Import_Box14.mirror = true;
        this.setRotation(this.Import_Box14, 0.0f, 1.291544f, 0.0f);
        this.Import_Box15 = new ModelRenderer((ModelBase)this, 33, 1);
        this.Import_Box15.addBox(-3.0f, 0.0f, -3.0f, 3, 2, 4);
        this.Import_Box15.setRotationPoint(-7.0f, -8.0f, -1.0f);
        this.Import_Box15.setTextureSize(64, 32);
        this.Import_Box15.mirror = true;
        this.setRotation(this.Import_Box15, 0.0f, 0.8552113f, 0.0f);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

	@Override
	public void render() {
        this.Import_Box0.render(f5);
        this.Import_Box1.render(f5);
        this.Import_Box2.render(f5);
        this.Import_Box3.render(f5);
        this.Import_Box4.render(f5);
        this.Import_Box5.render(f5);
        this.Import_Box6.render(f5);
        this.Import_Box7.render(f5);
        this.Import_Box8.render(f5);
        this.Import_Box9.render(f5);
        this.Import_Box10.render(f5);
	}
}

