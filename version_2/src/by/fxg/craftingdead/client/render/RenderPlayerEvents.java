package by.fxg.craftingdead.client.render;

import org.lwjgl.opengl.GL11;

import by.fxg.craftingdead.CDReloaded;
import by.fxg.craftingdead.client.model.ModelHandcuffs;
import by.fxg.craftingdead.client.render.guns.RenderGun;
import by.fxg.craftingdead.client.render.hat.RenderHat;
import by.fxg.craftingdead.inventory.InventoryCDA;
import by.fxg.craftingdead.item.ItemBackpack;
import by.fxg.craftingdead.item.ItemClothing;
import by.fxg.craftingdead.item.ItemFuelTankBackpack;
import by.fxg.craftingdead.item.ItemHat;
import by.fxg.craftingdead.item.ItemTacticalVest;
import by.fxg.craftingdead.player.PlayerData;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.IItemRenderer.ItemRenderType;
import net.minecraftforge.client.MinecraftForgeClient;

public class RenderPlayerEvents {
	private ModelHandcuffs modelHandcuff = new ModelHandcuffs();

	public void onPreRender(AbstractClientPlayer par1, ModelBiped par2, ModelBiped par3, ModelBiped par4, RenderPlayer par5) {
		PlayerData playerData = CDReloaded.instance.playerDataHandler().getPlayerData((EntityPlayer) par1);
		if (playerData.isAiming) {
			par2.aimedBow = par3.aimedBow = par4.aimedBow = true;
		}

		if (playerData.isHandCuffed) {
			par2.isSneak = par3.isSneak = par4.isSneak = true;
		}

	}

	public void onPostRender(AbstractClientPlayer par1, ModelBiped par2, ModelBiped par3, ModelBiped par4, RenderPlayer par5) {
		par2.aimedBow = par3.aimedBow = par4.aimedBow = false;
		par2.isSneak = par3.isSneak = par4.isSneak = false;
	}

