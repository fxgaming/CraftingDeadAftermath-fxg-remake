package by.fxg.craftingdead.inventory;

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
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

import by.fxg.craftingdead.client.gui.GuiCDButton;
import by.fxg.craftingdead.item.ItemManager;
import by.fxg.craftingdead.network.CDAPacketOpenGUI;

public class GuiInventoryCDACrafting extends GuiContainer {
   private ResourceLocation invTexture = new ResourceLocation("craftingdead:textures/gui/cdainventorycrafting.png");
   private ResourceLocation invTextureTabs = new ResourceLocation("craftingdead:textures/gui/cdainventory.png");
   private float xSize_lo;
   private float ySize_lo;
   private static float rotationYaw = 0.0F;

   public GuiInventoryCDACrafting(EntityPlayer par1EntityPlayer) {
      super(new ContainerInventoryCDACrafting(par1EntityPlayer.inventory, par1EntityPlayer));
      super.allowUserInput = true;
      rotationYaw = 0.0F;
   }

   public void initGui() {
      super.initGui();
      super.guiTop += 0;
      int k = super.guiLeft;
      int l = super.guiTop;
      GuiCDButton tab = new GuiCDButton(1, super.guiLeft + 6, super.guiTop - 20, new ItemStack(ItemManager.backpackMediumBlue));
      tab.hoverText = "Inventory";
      tab.drawBackground = false;
      super.buttonList.add(tab);
      tab = new GuiCDButton(2, super.guiLeft + 35, super.guiTop - 21, new ItemStack(ItemManager.pickaxe));
      tab.hoverText = "Crafting";
      tab.drawBackground = false;
      super.buttonList.add(tab);
      if (super.mc.thePlayer.capabilities.isCreativeMode) {
         tab = new GuiCDButton(3, super.guiLeft + 64, super.guiTop - 20, new ItemStack(ItemManager.backpackLargeTan));
         tab.hoverText = "Creative Inventory";
         tab.drawBackground = false;
         super.buttonList.add(tab);
      }

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
      if (par1GuiButton.id == 1) {
         PacketDispatcher.sendPacketToServer(CDAPacketOpenGUI.buildPacket(45));
      }

      if (par1GuiButton.id == 3) {
         super.mc.displayGuiScreen(new GuiContainerCreative(super.mc.thePlayer));
      }

   }

   protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      int k = super.guiLeft;
      int l = super.guiTop;
      super.mc.renderEngine.bindTexture(this.invTextureTabs);
      this.drawTexturedModalRect(k, l - 27, 28, 186, 28, 32);
      if (super.mc.thePlayer.capabilities.isCreativeMode) {
         this.drawTexturedModalRect(k + 58, l - 27, 0, 186, 28, 30);
      }

      super.mc.renderEngine.bindTexture(this.invTexture);
      this.drawTexturedModalRect(k, l, 0, 0, super.xSize, super.ySize);
      super.mc.renderEngine.bindTexture(this.invTextureTabs);
      this.drawTexturedModalRect(k + 29, l - 28, 28, 216, 28, 32);
      GL11.glPushMatrix();
      double scale = 1.0D;
      GL11.glScaled(scale, scale, scale);
      drawPlayerOnGui(super.mc, k + 33, l + 75, 30, (float)(k + 51) - this.xSize_lo, (float)(l + 75 - 50) - this.ySize_lo);
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
