package com.ferullogaming.craftingdead.item;

import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ItemClothingArmor extends ItemArmor {
   private static final int[] cB = new int[]{11, 16, 15, 13};
   public final int b;
   public final int c;
   private final EnumArmorMaterial cE;
   protected String textureName = "";
   protected String displayName = "";

   public ItemClothingArmor(int par1, EnumArmorMaterial par2EnumArmorMaterial, int par3, int par4) {
      super(par1, par2EnumArmorMaterial, par3, par4);
      this.cE = par2EnumArmorMaterial;
      this.b = par4;
      this.c = par2EnumArmorMaterial.getDamageReductionAmount(par4);
      this.setMaxDamage(par2EnumArmorMaterial.getDurability(par4));
      super.maxStackSize = 1;
      this.setCreativeTab((CreativeTabs)null);
   }

   public int getItemEnchantability() {
      return this.cE.getEnchantability();
   }

   static int[] getMaxDamageArray() {
      return cB;
   }

   public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
      return "craftingdead:textures/models/armor/default_" + slot + ".png";
   }

   public ItemClothingArmor setCDItemDisplayName(String par1) {
      this.displayName = par1;
      this.setUnlocalizedName(par1.replace(" ", ""));
      LanguageRegistry.addName(this, par1);
      return this;
   }

   public ItemClothingArmor setCDItemTextureName(String par2) {
      this.textureName = par2;
      return this;
   }

   public String getDisplayName(ItemStack par1) {
      return this.displayName;
   }

   public static String getCDDisplayName(ItemStack par1) {
      return par1 != null && par1.getItem() instanceof ItemCD ? ((ItemCD)par1.getItem()).getDisplayName(par1) : "";
   }

   public void registerIcons(IconRegister iconRegister) {
      super.itemIcon = iconRegister.registerIcon("craftingdead:" + this.textureName);
   }
}
