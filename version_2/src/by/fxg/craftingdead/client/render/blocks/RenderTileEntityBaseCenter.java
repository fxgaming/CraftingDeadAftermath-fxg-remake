package by.fxg.craftingdead.client.render.blocks;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelSkeletonHead;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

import by.fxg.craftingdead.block.TileEntityBaseCenter;
import by.fxg.craftingdead.block.TileEntityLoot;
import by.fxg.craftingdead.client.model.ModelBaseCenter;
import by.fxg.craftingdead.item.ItemManager;

public class RenderTileEntityBaseCenter extends TileEntitySpecialRenderer {
   private ModelBaseCenter model = new ModelBaseCenter();
   private ModelSkeletonHead modelSkull = new ModelSkeletonHead(0, 0, 64, 32);

   public void renderTileEntityBaseFlag(TileEntityBaseCenter tile, double d, double d1, double d2, float f) {
      this.bindTexture(new ResourceLocation("craftingdead:textures/models/basecenter.png"));
      GL11.glPushMatrix();
      GL11.glTranslatef((float)d + 0.5F, (float)d1 + 1.5F, (float)d2 + 0.5F);
      GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
      GL11.glScalef(1.0F, -1.0F, -1.0F);
      this.model.render((Entity)null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
      GL11.glPopMatrix();
      String owner = tile.getFlagOwner();
      if (owner != null) {
         this.renderPlayerHead(owner, d, d1 + 1.0D, d2 + 0.1D);
         GL11.glPushMatrix();
         GL11.glTranslatef((float)d + 0.25F, (float)d1 + 1.05F, (float)d2 - 0.3F);
         GL11.glRotatef(-90.0F, 1.0F, 0.0F, 0.0F);
         GL11.glPopMatrix();
      }

   }

   public void renderTileEntityLootItemStack(TileEntityLoot tile, double d, double d1, double d2, float f, ItemStack itemstack) {
      GL11.glPushMatrix();
      GL11.glTranslatef((float)d, (float)d1 + 0.05F, (float)d2);
      double scale = 1.0D;
      GL11.glScaled(scale, scale, scale);
      GL11.glRotatef(-90.0F, 1.0F, 0.0F, 0.0F);
      this.renderDroppedItem(itemstack, 0.0F, 0.0F, 0.0F);
      GL11.glPopMatrix();
   }

   private void renderDroppedItem(ItemStack itemstack, float par5, float par6, float par7) {
      Tessellator tessellator = Tessellator.instance;
      Icon par2Icon = itemstack.getItem().getIcon(itemstack, 0);
      if (par2Icon == null) {
         TextureManager texturemanager = Minecraft.getMinecraft().getTextureManager();
         ResourceLocation resourcelocation = texturemanager.getResourceLocation(itemstack.getItemSpriteNumber());
         par2Icon = ((TextureMap)texturemanager.getTexture(resourcelocation)).getAtlasSprite("missingno");
      }

      float f4 = ((Icon)par2Icon).getMinU();
      float f5 = ((Icon)par2Icon).getMaxU();
      float f6 = ((Icon)par2Icon).getMinV();
      float f7 = ((Icon)par2Icon).getMaxV();
      float f8 = 1.0F;
      float f9 = 0.5F;
      float f10 = 0.25F;
      if (itemstack != null) {
         if (itemstack.getItemSpriteNumber() == 0) {
            this.bindTexture(TextureMap.locationBlocksTexture);
         } else {
            this.bindTexture(TextureMap.locationItemsTexture);
         }

         GL11.glPushMatrix();
         float f12 = 0.0625F;
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         double scale = 0.6D;
         GL11.glScaled(scale, scale, scale);
         GL11.glTranslatef(0.3F, -1.3F, 0.0F);
         ItemRenderer.renderItemIn2D(tessellator, f5, f6, f4, f7, ((Icon)par2Icon).getIconWidth(), ((Icon)par2Icon).getIconHeight(), f12);
         GL11.glPopMatrix();
      }

   }

   public void renderPlayerHead(String par1, double par2, double par3, double par4) {
      ModelSkeletonHead modelskeletonhead = this.modelSkull;
      ResourceLocation resourcelocation = AbstractClientPlayer.locationStevePng;
      if (par1 != null && par1.length() > 0) {
         resourcelocation = AbstractClientPlayer.getLocationSkull(par1);
         AbstractClientPlayer.getDownloadImageSkin(resourcelocation, par1);
      }

      this.bindTexture(resourcelocation);
      GL11.glPushMatrix();
      GL11.glDisable(2884);
      GL11.glTranslated(par2 + 0.30000001192092896D, par3, par4 + 0.5D);
      float f4 = 0.0625F;
      GL11.glEnable(32826);
      GL11.glScalef(-1.0F, -1.0F, 1.0F);
      GL11.glEnable(3008);
      GL11.glRotated(45.0D, 0.0D, 1.0D, 0.0D);
      double scale = 0.8D;
      GL11.glScaled(scale, scale, scale);
      modelskeletonhead.render((Entity)null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, f4);
      GL11.glPopMatrix();
   }

   public void renderTileEntityAt(TileEntity tileentity, double d, double d1, double d2, float f) {
      this.renderTileEntityBaseFlag((TileEntityBaseCenter)tileentity, d, d1, d2, f);
   }
}
