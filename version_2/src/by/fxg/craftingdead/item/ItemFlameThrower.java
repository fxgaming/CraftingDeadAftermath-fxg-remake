package by.fxg.craftingdead.item;

import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.common.network.Player;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import org.lwjgl.input.Mouse;

import by.fxg.craftingdead.CDReloaded;
import by.fxg.craftingdead.entity.EntityFlameThrowerFire;
import by.fxg.craftingdead.inventory.InventoryFuelTanks;
import by.fxg.craftingdead.network.CDAPacketFTClient;
import by.fxg.craftingdead.network.CDAPacketFTTrigger;
import by.fxg.craftingdead.network.CDAPacketFTTriggerStop;
import by.fxg.craftingdead.player.PlayerData;
import by.fxg.craftingdead.player.PlayerDataHandler;

public class ItemFlameThrower extends ItemCD {
   private static boolean rightHeld;
   private static boolean lastRightHeld;
   private double tickFire = 0.0D;
   private double tickFireClient = 0.0D;
   private double tickSound = 0.0D;
   private Random rand = new Random();
   private boolean soundStart = false;
   private boolean lastSoundStart = false;

   public ItemFlameThrower(int par1) {
      super(par1);
   }

   public void onFlameThrowerFired(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
      int fuelSlot = -1;
      InventoryFuelTanks inv = (InventoryFuelTanks)ItemFuelTankBackpack.getTanksInventory(par3EntityPlayer);
      if (inv != null) {
         if (!par3EntityPlayer.capabilities.isCreativeMode) {
            for(int i = 0; i < inv.getSizeInventory(); ++i) {
               ItemStack stack = inv.getStackInSlot(i);
               if (stack != null && stack.getItem() instanceof ItemFuelTank) {
                  ItemFuelTank item = (ItemFuelTank)stack.getItem();
                  if (stack.getItemDamage() < item.clipSize) {
                     fuelSlot = i;
                     break;
                  }
               }
            }
         }

         if (fuelSlot == -1 && !par3EntityPlayer.capabilities.isCreativeMode) {
            this.setHasFuel(par1ItemStack, false);
            if (this.soundStart) {
               par2World.playSoundAtEntity(par3EntityPlayer, "craftingdead:flameout", 1.0F, 1.0F);
               this.soundStart = false;
            }
         } else {
            if (!this.soundStart) {
               par2World.playSoundAtEntity(par3EntityPlayer, "craftingdead:flamestart", 1.0F, 1.0F);
               this.soundStart = true;
            }

            if (this.tickSound++ > 18.0D) {
               par2World.playSoundAtEntity(par3EntityPlayer, "craftingdead:flame", 1.0F, 1.0F);
               this.tickSound = 0.0D;
            }

            if (this.tickFire++ < 2.0D) {
               return;
            }

            EntityFlameThrowerFire fire = new EntityFlameThrowerFire(par2World, par3EntityPlayer);
            par2World.spawnEntityInWorld(fire);
            this.setHasFuel(par1ItemStack, true);
            this.updateClientsAround(par3EntityPlayer, 100);
            if (!par3EntityPlayer.capabilities.isCreativeMode) {
               int var1 = inv.getStackInSlot(fuelSlot).getItemDamage();
               inv.setInventorySlotContents(fuelSlot, new ItemStack(inv.getStackInSlot(fuelSlot).getItem(), 1, var1 + 1));
            }
         }
      } else {
         this.setHasFuel(par1ItemStack, false);
      }

   }

   public void onFlameThrowerStopped(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
      if (!par2World.isRemote) {
         this.soundStart = false;
         this.tickSound = 0.0D;
         this.tickFire = 0.0D;
         if (this.hasFuel(par1ItemStack)) {
            par2World.playSoundAtEntity(par3EntityPlayer, "craftingdead:flameout", 1.0F, 1.0F);
         }
      }

   }

   public void onUpdate(ItemStack itemstack, World world, Entity entity, int i, boolean flag) {
      if (world.isRemote && Minecraft.getMinecraft().currentScreen == null && entity != null && entity instanceof EntityPlayer) {
         EntityPlayer player = (EntityPlayer)entity;
         PlayerData data = CDReloaded.instance.playerDataHandler().getPlayerData(player);
         if (data.isHandCuffed) {
            return;
         }

         if (player.getCurrentEquippedItem() == itemstack) {
            lastRightHeld = rightHeld;
            rightHeld = Mouse.isButtonDown(Mouse.getButtonIndex("BUTTON1"));
            if (rightHeld) {
               PacketDispatcher.sendPacketToServer(CDAPacketFTTrigger.buildPacket());
               if (this.hasFuel(itemstack) && this.tickFireClient++ > 1.0D) {
                  CDReloaded.instance.getClientEvents().applyFlameThrowerParticles(itemstack, world, player);
               }
            }

            if (rightHeld != lastRightHeld && !rightHeld) {
               PacketDispatcher.sendPacketToServer(CDAPacketFTTriggerStop.buildPacket());
               this.tickFireClient = 0.0D;
            }
         }
      }

   }

   public void updateClientsAround(EntityPlayer par1, int var1) {
      if (!par1.worldObj.isRemote) {
         ArrayList entities = (ArrayList)par1.worldObj.getEntitiesWithinAABB(EntityPlayer.class, AxisAlignedBB.getBoundingBox(par1.posX - (double)var1, par1.posY - (double)var1, par1.posZ - (double)var1, par1.posX + (double)var1, par1.posY + (double)var1, par1.posZ + (double)var1));
         Iterator var4 = entities.iterator();

         while(var4.hasNext()) {
            EntityPlayer player = (EntityPlayer)var4.next();
            if (!player.username.equals(par1.username)) {
               PacketDispatcher.sendPacketToPlayer(CDAPacketFTClient.buildPacket(par1), (Player)player);
            }
         }
      }

   }

   public void setHasFuel(ItemStack itemstack, boolean par2) {
      NBTTagCompound tag = this.getNBTTagCompound(itemstack);
      tag.setBoolean("ammo", par2);
   }

   public boolean hasFuel(ItemStack itemstack) {
      NBTTagCompound tag = this.getNBTTagCompound(itemstack);
      return tag.hasKey("ammo") ? tag.getBoolean("ammo") : false;
   }

   public boolean getShareTag() {
      return true;
   }

   @SideOnly(Side.CLIENT)
   public boolean isFull3D() {
      return true;
   }

   protected NBTTagCompound getNBTTagCompound(ItemStack itemstack) {
      String var1 = "thrower";
      if (itemstack.stackTagCompound == null) {
         itemstack.setTagCompound(new NBTTagCompound());
      }

      if (!itemstack.stackTagCompound.hasKey(var1)) {
         itemstack.stackTagCompound.setTag(var1, new NBTTagCompound(var1));
      }

      return (NBTTagCompound)itemstack.stackTagCompound.getTag(var1);
   }

   static {
      lastRightHeld = rightHeld;
   }
}
