package com.ferullogaming.craftingdead.client;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;

import org.lwjgl.opengl.GL11;

import com.ferullogaming.craftingdead.CDAftermath;
import com.ferullogaming.craftingdead.client.render.RenderPlayerEvents;
import com.ferullogaming.craftingdead.client.util.ClientManager;
import com.ferullogaming.craftingdead.item.ItemFlameThrower;
import com.ferullogaming.craftingdead.item.ItemManager;
import com.ferullogaming.craftingdead.item.gun.EnumFireMode;
import com.ferullogaming.craftingdead.item.gun.GunAttachment;
import com.ferullogaming.craftingdead.item.gun.ItemAmmo;
import com.ferullogaming.craftingdead.item.gun.ItemGun;
import com.ferullogaming.craftingdead.player.PlayerData;
import com.ferullogaming.craftingdead.player.PlayerDataHandler;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.ObfuscationReflectionHelper;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiIngameMenu;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.particle.EntityBreakingFX;
import net.minecraft.client.particle.EntityCloudFX;
import net.minecraft.client.particle.EntityDiggingFX;
import net.minecraft.client.particle.EntityExplodeFX;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.particle.EntityFlameFX;
import net.minecraft.client.particle.EntityHugeExplodeFX;
import net.minecraft.client.particle.EntityLargeExplodeFX;
import net.minecraft.client.particle.EntitySmokeFX;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.client.GuiIngameForge;

public class RenderTickHandler {
   private Minecraft mc = Minecraft.getMinecraft();
   private World theWorld;
   private ResourceLocation icons = new ResourceLocation("craftingdead:textures/gui/icon.png");
   public boolean renderCrosshairs = true;
   public static final boolean debugCrosshairs = false;
   public static boolean debugBulletCollisions = false;
   public static final double RENDER_DISTANCE_PARTICLES = 128.0D;
   public static final double RENDER_DISTANCE_PLAYER = 128.0D;
   private boolean lastAiming = false;
   private boolean lastZoomWithTexture = false;
   public boolean smoothCamera = false;
   public float smoothCameraWeight = 1.0F;
   private int lastPOV = 0;
   public int displayFiremodeChange = 0;
   public boolean renderPlayerHUD = true;
   private float zLevel = 0.0F;

