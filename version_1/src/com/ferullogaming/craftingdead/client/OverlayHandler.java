package com.ferullogaming.craftingdead.client;

import java.awt.Color;

import org.lwjgl.opengl.GL11;

import com.ferullogaming.craftingdead.CDAftermath;
import com.ferullogaming.craftingdead.player.PlayerData;
import com.ferullogaming.craftingdead.player.PlayerDataHandler;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ForgeSubscribe;

public class OverlayHandler {
	private Minecraft mc = Minecraft.getMinecraft();
	private FontRenderer font = Minecraft.getMinecraft().fontRenderer;
	public static float swing;

	public OverlayHandler() {
		MinecraftForge.EVENT_BUS.register(this);
	}

	@ForgeSubscribe
	public void onWorldRenderLast(RenderWorldLastEvent event) {
		++this.swing;
	}

	@ForgeSubscribe
	public void overlay(RenderGameOverlayEvent.Pre e) {
		if (e.type == e.type.ARMOR) {
			e.setCanceled(true);
		}
		if (e.type == e.type.JUMPBAR) {
			e.setCanceled(true);
		}
		if (e.type == e.type.HEALTH) {
			e.setCanceled(true);
		}
		if (e.type == e.type.FOOD) {
			e.setCanceled(true);
		}
		if (e.type == e.type.BOSSHEALTH) {
			e.setCanceled(true);
		}
		if (e.type == e.type.EXPERIENCE) {
			e.setCanceled(true);
		}
		if (e.type == e.type.HEALTHMOUNT) {
			e.setCanceled(true);
		}
		if (e.type == e.type.AIR) {
			e.setCanceled(true);
		}
		if (e.type == e.type.HOTBAR) {
			//e.setCanceled(true);
			Minecraft mc = Minecraft.getMinecraft();
			ScaledResolution sr = new ScaledResolution(mc.gameSettings, mc.displayWidth, mc.displayHeight);
			ResourceLocation ico = new ResourceLocation("craftingdead:textures/gui/ui/icons.png");
			ResourceLocation healthe = new ResourceLocation("craftingdead:textures/gui/ui/health_empty.png");
			ResourceLocation foode = new ResourceLocation("craftingdead:textures/gui/ui/food_empty.png");
			ResourceLocation watere = new ResourceLocation("craftingdead:textures/gui/ui/water_empty.png");
			ResourceLocation blood = new ResourceLocation("craftingdead:textures/gui/ui/blood.png");
			ResourceLocation infect = new ResourceLocation("craftingdead:textures/gui/ui/health_infected.png");
			ResourceLocation cap1 = new ResourceLocation("craftingdead:textures/gui/ui/bottlecap.png");
			ResourceLocation cap2 = new ResourceLocation("craftingdead:textures/gui/ui/bottlegold.png");
			ResourceLocation stamina = new ResourceLocation("craftingdead:textures/gui/ui/sprintbar1.png");
			ResourceLocation staminae = new ResourceLocation("craftingdead:textures/gui/ui/sprintbar.png");
			PlayerData data = CDAftermath.instance.playerDataHandler().getClientPlayerData();
			GL11.glPushMatrix();
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
			CDRenderHelper.drawImage(sr.getScaledWidth() - 40, sr.getScaledHeight() - 60, data.isPotionInfected ? infect : healthe, 40, 40);
			CDRenderHelper.drawImage(sr.getScaledWidth() - 40, sr.getScaledHeight() - 100, foode, 40, 40);
			CDRenderHelper.drawImage(sr.getScaledWidth() - 40, sr.getScaledHeight() - 140, watere, 40, 40);
			if (data.isPotionBleeding) CDRenderHelper.drawImage(sr.getScaledWidth() - 20, sr.getScaledHeight() - 160, blood, 20, 20);
			if (data.isPotionInfected) CDRenderHelper.drawImage(sr.getScaledWidth() - 40, sr.getScaledHeight() - 160, infect, 20, 20);
			if (data.isPotionLegBroken) {
				CDRenderHelper.renderItemStackIntoGUI(new ItemStack(9941, 1, 0), sr.getScaledWidth() - 18, sr.getScaledHeight() - 176);
			}
			int mf = mc.thePlayer.getFoodStats().getFoodLevel() * 2 - 40;
			Minecraft.getMinecraft().renderEngine.bindTexture(ico);
			CDRenderHelper.drawTexturedModalRect(sr.getScaledWidth() - 40, sr.getScaledHeight() - 100 - mf, 141, 12 - mf, 40, 40 - mf);
			mf = (int)mc.thePlayer.getHealth() * 2 - 40;
			CDRenderHelper.drawTexturedModalRect(sr.getScaledWidth() - 40, sr.getScaledHeight() - 60 - mf, 13, 12 - mf, 40, 40 - mf);
			mf = data.getWaterLevels().getWaterLevels() / 900 - 40;
			CDRenderHelper.drawTexturedModalRect(sr.getScaledWidth() - 40, sr.getScaledHeight() - 140 - mf, 77, 12 - mf, 40, 40 - mf);
			if (data.getStamina().getStamina() != data.getStamina().getStaminaMax()) {
				CDRenderHelper.drawImage(sr.getScaledWidth() / 2 - 50, sr.getScaledHeight() - 30, staminae, 100, 5);
				Minecraft.getMinecraft().renderEngine.bindTexture(stamina);
				mf = data.getStamina().getStamina() / 2 - 100;
				CDRenderHelper.drawTexturedModalRect(sr.getScaledWidth() / 2 - 49, sr.getScaledHeight() - 29, 0, 0, 98 + mf, 3);
			}
			int perc = (int)mc.thePlayer.getHealth() * 5;
			CDRenderHelper.renderCenteredText(perc + "%", sr.getScaledWidth() - 20, sr.getScaledHeight() - 44);
			perc = (int)mc.thePlayer.getFoodStats().getFoodLevel() * 5;
			CDRenderHelper.renderCenteredText(perc + "%", sr.getScaledWidth() - 20, sr.getScaledHeight() - 80);
			perc = (int)(data.getWaterLevels().getWaterLevels() / 360);
			CDRenderHelper.renderCenteredText(perc + "%", sr.getScaledWidth() - 20, sr.getScaledHeight() - 120);
			
			CDRenderHelper.drawRect(0, 5, 16 + (this.mc.fontRenderer.getStringWidth("" + data.coins)), 10, "0x000000", 0.6F);
			CDRenderHelper.drawImage(-1, 3, cap1, 16.0D, 16.0D);
			CDRenderHelper.drawRect(0, 15, 16 + (this.mc.fontRenderer.getStringWidth("" + data.donatecoins)), 10, "0x000000", 0.6F);
			CDRenderHelper.drawImage(-1, 13, cap2, 16.0D, 16.0D);
			float[] a = Color.RGBtoHSB(255, 250, 0, new float[]{55, 100, 100});
			CDRenderHelper.renderText("" + data.coins, 15, 7, Color.HSBtoRGB(a[0], a[1], a[2]));
			CDRenderHelper.renderText("" + data.donatecoins, 15, 17, Color.HSBtoRGB(a[0], a[1], a[2]));
			GL11.glDisable(GL11.GL_BLEND);
			GL11.glPopMatrix();
		}
		if (e.type == e.type.CROSSHAIRS) {
			if (!Minecraft.getMinecraft().thePlayer.capabilities.isCreativeMode) e.setCanceled(true);
		}
	}
}
