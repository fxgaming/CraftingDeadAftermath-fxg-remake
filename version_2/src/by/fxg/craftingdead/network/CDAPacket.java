package by.fxg.craftingdead.network;

import cpw.mods.fml.relauncher.Side;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet250CustomPayload;

public class CDAPacket {
   public static Packet buildPacket() {
      Packet250CustomPayload packet = new Packet250CustomPayload();
      packet.channel = "cdaNetworking";
      ByteArrayOutputStream bytes = new ByteArrayOutputStream();
      DataOutputStream data = new DataOutputStream(bytes);

      try {
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
   }
}
