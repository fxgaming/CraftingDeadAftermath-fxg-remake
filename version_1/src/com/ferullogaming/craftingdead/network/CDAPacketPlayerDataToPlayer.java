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

public class CDAPacketPlayerDataToPlayer extends CDAPacket {
   public static Packet buildPacket(EntityPlayer player) {
      Packet250CustomPayload packet = new Packet250CustomPayload();
      packet.channel = "cdaNetworking";
      ByteArrayOutputStream bytes = new ByteArrayOutputStream();
      DataOutputStream data = new DataOutputStream(bytes);

      try {
         data.write(NetworkManager.getIDFromPacket(CDAPacketPlayerDataToPlayer.class));
         PlayerData playerData = CDAftermath.instance.playerDataHandler().getPlayerData(player.username);
         data.writeUTF(playerData.username);
         data.writeBoolean(playerData.isAiming);
         data.writeInt(playerData.getWaterLevels().getWaterLevels());
         data.writeInt(playerData.getStamina().getStamina());
         data.writeInt(playerData.coins);
         data.writeInt(playerData.donatecoins);
         data.writeBoolean(playerData.canViewUsername);
         data.writeBoolean(player.isPotionActive(PotionManager.bleeding.id));
         data.writeBoolean(player.isPotionActive(PotionManager.RBInfection.id));
         data.writeBoolean(player.isPotionActive(PotionManager.brokenLeg.id));
         data.writeInt(playerData.flamethrowerFuelCount);
         data.writeBoolean(playerData.isHandCuffed);
         data.writeInt(playerData.handcuffDamage);
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

         packet.data = bytes.toByteArray();
         packet.length = packet.data.length;
         data.close();
         bytes.close();
      } catch (Exception var10) {
         var10.printStackTrace();
      }

      return packet;
   }

   @SideOnly(Side.CLIENT)
   public void execute(DataInputStream stream, EntityPlayer player, Object[] extradata, Side side) {
      try {
         if (player.worldObj.isRemote) {
            String username = stream.readUTF();
            boolean isClientUsername = username.equals(Minecraft.getMinecraft().getSession().getUsername());
            PlayerData playerData = CDAftermath.instance.playerDataHandler().getPlayerData(username);
            boolean isAiming = stream.readBoolean();
            int waterLevels = stream.readInt();
            int stamina = stream.readInt();
            int c = stream.readInt();
            int c1 = stream.readInt();
            boolean viewTag = stream.readBoolean();
            boolean potion1 = stream.readBoolean();
            boolean potion2 = stream.readBoolean();
            boolean potion3 = stream.readBoolean();
            int fuelCount = stream.readInt();
            boolean isHandcuffed = stream.readBoolean();
            int handcuffDamagae = stream.readInt();
            if (!isClientUsername) {
               playerData.isAiming = isAiming;
            }

            playerData.getWaterLevels().setWaterLevel(waterLevels);
            playerData.getStamina().setStamina(stamina);
            playerData.coins = c;
            playerData.donatecoins = c1;
            playerData.canViewUsername = viewTag;
            playerData.isPotionBleeding = potion1;
            playerData.isPotionInfected = potion2;
            playerData.isPotionLegBroken = potion3;
            int var2 = stream.readInt();
            if (Minecraft.getMinecraft().isSingleplayer()) {
               return;
            }

            playerData.isHandCuffed = isHandcuffed;
            playerData.handcuffDamage = handcuffDamagae;
            playerData.flamethrowerFuelCount = fuelCount;
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
      } catch (IOException var24) {
         var24.printStackTrace();
      }

   }
}
