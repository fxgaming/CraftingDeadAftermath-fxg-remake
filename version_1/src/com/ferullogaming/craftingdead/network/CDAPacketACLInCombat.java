package com.ferullogaming.craftingdead.network;

import com.ferullogaming.craftingdead.CDAftermath;
import com.ferullogaming.craftingdead.player.PlayerData;
import com.ferullogaming.craftingdead.player.PlayerDataHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet250CustomPayload;

public class CDAPacketACLInCombat extends CDAPacket {
   public static Packet buildPacket() {
      Packet250CustomPayload packet = new Packet250CustomPayload();
      packet.channel = "cdaNetworking";
      ByteArrayOutputStream bytes = new ByteArrayOutputStream();
      DataOutputStream data = new DataOutputStream(bytes);

      try {
         data.write(NetworkManager.getIDFromPacket(CDAPacketACLInCombat.class));
         packet.data = bytes.toByteArray();
         packet.length = packet.data.length;
         data.close();
         bytes.close();
      } catch (Exception var4) {
         var4.printStackTrace();
      }

      return packet;
   }

   @SideOnly(Side.CLIENT)
   public void execute(DataInputStream stream, EntityPlayer player, Object[] extradata, Side side) {
      PlayerData data = CDAftermath.instance.playerDataHandler().getClientPlayerData();
      data.inCombatTick = data.inCombatTickMax;
   }
}
