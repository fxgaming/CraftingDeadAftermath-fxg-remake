package com.fxg.decoration;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MathHelper;

public class CDDUtils {
	public static String secondsToTimeFormatted(long sec) {
		long seconds = sec % 60L;
		long minutes = sec / 60L;
		if (minutes >= 60L) {
			long hours = minutes / 60L;
			minutes %= 60L;
			if (hours >= 24L) {
				long days = hours / 24L;
				return String.format("%d дней %02d:%02d:%02d", days, hours % 24L, minutes, seconds);
			} else {
				return String.format("%02d:%02d:%02d", hours, minutes, seconds);
			}
		} else {
			return String.format("00:%02d:%02d", minutes, seconds);
		}
	}

	public static double getDistanceToClientCamera(double x, double y, double z) {
		double d3 = RenderManager.instance.viewerPosX - x;
		double d4 = RenderManager.instance.viewerPosY - y;
		double d5 = RenderManager.instance.viewerPosZ - z;
		return (double) MathHelper.sqrt_double(d3 * d3 + d4 * d4 + d5 * d5);
	}

	public static void renderCenteredTextScaledWithOutline(String text, int posX, int posY, double par4, int givenColor) {
		double width = (double) (Minecraft.getMinecraft().fontRenderer.getStringWidth(text) / 2) * par4;
		GL11.glPushMatrix();
		GL11.glTranslated((double) posX - width, (double) posY, 0.0D);
		GL11.glScaled(par4, par4, par4);
		Minecraft.getMinecraft().fontRenderer.drawString(EnumChatFormatting.BLACK + text, -1, -1, 0);
		Minecraft.getMinecraft().fontRenderer.drawString(EnumChatFormatting.BLACK + text, 1, -1, 0);
		Minecraft.getMinecraft().fontRenderer.drawString(EnumChatFormatting.BLACK + text, -1, 1, 0);
		Minecraft.getMinecraft().fontRenderer.drawString(EnumChatFormatting.BLACK + text, 1, 1, 0);
		Minecraft.getMinecraft().fontRenderer.drawString(EnumChatFormatting.BLACK + text, 0, -1, 0);
		Minecraft.getMinecraft().fontRenderer.drawString(EnumChatFormatting.BLACK + text, -1, 0, 0);
		Minecraft.getMinecraft().fontRenderer.drawString(EnumChatFormatting.BLACK + text, 1, 0, 0);
		Minecraft.getMinecraft().fontRenderer.drawString(EnumChatFormatting.BLACK + text, 0, 1, 0);
		Minecraft.getMinecraft().fontRenderer.drawString(text, 0, 0, givenColor);
		GL11.glPopMatrix();
	}
}
