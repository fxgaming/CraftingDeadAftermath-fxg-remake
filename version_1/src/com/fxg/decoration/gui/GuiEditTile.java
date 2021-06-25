package com.fxg.decoration.gui;

import org.lwjgl.input.Keyboard;

import com.fxg.decoration.network.CDDPacketData;
import com.fxg.decoration.tile.TileBaseProp;

import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;

@SideOnly(Side.CLIENT)
public class GuiEditTile extends GuiScreen {
	public String blockName;
	public int blockId;
	public int[] coords;
	public int facing;
	public String skin;
	public float[] rotation;
	public float[] scalation;
	public float[] position;
	public float[] bbMinMax;
	private GuiTextField gFacing;
	private GuiTextField gSkin;
	private GuiTextField gRotation1;
	private GuiTextField gRotation2;
	private GuiTextField gRotation3;
	private GuiTextField gScale1;
	private GuiTextField gScale2;
	private GuiTextField gScale3;
	private GuiTextField gTranslate1;
	private GuiTextField gTranslate2;
	private GuiTextField gTranslate3;
	private GuiTextField gXmin;
	private GuiTextField gYmin;
	private GuiTextField gZmin;
	private GuiTextField gXmax;
	private GuiTextField gYmax;
	private GuiTextField gZmax;
	TileBaseProp tile;
	
	public GuiEditTile(TileBaseProp tile) {
		this.tile = tile;
		this.blockName = tile.getBlockType().getLocalizedName();
		this.blockId = tile.getBlockType().blockID;
		this.coords = new int[]{tile.xCoord, tile.yCoord, tile.zCoord};
		this.facing = tile.getFacing();
		this.skin = tile.texture;
		this.rotation = new float[]{tile.rotateX, tile.rotateY, tile.rotateZ};
		this.scalation = new float[]{tile.scaleX, tile.scaleY, tile.scaleZ};
		this.position = new float[]{tile.translateX, tile.translateY, tile.translateZ};
		this.bbMinMax = new float[]{tile.bbXmin, tile.bbYmin, tile.bbZmin, tile.bbXmax, tile.bbYmax, tile.bbZmax};
	}
	
