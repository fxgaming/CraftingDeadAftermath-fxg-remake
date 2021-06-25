package com.ferullogaming.craftingdead.entity;

import com.ferullogaming.craftingdead.CDAftermath;
import com.ferullogaming.craftingdead.inventory.ContainerCDChest;
import com.ferullogaming.craftingdead.inventory.InventoryCDA;
import com.ferullogaming.craftingdead.item.ItemClothingArmor;
import com.ferullogaming.craftingdead.player.PlayerData;
import com.ferullogaming.craftingdead.player.PlayerDataHandler;
import java.util.ArrayList;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.packet.Packet100OpenWindow;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;

public class EntityCorpse extends Entity implements IInventory {
   public ItemStack[] mainItemsStored = new ItemStack[45];
   public String corpsePlayerName = "";
   public int maxLifeSPan = 4800;
   public int ageTick = 0;

   public EntityCorpse(World par1World) {
      super(par1World);
      this.setSize(1.0F, 0.5F);
   }

   public EntityCorpse(EntityPlayer player) {
      super(player.worldObj);
      this.corpsePlayerName = player.getEntityName();
      this.setUsernameKilled(this.corpsePlayerName);
      this.setPosition(player.posX, player.posY, player.posZ);
      this.mainItemsStored = new ItemStack[45];
      this.setSize(1.0F, 0.5F);
   }

   protected void entityInit() {
      super.dataWatcher.addObject(20, "");
      super.dataWatcher.addObject(21, 0);
   }

   public void onEntityUpdate() {
      super.onEntityUpdate();
      if (this.getLifeStage() > 4) {
         this.setDead();
      }

      if (this.ageTick++ > this.maxLifeSPan) {
         this.setDead();
         this.ageTick = 0;
      }

      if (!super.onGround) {
         super.motionY -= 0.02D;
      }

      this.moveEntity(super.motionX, super.motionY, super.motionZ);
   }

   public boolean hitByEntity(Entity par1Entity) {
      this.setLifeStage(this.getLifeStage() + 1);
      return false;
   }

   public boolean canBeCollidedWith() {
      return true;
   }

   public boolean interactFirst(EntityPlayer par1EntityPlayer) {
      if (!super.worldObj.isRemote && !super.isDead) {
         this.displayGUICDChest(par1EntityPlayer, this);
         return true;
      } else {
         return false;
      }
   }

   public void displayGUICDChest(EntityPlayer par1EntityPlayer, IInventory par1IInventory) {
      if (par1EntityPlayer instanceof EntityPlayerMP) {
         EntityPlayerMP mp = (EntityPlayerMP)par1EntityPlayer;
         if (mp.openContainer != mp.inventoryContainer) {
            mp.closeScreen();
         }

         mp.incrementWindowID();
         mp.playerNetServerHandler.sendPacketToPlayer(new Packet100OpenWindow(mp.currentWindowId, 0, par1IInventory.getInvName(), par1IInventory.getSizeInventory(), par1IInventory.isInvNameLocalized()));
         mp.openContainer = new ContainerCDChest(mp.inventory, par1IInventory);
         mp.openContainer.windowId = mp.currentWindowId;
         mp.openContainer.addCraftingToCrafters(mp);
      }

   }

   protected void readEntityFromNBT(NBTTagCompound nbttagcompound) {
      this.corpsePlayerName = nbttagcompound.getString("texture");
      this.setUsernameKilled(this.corpsePlayerName);
      this.ageTick = nbttagcompound.getInteger("age");
      NBTTagList nbttaglist = nbttagcompound.getTagList("Items");
      this.mainItemsStored = new ItemStack[this.getSizeInventory()];

      for(int i = 0; i < nbttaglist.tagCount(); ++i) {
         NBTTagCompound nbttagcompound1 = (NBTTagCompound)nbttaglist.tagAt(i);
         int j = nbttagcompound1.getByte("Slot") & 255;
         if (j >= 0 && j < this.mainItemsStored.length) {
            this.mainItemsStored[j] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
         }
      }

   }

   protected void writeEntityToNBT(NBTTagCompound nbttagcompound) {
      nbttagcompound.setString("texture", this.corpsePlayerName);
      nbttagcompound.setInteger("age", this.ageTick);
      NBTTagList nbttaglist = new NBTTagList();

      for(int i = 0; i < this.mainItemsStored.length; ++i) {
         if (this.mainItemsStored[i] != null) {
            NBTTagCompound nbttagcompound1 = new NBTTagCompound();
            nbttagcompound1.setByte("Slot", (byte)i);
            this.mainItemsStored[i].writeToNBT(nbttagcompound1);
            nbttaglist.appendTag(nbttagcompound1);
         }
      }

      nbttagcompound.setTag("Items", nbttaglist);
   }

