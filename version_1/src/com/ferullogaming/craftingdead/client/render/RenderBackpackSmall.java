package com.ferullogaming.craftingdead.client.render;

import org.lwjgl.opengl.GL11;

import com.ferullogaming.craftingdead.CDAftermath;
import com.ferullogaming.craftingdead.client.model.ModelBush;
import com.ferullogaming.craftingdead.inventory.InventoryCDA;
import com.ferullogaming.craftingdead.player.PlayerData;

import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class RenderBackpackSmall extends RenderBackpack {
   public RenderBackpackSmall(String par1, ModelBase par2) {
      super(par1, par2);
   }

   public void renderBackpack(EntityPlayer par1, ItemStack par2) {
      PlayerData data = CDAftermath.instance.playerDataHandler().getPlayerData(par1.username);
      InventoryCDA inv = data.getCDInventory();
      ItemStack stack = inv.getStack("upgrade");
      double scale = 1.0D;
      GL11.glScaled(scale, scale, scale);
      GL11.glTranslated(-0.03D, 0.22D, 0.3D);
      GL11.glRotated(180.0D, 1.0D, 0.0D, 0.0D);
      GL11.glRotated(180.0D, 0.0D, 0.0D, 1.0D);
      super.model.render(par1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
      if (stack != null) {
          GL11.glPushMatrix();
          GL11.glTranslatef(-0.23f, -0.25f, -0.08f);
          GL11.glScalef(1.1f, 1.1f, 1.6f);
          ((ModelBush)bush).renderSmall(0.0625f);
          GL11.glTranslatef(0.0f, 0.3f, 0.05f);
          ((ModelBush)bush).renderMedium(0.0625f);
          GL11.glTranslatef(0.0f, -0.3f, -0.05f);
          GL11.glPopMatrix();
      }
   }
}