    public void initGui() {
        this.buttonList.clear();
        this.buttonList.add(new GuiButton(0, this.width / 2 - 50, this.height / 2 + 85, 100, 20, "Edit"));
        this.buttonList.add(new GuiButton(1, this.width / 2 - 50, this.height / 2 + 65, 100, 20, "Update"));
        this.buttonList.add(new GuiButton(3, this.width - 75, 38, 10, 10, "+"));
        this.buttonList.add(new GuiButton(4, this.width - 65, 38, 10, 10, "-"));
        this.buttonList.add(new GuiButton(5, 50, 38, 10, 10, "+"));
        this.buttonList.add(new GuiButton(6, 60, 38, 10, 10, "-"));
        this.buttonList.add(new GuiButton(7, 100, 38, 10, 10, "+"));
        this.buttonList.add(new GuiButton(8, 110, 38, 10, 10, "-"));
        this.buttonList.add(new GuiButton(9, 150, 38, 10, 10, "+"));
        this.buttonList.add(new GuiButton(10, 160, 38, 10, 10, "-"));
        this.buttonList.add(new GuiButton(11, 50, 73, 10, 10, "+"));
        this.buttonList.add(new GuiButton(12, 60, 73, 10, 10, "-"));
        this.buttonList.add(new GuiButton(13, 100, 73, 10, 10, "+"));
        this.buttonList.add(new GuiButton(14, 110, 73, 10, 10, "-"));
        this.buttonList.add(new GuiButton(15, 150, 73, 10, 10, "+"));
        this.buttonList.add(new GuiButton(16, 160, 73, 10, 10, "-"));
        this.buttonList.add(new GuiButton(17, 50, 110, 10, 10, "+"));
        this.buttonList.add(new GuiButton(18, 60, 110, 10, 10, "-"));
        this.buttonList.add(new GuiButton(19, 100, 110, 10, 10, "+"));
        this.buttonList.add(new GuiButton(20, 110, 110, 10, 10, "-"));
        this.buttonList.add(new GuiButton(21, 150, 110, 10, 10, "+"));
        this.buttonList.add(new GuiButton(22, 160, 110, 10, 10, "-"));
        
        this.buttonList.add(new GuiButton(23, 210, 110, 10, 10, "+"));
        this.buttonList.add(new GuiButton(24, 220, 110, 10, 10, "-"));
        this.buttonList.add(new GuiButton(25, 260, 110, 10, 10, "+"));
        this.buttonList.add(new GuiButton(26, 270, 110, 10, 10, "-"));
        this.buttonList.add(new GuiButton(27, 310, 110, 10, 10, "+"));
        this.buttonList.add(new GuiButton(28, 320, 110, 10, 10, "-"));
        
        this.buttonList.add(new GuiButton(29, 210, 73, 10, 10, "+"));
        this.buttonList.add(new GuiButton(30, 220, 73, 10, 10, "-"));
        this.buttonList.add(new GuiButton(31, 260, 73, 10, 10, "+"));
        this.buttonList.add(new GuiButton(32, 270, 73, 10, 10, "-"));
        this.buttonList.add(new GuiButton(33, 310, 73, 10, 10, "+"));
        this.buttonList.add(new GuiButton(34, 320, 73, 10, 10, "-"));
        
        this.gFacing = new GuiTextField(this.fontRenderer, this.width - 75, 49, 20, 20);
        this.gFacing.setMaxStringLength(2);
        this.gFacing.setText("" + this.facing);
        this.gSkin = new GuiTextField(this.fontRenderer, this.width / 2 - 100, 160, 200, 20);
        this.gSkin.setMaxStringLength(60);
        this.gSkin.setText("" + this.skin);
        this.gRotation1 = new GuiTextField(this.fontRenderer, 50, 49, 40, 20);
        this.gRotation1.setMaxStringLength(6);
        this.gRotation1.setText("" + this.rotation[0]);
        this.gRotation2 = new GuiTextField(this.fontRenderer, 100, 49, 40, 20);
        this.gRotation2.setMaxStringLength(6);
        this.gRotation2.setText("" + this.rotation[1]);
        this.gRotation3 = new GuiTextField(this.fontRenderer, 150, 49, 40, 20);
        this.gRotation3.setMaxStringLength(6);
        this.gRotation3.setText("" + this.rotation[2]);
        this.gScale1 = new GuiTextField(this.fontRenderer, 50, 84, 40, 20);
        this.gScale1.setMaxStringLength(6);
        this.gScale1.setText("" + this.scalation[0]);
        this.gScale2 = new GuiTextField(this.fontRenderer, 100, 84, 40, 20);
        this.gScale2.setMaxStringLength(6);
        this.gScale2.setText("" + this.scalation[1]);
        this.gScale3 = new GuiTextField(this.fontRenderer, 150, 84, 40, 20);
        this.gScale3.setMaxStringLength(6);
        this.gScale3.setText("" + this.scalation[2]);
        this.gTranslate1 = new GuiTextField(this.fontRenderer, 50, 121, 40, 20);
        this.gTranslate1.setMaxStringLength(6);
        this.gTranslate1.setText("" + this.position[0]);
        this.gTranslate2 = new GuiTextField(this.fontRenderer, 100, 121, 40, 20);
        this.gTranslate2.setMaxStringLength(6);
        this.gTranslate2.setText("" + this.position[1]);
        this.gTranslate3 = new GuiTextField(this.fontRenderer, 150, 121, 40, 20);
        this.gTranslate3.setMaxStringLength(6);
        this.gTranslate3.setText("" + this.position[2]);
        this.gXmin = new GuiTextField(this.fontRenderer, 210, 121, 40, 20);
        this.gXmin.setMaxStringLength(6);
        this.gXmin.setText("" + this.bbMinMax[0]);
        this.gYmin = new GuiTextField(this.fontRenderer, 260, 121, 40, 20);
        this.gYmin.setMaxStringLength(6);
        this.gYmin.setText("" + this.bbMinMax[1]);
        this.gZmin = new GuiTextField(this.fontRenderer, 310, 121, 40, 20);
        this.gZmin.setMaxStringLength(6);
        this.gZmin.setText("" + this.bbMinMax[2]);
        this.gXmax = new GuiTextField(this.fontRenderer, 210, 84, 40, 20);
        this.gXmax.setMaxStringLength(6);
        this.gXmax.setText("" + this.bbMinMax[3]);
        this.gYmax = new GuiTextField(this.fontRenderer, 260, 84, 40, 20);
        this.gYmax.setMaxStringLength(6);
        this.gYmax.setText("" + this.bbMinMax[4]);
        this.gZmax = new GuiTextField(this.fontRenderer, 310, 84, 40, 20);
        this.gZmax.setMaxStringLength(6);
        this.gZmax.setText("" + this.bbMinMax[5]);
    }

