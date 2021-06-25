package by.fxg.craftingdead.item;

import cpw.mods.fml.common.registry.LanguageRegistry;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import org.lwjgl.input.Keyboard;

import by.fxg.craftingdead.ModSettings;
import by.fxg.craftingdead.client.util.KeyBindingManager;

public class ItemCD extends Item {
   protected String textureName = "";
   protected String displayName = "";
   protected ArrayList basicInformation = new ArrayList();

   public ItemCD(int par1) {
      super(par1);
      this.setCreativeTab(ItemManager.tabCraftingDead);
      this.setMaxStackSize(1);
      ItemManager.whitelistedCraftingDeadItems.add(par1);
   }

   public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
      return par1ItemStack;
   }

   public ItemCD setCDItemDisplayName(String par1) {
      this.displayName = par1;
      this.setUnlocalizedName(par1.replace(" ", ""));
      LanguageRegistry.addName(this, par1);
      return this;
   }

   public ItemCD setCDItemTextureName(String par2) {
      this.textureName = par2;
      return this;
   }

   public ItemCD addInformation(String par1) {
      this.basicInformation.add(par1);
      return this;
   }

   public String getDisplayName(ItemStack par1) {
      return this.displayName;
   }

   public static String getCDDisplayName(ItemStack par1) {
      return par1 != null && par1.getItem() instanceof ItemCD ? ((ItemCD)par1.getItem()).getDisplayName(par1) : "";
   }

   public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
      if (this.basicInformation.size() > 0) {
         par3List.addAll(this.basicInformation);
      }
   }

   public void registerIcons(IconRegister iconRegister) {
      super.itemIcon = iconRegister.registerIcon("craftingdead:" + this.textureName);
   }
}
