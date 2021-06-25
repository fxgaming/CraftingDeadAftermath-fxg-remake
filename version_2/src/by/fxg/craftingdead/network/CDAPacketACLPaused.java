package by.fxg.craftingdead.network;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;

import by.fxg.craftingdead.CDReloaded;
import by.fxg.craftingdead.player.PlayerData;
import by.fxg.craftingdead.player.PlayerDataHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet250CustomPayload;

public class CDAPacketACLPaused extends CDAPacket {
   public static Packet buildPacket() {
      Packet250CustomPayload packet = new Packet250CustomPayload();
      packet.channel = "cdaNetworking";
      ByteArrayOutputStream bytes = new ByteArrayOutputStream();
      DataOutputStream data = new DataOutputStream(bytes);

      try {
         data.write(NetworkManager.getIDFromPacket(CDAPacketACLPaused.class));
         packet.data = bytes.toByteArray();
         packet.length = packet.data.length;
         data.close();
         bytes.close();
      } catch (Exception var4) {
         var4.printStackTrace();
      }

      return packet;
   }

   @SideOnly(Side.SERVER)
   public void execute(DataInputStream stream, EntityPlayer player, Object[] extradata, Side side) {
      if (player instanceof EntityPlayerMP) {
         PlayerData data = CDReloaded.instance.playerDataHandler().getPlayerData(player);
         if (data.antiCombatLoggingWaitTick != -1) {
            data.antiCombatLoggingWaitTick = 90;
         }
      }

   }
}
