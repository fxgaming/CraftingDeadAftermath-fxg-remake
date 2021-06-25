package com.fxg.decoration.model.block;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import org.lwjgl.opengl.GL11;

import com.fxg.decoration.model.IModel;

public class ModelLight extends ModelBase implements IModel {
    int x = 0;
    ModelRenderer Part_0;

    public ModelLight() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.Part_0 = new ModelRenderer((ModelBase)this, 1, 1);
        this.Part_0.addBox(0.0f, 0.0f, 0.0f, 22, 3, 6);
        this.Part_0.setRotationPoint(-11.0f, -16.0f, -3.0f);
        this.Part_0.setTextureSize(64, 32);
        this.Part_0.mirror = true;
        this.setRotation(this.Part_0, 0.0f, 0.0f, 0.0f);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

	@Override
	public void render() {
        GL11.glScaled((double)0.7, (double)0.7, (double)0.7);
        GL11.glRotatef((float)90.0f, (float)0.0f, (float)1.0f, (float)0.0f);
        GL11.glTranslated((double)0.0, (double)-0.45, (double)0.0);
        this.Part_0.render(f5);
	}
}

