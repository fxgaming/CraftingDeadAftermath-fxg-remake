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

public class RenderM9 extends RenderGun {
	private ModelPistolIS1 ironSight1 = new ModelPistolIS1();
	private ModelPistolIS2 ironSight2 = new ModelPistolIS2();

	public void renderSpecials(ItemStack itemstack, boolean var2) {
		ItemGun gun = (ItemGun) itemstack.getItem();
		int sp = gun.getGunSpecials(itemstack);
		if (sp != 0) {
			if (var2) {
				GL11.glPushMatrix();
				GL11.glScalef(1.1f, 0.6f, 0.6f);
				GL11.glTranslatef(0.1f, 0.025f, 0.0125f);
				this.bush.renderMedium(0.0625f);
				GL11.glPopMatrix();
			} else {
				GL11.glPushMatrix();
				GL11.glScalef(1.1f, 0.6f, 0.6f);
				GL11.glTranslatef(0.1f, 0.025f, 0.0125f);
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
		GL11.glTranslatef(-0.55F, 0.325F, 0.0F);
	}

	public void renderHand(int var1, EntityPlayer var2) {
		GL11.glPushMatrix();
		GL11.glTranslatef(-0.15f, 0.4f, -0.2f);
		GL11.glRotatef(60.0f, 0.0f, 0.0f, -1.0f);
		this.lh.render(var2);
		GL11.glPopMatrix();
		GL11.glRotatef(6.0f, 0.0f, 0.0f, -1.0f);
		GL11.glTranslatef(0.08f, 0.1f, 0.1f);
	}

	protected void renderGunFirstPerson(EntityPlayer entityplayer, ItemStack itemstack) {
		GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
		GL11.glRotatef(-40.0F, 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(-5.0F, 0.0F, 1.0F, 0.0F);
		GL11.glTranslatef(0.55F, -0.25F, 0.2F);
		double scale = 0.8D;
		GL11.glScaled(scale, scale, scale);
	}

	protected void renderGunFirstPersonAiming(EntityPlayer entityplayer, ItemStack itemstack) {
		GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
		GL11.glRotatef(-25.0F, 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(5.0F, 0.0F, 1.0F, 0.0F);
		GL11.glTranslatef(0.2F, -0.695F, 0.972F);
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
		GL11.glTranslatef(-0.3F, -0.15F, -0.25F);
		GL11.glRotated(180.0D, 0.0D, 1.0D, 0.0D);
		super.mc.getTextureManager().bindTexture(new ResourceLocation("craftingdead:textures/models/guns/g18modelis1.png"));
		this.ironSight1.render((Entity) null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
		GL11.glPopMatrix();
	}

	private void renderIronSight2() {
		GL11.glPushMatrix();
		GL11.glTranslatef(0.6F, -0.05F, 0.07F);
		double scale = 0.25D;
		GL11.glScaled(scale, scale, scale);
		GL11.glRotated(90.0D, 0.0D, 1.0D, 0.0D);
		super.mc.getTextureManager().bindTexture(new ResourceLocation("craftingdead:textures/models/guns/g18modelis2.png"));
		this.ironSight2.render((Entity) null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
		GL11.glPopMatrix();
	}

	protected void renderGunOnGround(Entity entity, ItemStack itemstack) {
		GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
		double scale = 1.0D;
		GL11.glScaled(scale, scale, scale);
	}

	protected void renderGunOnPlayerBack(EntityPlayer entity, ItemStack itemstack) {
		GL11.glRotatef(90.0F, 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
		double scale = 0.55D;
		GL11.glScaled(scale, scale, scale);
		GL11.glTranslatef(1.1F, -0.2F, -0.58F);
	}

	protected void renderGunAmmo(Entity entityplayer, ItemStack itemstack) {
		if (itemstack.itemID == ItemManager.m9Ammo.itemID) {
			GL11.glRotatef(5.0F, 0.0F, 0.0F, 1.0F);
		}
	}

	protected void renderGunAttachment(Entity entityplayer, ItemStack itemstack, GunAttachment attachment) {
		if (attachment == GunAttachment.SURPPRESSOR) {
			GL11.glTranslatef(12.0F, -0.3F, 1.2F);
			double scale = 0.9D;
			GL11.glScaled(scale, scale, scale);
		}
	}

	protected ModelBase getGunModel() {
		return this.m9;
	}

	protected String getTexture() {
		return "m9model";
	}
}
