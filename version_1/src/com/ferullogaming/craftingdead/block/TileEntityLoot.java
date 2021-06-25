package com.ferullogaming.craftingdead.block;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import java.util.Random;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet132TileEntityData;
import net.minecraft.tileentity.TileEntity;

public class TileEntityLoot extends TileEntity {
   private ItemStack lootStack;
   private LootType lootType;
   public boolean isInventory = false;
   public int randomRotaion = 0;
   private int removalTick = 0;
   private int removalTickSeconds = 600;
   private int removalDisatnceFromPlayer = 500;

   public TileEntityLoot() {
      Random rand = new Random();
      this.randomRotaion = 90 * rand.nextInt(4);
   }

   public TileEntityLoot(LootType par1) {
      this.lootType = par1;
      Random rand = new Random();
      this.randomRotaion = 90 * rand.nextInt(4);
   }

   public void updateEntity() {
      if (super.worldObj.getClosestPlayer((double)super.xCoord, (double)super.yCoord, (double)super.zCoord, (double)this.removalDisatnceFromPlayer) == null && this.removalTick++ >= 20 * this.removalTickSeconds) {
         if (!super.worldObj.isRemote) {
            super.worldObj.destroyBlock(super.xCoord, super.yCoord, super.zCoord, false);
            if (super.worldObj.getBlockTileEntity(super.xCoord, super.yCoord, super.zCoord) != null) {
               super.worldObj.removeBlockTileEntity(super.xCoord, super.yCoord, super.zCoord);
            }
         }

         this.removalTick = 0;
      }

   }

   public ItemStack getItemStack() {
      return this.lootStack;
   }

   public String getTextureName() {
      return this.lootType.getID();
   }

   public Packet getDescriptionPacket() {
      if (super.worldObj != null && !super.worldObj.isRemote && this.lootStack == null && this.lootType != null) {
         this.lootStack = this.lootType.getRandomItemStack();
      }

      NBTTagCompound nbttagcompound = new NBTTagCompound();
      this.writeToNBT(nbttagcompound);
      return new Packet132TileEntityData(super.xCoord, super.yCoord, super.zCoord, 1, nbttagcompound);
   }

   public void onDataPacket(INetworkManager net, Packet132TileEntityData packet) {
      if (FMLCommonHandler.instance().getSide() == Side.CLIENT) {
         this.lootStack = ItemStack.loadItemStackFromNBT(packet.data.getCompoundTag("loot"));
      }

   }

   public boolean receiveClientEvent(int par1, int par2) {
      return true;
   }

   public void readFromNBT(NBTTagCompound par1NBTTagCompound) {
      super.readFromNBT(par1NBTTagCompound);
      if (par1NBTTagCompound.hasKey("loot")) {
         this.lootStack = ItemStack.loadItemStackFromNBT(par1NBTTagCompound.getCompoundTag("loot"));
      }

   }

   public void writeToNBT(NBTTagCompound par1NBTTagCompound) {
      super.writeToNBT(par1NBTTagCompound);
      if (this.lootStack != null) {
         NBTTagCompound tag = new NBTTagCompound();
         this.lootStack.writeToNBT(tag);
         par1NBTTagCompound.setCompoundTag("loot", tag);
      }

   }
}
