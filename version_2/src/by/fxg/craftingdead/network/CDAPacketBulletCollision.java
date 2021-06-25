package by.fxg.craftingdead.network;

import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.relauncher.Side;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import by.fxg.craftingdead.CDReloaded;
import by.fxg.craftingdead.events.EnumBulletCollision;
import by.fxg.craftingdead.events.EventBulletCollision;
import by.fxg.craftingdead.item.gun.ItemGun;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;

public class CDAPacketBulletCollision extends CDAPacket {
   public static Packet buildPacket(boolean par1, Object... extraData) {
      Packet250CustomPayload packet = new Packet250CustomPayload();
      packet.channel = "cdaNetworking";
      ByteArrayOutputStream bytes = new ByteArrayOutputStream();
      DataOutputStream data = new DataOutputStream(bytes);

      try {
         data.write(NetworkManager.getIDFromPacket(CDAPacketBulletCollision.class));
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
            double var5vecx = (Double)extraData[5];
            double var6vecy = (Double)extraData[6];
            double var7vecz = (Double)extraData[7];
            data.writeInt(blockid);
            data.writeDouble(var1);
            data.writeDouble(var2);
            data.writeDouble(var3);
            data.writeInt(var4);
            data.writeDouble(var5vecx);
            data.writeDouble(var6vecy);
            data.writeDouble(var7vecz);
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

   public void execute(DataInputStream stream, EntityPlayer player, Object[] extradata, Side side) {
      try {
         boolean var1 = stream.readBoolean();
         World world = player.worldObj;
         ItemStack itemstack = player.getCurrentEquippedItem();
         if (itemstack != null && itemstack.getItem() instanceof ItemGun && !world.isRemote) {
            int blockid;
            if (var1) {
               blockid = stream.readInt();
               boolean var3 = stream.readBoolean();
               double vecx = stream.readDouble();
               double vecy = stream.readDouble();
               double vecz = stream.readDouble();
               Vec3 vec3 = Vec3.createVectorHelper(vecx, vecy, vecz);
               Entity entityHit = world.getEntityByID(blockid);
               if (entityHit != null && !entityHit.isDead) {
                  if (entityHit instanceof EntityLivingBase) {
                     CDReloaded.instance.getCommonEvents().applyBulletCollisionEntity(player, itemstack, (EntityLivingBase)entityHit, var3, vec3, world);
                     double var10000 = entityHit.posX;
                     double var10001 = entityHit.posY;
                     double var10002 = entityHit.posZ;
                     PacketDispatcher.sendPacketToAllAround(var10000, var10001, var10002, 128.0D, 0, CDAPacketBulletCollisionClient.buildPacket(true, entityHit, var3, vecx, vecy, vecz));
                  } else {
                     EventBulletCollision eventBulletCollision = new EventBulletCollision(EnumBulletCollision.ENTITY, player, itemstack, world);
                     eventBulletCollision.setEntityHit(entityHit);
                     MinecraftForge.EVENT_BUS.post(eventBulletCollision);
                  }
               }
            } else {
               blockid = stream.readInt();
               double x = stream.readDouble();
               double y = stream.readDouble();
               double z = stream.readDouble();
               int sidehit = stream.readInt();
               double vecx = stream.readDouble();
               double vecy = stream.readDouble();
               double vecz = stream.readDouble();
               Vec3 vec3 = Vec3.createVectorHelper(vecx, vecy, vecz);
               int checkID = world.getBlockId((int)x, (int)y, (int)z);
               if (blockid == checkID && blockid != 0) {
                  CDReloaded.instance.getCommonEvents().applyBulletCollisionBlock(player, itemstack, world, x, y, z, blockid, sidehit, vec3);
                  PacketDispatcher.sendPacketToAllAround(x, y, z, 128.0D, 0, CDAPacketBulletCollisionClient.buildPacket(false, blockid, x, y, z, sidehit, vecx, vecy, vecz));
               }
            }
         }
      } catch (IOException var24) {
         var24.printStackTrace();
      }

   }
}
