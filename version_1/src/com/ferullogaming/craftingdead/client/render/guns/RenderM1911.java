package com.ferullogaming.craftingdead.client.render.guns;

import org.lwjgl.opengl.GL11;

import com.ferullogaming.craftingdead.client.model.guns.ModelM1911;
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

public class RenderM1911 extends RenderGun {
	private ModelPistolIS1 ironSight1 = new ModelPistolIS1();
	private ModelPistolIS2 ironSight2 = new ModelPistolIS2();
	
	public void renderSpecials(ItemStack itemstack, boolean var2) {
		ItemGun gun = (ItemGun) itemstack.getItem();
		int sp = gun.getGunSpecials(itemstack);
		if (sp != 0) {
			if (var2) {
				GL11.glPushMatrix();
				GL11.glScalef(1.25f, 0.9f, 0.6f);
				GL11.glTranslatef(0.1f, 0.04f, 0.0125f);
				this.bush.renderMedium(0.0625f);
				GL11.glPopMatrix();
			} else {
				GL11.glPushMatrix();
				GL11.glScalef(1.25f, 0.9f, 0.6f);
				GL11.glTranslatef(0.1f, 0.04f, 0.0125f);
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
		GL11.glTranslatef(-0.5F, 0.25F, 0.0F);
	}

	public void renderHand(int var1, EntityPlayer var2) {
		GL11.glPushMatrix();
		GL11.glTranslatef(-0.15f, 0.4f, -0.2f);
		GL11.glRotatef(60.0f, 0.0f, 0.0f, -1.0f);
		GL11.glScalef(0.8f, 0.8f, 0.8f);
		this.lh.render(var2);
		GL11.glScalef(1.0f, 1.0f, 1.0f);
		GL11.glPopMatrix();
		GL11.glRotatef(6.0f, 0.0f, 0.0f, -1.0f);
		GL11.glTranslatef(-0.1f, 0.08f, 0.0f);
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
		GL11.glTranslatef(0.1F, -0.701F, 0.972F);
		if (ItemGun.instance().getAttachmentFromSlot(itemstack, 0) != null) {
			GL11.glTranslatef(0.0F, 0.03F, 0.0F);
		}
		double scale = 0.6D;
		GL11.glScaled(scale, scale, scale);
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
		GL11.glTranslatef(-0.2F, -0.1F, -0.25F);
		GL11.glRotated(180.0D, 0.0D, 1.0D, 0.0D);
		super.mc.getTextureManager().bindTexture(new ResourceLocation("craftingdead:textures/models/guns/m1911modelis1.png"));
		this.ironSight1.render((Entity) null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
		GL11.glPopMatrix();
	}

	private void renderIronSight2() {
		GL11.glPushMatrix();
		GL11.glTranslatef(0.75F, -0.04F, 0.07F);
		double scale = 0.25D;
		GL11.glScaled(scale, scale, scale);
		GL11.glRotated(90.0D, 0.0D, 1.0D, 0.0D);
		super.mc.getTextureManager().bindTexture(new ResourceLocation("craftingdead:textures/models/guns/m1911modelis2.png"));
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
		GL11.glTranslatef(1.7F, -0.3F, -0.7F);
	}

	protected void renderGunAmmo(Entity entityplayer, ItemStack itemstack) {
		if (itemstack.itemID == ItemManager.m1911Ammo.itemID) {
			GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
			GL11.glRotatef(-8.0F, 0.0F, 0.0F, 1.0F);
			GL11.glTranslatef(-1.8F, 1.0F, -1.25F);
			double scale = 1.0D;
			GL11.glScaled(scale, scale, scale);
		}
	}

	protected void renderGunAttachment(Entity entityplayer, ItemStack itemstack, GunAttachment attachment) {
		double scale;
		if (attachment == GunAttachment.SURPPRESSOR) {
			GL11.glTranslatef(14.3F, 0.25F, 1.25F);
			scale = 1.0D;
			GL11.glScaled(scale, scale, scale);
		}
		if (attachment == GunAttachment.MUZZLE_BRAKE) {
			GL11.glTranslatef(8.3F, -0.25F, -0.35F);
			scale = 1.0D;
			GL11.glScaled(scale, scale, scale);
		}
		if (attachment == GunAttachment.REDDOT) {
			GL11.glTranslated(0.1D, -0.5D, 0.155D);
			scale = 0.75D;
			GL11.glScaled(scale, scale, scale);
		}
	}

	protected ModelBase getGunModel() {
		return this.m1911;
	}

	protected String getTexture() {
		return "m1911model";
	}
}
