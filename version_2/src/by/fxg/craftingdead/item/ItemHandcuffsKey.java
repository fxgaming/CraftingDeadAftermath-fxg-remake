package by.fxg.craftingdead.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;

import by.fxg.craftingdead.CDReloaded;
import by.fxg.craftingdead.player.PlayerData;
import by.fxg.craftingdead.player.PlayerDataHandler;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

public class ItemHandcuffsKey extends ItemCD {
   public ItemHandcuffsKey(int par1) {
      super(par1);
      this.addInformation("Нажмите ПКМ по игроку!");
   }

   public boolean itemInteractionForEntity(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, EntityLivingBase par3EntityLivingBase) {
      World world = par2EntityPlayer.worldObj;
      if (!world.isRemote && par3EntityLivingBase instanceof EntityPlayer) {
         EntityPlayer playerHit = (EntityPlayer)par3EntityLivingBase;
         PlayerData playerHitData = CDReloaded.instance.playerDataHandler().getPlayerData(playerHit);
         if (playerHitData.isHandCuffed) {
            playerHitData.isHandCuffed = false;
            playerHit.sendChatToPlayer(ChatMessageComponent.createFromText(EnumChatFormatting.RED + "Наручники были сняты!"));
            ItemStack itemstack1 = new ItemStack(ItemManager.handcuffs);
            if (!par2EntityPlayer.inventory.addItemStackToInventory(itemstack1)) {
               itemstack1.setItemDamage(playerHitData.handcuffDamage);
               playerHit.dropPlayerItem(itemstack1);
            } else {
               Random rand = new Random();
               playerHit.playSound("random.pop", 0.2F, ((rand.nextFloat() - rand.nextFloat()) * 0.7F + 1.0F) * 2.0F);
            }

            playerHitData.handcuffDamage = 0;
         }
      }

      return false;
   }

   @SideOnly(Side.CLIENT)
   public boolean isFull3D() {
      return false;
   }
}