    protected void actionPerformed(GuiButton b) {
        if (b.id == 0) {
        	this.tile.setSkin(this.gSkin.getText());
        	if (!this.gSkin.getText().equals("!")) this.tile.setSkin(this.gSkin.getText());
        	else this.tile.resetSkin();
        	this.tile.setFacing(Integer.valueOf(this.gFacing.getText()));
        	this.tile.setRotation(Float.valueOf(this.gRotation1.getText()), Float.valueOf(this.gRotation2.getText()), Float.valueOf(this.gRotation3.getText()));
        	this.tile.setScalation(Float.valueOf(this.gScale1.getText()), Float.valueOf(this.gScale2.getText()), Float.valueOf(this.gScale3.getText()));
        	this.tile.setTranslation(Float.valueOf(this.gTranslate1.getText()), Float.valueOf(this.gTranslate2.getText()), Float.valueOf(this.gTranslate3.getText()));
        	this.tile.setBB(Float.valueOf(this.gXmin.getText()), Float.valueOf(this.gYmin.getText()), Float.valueOf(this.gZmin.getText()), Float.valueOf(this.gXmax.getText()), Float.valueOf(this.gYmax.getText()), Float.valueOf(this.gZmax.getText()));
        	this.mc.displayGuiScreen((GuiScreen)null);
            this.mc.setIngameFocus();
        } else if (b.id == 1) {
        	this.tile.setSkin(this.gSkin.getText());
        	if (!this.gSkin.getText().equals("!")) this.tile.setSkin(this.gSkin.getText());
        	else this.tile.resetSkin();
        	if (Integer.valueOf(this.gFacing.getText()) != -1) this.tile.setFacing(Integer.valueOf(this.gFacing.getText()));
        	this.tile.setRotation(Float.valueOf(this.gRotation1.getText()), Float.valueOf(this.gRotation2.getText()), Float.valueOf(this.gRotation3.getText()));
        	this.tile.setScalation(Float.valueOf(this.gScale1.getText()), Float.valueOf(this.gScale2.getText()), Float.valueOf(this.gScale3.getText()));
        	this.tile.setTranslation(Float.valueOf(this.gTranslate1.getText()), Float.valueOf(this.gTranslate2.getText()), Float.valueOf(this.gTranslate3.getText()));
        	this.tile.setBB(Float.valueOf(this.gXmin.getText()), Float.valueOf(this.gYmin.getText()), Float.valueOf(this.gZmin.getText()), Float.valueOf(this.gXmax.getText()), Float.valueOf(this.gYmax.getText()), Float.valueOf(this.gZmax.getText()));
        } else if (b.id == 3) this.tile.setFacing(this.tile.getFacing() + 1); 
        else if (b.id == 4) this.tile.setFacing(this.tile.getFacing() - 1);
        else if (b.id == 5) {
        	if (GuiScreen.isCtrlKeyDown()) this.tile.rotateX += 0.1F;
        	else if (GuiScreen.isShiftKeyDown()) this.tile.rotateX += 10.0F;
        	else  this.tile.rotateX++;
        } else if (b.id == 6) {
        	if (GuiScreen.isCtrlKeyDown()) this.tile.rotateX -= 0.1F;
        	else if (GuiScreen.isShiftKeyDown()) this.tile.rotateX -= 10.0F;
        	else  this.tile.rotateX--;
        } else if (b.id == 7) {
        	if (GuiScreen.isCtrlKeyDown()) this.tile.rotateY += 0.1F;
        	else if (GuiScreen.isShiftKeyDown()) this.tile.rotateY += 10.0F;
        	else  this.tile.rotateY++;
        } else if (b.id == 8) {
        	if (GuiScreen.isCtrlKeyDown()) this.tile.rotateY -= 0.1F;
        	else if (GuiScreen.isShiftKeyDown()) this.tile.rotateY -= 10.0F;
        	else  this.tile.rotateY--;
        } else if (b.id == 9) {
        	if (GuiScreen.isCtrlKeyDown()) this.tile.rotateZ += 0.1F;
        	else if (GuiScreen.isShiftKeyDown()) this.tile.rotateZ += 10.0F;
        	else  this.tile.rotateZ++;
        } else if (b.id == 10) {
        	if (GuiScreen.isCtrlKeyDown()) this.tile.rotateZ -= 0.1F;
        	else if (GuiScreen.isShiftKeyDown()) this.tile.rotateZ -= 10.0F;
        	else this.tile.rotateZ--;
        } else if (b.id == 11) {
        	if (GuiScreen.isCtrlKeyDown()) this.tile.scaleX += 0.1F;
        	else if (GuiScreen.isShiftKeyDown()) this.tile.scaleX += 10.0F;
        	else  this.tile.scaleX++;
        } else if (b.id == 12) {
        	if (GuiScreen.isCtrlKeyDown()) this.tile.scaleX -= 0.1F;
        	else if (GuiScreen.isShiftKeyDown()) this.tile.scaleX -= 10.0F;
        	else  this.tile.scaleX--;
        } else if (b.id == 13) {
        	if (GuiScreen.isCtrlKeyDown()) this.tile.scaleY += 0.1F;
        	else if (GuiScreen.isShiftKeyDown()) this.tile.scaleY += 10.0F;
        	else  this.tile.scaleY++;
        } else if (b.id == 14) {
        	if (GuiScreen.isCtrlKeyDown()) this.tile.scaleY -= 0.1F;
        	else if (GuiScreen.isShiftKeyDown()) this.tile.scaleY -= 10.0F;
        	else  this.tile.scaleY--;
        } else if (b.id == 15) {
        	if (GuiScreen.isCtrlKeyDown()) this.tile.scaleZ += 0.1F;
        	else if (GuiScreen.isShiftKeyDown()) this.tile.scaleZ += 10.0F;
        	else  this.tile.scaleZ++;
        } else if (b.id == 16) {
        	if (GuiScreen.isCtrlKeyDown()) this.tile.scaleZ -= 0.1F;
        	else if (GuiScreen.isShiftKeyDown()) this.tile.scaleZ -= 10.0F;
        	else this.tile.scaleZ--;
        } else if (b.id == 17) {
        	if (GuiScreen.isCtrlKeyDown()) this.tile.translateX += 0.1F;
        	else if (GuiScreen.isShiftKeyDown()) this.tile.translateX += 10.0F;
        	else  this.tile.translateX++;
        } else if (b.id == 18) {
        	if (GuiScreen.isCtrlKeyDown()) this.tile.translateX -= 0.1F;
        	else if (GuiScreen.isShiftKeyDown()) this.tile.translateX -= 10.0F;
        	else  this.tile.translateX--;
        } else if (b.id == 19) {
        	if (GuiScreen.isCtrlKeyDown()) this.tile.translateY += 0.1F;
        	else if (GuiScreen.isShiftKeyDown()) this.tile.translateY += 10.0F;
        	else  this.tile.translateY++;
        } else if (b.id == 20) {
        	if (GuiScreen.isCtrlKeyDown()) this.tile.translateY -= 0.1F;
        	else if (GuiScreen.isShiftKeyDown()) this.tile.translateY -= 10.0F;
        	else  this.tile.translateY--;
        } else if (b.id == 21) {
        	if (GuiScreen.isCtrlKeyDown()) this.tile.translateZ += 0.1F;
        	else if (GuiScreen.isShiftKeyDown()) this.tile.translateZ += 10.0F;
        	else  this.tile.translateZ++;
        } else if (b.id == 22) {
        	if (GuiScreen.isCtrlKeyDown()) this.tile.translateZ -= 0.1F;
        	else if (GuiScreen.isShiftKeyDown()) this.tile.translateZ -= 10.0F;
        	else this.tile.translateZ--;
        } else if (b.id == 23) {
        	if (GuiScreen.isCtrlKeyDown()) this.tile.bbXmin += 0.01F;
        	else if (GuiScreen.isShiftKeyDown()) this.tile.bbXmin += 1.0F;
        	else this.tile.bbXmin += 0.1F;
        } else if (b.id == 24) {
        	if (GuiScreen.isCtrlKeyDown()) this.tile.bbXmin -= 0.01F;
        	else if (GuiScreen.isShiftKeyDown()) this.tile.bbXmin -= 1.0F;
        	else  this.tile.bbXmin -= 0.1F;
        } else if (b.id == 25) {
        	if (GuiScreen.isCtrlKeyDown()) this.tile.bbYmin += 0.01F;
        	else if (GuiScreen.isShiftKeyDown()) this.tile.bbYmin += 1.0F;
        	else  this.tile.bbYmin += 0.1F;
        } else if (b.id == 26) {
        	if (GuiScreen.isCtrlKeyDown()) this.tile.bbYmin -= 0.01F;
        	else if (GuiScreen.isShiftKeyDown()) this.tile.bbYmin -= 1.0F;
        	else  this.tile.bbYmin -= 0.1F;
        } else if (b.id == 27) {
        	if (GuiScreen.isCtrlKeyDown()) this.tile.bbZmin += 0.01F;
        	else if (GuiScreen.isShiftKeyDown()) this.tile.bbZmin += 1.0F;
        	else  this.tile.bbZmin += 0.1F;
        } else if (b.id == 28) {
        	if (GuiScreen.isCtrlKeyDown()) this.tile.bbZmin -= 0.01F;
        	else if (GuiScreen.isShiftKeyDown()) this.tile.bbZmin -= 1.0F;
        	else this.tile.bbZmin -= 0.1F;
        } else if (b.id == 29) {
        	if (GuiScreen.isCtrlKeyDown()) this.tile.bbXmax += 0.01F;
        	else if (GuiScreen.isShiftKeyDown()) this.tile.bbXmax += 1.0F;
        	else this.tile.bbXmax += 0.1F;
        } else if (b.id == 30) {
        	if (GuiScreen.isCtrlKeyDown()) this.tile.bbXmax -= 0.01F;
        	else if (GuiScreen.isShiftKeyDown()) this.tile.bbXmax -= 1.0F;
        	else  this.tile.bbXmax -= 0.1F;
        } else if (b.id == 31) {
        	if (GuiScreen.isCtrlKeyDown()) this.tile.bbYmax += 0.01F;
        	else if (GuiScreen.isShiftKeyDown()) this.tile.bbYmax += 1.0F;
        	else  this.tile.bbYmax += 0.1F;
        } else if (b.id == 32) {
        	if (GuiScreen.isCtrlKeyDown()) this.tile.bbYmax -= 0.01F;
        	else if (GuiScreen.isShiftKeyDown()) this.tile.bbYmax -= 1.0F;
        	else  this.tile.bbYmax -= 0.1F;
        } else if (b.id == 33) {
        	if (GuiScreen.isCtrlKeyDown()) this.tile.bbZmax += 0.01F;
        	else if (GuiScreen.isShiftKeyDown()) this.tile.bbZmax += 1.0F;
        	else  this.tile.bbZmax += 0.1F;
        } else if (b.id == 34) {
        	if (GuiScreen.isCtrlKeyDown()) this.tile.bbZmax -= 0.01F;
        	else if (GuiScreen.isShiftKeyDown()) this.tile.bbZmax -= 1.0F;
        	else this.tile.bbZmax -= 0.1F;
        }
        this.gFacing.setText("" + this.tile.getFacing());
        this.gRotation1.setText("" + this.tile.rotateX);
        this.gRotation2.setText("" + this.tile.rotateY);
        this.gRotation3.setText("" + this.tile.rotateZ);
        this.gScale1.setText("" + this.tile.scaleX);
        this.gScale2.setText("" + this.tile.scaleY);
        this.gScale3.setText("" + this.tile.scaleZ);
        this.gTranslate1.setText("" + this.tile.translateX);
        this.gTranslate2.setText("" + this.tile.translateY);
        this.gTranslate3.setText("" + this.tile.translateZ);
        this.gXmin.setText("" + this.tile.bbXmin);
        this.gYmin.setText("" + this.tile.bbYmin);
        this.gZmin.setText("" + this.tile.bbZmin);
        this.gXmax.setText("" + this.tile.bbXmax);
        this.gYmax.setText("" + this.tile.bbYmax);
        this.gZmax.setText("" + this.tile.bbZmax);
        PacketDispatcher.sendPacketToServer(CDDPacketData.buildPacket(this.tile.xCoord, this.tile.yCoord, this.tile.zCoord, this.tile.rotateX, this.tile.rotateY, this.tile.rotateZ, this.tile.getFacing(), this.tile.texture, this.tile.scaleX, this.tile.scaleY, this.tile.scaleZ, this.tile.translateX, this.tile.translateY, this.tile.translateZ, this.tile.bbXmin, this.tile.bbYmin, this.tile.bbZmin, this.tile.bbXmax, this.tile.bbYmax, this.tile.bbZmax));
    }
    