	public void onRenderSpecials(AbstractClientPlayer par1, ModelBiped par2, ModelBiped par3, ModelBiped par4, RenderPlayer par5) {
		PlayerData playerData = CDReloaded.instance.playerDataHandler().getPlayerData((EntityPlayer) par1);

		InventoryCDA inv = playerData.getCDInventory();
		ItemStack hatStack;
		if (inv.getStack("gun") != null) {
			hatStack = inv.getStack("gun");
			IItemRenderer itemrender = MinecraftForgeClient.getItemRenderer(hatStack, ItemRenderType.EQUIPPED);
			GL11.glPushMatrix();
			if (par1.isSneaking()) {
				GL11.glRotatef(30.0F, 1.0F, 0.0F, 0.0F);
				GL11.glTranslatef(0.0F, 0.1F, -0.02F);
			}

			if (par1 != null && itemrender != null && itemrender instanceof RenderGun) {
				((RenderGun) itemrender).renderMainGunOnPlayerBack(par1, hatStack);
			}

			GL11.glPopMatrix();
		}

		if (inv.getStack("melee") != null) {
			hatStack = inv.getStack("melee");
			GL11.glPushMatrix();
			if (par1.isSneaking()) {
				GL11.glRotatef(30.0F, 1.0F, 0.0F, 0.0F);
				GL11.glTranslatef(0.0F, 0.1F, -0.02F);
			}

			GL11.glTranslatef(0.25F, 1.4F, 0.18F);
			GL11.glRotatef(-45.0F, 0.0F, 0.0F, 1.0F);
			double scale = 1.5D;
			GL11.glScaled(scale, scale, scale);
			this.renderDroppedItem(hatStack);
			GL11.glPopMatrix();
		}

		if (inv.getStack("backpack") != null) {
			hatStack = inv.getStack("backpack");
			if (hatStack.getItem() instanceof ItemBackpack) {
				ItemBackpack backpackItem = (ItemBackpack) hatStack.getItem();
				RenderBackpack renderer = backpackItem.getBackpackRenderer();
				Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("craftingdead:textures/models/backpacks/" + renderer.getTexture() + ".png"));
				GL11.glPushMatrix();
				if (par1.isSneaking()) {
					GL11.glRotatef(30.0F, 1.0F, 0.0F, 0.0F);
					GL11.glTranslatef(0.0F, 0.0F, -0.02F);
				}

				renderer.renderBackpack(par1, hatStack);
				GL11.glPopMatrix();
			}

			if (hatStack.getItem() instanceof ItemFuelTankBackpack) {
				ItemFuelTankBackpack itemtank = (ItemFuelTankBackpack) hatStack.getItem();
				RenderFuelTanks renderer = itemtank.getRenderer();
				Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("craftingdead:textures/models/backpacks/" + renderer.getTexture() + ".png"));
				GL11.glPushMatrix();
				if (par1.isSneaking()) {
					GL11.glRotatef(30.0F, 1.0F, 0.0F, 0.0F);
					GL11.glTranslatef(0.0F, 0.0F, -0.02F);
				}

				renderer.renderBackpack(par1, hatStack);
				GL11.glPopMatrix();
			}
		}

		if (inv.getStack("vest") != null) {
			hatStack = inv.getStack("vest");
			ItemTacticalVest vestItem = (ItemTacticalVest) hatStack.getItem();
			RenderTacticalVest renderer = vestItem.getTacticalVestRenderer();
			Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("craftingdead:textures/models/tacticalvests/" + renderer.getTexture() + ".png"));
			GL11.glPushMatrix();
			if (par1.isSneaking()) {
				GL11.glRotatef(30.0F, 1.0F, 0.0F, 0.0F);
				GL11.glTranslatef(0.0F, 0.0F, -0.02F);
			}

			renderer.renderBackpack(par1, hatStack);
			GL11.glPopMatrix();
		}

		if (inv.getStack("hat") != null) {
			hatStack = inv.getStack("hat");
			GL11.glPushMatrix();
			par4.bipedHead.postRender(0.0625F);
			RenderHat hatRenderer = ((ItemHat) hatStack.getItem()).getHatRenderer();
			if (hatRenderer != null) {
				GL11.glPushMatrix();
				hatRenderer.renderHat(par1, hatStack);
				GL11.glPopMatrix();
			}

			GL11.glPopMatrix();
		}

		if (playerData.isHandCuffed) {
			Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("craftingdead:textures/models/handcuff.png"));
			GL11.glPushMatrix();
			float scale = 1.4F;
			GL11.glScalef(scale, scale, scale);
			GL11.glPushMatrix();
			par4.bipedRightArm.postRender(0.0625F);
			this.modelHandcuff.rightHandCuff = true;
			GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
			GL11.glTranslated(-0.32D, -0.06D, -0.4D);
			this.modelHandcuff.render(par1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
			GL11.glPopMatrix();
			GL11.glPushMatrix();
			par4.bipedLeftArm.postRender(0.0625F);
			this.modelHandcuff.leftHandCuff = true;
			GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
			GL11.glTranslated(0.07D, -0.06D, -0.4D);
			this.modelHandcuff.render(par1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
			GL11.glPopMatrix();
			GL11.glPushMatrix();
			this.modelHandcuff.middleHandCuff = true;
			GL11.glTranslated(-0.22D, 0.34D, 0.14D);
			GL11.glScalef(1.3F, 1.0F, 1.0F);
			this.modelHandcuff.render(par1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
			GL11.glPopMatrix();
			GL11.glPopMatrix();
		}
	}

	public void renderPlayerModel(RenderPlayer renderer, ModelBase model, EntityLivingBase par1EntityLivingBase, float par2, float par3, float par4, float par5, float par6, float par7) {
		EntityPlayer player = (EntityPlayer) par1EntityLivingBase;
		if (!par1EntityLivingBase.isInvisible()) {
			model.render(par1EntityLivingBase, par2, par3, par4, par5, par6, par7);
		} else if (!par1EntityLivingBase.isInvisibleToPlayer(Minecraft.getMinecraft().thePlayer)) {
			GL11.glPushMatrix();
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.15F);
			GL11.glDepthMask(false);
			GL11.glEnable(3042);
			GL11.glBlendFunc(770, 771);
			GL11.glAlphaFunc(516, 0.003921569F);
			model.render(par1EntityLivingBase, par2, par3, par4, par5, par6, par7);
			GL11.glDisable(3042);
			GL11.glAlphaFunc(516, 0.1F);
			GL11.glPopMatrix();
			GL11.glDepthMask(true);
		} else {
			model.setRotationAngles(par2, par3, par4, par5, par6, par7, par1EntityLivingBase);
		}

		PlayerData playerData = CDReloaded.instance.playerDataHandler().getPlayerData(player);
		if (playerData.getCDInventory().getStack("clothing") != null) {
			ItemStack clothingStack = playerData.getCDInventory().getStack("clothing");
			String var1 = ItemClothing.getClothingTexture(clothingStack);
			if (var1 != null) {
				ResourceLocation var2 = new ResourceLocation("craftingdead:textures/models/clothing/" + var1 + ".png");
				Minecraft.getMinecraft().renderEngine.bindTexture(var2);
				GL11.glDepthMask(false);
				GL11.glEnable(3042);
				GL11.glBlendFunc(770, 771);
				GL11.glAlphaFunc(516, 0.003921569F);
				GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
				model.render(par1EntityLivingBase, par2, par3, par4, par5, par6, par7);
				GL11.glDisable(3042);
				GL11.glAlphaFunc(516, 0.1F);
				GL11.glDepthMask(true);
			}
		}

	}

	public void onPostFirstPersonRender(EntityPlayer par1, RenderPlayer par2, ModelBiped par3) {
		PlayerData playerData = CDReloaded.instance.playerDataHandler().getPlayerData(par1);
		if (playerData.getCDInventory().getStack("clothing") != null) {
			ItemStack clothingStack = playerData.getCDInventory().getStack("clothing");
			String var1 = ItemClothing.getClothingTexture(clothingStack);
			if (var1 != null) {
				ResourceLocation var2 = new ResourceLocation("craftingdead:textures/models/clothing/" + var1 + ".png");
				Minecraft.getMinecraft().renderEngine.bindTexture(var2);
				GL11.glEnable(3042);
				GL11.glBlendFunc(770, 771);
				GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
				par3.onGround = 0.0F;
				par3.setRotationAngles(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F, par1);
				par3.bipedRightArm.render(0.0625F);
				GL11.glDisable(3042);
			}
		}
	}

	private void renderDroppedItem(ItemStack par1ItemStack) {
		Tessellator tessellator = Tessellator.instance;
		TextureManager texturemanager = Minecraft.getMinecraft().getTextureManager();
		Icon par2Icon = par1ItemStack.getItem().getIcon(par1ItemStack, 0);
		if (par2Icon == null) {
			ResourceLocation resourcelocation = texturemanager.getResourceLocation(par1ItemStack.getItemSpriteNumber());
			par2Icon = ((TextureMap) texturemanager.getTexture(resourcelocation)).getAtlasSprite("missingno");
		}

		float f4 = ((Icon) par2Icon).getMinU();
		float f5 = ((Icon) par2Icon).getMaxU();
		float f6 = ((Icon) par2Icon).getMinV();
		float f7 = ((Icon) par2Icon).getMaxV();
		float f8 = 1.0F;
		float f9 = 0.5F;
		float f10 = 0.25F;
		if (par1ItemStack != null) {
			if (par1ItemStack.getItemSpriteNumber() == 0) {
				texturemanager.bindTexture(TextureMap.locationBlocksTexture);
			} else {
				texturemanager.bindTexture(TextureMap.locationItemsTexture);
			}

			GL11.glPushMatrix();
			float f12 = 0.0625F;
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			double scale = 0.6D;
			GL11.glScaled(scale, scale, scale);
			GL11.glTranslatef(0.3F, -1.3F, 0.0F);
			ItemRenderer.renderItemIn2D(tessellator, f5, f6, f4, f7, ((Icon) par2Icon).getIconWidth(), ((Icon) par2Icon).getIconHeight(), f12);
			GL11.glPopMatrix();
		}

	}

	public static RenderPlayerEvents instance() {
		return new RenderPlayerEvents();
	}
}
