package by.fxg.craftingdead.item;

import java.util.ArrayList;

import by.fxg.craftingdead.entity.EntityC4;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

public class ItemC4Detonator extends ItemCD {
   private int c4Radius = 50;

   public ItemC4Detonator(int par1) {
      super(par1);
      this.addInformation(EnumChatFormatting.RED + "Нажмите ПКМ" + EnumChatFormatting.GRAY + " что-бы взорвать все C4");
      this.addInformation("в радиусе " + this.c4Radius + " блоков от вас!");
   }

   public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
      if (!par2World.isRemote) {
         par2World.playSoundAtEntity(par3EntityPlayer, "random.click", 0.8F, 1.2F);
         ArrayList entities = (ArrayList)par2World.getEntitiesWithinAABB(EntityC4.class, AxisAlignedBB.getBoundingBox(par3EntityPlayer.posX - (double)this.c4Radius, par3EntityPlayer.posY - (double)this.c4Radius, par3EntityPlayer.posZ - (double)this.c4Radius, par3EntityPlayer.posX + (double)this.c4Radius, par3EntityPlayer.posY + (double)this.c4Radius, par3EntityPlayer.posZ + (double)this.c4Radius));
         if (entities.size() > 0) {
            for(int i = 0; i < entities.size(); ++i) {
               EntityC4 c4 = (EntityC4)entities.get(i);
               c4.setOffC4(par3EntityPlayer);
            }
         }
      }

      return par1ItemStack;
   }
}
