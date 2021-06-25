package by.fxg.craftingdead.network;

import cpw.mods.fml.relauncher.Side;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import by.fxg.craftingdead.item.ItemGrenade;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.world.World;

public class CDAPacketGrenadeThrowing extends CDAPacket {
   public static Packet buildPacket(double force) {
      Packet250CustomPayload packet = new Packet250CustomPayload();
      packet.channel = "cdaNetworking";
      ByteArrayOutputStream bytes = new ByteArrayOutputStream();
      DataOutputStream data = new DataOutputStream(bytes);

      try {
         data.write(NetworkManager.getIDFromPacket(CDAPacketGrenadeThrowing.class));
         data.writeDouble(force);
         packet.data = bytes.toByteArray();
         packet.length = packet.data.length;
         data.close();
         bytes.close();
      } catch (Exception var6) {
         var6.printStackTrace();
      }

      return packet;
   }

   public void execute(DataInputStream stream, EntityPlayer player, Object[] extradata, Side side) {
      try {
         if (player instanceof EntityPlayerMP) {
            double force = stream.readDouble();
            EntityPlayerMP playermp = (EntityPlayerMP)player;
            World world = playermp.worldObj;
            ItemStack itemstack = playermp.inventory.getCurrentItem();
            if (itemstack != null && itemstack.getItem() != null && itemstack.getItem() instanceof ItemGrenade) {
               ((ItemGrenade)itemstack.getItem()).onGrenadeThrown(itemstack, world, playermp, force);
            }
         }
      } catch (IOException var10) {
         var10.printStackTrace();
      }

   }
}
