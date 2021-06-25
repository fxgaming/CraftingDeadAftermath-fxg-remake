package by.fxg.craftingdead.inventory;

import java.util.ArrayList;

import by.fxg.craftingdead.item.ItemSpecials;
import by.fxg.craftingdead.item.gun.GunAttachment;
import by.fxg.craftingdead.item.gun.GunPaint;
import by.fxg.craftingdead.item.gun.ItemGun;
import by.fxg.craftingdead.item.gun.ItemGunAttachment;
import by.fxg.craftingdead.item.gun.ItemPaint;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

public class InventoryCDA implements IInventory {
   private int invSize = 13;
   private ItemStack[] mainInventory;

   public InventoryCDA() {
      this.mainInventory = new ItemStack[this.invSize];
   }

   public int getSizeInventory() {
      return this.mainInventory.length;
   }

   public ItemStack getStackInSlot(int par1) {
      return this.mainInventory[par1];
   }

   public ItemStack decrStackSize(int par1, int par2) {
      ItemStack[] aitemstack = this.mainInventory;
      if (aitemstack[par1] != null) {
         ItemStack itemstack;
         if (aitemstack[par1].stackSize <= par2) {
            itemstack = aitemstack[par1];
            aitemstack[par1] = null;
            if (par1 == this.getStackSlot("cgun") && this.isGunCraftable(itemstack)) {
               this.craftGun(itemstack);
            }

            return itemstack;
         } else {
            itemstack = aitemstack[par1].splitStack(par2);
            if (aitemstack[par1].stackSize == 0) {
               aitemstack[par1] = null;
            }

            return itemstack;
         }
      } else {
         return null;
      }
   }

   public ItemStack getStackInSlotOnClosing(int par1) {
      if (this.mainInventory[par1] != null) {
         ItemStack itemstack = this.mainInventory[par1];
         this.mainInventory[par1] = null;
         return itemstack;
      } else {
         return null;
      }
   }

   public void setInventorySlotContents(int par1, ItemStack itemstack) {
      if (par1 == this.getStackSlot("cgun") && itemstack != null && itemstack.getItem() instanceof ItemGun) {
         ItemGun gunitem = (ItemGun)itemstack.getItem();
         int var1 = 0;

         for(int i = this.getStackSlot("cattach1"); i <= this.getStackSlot("cattach3"); ++i) {
            if (gunitem.getAttachmentFromSlot(itemstack, var1) != null) {
               this.setInventorySlotContents(i, new ItemStack(GunAttachment.getItemFromGunAttachment(gunitem.getAttachmentFromSlot(itemstack, var1))));
            }
            ++var1;
         }
         gunitem.clearAttachments(itemstack);
         
         if (gunitem.getGunSpecials(itemstack) != 0) {
        	 this.setInventorySlotContents(12, new ItemStack(gunitem.getGunSpecials(itemstack), 1, 0));
        	 gunitem.setGunSpecials(itemstack, 0);
         }
      }

      this.mainInventory[par1] = itemstack;
   }

   public String getInvName() {
      return "Crafting Dead Inventory";
   }

   public boolean isInvNameLocalized() {
      return false;
   }

   public int getInventoryStackLimit() {
      return 64;
   }

   public void onInventoryChanged() {
   }

   public void writeToNBT(NBTTagList par1NBTTagList) {
      for(int i = 0; i < this.invSize; ++i) {
         if (this.mainInventory[i] != null) {
            NBTTagCompound nbttagcompound = new NBTTagCompound();
            nbttagcompound.setByte("Slot", (byte)i);
            this.mainInventory[i].writeToNBT(nbttagcompound);
            par1NBTTagList.appendTag(nbttagcompound);
         }
      }

   }

   public void readFromNBT(NBTTagList par1NBTTagList) {
      this.mainInventory = new ItemStack[this.invSize];

      for(int i = 0; i < par1NBTTagList.tagCount(); ++i) {
         NBTTagCompound nbttagcompound = (NBTTagCompound)par1NBTTagList.tagAt(i);
         int j = nbttagcompound.getByte("Slot");
         if (j != this.getStackSlot("cgun") && j != this.getStackSlot("cattach1") && j != this.getStackSlot("cattach2") && j != this.getStackSlot("cattach3") && j != this.getStackSlot("cpaint") && j != this.getStackSlot("cupgrade")) {
            ItemStack itemstack = ItemStack.loadItemStackFromNBT(nbttagcompound);
            if (itemstack != null) {
               this.mainInventory[j] = itemstack;
            }
         }
      }

   }