    @Override
    public void onGuiClosed() {
        PacketDispatcher.sendPacketToServer(CDDPacketData.buildPacket(this.tile.xCoord, this.tile.yCoord, this.tile.zCoord, this.tile.rotateX, this.tile.rotateY, this.tile.rotateZ, this.tile.getFacing(), this.tile.texture, this.tile.scaleX, this.tile.scaleY, this.tile.scaleZ, this.tile.translateX, this.tile.translateY, this.tile.translateZ, this.tile.bbXmin, this.tile.bbYmin, this.tile.bbZmin, this.tile.bbXmax, this.tile.bbYmax, this.tile.bbZmax));
        Keyboard.enableRepeatEvents(false);
    }

    public void updateScreen() {
        super.updateScreen();
        this.gFacing.updateCursorCounter();
        this.gSkin.updateCursorCounter();
        this.gRotation1.updateCursorCounter();
        this.gRotation2.updateCursorCounter();
        this.gRotation3.updateCursorCounter();
        this.gScale1.updateCursorCounter();
        this.gScale2.updateCursorCounter();
        this.gScale3.updateCursorCounter();
        this.gTranslate1.updateCursorCounter();
        this.gTranslate2.updateCursorCounter();
        this.gTranslate3.updateCursorCounter();
        this.gXmin.updateCursorCounter();
        this.gYmin.updateCursorCounter();
        this.gZmin.updateCursorCounter();
        this.gXmax.updateCursorCounter();
        this.gYmax.updateCursorCounter();
        this.gZmax.updateCursorCounter();
    }

