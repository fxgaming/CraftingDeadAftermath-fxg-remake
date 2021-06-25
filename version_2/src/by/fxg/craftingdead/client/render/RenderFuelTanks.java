package by.fxg.craftingdead.client.render;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class RenderFuelTanks {
	protected ModelBase model;
	protected String texture;

	public RenderFuelTanks(String par1, ModelBase par2) {
		this.texture = par1;
		this.model = par2;
	}

	public void renderBackpack(EntityPlayer par1, ItemStack par2) {
		double scale = 1.05D;
		GL11.glScaled(scale, scale, scale);
		GL11.glTranslated(-0.0D, -0.01D, -0.12D);
		GL11.glRotated(180.0D, 1.0D, 0.0D, 0.0D);
		GL11.glRotated(180.0D, 0.0D, 0.0D, 1.0D);
		GL11.glRotated(180.0D, 0.0D, 1.0D, 0.0D);
		GL11.glEnable(2884);
		this.model.render(par1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
		GL11.glDisable(2884);
	}

	public String getTexture() {
		return this.texture;
	}
}
