package by.fxg.craftingdead.entity;

import by.fxg.craftingdead.CDReloaded;
import by.fxg.craftingdead.client.RenderTickHandler;
import by.fxg.craftingdead.world.WorldManager;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.entity.EnumCreatureType;

public class EntityManager {
   public void init() {
      EntityRegistry.registerGlobalEntityID(EntityCDZombie.class, "cdzombie", 80, 0, 16777215);
      EntityRegistry.addSpawn(EntityCDZombie.class, 10, 2, 2, EnumCreatureType.monster, WorldManager.craftingDeadBiomes);
      EntityRegistry.registerModEntity(EntityGrenade.class, "grenade", 81, CDReloaded.instance, 48, 20, true);
      EntityRegistry.registerModEntity(EntityGrenadeFlash.class, "grenadeflash", 82, CDReloaded.instance, 48, 20, true);
      EntityRegistry.registerModEntity(EntityGrenadeDecoy.class, "grenadedecoy", 83, CDReloaded.instance, 48, 20, true);
      EntityRegistry.registerModEntity(EntityGrenadeSmoke.class, "grenadesmoke", 84, CDReloaded.instance, 48, 20, true);
      EntityRegistry.registerModEntity(EntityGrenadeFire.class, "grenadefire", 85, CDReloaded.instance, 48, 20, true);
      EntityRegistry.registerModEntity(EntityCorpse.class, "corpse", 86, CDReloaded.instance, 48, 20, true);
      EntityRegistry.registerModEntity(EntityGroundItem.class, "grounditem", 87, CDReloaded.instance, 48, 20, true);
      EntityRegistry.registerModEntity(EntityPlayerHead.class, "head", 88, CDReloaded.instance, 48, 20, true);
      EntityRegistry.registerModEntity(EntityGrenadePipeBomb.class, "grenadepipebomb", 89, CDReloaded.instance, 48, 20, true);
      EntityRegistry.registerModEntity(EntityC4.class, "c4", 90, CDReloaded.instance, 48, 20, true);
      EntityRegistry.registerModEntity(EntityFlameThrowerFire.class, "flamethrowerfire", 91, CDReloaded.instance, 48, 20, true);
      EntityRegistry.registerModEntity(EntitySupplyDrop.class, "supplydrop", 92, CDReloaded.instance, 72, 20, true);
      LanguageRegistry.instance().addStringLocalization("entity.cdzombie.name", "CD Zombie");
   }

   public static void spawnParticle(String par1Str, double par2, double par4, double par6, double par8, double par10, double par12) {
      if (FMLCommonHandler.instance().getSide() == Side.CLIENT && CDReloaded.instance.getClientManager() != null && CDReloaded.instance.getClientManager().getClientTickHandler() != null) {
         RenderTickHandler.spawnParticle(par1Str, par2, par4, par6, par8, par10, par12);
      }

   }
}
