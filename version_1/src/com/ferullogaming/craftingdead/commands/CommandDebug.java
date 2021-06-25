package com.ferullogaming.craftingdead.commands;

import java.util.HashMap;

import com.ferullogaming.craftingdead.CDAftermath;
import com.ferullogaming.craftingdead.player.PlayerData;

import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;

public class CommandDebug extends CommandBase {
	public String getCommandName() {
		return "debug";
	}

	public String getCommandUsage(ICommandSender icommandsender) {
		return "cda.commands.debug";
	}

	public void processCommand(ICommandSender icommandsender, String[] arg) {
		EntityPlayer p = (EntityPlayer)icommandsender;
		PlayerData d = CDAftermath.instance.playerDataHandler().getPlayerData(p);
		if (arg[0].equals("c")) d.coins += Integer.valueOf(arg[1]);
		else if (arg[0].equals("g")) p.getHeldItem().stackTagCompound.setInteger("repair", Integer.valueOf(arg[1]));
		else if (arg[0].equals("pdh")) {
			HashMap hm = CDAftermath.instance.playerDataHandler().playerDataMapping;
			p.addChatMessage("§eList: " + hm.size());
		}
	}
}
