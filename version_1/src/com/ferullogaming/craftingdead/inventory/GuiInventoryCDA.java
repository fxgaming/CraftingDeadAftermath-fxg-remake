package com.ferullogaming.craftingdead.inventory;

import com.ferullogaming.craftingdead.client.CDRenderHelper;
import com.ferullogaming.craftingdead.client.gui.GuiCDButton;
import com.ferullogaming.craftingdead.item.ItemManager;
import com.ferullogaming.craftingdead.item.gun.GunPaint;
import com.ferullogaming.craftingdead.item.gun.ItemGun;
import com.ferullogaming.craftingdead.item.gun.ItemPaint;
import com.ferullogaming.craftingdead.network.CDAPacketOpenGUI;
import cpw.mods.fml.common.network.PacketDispatcher;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.gui.inventory.GuiContainerCreative;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.AchievementList;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

public class GuiInventoryCDA extends GuiContainer {
   private float xSize_lo;
   private float ySize_lo;
   private ResourceLocation invTexture = new ResourceLocation("craftingdead:textures/gui/cdainventory.png");
   private static float rotationYaw = 0.0F;

   public GuiInventoryCDA(EntityPlayer par1EntityPlayer, InventoryCDA par2Extended) {
      super(new ContainerInventoryCDA(par1EntityPlayer, par2Extended));
      super.allowUserInput = true;
      rotationYaw = 0.0F;
      par1EntityPlayer.addStat(AchievementList.openInventory, 1);
      super.ySize = 186;
   }

   public void initGui() {
      super.initGui();
      super.guiTop += 10;
      GuiCDButton tab = new GuiCDButton(1, super.guiLeft + 6, super.guiTop - 21, new ItemStack(ItemManager.backpackMediumBlue));
      tab.hoverText = "Inventory";
      tab.drawBackground = false;
      super.buttonList.add(tab);
      tab = new GuiCDButton(2, super.guiLeft + 35, super.guiTop - 20, new ItemStack(ItemManager.pickaxe));
      tab.hoverText = "Crafting";
      tab.drawBackground = false;
      super.buttonList.add(tab);
      if (super.mc.thePlayer.capabilities.isCreativeMode) {
         tab = new GuiCDButton(5, super.guiLeft + 64, super.guiTop - 20, new ItemStack(ItemManager.backpackLargeTan));
         tab.hoverText = "Creative Inventory";
         tab.drawBackground = false;
         super.buttonList.add(tab);
      }

      tab = new GuiCDButton(3, super.guiLeft + 83, super.guiTop + 48, 10, 16, ">");
      tab.drawShadow = true;
      super.buttonList.add(tab);
      tab = new GuiCDButton(4, super.guiLeft + 83, super.guiTop + 66, 10, 16, ">");
      tab.drawShadow = true;
      super.buttonList.add(tab);
   }

   public void drawScreen(int par1, int par2, float par3) {
      super.drawScreen(par1, par2, par3);
      this.xSize_lo = (float)par1;
      this.ySize_lo = (float)par2;

      for(int i = 0; i < super.buttonList.size(); ++i) {
         if (super.buttonList.get(i) instanceof GuiCDButton) {
            GuiCDButton button = (GuiCDButton)super.buttonList.get(i);
            if (button.isOver == 2 && button.hoverText != null && button.hoverText.length() > 0) {
               List list = new ArrayList();
               list.add(button.hoverText);
               this.drawHoveringText(list, par1, par2, super.fontRenderer);
            }
         }
      }

   }

   protected void actionPerformed(GuiButton par1GuiButton) {
      ContainerInventoryCDA container = (ContainerInventoryCDA)super.inventorySlots;
      InventoryCDA inventory = container.inventoryCDA;
      if (par1GuiButton.id == 2) {
         PacketDispatcher.sendPacketToServer(CDAPacketOpenGUI.buildPacket(46));
      }

      if (par1GuiButton.id == 3 && inventory.getStack("backpack") != null) {
         PacketDispatcher.sendPacketToServer(CDAPacketOpenGUI.buildPacket(47));
      }

      if (par1GuiButton.id == 4 && inventory.getStack("vest") != null) {
         PacketDispatcher.sendPacketToServer(CDAPacketOpenGUI.buildPacket(48));
      }

      if (par1GuiButton.id == 5) {
         super.mc.displayGuiScreen(new GuiContainerCreative(super.mc.thePlayer));
      }

   }

   protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      super.mc.renderEngine.bindTexture(this.invTexture);
      int k = super.guiLeft;
      int l = super.guiTop;
      if (super.mc.thePlayer.capabilities.isCreativeMode) {
         this.drawTexturedModalRect(k + 58, l - 27, 0, 186, 28, 30);
      }

