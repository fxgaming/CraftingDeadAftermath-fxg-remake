package by.fxg.craftingdead.network;

import cpw.mods.fml.relauncher.Side;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import by.fxg.craftingdead.CDReloaded;
import by.fxg.craftingdead.item.ItemMeleeWeapon;
import by.fxg.craftingdead.item.gun.ItemGun;
import by.fxg.craftingdead.player.PlayerData;
import by.fxg.craftingdead.player.PlayerDataHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet250CustomPayload;

public class CDAPacketSwitchItem extends CDAPacket {
   public static Packet buildPacket(boolean par1) {
      Packet250CustomPayload packet = new Packet250CustomPayload();
      packet.channel = "cdaNetworking";
      ByteArrayOutputStream bytes = new ByteArrayOutputStream();
      DataOutputStream data = new DataOutputStream(bytes);

      try {
         data.write(NetworkManager.getIDFromPacket(CDAPacketSwitchItem.class));
         data.writeBoolean(par1);
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
            boolean var1 = stream.readBoolean();
            EntityPlayerMP playermp = (EntityPlayerMP)player;
            PlayerData data = CDReloaded.instance.playerDataHandler().getPlayerData(playermp.username);
            ItemStack itemstackHolding = player.inventory.getCurrentItem();
            ItemStack itemstackCarring = data.getCDInventory().getStack(var1 ? "gun" : "melee");
            if (var1) {
               if (itemstackHolding == null) {
                  if (itemstackCarring != null && itemstackCarring.getItem() instanceof ItemGun) {
                     playermp.inventory.setInventorySlotContents(player.inventory.currentItem, itemstackCarring);
                     data.getCDInventory().setInventorySlotContents(data.getCDInventory().getStackSlot("gun"), (ItemStack)null);
                     return;
                  }
               } else if (itemstackHolding.getItem() instanceof ItemGun) {
                  if (itemstackCarring == null) {
                     playermp.inventory.setInventorySlotContents(player.inventory.currentItem, (ItemStack)null);
                     data.getCDInventory().setInventorySlotContents(data.getCDInventory().getStackSlot("gun"), itemstackHolding);
                     return;
                  }

                  playermp.inventory.setInventorySlotContents(player.inventory.currentItem, itemstackCarring);
                  data.getCDInventory().setInventorySlotContents(data.getCDInventory().getStackSlot("gun"), itemstackHolding);
                  return;
               }
            } else if (itemstackHolding == null) {
               if (itemstackCarring != null && itemstackCarring.getItem() instanceof ItemMeleeWeapon) {
                  playermp.inventory.setInventorySlotContents(player.inventory.currentItem, itemstackCarring);
                  data.getCDInventory().setInventorySlotContents(data.getCDInventory().getStackSlot("melee"), (ItemStack)null);
                  return;
               }
            } else if (itemstackHolding.getItem() instanceof ItemMeleeWeapon) {
               if (itemstackCarring == null) {
                  playermp.inventory.setInventorySlotContents(player.inventory.currentItem, (ItemStack)null);
                  data.getCDInventory().setInventorySlotContents(data.getCDInventory().getStackSlot("melee"), itemstackHolding);
                  return;
               }

               playermp.inventory.setInventorySlotContents(player.inventory.currentItem, itemstackCarring);
               data.getCDInventory().setInventorySlotContents(data.getCDInventory().getStackSlot("melee"), itemstackHolding);
               return;
            }
         } catch (IOException var10) {
            var10.printStackTrace();
         }
      }

   }
}
