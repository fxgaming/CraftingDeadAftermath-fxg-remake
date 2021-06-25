package com.fxg.decoration.model.block;

import com.fxg.decoration.model.IModel;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelRoadsign extends ModelBase implements IModel {
    ModelRenderer Part_0;
    ModelRenderer Part_1;

    public ModelRoadsign() {
        this.textureWidth = 32;
        this.textureHeight = 64;
        this.Part_0 = new ModelRenderer((ModelBase)this, 1, 1);
        this.Part_0.addBox(0.0f, 0.0f, 0.0f, 1, 33, 1);
        this.Part_0.setRotationPoint(-0.5f, -33.0f, -0.5f);
        this.Part_0.setTextureSize(32, 64);
        this.Part_0.mirror = true;
        this.setRotation(this.Part_0, 0.0f, 0.0f, 0.0f);
        this.Part_1 = new ModelRenderer((ModelBase)this, 9, 1);
        this.Part_1.addBox(0.0f, 0.0f, 0.0f, 1, 10, 9);
        this.Part_1.setRotationPoint(0.0f, -35.0f, -4.5f);
        this.Part_1.setTextureSize(32, 64);
        this.Part_1.mirror = true;
        this.setRotation(this.Part_1, 0.0f, 0.0f, 0.0f);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    }

	@Override
	public void render() {
        this.Part_0.render(f5);
        this.Part_1.render(f5);
	}
}

