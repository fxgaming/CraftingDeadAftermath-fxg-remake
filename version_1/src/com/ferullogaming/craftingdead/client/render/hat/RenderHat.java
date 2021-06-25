package com.ferullogaming.craftingdead.client.render.hat;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public abstract class RenderHat {
   public ModelBase hatModel;
   public String texture;

   public abstract void renderHat(EntityPlayer var1, ItemStack var2);

   public void bindTexture() {
      Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("craftingdead:textures/models/hats/hat_" + this.texture + ".png"));
   }

   public void renderModel(EntityPlayer par1) {
      this.hatModel.render(par1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.625F);
   }
}
