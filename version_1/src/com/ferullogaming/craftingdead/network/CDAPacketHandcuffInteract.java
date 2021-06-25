package com.ferullogaming.craftingdead.network;

import com.ferullogaming.craftingdead.CDAftermath;
import com.ferullogaming.craftingdead.player.PlayerData;
import com.ferullogaming.craftingdead.player.PlayerDataHandler;
import cpw.mods.fml.relauncher.Side;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.Random;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.world.World;

public class CDAPacketHandcuffInteract extends CDAPacket {
	public static Packet buildPacket() {
		Packet250CustomPayload packet = new Packet250CustomPayload();
		packet.channel = "cdaNetworking";
		ByteArrayOutputStream bytes = new ByteArrayOutputStream();
		DataOutputStream data = new DataOutputStream(bytes);

		try {
			data.write(NetworkManager.getIDFromPacket(CDAPacketHandcuffInteract.class));
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
		if (player instanceof EntityPlayerMP) {
			PlayerData data = CDAftermath.instance.playerDataHandler().getPlayerData(player);
			World world = player.worldObj;
			if (data.isHandCuffed) {
				++data.handcuffDamage;
				Random rand = new Random();
				world.playSoundAtEntity(player, "random.break", 0.8F, 0.8F + rand.nextFloat() / 2.0F);
			}
		}

	}
}
