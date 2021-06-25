package com.ferullogaming.craftingdead.network;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;

import com.ferullogaming.craftingdead.CDAftermath;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;

public class PacketHandlerClient implements IPacketHandler {
	public static CDAPacket bufferPacket;

	public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player player) {
		String name = ((EntityPlayer) player).username;
		EntityPlayer playerEntity = FMLClientHandler.instance().getClient().thePlayer;
		this.onRecieve(packet, playerEntity, manager);
	}

	public static final void onRecieve(Packet250CustomPayload packet, EntityPlayer player, INetworkManager manager) {
		if (packet.channel.equals("cdaNetworking")) {
			NetworkManager netManager = CDAftermath.instance.getNetworkManager();

			try {
				ByteArrayInputStream bais = new ByteArrayInputStream(packet.data);
				DataInputStream stream = new DataInputStream(bais);
				int incomingPacketID = stream.read();
				if (incomingPacketID == 0) {
					CDAftermath.log("Incoming Pakcet processed by client with 0 ID!");
					stream.close();
					return;
				}
				if (netManager.getPacketFromID(incomingPacketID) != null) {
					bufferPacket = (CDAPacket) netManager.getPacketFromID(incomingPacketID);
					bufferPacket.execute(stream, player, null, Side.CLIENT);
				}

				stream.close();
				bais.close();
			} catch (Exception var7) {
				var7.printStackTrace();
			}
		}

	}
}
