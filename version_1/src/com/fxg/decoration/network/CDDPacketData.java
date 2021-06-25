package com.fxg.decoration.network;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import com.fxg.decoration.tile.TileBaseProp;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.world.World;

public class CDDPacketData extends CDDPacket {
	public static Packet buildPacket(int posX, int posY, int posZ, float rx, float ry, float rz, int fn, String sk, float sx, float sy, float sz, float tx, float ty, float tz, float bbxn, float bbyn, float bbzn, float bbxx, float bbyx, float bbzx) {
		Packet250CustomPayload packet = new Packet250CustomPayload();
		packet.channel = "cddNetworking";
		ByteArrayOutputStream bytes = new ByteArrayOutputStream();
		DataOutputStream data = new DataOutputStream(bytes);
		try {
			data.write(NetworkManager.getIDFromPacket(CDDPacketData.class));
			data.writeInt(posX);
			data.writeInt(posY);
			data.writeInt(posZ);
			data.writeFloat(rx);
			data.writeFloat(ry);
			data.writeFloat(rz);
			data.writeInt(fn);
			data.writeUTF(sk);
			data.writeFloat(sx);
			data.writeFloat(sy);
			data.writeFloat(sz);
			data.writeFloat(tx);
			data.writeFloat(ty);
			data.writeFloat(tz);
			data.writeFloat(bbxn);
			data.writeFloat(bbyn);
			data.writeFloat(bbzn);
			data.writeFloat(bbxx);
			data.writeFloat(bbyx);
			data.writeFloat(bbzx);
			packet.data = bytes.toByteArray();
			packet.length = packet.data.length;
			data.close();
			bytes.close();
		} catch (Exception var4) {
			var4.printStackTrace();
		}
		return packet;
	}

	public void execute(DataInputStream stream, EntityPlayer player, Object[] extradata, Side side) {
		try {
			if (player instanceof EntityPlayerMP) {
				World world = player.worldObj;
				int posX = stream.readInt();
				int posY = stream.readInt();
				int posZ = stream.readInt();
				float rx = stream.readFloat();
				float ry = stream.readFloat();
				float rz = stream.readFloat();
				int fn = stream.readInt();
				String sk = stream.readUTF();
				float sx = stream.readFloat();
				float sy = stream.readFloat();
				float sz = stream.readFloat();
				float tx = stream.readFloat();
				float ty = stream.readFloat();
				float tz = stream.readFloat();
				float xn = stream.readFloat();
				float yn = stream.readFloat();
				float zn = stream.readFloat();
				float xx = stream.readFloat();
				float yx = stream.readFloat();
				float zx = stream.readFloat();
				TileBaseProp tile = (TileBaseProp) world.getBlockTileEntity(posX, posY, posZ);
				tile.setRotation(rx, ry, rz);
				tile.setScalation(sx, sy, sz);
				tile.setTranslation(tx, ty, tz);
				tile.setFacing(fn);
				tile.setSkin(sk);
				tile.setBB(xn, yn, zn, xx, yx, zx);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
