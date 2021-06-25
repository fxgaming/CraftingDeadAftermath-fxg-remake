package by.fxg.craftingdead.client.render.guns;

import org.lwjgl.opengl.GL11;

import by.fxg.craftingdead.client.model.guns.ModelPistolIS1;
import by.fxg.craftingdead.client.model.guns.ModelPistolIS2;
import by.fxg.craftingdead.item.gun.GunAttachment;
import by.fxg.craftingdead.item.gun.ItemGun;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class RenderMAC10 extends RenderGun {
	private ModelPistolIS1 ironSight1 = new ModelPistolIS1();
	private ModelPistolIS2 ironSight2 = new ModelPistolIS2();

	public void renderSpecials(ItemStack itemstack, boolean var2) {
		ItemGun gun = (ItemGun) itemstack.getItem();
		int sp = gun.getGunSpecials(itemstack);
		if (sp != 0) {
			if (var2) {
				GL11.glPushMatrix();
				GL11.glScalef(1.25f, 0.5f, 0.5f);
				GL11.glTranslatef(0.1f, 0.1f, 0.1f);
				this.bush.renderLarge(0.0625f);
				GL11.glPopMatrix();
			} else {
				GL11.glPushMatrix();
				GL11.glScalef(1.25f, 0.5f, 0.5f);
				GL11.glTranslatef(0.1f, 0.1f, 0.1f);
				this.bush.renderLarge(0.0625f);
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
		GL11.glTranslatef(-0.75F, 0.25F, 0.0F);
		double scale = 1.0D;
		GL11.glScaled(scale, scale, scale);
	}

	public void renderHand(int var1, EntityPlayer var2) {
		{
			GL11.glPushMatrix();
			GL11.glTranslatef(-0.2f, 0.4f, -0.2f);
			GL11.glRotatef(60.0f, 0.0f, 0.0f, -1.0f);
			this.lh.render(var2);
			GL11.glPopMatrix();
			GL11.glRotatef(6.0f, 0.0f, 0.0f, -1.0f);
			GL11.glTranslatef(-0.08f, 0.1f, 0.0f);
		}
	}

	protected void renderGunFirstPerson(EntityPlayer entityplayer, ItemStack itemstack) {
		GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
		GL11.glRotatef(-40.0F, 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(-5.0F, 0.0F, 1.0F, 0.0F);
		GL11.glTranslatef(0.5F, -0.2F, 0.1F);
		double scale = 0.75D;
		GL11.glScaled(scale, scale, scale);
	}

	protected void renderGunFirstPersonAiming(EntityPlayer entityplayer, ItemStack itemstack) {
		GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
		GL11.glRotatef(-25.0F, 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(5.0F, 0.0F, 1.0F, 0.0F);
		GL11.glTranslatef(0.0F, -0.695F, 0.9525F);
		if (ItemGun.instance().getAttachmentFromSlot(itemstack, 0) != null) {
			GL11.glTranslatef(0.0F, 0.03F, 0.0F);
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
		GL11.glTranslatef(-0.45F, -0.14F, -0.375F);
		GL11.glRotated(180.0D, 0.0D, 1.0D, 0.0D);
		super.mc.getTextureManager().bindTexture(new ResourceLocation("craftingdead:textures/models/guns/g18modelis1.png"));
		this.ironSight1.render((Entity) null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
		GL11.glPopMatrix();
	}

	private void renderIronSight2() {
		GL11.glPushMatrix();
		GL11.glTranslatef(0.755F, -0.05F, 0.102F);
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
		double scale = 0.45D;
		GL11.glScaled(scale, scale, scale);
		GL11.glTranslatef(1.2F, -0.3F, -0.7F);
	}

	protected void renderGunAmmo(Entity entityplayer, ItemStack itemstack) {
	}

	protected void renderGunAttachment(Entity entityplayer, ItemStack itemstack, GunAttachment attachment) {
		double scale;
		if (attachment == GunAttachment.SURPPRESSOR) {
			GL11.glTranslatef(15.25F, 0.25F, 1.6F);
			scale = 1.0D;
			GL11.glScaled(scale, scale, scale);
		}
		if (attachment == GunAttachment.MUZZLE_BRAKE) {
			GL11.glTranslatef(9F, 0.2F, 0.25F);
			scale = 0.75D;
			GL11.glScaled(scale, scale, scale);
		}
		if (attachment == GunAttachment.REDDOT) {
			GL11.glTranslated(0.5D, -0.58D, 0.482D);
			scale = 0.75D;
			GL11.glScaled(scale, scale, scale);
		}
		if (attachment == GunAttachment.ACOG) {
			GL11.glDisable(2884);
			GL11.glTranslated(2.0D, -0.58D, 0.795D);
			scale = 0.5D;
			GL11.glScaled(scale, scale, scale);
		}
	}

	protected ModelBase getGunModel() {
		return this.mac10;
	}

	protected String getTexture() {
		return "mac10model";
	}
}
