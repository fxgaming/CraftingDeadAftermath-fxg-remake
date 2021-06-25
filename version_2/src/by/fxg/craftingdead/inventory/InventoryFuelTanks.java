package by.fxg.craftingdead.inventory;

import java.util.ArrayList;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

public class InventoryFuelTanks implements IInventory {
   private ItemStack tacticalVestStack;
   private boolean loadingInv = false;
   private ItemStack[] inventoryContents = new ItemStack[9];

   public InventoryFuelTanks(ItemStack par2) {
      this.tacticalVestStack = par2;
      this.loadInventory();
   }

   public String getInvName() {
      return "Flame Thrower Fuel Tanks";
   }

   public boolean isInvNameLocalized() {
      return false;
   }

   public int getInventoryStackLimit() {
      return 64;
   }

   public void onInventoryChanged() {
      if (!this.loadingInv) {
         this.saveInventory();
      }

   }

   public void openChest() {
      this.loadInventory();
   }

   public void closeChest() {
      this.saveInventory();
   }

   public boolean isUseableByPlayer(EntityPlayer entityplayer) {
      return true;
   }

   public boolean isItemValidForSlot(int i, ItemStack itemstack) {
      return true;
   }

   public int getSizeInventory() {
      return this.inventoryContents != null ? this.inventoryContents.length : 0;
   }

   public ItemStack getStackInSlot(int i) {
      return this.inventoryContents[i];
   }

   public ItemStack decrStackSize(int par1, int par2) {
      if (this.inventoryContents[par1] != null) {
         ItemStack itemstack;
         if (this.inventoryContents[par1].stackSize <= par2) {
            itemstack = this.inventoryContents[par1];
            this.inventoryContents[par1] = null;
            this.onInventoryChanged();
            return itemstack;
         } else {
            itemstack = this.inventoryContents[par1].splitStack(par2);
            if (this.inventoryContents[par1].stackSize == 0) {
               this.inventoryContents[par1] = null;
            }

            this.onInventoryChanged();
            return itemstack;
         }
      } else {
         return null;
      }
   }

   public ItemStack getStackInSlotOnClosing(int par1) {
      if (this.inventoryContents[par1] != null) {
         ItemStack itemstack = this.inventoryContents[par1];
         this.inventoryContents[par1] = null;
         return itemstack;
      } else {
         return null;
      }
   }

   public void setInventorySlotContents(int par1, ItemStack par2ItemStack) {
      this.inventoryContents[par1] = par2ItemStack;
      this.onInventoryChanged();
   }

   public void saveInventory() {
      NBTTagCompound nbt = this.getNBTTagCompound(this.tacticalVestStack);
      NBTTagList list = new NBTTagList();

      for(int i = 0; i < this.getSizeInventory(); ++i) {
         if (this.getStackInSlot(i) != null) {
            NBTTagCompound nbttagcompound = new NBTTagCompound();
            nbttagcompound.setByte("slot", (byte)i);
            this.getStackInSlot(i).writeToNBT(nbttagcompound);
            list.appendTag(nbttagcompound);
         }
      }

      nbt.setTag("content", list);
   }

   public void loadInventory() {
      this.loadingInv = true;
      NBTTagCompound nbt = this.getNBTTagCompound(this.tacticalVestStack);
      NBTTagList list = nbt.getTagList("content");

      for(int i = 0; i < list.tagCount(); ++i) {
         NBTTagCompound nbttagcompound = (NBTTagCompound)list.tagAt(i);
         int j = nbttagcompound.getByte("slot");
         ItemStack itemstack = ItemStack.loadItemStackFromNBT(nbttagcompound);
         if (itemstack != null) {
            this.setInventorySlotContents(j, itemstack);
         }
      }

      this.loadingInv = false;
   }

   public ArrayList getInventoryList() {
      ArrayList list = new ArrayList();

      for(int i = 0; i < this.inventoryContents.length; ++i) {
         if (this.inventoryContents[i] != null) {
            list.add(this.inventoryContents[i].copy());
         }
      }

      return list;
   }

   public NBTTagCompound getNBTTagCompound(ItemStack itemstack) {
      String var1 = "tanks";
      if (!itemstack.hasTagCompound()) {
         itemstack.setTagCompound(new NBTTagCompound("tag"));
      }

      if (!itemstack.stackTagCompound.hasKey(var1)) {
         NBTTagCompound tag = new NBTTagCompound(var1);
         itemstack.stackTagCompound.setTag(var1, tag);
      }

      return (NBTTagCompound)itemstack.stackTagCompound.getTag(var1);
   }
}
