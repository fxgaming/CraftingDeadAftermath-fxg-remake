package com.ferullogaming.craftingdead.client.render;

import com.ferullogaming.craftingdead.block.BlockLoot;
import com.ferullogaming.craftingdead.block.BlockManager;
import com.ferullogaming.craftingdead.block.TileEntityBaseCenter;
import com.ferullogaming.craftingdead.block.TileEntityCampfire;
import com.ferullogaming.craftingdead.block.TileEntityLoot;
import com.ferullogaming.craftingdead.block.TileEntitySandBarrier;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.world.IBlockAccess;

public class RenderBlockHandler implements ISimpleBlockRenderingHandler {
   public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer) {
      if (modelID == BlockManager.renderLootID) {
         TileEntityLoot entity = new TileEntityLoot(((BlockLoot)block).getLootType());
         entity.isInventory = true;
         TileEntityRenderer.instance.renderTileEntityAt(entity, 0.0D, 0.0D, 0.0D, 0.0F);
      }

      if (modelID == BlockManager.renderBaseCenterID) {
         TileEntityBaseCenter entity = new TileEntityBaseCenter();
         TileEntityRenderer.instance.renderTileEntityAt(entity, 0.0D, 0.0D, 0.0D, 0.0F);
      }

      if (modelID == BlockManager.renderCampfireID) {
         TileEntityCampfire entity = new TileEntityCampfire();
         TileEntityRenderer.instance.renderTileEntityAt(entity, 0.0D, 0.0D, 0.0D, 0.0F);
      }

      if (modelID == BlockManager.renderSandBarrierID) {
         TileEntitySandBarrier entity = new TileEntitySandBarrier();
         TileEntityRenderer.instance.renderTileEntityAt(entity, 0.0D, 0.0D, 0.0D, 0.0F);
      }

   }

   public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
      return true;
   }

   public boolean shouldRender3DInInventory() {
      return true;
   }

   public int getRenderId() {
      return 0;
   }
}
