package by.fxg.craftingdead.item;

import java.util.Iterator;
import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import org.lwjgl.input.Keyboard;

import by.fxg.craftingdead.CDReloaded;
import by.fxg.craftingdead.client.render.RenderBackpack;
import by.fxg.craftingdead.inventory.InventoryBackpack;
import by.fxg.craftingdead.player.PlayerData;
import by.fxg.craftingdead.player.PlayerDataHandler;

public class ItemBackpack extends ItemCD {
   private EnumBackpackSize backpackSize;
   private RenderBackpack backpackRendering;

   public ItemBackpack(int par1, EnumBackpackSize par2) {
      super(par1);
      this.backpackSize = par2;
      this.setMaxStackSize(1);
   }

   public ItemBackpack setRenderer(RenderBackpack par1) {
      this.backpackRendering = par1;
      return this;
   }

   public static IInventory getBackpackInventory(EntityPlayer player) {
      IInventory backpackInv = null;
      PlayerData data = CDReloaded.instance.playerDataHandler().getPlayerData(player);
      ItemStack backpack = data.getCDInventory().getStack("backpack");
      if (!player.worldObj.isRemote && backpack != null && backpack.getItem() instanceof ItemBackpack) {
         backpackInv = new InventoryBackpack(getBackpackSize(backpack), backpack);
      }

      return backpackInv;
   }

   public static IInventory getBackpackInventory(ItemStack itemstack) {
      return itemstack != null && itemstack.getItem() instanceof ItemBackpack ? new InventoryBackpack(getBackpackSize(itemstack), itemstack) : null;
   }

   public static EnumBackpackSize getBackpackSize(ItemStack par1) {
      return par1 != null && par1.getItem() instanceof ItemBackpack ? ((ItemBackpack)par1.getItem()).getBackpackSize() : null;
   }

   public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
      super.addInformation(par1ItemStack, par2EntityPlayer, par3List, par4);
      InventoryBackpack backpackInventory = (InventoryBackpack)getBackpackInventory(par1ItemStack);
      if (backpackInventory != null) {
         int var1 = backpackInventory.getInventoryList().size();
         par3List.add("Нажмите 'R' для большей информации!");
         par3List.add("Содержит " + EnumChatFormatting.RED + var1 + EnumChatFormatting.GRAY + " вещь(ей)");
         if (Keyboard.isKeyDown(19)) {
            par3List.add(EnumChatFormatting.RED + "-=-=-=- Содержание -=-=-=-");
            Iterator var7 = backpackInventory.getInventoryList().iterator();

            while(var7.hasNext()) {
               ItemStack stack = (ItemStack)var7.next();
               par3List.add(stack.getDisplayName());
            }
         }
      }

   }

   public boolean getShareTag() {
      return true;
   }

   public RenderBackpack getBackpackRenderer() {
      return this.backpackRendering;
   }

   public EnumBackpackSize getBackpackSize() {
      return this.backpackSize;
   }
}
