package by.fxg.craftingdead.network;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import by.fxg.craftingdead.entity.GrenadeExplosion;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet250CustomPayload;

public class CDAPacketGrenadeExplosion extends CDAPacket {
   public static Packet buildPacket(double par1, double par2, double par3, float par4) {
      Packet250CustomPayload packet = new Packet250CustomPayload();
      packet.channel = "cdaNetworking";
      ByteArrayOutputStream bytes = new ByteArrayOutputStream();
      DataOutputStream data = new DataOutputStream(bytes);

      try {
         data.write(NetworkManager.getIDFromPacket(CDAPacketGrenadeExplosion.class));
         data.writeDouble(par1);
         data.writeDouble(par2);
         data.writeDouble(par3);
         data.writeFloat(par4);
         packet.data = bytes.toByteArray();
         packet.length = packet.data.length;
         data.close();
         bytes.close();
      } catch (Exception var11) {
         var11.printStackTrace();
      }

      return packet;
   }

   @SideOnly(Side.CLIENT)
   public void execute(DataInputStream stream, EntityPlayer player, Object[] extradata, Side side) {
      try {
         double var1 = stream.readDouble();
         double var2 = stream.readDouble();
         double var3 = stream.readDouble();
         float var4 = stream.readFloat();
         this.createExplosion(var1, var2, var3, var4);
      } catch (IOException var12) {
         var12.printStackTrace();
      }

   }

   @SideOnly(Side.CLIENT)
   public void createExplosion(double par2, double par4, double par6, float par8) {
      GrenadeExplosion explosion = new GrenadeExplosion(Minecraft.getMinecraft().theWorld, (EntityLivingBase)null, par2, par4, par6, par8);
      explosion.a = false;
      explosion.b = true;
      explosion.doExplosionB(true);
   }
}
