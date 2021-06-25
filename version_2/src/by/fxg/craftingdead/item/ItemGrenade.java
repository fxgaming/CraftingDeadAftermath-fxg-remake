package by.fxg.craftingdead.item;

import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import org.lwjgl.input.Mouse;

import by.fxg.craftingdead.CDReloaded;
import by.fxg.craftingdead.entity.EntityGrenade;
import by.fxg.craftingdead.network.CDAPacketGrenadeThrowing;
import by.fxg.craftingdead.player.PlayerData;
import by.fxg.craftingdead.player.PlayerDataHandler;

public class ItemGrenade extends ItemCD {
   public static boolean rightHeld;
   public static boolean lastRightHeld;
   public static boolean leftHeld;
   public static boolean lastLeftHeld;
   public boolean throwing = false;
   public boolean throwingDouble = false;
   public double throwingForce = 1.1D;
   private static ItemStack lastGrenadeStack;
   private static int lastStackTick;

   public ItemGrenade(int par1) {
      super(par1);
      this.setMaxStackSize(1);
   }

   public void onUpdate(ItemStack itemstack, World world, Entity entity, int i, boolean flag) {
      if (world.isRemote && Minecraft.getMinecraft().currentScreen == null && entity != null && entity instanceof EntityPlayer) {
         EntityPlayer player = (EntityPlayer)entity;
         PlayerData data = CDReloaded.instance.playerDataHandler().getPlayerData(player);
         if (data.isHandCuffed) {
            return;
         }

         if (player.getCurrentEquippedItem() == itemstack) {
            if (lastGrenadeStack != itemstack) {
               lastStackTick = 5;
               lastGrenadeStack = itemstack;
            }

            if (--lastStackTick > 0) {
               return;
            }

            lastRightHeld = rightHeld;
            rightHeld = Mouse.isButtonDown(Mouse.getButtonIndex("BUTTON1"));
            lastLeftHeld = leftHeld;
            leftHeld = Mouse.isButtonDown(Mouse.getButtonIndex("BUTTON0"));
            if (leftHeld) {
               this.throwingForce = 1.45D;
               this.throwing = true;
            }

            if (rightHeld) {
               this.throwingForce = 0.3D;
               this.throwing = true;
            }

            if (rightHeld && leftHeld) {
               this.throwingForce = 0.7D;
               this.throwing = true;
            }

            if (!leftHeld && !rightHeld && this.throwing) {
               PacketDispatcher.sendPacketToServer(CDAPacketGrenadeThrowing.buildPacket(this.throwingForce));
               this.throwing = false;
            }
         }
      }

   }

   public void onGrenadeThrown(ItemStack itemstack, World world, EntityPlayer player, double force) {
      PlayerData data = CDReloaded.instance.playerDataHandler().getPlayerData(player);
      if (data.canThrowGrenades) {
         double timeSeconds = 1.4D;
         world.spawnEntityInWorld(new EntityGrenade(world, player, force, (int)(timeSeconds * 20.0D)));
         if (!player.capabilities.isCreativeMode) {
            player.inventory.setInventorySlotContents(player.inventory.currentItem, (ItemStack)null);
         }

      }
   }

   @SideOnly(Side.CLIENT)
   public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
      super.addInformation(par1ItemStack, par2EntityPlayer, par3List, par4);
      par3List.add(EnumChatFormatting.RED + "Нажмите ЛКМ" + EnumChatFormatting.GRAY + " для сильного броска!");
      par3List.add(EnumChatFormatting.RED + "Нажмите ПКМ" + EnumChatFormatting.GRAY + " для слабого броска!");
   }

   public boolean onEntitySwing(EntityLivingBase entityLiving, ItemStack stack) {
      return true;
   }

   public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {
      return true;
   }

   public boolean onBlockStartBreak(ItemStack itemstack, int X, int Y, int Z, EntityPlayer player) {
      return true;
   }

   static {
      lastRightHeld = rightHeld;
      lastLeftHeld = leftHeld;
      lastStackTick = 0;
   }
}
