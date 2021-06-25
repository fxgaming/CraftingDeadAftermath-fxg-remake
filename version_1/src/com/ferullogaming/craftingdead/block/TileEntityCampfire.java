package com.ferullogaming.craftingdead.block;

import cpw.mods.fml.common.network.PacketDispatcher;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet132TileEntityData;
import net.minecraft.tileentity.TileEntity;

public class TileEntityCampfire extends TileEntity {
   public void updateEntity() {
      if (super.worldObj.isRemote) {
         for(int i = 0; i < 1; ++i) {
            super.worldObj.spawnParticle("flame", (double)super.xCoord, (double)super.yCoord + 0.5D, (double)super.yCoord, 0.0D, 0.0D, 0.0D);
         }
      }

   }

   public void sendInformation() {
      NBTTagCompound nbttagcompound = new NBTTagCompound();
      this.writeToNBT(nbttagcompound);
      PacketDispatcher.sendPacketToAllPlayers(new Packet132TileEntityData(super.xCoord, super.yCoord, super.zCoord, 1, nbttagcompound));
   }

   public Packet getDescriptionPacket() {
      NBTTagCompound nbttagcompound = new NBTTagCompound();
      this.writeToNBT(nbttagcompound);
      return new Packet132TileEntityData(super.xCoord, super.yCoord, super.zCoord, 1, nbttagcompound);
   }

   public void onDataPacket(INetworkManager net, Packet132TileEntityData packet) {
      if (super.worldObj.isRemote) {
         ;
      }

   }

   public boolean receiveClientEvent(int par1, int par2) {
      return true;
   }

   public void readFromNBT(NBTTagCompound par1NBTTagCompound) {
      super.readFromNBT(par1NBTTagCompound);
   }

   public void writeToNBT(NBTTagCompound par1NBTTagCompound) {
      super.writeToNBT(par1NBTTagCompound);
   }
}
