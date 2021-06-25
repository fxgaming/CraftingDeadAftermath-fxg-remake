package by.fxg.craftingdead.network;

import cpw.mods.fml.relauncher.Side;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.Random;

import by.fxg.craftingdead.CDReloaded;
import by.fxg.craftingdead.player.PlayerData;
import by.fxg.craftingdead.player.PlayerDataHandler;
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
			PlayerData data = CDReloaded.instance.playerDataHandler().getPlayerData(player);
			World world = player.worldObj;
			if (data.isHandCuffed) {
				++data.handcuffDamage;
				Random rand = new Random();
				world.playSoundAtEntity(player, "random.break", 0.8F, 0.8F + rand.nextFloat() / 2.0F);
			}
		}

	}
}
