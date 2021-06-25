package com.fxg.decoration.network;

import com.ferullogaming.craftingdead.CDAftermath;
import com.fxg.decoration.CDDecoration;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;
import cpw.mods.fml.relauncher.Side;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;

public class PacketHandler implements IPacketHandler {
	public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player player) {
		String name = ((EntityPlayer) player).username;
		EntityPlayer playerEntity = FMLCommonHandler.instance().getSidedDelegate().getServer().getConfigurationManager().getPlayerForUsername(name);
		this.onRecieve(packet, playerEntity, manager);
	}

	public static final void onRecieve(Packet250CustomPayload packet, EntityPlayer player, INetworkManager manager) {
		if (packet.channel.equals("cddNetworking")) {
			NetworkManager netManager = CDDecoration.networkManager;
			try {
				DataInputStream stream = new DataInputStream(new ByteArrayInputStream(packet.data));
				int incomingPacketID = stream.read();
				if (incomingPacketID == 0) {
					CDAftermath.log("Incoming Pakcet processed by SERVER with 0 ID!");
					stream.close();
					return;
				}
				if (netManager.getPacketFromID(incomingPacketID) != null) {
					CDDPacket ccpacket = (CDDPacket) netManager.getPacketFromID(incomingPacketID);
					ccpacket.execute(stream, player, new Object[0], Side.SERVER);
				}
				stream.close();
			} catch (Exception var7) {
				var7.printStackTrace();
			}
		}
	}
}
