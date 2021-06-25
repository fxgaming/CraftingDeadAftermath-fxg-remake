package com.fxg.decoration.model.block;

import org.lwjgl.opengl.GL11;

import com.fxg.decoration.model.IModel;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelCanTrap extends ModelBase implements IModel {
    ModelRenderer Part_0;
    ModelRenderer Part_1;

    public ModelCanTrap() {
        this.textureWidth = 32;
        this.textureHeight = 128;
        this.Part_0 = new ModelRenderer((ModelBase)this, 1, 1);
        this.Part_0.addBox(0.0f, 0.0f, 0.0f, 5, 10, 5);
        this.Part_0.setRotationPoint(-2.5f, 87.0f, -2.5f);
        this.Part_0.setTextureSize(32, 128);
        this.Part_0.mirror = true;
        this.setRotation(this.Part_0, 0.0f, 0.0f, 0.0f);
        this.Part_1 = new ModelRenderer((ModelBase)this, 25, 1);
        this.Part_1.addBox(0.0f, 0.0f, 0.0f, 1, 86, 1);
        this.Part_1.setRotationPoint(-0.5f, 10.0f, -0.5f);
        this.Part_1.setTextureSize(32, 128);
        this.Part_1.mirror = true;
        this.setRotation(this.Part_1, 0.0f, 0.0f, 0.0f);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

	@Override
	public void render() {
        GL11.glScaled((double)0.5, (double)0.5, (double)0.5);
        GL11.glTranslatef((float)0.0f, (float)-7.0f, (float)0.0f);
        //float realTick = VariablesClient.smoothSwing;
        //float val = (float)Math.sin(realTick / 60.0f);
        //float val2 = (float)(Math.sin(realTick / 50.0f) / 2.0);
        //GL11.glRotatef((float)val, (float)1.0f, (float)0.0f, (float)0.0f);
        //GL11.glRotatef((float)val2, (float)0.0f, (float)0.0f, (float)1.0f);
        this.Part_0.render(f5);
        this.Part_1.render(f5);
	}
}

