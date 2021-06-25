package com.ferullogaming.craftingdead.item;

import com.ferullogaming.craftingdead.CDAftermath;
import com.ferullogaming.craftingdead.events.EventThirstQuenched;
import com.ferullogaming.craftingdead.item.potion.PotionManager;
import com.ferullogaming.craftingdead.player.PlayerData;
import com.ferullogaming.craftingdead.player.PlayerDataHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;

public class ItemConsumable extends ItemCD {
   public boolean isDrinkable = false;
   public int waterHeal = 0;
   public boolean isEdable = false;
   public int feedHeal = 0;
   public boolean isBloodRestored = false;
   public int bloodHeal = 0;
   public boolean stopsBleeding = false;
   public boolean stopsInfection = false;
   public boolean stopsBrokenLeg = false;
   public boolean addsAdrenaline = false;
   public int returnItemID = 0;
   public EnumAction animationType;

   public ItemConsumable(int par1) {
      super(par1);
      this.animationType = EnumAction.eat;
   }

   public ItemStack onEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
      PlayerData playerData = CDAftermath.instance.playerDataHandler().getPlayerData(par3EntityPlayer);
      if (this.isDrinkable && playerData.getWaterLevels().needsWater()) {
         if (!par2World.isRemote) {
            EventThirstQuenched event = new EventThirstQuenched(par3EntityPlayer, par1ItemStack, playerData.getWaterLevels().getWaterLevelsScaled(), this.waterHeal);
            if (MinecraftForge.EVENT_BUS.post(event)) {
               return par1ItemStack;
            }
         }

         playerData.getWaterLevels().addWaterLevels(this.waterHeal);
      }

      if (this.isEdable && par3EntityPlayer.getFoodStats().needFood()) {
         par3EntityPlayer.getFoodStats().addStats(this.feedHeal, (float)this.feedHeal);
      }

      if (this.isBloodRestored && par3EntityPlayer.getHealth() < 20.0F) {
         par3EntityPlayer.heal((float)this.bloodHeal);
      }

      if (this.stopsBleeding && par3EntityPlayer.isPotionActive(PotionManager.bleeding.id)) {
         par3EntityPlayer.removePotionEffect(PotionManager.bleeding.id);
      }

      if (this.stopsInfection && par3EntityPlayer.isPotionActive(PotionManager.RBInfection.id)) {
         par3EntityPlayer.removePotionEffect(PotionManager.RBInfection.id);
      }

      if (this.stopsBrokenLeg && par3EntityPlayer.isPotionActive(PotionManager.brokenLeg.id)) {
         par3EntityPlayer.removePotionEffect(PotionManager.brokenLeg.id);
      }

      if (this.addsAdrenaline) {
         par3EntityPlayer.addPotionEffect(new PotionEffect(PotionManager.adrenaline.id, 400));
      }

      if (this.returnItemID != 0) {
         return new ItemStack(this.returnItemID, 1, 0);
      } else {
         --par1ItemStack.stackSize;
         return par1ItemStack;
      }
   }

   public int getMaxItemUseDuration(ItemStack par1ItemStack) {
      return 32;
   }

   public EnumAction getItemUseAction(ItemStack par1ItemStack) {
      return this.animationType;
   }

   public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
      PlayerData playerData = CDAftermath.instance.playerDataHandler().getPlayerData(par3EntityPlayer);
      if (this.isDrinkable && playerData.getWaterLevels().needsWater()) {
         par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
         return par1ItemStack;
      } else if (this.isEdable && par3EntityPlayer.getFoodStats().needFood()) {
         par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
         return par1ItemStack;
      } else if (this.isBloodRestored && par3EntityPlayer.getHealth() < 20.0F) {
         par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
         return par1ItemStack;
      } else if (this.stopsBleeding && par3EntityPlayer.isPotionActive(PotionManager.bleeding.id)) {
         par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
         return par1ItemStack;
      } else if (this.stopsInfection && par3EntityPlayer.isPotionActive(PotionManager.RBInfection.id)) {
         par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
         return par1ItemStack;
      } else if (this.stopsBrokenLeg && par3EntityPlayer.isPotionActive(PotionManager.brokenLeg.id)) {
         par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
         return par1ItemStack;
      } else if (this.addsAdrenaline) {
         par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
         return par1ItemStack;
      } else {
         return par1ItemStack;
      }
   }

   public ItemConsumable setDrinkable(int par1) {
      this.isDrinkable = true;
      this.waterHeal = par1;
      return this;
   }

   public ItemConsumable setEdible(int par1) {
      this.isEdable = true;
      this.feedHeal = par1;
      return this;
   }

   public ItemConsumable setBloodRestoreable(int par1) {
      this.isBloodRestored = true;
      this.bloodHeal = par1;
      return this;
   }

   public ItemConsumable setStopsBleeding() {
      this.stopsBleeding = true;
      return this;
   }

   public ItemConsumable setCuresInfection() {
      this.stopsInfection = true;
      return this;
   }

   public ItemConsumable setBrokenLegFixed() {
      this.stopsBrokenLeg = true;
      return this;
   }

   public ItemConsumable setAnimation(EnumAction par1Action) {
      this.animationType = par1Action;
      return this;
   }

   public ItemConsumable setReturnItem(int par1) {
      this.returnItemID = par1;
      return this;
   }

   public ItemConsumable addAdrenalineFactor() {
      this.addsAdrenaline = true;
      return this;
   }

   @SideOnly(Side.CLIENT)
   public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
      super.addInformation(par1ItemStack, par2EntityPlayer, par3List, par4);
      if (this.feedHeal != 0) {
         par3List.add("Питательность " + EnumChatFormatting.RED + this.feedHeal);
      }

      if (this.waterHeal != 0) {
         par3List.add("Утоление жажды " + EnumChatFormatting.RED + (this.waterHeal));
      }

      if (this.bloodHeal != 0) {
         par3List.add("Восполнение здоровья " + EnumChatFormatting.RED + this.bloodHeal);
      }

      if (this.stopsBleeding) {
         par3List.add("Останавливает кровотечение");
      }

      if (this.stopsInfection) {
         par3List.add("Излечивает инфекцию RBI");
      }

      if (this.stopsBrokenLeg) {
         par3List.add("Чинит сломанные ноги");
      }

      if (this.addsAdrenaline) {
         par3List.add("Увеличивает адреналин");
      }

   }
}
