package com.fxg.decoration.tile;

import cpw.mods.fml.common.network.PacketDispatcher;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet132TileEntityData;

public class TileBaseProp extends TileInventoried {
	public String texture = "";
	public float rotateX = 0.0F;
	public float rotateY = 0.0F;
	public float rotateZ = 0.0F;
	public float scaleX = 1.0F;
	public float scaleY = 1.0F;
	public float scaleZ = 1.0F;
	public float translateX = 0.0F;
	public float translateY = 0.0F;
	public float translateZ = 0.0F;
	public int tick = 0;
	public float bbXmin = 0.0F;
	public float bbYmin = 0.0F;
	public float bbZmin = 0.0F;
	public float bbXmax = 1.0F;
	public float bbYmax = 1.0F;
	public float bbZmax = 1.0F;
	
	public TileBaseProp() {
		super.items = new ItemStack[1];
	}
	
	public void updateEntity() {
		try {
			if (!super.worldObj.isRemote) {
				if (this.tick++ >= 20) {
					this.tick = 0;
					if (this.blockType != null) {
						this.blockType.setBlockBounds(this.bbXmin, this.bbYmin, this.bbZmin, this.bbXmax, this.bbYmax, this.bbZmax);
					} else {
						if (Block.blocksList[this.worldObj.getBlockId(this.xCoord, this.yCoord, this.zCoord)] != null) {
							Block.blocksList[this.worldObj.getBlockId(this.xCoord, this.yCoord, this.zCoord)].setBlockBounds(this.bbXmin, this.bbYmin, this.bbZmin, this.bbXmax, this.bbYmax, this.bbZmax);
						}
					}
					PacketDispatcher.sendPacketToAllAround((double)super.xCoord, (double)super.yCoord, (double)super.zCoord, 50.0D, super.worldObj.provider.dimensionId, this.getDescriptionPacket());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Packet getDescriptionPacket() {
		NBTTagCompound data = new NBTTagCompound();
		this.writeToNBT(data);
		Packet132TileEntityData packet = new Packet132TileEntityData(super.xCoord, super.yCoord, super.zCoord, 0, data);
		return packet;
	}
	
	public void setSkin(String var1) {
		this.texture = var1;
	}
	
	public void resetSkin() {
		this.texture = "";
	}
	
	public void setRotation(float... xyz) {
		this.rotateX = xyz[0];
		this.rotateY = xyz[1];
		this.rotateZ = xyz[2];
	}
	
	public void setScalation(float... xyz) {
		this.scaleX = xyz[0];
		this.scaleY = xyz[1];
		this.scaleZ = xyz[2];
	}
	
	public void setTranslation(float... xyz) {
		this.translateX = xyz[0];
		this.translateY = xyz[1];
		this.translateZ = xyz[2];
	}
	
	public void setBB(float... bb) {
		this.bbXmin = bb[0];
		this.bbYmin = bb[1];
		this.bbZmin = bb[2];
		this.bbXmax = bb[3];
		this.bbYmax = bb[4];
		this.bbZmax = bb[5];
	}
	
	public void readFromNBT(NBTTagCompound n) {
		super.readFromNBT(n);
		this.texture = n.getString("tile_skin");
		this.rotateX = n.getFloat("tile_rotateX");
		this.rotateY = n.getFloat("tile_rotateY");
		this.rotateZ = n.getFloat("tile_rotateZ");
		this.scaleX = n.getFloat("tile_scaleX");
		this.scaleY = n.getFloat("tile_scaleY");
		this.scaleZ = n.getFloat("tile_scaleZ");
		this.translateX = n.getFloat("tile_translateX");
		this.translateY = n.getFloat("tile_translateY");
		this.translateZ = n.getFloat("tile_translateZ");
	}

	public void writeToNBT(NBTTagCompound n) {
		super.writeToNBT(n);
		n.setString("tile_skin", this.texture);
		n.setFloat("tile_rotateX", this.rotateX);
		n.setFloat("tile_rotateY", this.rotateY);
		n.setFloat("tile_rotateZ", this.rotateZ);
		n.setFloat("tile_scaleX", this.scaleX);
		n.setFloat("tile_scaleY", this.scaleY);
		n.setFloat("tile_scaleZ", this.scaleZ);
		n.setFloat("tile_translateX", this.translateX);
		n.setFloat("tile_translateY", this.translateY);
		n.setFloat("tile_translateZ", this.translateZ);
	}
}