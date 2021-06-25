package by.fxg.craftingdead.client.render.guns;

import org.lwjgl.opengl.GL11;

import by.fxg.craftingdead.client.model.guns.ModelPistolIS2;
import by.fxg.craftingdead.client.model.guns.ModelScarhIS1;
import by.fxg.craftingdead.item.gun.GunAttachment;
import by.fxg.craftingdead.item.gun.ItemGun;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class RenderM240B extends RenderGun {
	private ModelScarhIS1 ironSight1 = new ModelScarhIS1();
	private ModelPistolIS2 ironSight2 = new ModelPistolIS2();
	private boolean isSprinting = false;
	private double par1 = 0.0D, par2 = 0.0D;

	public void renderSpecials(ItemStack itemstack, boolean var2) {
		ItemGun gun = (ItemGun) itemstack.getItem();
		int sp = gun.getGunSpecials(itemstack);
		if (sp != 0) {
			if (var2) {
				GL11.glPushMatrix();
				GL11.glTranslatef(-0.5f, 0.025f, -0.0f);
				GL11.glTranslatef(0.5f, -0.025f, 0.0f);
				this.bush.renderMedium(0.0625f);
				GL11.glTranslatef(0.6f, 0.025f, -0.0f);
				GL11.glScalef(2.0f, 1.0f, 1.0f);
				this.bush.renderMedium(0.0625f);
				GL11.glPopMatrix();
			} else {
				GL11.glPushMatrix();
				GL11.glTranslatef(-0.5f, 0.025f, -0.0f);
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
		GL11.glTranslatef(-0.5F, 0.25F, 0.0F);
		double scale = 0.75D;
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
			GL11.glRotatef(60.0f, 0.0f, 0.0f, -1.0f);
			GL11.glRotatef(48.0f, 1.0f, 0.0f, 0.0f);
			GL11.glScalef(1.0f, 2.3f, 1.0f);
			GL11.glRotatef((float) this.par1 * 2, -1.0f, 0.0f, 0.0f);
			if (this.isSprinting) {
				GL11.glTranslatef(0.0f, -(float) this.par2 / 2 - 0.2f, 0.1f);
				GL11.glRotatef(10.0f, 1.0f, 0.0f, 0.0f);
				GL11.glRotatef(14.0f, 0.0f, 0.0f, -1.0f);
			}
			this.lh.render(var2);
			GL11.glPopMatrix();
		}
		GL11.glPushMatrix();
		GL11.glTranslatef(-0.1f, -0.2f, -0.2f);
		GL11.glRotatef(20f, 0f, 0f, -1f);
		GL11.glRotatef(0f, 0f, 0f, 0f);
		GL11.glRotatef(0f, 0f, 0f, 0f);
		this.lh.render(var2);
		GL11.glPopMatrix();
	}

	protected void renderGunFirstPerson(EntityPlayer entityplayer, ItemStack itemstack) {
		GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
		GL11.glRotatef(-40.0F, 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(-3.0F, 0.0F, 1.0F, 0.0F);
		GL11.glTranslatef(0.3F, -0.2F, 0.1F);
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
		GL11.glTranslatef((float) this.par2 / 2, -0.1f, (float) this.par2 / 20);
	}

	protected void renderGunFirstPersonAiming(EntityPlayer entityplayer, ItemStack itemstack) {
		GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
		GL11.glRotatef(-24.0F, 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(5.1F, 0.0F, 1.0F, 0.0F);
		GL11.glTranslatef(-0.1F, -0.665F, 0.952F);
		if (ItemGun.instance().getAttachmentFromSlot(itemstack, 0) != null) {
			GL11.glTranslatef(0.0F, 0.007F, 0.0F);
		}
		double scale = 0.6D;
		GL11.glScaled(scale, scale, scale);
		GL11.glRotatef(-0.7F, 0.0F, 0.0F, 1.0F);
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
		double scale = 1.1D;
		GL11.glScaled(scale, scale, scale);
		GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
	}

	protected void renderGunOnPlayerBack(EntityPlayer entity, ItemStack itemstack) {
		GL11.glRotatef(90.0F, 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
		GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
		double scale = 0.65D;
		GL11.glScaled(scale, scale, scale);
		GL11.glTranslatef(-1.0F, 0.18F, 0.28F);
	}

	private void renderIronSight1() {
		GL11.glPushMatrix();
		GL11.glRotated(180.0D, 0.0D, 1.0D, 0.0D);
		double scale = 0.7D;
		GL11.glScaled(scale, scale, scale);
		GL11.glTranslatef(1.4F, -0.48F, -0.087F);
		scale = 0.7D;
		GL11.glScaled(scale, scale, scale);
		GL11.glTranslatef(-2.4F, 0.6F, -0.13F);
		super.mc.getTextureManager().bindTexture(new ResourceLocation("craftingdead:textures/models/guns/scarhmodelis1.png"));
		this.ironSight1.render((Entity) null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
		GL11.glPopMatrix();
	}

	private void renderIronSight2() {
		GL11.glPushMatrix();
		GL11.glTranslatef(1.75F, -0.1F, 0.087F);
		double scale = 0.25D;
		GL11.glScaled(scale, scale + 0.5D, scale);
		super.mc.getTextureManager().bindTexture(new ResourceLocation("craftingdead:textures/models/guns/m1911modelis2.png"));
		this.ironSight2.render((Entity) null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
		GL11.glPopMatrix();
	}

	protected void renderGunAmmo(Entity entityplayer, ItemStack itemstack) {
	}

	protected void renderGunAttachment(Entity entityplayer, ItemStack itemstack, GunAttachment attachment) {
		double scale;
		if (attachment == GunAttachment.REDDOT) {
			GL11.glTranslated(1.0D, -0.8D, 0.57D);
			scale = 0.6D;
			GL11.glScaled(scale, scale, scale);
		} else if (attachment == GunAttachment.BIPOD) {
			GL11.glTranslated(12.0D, 2.2D, 0.3D);
			scale = 0.9D;
			GL11.glScaled(scale, scale, scale);
		}
		if (attachment == GunAttachment.MUZZLE_BRAKE) {
			GL11.glTranslatef(18.5F, -0.1F, 0.25F);
			scale = 0.75D;
			GL11.glScaled(scale, scale, scale);
		}
	}

	protected ModelBase getGunModel() {
		return this.m240b;
	}

	protected String getTexture() {
		return "m240bmodel";
	}
}
