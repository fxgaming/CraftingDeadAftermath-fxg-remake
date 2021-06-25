package com.ferullogaming.craftingdead.inventory;

import com.ferullogaming.craftingdead.client.gui.GuiCDButton;
import com.ferullogaming.craftingdead.item.ItemManager;
import com.ferullogaming.craftingdead.network.CDAPacketOpenGUI;
import cpw.mods.fml.common.network.PacketDispatcher;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import org.lwjgl.opengl.GL11;

public class GuiBackpack extends GuiContainer {
   private IInventory upperChestInventory;
   private IInventory lowerChestInventory;
   private ResourceLocation invTexture = new ResourceLocation("craftingdead:textures/gui/backpack.png");
   private ResourceLocation invTextureTabs = new ResourceLocation("craftingdead:textures/gui/cdainventory.png");
   private int inventoryRows = 0;

   public GuiBackpack(IInventory par1IInventory, IInventory par2IInventory) {
      super(new ContainerBackpack(par1IInventory, par2IInventory));
      this.upperChestInventory = par1IInventory;
      this.lowerChestInventory = par2IInventory;
      super.allowUserInput = false;
      short short1 = 222;
      int i = short1 - 108;
      this.inventoryRows = par2IInventory.getSizeInventory() / 9;
      super.ySize = i + this.inventoryRows * 18;
   }

   public void initGui() {
      super.initGui();
      GuiCDButton tab = new GuiCDButton(1, super.guiLeft + 6, super.guiTop - 21, new ItemStack(ItemManager.backpackMediumBlue));
      tab.hoverText = "Inventory";
      tab.drawBackground = false;
      super.buttonList.add(tab);
   }

   protected void actionPerformed(GuiButton par1GuiButton) {
      if (par1GuiButton.id == 1) {
         PacketDispatcher.sendPacketToServer(CDAPacketOpenGUI.buildPacket(45));
      }

   }

   protected void drawGuiContainerForegroundLayer(int par1, int par2) {
      super.fontRenderer.drawString(this.lowerChestInventory.isInvNameLocalized() ? this.lowerChestInventory.getInvName() : StatCollector.translateToLocal(this.lowerChestInventory.getInvName()), 8, 6, 4210752);
      super.fontRenderer.drawString(this.upperChestInventory.isInvNameLocalized() ? this.upperChestInventory.getInvName() : StatCollector.translateToLocal(this.upperChestInventory.getInvName()), 8, super.ySize - 96 + 2, 4210752);
   }

   protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      super.mc.renderEngine.bindTexture(this.invTexture);
      int k = (super.width - super.xSize) / 2;
      int l = (super.height - super.ySize) / 2;
      super.mc.renderEngine.bindTexture(this.invTextureTabs);
      this.drawTexturedModalRect(k, l - 28, 28, 186, 28, 32);
      super.mc.renderEngine.bindTexture(this.invTexture);
      this.drawTexturedModalRect(k, l, 0, 0, super.xSize, this.inventoryRows * 18 + 17);
      this.drawTexturedModalRect(k, l + this.inventoryRows * 18 + 17, 0, 126, super.xSize, 96);

      for(int i = 0; i < super.buttonList.size(); ++i) {
         if (super.buttonList.get(i) instanceof GuiCDButton) {
            GuiCDButton button = (GuiCDButton)super.buttonList.get(i);
            if (button.isOver == 2 && button.hoverText != null && button.hoverText.length() > 0) {
               List list = new ArrayList();
               list.add(button.hoverText);
               this.drawHoveringText(list, par2, par3, super.fontRenderer);
            }
         }
      }

   }
}
