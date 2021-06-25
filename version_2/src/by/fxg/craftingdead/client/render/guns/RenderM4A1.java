package by.fxg.craftingdead.client.render.guns;

import org.lwjgl.opengl.GL11;

import by.fxg.craftingdead.client.model.guns.ModelM4A1IS1;
import by.fxg.craftingdead.client.model.guns.ModelM4A1IS2;
import by.fxg.craftingdead.item.ItemManager;
import by.fxg.craftingdead.item.gun.GunAttachment;
import by.fxg.craftingdead.item.gun.ItemGun;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class RenderM4A1 extends RenderGun {
	private ModelM4A1IS1 ironSight1 = new ModelM4A1IS1();
	private ModelM4A1IS2 ironSight2 = new ModelM4A1IS2();;
	private boolean isSprinting = false;
	private double par1 = 0.0D, par2 = 0.0D;

	public void renderSpecials(ItemStack itemstack, boolean var2) {
		ItemGun gun = (ItemGun) itemstack.getItem();
		int sp = gun.getGunSpecials(itemstack);
		if (sp != 0) {
			if (var2) {
				GL11.glPushMatrix();
				GL11.glTranslatef(-0.2f, -0.3f, -0.0f);
				this.bush.renderMedium(0.0625f);
				GL11.glTranslatef(0.3f, -0.025f, 0.0f);
				this.bush.renderMedium(0.0625f);
				GL11.glTranslatef(0.4f, 0.025f, -0.0f);
				GL11.glScalef(1.5f, 1.0f, 1.0f);
				this.bush.renderMedium(0.0625f);
				GL11.glPopMatrix();
			} else {
				GL11.glPushMatrix();
				GL11.glTranslatef(-0.2f, -0.3f, -0.0f);
				this.bush.renderMedium(0.0625f);
				GL11.glTranslatef(0.3f, -0.025f, 0.0f);
				this.bush.renderMedium(0.0625f);
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
		GL11.glTranslatef(0.6F, -0.4F, 0.35F);
		GL11.glRotatef(15.0F, 0.0F, 0.0F, 1.0F);
		GL11.glTranslatef(-0.2F, 0.55F, 0.0F);
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
			GL11.glRotatef(68.0f, 0.0f, 0.0f, -1.0f);
			GL11.glRotatef(53.0f, 1.0f, 0.0f, 0.0f);
			GL11.glRotatef(12.0f, 0.0f, 1.0f, 0.0f);
			GL11.glScalef(1.0f, 2.25f, 1.0f);
			GL11.glRotatef((float) this.par1 * 2, -1.0f, 0.0f, 0.0f);
			if (this.isSprinting) {
				GL11.glTranslatef(0.0f, -(float) this.par2 / 2 - 0.2f, 0.1f);
				GL11.glRotatef(10.0f, 1.0f, 0.0f, 0.0f);
				GL11.glRotatef(18.0f, 0.0f, 0.0f, -1.0f);
			}
			this.lh.render(var2);
			GL11.glPopMatrix();
		}
	}

	protected void renderGunFirstPerson(EntityPlayer entityplayer, ItemStack itemstack) {
		GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
		GL11.glRotatef(-35.0F, 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(5.0F, 0.0F, 1.0F, 0.0F);
		GL11.glTranslatef(0.6F, -0.0F, 0.3F);
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
		GL11.glTranslatef((float) this.par2, 0.0f, (float) this.par2);
	}

	protected void renderGunFirstPersonAiming(EntityPlayer entityplayer, ItemStack itemstack) {
		GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
		GL11.glRotatef(-35.0F, 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(5.0F, 0.0F, 1.0F, 0.0F);
		GL11.glTranslatef(1.0F, -0.22F, 0.94F);
		double scale = 0.8D;
		GL11.glScaled(scale, scale, scale);
		GL11.glRotatef(10.0F, 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(-0.4F, 1.0F, 0.0F, 0.0F);
		GL11.glTranslatef(-0.6F, 0.0F, 0.0F);
		GL11.glTranslatef(0.0F, 0.033F, 0.0F);
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
		double scale = 0.9D;
		GL11.glScaled(scale, scale, scale);
	}

	protected void renderGunOnPlayerBack(EntityPlayer entity, ItemStack itemstack) {
		GL11.glRotatef(90.0F, 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
		GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
		double scale = 0.55D;
		GL11.glScaled(scale, scale, scale);
		GL11.glTranslatef(-0.7F, 0.6F, 0.3F);
	}

	private void renderIronSight1() {
		GL11.glPushMatrix();
		GL11.glRotated(180.0D, 0.0D, 1.0D, 0.0D);
		double scale = 0.5D;
		GL11.glScaled(scale, scale, scale);
		GL11.glTranslatef(0.9F, -0.7F, -0.145F);
		scale = 0.75D;
		GL11.glScaled(scale, scale, scale);
		GL11.glTranslatef(-0.5F, -0.04F, -0.0F);
		super.mc.getTextureManager().bindTexture(new ResourceLocation("craftingdead:textures/models/guns/m4a1modelis1.png"));
		this.ironSight1.render((Entity) null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
		GL11.glPopMatrix();
	}

	private void renderIronSight2() {
		GL11.glPushMatrix();
		GL11.glTranslatef(1.188F, -0.39F, 0.0625F);
		double scale = 0.25D;
		GL11.glScaled(scale, scale, scale);
		super.mc.getTextureManager().bindTexture(new ResourceLocation("craftingdead:textures/models/guns/m4a1modelis2.png"));
		this.ironSight2.render((Entity) null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
		GL11.glPopMatrix();
	}

	protected void renderGunAmmo(Entity entityplayer, ItemStack itemstack) {
		double scale;
		if (itemstack.itemID == ItemManager.stanag20Rnd.itemID) {
			GL11.glTranslated(0.8D, -1.5D, 0.2D);
			scale = 1.2D;
			GL11.glScaled(scale, scale, scale);
		}
		if (itemstack.itemID == ItemManager.stanag30Rnd.itemID) {
			GL11.glTranslated(0.8D, 0.0D, 0.2D);
			scale = 1.2D;
			GL11.glScaled(scale, scale, scale);
		}
		if (itemstack.itemID == ItemManager.stanagDrum.itemID) {
			GL11.glRotated(90.0D, 0.0D, 1.0D, 0.0D);
			GL11.glTranslated(-1.7D, -0.0D, 0.5D);
			scale = 0.8D;
			GL11.glScaled(scale, scale, scale);
			GL11.glRotated(5.0D, 1.0D, 0.0D, 0.0D);
		}
		if (itemstack.itemID == ItemManager.stanagBox.itemID) {
			GL11.glRotated(90.0D, 0.0D, 1.0D, 0.0D);
			GL11.glTranslated(-2.4D, 1.2D, 0.5D);
			scale = 1.2D;
			GL11.glScaled(scale, scale, scale);
		}
	}

	protected void renderGunAttachment(Entity entityplayer, ItemStack itemstack, GunAttachment attachment) {
		double scale;
		if (attachment == GunAttachment.SCOPELP) {
			GL11.glTranslated(-3.0D, -5.0D, 0.498D);
			scale = 0.75D;
			GL11.glScaled(scale, scale, scale);
		}
		if (attachment == GunAttachment.SCOPEHP) {
			GL11.glTranslated(-3.0D, -5.0D, 0.498D);
			scale = 0.75D;
			GL11.glScaled(scale, scale, scale);
		}
		if (attachment == GunAttachment.REDDOT) {
			GL11.glTranslated(-3.0D, -3.9D, 0.498D);
			scale = 0.75D;
			GL11.glScaled(scale, scale, scale);
		}
		if (attachment == GunAttachment.ACOG) {
			GL11.glDisable(2884);
			GL11.glTranslated(-2.0D, -3.81D, 0.78D);
			scale = 0.6D;
			GL11.glScaled(scale, scale, scale);
		}
		if (attachment == GunAttachment.SURPPRESSOR) {
			GL11.glTranslated(20.0D, -2.75D, 1.5D);
			scale = 1.0D;
			GL11.glScaled(scale, scale, scale);
		}
		if (attachment == GunAttachment.MUZZLE_BRAKE) {
			GL11.glTranslatef(-2.25F, -0.9F, -0.9F);
			scale = 0.75D;
			GL11.glScaled(scale, scale, scale);
		}
		if (attachment == GunAttachment.MUZZLE_BRAKE) {
			GL11.glTranslated(20.0D, -2.75D, 1.5D);
			scale = 1.0D;
			GL11.glScaled(scale, scale, scale);
		}
		if (attachment == GunAttachment.GRIP) {
			GL11.glTranslated(9.0D, -1.25D, 1.5D);
			scale = 1.0D;
			GL11.glScaled(scale, scale, scale);
		}
		if (attachment == GunAttachment.BIPOD) {
			GL11.glTranslated(7.0D, -1.2D, 0.2D);
			scale = 1.2D;
			GL11.glScaled(scale, scale, scale);
		}
	}

	protected ModelBase getGunModel() {
		return this.m4a1;
	}

	protected String getTexture() {
		return "m4a1model";
	}
}
