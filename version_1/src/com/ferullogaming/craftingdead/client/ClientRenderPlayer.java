package com.ferullogaming.craftingdead.client;

import org.lwjgl.opengl.GL11;

import com.ferullogaming.craftingdead.CDAftermath;
import com.ferullogaming.craftingdead.client.render.RenderPlayerEvents;
import com.ferullogaming.craftingdead.inventory.InventoryCDA;
import com.ferullogaming.craftingdead.item.ItemClothing;
import com.ferullogaming.craftingdead.player.PlayerData;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class ClientRenderPlayer extends RenderPlayer {
	public static ModelBiped modelBipedMain;
	private ModelBiped modelArmorChestplate;
	private ModelBiped modelArmor;

	public ClientRenderPlayer() {
		super();
		this.modelBipedMain = (ModelBiped) this.mainModel;
		this.modelArmorChestplate = new ModelBiped(1.0F);
		this.modelArmor = new ModelBiped(0.5F);
	}

	protected int setArmorModel(AbstractClientPlayer par1AbstractClientPlayer, int par2, float par3) {
		PlayerData data = CDAftermath.instance.playerDataHandler().getPlayerData(par1AbstractClientPlayer);
		return super.setArmorModel(par1AbstractClientPlayer, par2, par3);
	}

	@SuppressWarnings("unused")
	protected void renderSpecials(AbstractClientPlayer var1, float var2) {
		super.renderSpecials(var1, var2);
		RenderPlayerEvents.instance().onRenderSpecials(var1, this.modelArmorChestplate, this.modelArmor, this.modelBipedMain, this);
	}

	public void renderFirstPersonArm(EntityPlayer par1EntityPlayer) {
		float f = 1.0F;
        GL11.glColor3f(f, f, f);
        if (this.modelBipedMain.bipedRightArm.isHidden) {
        	this.modelBipedMain.bipedRightArm.isHidden = false;
	        this.modelBipedMain.onGround = 0.0F;
	        this.modelBipedMain.setRotationAngles(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F, par1EntityPlayer);
	        this.modelBipedMain.bipedRightArm.render(0.0625F);
			RenderPlayerEvents.instance().onPostFirstPersonRender(par1EntityPlayer, this, this.modelBipedMain);
			this.modelBipedMain.bipedRightArm.isHidden = true;
        } else {
	        this.modelBipedMain.onGround = 0.0F;
	        this.modelBipedMain.setRotationAngles(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F, par1EntityPlayer);
	        this.modelBipedMain.bipedRightArm.render(0.0625F);
			RenderPlayerEvents.instance().onPostFirstPersonRender(par1EntityPlayer, this, this.modelBipedMain);
        }
	}

	@Override
	public ResourceLocation getEntityTexture(Entity var1) {
		PlayerData playerData = CDAftermath.instance.playerDataHandler().getPlayerData((AbstractClientPlayer) var1);
		if (playerData.getCDInventory().getStack("clothing") != null) {
			ItemStack clothingStack = playerData.getCDInventory().getStack("clothing");
			String var2 = ItemClothing.getClothingTexture(clothingStack);
			if (var2 != null) {
				ResourceLocation var3 = new ResourceLocation("craftingdead:textures/models/clothing/" + var2 + ".png");
				return var3;
			} else {
				return this.func_110817_a((AbstractClientPlayer) var1);
			}
		} else {
			return this.func_110817_a((AbstractClientPlayer) var1);
		}
	}
}