      this.drawTexturedModalRect(k + 29, l - 27, 0, 186, 28, 32);
      this.drawTexturedModalRect(k, l, 0, 0, super.xSize, super.ySize);
      this.drawTexturedModalRect(k, l - 28, 0, 216, 28, 32);
      ContainerInventoryCDA container = (ContainerInventoryCDA)super.inventorySlots;
      InventoryCDA inventory = container.inventoryCDA;
      super.mc.renderEngine.bindTexture(this.invTexture);
      if (inventory.getStack("cgun") != null) {
         this.drawTexturedModalRect(k + 122, l + 45, 176, 0, 22, 22);
         if (inventory.isGunCraftable()) {
            this.drawTexturedModalRect(k + 122, l + 45, 176, 22, 22, 22);
         }

         if (!inventory.isItemGunCraftingAllowed(container.inventoryPlayer.getItemStack())) {
            this.drawTexturedModalRect(k + 122, l + 45, 176, 44, 22, 22);
         }
         
         ItemGun i = (ItemGun)inventory.getStack("cgun").getItem();
         this.drawTexturedModalRect(k + 176, l + 36, 176, 67, 80, 148);
         CDRenderHelper.renderText("Доступные модули", k + 186, l + 130, 0);
         CDRenderHelper.renderText("улучшения оружия", k + 186, l + 136, 0);
         CDRenderHelper.renderText("Патронов: " + i.getAmmo(inventory.getStack("cgun")), k + 178, l + 58, 0);
         CDRenderHelper.renderText("Урон: " + i.gunDamage, k + 178, l + 68, 0);
         CDRenderHelper.renderText("В голову: " + i.gunDamageHead, k + 178, l + 78, 0);
         CDRenderHelper.renderText("Точность: " + i.gunAccuracy, k + 178, l + 88, 0);
         CDRenderHelper.renderText("Разброс: " + i.gunRecoil, k + 178, l + 98, 0);
         CDRenderHelper.renderText("Окрас: " + i.getSkinName(inventory.getStack("cgun")), k + 178, l + 108, 0);
         
         int a = 9256, b = 9257, c = 9259, d = 9260, e = 9286, id = inventory.getStack("cgun").getItem().itemID;
         ItemStack sd = new ItemStack(9331, 1, 0), sa = new ItemStack(9332, 1, 0), s5 = new ItemStack(9333, 1, 0), s10 = new ItemStack(9334, 1, 0);
         ItemStack sil = new ItemStack(9335, 1, 0), tacr = new ItemStack(9336, 1, 0), soh = new ItemStack(9337, 1, 0), muz = new ItemStack(9338, 1, 0);
         if (id == a || id == b || id == c || id == d || id == e) {
        	 CDRenderHelper.renderItemStackIntoGUI(sd, k + 186, l + 146);
        	 CDRenderHelper.renderItemStackIntoGUI(sa, k + 186 + 16, l + 146);
        	 CDRenderHelper.renderItemStackIntoGUI(s5, k + 186 + 32, l + 146);
        	 CDRenderHelper.renderItemStackIntoGUI(s10, k + 186 + 48, l + 146);
        	 CDRenderHelper.renderItemStackIntoGUI(sil, k + 186, l + 146 + 16);
        	 CDRenderHelper.renderItemStackIntoGUI(tacr, k + 186 + 16, l + 146 + 16);
        	 CDRenderHelper.renderItemStackIntoGUI(soh, k + 186 + 32, l + 146 + 16);
        	 CDRenderHelper.renderItemStackIntoGUI(muz, k + 186 + 48, l + 146 + 16);
         }
         else if (id == 9287 || id == 9288) {
        	 CDRenderHelper.renderItemStackIntoGUI(sd, k + 186, l + 146);
        	 CDRenderHelper.renderItemStackIntoGUI(sa, k + 186 + 16, l + 146);
        	 CDRenderHelper.renderItemStackIntoGUI(s5, k + 186 + 32, l + 146);
        	 CDRenderHelper.renderItemStackIntoGUI(s10, k + 186 + 48, l + 146);
        	 CDRenderHelper.renderItemStackIntoGUI(tacr, k + 186, l + 146 + 16);
        	 CDRenderHelper.renderItemStackIntoGUI(soh, k + 186 + 16, l + 146 + 16);
        	 CDRenderHelper.renderItemStackIntoGUI(muz, k + 186 + 32, l + 146 + 16);
         }
         else if (id == 9266 || id == 9267) {
        	 CDRenderHelper.renderItemStackIntoGUI(sd, k + 186, l + 146);
        	 CDRenderHelper.renderItemStackIntoGUI(sil, k + 186 + 16, l + 146);
        	 CDRenderHelper.renderItemStackIntoGUI(muz, k + 186 + 32, l + 146);
         }
         else if (id == 9276 || id == 9277) {
        	 CDRenderHelper.renderItemStackIntoGUI(sd, k + 186, l + 146);
        	 CDRenderHelper.renderItemStackIntoGUI(sa, k + 186 + 16, l + 146);
        	 CDRenderHelper.renderItemStackIntoGUI(sil, k + 186 + 32, l + 146);
        	 CDRenderHelper.renderItemStackIntoGUI(muz, k + 186 + 48, l + 146);
         }
         else if (id == 9268) {
        	 CDRenderHelper.renderItemStackIntoGUI(sil, k + 186, l + 146);
        	 CDRenderHelper.renderItemStackIntoGUI(muz, k + 186 + 16, l + 146);	 
         }
         else if (id == 9296) {
        	 CDRenderHelper.renderItemStackIntoGUI(tacr, k + 186, l + 146);
         }
         else if (id == 9289) {
        	 CDRenderHelper.renderItemStackIntoGUI(s5, k + 186, l + 146);
        	 CDRenderHelper.renderItemStackIntoGUI(s10, k + 186 + 16, l + 146);
        	 CDRenderHelper.renderItemStackIntoGUI(soh, k + 186 + 32, l + 146);
         }
         else if (id == 9301) {
        	 CDRenderHelper.renderItemStackIntoGUI(sd, k + 186, l + 146);
        	 CDRenderHelper.renderItemStackIntoGUI(tacr, k + 186 + 16, l + 146);
        	 CDRenderHelper.renderItemStackIntoGUI(soh, k + 186 + 32, l + 146);
        	 CDRenderHelper.renderItemStackIntoGUI(muz, k + 186 + 48, l + 146);
         } else if (id == 9302) {
        	 CDRenderHelper.renderItemStackIntoGUI(s5, k + 186, l + 146);
        	 CDRenderHelper.renderItemStackIntoGUI(s10, k + 186 + 16, l + 146);
        	 CDRenderHelper.renderItemStackIntoGUI(sil, k + 186 + 32, l + 146);
        	 CDRenderHelper.renderItemStackIntoGUI(muz, k + 186 + 48, l + 146);
         }
      }

