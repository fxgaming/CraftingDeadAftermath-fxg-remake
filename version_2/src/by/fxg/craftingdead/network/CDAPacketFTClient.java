package by.fxg.craftingdead.network;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import by.fxg.craftingdead.CDReloaded;
import by.fxg.craftingdead.item.ItemFlameThrower;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.world.World;

public class CDAPacketFTClient extends CDAPacket {
   public static Packet buildPacket(EntityPlayer par1) {
      Packet250CustomPayload packet = new Packet250CustomPayload();
      packet.channel = "cdaNetworking";
      ByteArrayOutputStream bytes = new ByteArrayOutputStream();
      DataOutputStream data = new DataOutputStream(bytes);

      try {
         data.write(NetworkManager.getIDFromPacket(CDAPacketFTClient.class));
         data.writeInt(par1.entityId);
         packet.data = bytes.toByteArray();
         packet.length = packet.data.length;
         data.close();
         bytes.close();
      } catch (Exception var5) {
         var5.printStackTrace();
      }

      return packet;
   }

   @SideOnly(Side.CLIENT)
   public void execute(DataInputStream stream, EntityPlayer player, Object[] extradata, Side side) {
      try {
         int var1 = stream.readInt();
         World world = player.worldObj;
         if (world.isRemote) {
            try {
               if (world.getEntityByID(var1) != null) {
                  Entity entity = world.getEntityByID(var1);
                  if (entity instanceof EntityPlayer) {
                     EntityPlayer playerFiring = (EntityPlayer)entity;
                     if (playerFiring.getDistanceToEntity(player) <= 100.0F && playerFiring.getCurrentEquippedItem() != null && playerFiring.getCurrentEquippedItem().getItem() instanceof ItemFlameThrower) {
                        CDReloaded.instance.getClientEvents().applyFlameThrowerParticles(playerFiring.getCurrentEquippedItem(), world, playerFiring);
                     }
                  }
               }
            } catch (Exception var9) {
               ;
            }
         }
      } catch (IOException var10) {
         var10.printStackTrace();
      }

   }
}
