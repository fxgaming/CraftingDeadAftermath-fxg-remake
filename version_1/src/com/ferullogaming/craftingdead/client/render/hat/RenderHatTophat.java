package com.ferullogaming.craftingdead.client.render.hat;

import com.ferullogaming.craftingdead.client.model.hats.ModelHatTophat;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import org.lwjgl.opengl.GL11;

public class RenderHatTophat extends RenderHat {
   public RenderHatTophat() {
      super.hatModel = new ModelHatTophat();
      super.texture = "tophat";
   }

   public void renderHat(EntityPlayer par1, ItemStack par2) {
      double scale = 0.1D;
      GL11.glScaled(scale, scale, scale);
      GL11.glTranslated(0.0D, -7.0D, 0.0D);
      this.bindTexture();
      this.renderModel(par1);
   }
}
