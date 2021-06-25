package com.ferullogaming.craftingdead.client.render;

import com.ferullogaming.craftingdead.client.model.ModelBush;

import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public abstract class RenderBackpack {
	protected ModelBase model;
	protected String texture;
	protected ModelBush bush = new ModelBush();

	public RenderBackpack(String par1, ModelBase par2) {
		this.texture = par1;
		this.model = par2;
	}

	public abstract void renderBackpack(EntityPlayer var1, ItemStack var2);

	public String getTexture() {
		return this.texture;
	}
}
