package com.ferullogaming.craftingdead.player;

import java.util.HashMap;
import java.util.Map;

import com.ferullogaming.craftingdead.CDAftermath;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;

public class PlayerDataHandler {
	public static HashMap playerDataMapping = new HashMap<String, PlayerData>();;
	public PlayerData getClientPlayerData() {
		Minecraft mc = Minecraft.getMinecraft();
		return this.getPlayerData(mc.getSession().getUsername());
	}

	public PlayerData getPlayerData(EntityPlayer player) {
		return player == null ? null : this.getPlayerData(player.username);
	}

	public PlayerData getPlayerData(String username) {
		if (!this.playerDataMapping.containsKey(username)) {
			PlayerData playerdata = new PlayerData(username);
			this.playerDataMapping.put(username, playerdata);
			return playerdata;
		}
		return (PlayerData)this.playerDataMapping.get(username);
	}

	public void removePlayerData(EntityPlayer player) {
		if (player != null) {
			this.removePlayerData(player.username);
		}
	}

	public void removePlayerData(String username) {
		if (this.playerDataMapping.containsKey(username)) {
			this.playerDataMapping.remove(username);
		}
	}
}
