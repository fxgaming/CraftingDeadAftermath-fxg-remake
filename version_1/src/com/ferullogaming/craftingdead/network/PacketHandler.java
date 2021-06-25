package com.ferullogaming.craftingdead.network;

import com.ferullogaming.craftingdead.CDAftermath;
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
	public static CDAPacket bufferPacket;

	public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player player) {
		String name = ((EntityPlayer) player).username;
		EntityPlayer playerEntity = FMLCommonHandler.instance().getSidedDelegate().getServer().getConfigurationManager().getPlayerForUsername(name);
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
					CDAftermath.log("Incoming Pakcet processed by SERVER with 0 ID!");
					stream.close();
					return;
				}

				if (netManager.getPacketFromID(incomingPacketID) != null) {
					bufferPacket = (CDAPacket)netManager.getPacketFromID(incomingPacketID);
					bufferPacket.execute(stream, player, null, Side.SERVER);
				}

				stream.close();
				bais.close();
			} catch (Exception var7) {
				var7.printStackTrace();
			}
		}

	}
}
