package com.ferullogaming.craftingdead.client.render.guns;

import org.lwjgl.opengl.GL11;

import com.ferullogaming.craftingdead.client.model.guns.ModelScarhIS1;
import com.ferullogaming.craftingdead.client.model.guns.ModelScarhIS2;
import com.ferullogaming.craftingdead.item.ItemManager;
import com.ferullogaming.craftingdead.item.gun.GunAttachment;
import com.ferullogaming.craftingdead.item.gun.ItemGun;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class RenderScarh extends RenderGun {
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
				GL11.glScalef(1.0f, 1.0f, 0.75f);
				GL11.glTranslatef(0.1f, -0.05f, -0.0f);
				this.bush.renderMedium(0.0625f);
				GL11.glTranslatef(0.0f, -0.025f, 0.0f);
				GL11.glTranslatef(0.4f, 0.025f, -0.0f);
				GL11.glScalef(1.5f, 1.0f, 1.0f);
				this.bush.renderMedium(0.0625f);
				GL11.glPopMatrix();
			} else {
				GL11.glPushMatrix();
				GL11.glScalef(1.0f, 1.0f, 0.75f);
				GL11.glTranslatef(0.1f, -0.05f, -0.0f);
				this.bush.renderMedium(0.0625f);
				GL11.glTranslatef(0.0f, -0.025f, 0.0f);
				GL11.glTranslatef(0.4f, 0.025f, -0.0f);
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
		GL11.glTranslatef(-0.4F, 0.6F, 0.0F);
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
			GL11.glRotatef(64.0f, 0.0f, 0.0f, -1.0f);
			GL11.glRotatef(56.0f, 1.0f, 0.0f, 0.0f);
			GL11.glRotatef(8.0f, 0.0f, 1.0f, 0.0f);
			GL11.glScalef(1.0f, 2.0f, 1.0f);
			GL11.glRotatef((float) this.par1 * 2, -1.0f, 0.0f, 0.0f);
			if (this.isSprinting) {
				GL11.glTranslatef(0.0f, -(float) this.par2 / 2 - 0.2f, 0.1f);
				GL11.glRotatef(10.0f, 1.0f, 0.0f, 0.0f);
				GL11.glRotatef(12.0f, 0.0f, 0.0f, -1.0f);
			}
			this.lh.render(var2);
			GL11.glPopMatrix();
		}
	}

	protected void renderGunFirstPerson(EntityPlayer entityplayer, ItemStack itemstack) {
		GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
		GL11.glRotatef(-35.0F, 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(5.0F, 0.0F, 1.0F, 0.0F);
		GL11.glTranslatef(0.3F, -0.3F, 0.4F);
		double scale = 0.8D;
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
		GL11.glTranslatef((float) this.par2, 0.0f, (float) this.par2 / 4);
	}

	protected void renderGunFirstPersonAiming(EntityPlayer entityplayer, ItemStack itemstack) {
		GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
		GL11.glRotatef(-35.0F, 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(5.0F, 0.0F, 1.0F, 0.0F);
		GL11.glTranslatef(1.0F, -0.22F, 0.94F);
		double scale = 1.0D;
		GL11.glScaled(scale, scale, scale);
		GL11.glRotatef(10.0F, 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(-1.0F, 1.0F, 0.0F, 0.0F);
		GL11.glRotatef(0.18F, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(1.2F, 0.0F, 0.0F, 1.0F);
		GL11.glTranslatef(-0.8F, -0.17F, 0.01F);
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
		double scale = 1.2D;
		GL11.glScaled(scale, scale, scale);
	}

	protected void renderGunOnPlayerBack(EntityPlayer entity, ItemStack itemstack) {
		GL11.glRotatef(90.0F, 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
		GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
		double scale = 0.72D;
		GL11.glScaled(scale, scale, scale);
		GL11.glTranslatef(-0.7F, 0.2F, 0.2F);
	}

	protected void renderGunAmmo(Entity entityplayer, ItemStack itemstack) {
		double scale;
		if (itemstack.itemID == ItemManager.stanag20Rnd.itemID) {
			GL11.glTranslated(3.0D, 1.5D, 0.05D);
			scale = 0.9D;
			GL11.glScaled(scale, scale, scale);
		}
		if (itemstack.itemID == ItemManager.stanag30Rnd.itemID) {
			GL11.glTranslated(3.0D, 2.5D, 0.05D);
			scale = 0.9D;
			GL11.glScaled(scale, scale, scale);
		}
		if (itemstack.itemID == ItemManager.stanagDrum.itemID) {
			GL11.glRotated(90.0D, 0.0D, 1.0D, 0.0D);
			GL11.glTranslated(-1.24D, 2.4D, 2.7D);
			scale = 0.65D;
			GL11.glScaled(scale, scale, scale);
			GL11.glRotated(5.0D, 1.0D, 0.0D, 0.0D);
		}
		if (itemstack.itemID == ItemManager.stanagBox.itemID) {
			GL11.glRotated(90.0D, 0.0D, 1.0D, 0.0D);
			GL11.glTranslated(-1.8D, 3.2D, 3.0D);
			scale = 0.95D;
			GL11.glScaled(scale, scale, scale);
		}
	}

	protected void renderGunAttachment(Entity entityplayer, ItemStack itemstack, GunAttachment attachment) {
		double scale;
		if (attachment == GunAttachment.SCOPELP) {
			GL11.glTranslated(1.0D, -1.8D, 0.25D);
			scale = 0.6D;
			GL11.glScaled(scale, scale, scale);
		}
		if (attachment == GunAttachment.SCOPEHP) {
			GL11.glTranslated(1.0D, -1.8D, 0.25D);
			scale = 0.6D;
			GL11.glScaled(scale, scale, scale);
		}
		if (attachment == GunAttachment.REDDOT) {
			GL11.glTranslated(0.5D, -1.02D, 0.26D);
			scale = 0.6D;
			GL11.glScaled(scale, scale, scale);
		}
		if (attachment == GunAttachment.ACOG) {
			GL11.glDisable(2884);
			GL11.glTranslated(1.5D, -1.035D, 0.508D);
			scale = 0.4D;
			GL11.glScaled(scale, scale, scale);
		}
		if (attachment == GunAttachment.SURPPRESSOR) {
			GL11.glTranslated(18.3D, 0.1D, 1.15D);
			scale = 0.8D;
			GL11.glScaled(scale, scale, scale);
		}
		if (attachment == GunAttachment.MUZZLE_BRAKE) {
			GL11.glTranslatef(-1.0F, 0.0F, -0.75F);
			scale = 0.75D;
			GL11.glScaled(scale, scale, scale);
		}
		if (attachment == GunAttachment.MUZZLE_BRAKE) {
			GL11.glTranslated(18.3D, 0.1D, 1.15D);
			scale = 0.8D;
			GL11.glScaled(scale, scale, scale);
		}
		if (attachment == GunAttachment.GRIP) {
			GL11.glTranslated(9.0D, 1.3D, 1.05D);
			scale = 0.8D;
			GL11.glScaled(scale, scale, scale);
		}
		if (attachment == GunAttachment.BIPOD) {
			GL11.glTranslated(8.0D, 1.3D, 0.15D);
			scale = 0.8D;
			GL11.glScaled(scale, scale, scale);
		}
	}

	private void renderIronSight1() {
		GL11.glPushMatrix();
		GL11.glRotated(180.0D, 0.0D, 1.0D, 0.0D);
		double scale = 0.5D;
		GL11.glScaled(scale, scale, scale);
		GL11.glTranslatef(-0.2F, -0.15F, -0.187F);
		super.mc.getTextureManager().bindTexture(new ResourceLocation("craftingdead:textures/models/guns/scarhmodelis1.png"));
		this.ironSight1.render((Entity) null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
		GL11.glPopMatrix();
	}

	private void renderIronSight2() {
		GL11.glPushMatrix();
		GL11.glTranslatef(1.1255F, -0.19F, 0.0318F);
		double scale = 0.495D;
		GL11.glScaled(scale, scale, scale);
		super.mc.getTextureManager().bindTexture(new ResourceLocation("craftingdead:textures/models/guns/scarhmodelis2.png"));
		this.ironSight2.render((Entity) null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
		GL11.glPopMatrix();
	}

	protected ModelBase getGunModel() {
		return this.scarh;
	}

	protected String getTexture() {
		return "scarhmodel";
	}
}
