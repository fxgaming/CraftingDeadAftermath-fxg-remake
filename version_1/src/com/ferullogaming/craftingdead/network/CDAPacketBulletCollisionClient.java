package com.ferullogaming.craftingdead.network;

import com.ferullogaming.craftingdead.CDAftermath;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class CDAPacketBulletCollisionClient extends CDAPacket {
   public static Packet buildPacket(boolean par1, Object... extraData) {
      Packet250CustomPayload packet = new Packet250CustomPayload();
      packet.channel = "cdaNetworking";
      ByteArrayOutputStream bytes = new ByteArrayOutputStream();
      DataOutputStream data = new DataOutputStream(bytes);

      try {
         data.write(NetworkManager.getIDFromPacket(CDAPacketBulletCollisionClient.class));
         data.writeBoolean(par1);
         if (par1) {
            Entity entityHit = (Entity)extraData[0];
            int var1 = entityHit.entityId;
            data.writeInt(var1);
            data.writeBoolean((Boolean)extraData[1]);
            data.writeDouble((Double)extraData[2]);
            data.writeDouble((Double)extraData[3]);
            data.writeDouble((Double)extraData[4]);
         } else {
            int blockid = (Integer)extraData[0];
            double var1 = (Double)extraData[1];
            double var2 = (Double)extraData[2];
            double var3 = (Double)extraData[3];
            int var4 = (Integer)extraData[4];
            double var5 = (Double)extraData[5];
            double var6 = (Double)extraData[6];
            double var7 = (Double)extraData[7];
            data.writeInt(blockid);
            data.writeDouble(var1);
            data.writeDouble(var2);
            data.writeDouble(var3);
            data.writeInt(var4);
            data.writeDouble(var5);
            data.writeDouble(var6);
            data.writeDouble(var7);
         }

         packet.data = bytes.toByteArray();
         packet.length = packet.data.length;
         data.close();
         bytes.close();
      } catch (Exception var19) {
         var19.printStackTrace();
      }

      return packet;
   }

   @SideOnly(Side.CLIENT)
   public void execute(DataInputStream stream, EntityPlayer player, Object[] extradata, Side side) {
      try {
         boolean var1 = stream.readBoolean();
         World world = player.worldObj;
         if (world.isRemote) {
            int blockid;
            if (var1) {
               blockid = stream.readInt();
               boolean var3 = stream.readBoolean();
               double vx = stream.readDouble();
               double vy = stream.readDouble();
               double vz = stream.readDouble();
               Vec3 vec3 = Vec3.createVectorHelper(vx, vy, vz);
               Entity entityHit = world.getEntityByID(blockid);
               if (entityHit != null && !entityHit.isDead && entityHit instanceof EntityLivingBase) {
                  CDAftermath.instance.getClientEvents().applyBulletCollisionEntity((EntityLivingBase)entityHit, var3, vec3);
               }
            } else {
               blockid = stream.readInt();
               double x = stream.readDouble();
               double y = stream.readDouble();
               double z = stream.readDouble();
               int sidehit = stream.readInt();
               double vx = stream.readDouble();
               double vy = stream.readDouble();
               double vz = stream.readDouble();
               Vec3 vec3 = Vec3.createVectorHelper(vx, vy, vz);
               int checkID = world.getBlockId((int)x, (int)y, (int)z);
               if (blockid == checkID && blockid != 0) {
                  CDAftermath.instance.getClientEvents().applyBulletCollisionBlock(world, x, y, z, blockid, sidehit, vec3);
               }
            }
         }
      } catch (IOException var23) {
         var23.printStackTrace();
      }

   }
}
