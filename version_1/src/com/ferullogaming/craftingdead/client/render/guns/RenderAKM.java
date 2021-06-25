package com.ferullogaming.craftingdead.client.render.guns;

import org.lwjgl.opengl.GL11;

import com.ferullogaming.craftingdead.client.model.guns.ModelAKM;
import com.ferullogaming.craftingdead.client.model.guns.ModelAKMIS1;
import com.ferullogaming.craftingdead.client.model.guns.ModelAKMIS2;
import com.ferullogaming.craftingdead.item.ItemManager;
import com.ferullogaming.craftingdead.item.gun.GunAttachment;
import com.ferullogaming.craftingdead.item.gun.ItemGun;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class RenderAKM extends RenderGun {
	private ModelAKMIS1 ironSight1 = new ModelAKMIS1();
	private ModelAKMIS2 ironSight2 = new ModelAKMIS2();
	private boolean isSprinting = false;
	private double par1 = 0.0D, par2 = 0.0D;
	
	public void renderSpecials(ItemStack itemstack, boolean var2) {
		ItemGun gun = (ItemGun) itemstack.getItem();
		int sp = gun.getGunSpecials(itemstack);
		if (sp != 0) {
			if (var2) {
				GL11.glPushMatrix();
				GL11.glTranslatef(-0.8f, -0.1f, -0.0f);
				this.bush.renderMedium(0.0625f);
				GL11.glTranslatef(0.5f, -0.025f, 0.0f);
				this.bush.renderMedium(0.0625f);
				GL11.glTranslatef(0.6f, 0.025f, -0.0f);
				GL11.glScalef(1.5f, 1.0f, 1.0f);
				this.bush.renderMedium(0.0625f);
				GL11.glPopMatrix();
			} else {
				GL11.glPushMatrix();
				GL11.glTranslatef(-0.8f, -0.1f, -0.0f);
				this.bush.renderMedium(0.0625f);
				GL11.glTranslatef(0.5f, -0.025f, 0.0f);
				this.bush.renderMedium(0.0625f);
				GL11.glTranslatef(0.6f, 0.025f, -0.0f);
				GL11.glScalef(1.5f, 1.0f, 1.0f);
				this.bush.renderMedium(0.0625f);
				GL11.glPopMatrix();
			}
		}
	}

	public void renderGunThirdPerson(Entity entityplayer, ItemStack itemstack) {
		GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
		GL11.glRotatef(-15.0F, 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(77.0F, 0.0F, 1.0F, 0.0F);
		GL11.glTranslatef(0.6F, -0.7F, 0.35F);
		GL11.glRotatef(15.0F, 0.0F, 0.0F, 1.0F);
		GL11.glTranslatef(0.35F, 0.6F, 0.0F);
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
			GL11.glRotatef(60.0f, 0.0f, 0.0f, -1.0f);
			GL11.glRotatef(65.0f, 1.0f, 0.0f, 0.0f);
			GL11.glScalef(1.0f, 1.75f, 1.0f);
			GL11.glRotatef((float) this.par1 * 2, -1.0f, 0.0f, 0.0f);
			if (this.isSprinting) {
				GL11.glTranslatef(0.0f, -(float) this.par2 / 2 - 0.2f, 0.1f);
				GL11.glRotatef(10.0f, 1.0f, 0.0f, 0.0f);
			}
			this.lh.render(var2);
			GL11.glPopMatrix();
		}
	}

	protected void renderGunFirstPerson(EntityPlayer entityplayer, ItemStack itemstack) {
		GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
		GL11.glRotatef(-35.0F, 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(5.0F, 0.0F, 1.0F, 0.0F);
		GL11.glTranslatef(0.5F, -0.35F, 0.5F);
		double scale = 0.5D;
		GL11.glScaled(scale, scale, scale);
		GL11.glRotatef(-2.0F, 1.0F, 0.0F, 0.0F);
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
		GL11.glTranslatef((float) this.par2, 0.0f, (float) this.par2);
	}

	protected void renderGunFirstPersonAiming(EntityPlayer entityplayer, ItemStack itemstack) {
		GL11.glTranslatef(0.0F, 0.0F, -0.002F);
		GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
		GL11.glRotatef(-35.0F, 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(5.0F, 0.0F, 1.0F, 0.0F);
		GL11.glTranslatef(1.0F, -0.15F, 0.92F);
		double scale = 0.9D;
		GL11.glScaled(scale, scale, scale);
		GL11.glRotatef(10.0F, 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(-1.0F, 1.0F, 0.0F, 0.0F);
		GL11.glRotatef(0.25F, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(1.25F, 0.0F, 0.0F, 1.0F);
		GL11.glTranslatef(-0.3F, -0.2F, 0.005F);
		GL11.glTranslatef(0.0F, 0.0F, 0.0F);
		if (ItemGun.instance().getAttachmentFromSlot(itemstack, 0) != null) {
			GunAttachment attachment = ItemGun.instance().getAttachmentFromSlot(itemstack, 0);
			if (attachment == GunAttachment.REDDOT) {
				GL11.glTranslatef(0.0F, 0.015F, 0.0F);
			}

			if (attachment == GunAttachment.ACOG) {
				GL11.glTranslatef(0.0F, 0.02F, 0.0F);
			}
		}
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
		double scale = 1.0D;
		GL11.glScaled(scale, scale, scale);
	}

	protected void renderGunOnPlayerBack(EntityPlayer entity, ItemStack itemstack) {
		GL11.glRotatef(90.0F, 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
		GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
		double scale = 0.55D;
		GL11.glScaled(scale, scale, scale);
		GL11.glTranslatef(-0.2F, 0.38F, 0.25F);
	}

	protected void renderGunAmmo(Entity entityplayer, ItemStack itemstack) {
		if (itemstack.itemID == ItemManager.stanagDrum.itemID) {
			GL11.glRotated(90.0D, 0.0D, 1.0D, 0.0D);
			GL11.glTranslated(-1.6D, 1.0D, -3.5D);
			double scale = 0.7D;
			GL11.glScaled(scale, scale, scale);
			GL11.glRotated(5.0D, 1.0D, 0.0D, 0.0D);
		}
	}

	protected void renderGunAttachment(Entity entityplayer, ItemStack itemstack, GunAttachment attachment) {
		double scale;
		if (attachment == GunAttachment.SCOPELP) {
			GL11.glTranslated(-6.0D, -3.2D, 0.5D);
			scale = 0.7D;
			GL11.glScaled(scale, scale, scale);
		}

		if (attachment == GunAttachment.SCOPEHP) {
			GL11.glTranslated(-6.0D, -3.2D, 0.5D);
			scale = 0.7D;
			GL11.glScaled(scale, scale, scale);
		}

		if (attachment == GunAttachment.REDDOT) {
			GL11.glTranslated(-6.0D, -1.9D, 0.47D);
			scale = 0.75D;
			GL11.glScaled(scale, scale, scale);
		}

		if (attachment == GunAttachment.ACOG) {
			GL11.glDisable(2884);
			GL11.glTranslated(-5.0D, -1.945D, 0.775D);
			scale = 0.5D;
			GL11.glScaled(scale, scale, scale);
		}

		if (attachment == GunAttachment.SURPPRESSOR) {
			GL11.glTranslated(17.8D, -0.16D, 1.3D);
			scale = 0.8D;
			GL11.glScaled(scale, scale, scale);
		}

		if (attachment == GunAttachment.MUZZLE_BRAKE) {
			GL11.glTranslatef(13.0F, -0.25F, 0.25F);
			scale = 0.75D;
			GL11.glScaled(scale, scale, scale);
		}

		if (attachment == GunAttachment.GRIP) {
			GL11.glTranslated(5.0D, 1.2D, 1.4D);
			scale = 0.9D;
			GL11.glScaled(scale, scale, scale);
		}

		if (attachment == GunAttachment.BIPOD) {
			GL11.glTranslated(4.0D, 1.1D, 0.3D);
			scale = 1.0D;
			GL11.glScaled(scale, scale, scale);
		}

	}

	private void renderIronSight1() {
		GL11.glPushMatrix();
		GL11.glRotated(0.0D, 0.0D, 1.0D, 0.0D);
		double scale = 0.51D;
		GL11.glScaled(scale, scale, scale);
		GL11.glTranslatef(-0.2F, -0.4F, 0.12F);
		super.mc.getTextureManager().bindTexture(new ResourceLocation("craftingdead:textures/models/guns/akmmodelis1.png"));
		this.ironSight1.render((Entity) null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
		GL11.glPopMatrix();
	}

	private void renderIronSight2() {
		GL11.glPushMatrix();
		GL11.glTranslatef(1.219F, -0.22F, 0.063F);
		double scale = 0.25D;
		GL11.glScaled(scale, scale, scale);
		GL11.glDisable(2884);
		super.mc.getTextureManager().bindTexture(new ResourceLocation("craftingdead:textures/models/guns/akmmodelis2.png"));
		this.ironSight2.render((Entity) null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
		GL11.glPopMatrix();
	}

	protected ModelBase getGunModel() {
		return this.akm;
	}

	protected String getTexture() {
		return "akmmodel";
	}
}