   public void setUsernameKilled(String par1) {
      super.dataWatcher.updateObject(20, par1);
   }

   public void setLifeStage(int par1) {
      super.dataWatcher.updateObject(21, par1);
   }

   public String getUsernameKilled() {
      return super.dataWatcher.getWatchableObjectString(20);
   }

   public int getLifeStage() {
      return super.dataWatcher.getWatchableObjectInt(21);
   }

   public int getSizeInventory() {
      return this.mainItemsStored.length;
   }

   public ItemStack getStackInSlot(int i) {
      return this.mainItemsStored[i];
   }

   public ItemStack decrStackSize(int i, int j) {
      if (this.mainItemsStored[i] != null) {
         ItemStack itemstack;
         if (this.mainItemsStored[i].stackSize <= j) {
            itemstack = this.mainItemsStored[i];
            this.mainItemsStored[i] = null;
            return itemstack;
         } else {
            itemstack = this.mainItemsStored[i].splitStack(j);
            if (this.mainItemsStored[i].stackSize == 0) {
               this.mainItemsStored[i] = null;
            }

            return itemstack;
         }
      } else {
         return null;
      }
   }

   public ItemStack getStackInSlotOnClosing(int i) {
      if (this.mainItemsStored[i] != null) {
         ItemStack itemstack = this.mainItemsStored[i];
         this.mainItemsStored[i] = null;
         return itemstack;
      } else {
         return null;
      }
   }

   public void setInventoryContents(ArrayList list) {
      for(int i = 0; i < list.size(); ++i) {
         if (this.mainItemsStored[i] == null && list.get(i) != null && !(((ItemStack)list.get(i)).getItem() instanceof ItemClothingArmor)) {
            this.setInventorySlotContents(i, (ItemStack)list.get(i));
         }
      }

      this.checkForUnwantedItems();
   }

   public void setInventoryContentsFromEntities(ArrayList list) {
      for(int i = 0; i < list.size(); ++i) {
         if (this.mainItemsStored[i] == null && list.get(i) != null && !(((EntityItem)list.get(i)).getEntityItem().getItem() instanceof ItemClothingArmor)) {
            this.setInventorySlotContents(i, ((EntityItem)list.get(i)).getEntityItem());
         }
      }

      this.checkForUnwantedItems();
   }

   private void checkForUnwantedItems() {
      for(int i = 0; i < this.mainItemsStored.length; ++i) {
         if (this.mainItemsStored[i] != null && this.mainItemsStored[i].getItem() instanceof ItemClothingArmor) {
            this.decrStackSize(i, 1);
         }
      }

   }

   public void setInventorySlotContents(int i, ItemStack itemstack) {
      this.mainItemsStored[i] = itemstack;
      if (itemstack != null && itemstack.stackSize > this.getInventoryStackLimit()) {
         itemstack.stackSize = this.getInventoryStackLimit();
      }

   }

   public String getInvName() {
      return this.getUsernameKilled() + "'s Corpse";
   }

   public boolean isInvNameLocalized() {
      return false;
   }

   public int getInventoryStackLimit() {
      return 64;
   }

   public void onInventoryChanged() {
   }

   public boolean isUseableByPlayer(EntityPlayer entityplayer) {
      return super.isDead ? false : entityplayer.getDistanceSqToEntity(this) <= 64.0D;
   }

   public void openChest() {
   }

   public void closeChest() {
   }

   public boolean isItemValidForSlot(int i, ItemStack itemstack) {
      return false;
   }

   public static void spawnEntityCorpseWithPlayer(EntityPlayer player) {
      World world = MinecraftServer.getServer().getEntityWorld();
      PlayerData data = CDAftermath.instance.playerDataHandler().getPlayerData(player);
      InventoryPlayer inv = player.inventory;
      InventoryCDA invcda = data.getCDInventory();
      ArrayList stacks = new ArrayList();

      int i;
      ItemStack stack;
      for(i = 0; i < inv.getSizeInventory(); ++i) {
         stack = inv.getStackInSlot(i);
         if (stack != null && !(stack.getItem() instanceof ItemClothingArmor)) {
            stacks.add(stack.copy());
         }
      }

      for(i = 0; i < invcda.getSizeInventory(); ++i) {
         stack = invcda.getStackInSlot(i);
         if (stack != null && !(stack.getItem() instanceof ItemClothingArmor)) {
            stacks.add(stack.copy());
         }
      }

      EntityCorpse corpse = new EntityCorpse(player);
      corpse.setInventoryContents(stacks);
      world.spawnEntityInWorld(corpse);
   }
}