    public void drawScreen(int par1, int par2, float par3) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRenderer, "Editing: " + this.blockName + " - " + this.blockId + " - " + this.coords[0] + "," + this.coords[1] + "," + this.coords[2], this.width / 2, 10, 16777215);
        this.drawString(this.fontRenderer, "Facing", this.width - 110, 55, 16777215);
        this.drawString(this.fontRenderer, "Skin", 90, 165, 16777215);
        this.drawString(this.fontRenderer, "Rotation", 2, 55, 16777215);
        this.drawString(this.fontRenderer, "Scalation", 2, 90, 16777215);
        this.drawString(this.fontRenderer, "Position", 2, 125, 16777215);
        this.drawString(this.fontRenderer, "Block bounds [Buggy]", 210, 55, 16777215);
        this.drawString(this.fontRenderer, "X", 235, 71, 16777215);
        this.drawString(this.fontRenderer, "Y", 285, 71, 16777215);
        this.drawString(this.fontRenderer, "Z", 335, 71, 16777215);
        this.drawString(this.fontRenderer, "X", 78, 36, 16777215);
        this.drawString(this.fontRenderer, "Y", 128, 36, 16777215);
        this.drawString(this.fontRenderer, "Z", 178, 36, 16777215);
        this.drawString(this.fontRenderer, "To reset - '!'", this.width / 2 - 30, 150, 16777215);
        this.gFacing.drawTextBox();
        this.gSkin.drawTextBox();
        this.gRotation1.drawTextBox();
        this.gRotation2.drawTextBox();
        this.gRotation3.drawTextBox();
        this.gScale1.drawTextBox();
        this.gScale2.drawTextBox();
        this.gScale3.drawTextBox();
        this.gTranslate1.drawTextBox();
        this.gTranslate2.drawTextBox();
        this.gTranslate3.drawTextBox();
        this.gXmin.drawTextBox();
        this.gYmin.drawTextBox();
        this.gZmin.drawTextBox();
        this.gXmax.drawTextBox();
        this.gYmax.drawTextBox();
        this.gZmax.drawTextBox();
        super.drawScreen(par1, par2, par3);
    }
    
    protected void keyTyped(char par1, int par2) {
    	super.keyTyped(par1, par2);
        this.gFacing.textboxKeyTyped(par1, par2);
        this.gSkin.textboxKeyTyped(par1, par2);
        this.gRotation1.textboxKeyTyped(par1, par2);
        this.gRotation2.textboxKeyTyped(par1, par2);
        this.gRotation3.textboxKeyTyped(par1, par2);
        this.gScale1.textboxKeyTyped(par1, par2);
        this.gScale2.textboxKeyTyped(par1, par2);
        this.gScale3.textboxKeyTyped(par1, par2);
        this.gTranslate1.textboxKeyTyped(par1, par2);
        this.gTranslate2.textboxKeyTyped(par1, par2);
        this.gTranslate3.textboxKeyTyped(par1, par2);
        this.gXmin.textboxKeyTyped(par1, par2);
        this.gYmin.textboxKeyTyped(par1, par2);
        this.gZmin.textboxKeyTyped(par1, par2);
        this.gXmax.textboxKeyTyped(par1, par2);
        this.gYmax.textboxKeyTyped(par1, par2);
        this.gZmax.textboxKeyTyped(par1, par2);
        if (par2 == 15) {
            this.gFacing.setFocused(!this.gFacing.isFocused());
            this.gSkin.setFocused(!this.gSkin.isFocused());
            this.gRotation1.setFocused(!this.gRotation1.isFocused());
            this.gRotation2.setFocused(!this.gRotation2.isFocused());
            this.gRotation3.setFocused(!this.gRotation3.isFocused());
            this.gScale1.setFocused(!this.gScale1.isFocused());
            this.gScale2.setFocused(!this.gScale2.isFocused());
            this.gScale3.setFocused(!this.gScale3.isFocused());
            this.gTranslate1.setFocused(!this.gTranslate1.isFocused());
            this.gTranslate2.setFocused(!this.gTranslate2.isFocused());
            this.gTranslate3.setFocused(!this.gTranslate3.isFocused());
            this.gXmin.setFocused(!this.gXmin.isFocused());
            this.gYmin.setFocused(!this.gYmin.isFocused());
            this.gZmin.setFocused(!this.gZmin.isFocused());
            this.gXmax.setFocused(!this.gXmax.isFocused());
            this.gYmax.setFocused(!this.gYmax.isFocused());
            this.gZmax.setFocused(!this.gZmax.isFocused());
        }        
    }
    
    protected void mouseClicked(int par1, int par2, int par3) {
        super.mouseClicked(par1, par2, par3);
        this.gFacing.mouseClicked(par1, par2, par3);
        this.gSkin.mouseClicked(par1, par2, par3);
        this.gRotation1.mouseClicked(par1, par2, par3);
        this.gRotation2.mouseClicked(par1, par2, par3);
        this.gRotation3.mouseClicked(par1, par2, par3);
        this.gScale1.mouseClicked(par1, par2, par3);
        this.gScale2.mouseClicked(par1, par2, par3);
        this.gScale3.mouseClicked(par1, par2, par3);
        this.gTranslate1.mouseClicked(par1, par2, par3);
        this.gTranslate2.mouseClicked(par1, par2, par3);
        this.gTranslate3.mouseClicked(par1, par2, par3);
        this.gXmin.mouseClicked(par1, par2, par3);
        this.gYmin.mouseClicked(par1, par2, par3);
        this.gZmin.mouseClicked(par1, par2, par3);
        this.gXmax.mouseClicked(par1, par2, par3);
        this.gYmax.mouseClicked(par1, par2, par3);
        this.gZmax.mouseClicked(par1, par2, par3);
    }
    
    public boolean doesGuiPauseGame() {
        return false;
    }
}
