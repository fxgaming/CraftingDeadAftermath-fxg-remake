package com.fxg.decoration.network;

import java.util.HashMap;
import java.util.Map;

import com.fxg.decoration.CDDecoration;

public class NetworkManager {
	public static final String packetChannel = "cddNetworking";
	public static Map packetMapping = new HashMap();
	public static Map packetMappingToID = new HashMap();

	public void init() {
		this.registerPacket(1, new CDDPacketData());
	}

	public void registerPacket(int par1, CDDPacket par1CCPacket) {
		packetMapping.put(par1, par1CCPacket);
		packetMappingToID.put(par1CCPacket.getClass(), par1);
	}

	public static int getIDFromPacket(Class par1) {
		return packetMappingToID.containsKey(par1) ? (Integer) packetMappingToID.get(par1) : 0;
	}

	public CDDPacket getPacketFromID(int par1) {
		return packetMapping.containsKey(par1) ? (CDDPacket) packetMapping.get(par1) : null;
	}

	public static NetworkManager instance() {
		return CDDecoration.networkManager;
	}
}
