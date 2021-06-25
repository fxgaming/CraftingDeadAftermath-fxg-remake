package by.fxg.craftingdead.block;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet132TileEntityData;
import net.minecraft.tileentity.TileEntity;

public class TileEntityLootSpawner extends TileEntity {
   public int blockID = 0;
   public int blockMETA = 0;

   public TileEntityLootSpawner() {
   }

   public Packet getDescriptionPacket() {
      this.getLocalBlocks();
      NBTTagCompound nbttagcompound = new NBTTagCompound();
      this.writeToNBT(nbttagcompound);
      return new Packet132TileEntityData(super.xCoord, super.yCoord, super.zCoord, 1, nbttagcompound);
   }

   public void getLocalBlocks() {
      if (super.worldObj != null) {
         int checkSize = 1;
         boolean flag = false;
         int x = super.xCoord;
         int y = super.yCoord;
         int z = super.zCoord;
         int currentID = super.worldObj.getBlockId(x, y, z);

         for(int ix = -checkSize; ix <= checkSize; ++ix) {
            for(int iz = -checkSize; iz <= checkSize; ++iz) {
               int var1 = super.worldObj.getBlockId(x + ix, y, z + iz);
               if (var1 != 0) {
                  Block block = Block.blocksList[var1];
                  if (block != null && !(block instanceof BlockLootSpawner) && !(block instanceof BlockLoot) && var1 != 0 && !flag) {
                     int var2 = super.worldObj.getBlockMetadata(x + ix, y, z + iz);
                     this.blockID = var1;
                     this.blockMETA = var2;
                     flag = true;
                  }
               }
            }
         }

         if (!flag) {
            this.blockID = currentID;
            this.blockMETA = 0;
         }
      }

   }

   public void onDataPacket(INetworkManager net, Packet132TileEntityData packet) {
      if (FMLCommonHandler.instance().getSide() == Side.CLIENT) {
         this.blockID = packet.data.getInteger("blockid");
         this.blockMETA = packet.data.getInteger("blockmeta");
      }

   }

   public boolean receiveClientEvent(int par1, int par2) {
      return true;
   }

   public void readFromNBT(NBTTagCompound par1NBTTagCompound) {
      super.readFromNBT(par1NBTTagCompound);
      if (par1NBTTagCompound.hasKey("blockid")) {
         this.blockID = par1NBTTagCompound.getInteger("blockid");
      }

      if (par1NBTTagCompound.hasKey("blockmeta")) {
         this.blockMETA = par1NBTTagCompound.getInteger("blockmeta");
      }

   }

   public void writeToNBT(NBTTagCompound par1NBTTagCompound) {
      super.writeToNBT(par1NBTTagCompound);
      par1NBTTagCompound.setInteger("blockid", this.blockID);
      par1NBTTagCompound.setInteger("blockmeta", this.blockMETA);
   }
}
