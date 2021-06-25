package com.fxg.decoration.model.block;

import org.lwjgl.opengl.GL11;

import com.fxg.decoration.model.IModel;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelTrashbox1 extends ModelBase implements IModel {
	ModelRenderer Shape1;
	ModelRenderer Shape2;
	ModelRenderer Shape3;
	ModelRenderer Shape4;
	ModelRenderer Shape5;
	ModelRenderer Shape6;
	ModelRenderer Shape7;
	ModelRenderer Shape8;
	ModelRenderer Shape9;
	ModelRenderer Shape10;
	ModelRenderer Shape11;

	public ModelTrashbox1() {
		textureWidth = 64;
		textureHeight = 64;

		Shape1 = new ModelRenderer(this, 0, 13).addBox(0F, 0F, 0F, 10, 1, 10);
		Shape1.setTextureSize(64, 64).setRotationPoint(-5F, 23F, -5F);
		a(Shape1, 0F, 0F, 0F);
		Shape1.mirror = true;
		Shape2 = new ModelRenderer(this, 0, 24).addBox(0F, 0F, 0F, 10, 18, 1);
		Shape2.setTextureSize(64, 64).setRotationPoint(-5F, 5F, -5F);
		a(Shape2, 0F, 0F, 0F);
		Shape2.mirror = true;
		Shape3 = new ModelRenderer(this, 0, 24).addBox(0F, 0F, 0F, 10, 18, 1);
		Shape3.setTextureSize(64, 64).setRotationPoint(-5F, 5F, 4F);
		a(Shape3, 0F, 0F, 0F);
		Shape3.mirror = true;
		Shape4 = new ModelRenderer(this, 40, 5).addBox(0F, 0F, 0F, 1, 18, 8);
		Shape4.setTextureSize(64, 64).setRotationPoint(4F, 5F, -4F);
		a(Shape4, 0F, 0F, 0F);
		Shape4.mirror = true;
		Shape5 = new ModelRenderer(this, 40, 5).addBox(0F, 0F, 0F, 1, 18, 8);
		Shape5.setTextureSize(64, 64).setRotationPoint(-5F, 5F, -4F);
		a(Shape5, 0F, 0F, 0F);
		Shape5.mirror = true;
		Shape6 = new ModelRenderer(this, 0, 0).addBox(0F, 0F, 0F, 11, 1, 12);
		Shape6.setTextureSize(64, 64).setRotationPoint(-5.5F, 4F, -6.5F);
		a(Shape6, 0F, 0F, 0F);
		Shape6.mirror = true;
		Shape7 = new ModelRenderer(this, 0, 13).addBox(0F, 0F, 0F, 10, 1, 10);
		Shape7.setTextureSize(64, 64).setRotationPoint(-5F, 3.5F, -6F);
		a(Shape7, 0F, 0F, 0F);
		Shape7.mirror = true;
		Shape8 = new ModelRenderer(this, 0, 0).addBox(0F, 0F, 0F, 2, 1, 1);
		Shape8.setTextureSize(64, 64).setRotationPoint(2F, 3F, 4F);
		a(Shape8, 0F, 0F, 0F);
		Shape8.mirror = true;
		Shape9 = new ModelRenderer(this, 0, 0).addBox(0F, 0F, 0F, 2, 1, 1);
		Shape9.setTextureSize(64, 64).setRotationPoint(-4F, 3F, 4F);
		a(Shape9, 0F, 0F, 0F);
		Shape9.mirror = true;
		Shape10 = new ModelRenderer(this, 0, 2).addBox(0F, 0F, 0F, 1, 3, 3);
		Shape10.setTextureSize(64, 64).setRotationPoint(5F, 21F, 3F);
		a(Shape10, 0F, 0F, 0F);
		Shape10.mirror = true;
		Shape11 = new ModelRenderer(this, 0, 2).addBox(0F, 0F, 0F, 1, 3, 3);
		Shape11.setTextureSize(64, 64).setRotationPoint(-6F, 21F, 3F);
		a(Shape11, 0F, 0F, 0F);
		Shape11.mirror = true;
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	}

	private void a(ModelRenderer a, float b, float c, float d) {
		a.rotateAngleX = b;
		a.rotateAngleY = c;
		a.rotateAngleZ = d;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	}

	@Override
	public void render() {
		float f5 = 0.0625F;
		GL11.glTranslatef(0.0F, -1.5F, 0.0F);
		Shape1.render(f5);
		Shape2.render(f5);
		Shape3.render(f5);
		Shape4.render(f5);
		Shape5.render(f5);
		Shape6.render(f5);
		Shape7.render(f5);
		Shape8.render(f5);
		Shape9.render(f5);
		Shape10.render(f5);
		Shape11.render(f5);
	}
}
