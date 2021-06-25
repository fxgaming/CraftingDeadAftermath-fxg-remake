package com.ferullogaming.craftingdead.network;

import java.util.HashMap;
import java.util.Map;

import com.ferullogaming.craftingdead.CDAftermath;

public class NetworkManager {
	public static final String packetChannel = "cdaNetworking";
	public static Map packetMapping = new HashMap();
	public static Map packetMappingToID = new HashMap();
	public static int nextID = 0;

	public void init() {
		this.registerPacket(nextID(), new CDAPacketGunTrigger());
		this.registerPacket(nextID(), new CDAPacketGunReload());
		this.registerPacket(nextID(), new CDAPacketBulletCollision());
		this.registerPacket(nextID(), new CDAPacketBulletCollisionClient());
		//this.registerPacket(nextID(), new CDAPacketPlayerData());
		this.registerPacket(nextID(), new CDAPacketPlayerDataToServer());
		this.registerPacket(nextID(), new CDAPacketOpenGUI());
		this.registerPacket(nextID(), new CDAPacketGrenadeFlash());
		this.registerPacket(nextID(), new CDAPacketGrenadeThrowing());
		this.registerPacket(nextID(), new CDAPacketGrenadeExplosion());
		this.registerPacket(nextID(), new CDAPacketSwitchItem());
		this.registerPacket(nextID(), new CDAPacketPlayerDataToPlayer());
		this.registerPacket(nextID(), new CDAPacketACLPaused());
		this.registerPacket(nextID(), new CDAPacketACLUnpaused());
		this.registerPacket(nextID(), new CDAPacketACLInCombat());
		this.registerPacket(nextID(), new CDAPacketFTTrigger());
		this.registerPacket(nextID(), new CDAPacketFTClient());
		this.registerPacket(nextID(), new CDAPacketFTTriggerStop());
		this.registerPacket(nextID(), new CDAPacketHandcuffInteract());
		this.registerPacket(nextID(), new CDAPacketChalk());
		this.registerPacket(nextID(), new CDAPacketSound());
	}

	public void registerPacket(int par1, CDAPacket par1CCPacket) {
		packetMapping.put(par1, par1CCPacket);
		packetMappingToID.put(par1CCPacket.getClass(), par1);
	}

	public static int getIDFromPacket(Class par1) {
		return packetMappingToID.containsKey(par1) ? (Integer) packetMappingToID.get(par1) : 0;
	}

	public CDAPacket getPacketFromID(int par1) {
		return packetMapping.containsKey(par1) ? (CDAPacket) packetMapping.get(par1) : null;
	}

	public static NetworkManager instance() {
		return CDAftermath.instance.getNetworkManager();
	}

	private static int nextID() {
		nextID = nextID + 1;
		return nextID;
	}
}
