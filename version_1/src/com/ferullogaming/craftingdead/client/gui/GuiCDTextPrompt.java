package com.ferullogaming.craftingdead.client.gui;

import com.ferullogaming.craftingdead.client.CDRenderHelper;
import java.awt.Rectangle;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.util.EnumChatFormatting;
import org.lwjgl.input.Keyboard;

public abstract class GuiCDTextPrompt extends GuiCDScreen {
   protected GuiScreen parentGui;
   private boolean isButtonClicked = false;
   private boolean isOpened = false;
   public GuiTextField promptInputText;
   private GuiCDButton enterButton;
   private GuiCDButton exitButton;
   public String[] promptInformation;
   public int maxCharacters = 32;
   private int promptX;
   private int promptY;
   public int promptWidth = 200;
   public int promptHeight = 20;
   public String promptedTextInput = "";
   public boolean restrictedUsernameInput = false;
   protected String errorMessage = "";
   private int backspaceTicker = 0;

   public GuiCDTextPrompt(GuiScreen par1) {
      this.parentGui = par1;
   }

   public GuiCDTextPrompt addInformation(String... par1) {
      this.promptInformation = par1;
      return this;
   }

   public GuiCDTextPrompt setUsernameInput() {
      this.restrictedUsernameInput = true;
      return this;
   }

   public void initGui() {
      this.promptX = super.width / 2 - this.promptWidth / 2;
      this.promptY = super.height / 2 - this.promptHeight / 2;
      this.promptInputText = new GuiTextField(super.fontRenderer, this.promptX, this.promptY, this.promptWidth, this.promptHeight);
      this.promptInputText.setMaxStringLength(this.maxCharacters);
      this.promptInputText.setText(this.promptedTextInput);
      super.buttonList.add(new GuiCDButton(10, this.promptX, this.promptY + 25, 80, 20, "Close"));
      super.buttonList.add(new GuiCDButton(11, this.promptX + this.promptWidth - 80, this.promptY + 25, 80, 20, "Confirm"));
      if (this.isOpened) {
         super.mc.displayGuiScreen(this.parentGui);
      }

      this.isOpened = true;
   }

   public void actionPerformed(GuiButton guibutton) {
      if (guibutton.id == 11) {
         this.isButtonClicked = true;
         String text = this.promptInputText.getText();
         if (text.isEmpty()) {
            this.errorMessage = "Empty Field";
            return;
         }

         if (this.restrictedUsernameInput) {
            if (text.contains(" ")) {
               this.errorMessage = "Spaces are Invalid!";
               return;
            }

            for(int i = 0; i < text.length(); ++i) {
               char char1 = text.charAt(i);
               if (!Character.isAlphabetic(char1) && !Character.isDigit(char1) && char1 != '_') {
                  this.errorMessage = "Invalid Character Found";
                  return;
               }
            }
         }

         this.onPromptEntered();
      }

      if (guibutton.id == 10 && super.mc.currentScreen == this) {
         super.mc.displayGuiScreen(this.parentGui);
      }

   }

   public void updateScreen() {
      super.updateScreen();
      this.promptInputText.updateCursorCounter();
      if (Keyboard.isKeyDown(14)) {
         if (this.backspaceTicker >= 15) {
            this.promptInputText.deleteFromCursor(-1);
         } else {
            ++this.backspaceTicker;
         }
      } else {
         this.backspaceTicker = 0;
      }

   }

   protected void keyTyped(char par1, int par2) {
      super.keyTyped(par1, par2);
      this.promptInputText.textboxKeyTyped(par1, par2);
   }

   public abstract void onPromptEntered();

   public String getTextField() {
      return this.promptInputText.getText();
   }

   protected void mouseClicked(int par1, int par2, int par3) {
      super.mouseClicked(par1, par2, par3);
      this.promptInputText.mouseClicked(par1, par2, par3);
      Rectangle rect = new Rectangle(this.promptX, this.promptY, this.promptWidth, this.promptHeight);
      if (!rect.contains(par1, par2)) {
         if (this.isButtonClicked) {
            this.isButtonClicked = false;
         } else {
            if (super.mc.currentScreen == this) {
               super.mc.displayGuiScreen(this.parentGui);
            }

         }
      }
   }

   public void drawScreen(int i, int j, float f) {
      int margin = 60;
      CDRenderHelper.drawRectWithShadow(this.promptX - 4, this.promptY - margin, this.promptWidth + 8, this.promptHeight + margin + 30, "0x4d4d4d", 1.0F);

      int i1;
      for(i1 = 0; i1 < super.buttonList.size(); ++i1) {
         GuiButton guibutton = (GuiButton)super.buttonList.get(i1);
         guibutton.drawButton(super.mc, i, j);
      }

      if (this.promptInformation != null) {
         for(i1 = 0; i1 < this.promptInformation.length; ++i1) {
            String var1 = this.promptInformation[i1];
            CDRenderHelper.renderCenteredText(var1, this.promptX + this.promptWidth / 2, this.promptY - margin + 5 + i1 * 11);
         }
      }

      CDRenderHelper.renderCenteredText(EnumChatFormatting.RED + "" + this.errorMessage, this.promptX + this.promptWidth / 2, this.promptY - margin + 48);
      this.promptInputText.drawTextBox();
   }
}
