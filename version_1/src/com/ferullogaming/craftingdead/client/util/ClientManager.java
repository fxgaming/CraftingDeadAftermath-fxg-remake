package com.ferullogaming.craftingdead.client.util;

import java.util.ArrayList;

import com.ferullogaming.craftingdead.CDAftermath;
import com.ferullogaming.craftingdead.client.ClientTickHandler;

import cpw.mods.fml.client.registry.KeyBindingRegistry;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.client.Minecraft;

public class ClientManager extends Thread {
	private ClientGunTicker clientGunUpdater;
	private ClientTickHandler clientTickHandler;
	private FakePlayerManager fakePlayerManager;
	private TickChecker tickChecker;
	public ArrayList notifications = new ArrayList();
	public ClientNotification currentNotification;
	private String dirLocation = "";
	public static boolean isGameLoading = true;

	public ClientManager(FMLPreInitializationEvent event) {
		Runtime.getRuntime().addShutdownHook(this);
		this.fakePlayerManager = new FakePlayerManager();
		KeyBindingRegistry.registerKeyBinding(new KeyBindingManager());
		this.tickChecker = new TickChecker();
	}

	public void initMod() {
		this.clientTickHandler = new ClientTickHandler();
		this.clientGunUpdater = new ClientGunTicker(Minecraft.getMinecraft());
		this.clientGunUpdater.start();
	}

	public void run() {
		CDAftermath.instance.getSoundHandler().getAmbienceHandler().shutdownAmbience();
		if (this.clientGunUpdater != null) {
			this.clientGunUpdater.stopThread();
			this.clientGunUpdater.interrupt();
			this.clientGunUpdater = null;
		}
	}

	public static ClientManager instance() {
		return CDAftermath.instance.getClientManager();
	}

	public ClientTickHandler getClientTickHandler() {
		return this.clientTickHandler;
	}

	public FakePlayerManager getFakePlayerManager() {
		return this.fakePlayerManager;
	}
}
