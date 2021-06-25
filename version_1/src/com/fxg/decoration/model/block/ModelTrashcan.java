package com.fxg.decoration.model.block;

import com.fxg.decoration.model.IModel;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelTrashcan extends ModelBase implements IModel {
    int x = 0;
    ModelRenderer Part_0;
    ModelRenderer Part_1;

    public ModelTrashcan() {
        this.textureWidth = 128;
        this.textureHeight = 32;
        this.Part_0 = new ModelRenderer((ModelBase)this, 49, 0);
        this.Part_0.addBox(0.0f, 0.0f, 0.0f, 14, 2, 14);
        this.Part_0.setRotationPoint(-7.0f, -19.0f, -7.0f);
        this.Part_0.setTextureSize(512, 512);
        this.Part_0.mirror = true;
        this.setRotation(this.Part_0, 0.0f, 0.0f, 0.0f);
        this.Part_1 = new ModelRenderer((ModelBase)this, 0, 0);
        this.Part_1.addBox(0.0f, 0.0f, 0.0f, 12, 17, 12);
        this.Part_1.setRotationPoint(-6.0f, -17.0f, -6.0f);
        this.Part_1.setTextureSize(512, 512);
        this.Part_1.mirror = true;
        this.setRotation(this.Part_1, 0.0f, 0.0f, 0.0f);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5);
        this.Part_0.render(f5);
        this.Part_1.render(f5);
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
		// TODO Auto-generated method stub
		
	}
}

