package by.fxg.craftingdead.network;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;

import by.fxg.craftingdead.item.gun.ItemGun;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.world.World;

public class CDAPacketSound extends CDAPacket {
   public static Packet buildPacket(Type t) {
      Packet250CustomPayload packet = new Packet250CustomPayload();
      packet.channel = "cdaNetworking";
      ByteArrayOutputStream bytes = new ByteArrayOutputStream();
      DataOutputStream data = new DataOutputStream(bytes);

      try {
         data.write(NetworkManager.getIDFromPacket(CDAPacketSound.class));
         data.writeInt(t.ordinal());
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
	   try {
		   if (player.worldObj.isRemote) {
			   int type = stream.readInt();
			   switch(type) {
			       case 0:
			    	   Minecraft.getMinecraft().sndManager.playSoundFX("craftingdead:headshot", 1.5F, 1.0F);
			    	   break;
			       case 1:
			    	   Minecraft.getMinecraft().sndManager.playSoundFX("craftingdead:gun_break", 1.0F, 1.0F);
			    	   break;
			       case 2:
			    	   Minecraft.getMinecraft().sndManager.playSoundFX("craftingdead:gun_repair", 1.5F, 1.0F);
			    	   break;
			       case 3:
			    	   Minecraft.getMinecraft().sndManager.playSoundFX("craftingdead:supressorslot_break", 1.5F, 1.0F);
			    	   break;
			       case 4:
			    	   Minecraft.getMinecraft().sndManager.playSoundFX("craftingdead:supressorslot_repair", 1.5F, 1.0F);
			    	   break;
			   }
		   }
	   } catch (Exception e) {
		   e.printStackTrace();
	   }
   } 
   
   public static enum Type {
	   HEADSHOT,
	   GUN_BROKEN,
	   GUN_REPAIRED,
	   SUPRESSORSLOT_BROKEN,
	   SUPRESSORSLOT_REPAIRED
   }
}
