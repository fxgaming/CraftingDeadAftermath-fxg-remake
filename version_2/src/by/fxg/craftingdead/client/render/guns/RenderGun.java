package by.fxg.craftingdead.client.render.guns;

import java.awt.Color;

import org.lwjgl.opengl.GL11;

import by.fxg.craftingdead.CDReloaded;
import by.fxg.craftingdead.client.CDRenderHelper;
import by.fxg.craftingdead.client.anim.AnimationManager;
import by.fxg.craftingdead.client.anim.GunAnimation;
import by.fxg.craftingdead.client.anim.GunAnimationPistolFired;
import by.fxg.craftingdead.client.anim.GunAnimationPulled;
import by.fxg.craftingdead.client.anim.GunAnimationReload;
import by.fxg.craftingdead.client.anim.GunAnimationReloadP90;
import by.fxg.craftingdead.client.anim.GunAnimationRifleFired;
import by.fxg.craftingdead.client.anim.GunAnimationSMGFired;
import by.fxg.craftingdead.client.model.ModelBush;
import by.fxg.craftingdead.client.model.guns.ModelAKM;
import by.fxg.craftingdead.client.model.guns.ModelAS50;
import by.fxg.craftingdead.client.model.guns.ModelFNFAL;
import by.fxg.craftingdead.client.model.guns.ModelG18;
import by.fxg.craftingdead.client.model.guns.ModelM107;
import by.fxg.craftingdead.client.model.guns.ModelM1911;
import by.fxg.craftingdead.client.model.guns.ModelM1Garand;
import by.fxg.craftingdead.client.model.guns.ModelM240B;
import by.fxg.craftingdead.client.model.guns.ModelM4A1;
import by.fxg.craftingdead.client.model.guns.ModelM9;
import by.fxg.craftingdead.client.model.guns.ModelMAC10;
import by.fxg.craftingdead.client.model.guns.ModelMP5A4;
import by.fxg.craftingdead.client.model.guns.ModelP90;
import by.fxg.craftingdead.client.model.guns.ModelScarh;
import by.fxg.craftingdead.client.model.guns.ModelSporter22;
import by.fxg.craftingdead.client.model.guns.ModelTrenchGun;
import by.fxg.craftingdead.entity.EntityGroundItem;
import by.fxg.craftingdead.item.gun.GunAttachment;
import by.fxg.craftingdead.item.gun.GunPaint;
import by.fxg.craftingdead.item.gun.ItemAmmo;
import by.fxg.craftingdead.item.gun.ItemGun;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.Icon;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

