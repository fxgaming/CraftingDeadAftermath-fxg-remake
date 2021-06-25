package com.ferullogaming.craftingdead.item.gun;

import com.ferullogaming.craftingdead.client.model.guns.ModelAttachmentACOG;
import com.ferullogaming.craftingdead.client.model.guns.ModelAttachmentBipod;
import com.ferullogaming.craftingdead.client.model.guns.ModelAttachmentGrip;
import com.ferullogaming.craftingdead.client.model.guns.ModelAttachmentMuzzleBrake;
import com.ferullogaming.craftingdead.client.model.guns.ModelAttachmentReddot;
import com.ferullogaming.craftingdead.client.model.guns.ModelAttachmentScope;
import com.ferullogaming.craftingdead.client.model.guns.ModelAttachmentScope2;
import com.ferullogaming.craftingdead.client.model.guns.ModelAttachmentSuppressor;
import com.ferullogaming.craftingdead.item.ItemManager;

import net.minecraft.client.model.ModelBase;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

public class GunAttachment {
	public static GunAttachment[] attachmentList = new GunAttachment[24];
	public int damage = 0;
	public float recoil = 0.0F;
	public float zoomLevel = 1.0F;
	public static GunAttachment REDDOT;
	public static GunAttachment ACOG;
	public static GunAttachment SCOPELP;
	public static GunAttachment SCOPEHP;
	public static GunAttachment GRIP;
	public static GunAttachment BIPOD;
	public static GunAttachment SURPPRESSOR;
	public static GunAttachment MUZZLE_BRAKE;
	public int attachmentID;
	public String name;
	public boolean isSight = false;
	public boolean isUnderbarrel = false;
	public boolean isSupressor = false;
	public boolean isSupressorSlot = false;
	public ModelBase attachModel;
	public ResourceLocation attachTexture;
	public int attachmentItem;
	public ResourceLocation scopeTexture;
	public int maxRepair;

	public GunAttachment(int par1, String par2, int par3) {
		this.attachmentID = par1;
		this.name = par2;
		this.attachmentItem = par3;
		attachmentList[par1] = this;
	}

	public GunAttachment setModel(ModelBase par1, String par2) {
		this.attachTexture = new ResourceLocation("craftingdead:textures/models/attachments/" + par2 + ".png");
		this.attachModel = par1;
		return this;
	}

	public GunAttachment setScopeTexture(String par1) {
		this.scopeTexture = new ResourceLocation("craftingdead:textures/misc/sights/" + par1 + ".png");
		return this;
	}

	public GunAttachment setSight(float par1Zoom) {
		this.zoomLevel = par1Zoom;
		this.isSight = true;
		return this;
	}

	public GunAttachment setSupressor(int maxRepair) {
		this.isSupressor = true;
		this.maxRepair = maxRepair;
		return this;
	}

	public GunAttachment setSupressorSlot(int maxRepair) {
		this.isSupressorSlot = true;
		this.maxRepair = maxRepair;
		return this;
	}

	public GunAttachment setUnderBarrel() {
		this.isUnderbarrel = true;
		return this;
	}

	public GunAttachment setRecoil(float par1) {
		this.recoil = par1;
		return this;
	}

	public GunAttachment setDamage(int par1) {
		this.damage = par1;
		return this;
	}

	public static GunAttachment getAttachmentFromItem(int item) {
		if (item != 0) {
			for (int i = 0; i < attachmentList.length; ++i) {
				if (attachmentList[i] != null && attachmentList[i].attachmentItem == item) {
					return attachmentList[i];
				}
			}
		}

		return null;
	}

	public static Item getItemFromGunAttachment(GunAttachment par1) {
		return par1 != null && par1.attachmentItem != 0 ? Item.itemsList[par1.attachmentItem] : null;
	}

	public int getAttachmentID() {
		return this.attachmentID;
	}

	public String getAttachmentName() {
		return this.name;
	}

	static {
		REDDOT = (new GunAttachment(1, "'Красная точка'", ItemManager.attachmentReddot.itemID)).setModel(new ModelAttachmentReddot(), "attachmentreddot").setSight(2.5F);
		ACOG = (new GunAttachment(2, "Улучшенный боевой оптический прицел", ItemManager.attachmentACOG.itemID)).setModel(new ModelAttachmentACOG(), "attachmentacog").setSight(3.25F);
		SCOPELP = (new GunAttachment(4, "Прицел БР", ItemManager.attachmentScope6x.itemID)).setModel(new ModelAttachmentScope(), "attachmentscope").setSight(5.0F).setScopeTexture("scope1");
		SCOPEHP = (new GunAttachment(5, "Прицел ДР", ItemManager.attachmentScope12x.itemID)).setModel(new ModelAttachmentScope2(), "attachmentscope2").setSight(8.0F).setScopeTexture("scope2");
		GRIP = (new GunAttachment(10, "Тактическая рукоядка", ItemManager.attachmentGrip.itemID)).setModel(new ModelAttachmentGrip(), "attachmentgrip").setUnderBarrel().setRecoil(-1.0F);
		BIPOD = (new GunAttachment(11, "Сошка", ItemManager.attachmentBipod.itemID)).setModel(new ModelAttachmentBipod(), "attachmentbipod").setUnderBarrel().setRecoil(-2.0F);
		SURPPRESSOR = (new GunAttachment(20, "Глушитель", ItemManager.attachmentSupressor.itemID)).setModel(new ModelAttachmentSuppressor(), "attachmentsuppressor").setSupressor(900).setDamage(-2);
		MUZZLE_BRAKE = (new GunAttachment(21, "Дульный тормоз", ItemManager.attachmentMuzzleBrake.itemID)).setModel(new ModelAttachmentMuzzleBrake(), "attachmentmuzzlebrake").setSupressorSlot(1500).setRecoil(-1.5F);
	}
}
