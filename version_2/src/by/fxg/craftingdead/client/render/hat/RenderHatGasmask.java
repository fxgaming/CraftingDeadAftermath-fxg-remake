package by.fxg.craftingdead.client.render.hat;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import org.lwjgl.opengl.GL11;

import by.fxg.craftingdead.client.model.hats.ModelHatGasmask;

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
