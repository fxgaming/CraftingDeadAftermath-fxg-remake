package com.ferullogaming.craftingdead.client.render.blocks;

import com.ferullogaming.craftingdead.block.TileEntityLoot;
import com.ferullogaming.craftingdead.client.model.ModelLoot;
import com.ferullogaming.craftingdead.client.model.ModelLootPresent;
import com.ferullogaming.craftingdead.client.util.ClientManager;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderTileEntityLoot extends TileEntitySpecialRenderer {
   private ModelLoot model = new ModelLoot();
   private ModelLootPresent modelPresent = new ModelLootPresent();

   public void renderTileEntityLoot(TileEntityLoot tile, double d, double d1, double d2, float f) {
      if (false) {
         this.bindTexture(new ResourceLocation("craftingdead:textures/models/loot/presents/" + tile.getTextureName() + ".png"));
         GL11.glPushMatrix();
         GL11.glTranslatef((float)d + 0.5F, (float)d1 + 1.5F, (float)d2 + 0.5F);
         GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
         GL11.glScalef(1.0F, -1.0F, -1.0F);
         this.modelPresent.render(0.0625F);
         GL11.glPopMatrix();
      } else if (tile.getItemStack() != null && !tile.isInventory) {
         this.renderTileEntityLootItemStack(tile, d, d1, d2, f, tile.getItemStack());
      } else {
         this.bindTexture(new ResourceLocation("craftingdead:textures/models/loot/" + tile.getTextureName() + ".png"));
         GL11.glPushMatrix();
         GL11.glTranslatef((float)d + 0.5F, (float)d1 + 1.5F, (float)d2 + 0.5F);
         GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
         GL11.glScalef(1.0F, -1.0F, -1.0F);
         this.model.render(0.0625F);
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

   public void renderTileEntityAt(TileEntity tileentity, double d, double d1, double d2, float f) {
      this.renderTileEntityLoot((TileEntityLoot)tileentity, d, d1, d2, f);
   }
}