   public void craftGun(ItemStack itemstack) {
      if (itemstack != null && itemstack.getItem() instanceof ItemGun) {
         ItemGun itemGun = (ItemGun)itemstack.getItem();

         for(int i = this.getStackSlot("cattach1"); i <= this.getStackSlot("cattach3"); ++i) {
            if (this.mainInventory[i] != null && this.mainInventory[i].getItem() instanceof ItemGunAttachment) {
               GunAttachment attachment = GunAttachment.getAttachmentFromItem(this.mainInventory[i].itemID);
               if (attachment != null && itemGun.isAttachmentAloud(attachment)) {
                  itemGun.setAttachment(itemstack, attachment);
                  this.setInventorySlotContents(i, (ItemStack)null);
               }
            }
         }

         ItemStack paintStack = this.getStack("cpaint");
         if (paintStack != null) {
            itemGun.setGunSkin(itemstack, ((ItemPaint)paintStack.getItem()).paintReference);
            this.setInventorySlotContents(this.getStackSlot("cpaint"), (ItemStack)null);
         }
         
         ItemStack upgradeStack = this.getStack("cupgrade");
         if (upgradeStack != null) {
        	 if (upgradeStack.itemID == 0) {
        		 itemGun.setGunSpecials(itemstack, upgradeStack.itemID);
            	 this.setInventorySlotContents(this.getStackSlot("cupgrade"), (ItemStack)null);
        	 }
        	 itemGun.setGunSpecials(itemstack, upgradeStack.itemID);
        	 this.setInventorySlotContents(this.getStackSlot("cupgrade"), (ItemStack)null);
         }
      }
   }

   public boolean isGunCraftable() {
      return this.isGunCraftable(this.getStack("cgun"));
   }

   public boolean isGunCraftable(ItemStack itemstack) {
      if (itemstack != null && itemstack.getItem() instanceof ItemGun) {
         boolean flag1 = false;
         ItemGun itemGun = (ItemGun)itemstack.getItem();

         for(int i = this.getStackSlot("cattach1"); i <= this.getStackSlot("cattach3"); ++i) {
            if (this.mainInventory[i] != null) {
               GunAttachment attachment = GunAttachment.getAttachmentFromItem(this.mainInventory[i].itemID);
               if (attachment == null || !itemGun.isAttachmentAloud(attachment)) {
                  return false;
               }

               flag1 = true;
            }
         }
         ItemStack upgradeStack = this.getStack("cupgrade");
         if (upgradeStack != null) flag1 = true;
         
         ItemStack paintStack = this.getStack("cpaint");
         if (paintStack != null) {
            flag1 = true;
         }

         if (!flag1) {
            return false;
         } else {
            return true;
         }
      } else {
         return false;
      }
   }

   public boolean isItemGunCraftingAllowed(ItemStack par1) {
      if (par1 == null) {
         return true;
      } else {
         if (par1.getItem() instanceof ItemGunAttachment) {
            GunAttachment attachment = GunAttachment.getAttachmentFromItem(par1.itemID);
            if (((ItemGun)this.getStack("cgun").getItem()).isAttachmentAloud(attachment)) {
               return true;
            }
         }

         if (par1.getItem() instanceof ItemPaint) {
            GunPaint paint = ((ItemPaint)par1.getItem()).paintReference;
            if (((ItemGun)this.getStack("cgun").getItem()).isSkinAllowed(paint)) {
               return true;
            }
         }
         
         if (par1.getItem() instanceof ItemSpecials) {
        	 return true;
         }

         return false;
      }
   }

   public ItemStack getStack(String par1) {
      int var1 = this.getStackSlot(par1);
      return var1 != -1 ? this.mainInventory[var1] : null;
   }

   public int getStackSlot(String par1) {
      if (par1.equals("gun")) {
         return 0;
      } else if (par1.equals("backpack")) {
         return 1;
      } else if (par1.equals("vest")) {
         return 2;
      } else if (par1.equals("melee")) {
         return 3;
      } else if (par1.equals("hat")) {
         return 4;
      } else if (par1.equals("clothing")) {
         return 5;
      } else if (par1.equals("cgun")) {
         return 6;
      } else if (par1.equals("cattach1")) {
         return 7;
      } else if (par1.equals("cattach2")) {
         return 8;
      } else if (par1.equals("cattach3")) {
         return 9;
      } else if (par1.equals("cpaint")){
         return 10;
      } else if (par1.equals("upgrade")){
    	  return 11;
      } else if (par1.equals("cupgrade")){
    	  return 12;
      }
      else {
    	  return -1;
      }
   }

   public ArrayList getInventoryContentList() {
      ArrayList list = new ArrayList();

      for(int i = 0; i < this.mainInventory.length; ++i) {
         if (this.mainInventory[i] != null) {
            list.add(this.mainInventory[i]);
         }
      }

      return list;
   }

   public void clearInventory() {
      this.mainInventory = new ItemStack[this.invSize];
   }

   public ItemStack[] getInventoryContents() {
      return this.mainInventory;
   }

   public boolean isUseableByPlayer(EntityPlayer par1EntityPlayer) {
      return true;
   }

   public void openChest() {
   }

   public void closeChest() {
   }

   public boolean isItemValidForSlot(int i, ItemStack itemstack) {
      return false;
   }
}