   public void onRenderTick(Minecraft par1Minecraft, float par2) {
      ScaledResolution scaledresolution = new ScaledResolution(par1Minecraft.gameSettings, par1Minecraft.displayWidth, par1Minecraft.displayHeight);
      int width = scaledresolution.getScaledWidth();
      int height = scaledresolution.getScaledHeight();
      int mwidth = width / 2;
      int mheight = height / 2;
      if (ClientManager.instance().currentNotification != null) {
         ClientManager.instance().currentNotification.doRender(width, height);
      }

      this.renderPlayerViewDistance(par1Minecraft);
      EntityPlayer player = par1Minecraft.thePlayer;
      PlayerData playerData = CDAftermath.instance.playerDataHandler().getPlayerData((EntityPlayer)player);
      this.theWorld = this.mc.theWorld;
      if (player != null && !player.isDead) {
         if (this.mc.currentScreen == null && this.mc.inGameHasFocus) {
            this.renderNightVision(playerData, (double)width, (double)height);
            if (playerData.isHandCuffed) {
               int damage = 200 - playerData.handcuffDamage;
               CDRenderHelper.renderCenteredText(EnumChatFormatting.WHITE + "" + damage + "/" + 200, mwidth + 1, mheight + 10);
               CDRenderHelper.renderScaledItemStackIcon(new ItemStack(ItemManager.handcuffs), (double)mwidth - 19.5D, (double)(mheight - 30), 2.5D);
            }
         }

         ItemStack itemstack = player.getCurrentEquippedItem();
         boolean renderDefaultCrosshairs = true;
         boolean flag1 = true;
         this.smoothCamera = false;
         this.smoothCameraWeight = 0.35F;
         int ammo;
         if (itemstack != null) {
            if (itemstack.getItem() instanceof ItemGun) {
               this.renderCrosshairs = true;
               boolean isAimingWithTexture = false;
               ItemGun itemgun = (ItemGun)itemstack.getItem();
               if (this.lastAiming != playerData.isAiming) {
                  if (playerData.isAiming) {
                     this.lastPOV = this.mc.gameSettings.thirdPersonView;
                     if (this.mc.gameSettings.thirdPersonView != 0) {
                        this.mc.gameSettings.thirdPersonView = 0;
                     }
                  } else {
                     this.mc.gameSettings.thirdPersonView = this.lastPOV;
                  }

                  this.lastAiming = playerData.isAiming;
               }

               if (playerData.isAiming) {
                  if (true && this.mc.currentScreen != null) {
                     playerData.isAiming = false;
                     return;
                  }
                  
                  Random rand = new Random();
                  float x = this.mc.thePlayer.rotationYaw;
                  float y = this.mc.thePlayer.rotationPitch;
                  int r = (int) (Math.random() * (11 - 1));
                  switch(r) {
                  case 0:
                	  y += rand.nextFloat()/70;
                  case 1:
                	  x -= rand.nextFloat()/70;
                  case 2:
                	  x += rand.nextFloat()/60;
                  case 3:
                	  y -= rand.nextFloat()/60;
                  case 4:
                	  y += rand.nextFloat()/60;
                	  x -= rand.nextFloat()/70;
                  case 5:
                	  x += rand.nextFloat()/70;
                	  y -= rand.nextFloat()/60;
                  case 6:
                	  x += rand.nextFloat()/70;
                	  x -= rand.nextFloat()/60;
                  case 7:
                	  y -= rand.nextFloat()/60;
                	  y += rand.nextFloat()/70;
                  case 8:
                	  y += (rand.nextFloat()/60);
                  case 9:
                	  x -= rand.nextFloat()/70;
                  case 10:
                	  x += rand.nextFloat()/60;
                  }
                  this.mc.thePlayer.rotationYaw = x;
                  this.mc.thePlayer.rotationPitch = y;
                  
                  float zoom = itemgun.zoomLevel;
                  GunAttachment attachment = itemgun.getAttachmentFromSlot(itemstack, 0);
                  this.renderCrosshairs = false;
                  renderDefaultCrosshairs = false;
                  if (attachment != null) {
                     zoom = attachment.zoomLevel;
                  }

                  if (attachment != null && attachment.scopeTexture != null) {
                     this.smoothCamera = true;
                     isAimingWithTexture = true;
                     if (!this.lastZoomWithTexture) {
                        this.mc.sndManager.playSoundFX("craftingdead:zoomin", 1.0F, 1.0F);
                        this.lastZoomWithTexture = true;
                     }

                     GL11.glPushMatrix();
                     GL11.glDisable(2929);
                     GL11.glDepthMask(false);
                     GL11.glScaled(1.0D, 1.0D, 0.0D);
                     GL11.glBlendFunc(770, 771);
                     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                     GL11.glDisable(3008);
                     par1Minecraft.renderEngine.bindTexture(attachment.scopeTexture);
                     Tessellator tessellator = Tessellator.instance;
                     tessellator.startDrawingQuads();
                     tessellator.addVertexWithUV((double)(width / 2 - 2 * height), (double)height, -90.0D, 0.0D, 1.0D);
                     tessellator.addVertexWithUV((double)(width / 2 + 2 * height), (double)height, -90.0D, 1.0D, 1.0D);
                     tessellator.addVertexWithUV((double)(width / 2 + 2 * height), 0.0D, -90.0D, 1.0D, 0.0D);
                     tessellator.addVertexWithUV((double)(width / 2 - 2 * height), 0.0D, -90.0D, 0.0D, 0.0D);
                     tessellator.draw();
                     GL11.glDepthMask(true);
                     GL11.glEnable(2929);
                     GL11.glEnable(3008);
                     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                     GL11.glPopMatrix();
                  }

                  if (zoom > 1.0F) {
                     this.updateZoomLevels(par1Minecraft, zoom);
                     flag1 = false;
                  }
               } else {
                  this.lastZoomWithTexture = false;
               }
               
               if (!isAimingWithTexture && this.mc.currentScreen == null) {
                  ItemStack ammoStack = itemgun.getClipLoaded(itemstack);
                  if (ammoStack != null) {
                     ammo = itemgun.getAmmo(itemstack);
                     int maxammo = ((ItemAmmo)itemgun.getClipLoaded(itemstack).getItem()).clipSize;
                     CDRenderHelper.renderText(EnumChatFormatting.WHITE + "" + ammo + "/" + maxammo, 18, height - 10);
                     CDRenderHelper.renderItemStackIntoGUI(ammoStack, 2, height - 15);
                  }

                  if (this.displayFiremodeChange > 0) {
                     CDRenderHelper.renderText(EnumChatFormatting.WHITE + "Режим стрельбы: " + this.getTranslation(itemgun.getFiremode().toString()), 5, height - 32);
                  }
               }
            }
            
            if (itemstack.getItem() instanceof ItemFlameThrower && this.mc.currentScreen == null) {
               PlayerData data = CDAftermath.instance.playerDataHandler().getClientPlayerData();
               if (data.getCDInventory() != null) {
                  CDRenderHelper.renderText(EnumChatFormatting.WHITE + "" + data.flamethrowerFuelCount, mwidth - 75, height - 60);
                  CDRenderHelper.renderItemStackIntoGUI(new ItemStack(ItemManager.fuelTank), mwidth - 92, height - 65);
               }
            }
         }

         if ((itemstack == null || !(itemstack.getItem() instanceof ItemGun)) && this.lastAiming) {
            this.mc.gameSettings.thirdPersonView = this.lastPOV;
            this.lastAiming = false;
         }

         if (flag1) {
            this.updateZoomLevels(par1Minecraft, 1.0F);
         }

         GuiIngameForge.renderCrosshairs = renderDefaultCrosshairs;
         this.renderFlashBang(playerData, (double)width, (double)height);
      }

      if (this.mc.currentScreen != null && this.mc.currentScreen instanceof GuiIngameMenu && !this.mc.isSingleplayer()) {
         PlayerData data = CDAftermath.instance.playerDataHandler().getClientPlayerData();
         if (data.isInCombat()) {
            String waitTime = EnumChatFormatting.RED + "" + 5 + "s" + EnumChatFormatting.WHITE;
            CDRenderHelper.renderCenteredText("Вы в бою! Ждите " + waitTime + " до выхода!", width / 2, 50);
            if (data != null) {
               DecimalFormat df = new DecimalFormat("0.00");
               String time = EnumChatFormatting.RED + "" + df.format((double)data.antiCombatLoggingWaitTick / 20.0D) + "с" + EnumChatFormatting.WHITE;
               CDRenderHelper.renderCenteredText("Времени осталось: " + time, width / 2, 60);
            }
         }
      }

   }
   private String getTranslation(String id) {
	   if (id.equals("AUTO")) {
		   return "автоматический";
	   }
	   else if (id.equals("SEMI")) {
		   return "полуавтоматический";
	   }
	   else if (id.equals("BURST")) {
		   return "очередь";
	   }
	   else {
		   return "error";
	   }
   }
   public void renderPlayerViewDistance(Minecraft par1Minecraft) {
      if (par1Minecraft.theWorld != null) {
         ArrayList list = (ArrayList)par1Minecraft.theWorld.getLoadedEntityList();

         for(int i = 0; i < list.size(); ++i) {
            Entity entity = (Entity)list.get(i);
            if (entity instanceof EntityPlayer) {
               entity.renderDistanceWeight = 2.0D;
            }
         }

      }
   }

