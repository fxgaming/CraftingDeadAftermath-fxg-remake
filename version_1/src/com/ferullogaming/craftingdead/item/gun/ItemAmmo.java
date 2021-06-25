package com.ferullogaming.craftingdead.item.gun;

import java.util.List;

import com.ferullogaming.craftingdead.item.ItemCD;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

public class ItemAmmo extends ItemCD {
	public int clipSize = 1;
	public EnumAmmoType type;
	public ModelBase magModel;
	public String texture;
	public double armorPenetration;

	public ItemAmmo(int par1, int par2) {
		super(par1);
		this.type = EnumAmmoType.NORMAL;
		this.armorPenetration = 10.0D;
		this.clipSize = par2;
		this.setMaxDamage(par2 + 1);
		this.setMaxStackSize(1);
	}

	public ItemAmmo(int par1, int par2, EnumAmmoType type) {
		super(par1);
		this.type = EnumAmmoType.NORMAL;
		this.armorPenetration = 10.0D;
		this.clipSize = par2;
		this.setMaxDamage(par2 + 1);
		this.setMaxStackSize(1);
		this.type = type;
	}

	public void onUpdate(ItemStack par1ItemStack, World par2World, Entity par3Entity, int par4, boolean par5) {
		if (par3Entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) par3Entity;
			if (player.getCurrentEquippedItem() == par1ItemStack && this.getDamage(par1ItemStack) > this.clipSize) {
				player.inventory.setInventorySlotContents(player.inventory.currentItem, (ItemStack) null);
			}
		}

	}

	public void setAmmoInfected(ItemStack itemstack, boolean par2) {
		NBTTagCompound tag = this.getNBTTagCompound(itemstack);
		tag.setBoolean("infected", par2);
	}

	public boolean isAmmoInfected(ItemStack itemstack) {
		NBTTagCompound tag = this.getNBTTagCompound(itemstack);
		return tag.hasKey("infected") ? tag.getBoolean("infected") : false;
	}

	public ItemAmmo setModel(ModelBase model, String texture) {
		this.magModel = model;
		this.texture = texture;
		return this;
	}

	public ItemAmmo setArmorPenetration(double par1) {
		this.armorPenetration = par1;
		return this;
	}

	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		super.addInformation(par1ItemStack, par2EntityPlayer, par3List, par4);
		int var1 = this.clipSize - par1ItemStack.getItemDamage();
		par3List.add("Патронов " + EnumChatFormatting.RED + var1);
		if (this.isAmmoInfected(par1ItemStack)) {
			par3List.add(EnumChatFormatting.RED + "Зараженные патроны");
		}

		if (this.type != EnumAmmoType.NORMAL) {
			String ammoType = this.type.getFormat() + "" + this.type.getLabel();
			par3List.add(EnumChatFormatting.GRAY + ammoType + " патроны");
		}

		if (this.armorPenetration > 10.0D) {
			par3List.add("Бронепробиваемость: " + EnumChatFormatting.RED + "" + (int) this.armorPenetration + "%");
		}

	}

	public boolean hasEffect(ItemStack par1ItemStack, int pass) {
		return this.isAmmoInfected(par1ItemStack);
	}

	protected NBTTagCompound getNBTTagCompound(ItemStack itemstack) {
		String var1 = "cdaammo";
		if (itemstack.stackTagCompound == null) {
			itemstack.setTagCompound(new NBTTagCompound());
		}

		if (!itemstack.stackTagCompound.hasKey(var1)) {
			itemstack.stackTagCompound.setTag(var1, new NBTTagCompound(var1));
		}

		return (NBTTagCompound) itemstack.stackTagCompound.getTag(var1);
	}
}
