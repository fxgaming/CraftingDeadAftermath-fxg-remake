package com.fxg.decoration.command;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.World;

public class CommandWG extends CommandBase {
	public static int[] xyz1 = new int[3];
	public static int[] xyz2 = new int[3];
	public String getCommandName() {
		return "wg";
	}

	public String getCommandUsage(ICommandSender icommandsender) {
		return "eye";
	}


	public void processCommand(ICommandSender icommandsender, String[] astring) {
		if (astring.length > 0) {
			if (astring[0].toLowerCase().equals("pos1")) {
				ChunkCoordinates cc = icommandsender.getPlayerCoordinates();
				xyz1[0] = cc.posX;
				xyz1[1] = cc.posY;
				xyz1[2] = cc.posZ;
				icommandsender.sendChatToPlayer(ChatMessageComponent.createFromText("Pos1 = [" + xyz1[0] + " " + xyz1[1] + " " + xyz1[2] + "]"));
			}
			if (astring[0].toLowerCase().equals("pos2")) {
				ChunkCoordinates cc = icommandsender.getPlayerCoordinates();
				xyz2[0] = cc.posX;
				xyz2[1] = cc.posY;
				xyz2[2] = cc.posZ;
				icommandsender.sendChatToPlayer(ChatMessageComponent.createFromText("Pos2 = [" + xyz2[0] + " " + xyz2[1] + " " + xyz2[2] + "]"));
			}
			if (astring[0].toLowerCase().equals("set") && astring.length > 1) {
				int[] ix = {(xyz1[0] > xyz2[0] ? xyz2[0] : xyz1[0]), (xyz1[0] > xyz2[0] ? xyz1[0] - xyz2[0] : xyz2[0] - xyz1[0])};
				int[] iy = {(xyz1[1] > xyz2[1] ? xyz2[1] : xyz1[1]), (xyz1[1] > xyz2[1] ? xyz1[1] - xyz2[1] : xyz2[1] - xyz1[1])};
				int[] iz = {(xyz1[2] > xyz2[2] ? xyz2[2] : xyz1[2]), (xyz1[2] > xyz2[2] ? xyz1[2] - xyz2[2] : xyz2[2] - xyz1[2])};
				World w = icommandsender.getEntityWorld();
				int id = Integer.valueOf(astring[1]);
				if (!w.isRemote) {
					for (int x = ix[0]; x != ix[1] + 1; x++) {
						for (int y = iy[0]; y != iy[1] + 1; y++) {
							for (int z = iz[0]; z != iz[1] + 1; z++) {
								w.setBlock(x, y, z, id);
							}	
						}
					}
				}
				icommandsender.sendChatToPlayer(ChatMessageComponent.createFromText("blocksSet " + id + ", total " + (ix[1] + iy[1] + iz[1])));
			}
		}
	}
}
