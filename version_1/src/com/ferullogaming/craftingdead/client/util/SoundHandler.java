package com.ferullogaming.craftingdead.client.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import com.ferullogaming.craftingdead.client.AmbienceHandler;
import com.ferullogaming.craftingdead.item.gun.ItemGun;

import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.SoundManager;
import net.minecraft.client.audio.SoundPool;
import net.minecraft.client.audio.SoundPoolEntry;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ForgeSubscribe;
import paulscode.sound.SoundSystem;

public class SoundHandler {
	public static ArrayList soundFiles;
	private AmbienceHandler ambienceHandler;
	public static SoundPool soundPoolMusic;

	public SoundHandler() {
		MinecraftForge.EVENT_BUS.register(this);
		this.ambienceHandler = new AmbienceHandler();
	}

	public void onIngameUpdate() {
		this.ambienceHandler.onClientTick();
	}

	public AmbienceHandler getAmbienceHandler() {
		return this.ambienceHandler;
	}

	public void addSound(String str) {
		soundFiles.add(str);
	}

	@ForgeSubscribe
	public void onSoundsLoaded(SoundLoadEvent evt) {
		soundFiles = new ArrayList();
		this.addSound("gunEmpty");
		this.addSound("gunFiremode");
		this.addSound("gunPulled");
		this.addSound("zoomin");
		this.addSound("flame");
		this.addSound("flamestart");
		this.addSound("flameout");
		this.addSound("ambient_cd_1");
		this.addSound("ambient_cd_2");
		this.addSound("ambient_cd_3");
		this.addSound("ambient_cd_4");
		this.addSound("ambient_cd_5");
		this.addSound("ambient_cd_6");
		this.addSound("bulletimpact_dirt");
		this.addSound("bulletimpact_flesh");
		this.addSound("bulletimpact_flesh_vest");
		this.addSound("bulletimpact_glass");
		this.addSound("bulletimpact_metal");
		this.addSound("bulletimpact_metal2");
		this.addSound("bulletimpact_stone");
		this.addSound("bulletimpact_water");
		this.addSound("bulletimpact_wood");
		this.addSound("pipebomb_beep");
		this.addSound("headshot");
		this.addSound("gun_break");
		this.addSound("ost1");
		this.addSound("ost2");

		this.addAmbience();
		
		soundPoolMusic = new SoundPool(Minecraft.getMinecraft().getResourceManager(), "sound", true);
		Random rand = new Random();
		soundPoolMusic.addSound("craftingdead:ost" + (rand.nextInt(2) + 1) + ".ogg");
		for (int i = 0; i < Item.itemsList.length; ++i) {
			if (Item.itemsList[i] != null && Item.itemsList[i] instanceof ItemGun) {
				ItemGun gun = (ItemGun) Item.itemsList[i];
				if (gun.soundFire != null && gun.soundFire.length() > 0) {
					this.addSound(gun.soundFire.trim().toLowerCase());
				}

				if (gun.soundSupressed != null && gun.soundSupressed.length() > 0) {
					this.addSound(gun.soundSupressed.trim().toLowerCase());
				}

				if (gun.soundReload != null && gun.soundReload.length() > 0) {
					this.addSound(gun.soundReload.trim().toLowerCase());
				}
			}
		}
		SoundManager manager = evt.manager;
		boolean flag = true;
		Iterator var4 = soundFiles.iterator();
		while (var4.hasNext()) {
			String sound = (String) var4.next();
			try {
				manager.addSound("craftingdead:" + sound + ".ogg");
			} catch (Exception var7) {
				System.out.println("FAILED to load sound: " + sound);
				flag = false;
			}
		}
		if (!flag) System.out.println("DAYZ SOUND Failed to load!");
	}

	public static void playMenuMusic() {
		Minecraft mc = Minecraft.getMinecraft();
		SoundManager soundManager = mc.sndManager;
		SoundSystem soundHandler = soundManager.sndSystem;
		if (!soundManager.sndSystem.playing("BGMusic") && !soundManager.sndSystem.playing("streaming")) {
			soundManager.stopAllSounds();
			SoundPoolEntry soundpoolentry = soundPoolMusic.getRandomSound();
			if (soundpoolentry != null) {
				soundManager.sndSystem.backgroundMusic("BGMusic", soundpoolentry.getSoundUrl(), soundpoolentry.getSoundName(), false);
				soundManager.sndSystem.setVolume("BGMusic", Minecraft.getMinecraft().gameSettings.musicVolume);
				soundManager.sndSystem.play("BGMusic");
			}
		} else soundManager.sndSystem.setVolume("BGMusic", Minecraft.getMinecraft().gameSettings.musicVolume);
	}

	public static void stopMenuMusic() {
		try {
			if (Minecraft.getMinecraft().sndManager.sndSystem.playing("BGMusic")) Minecraft.getMinecraft().sndManager.sndSystem.stop("BGMusic");
		} catch (Exception e) {}
	}
	
	public void addAmbience() {
		this.addSound("block/bell");
		this.addSound("block/belldistant");
		this.addSound("block/tinhit0");
		this.addSound("block/tinhit1");
		this.addSound("block/tinhit2");
		this.addSound("block/tinhit3");
		this.addSound("block/electricbox0_");
		this.addSound("block/electricbox1_");
	}
}
