package by.fxg.craftingdead.entity;

import java.util.Random;

import by.fxg.craftingdead.item.ItemManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class EntitySupplyDrop extends Entity implements IInventory {
   public int ageTickMax = 12000;
   public int ageTick = 0;
   public ItemStack[] dropContent = new ItemStack[54];

   public EntitySupplyDrop(World par1World) {
      super(par1World);
      this.setSize(2.0F, 1.2F);
   }

   protected void entityInit() {
   }

   public void onEntityUpdate() {
      super.onEntityUpdate();
      if (this.ageTick++ > this.ageTickMax) {
         this.setDead();
      }

      if (!super.onGround) {
         super.motionY -= 0.003D;
      }

      this.moveEntity(super.motionX, super.motionY, super.motionZ);
   }

   public boolean interactFirst(EntityPlayer par1EntityPlayer) {
      if (!super.worldObj.isRemote && !super.isDead) {
         par1EntityPlayer.displayGUIChest(this);
         return true;
      } else {
         return false;
      }
   }

   protected void readEntityFromNBT(NBTTagCompound nbttagcompound) {
      this.ageTick = nbttagcompound.getInteger("age");
      NBTTagList nbttaglist = nbttagcompound.getTagList("Items");
      this.dropContent = new ItemStack[this.getSizeInventory()];

      for(int i = 0; i < nbttaglist.tagCount(); ++i) {
         NBTTagCompound nbttagcompound1 = (NBTTagCompound)nbttaglist.tagAt(i);
         int j = nbttagcompound1.getByte("Slot") & 255;
         if (j >= 0 && j < this.dropContent.length) {
            this.dropContent[j] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
         }
      }

   }

   protected void writeEntityToNBT(NBTTagCompound nbttagcompound) {
      nbttagcompound.setInteger("age", this.ageTick);
      NBTTagList nbttaglist = new NBTTagList();

      for(int i = 0; i < this.dropContent.length; ++i) {
         if (this.dropContent[i] != null) {
            NBTTagCompound nbttagcompound1 = new NBTTagCompound();
            nbttagcompound1.setByte("Slot", (byte)i);
            this.dropContent[i].writeToNBT(nbttagcompound1);
            nbttaglist.appendTag(nbttagcompound1);
         }
      }

      nbttagcompound.setTag("Items", nbttaglist);
   }

   public AxisAlignedBB getCollisionBox(Entity par1Entity) {
      return par1Entity.boundingBox;
   }

   public AxisAlignedBB getBoundingBox() {
      return super.boundingBox;
   }

   public boolean canBePushed() {
      return false;
   }

   public boolean canBeCollidedWith() {
      return true;
   }

   public int getSizeInventory() {
      return 54;
   }

   public ItemStack getStackInSlot(int par1) {
      return this.dropContent[par1];
   }

   public ItemStack decrStackSize(int par1, int par2) {
      if (this.dropContent[par1] != null) {
         ItemStack itemstack;
         if (this.dropContent[par1].stackSize <= par2) {
            itemstack = this.dropContent[par1];
            this.dropContent[par1] = null;
            this.onInventoryChanged();
            return itemstack;
         } else {
            itemstack = this.dropContent[par1].splitStack(par2);
            if (this.dropContent[par1].stackSize == 0) {
               this.dropContent[par1] = null;
            }

            this.onInventoryChanged();
            return itemstack;
         }
      } else {
         return null;
      }
   }

   public ItemStack getStackInSlotOnClosing(int par1) {
      if (this.dropContent[par1] != null) {
         ItemStack itemstack = this.dropContent[par1];
         this.dropContent[par1] = null;
         return itemstack;
      } else {
         return null;
      }
   }

   public void setInventorySlotContents(int par1, ItemStack par2ItemStack) {
      this.dropContent[par1] = par2ItemStack;
      if (par2ItemStack != null && par2ItemStack.stackSize > this.getInventoryStackLimit()) {
         par2ItemStack.stackSize = this.getInventoryStackLimit();
      }

      this.onInventoryChanged();
   }

   public String getInvName() {
      return "Supply Drop";
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

   public void addContent(int par1, String par2) {
      for(int i = 0; i < par1; ++i) {
         this.addContentType(par2);
      }

   }

   private void addContentType(String par1) {
      if (par1.equals("medical")) {
         this.addContentMedical();
      } else if (par1.equals("military")) {
         this.addContentMilitary();
      } else {
         this.addContentMilitary();
      }
   }

   private void addContentMedical() {
      this.addRandomItemWithChance(ItemManager.mre, 70, 9);
      this.addRandomItemWithChance(ItemManager.watercanteen, 70, 9);
      this.addRandomItemWithChance(ItemManager.bandage, 50, 4);
      this.addRandomItemWithChance(ItemManager.ragClean, 50, 4);
      this.addRandomItemWithChance(ItemManager.waterbottle, 40, 8);
      this.addRandomItemWithChance(ItemManager.medpack, 70, 12);
      this.addRandomItemWithChance(ItemManager.needleMorphine, 50, 4);
      this.addRandomItemWithChance(ItemManager.needleAdrenaline, 50, 4);
      this.addRandomItemWithChance(ItemManager.needleCure, 50, 8);
      this.addRandomItemWithChance(ItemManager.needleRBI, 50, 3);
      this.addRandomItemWithChance(ItemManager.splint, 50, 4);
      this.addRandomItemWithChance(ItemManager.m9Ammo, 40, 2);
      this.addRandomItemWithChance(ItemManager.m1911Ammo, 40, 2);
      this.addRandomItemWithChance(ItemManager.g18Ammo, 40, 2);
      this.addRandomItemWithChance(ItemManager.grenadePipeBomb, 50, 2);
      this.addRandomItemWithChance(ItemManager.grenadeSmoke, 50, 1);
      this.addRandomItemWithChance(ItemManager.grenadeFlash, 50, 1);
      this.addRandomItemWithChance(ItemManager.clothingDoctor, 40, 2);
      this.addRandomItemWithChance(ItemManager.clothingCasual, 30, 2);
      this.addRandomItemWithChance(ItemManager.m1911, 20, 2);
      this.addRandomItemWithChance(ItemManager.g18, 15, 2);
      this.addRandomItemWithChance(ItemManager.m9, 10, 1);
   }

   private void addContentMilitary() {
      this.addRandomItemWithChance(ItemManager.mre, 70, 11);
      this.addRandomItemWithChance(ItemManager.watercanteen, 60, 6);
      this.addRandomItemWithChance(ItemManager.bandage, 60, 10);
      this.addRandomItemWithChance(ItemManager.handcuffs, 15, 2);
      this.addRandomItemWithChance(ItemManager.boltCutters, 10, 2);
      this.addRandomItemWithChance(ItemManager.c4, 6, 8);
      this.addRandomItemWithChance(ItemManager.rawExplosive, 15, 2);
      this.addRandomItemWithChance(ItemManager.flameThrower, 4, 1);
      this.addRandomItemWithChance(ItemManager.fuelTank, 10, 4);
      this.addRandomItemWithChance(ItemManager.fuelTankBackpack, 2, 1);
      this.addRandomItemWithChance(ItemManager.detonator, 1, 1);
      this.addRandomItemWithChance(ItemManager.stanag30Rnd, 12, 4);
      this.addRandomItemWithChance(ItemManager.akm10rnd, 10, 4);
      this.addRandomItemWithChance(ItemManager.m107Ammo, 4, 4);
      this.addRandomItemWithChance(ItemManager.m107AmmoAP, 2, 2);
      this.addRandomItemWithChance(ItemManager.m9Ammo, 25, 5);
      this.addRandomItemWithChance(ItemManager.g18Ammo, 25, 5);
      this.addRandomItemWithChance(ItemManager.m240bAmmo, 5, 2);
      this.addRandomItemWithChance(ItemManager.grenadeFrag, 35, 3);
      this.addRandomItemWithChance(ItemManager.grenadeFire, 25, 3);
      this.addRandomItemWithChance(ItemManager.grenadeFlash, 30, 2);
      this.addRandomItemWithChance(ItemManager.attachmentACOG, 12, 4);
      this.addRandomItemWithChance(ItemManager.attachmentSupressor, 15, 3);
      this.addRandomItemWithChance(ItemManager.attachmentScope12x, 2, 3);
      this.addRandomItemWithChance(ItemManager.clothingGhillie, 20, 3);
      this.addRandomItemWithChance(ItemManager.clothingGhillieFull, 10, 4);
      this.addRandomItemWithChance(ItemManager.clothingSpaceman, 25, 2);
      this.addRandomItemWithChance(ItemManager.clothingJuggernaut, 2, 2);
      this.addRandomItemWithChance(ItemManager.clothingSpetsnaz, 7, 2);
      this.addRandomItemWithChance(ItemManager.akm, 11, 3);
      this.addRandomItemWithChance(ItemManager.m4a1, 10, 3);
      this.addRandomItemWithChance(ItemManager.m107, 1, 3);
      this.addRandomItemWithChance(ItemManager.m1911, 17, 7);
      this.addRandomItemWithChance(ItemManager.g18, 20, 5);
      this.addRandomItemWithChance(ItemManager.m9, 15, 5);
      this.addRandomItemWithChance(ItemManager.as50, 1, 1);
      this.addRandomItemWithChance(ItemManager.m240b, 1, 1);
   }

   public void addRandomItemWithChance(Item par1, int par2Chance, int par3Amount) {
      this.addRandomItemWithChance(par1.itemID, par2Chance, par3Amount);
   }

   public void addRandomItemWithChance(int par1ID, int par2Chance, int par3Amount) {
      Random rand = new Random();

      for(int i = 0; i < par3Amount; ++i) {
         if (rand.nextInt(100) <= par2Chance) {
            int slot = rand.nextInt(54);
            if (this.getStackInSlot(slot) == null || rand.nextBoolean()) {
            	boolean flag = rand.nextBoolean();
            	if (flag) {
            		ItemStack stack = new ItemStack(par1ID, 1, 0);
                    this.setInventorySlotContents(slot, stack.copy());
            	}
            }
         }
      }

   }
}
