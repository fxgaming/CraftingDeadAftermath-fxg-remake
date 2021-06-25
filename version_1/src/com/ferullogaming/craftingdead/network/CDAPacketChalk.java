package com.ferullogaming.craftingdead.network;

import com.ferullogaming.craftingdead.item.ItemChalk;
import cpw.mods.fml.relauncher.Side;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.world.World;

public class CDAPacketChalk extends CDAPacket {
   public static Packet buildPacket(String par1) {
      Packet250CustomPayload packet = new Packet250CustomPayload();
      packet.channel = "cdaNetworking";
      ByteArrayOutputStream bytes = new ByteArrayOutputStream();
      DataOutputStream data = new DataOutputStream(bytes);

      try {
         data.write(NetworkManager.getIDFromPacket(CDAPacketChalk.class));
         data.writeUTF(par1);
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
            World world = player.worldObj;
            ItemStack itemstack = player.inventory.getCurrentItem();
            String name = stream.readUTF();
            if (itemstack != null && itemstack.getItem() != null && itemstack.getItem() instanceof ItemChalk) {
               ((ItemChalk)itemstack.getItem()).onChalkNamed(player, itemstack, name);
            }
         } catch (IOException var8) {
            var8.printStackTrace();
         }
      }

   }
}
