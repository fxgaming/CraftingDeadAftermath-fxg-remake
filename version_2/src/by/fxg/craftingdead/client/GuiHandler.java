package by.fxg.craftingdead.client;

import by.fxg.craftingdead.CDReloaded;
import by.fxg.craftingdead.inventory.ContainerBackpack;
import by.fxg.craftingdead.inventory.ContainerFuelTanks;
import by.fxg.craftingdead.inventory.ContainerInventoryCDA;
import by.fxg.craftingdead.inventory.ContainerInventoryCDACrafting;
import by.fxg.craftingdead.inventory.ContainerTacticalVest;
import by.fxg.craftingdead.inventory.GuiBackpack;
import by.fxg.craftingdead.inventory.GuiFuelTanks;
import by.fxg.craftingdead.inventory.GuiInventoryCDA;
import by.fxg.craftingdead.inventory.GuiInventoryCDACrafting;
import by.fxg.craftingdead.inventory.GuiTacticalVest;
import by.fxg.craftingdead.inventory.InventoryBackpack;
import by.fxg.craftingdead.inventory.InventoryFuelTanks;
import by.fxg.craftingdead.inventory.InventoryTacticalVest;
import by.fxg.craftingdead.item.EnumBackpackSize;
import by.fxg.craftingdead.item.ItemBackpack;
import by.fxg.craftingdead.item.ItemFuelTankBackpack;
import by.fxg.craftingdead.item.ItemTacticalVest;
import by.fxg.craftingdead.player.PlayerData;
import by.fxg.craftingdead.player.PlayerDataHandler;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class GuiHandler implements IGuiHandler {
   public static final int GUI_CDAInventory = 45;
   public static final int GUI_CDAInventoryCrafting = 46;
   public static final int GUI_Backpack = 47;
   public static final int GUI_TacticalVest = 48;
   public static final int GUI_CreativeInventory = 49;

   public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
      PlayerData data = CDReloaded.instance.playerDataHandler().getPlayerData(player);
      if (id == 45) {
         return new ContainerInventoryCDA(player, data.getCDInventory());
      } else if (id == 46) {
         return new ContainerInventoryCDACrafting(player.inventory, player);
      } else {
         if (id == 47) {
            if (ItemBackpack.getBackpackInventory(player) != null) {
               return new ContainerBackpack(player.inventory, ItemBackpack.getBackpackInventory(player));
            }

            if (ItemFuelTankBackpack.getTanksInventory(player) != null) {
               return new ContainerFuelTanks(player.inventory, ItemFuelTankBackpack.getTanksInventory(player));
            }
         }

         return id == 48 && ItemTacticalVest.getVestInventory(player) != null ? new ContainerTacticalVest(player.inventory, ItemTacticalVest.getVestInventory(player)) : null;
      }
   }

   public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
      PlayerData data = CDReloaded.instance.playerDataHandler().getPlayerData(player);
      boolean isSinglePlayer = Minecraft.getMinecraft().isSingleplayer();
      if (id == 45) {
         return new GuiInventoryCDA(player, ClientProxy.getDummyCDInventory());
      } else if (id == 46) {
         return new GuiInventoryCDACrafting(player);
      } else {
         ItemStack stack;
         if (id == 47 && data.getCDInventory().getStack("backpack") != null) {
            stack = new ItemStack(data.getCDInventory().getStack("backpack").getItem());
            if (stack.getItem() instanceof ItemBackpack) {
               EnumBackpackSize size = ItemBackpack.getBackpackSize(stack);
               if (size != null && size.backpackSlots > 0) {
                  InventoryBackpack inventory = new InventoryBackpack(size, stack);
                  return new GuiBackpack(player.inventory, inventory);
               }
            }

            if (stack.getItem() instanceof ItemFuelTankBackpack) {
               InventoryFuelTanks inventory = new InventoryFuelTanks(stack);
               return new GuiFuelTanks(player.inventory, inventory);
            }
         }

         if (id == 48 && data.getCDInventory().getStack("vest") != null) {
            stack = new ItemStack(data.getCDInventory().getStack("vest").getItem());
            InventoryTacticalVest tacticalVestInventory = new InventoryTacticalVest(stack);
            return new GuiTacticalVest(player.inventory, tacticalVestInventory);
         } else {
            return null;
         }
      }
   }
}
