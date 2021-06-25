package by.fxg.craftingdead.network;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import by.fxg.craftingdead.CDReloaded;
import by.fxg.craftingdead.player.PlayerData;
import by.fxg.craftingdead.player.PlayerDataHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet250CustomPayload;

public class CDAPacketPlayerDataToServer extends CDAPacket {
   public static Packet buildPacket() {
      Packet250CustomPayload packet = new Packet250CustomPayload();
      packet.channel = "cdaNetworking";
      ByteArrayOutputStream bytes = new ByteArrayOutputStream();
      DataOutputStream data = new DataOutputStream(bytes);

      try {
         data.write(NetworkManager.getIDFromPacket(CDAPacketPlayerDataToServer.class));
         PlayerData playerData = CDReloaded.instance.playerDataHandler().getPlayerData(Minecraft.getMinecraft().getSession().getUsername());
         data.writeBoolean(playerData.isAiming);
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
      try {
         PlayerData data = CDReloaded.instance.playerDataHandler().getPlayerData(player.username);
         if (FMLCommonHandler.instance().getSide() == Side.SERVER) {
            data.isAiming = stream.readBoolean();
         }
      } catch (IOException var6) {
         var6.printStackTrace();
      }

   }
}