public abstract class RenderGun implements IItemRenderer, IRenderPartialTick {
	public Minecraft mc = Minecraft.getMinecraft();
	public ModelBase gunModel = null;
	public float partialTick;
	public GunAnimation animation;
	protected RightHand rh = new RightHand();
	protected LeftHand lh = new LeftHand();
	protected ModelBush bush = new ModelBush();
	protected ModelAKM akm = new ModelAKM();
	protected ModelAS50 as50 = new ModelAS50();
	protected ModelFNFAL fnfal = new ModelFNFAL();
	protected ModelG18 g18 = new ModelG18();
	protected ModelM107 m107 = new ModelM107();
	protected ModelM1911 m1911 = new ModelM1911();
	protected ModelM1Garand m1garand = new ModelM1Garand();
	protected ModelM240B m240b = new ModelM240B();
	protected ModelM4A1 m4a1 = new ModelM4A1();
	protected ModelM9 m9 = new ModelM9();
	protected ModelMAC10 mac10 = new ModelMAC10();
	protected ModelP90 p90 = new ModelP90();
	protected ModelScarh scarh = new ModelScarh();
	protected ModelSporter22 sporter22 = new ModelSporter22();
	protected ModelTrenchGun trenchgun = new ModelTrenchGun();
	protected ModelMP5A4 mp5a4 = new ModelMP5A4(3);
	
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		return type == ItemRenderType.EQUIPPED || type == ItemRenderType.ENTITY || type == ItemRenderType.EQUIPPED_FIRST_PERSON || type == ItemRenderType.INVENTORY;
	}

	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
		return false;
	}

	public void setPartialTick(float par1) {
		this.partialTick = par1;
	}

	public void renderItem(ItemRenderType type, ItemStack itemstack, Object... data) {
		this.applyGunModel();
		if (itemstack != null) {
			Entity entity = null;
			if (data.length > 1 && data[1] instanceof Entity) entity = (Entity)data[1];
			GL11.glPushMatrix();
			GL11.glDisable(GL11.GL_BLEND);
			String guntexture = this.getTexture(itemstack);
			if (type == ItemRenderType.EQUIPPED_FIRST_PERSON) {
				if (CDReloaded.instance.playerDataHandler().getPlayerData(((EntityPlayer) entity).username).isAiming && ItemGun.instance().getAttachmentFromSlot(itemstack, 0) != null && ItemGun.instance().getAttachmentFromSlot(itemstack, 0).scopeTexture != null) {
					GL11.glPopMatrix();
					return;
				}
				if (!CDReloaded.instance.playerDataHandler().getPlayerData(((EntityPlayer) entity).username).isAiming) {
					this.animation = AnimationManager.instance().getCurrentAnimation();
					if (this.animation != null) this.animation.doRender(itemstack, this.partialTick, false, false);

					if (this.animation == null || this.animation != null && (this.animation instanceof GunAnimationPistolFired || this.animation instanceof GunAnimationRifleFired || this.animation instanceof GunAnimationSMGFired || this.animation instanceof GunAnimationPulled || this.animation instanceof GunAnimationReloadP90)) this.renderHand(0, (EntityPlayer) entity);
					else if (this.animation != null && this.animation instanceof GunAnimationReload) this.renderHand(1, (EntityPlayer) entity);
					this.renderGunFirstPerson((EntityPlayer) entity, itemstack);
					this.mc.getTextureManager().bindTexture(new ResourceLocation("craftingdead:textures/models/guns/" + guntexture + ".png"));
					this.gunModel.render(entity, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
					this.renderIronSights(itemstack);
					GL11.glPushMatrix();
					if (this.animation != null && this.animation instanceof GunAnimationReload) {
						((GunAnimationReload) this.animation).doRenderAmmo(itemstack, this.partialTick);
					}
					this.renderMainGunAmmo(entity, itemstack);
					GL11.glPopMatrix();
					this.renderMainGunAttachments(entity, itemstack);
					this.renderSpecials(itemstack, true);
					GL11.glPopMatrix();
					if (!Minecraft.getMinecraft().gameSettings.viewBobbing) {
						Minecraft.getMinecraft().gameSettings.viewBobbing = true;
					}
					return;
				} else if (CDReloaded.instance.playerDataHandler().getPlayerData(((EntityPlayer)entity).username).isAiming) {
					if (Minecraft.getMinecraft().gameSettings.viewBobbing) {
						Minecraft.getMinecraft().gameSettings.viewBobbing = false;
					}
					if (Minecraft.getMinecraft().thePlayer.isSprinting()) {
						Minecraft.getMinecraft().thePlayer.setSprinting(false);
					}
					this.animation = AnimationManager.instance().getCurrentAnimation();
					if (this.animation != null) this.animation.doRender(itemstack, this.partialTick, true, true);
					GL11.glDisable(GL11.GL_BLEND);
					this.renderGunFirstPersonAiming((EntityPlayer) entity, itemstack);
					if (this.animation != null) this.animation.doRender(itemstack, this.partialTick, true, false);
					this.renderSpecials(itemstack, true);
				}
			} else if (type == ItemRenderType.EQUIPPED) {
				this.renderGunThirdPerson(entity, itemstack);
				this.renderSpecials(itemstack, false);
				
			} else if (type == ItemRenderType.ENTITY) {
				this.renderGunOnGround(entity, itemstack);
			} else if (type == ItemRenderType.INVENTORY) {
				this.renderInventory(itemstack);
				GL11.glPopMatrix();
				return;
			}

			this.mc.getTextureManager().bindTexture(new ResourceLocation("craftingdead:textures/models/guns/" + guntexture + ".png"));
			this.gunModel.render(entity, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
			this.renderIronSights(itemstack);
			this.renderMainGunAmmo(entity, itemstack);
			this.renderMainGunAttachments(entity, itemstack);
			GL11.glPopMatrix();
		}
	}

	public void renderMainGunOnGround(Entity entity, ItemStack itemstack, double par1, double par2, double par3) {
		this.applyGunModel();
		GL11.glPushMatrix();
		String guntexture = this.getTexture(itemstack);
		this.mc.getTextureManager().bindTexture(new ResourceLocation("craftingdead:textures/models/guns/" + guntexture + ".png"));
		GL11.glTranslated(par1, par2 + 0.1D, par3);
		double scale = 0.4D;
		GL11.glScaled(scale, scale, scale);
		GL11.glRotatef(0.0F, 1.0F, 0.0F, 0.0F);
		GL11.glRotatef(((EntityGroundItem) entity).renderDirection, 0.0F, 1.0F, 0.0F);
		this.renderGunOnGround(entity, itemstack);
		this.gunModel.render(entity, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
		this.renderSpecials(itemstack, false);
		this.renderIronSights(itemstack);
		this.renderMainGunAmmo(entity, itemstack);
		this.renderMainGunAttachments(entity, itemstack);
		GL11.glDisable(2884);
		GL11.glPopMatrix();
	}

	public void renderMainGunOnPlayerBack(EntityPlayer entity, ItemStack itemstack) {
		this.applyGunModel();
		GL11.glPushMatrix();
		String guntexture = this.getTexture(itemstack);
		this.mc.getTextureManager().bindTexture(new ResourceLocation("craftingdead:textures/models/guns/" + guntexture + ".png"));
		this.renderGunOnPlayerBack(entity, itemstack);
		this.gunModel.render(entity, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
		this.renderIronSights(itemstack);
		this.renderMainGunAmmo(entity, itemstack);
		this.renderMainGunAttachments(entity, itemstack);
		GL11.glDisable(2884);
		GL11.glPopMatrix();
	}

	private void renderMainGunAttachments(Entity entity, ItemStack itemstack) {
		if (ItemGun.instance().hasAttachments(itemstack)) {
			for (int i = 0; i < 3; ++i) {
				GunAttachment attachment = ItemGun.instance().getAttachmentFromSlot(itemstack, i);
				if (attachment != null) {
					GL11.glPushMatrix();
					this.mc.getTextureManager().bindTexture(attachment.attachTexture);
					double scale = 0.1D;
					GL11.glScaled(scale, scale, scale);
					this.renderGunAttachment(entity, itemstack, attachment);
					attachment.attachModel.render(entity, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.625F);
					GL11.glEnable(2884);
					GL11.glPopMatrix();
				}
			}
		}
	}

	private void renderMainGunAmmo(Entity entity, ItemStack itemstack) {
		if (ItemGun.instance().getClipLoaded(itemstack) != null) {
			String guntexture = this.getTexture(itemstack);
			GL11.glPushMatrix();
			ItemAmmo ammoItem = (ItemAmmo) ItemGun.instance().getClipLoaded(itemstack).getItem();
			if (ammoItem.magModel != null) {
				String ammoTexture = ammoItem.texture.equals("guntexture") ? guntexture : ammoItem.texture;
				this.mc.getTextureManager().bindTexture(new ResourceLocation("craftingdead:textures/models/guns/" + ammoTexture + ".png"));
				double scale = 0.1D;
				GL11.glScaled(scale, scale, scale);
				this.renderGunAmmo(entity, ItemGun.instance().getClipLoaded(itemstack));
				ammoItem.magModel.render(entity, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.625F);
				GL11.glPopMatrix();
			}
		}

	}

	private void renderInventory(ItemStack i) {
		int[] color = { Color.RED.getRGB(), Color.RED.getRGB(), Color.RED.getRGB(), Color.YELLOW.getRGB(), Color.YELLOW.getRGB(), Color.YELLOW.getRGB(), Color.WHITE.getRGB(), Color.WHITE.getRGB(), Color.WHITE.getRGB(), Color.WHITE.getRGB(), Color.WHITE.getRGB() };
		if (i != null) {
			GL11.glPushMatrix();
			this.draw(0, 0, i.getIconIndex(), 16, 16);
			if (i.stackTagCompound != null && i.stackTagCompound.hasKey("maxrepair") && i.stackTagCompound.hasKey("repair")) {
				NBTTagCompound nbt = i.stackTagCompound;
				int max = nbt.getInteger("maxrepair");
				int now = nbt.getInteger("repair");
				int percent = (now / (max / 100));
				GL11.glScalef(0.5F, 0.5F, 0.5F);
				GL11.glTranslatef(1.5F, 1.5F, 0.0F);
				CDRenderHelper.renderText(percent + "%", 0, 0, color[(int) (percent / 10)]);
			}
			GL11.glPopMatrix();
		}
	}

	private void draw(int par1, int par2, Icon par3Icon, int par4, int par5) {
		Tessellator tessellator = Tessellator.instance;
		tessellator.startDrawingQuads();
		tessellator.addVertexWithUV((double) (par1 + 0), (double) (par2 + par5), 0.0D, (double) par3Icon.getMinU(), (double) par3Icon.getMaxV());
		tessellator.addVertexWithUV((double) (par1 + par4), (double) (par2 + par5), 0.0D, (double) par3Icon.getMaxU(), (double) par3Icon.getMaxV());
		tessellator.addVertexWithUV((double) (par1 + par4), (double) (par2 + 0), 0.0D, (double) par3Icon.getMaxU(), (double) par3Icon.getMinV());
		tessellator.addVertexWithUV((double) (par1 + 0), (double) (par2 + 0), 0.0D, (double) par3Icon.getMinU(), (double) par3Icon.getMinV());
		tessellator.draw();
	}

	public void draw2(int par1, int par2, int par3, int par4, int par5, int par6) {
		float f = 0.00390625F;
		float f1 = 0.00390625F;
		Tessellator tessellator = Tessellator.instance;
		tessellator.startDrawingQuads();
		tessellator.addVertexWithUV((double) (par1 + 0), (double) (par2 + par6), 0.0D, (double) ((float) (par3 + 0) * f), (double) ((float) (par4 + par6) * f1));
		tessellator.addVertexWithUV((double) (par1 + par5), (double) (par2 + par6), 0.0D, (double) ((float) (par3 + par5) * f), (double) ((float) (par4 + par6) * f1));
		tessellator.addVertexWithUV((double) (par1 + par5), (double) (par2 + 0), 0.0D, (double) ((float) (par3 + par5) * f), (double) ((float) (par4 + 0) * f1));
		tessellator.addVertexWithUV((double) (par1 + 0), (double) (par2 + 0), 0.0D, (double) ((float) (par3 + 0) * f), (double) ((float) (par4 + 0) * f1));
		tessellator.draw();
	}

	private void applyGunModel() {
		this.gunModel = this.getGunModel();
	}

	private String getTexture(ItemStack par1) {
		GunPaint skin = ItemGun.instance().getGunSkin(par1);
		return skin != null ? this.getTexture() + "_" + skin.getTextureSuffix() : this.getTexture();
	}

	public abstract void renderGunThirdPerson(Entity var1, ItemStack var2);

	protected abstract void renderGunFirstPerson(EntityPlayer var1, ItemStack var2);

	protected abstract void renderGunFirstPersonAiming(EntityPlayer var1, ItemStack var2);

	protected abstract void renderIronSights(ItemStack var1);

	public abstract void renderSpecials(ItemStack var1, boolean var2);

	protected abstract void renderGunOnGround(Entity var1, ItemStack var2);

	protected abstract void renderGunOnPlayerBack(EntityPlayer var1, ItemStack var2);

	protected abstract void renderGunAmmo(Entity var1, ItemStack var2);

	protected abstract void renderGunAttachment(Entity var1, ItemStack var2, GunAttachment var3);

	public abstract void renderHand(int var1, EntityPlayer var2);

	protected abstract ModelBase getGunModel();

	protected abstract String getTexture();
}
