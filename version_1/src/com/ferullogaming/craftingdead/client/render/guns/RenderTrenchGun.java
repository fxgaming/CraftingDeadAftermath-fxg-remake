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

public class RenderTrenchGun extends RenderGun {
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
				GL11.glTranslatef(-0.8f, 0.025f, -0.0f);
				this.bush.renderMedium(0.0625f);
				GL11.glTranslatef(0.5f, -0.025f, 0.0f);
				this.bush.renderMedium(0.0625f);
				GL11.glTranslatef(0.6f, 0.025f, -0.0f);
				GL11.glScalef(2.0f, 1.0f, 1.0f);
				this.bush.renderMedium(0.0625f);
				GL11.glPopMatrix();
			} else {
				GL11.glPushMatrix();
				GL11.glTranslatef(-0.8f, 0.025f, -0.0f);
				this.bush.renderMedium(0.0625f);
				GL11.glTranslatef(0.5f, -0.025f, 0.0f);
				this.bush.renderMedium(0.0625f);
				GL11.glTranslatef(0.6f, 0.025f, -0.0f);
				GL11.glScalef(2.0f, 1.0f, 1.0f);
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
		GL11.glTranslatef(-0.1F, 0.35F, 0.0F);
		double scale = 0.65D;
		GL11.glScaled(scale, scale, scale);
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
			GL11.glRotatef(64.0f, 0.0f, 0.0f, -1f);
			GL11.glRotatef(63.0f, 1.0f, 0.0f, 0.0f);
			GL11.glRotatef(14.0f, 0.0f, 1.0f, 0.0f);
			GL11.glScalef(1.0f, 2.25f, 1.0f);
			GL11.glRotatef((float) this.par1 * 2, -1.0f, 0.0f, 0.0f);
			if (this.isSprinting) {
				GL11.glTranslatef(0.0f, -(float) this.par2 / 2 - 0.2f, 0.1f);
				GL11.glRotatef(24.0f, 1.0f, 0.0f, 0.0f);
				GL11.glRotatef(5.0f, 0.0f, 0.0f, -1.0f);
			}
			this.lh.render(var2);
			GL11.glPopMatrix();
		}
	}

	protected void renderGunFirstPerson(EntityPlayer entityplayer, ItemStack itemstack) {
		GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
		GL11.glRotatef(-40.0F, 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(-3.0F, 0.0F, 1.0F, 0.0F);
		GL11.glTranslatef(0.7F, -0.2F, 0.15F);
		double scale = 0.5D;
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
		GL11.glTranslatef((float) this.par2, -0.05f, (float) this.par2 / 2);
	}

	protected void renderGunFirstPersonAiming(EntityPlayer entityplayer, ItemStack itemstack) {
		GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
		GL11.glRotatef(-24.0F, 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(5.1F, 0.0F, 1.0F, 0.0F);
		GL11.glTranslatef(-0.0F, -0.69F, 0.972F);
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
		double scale = 0.7D;
		GL11.glScaled(scale, scale, scale);
	}

	protected void renderGunOnPlayerBack(EntityPlayer entity, ItemStack itemstack) {
		GL11.glRotatef(90.0F, 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
		GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
		double scale = 0.45D;
		GL11.glScaled(scale, scale, scale);
		GL11.glTranslatef(-0.7F, 0.18F, 0.4F);
	}

	private void renderIronSight1() {
	}

	private void renderIronSight2() {
		GL11.glPushMatrix();
		GL11.glTranslatef(1.6F, -0.11F, 0.0315F);
		double scale = 0.49D;
		GL11.glScaled(scale, scale, scale);
		super.mc.getTextureManager().bindTexture(new ResourceLocation("craftingdead:textures/models/guns/scarhmodelis2.png"));
		this.ironSight2.render((Entity) null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
		GL11.glPopMatrix();
	}

	protected void renderGunAmmo(Entity entityplayer, ItemStack itemstack) {
	}

	protected void renderGunAttachment(Entity entityplayer, ItemStack itemstack, GunAttachment attachment) {
		if (attachment == GunAttachment.GRIP) {
			GL11.glTranslated(7.0D, 3.3D, 1.0D);
			double scale = 1.0D;
			GL11.glScaled(scale, scale, scale);
		}
	}

	protected ModelBase getGunModel() {
		return this.trenchgun;
	}

	protected String getTexture() {
		return "trenchgunmodel";
	}
}
