package by.fxg.craftingdead.client;

import api.player.model.ModelPlayerAPI;
import by.fxg.craftingdead.CommonProxy;
import by.fxg.craftingdead.block.BlockManager;
import by.fxg.craftingdead.block.TileEntityBaseCenter;
import by.fxg.craftingdead.block.TileEntityCampfire;
import by.fxg.craftingdead.block.TileEntityLoot;
import by.fxg.craftingdead.block.TileEntitySandBarrier;
import by.fxg.craftingdead.client.render.RenderBlockHandler;
import by.fxg.craftingdead.client.render.RenderC4;
import by.fxg.craftingdead.client.render.RenderCDZombie;
import by.fxg.craftingdead.client.render.RenderCorpse;
import by.fxg.craftingdead.client.render.RenderEntityHeadHitbox;
import by.fxg.craftingdead.client.render.RenderFlameThrowerFire;
import by.fxg.craftingdead.client.render.RenderGrenade;
import by.fxg.craftingdead.client.render.RenderGrenadeFlash;
import by.fxg.craftingdead.client.render.RenderGrenadeSmoke;
import by.fxg.craftingdead.client.render.RenderGroundItem;
import by.fxg.craftingdead.client.render.RenderLootcrate;
import by.fxg.craftingdead.client.render.RenderSupplyDrop;
import by.fxg.craftingdead.client.render.blocks.RenderTileEntityBaseCenter;
import by.fxg.craftingdead.client.render.blocks.RenderTileEntityCampfire;
import by.fxg.craftingdead.client.render.blocks.RenderTileEntityLoot;
import by.fxg.craftingdead.client.render.blocks.RenderTileEntitySandBarrier;
import by.fxg.craftingdead.entity.EntityC4;
import by.fxg.craftingdead.entity.EntityCDZombie;
import by.fxg.craftingdead.entity.EntityCorpse;
import by.fxg.craftingdead.entity.EntityFlameThrowerFire;
import by.fxg.craftingdead.entity.EntityGrenade;
import by.fxg.craftingdead.entity.EntityGrenadeDecoy;
import by.fxg.craftingdead.entity.EntityGrenadeFire;
import by.fxg.craftingdead.entity.EntityGrenadeFlash;
import by.fxg.craftingdead.entity.EntityGrenadePipeBomb;
import by.fxg.craftingdead.entity.EntityGrenadeSmoke;
import by.fxg.craftingdead.entity.EntityGroundItem;
import by.fxg.craftingdead.entity.EntityPlayerHead;
import by.fxg.craftingdead.entity.EntitySupplyDrop;
import by.fxg.craftingdead.inventory.InventoryCDA;
import by.fxg.craftingdead.item.ItemManager;
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
