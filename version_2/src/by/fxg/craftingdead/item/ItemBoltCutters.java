package by.fxg.craftingdead.item;

import by.fxg.craftingdead.CDReloaded;
import by.fxg.craftingdead.player.PlayerData;
import by.fxg.craftingdead.player.PlayerDataHandler;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

public class ItemBoltCutters extends ItemMeleeWeapon {
   private int damageToHandcuffs = 0;

   public ItemBoltCutters(int par1, int par2, int par3) {
      super(par1, par2, par3);
      this.addInformation("Нажмите ПКМ, что-бы сломать наручники!");
   }

   public boolean itemInteractionForEntity(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, EntityLivingBase par3EntityLivingBase) {
      World world = par2EntityPlayer.worldObj;
      if (!world.isRemote && par3EntityLivingBase instanceof EntityPlayer) {
         EntityPlayer playerHit = (EntityPlayer)par3EntityLivingBase;
         PlayerData playerHitData = CDReloaded.instance.playerDataHandler().getPlayerData(playerHit);
         if (playerHitData.isHandCuffed) {
            int var1 = playerHitData.handcuffDamage;
            int var2 = 200;
            if (var1 + this.damageToHandcuffs >= var2) {
               playerHit.sendChatToPlayer(ChatMessageComponent.createFromText(EnumChatFormatting.RED + "Ваши наручники были сняты игроком " + par2EntityPlayer.getDisplayName()));
               playerHit.playSound("random.break", 0.2F, 0.5F);
               playerHitData.isHandCuffed = false;
               playerHitData.handcuffDamage = 0;
            } else {
               playerHit.playSound("random.break", 0.2F, 0.5F);
               playerHitData.handcuffDamage += this.damageToHandcuffs;
            }

            par1ItemStack.damageItem(1, par2EntityPlayer);
         }
      }

      return false;
   }

   public ItemBoltCutters setCuttingDamage(int par1) {
      this.damageToHandcuffs = par1;
      return this;
   }
}
