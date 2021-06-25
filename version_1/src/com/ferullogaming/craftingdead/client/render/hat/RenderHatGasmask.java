package com.ferullogaming.craftingdead.client.render.hat;

import com.ferullogaming.craftingdead.client.model.hats.ModelHatGasmask;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import org.lwjgl.opengl.GL11;

public class RenderHatGasmask extends RenderHat {
   public RenderHatGasmask() {
      super.hatModel = new ModelHatGasmask();
      super.texture = "gasmask";
   }

   public void renderHat(EntityPlayer par1, ItemStack par2) {
      double scale = 0.1D;
      GL11.glScaled(scale, scale, scale);
      GL11.glTranslated(-2.8D, -5.1D, -3.0D);
      this.bindTexture();
      this.renderModel(par1);
   }
}
