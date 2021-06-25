package com.ferullogaming.craftingdead.client.render.hat;

import org.lwjgl.opengl.GL11;

import com.ferullogaming.craftingdead.CDAftermath;
import com.ferullogaming.craftingdead.client.model.ModelBush;
import com.ferullogaming.craftingdead.client.model.hats.ModelHatArmyHelmet;
import com.ferullogaming.craftingdead.inventory.InventoryCDA;
import com.ferullogaming.craftingdead.player.PlayerData;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class RenderHatArmyhelmet extends RenderHat {
	public ModelBush bush = new ModelBush();

	public RenderHatArmyhelmet(String par1) {
		super.hatModel = new ModelHatArmyHelmet();
		super.texture = "hatModel_armyhelmet";
		super.texture = par1;
	}

	public void renderHat(EntityPlayer par1, ItemStack par2) {
		PlayerData data = CDAftermath.instance.playerDataHandler().getPlayerData(par1.username);
		InventoryCDA inv = data.getCDInventory();
		ItemStack stack = inv.getStack("upgrade");
		if (stack != null) {
			GL11.glPushMatrix();
			GL11.glTranslatef(-0.19f, -0.5f, -0.125f);
			GL11.glScalef(1.0f, 1.0f, 1.4f);
			this.bush.renderLarge(0.0625f);
			GL11.glRotatef(90f, 1f, 0f, 0f);
			GL11.glTranslatef(-0.0f, 0.0f, -0.275f);
			this.bush.renderLarge(0.0625f);
			GL11.glPopMatrix();
		}
		double scale = 0.1D;
		GL11.glScaled(scale, scale, scale);
		GL11.glTranslated(-0.25D, -3.0D, -0.25D);
		this.bindTexture();
		this.renderModel(par1);
	}
}