      GL11.glPushMatrix();
      double scale = 1.0D;
      GL11.glScaled(scale, scale, scale);
      drawPlayerOnGui(super.mc, k + 33, l + 97, 30, (float)(k + 51) - this.xSize_lo, (float)(l + 75 - 50) - this.ySize_lo);
      GL11.glPopMatrix();
   }

   public void updateScreen() {
      rotationYaw += 2.0F;
   }

   public static void drawPlayerOnGui(Minecraft par0Minecraft, int par1, int par2, int par3, float par4, float par5) {
	   GL11.glEnable(2903);
      GL11.glPushMatrix();
      GL11.glTranslatef((float)par1, (float)par2, 50.0F);
      GL11.glScalef((float)(-par3), (float)par3, (float)par3);
      GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
      float f2 = par0Minecraft.thePlayer.renderYawOffset;
      float f3 = par0Minecraft.thePlayer.rotationYaw;
      float f4 = par0Minecraft.thePlayer.rotationPitch;
      GL11.glRotatef(135.0F, 0.0F, 1.0F, 0.0F);
      RenderHelper.enableStandardItemLighting();
      GL11.glRotatef(-135.0F + rotationYaw, 0.0F, 1.0F, 0.0F);
      par0Minecraft.thePlayer.renderYawOffset = 0.0F;
      par0Minecraft.thePlayer.rotationYaw = 0.0F;
      par0Minecraft.thePlayer.rotationPitch = 0.0F;
      par0Minecraft.thePlayer.rotationYawHead = 0.0F;
      GL11.glTranslatef(0.0F, par0Minecraft.thePlayer.yOffset, 0.0F);
      RenderManager.instance.playerViewY = 180.0F;
      RenderManager.instance.renderEntityWithPosYaw(par0Minecraft.thePlayer, 0.0D, 0.0D, 0.0D, 0.0F, 1.0F);
      par0Minecraft.thePlayer.renderYawOffset = f2;
      par0Minecraft.thePlayer.rotationYaw = f3;
      par0Minecraft.thePlayer.rotationPitch = f4;
      GL11.glPopMatrix();
      RenderHelper.disableStandardItemLighting();
      GL11.glDisable(32826);
      OpenGlHelper.setActiveTexture(OpenGlHelper.lightmapTexUnit);
      GL11.glDisable(3553);
      OpenGlHelper.setActiveTexture(OpenGlHelper.defaultTexUnit);
   }
}
