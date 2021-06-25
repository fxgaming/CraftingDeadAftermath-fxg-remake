package com.ferullogaming.craftingdead;

import com.ferullogaming.craftingdead.entity.EntityCorpse;
import com.ferullogaming.craftingdead.player.PlayerData;
import com.ferullogaming.craftingdead.player.PlayerDataHandler;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.IPlayerTracker;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;

public class CommonPlayerTracker implements IPlayerTracker {
	public CommonPlayerTracker() {
		GameRegistry.registerPlayerTracker(this);
	}

	public void onPlayerLogin(EntityPlayer player) {
		NBTTagCompound nbt = player.getEntityData().getCompoundTag("cda");
		PlayerData data = CDAftermath.instance.playerDataHandler().getPlayerData(player);
		data.onPlayerDeath();
		data.readFromNBT(nbt);
		data.killPlayerForCombatLogging = false;
		if (nbt.hasKey("isdead") && nbt.getBoolean("isdead") && !player.capabilities.isCreativeMode) {
			data.killPlayerForCombatLogging = true;
		}
	}

	public void onPlayerLogout(EntityPlayer player) {
		NBTTagCompound nbt = new NBTTagCompound();
		PlayerData data = CDAftermath.instance.playerDataHandler().getPlayerData(player);
		nbt.setBoolean("isdead", false);
		if (FMLCommonHandler.instance().getSide() == Side.SERVER && data.antiCombatLoggingWaitTick != -1 && data.antiCombatLoggingWaitTick > 10 && !player.capabilities.isCreativeMode) {
			nbt.setBoolean("isdead", true);
			EntityCorpse.spawnEntityCorpseWithPlayer(player);
		}
		player.getEntityData().setCompoundTag("cda", nbt);
		data.writeToNBT(nbt);
	}

	public void onPlayerChangedDimension(EntityPlayer player) {
	}

	public void onPlayerRespawn(EntityPlayer player) {
	}
}
