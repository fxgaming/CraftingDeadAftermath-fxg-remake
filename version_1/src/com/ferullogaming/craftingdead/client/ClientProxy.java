package com.ferullogaming.craftingdead.client;

import com.ferullogaming.craftingdead.CommonProxy;
import com.ferullogaming.craftingdead.block.BlockManager;
import com.ferullogaming.craftingdead.block.TileEntityBaseCenter;
import com.ferullogaming.craftingdead.block.TileEntityCampfire;
import com.ferullogaming.craftingdead.block.TileEntityLoot;
import com.ferullogaming.craftingdead.block.TileEntitySandBarrier;
import com.ferullogaming.craftingdead.client.render.RenderBlockHandler;
import com.ferullogaming.craftingdead.client.render.RenderC4;
import com.ferullogaming.craftingdead.client.render.RenderCDZombie;
import com.ferullogaming.craftingdead.client.render.RenderCorpse;
import com.ferullogaming.craftingdead.client.render.RenderEntityHeadHitbox;
import com.ferullogaming.craftingdead.client.render.RenderFlameThrowerFire;
import com.ferullogaming.craftingdead.client.render.RenderGrenade;
import com.ferullogaming.craftingdead.client.render.RenderGrenadeFlash;
import com.ferullogaming.craftingdead.client.render.RenderGrenadeSmoke;
import com.ferullogaming.craftingdead.client.render.RenderGroundItem;
import com.ferullogaming.craftingdead.client.render.RenderLootcrate;
import com.ferullogaming.craftingdead.client.render.RenderSupplyDrop;
import com.ferullogaming.craftingdead.client.render.blocks.RenderTileEntityBaseCenter;
import com.ferullogaming.craftingdead.client.render.blocks.RenderTileEntityCampfire;
import com.ferullogaming.craftingdead.client.render.blocks.RenderTileEntityLoot;
import com.ferullogaming.craftingdead.client.render.blocks.RenderTileEntitySandBarrier;
import com.ferullogaming.craftingdead.entity.EntityC4;
import com.ferullogaming.craftingdead.entity.EntityCDZombie;
import com.ferullogaming.craftingdead.entity.EntityCorpse;
import com.ferullogaming.craftingdead.entity.EntityFlameThrowerFire;
import com.ferullogaming.craftingdead.entity.EntityGrenade;
import com.ferullogaming.craftingdead.entity.EntityGrenadeDecoy;
import com.ferullogaming.craftingdead.entity.EntityGrenadeFire;
import com.ferullogaming.craftingdead.entity.EntityGrenadeFlash;
import com.ferullogaming.craftingdead.entity.EntityGrenadePipeBomb;
import com.ferullogaming.craftingdead.entity.EntityGrenadeSmoke;
import com.ferullogaming.craftingdead.entity.EntityGroundItem;
import com.ferullogaming.craftingdead.entity.EntityPlayerHead;
import com.ferullogaming.craftingdead.entity.EntitySupplyDrop;
import com.ferullogaming.craftingdead.inventory.InventoryCDA;
import com.ferullogaming.craftingdead.item.ItemManager;

import api.player.model.ModelPlayerAPI;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends CommonProxy {
   private static InventoryCDA dummyCDAInventory = new InventoryCDA();

   public void initMod() {
      BlockManager.renderLootID = RenderingRegistry.getNextAvailableRenderId();
      BlockManager.renderBaseCenterID = RenderingRegistry.getNextAvailableRenderId();
      BlockManager.renderCampfireID = RenderingRegistry.getNextAvailableRenderId();
      BlockManager.renderSandBarrierID = RenderingRegistry.getNextAvailableRenderId();
      RenderBlockHandler handler = new RenderBlockHandler();
      RenderingRegistry.registerBlockHandler(BlockManager.renderLootID, handler);
      RenderingRegistry.registerBlockHandler(BlockManager.renderBaseCenterID, handler);
      RenderingRegistry.registerBlockHandler(BlockManager.renderCampfireID, handler);
      RenderingRegistry.registerBlockHandler(BlockManager.renderSandBarrierID, handler);
      MinecraftForgeClient.registerItemRenderer(ItemManager.lootcrateAlpha.itemID, new RenderLootcrate("alpha"));
      MinecraftForgeClient.registerItemRenderer(ItemManager.lootcrateBravo.itemID, new RenderLootcrate("bravo"));
      MinecraftForgeClient.registerItemRenderer(ItemManager.lootcrateCharlie.itemID, new RenderLootcrate("charlie"));
      ClientRegistry.bindTileEntitySpecialRenderer(TileEntityLoot.class, new RenderTileEntityLoot());
      ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBaseCenter.class, new RenderTileEntityBaseCenter());
      ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCampfire.class, new RenderTileEntityCampfire());
      ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySandBarrier.class, new RenderTileEntitySandBarrier());
      RenderingRegistry.registerEntityRenderingHandler(EntityCDZombie.class, new RenderCDZombie(new ModelBiped(), 0.4F));
      RenderingRegistry.registerEntityRenderingHandler(EntityGrenade.class, new RenderGrenade());
      RenderingRegistry.registerEntityRenderingHandler(EntityGrenadeFlash.class, new RenderGrenadeFlash());
      RenderingRegistry.registerEntityRenderingHandler(EntityGrenadeDecoy.class, new RenderGrenadeFlash("grenadedecoy"));
      RenderingRegistry.registerEntityRenderingHandler(EntityGrenadeSmoke.class, new RenderGrenadeSmoke());
      RenderingRegistry.registerEntityRenderingHandler(EntityGrenadeFire.class, new RenderGrenadeSmoke("grenadefire"));
      RenderingRegistry.registerEntityRenderingHandler(EntityGrenadePipeBomb.class, new RenderGrenadeSmoke("grenadepipe"));
      RenderingRegistry.registerEntityRenderingHandler(EntityC4.class, new RenderC4());
      RenderingRegistry.registerEntityRenderingHandler(EntityCorpse.class, new RenderCorpse());
      RenderingRegistry.registerEntityRenderingHandler(EntityPlayerHead.class, new RenderEntityHeadHitbox());
      RenderingRegistry.registerEntityRenderingHandler(EntityGroundItem.class, new RenderGroundItem());
      RenderingRegistry.registerEntityRenderingHandler(EntityFlameThrowerFire.class, new RenderFlameThrowerFire());
      RenderingRegistry.registerEntityRenderingHandler(EntitySupplyDrop.class, new RenderSupplyDrop());
      RenderingRegistry.registerEntityRenderingHandler(EntityPlayer.class, new ClientRenderPlayer());
      ModelPlayerAPI.register("CraftingDeadAftermath", ClientModelPlayer.class);
   }

   public static InventoryCDA getDummyCDInventory() {
      return dummyCDAInventory;
   }

   public int addArmor(String armor) {
      return RenderingRegistry.addNewArmourRendererPrefix(armor);
   }
}
