package com.ferullogaming.craftingdead.network;

import com.ferullogaming.craftingdead.CDAftermath;
import com.ferullogaming.craftingdead.inventory.InventoryCDA;
import com.ferullogaming.craftingdead.item.gun.ItemGun;
import com.ferullogaming.craftingdead.item.potion.PotionManager;
import com.ferullogaming.craftingdead.player.PlayerData;
import com.ferullogaming.craftingdead.player.PlayerDataHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.world.World;

public class CDAPacketPlayerData extends CDAPacket {
   public static Packet buildPacket(World world) {
      Packet250CustomPayload packet = new Packet250CustomPayload();
      packet.channel = "cdaNetworking";
      ByteArrayOutputStream bytes = new ByteArrayOutputStream();
      DataOutputStream data = new DataOutputStream(bytes);

      try {
         data.write(NetworkManager.getIDFromPacket(CDAPacketPlayerData.class));
         data.writeInt(world.playerEntities.size());

         for(int i = 0; i < world.playerEntities.size(); ++i) {
            EntityPlayer player = (EntityPlayer)world.playerEntities.get(i);
            PlayerData playerData = CDAftermath.instance.playerDataHandler().getPlayerData(player.username);
            data.writeUTF(playerData.username);
            data.writeBoolean(playerData.isAiming);
            data.writeInt(playerData.getWaterLevels().getWaterLevels());
            data.writeBoolean(playerData.canViewUsername);
            data.writeBoolean(player.isPotionActive(PotionManager.bleeding.id));
            data.writeBoolean(player.isPotionActive(PotionManager.RBInfection.id));
            data.writeBoolean(player.isPotionActive(PotionManager.brokenLeg.id));
            InventoryCDA inv = playerData.getCDInventory();
            data.writeInt(inv.getInventoryContentList().size());

            for(int i1 = 0; i1 < inv.getSizeInventory(); ++i1) {
               ItemStack itemstack = inv.getStackInSlot(i1);
               boolean hasNBT = false;
               if (itemstack != null) {
                  if (itemstack.getItem() instanceof ItemGun) {
                     hasNBT = true;
                  }

                  data.writeInt(i1);
                  data.writeInt(itemstack.itemID);
                  data.writeBoolean(hasNBT);
                  if (hasNBT) {
                     NBTTagCompound nbt = new NBTTagCompound("itemstack" + i1);
                     itemstack.writeToNBT(nbt);
                     NBTTagCompound.writeNamedTag(nbt, data);
                  }
               }
            }
         }

         packet.data = bytes.toByteArray();
         packet.length = packet.data.length;
         data.close();
         bytes.close();
      } catch (Exception var12) {
         var12.printStackTrace();
      }

      return packet;
   }

   @SideOnly(Side.CLIENT)
   public void execute(DataInputStream stream, EntityPlayer player, Object[] extradata, Side side) {
      try {
         int var1 = stream.readInt();
         if (player.worldObj.isRemote) {
            for(int i = 0; i < var1; ++i) {
               String username = stream.readUTF();
               boolean isClientUsername = username.equals(Minecraft.getMinecraft().getSession().getUsername());
               PlayerData playerData = CDAftermath.instance.playerDataHandler().getPlayerData(username);
               boolean isAiming = stream.readBoolean();
               int waterLevels = stream.readInt();
               int temperature = stream.readInt();
               boolean viewTag = stream.readBoolean();
               boolean potion1 = stream.readBoolean();
               boolean potion2 = stream.readBoolean();
               boolean potion3 = stream.readBoolean();
               if (!isClientUsername) {
                  playerData.isAiming = isAiming;
               }
               playerData.getWaterLevels().setWaterLevel(waterLevels);
               playerData.canViewUsername = viewTag;
               playerData.isPotionBleeding = potion1;
               playerData.isPotionInfected = potion2;
               playerData.isPotionLegBroken = potion3;
               int var2 = stream.readInt();
               playerData.getCDInventory().clearInventory();

               for(int i1 = 0; i1 < var2; ++i1) {
                  int var3 = stream.readInt();
                  int var4 = stream.readInt();
                  boolean var5 = stream.readBoolean();
                  ItemStack itemstack = new ItemStack(var4, 1, 0);
                  if (var5) {
                     NBTTagCompound nbt = (NBTTagCompound)NBTTagCompound.readNamedTag(stream);
                     itemstack.readFromNBT(nbt);
                  }

                  playerData.getCDInventory().setInventorySlotContents(var3, itemstack);
               }
            }
         }
      } catch (IOException var23) {
         var23.printStackTrace();
      }

   }
}