   public void renderNightVision(PlayerData playerData, double width, double height) {
      if (playerData.isNightVisionActive) {
         CDRenderHelper.drawRect(0, 0, (int)width, (int)height, "0x00ff00", 0.15F);
      }

   }

   public void renderFlashBang(PlayerData playerData, double width, double height) {
      float var1 = (float)playerData.flashTime * 1.0F / 6.0F;
      if (var1 >= 0.1F) {
         CDRenderHelper.drawRect(0, 0, (int)width, (int)height, "0xffffff", var1);
      }

   }

   public void drawIcon(Minecraft mc, double par1, double par2, int var3, int var4, int imageSize, double scale) {
      mc.getTextureManager().bindTexture(this.icons);
      GL11.glPushMatrix();
      GL11.glEnable(3042);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.9F);
      GL11.glScaled(scale, scale, scale);
      GL11.glTranslated(par1 * (1.0D / scale), par2 * (1.0D / scale), 0.0D);
      this.drawTexturedModalRect(imageSize / 2, imageSize / 2, var3, var4, imageSize, imageSize);
      GL11.glDisable(3042);
      GL11.glPopMatrix();
   }

   private void drawTexturedModalRect(int par1, int par2, int par3, int par4, int par5, int par6) {
      float f = 0.00390625F;
      float f1 = 0.00390625F;
      Tessellator tessellator = Tessellator.instance;
      tessellator.startDrawingQuads();
      tessellator.addVertexWithUV((double)(par1 + 0), (double)(par2 + par6), (double)this.zLevel, (double)((float)(par3 + 0) * f), (double)((float)(par4 + par6) * f1));
      tessellator.addVertexWithUV((double)(par1 + par5), (double)(par2 + par6), (double)this.zLevel, (double)((float)(par3 + par5) * f), (double)((float)(par4 + par6) * f1));
      tessellator.addVertexWithUV((double)(par1 + par5), (double)(par2 + 0), (double)this.zLevel, (double)((float)(par3 + par5) * f), (double)((float)(par4 + 0) * f1));
      tessellator.addVertexWithUV((double)(par1 + 0), (double)(par2 + 0), (double)this.zLevel, (double)((float)(par3 + 0) * f), (double)((float)(par4 + 0) * f1));
      tessellator.draw();
   }

   public void updateZoomLevels(Minecraft mc, float par2) {
      try {
         ObfuscationReflectionHelper.setPrivateValue(EntityRenderer.class, mc.entityRenderer, (double)par2, new String[]{"cameraZoom", "Y", "field_78503_V"});
      } catch (Exception var4) {
         throw new RuntimeException(var4);
      }
   }

   public static void spawnParticle(String par1Str, double par2, double par4, double par6, double par8, double par10, double par12) {
      if (FMLCommonHandler.instance().getSide() == Side.CLIENT && instance() != null && instance().theWorld != null) {
         instance().doSpawnParticle(par1Str, par2, par4, par6, par8, par10, par12);
      }

   }

   private EntityFX doSpawnParticle(String par1Str, double par2, double par4, double par6, double par8, double par10, double par12) {
      if (this.mc != null && this.mc.renderViewEntity != null && this.mc.effectRenderer != null) {
         double d6 = this.mc.renderViewEntity.posX - par2;
         double d7 = this.mc.renderViewEntity.posY - par4;
         double d8 = this.mc.renderViewEntity.posZ - par6;
         EntityFX entityfx = null;
         if (par1Str.equals("hugeexplosion")) {
            this.mc.effectRenderer.addEffect((EntityFX)(entityfx = new EntityHugeExplodeFX(this.theWorld, par2, par4, par6, par8, par10, par12)));
         } else if (par1Str.equals("largeexplode")) {
            this.mc.effectRenderer.addEffect((EntityFX)(entityfx = new EntityLargeExplodeFX(this.mc.renderEngine, this.theWorld, par2, par4, par6, par8, par10, par12)));
         }

         if (entityfx != null) {
            return (EntityFX)entityfx;
         } else {
            double d9 = 128.0D;
            if (d6 * d6 + d7 * d7 + d8 * d8 > d9 * d9) {
               return null;
            } else {
               if (par1Str.equals("smoke")) {
                  entityfx = new EntitySmokeFX(this.theWorld, par2, par4, par6, par8, par10, par12);
               } else if (par1Str.equals("explode")) {
                  entityfx = new EntityExplodeFX(this.theWorld, par2, par4, par6, par8, par10, par12);
               } else if (par1Str.equals("flame")) {
                  entityfx = new EntityFlameFX(this.theWorld, par2, par4, par6, par8, par10, par12);
               } else if (par1Str.equals("largesmoke")) {
                  entityfx = new EntitySmokeFX(this.theWorld, par2, par4, par6, par8, par10, par12, 2.5F);
               } else if (par1Str.equals("cloud")) {
                  entityfx = new EntityCloudFX(this.theWorld, par2, par4, par6, par8, par10, par12);
               } else {
                  int j;
                  String[] astring;
                  int k;
                  if (par1Str.startsWith("iconcrack_")) {
                     astring = par1Str.split("_", 3);
                     j = Integer.parseInt(astring[1]);
                     if (astring.length > 2) {
                        k = Integer.parseInt(astring[2]);
                        entityfx = new EntityBreakingFX(this.theWorld, par2, par4, par6, par8, par10, par12, Item.itemsList[j], k);
                     } else {
                        entityfx = new EntityBreakingFX(this.theWorld, par2, par4, par6, par8, par10, par12, Item.itemsList[j], 0);
                     }
                  } else if (par1Str.startsWith("tilecrack_")) {
                     astring = par1Str.split("_", 3);
                     j = Integer.parseInt(astring[1]);
                     k = Integer.parseInt(astring[2]);
                     entityfx = (new EntityDiggingFX(this.theWorld, par2, par4, par6, par8, par10, par12, Block.blocksList[j], k)).applyRenderColor(k);
                  }
               }

               if (entityfx != null) {
                  this.mc.effectRenderer.addEffect((EntityFX)entityfx);
               }

               return (EntityFX)entityfx;
            }
         }
      } else {
         return null;
      }
   }

   public void onFiremodeUpdated(EnumFireMode par1) {
      this.displayFiremodeChange = 60;
   }

   public static RenderTickHandler instance() {
      return CDAftermath.instance.getClientManager().getClientTickHandler().renderHandler;
   }
}
