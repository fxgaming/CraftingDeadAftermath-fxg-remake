package com.ferullogaming.craftingdead.client;

import java.util.ArrayList;

import com.ferullogaming.craftingdead.CDAftermath;
import com.ferullogaming.craftingdead.client.render.guns.IRenderPartialTick;
import com.ferullogaming.craftingdead.client.util.BulletCollisionBox;
import com.ferullogaming.craftingdead.player.PlayerData;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.client.renderer.entity.RendererLivingEntity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.IItemRenderer.ItemRenderType;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.client.event.RenderPlayerEvent.Specials.Pre;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.player.PlayerEvent.NameFormat;

public class RenderEvents {
	private Minecraft mc = Minecraft.getMinecraft();

	public RenderEvents() {
		MinecraftForge.EVENT_BUS.register(this);
	}

	@ForgeSubscribe
	public void onPlayerNameFormated(NameFormat event) {
		if (Minecraft.getMinecraft() != null && Minecraft.getMinecraft().thePlayer != null) {
			PlayerData dataDisplayed = CDAftermath.instance.playerDataHandler().getPlayerData(event.username);
			if (event.entityPlayer.capabilities.isCreativeMode)
				event.displayname = "§7[§aTechnical§7]§r " + event.username;
			//event.displayname = event.username;
		}
	}

	@ForgeSubscribe
	public void onRenderLivingTag(Pre event) {
		if (Minecraft.getMinecraft() != null && Minecraft.getMinecraft().thePlayer != null) {
			EntityPlayer mcPlayer = Minecraft.getMinecraft().thePlayer;
			PlayerData data = CDAftermath.instance.playerDataHandler().getPlayerData(mcPlayer.username);
			RenderPlayer var10000 = event.renderer;
			RendererLivingEntity.NAME_TAG_RANGE = 64.0F;
			var10000 = event.renderer;
			RendererLivingEntity.NAME_TAG_RANGE_SNEAK = 32.0F;
			PlayerData data2 = CDAftermath.instance.playerDataHandler().getPlayerData(event.entityPlayer.username);
			if (!data.canViewUsername) {
				var10000 = event.renderer;
				RendererLivingEntity.NAME_TAG_RANGE = 0.0F;
				var10000 = event.renderer;
				RendererLivingEntity.NAME_TAG_RANGE_SNEAK = 0.0F;
				if (Minecraft.getMinecraft().objectMouseOver != null && Minecraft.getMinecraft().objectMouseOver.entityHit != null && Minecraft.getMinecraft().objectMouseOver.entityHit instanceof EntityPlayer) {
					EntityPlayer playerHit = (EntityPlayer) Minecraft.getMinecraft().objectMouseOver.entityHit;
					if (playerHit.username.toLowerCase().equals(event.entityPlayer.username.toLowerCase())) {
						var10000 = event.renderer;
						RendererLivingEntity.NAME_TAG_RANGE = 64.0F;
						var10000 = event.renderer;
						RendererLivingEntity.NAME_TAG_RANGE_SNEAK = 32.0F;
					}
				}
			}

//         if (data.hasClanData() && data2.tempClan != null && data.getClientClanData().clanNameTag.equals(data2.tempClan)) {
//            var10000 = event.renderer;
//            RendererLivingEntity.NAME_TAG_RANGE = 64.0F;
//            var10000 = event.renderer;
//            RendererLivingEntity.NAME_TAG_RANGE_SNEAK = 32.0F;
//         }
		}
	}

	@ForgeSubscribe
	public void renderWorldLastEvent(RenderWorldLastEvent evt) {
		EntityPlayer player = this.mc.thePlayer;
		PlayerData playerData = CDAftermath.instance.playerDataHandler().getPlayerData((EntityPlayer) player);
		CDRenderHelper.particleTick = evt.partialTicks;
		if (player != null) {
			if (playerData.isAiming) {
				Minecraft.getMinecraft().entityRenderer.renderHand(evt.partialTicks, 0);
			}

			ItemStack itemstack = player.getCurrentEquippedItem();
			if (itemstack != null) {
				IItemRenderer customRenderer = MinecraftForgeClient.getItemRenderer(itemstack, ItemRenderType.EQUIPPED_FIRST_PERSON);
				if (customRenderer != null && customRenderer instanceof IRenderPartialTick) {
					((IRenderPartialTick) customRenderer).setPartialTick(evt.partialTicks);
				}
			}
		}

	}
}
