package com.ferullogaming.craftingdead.block;

import cpw.mods.fml.common.network.PacketDispatcher;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet132TileEntityData;
import net.minecraft.tileentity.TileEntity;

public class TileEntityBaseCenter extends TileEntity {
   private String flagOwner;

   public void setFlagOwner(String par1) {
      this.flagOwner = par1;
   }

   public String getFlagOwner() {
      return this.flagOwner;
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
      if (super.worldObj.isRemote && packet.data.hasKey("owner")) {
         this.flagOwner = packet.data.getString("owner");
      }

   }

   public boolean receiveClientEvent(int par1, int par2) {
      return true;
   }

   public void readFromNBT(NBTTagCompound par1NBTTagCompound) {
      super.readFromNBT(par1NBTTagCompound);
      if (par1NBTTagCompound.hasKey("owner")) {
         this.flagOwner = par1NBTTagCompound.getString("owner");
      }

   }

   public void writeToNBT(NBTTagCompound par1NBTTagCompound) {
      super.writeToNBT(par1NBTTagCompound);
      if (!super.worldObj.isRemote && this.flagOwner != null) {
         par1NBTTagCompound.setString("owner", this.flagOwner);
      }

   }
}
