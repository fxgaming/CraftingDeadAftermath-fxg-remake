package com.ferullogaming.craftingdead.client.render.guns;

import org.lwjgl.opengl.GL11;

import com.ferullogaming.craftingdead.client.model.guns.ModelPistolIS1;
import com.ferullogaming.craftingdead.client.model.guns.ModelPistolIS2;
import com.ferullogaming.craftingdead.item.ItemManager;
import com.ferullogaming.craftingdead.item.gun.GunAttachment;
import com.ferullogaming.craftingdead.item.gun.ItemGun;

import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class RenderG18 extends RenderGun {
	private ModelPistolIS1 ironSight1 = new ModelPistolIS1();
	private ModelPistolIS2 ironSight2 = new ModelPistolIS2();

	public void renderSpecials(ItemStack itemstack, boolean var2) {
		ItemGun gun = (ItemGun) itemstack.getItem();
		int sp = gun.getGunSpecials(itemstack);
		if (sp != 0) {
			if (var2) {
				GL11.glPushMatrix();
				GL11.glScalef(1.75f, 0.9f, 0.75f);
				GL11.glTranslatef(0.1f, 0.04f, 0.03f);
				this.bush.renderMedium(0.0625f);
				GL11.glPopMatrix();
			} else {
				GL11.glPushMatrix();
				GL11.glScalef(1.75f, 0.9f, 0.75f);
				GL11.glTranslatef(0.1f, 0.04f, 0.03f);
				this.bush.renderMedium(0.0625f);
				GL11.glPopMatrix();
			}
		}
	}

	public void renderGunThirdPerson(Entity entityplayer, ItemStack itemstack) {
		GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
		GL11.glRotatef(-15.0F, 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(77.0F, 0.0F, 1.0F, 0.0F);
		GL11.glTranslatef(0.6F, -0.4F, 0.35F);
		GL11.glRotatef(15.0F, 0.0F, 0.0F, 1.0F);
		GL11.glTranslatef(-0.6F, 0.25F, 0.0F);
		double scale = 0.75D;
		GL11.glScaled(scale, scale, scale);
	}

	public void renderHand(int var1, EntityPlayer var2) {
		GL11.glPushMatrix();
		GL11.glTranslatef(-0.15f, 0.4f, -0.2f);
		GL11.glRotatef(60.0f, 0.0f, 0.0f, -1.0f);
		this.lh.render(var2);
		GL11.glPopMatrix();
		GL11.glRotatef(6f, 0.0f, 0.0f, -1.0f);
		GL11.glTranslatef(0.0f, 0.07f, 0.0f);
	}

	protected void renderGunFirstPerson(EntityPlayer entityplayer, ItemStack itemstack) {
		GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
		GL11.glRotatef(-40.0F, 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(-5.0F, 0.0F, 1.0F, 0.0F);
		GL11.glTranslatef(0.6F, -0.2F, 0.1F);
		double scale = 0.6D;
		GL11.glScaled(scale, scale, scale);
	}

	protected void renderGunFirstPersonAiming(EntityPlayer entityplayer, ItemStack itemstack) {
		GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
		GL11.glRotatef(-25.0F, 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(5.0F, 0.0F, 1.0F, 0.0F);
		GL11.glTranslatef(0.2F, -0.695F, 0.9525F);
		if (ItemGun.instance().getAttachmentFromSlot(itemstack, 0) != null) {
			GL11.glTranslatef(0.0F, 0.02F, 0.0F);
		}

		double scale = 0.6D;
		GL11.glScaled(scale, scale, scale);
		GL11.glRotatef(0.0F, 0.0F, 0.0F, 1.0F);
	}

	protected void renderIronSights(ItemStack itemstack) {
		if (ItemGun.instance().getAttachmentFromSlot(itemstack, 0) == null) {
			this.renderIronSight1();
			this.renderIronSight2();
		}

	}

	private void renderIronSight1() {
		GL11.glPushMatrix();
		GL11.glRotated(180.0D, 0.0D, 1.0D, 0.0D);
		double scale = 0.5D;
		GL11.glScaled(scale, scale, scale);
		scale = 0.5D;
		GL11.glScaled(scale, scale, scale);
		GL11.glTranslatef(-0.625F, -0.15F, -0.375F);
		GL11.glRotated(180.0D, 0.0D, 1.0D, 0.0D);
		super.mc.getTextureManager().bindTexture(new ResourceLocation("craftingdead:textures/models/guns/g18modelis1.png"));
		this.ironSight1.render((Entity) null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
		GL11.glPopMatrix();
	}

	private void renderIronSight2() {
		GL11.glPushMatrix();
		GL11.glTranslatef(0.9F, -0.05F, 0.102F);
		double scale = 0.25D;
		GL11.glScaled(scale, scale, scale);
		GL11.glRotated(90.0D, 0.0D, 1.0D, 0.0D);
		super.mc.getTextureManager().bindTexture(new ResourceLocation("craftingdead:textures/models/guns/g18modelis2.png"));
		this.ironSight2.render((Entity) null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
		GL11.glPopMatrix();
	}

	protected void renderGunOnGround(Entity entity, ItemStack itemstack) {
		GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
		double scale = 0.7D;
		GL11.glScaled(scale, scale, scale);
	}

	protected void renderGunOnPlayerBack(EntityPlayer entity, ItemStack itemstack) {
		GL11.glRotatef(90.0F, 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
		double scale = 0.45D;
		GL11.glScaled(scale, scale, scale);
		GL11.glTranslatef(1.3F, -0.3F, -0.7F);
	}

	protected void renderGunAmmo(Entity entityplayer, ItemStack itemstack) {
		if (itemstack.itemID == ItemManager.g18Ammo.itemID) {
			GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
			GL11.glRotatef(-12.0F, 0.0F, 0.0F, 1.0F);
			GL11.glTranslatef(-3.0F, 3.5F, -1.7F);
			double scale = 1.2D;
			GL11.glScaled(scale, scale, scale);
		}
	}

	protected void renderGunAttachment(Entity entityplayer, ItemStack itemstack, GunAttachment attachment) {
		double scale;
		if (attachment == GunAttachment.SURPPRESSOR) {
			GL11.glTranslatef(16.3F, 0.0F, 1.6F);
			scale = 1.0D;
			GL11.glScaled(scale, scale, scale);
		}
		if (attachment == GunAttachment.REDDOT) {
			GL11.glTranslated(0.0D, -0.5D, 0.482D);
			scale = 0.75D;
			GL11.glScaled(scale, scale, scale);
		}
	}

	protected ModelBase getGunModel() {
		return this.g18;
	}

	protected String getTexture() {
		return "g18model";
	}
}
