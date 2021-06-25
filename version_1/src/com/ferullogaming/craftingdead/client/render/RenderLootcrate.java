package com.ferullogaming.craftingdead.client.render;

import com.ferullogaming.craftingdead.client.model.ModelCrate;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.client.IItemRenderer.ItemRenderType;
import net.minecraftforge.client.IItemRenderer.ItemRendererHelper;
import org.lwjgl.opengl.GL11;

public class RenderLootcrate implements IItemRenderer {
   private ResourceLocation res;
   private ModelCrate model = new ModelCrate();

   public RenderLootcrate(String par1) {
      this.res = new ResourceLocation("craftingdead:textures/models/crates/" + par1 + ".png");
   }

   public boolean handleRenderType(ItemStack item, ItemRenderType type) {
      return type != ItemRenderType.FIRST_PERSON_MAP;
   }

   public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
      return true;
   }

   public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
      Minecraft mc = Minecraft.getMinecraft();
      mc.getTextureManager().bindTexture(this.res);
      if (type == ItemRenderType.EQUIPPED) {
         EntityPlayer entityplayer = (EntityPlayer)data[1];
         GL11.glPushMatrix();
         double scale = 1.6D;
         GL11.glScaled(scale, scale, scale);
         GL11.glRotated(180.0D, 0.0D, 0.0D, 1.0D);
         GL11.glRotated(180.0D, 0.0D, 1.0D, 0.0D);
         GL11.glTranslated(0.1D, -0.5D, -0.2D);
         this.model.render(entityplayer, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
         GL11.glPopMatrix();
      } else {
         double scale;
         if (type == ItemRenderType.INVENTORY) {
            GL11.glPushMatrix();
            scale = 1.6D;
            GL11.glScaled(scale, scale, scale);
            GL11.glRotated(180.0D, 0.0D, 0.0D, 1.0D);
            GL11.glRotated(180.0D, 0.0D, 1.0D, 0.0D);
            GL11.glTranslated(0.0D, -0.2D, 0.0D);
            this.model.render((Entity)null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
            GL11.glPopMatrix();
         } else if (type == ItemRenderType.EQUIPPED_FIRST_PERSON) {
            GL11.glPushMatrix();
            scale = 1.6D;
            GL11.glScaled(scale, scale, scale);
            GL11.glRotated(180.0D, 0.0D, 0.0D, 1.0D);
            GL11.glRotated(300.0D, 0.0D, 1.0D, 0.0D);
            GL11.glTranslated(0.1D, -0.8D, 0.1D);
            this.model.render((Entity)null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
            GL11.glPopMatrix();
         } else if (type == ItemRenderType.ENTITY) {
            GL11.glPushMatrix();
            scale = 0.8D;
            GL11.glScaled(scale, scale, scale);
            GL11.glRotated(180.0D, 0.0D, 0.0D, 1.0D);
            GL11.glTranslated(-0.1D, -0.38D, -0.1D);
            this.model.render((Entity)null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
            GL11.glPopMatrix();
         }
      }

   }

   public static RenderLootcrate getRenderCase(ItemStack par1) {
      return (RenderLootcrate)MinecraftForgeClient.getItemRenderer(par1, (ItemRenderType)null);
   }

   public void renderCaseDisplayed(ItemStack par1ItemStack, double posx, double posy, double scale, boolean tilted, double rotation) {
      Minecraft mc = Minecraft.getMinecraft();
      mc.getTextureManager().bindTexture(this.res);
      GL11.glPushMatrix();
      GL11.glDisable(2884);
      GL11.glEnable(2929);
      GL11.glTranslated(posx + scale / 2.0D, posy + scale / 2.0D, 0.0D);
      GL11.glScaled(scale, -scale, scale);
      GL11.glRotated(180.0D, 0.0D, 1.0D, 0.0D);
      GL11.glRotated(180.0D, 0.0D, 0.0D, 1.0D);
      GL11.glTranslated(0.5D, -0.6D, 0.0D);
      GL11.glRotated(15.0D, 1.0D, 0.0D, 0.0D);
      GL11.glRotated(-35.0D, 0.0D, -1.0D, 0.0D);
      double scale2 = 1.5D;
      GL11.glScaled(scale2, scale2, scale2);
      GL11.glRotated(-rotation, 0.0D, 1.0D, 0.0D);
      this.model.render((Entity)null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
      GL11.glDisable(2929);
      GL11.glEnable(2884);
      GL11.glPopMatrix();
   }
}
