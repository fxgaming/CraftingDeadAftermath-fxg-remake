package com.ferullogaming.craftingdead.client.render.guns;

import org.lwjgl.opengl.GL11;

import com.ferullogaming.craftingdead.client.model.guns.ModelScarhIS1;
import com.ferullogaming.craftingdead.client.model.guns.ModelScarhIS2;
import com.ferullogaming.craftingdead.item.gun.GunAttachment;
import com.ferullogaming.craftingdead.item.gun.ItemGun;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class RenderM1Garand extends RenderGun {
	private ModelScarhIS1 ironSight1 = new ModelScarhIS1();
	private ModelScarhIS2 ironSight2 = new ModelScarhIS2();
	private boolean isSprinting = false;
	private double par1 = 0.0D, par2 = 0.0D;

	public void renderSpecials(ItemStack itemstack, boolean var2) {
		ItemGun gun = (ItemGun) itemstack.getItem();
		int sp = gun.getGunSpecials(itemstack);
		if (sp != 0) {
			if (var2) {
				GL11.glPushMatrix();
				GL11.glScalef(1.0f, 0.9f, 0.75f);
				GL11.glTranslatef(-0.2f, 0.05f, -0.01f);
				this.bush.renderMedium(0.0625f);
				GL11.glTranslatef(0.0f, -0.025f, 0.0f);
				GL11.glTranslatef(0.5f, 0.025f, -0.0f);
				GL11.glScalef(1.5f, 1.0f, 1.0f);
				this.bush.renderMedium(0.0625f);
				GL11.glPopMatrix();
				GL11.glPushMatrix();
				GL11.glTranslatef(0.8f, -0.25f, -0.075f);
				GL11.glScalef(0.25f, 0.25f, 0.25f);
				GL11.glRotatef(90f, 0f, 1f, 0f);
				GL11.glRotatef(45f, 0f, 0f, 1f);
				this.bush.renderLeafLarge(0.0625f);
				GL11.glPopMatrix();
			} else {
				GL11.glPushMatrix();
				GL11.glScalef(1.0f, 0.9f, 0.75f);
				GL11.glTranslatef(-0.2f, 0.05f, -0.01f);
				this.bush.renderMedium(0.0625f);
				GL11.glTranslatef(0.0f, -0.025f, 0.0f);
				GL11.glTranslatef(0.5f, 0.025f, -0.0f);
				GL11.glScalef(1.5f, 1.0f, 1.0f);
				this.bush.renderMedium(0.0625f);
				GL11.glPopMatrix();
				GL11.glPushMatrix();
				GL11.glTranslatef(0.8f, -0.25f, -0.075f);
				GL11.glScalef(0.25f, 0.25f, 0.25f);
				GL11.glRotatef(90f, 0f, 1f, 0f);
				GL11.glRotatef(45f, 0f, 0f, 1f);
				this.bush.renderLeafLarge(0.0625f);
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
		GL11.glTranslatef(-0.225F, 0.3F, 0.0F);
	}

	public void renderHand(int var1, EntityPlayer var2) {
		if (var1 == 0) {
			GL11.glPushMatrix();
			if (this.isSprinting && this.par1 <= 34.0D) {
				++this.par1;
			}
			if (this.isSprinting && this.par2 <= 0.5D) {
				this.par2 += 0.05D;
			}
			if (!this.isSprinting && this.par1 >= 0.0D) {
				--this.par1;
			}
			if (!this.isSprinting && this.par2 >= 0.0D) {
				this.par2 -= 0.05D;
			}
			GL11.glTranslatef(-0.1f, 0.6f, -1.5f);
			GL11.glRotatef(65.0f, 0.0f, 0.0f, -1.0f);
			GL11.glRotatef(55.0f, 1.0f, 0.0f, 0.0f);
			GL11.glRotatef(16.0f, 0.0f, 1.0f, 0.0f);
			GL11.glScalef(1.0f, 2.25f, 1.0f);
			GL11.glRotatef((float) this.par1 * 2, -1f, 0f, 0f);
			if (this.isSprinting) {
				GL11.glTranslatef(0.0f, -(float) this.par2 / 2 - 0.2f, 0.1f);
				GL11.glRotatef(10.0f, 1.0f, 0.0f, 0.0f);
				GL11.glRotatef(8.0f, 0.0f, 0.0f, -1.0f);
			}
			this.lh.render(var2);
			GL11.glPopMatrix();
		}
		if (!this.isSprinting) {
			GL11.glPushMatrix();
			GL11.glRotatef(20f, 0f, 0f, -1f);
			GL11.glRotatef(5f, -1f, 0f, 0f);
			this.lh.render(var2);
			GL11.glPopMatrix();
		}
	}

	protected void renderGunFirstPerson(EntityPlayer entityplayer, ItemStack itemstack) {
		GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
		GL11.glRotatef(-40.0F, 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(-3.0F, 0.0F, 1.0F, 0.0F);
		GL11.glTranslatef(0.7F, -0.2F, 0.15F);
		double scale = 0.85D;
		GL11.glScaled(scale, scale, scale);
		GL11.glRotatef(3.0F, 0.0F, 0.0F, 1.0F);
		if (Minecraft.getMinecraft().thePlayer.isSprinting()) {
			this.isSprinting = true;
			if (this.isSprinting && this.par1 <= 34.0D) {
				++this.par1;
			}
			if (this.isSprinting && this.par2 <= 0.5D) {
				this.par2 += 0.05D;
			}
		} else if (!Minecraft.getMinecraft().thePlayer.isSprinting()) {
			this.isSprinting = false;
			if (!this.isSprinting && this.par1 >= 0.0D) {
				--this.par1;
			}
			if (!this.isSprinting && this.par2 >= 0.0D) {
				this.par2 -= 0.05D;
			}
		}
		GL11.glRotatef((float) this.par1 * 2, 0f, -1f, 0f);
		GL11.glTranslatef((float) this.par2 * 1.3f, 0.0f, (float) this.par2 / 2);
	}

	protected void renderGunFirstPersonAiming(EntityPlayer entityplayer, ItemStack itemstack) {
		GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
		GL11.glRotatef(-24.0F, 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(5.1F, 0.0F, 1.0F, 0.0F);
		GL11.glTranslatef(-0.0F, -0.685F, 0.971F);
		if (ItemGun.instance().getAttachmentFromSlot(itemstack, 0) != null) {
			GL11.glTranslatef(0.0F, 0.017F, 0.0F);
		}
		double scale = 0.6D;
		GL11.glScaled(scale, scale, scale);
		GL11.glRotatef(-0.7F, 0.0F, 0.0F, 1.0F);
		GL11.glTranslatef(0.0F, 0.0F, 0.0F);
		if (this.isSprinting || this.par1 != 0.0D || this.par2 != 0.0D) {
			if (this.isSprinting) {
				this.isSprinting = false;
			}
			if (this.par1 != 0.0D) {
				this.par1 = 0.0D;
			}
			if (this.par2 != 0.0D) {
				this.par2 = 0.0D;
			}
		}
	}

	protected void renderIronSights(ItemStack itemstack) {
		if (ItemGun.instance().getAttachmentFromSlot(itemstack, 0) == null) {
			this.renderIronSight1();
			this.renderIronSight2();
		}
	}

	protected void renderGunOnGround(Entity entity, ItemStack itemstack) {
		GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
		double scale = 1.25D;
		GL11.glScaled(scale, scale, scale);
	}

	protected void renderGunOnPlayerBack(EntityPlayer entity, ItemStack itemstack) {
		GL11.glRotatef(90.0F, 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
		GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
		double scale = 0.7D;
		GL11.glScaled(scale, scale, scale);
		GL11.glTranslatef(-0.7F, 0.18F, 0.25F);
	}

	private void renderIronSight1() {
		GL11.glPushMatrix();
		GL11.glRotated(180.0D, 0.0D, 1.0D, 0.0D);
		double scale = 0.5D;
		GL11.glScaled(scale, scale, scale);
		GL11.glTranslatef(0.25F, -0.02F, -0.187F);
		super.mc.getTextureManager().bindTexture(new ResourceLocation("craftingdead:textures/models/guns/scarhmodelis1.png"));
		this.ironSight1.render((Entity) null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
		GL11.glPopMatrix();
	}

	private void renderIronSight2() {
		GL11.glPushMatrix();
		GL11.glTranslatef(1.186F, -0.11F, 0.0315F);
		double scale = 0.49D;
		GL11.glScaled(scale, scale, scale);
		super.mc.getTextureManager().bindTexture(new ResourceLocation("craftingdead:textures/models/guns/scarhmodelis2.png"));
		this.ironSight2.render((Entity) null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
		GL11.glPopMatrix();
	}

	protected void renderGunAmmo(Entity entityplayer, ItemStack itemstack) {
	}

	protected void renderGunAttachment(Entity entityplayer, ItemStack itemstack, GunAttachment attachment) {
		double scale;
		if (attachment == GunAttachment.SCOPELP) {
			GL11.glTranslated(-2.2D, -1.0D, 0.26D);
			scale = 0.6D;
			GL11.glScaled(scale, scale, scale);
		} else if (attachment == GunAttachment.SCOPEHP) {
			GL11.glTranslated(-2.2D, -1.0D, 0.26D);
			scale = 0.6D;
			GL11.glScaled(scale, scale, scale);
		} else if (attachment == GunAttachment.BIPOD) {
			GL11.glTranslated(7.0D, 1.0D, 0.1D);
			scale = 0.8D;
			GL11.glScaled(scale, scale, scale);
		}
	}

	protected ModelBase getGunModel() {
		return this.m1garand;
	}

	protected String getTexture() {
		return "m1garandmodel";
	}
}
