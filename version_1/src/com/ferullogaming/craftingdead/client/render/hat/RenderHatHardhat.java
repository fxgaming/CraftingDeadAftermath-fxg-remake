package com.ferullogaming.craftingdead.client.render.hat;

import com.ferullogaming.craftingdead.client.model.hats.ModelHatHardhat;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import org.lwjgl.opengl.GL11;

public class RenderHatHardhat extends RenderHat {
   public RenderHatHardhat(String par1) {
      super.hatModel = new ModelHatHardhat();
      super.texture = par1;
   }

   public void renderHat(EntityPlayer par1, ItemStack par2) {
      double scale = 0.1D;
      GL11.glScaled(scale, scale, scale);
      GL11.glTranslated(-0.25D, -3.0D, -0.25D);
      this.bindTexture();
      this.renderModel(par1);
   }
}
