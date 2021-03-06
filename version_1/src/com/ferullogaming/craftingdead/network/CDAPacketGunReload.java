package com.ferullogaming.craftingdead.network;

import com.ferullogaming.craftingdead.item.gun.ItemGun;
import cpw.mods.fml.relauncher.Side;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.world.World;

public class CDAPacketGunReload extends CDAPacket {
   public static Packet buildPacket() {
      Packet250CustomPayload packet = new Packet250CustomPayload();
      packet.channel = "cdaNetworking";
      ByteArrayOutputStream bytes = new ByteArrayOutputStream();
      DataOutputStream data = new DataOutputStream(bytes);

      try {
         data.write(NetworkManager.getIDFromPacket(CDAPacketGunReload.class));
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
         EntityPlayerMP playermp = (EntityPlayerMP)player;
         World world = playermp.worldObj;
         ItemStack itemstack = playermp.inventory.getCurrentItem();
         if (itemstack != null && itemstack.getItem() != null && itemstack.getItem() instanceof ItemGun) {
            ((ItemGun)itemstack.getItem()).onReload(playermp, world, itemstack);
         }
      }

   }
}
