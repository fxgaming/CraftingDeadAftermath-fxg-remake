package by.fxg.craftingdead.network;

import cpw.mods.fml.relauncher.Side;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import by.fxg.craftingdead.CDReloaded;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet250CustomPayload;

public class CDAPacketOpenGUI extends CDAPacket {
   public static Packet buildPacket(int var1) {
      Packet250CustomPayload packet = new Packet250CustomPayload();
      packet.channel = "cdaNetworking";
      ByteArrayOutputStream bytes = new ByteArrayOutputStream();
      DataOutputStream data = new DataOutputStream(bytes);

      try {
         data.write(NetworkManager.getIDFromPacket(CDAPacketOpenGUI.class));
         data.writeInt(var1);
         packet.data = bytes.toByteArray();
         packet.length = packet.data.length;
         data.close();
         bytes.close();
      } catch (Exception var5) {
         var5.printStackTrace();
      }

      return packet;
   }

   public void execute(DataInputStream stream, EntityPlayer player, Object[] extradata, Side side) {
      if (player instanceof EntityPlayerMP) {
         try {
            int var1 = stream.readInt();
            EntityPlayerMP playermp = (EntityPlayerMP)player;
            playermp.openGui(CDReloaded.instance, var1, player.worldObj, 0, 0, 0);
         } catch (IOException var7) {
            var7.printStackTrace();
         }
      }

   }
}
