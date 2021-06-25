package com.ferullogaming.craftingdead.client.render.hat;

import com.ferullogaming.craftingdead.client.model.hats.ModelHatPayday;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import org.lwjgl.opengl.GL11;

public class RenderHatPayday extends RenderHat {
   public RenderHatPayday(String par1) {
      super.hatModel = new ModelHatPayday();
      super.texture = par1;
   }

   public void renderHat(EntityPlayer par1, ItemStack par2) {
      double scale = 0.1D;
      GL11.glScaled(scale, scale, scale);
      GL11.glTranslated(0.0D, -2.0D, -3.0D);
      this.bindTexture();
      this.renderModel(par1);
   }
}
