package by.fxg.craftingdead.client.render;

import org.lwjgl.opengl.GL11;

import by.fxg.craftingdead.CDReloaded;
import by.fxg.craftingdead.client.model.ModelBush;
import by.fxg.craftingdead.inventory.InventoryCDA;
import by.fxg.craftingdead.player.PlayerData;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class RenderBackpackLarge extends RenderBackpack {
	public RenderBackpackLarge(String par1, ModelBase par2) {
		super(par1, par2);
	}

	public void renderBackpack(EntityPlayer par1, ItemStack par2) {
		PlayerData data = CDReloaded.instance.playerDataHandler().getPlayerData(par1.username);
		InventoryCDA inv = data.getCDInventory();
		ItemStack stack = inv.getStack("upgrade");
		double scale = 1.0D;
		GL11.glScaled(scale, scale, scale);
		GL11.glTranslated(-0.0D, 0.02D, 0.37D);
		GL11.glRotated(180.0D, 1.0D, 0.0D, 0.0D);
		GL11.glRotated(180.0D, 0.0D, 0.0D, 1.0D);
		super.model.render(par1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
		if (stack != null) {
			GL11.glPushMatrix();
			GL11.glTranslatef(-0.19f, 0.1f, 0.0f);
			GL11.glScalef(1f, 1f, 1f);
			((ModelBush) bush).renderLarge(0.0625f);
			GL11.glTranslatef(0.0f, 0.3f, 0.05f);
			((ModelBush) bush).renderLarge(0.0625f);
			GL11.glTranslatef(0.0f, -0.1f, -0.1f);
			((ModelBush) bush).renderLarge(0.0625f);
			GL11.glTranslatef(0.0f, -0.2f, 0.05f);
			GL11.glPushMatrix();
			GL11.glScalef(0.25f, 0.25f, 0.25f);
			GL11.glTranslatef(2.2f, 0.0f, 0.0f);
			GL11.glRotatef(45f, 0f, 0f, 1f);
			((ModelBush) bush).renderLeafLarge(0.0625f);
			GL11.glPopMatrix();
			GL11.glPushMatrix();
			GL11.glScalef(0.25f, 0.25f, 0.25f);
			GL11.glTranslatef(-1.2f, -0.6f, 0.0f);
			GL11.glRotatef(-45f, 0f, 0f, 1f);
			((ModelBush) bush).renderLeafLarge(0.0625f);
			GL11.glPopMatrix();
			GL11.glPushMatrix();
			GL11.glScalef(0.25f, 0.25f, 0.25f);
			GL11.glTranslatef(0.2f, 0.0f, -0.7f);
			GL11.glRotatef(90f, 0f, 1f, 0f);
			GL11.glRotatef(45f, 0f, 0f, 1f);
			((ModelBush) bush).renderLeafSmall(0.0625f);
			GL11.glPopMatrix();
			GL11.glPopMatrix();
		}
	}
}
