package by.fxg.craftingdead.item;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

public class ItemChalk extends ItemCD {
   public ItemChalk(int par1) {
      super(par1);
      this.addInformation("Нажмите ПКМ что-бы изменить название! Совместите с");
      this.addInformation("Оружием, Холодным оружием, Рюкзаками и Жилетами!");
   }

   @SideOnly(Side.CLIENT)
   public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
      if (FMLCommonHandler.instance().getSide() == Side.CLIENT && par2World.isRemote) {
         Minecraft.getMinecraft().displayGuiScreen(new GuiChalk());
      }

      return par1ItemStack;
   }

   public void onChalkNamed(EntityPlayer player, ItemStack stack, String name) {
      if (!player.worldObj.isRemote) {
         this.setNameTag(stack, name);
      }

   }

   public boolean hasNameTag(ItemStack itemstack) {
      return this.getNameTag(itemstack) != null;
   }

   public String getNameTag(ItemStack itemstack) {
      NBTTagCompound tag = this.getNBTTagCompound(itemstack);
      return tag.hasKey("nametag") ? tag.getString("nametag") : null;
   }

   public void setNameTag(ItemStack itemstack, String par2) {
      NBTTagCompound tag = this.getNBTTagCompound(itemstack);
      tag.setString("nametag", par2);
   }

   public boolean getShareTag() {
      return true;
   }

   public boolean hasEffect(ItemStack par1ItemStack, int pass) {
      return this.hasNameTag(par1ItemStack);
   }

   @SideOnly(Side.CLIENT)
   public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
      if (this.hasNameTag(par1ItemStack)) {
         par3List.add(EnumChatFormatting.RED + "" + EnumChatFormatting.ITALIC + "" + this.getNameTag(par1ItemStack));
      }

      super.addInformation(par1ItemStack, par2EntityPlayer, par3List, par4);
   }

   protected NBTTagCompound getNBTTagCompound(ItemStack itemstack) {
      String var1 = "chalk";
      if (itemstack.stackTagCompound == null) {
         itemstack.setTagCompound(new NBTTagCompound());
      }

      if (!itemstack.stackTagCompound.hasKey(var1)) {
         itemstack.stackTagCompound.setTag(var1, new NBTTagCompound(var1));
      }

      return (NBTTagCompound)itemstack.stackTagCompound.getTag(var1);
   }
}
