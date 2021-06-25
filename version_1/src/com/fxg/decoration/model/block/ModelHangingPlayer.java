package com.fxg.decoration.model.block;

import org.lwjgl.opengl.GL11;
import com.fxg.decoration.model.IModel;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelHangingPlayer extends ModelBase implements IModel {
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

    public ModelHangingPlayer() {
        this.textureWidth = 64;
        this.textureHeight = 128;
        this.Box_0 = new ModelRenderer((ModelBase)this, 1, 1);
        this.Box_0.addBox(-4.0f, -8.0f, -2.0f, 8, 8, 8);
        this.Box_0.setRotationPoint(-0.3f, 13.0f, 2.0f);
        this.Box_0.setTextureSize(64, 32);
        this.Box_0.mirror = true;
        this.setRotation(this.Box_0, -0.9250245f, 0.0f, 0.1570796f);
        this.Box_1 = new ModelRenderer((ModelBase)this, 33, 17);
        this.Box_1.addBox(0.0f, 0.0f, 0.0f, 8, 12, 4);
        this.Box_1.setRotationPoint(-4.3f, 13.0f, 2.0f);
        this.Box_1.setTextureSize(64, 32);
        this.Box_1.mirror = true;
        this.setRotation(this.Box_1, -0.2268928f, 0.0f, 0.0f);
        this.Box_2 = new ModelRenderer((ModelBase)this, 1, 25);
        this.Box_2.addBox(-4.0f, 0.0f, 0.0f, 4, 12, 4);
        this.Box_2.setRotationPoint(-4.3f, 13.0f, 2.0f);
        this.Box_2.setTextureSize(64, 32);
        this.Box_2.mirror = true;
        this.setRotation(this.Box_2, -0.0349066f, 0.0f, 0.0872665f);
        this.Box_3 = new ModelRenderer((ModelBase)this, 17, 41);
        this.Box_3.addBox(0.0f, 0.0f, 0.0f, 4, 12, 4);
        this.Box_3.setRotationPoint(3.7f, 13.0f, 2.0f);
        this.Box_3.setTextureSize(64, 32);
        this.Box_3.mirror = true;
        this.setRotation(this.Box_3, 0.0f, 0.0f, -0.0523599f);
        this.Box_4 = new ModelRenderer((ModelBase)this, 41, 41);
        this.Box_4.addBox(-4.0f, 0.0f, 0.0f, 4, 12, 4);
        this.Box_4.setRotationPoint(-0.3f, 25.0f, -0.5f);
        this.Box_4.setTextureSize(64, 32);
        this.Box_4.mirror = true;
        this.setRotation(this.Box_4, 0.0f, 0.0f, 0.0349066f);
        this.Box_5 = new ModelRenderer((ModelBase)this, 1, 57);
        this.Box_5.addBox(0.0f, 0.0f, 0.0f, 4, 12, 4);
        this.Box_5.setRotationPoint(-0.3f, 25.0f, -0.5f);
        this.Box_5.setTextureSize(64, 32);
        this.Box_5.mirror = true;
        this.setRotation(this.Box_5, 0.0f, 0.0f, -0.0349066f);
        this.Box_6 = new ModelRenderer((ModelBase)this, 33, 1);
        this.Box_6.addBox(0.0f, 0.0f, 0.0f, 4, 2, 4);
        this.Box_6.setRotationPoint(-2.5f, 11.0f, 2.5f);
        this.Box_6.setTextureSize(64, 32);
        this.Box_6.mirror = true;
        this.setRotation(this.Box_6, -0.2792527f, 0.8203047f, 0.0523599f);
        this.Box_7 = new ModelRenderer((ModelBase)this, 57, 1);
        this.Box_7.addBox(0.0f, 0.0f, 0.0f, 1, 13, 1);
        this.Box_7.setRotationPoint(-0.3f, -0.5f, 0.25f);
        this.Box_7.setTextureSize(64, 32);
        this.Box_7.mirror = true;
        this.setRotation(this.Box_7, 0.0f, 0.0f, 0.0f);
        this.Box_8 = new ModelRenderer((ModelBase)this, 41, 9);
        this.Box_8.addBox(0.0f, 0.0f, 0.0f, 2, 5, 2);
        this.Box_8.setRotationPoint(-0.8f, -0.5f, -0.25f);
        this.Box_8.setTextureSize(64, 32);
        this.Box_8.mirror = true;
        this.setRotation(this.Box_8, 0.0f, 0.0f, 0.0f);
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
        float realTick = (float)(Minecraft.getMinecraft().getSystemTime() % 9999999 / 32);
        float val = (float)(Math.sin(realTick / 20.0f) * 20.0);
        GL11.glTranslatef(0.0F, -1.0F, 0.0F);
        GL11.glPushMatrix();
        GL11.glRotated((double)(val / 20.0f), (double)0.0, (double)1.0, (double)0.0);
        this.Box_0.render(f5);
        GL11.glPopMatrix();
        this.Box_1.render(f5);
        this.Box_2.render(f5);
        this.Box_3.render(f5);
        this.Box_6.render(f5);
        this.Box_7.render(f5);
        this.Box_8.render(f5);
        GL11.glPushMatrix();
        GL11.glRotated((double)(val / 10.0f), (double)0.0, (double)1.0, (double)0.0);
        this.Box_4.render(f5);
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        GL11.glRotated((double)(val / 20.0f), (double)0.0, (double)1.0, (double)0.0);
        this.Box_5.render(f5);
        GL11.glPopMatrix();
	}
}

