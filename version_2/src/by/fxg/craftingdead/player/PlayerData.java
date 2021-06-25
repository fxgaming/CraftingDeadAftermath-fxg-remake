package by.fxg.craftingdead.player;

import java.util.HashMap;

import by.fxg.craftingdead.block.BlockManager;
import by.fxg.craftingdead.block.TileEntityBaseCenter;
import by.fxg.craftingdead.inventory.InventoryCDA;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;

public class PlayerData {
	public String username;
	public boolean isShooting = false;
	public boolean isAiming = false;
	public float spread = 0.1F;
	public float defaultSpread = 0.1F;
	public float maxSpread = 6.0F;
	public int killedPlayers = 0;
	public int killedZombies = 0;
	public int daysSurvived = 0;
	public int timeAlive = 0;
	public boolean isNightVisionActive = false;
	public int potionBleedingDelay = 0;
	public int potionRBIDelay = 0;
	public int potionParticleBleedingDelay = 0;
	public int potionParticleRBIDelay = 0;
	public int potionParticleBrokenLegDelay = 0;
	public boolean isPotionBleeding = false;
	public boolean isPotionInfected = false;
	public boolean isPotionLegBroken = false;
	public float soundLevels = 0.0F;
	public int soundUpdateTick = 0;
	public double flashTime = 0.0D;
	public int playerBulletInteractBlockDelay = 0;
	private InventoryCDA inventoryCDA = new InventoryCDA();
	private WaterLevels playerWaterLevels;
	private StaminaLevels stamina;
	public int lastArmorLevel = 0;
	public boolean canViewUsername = true;
	public boolean canTakeBulletDamage = true;
	public boolean canTakeBloodDamage = true;
	public boolean canTakeInfectionDamage = true;
	public boolean canThrowGrenades = true;
	public static final int antiCombatLoggingWait = 100;
	public int antiCombatLoggingWaitTick = 0;
	public boolean killPlayerForCombatLogging = false;
	public int inCombatTick = 0;
	public int inCombatTickMax = 600;
	public int flamethrowerFuelCount = 0;
	public boolean isHandCuffed = false;
	public int handcuffDamage = 0;
	public static final int handcuffMaxDamage = 200;
	public int coins = 0;
	public int donatecoins = 0;

	public PlayerData(String par1) {
		this.username = par1;
		this.playerWaterLevels = new WaterLevels(this);
		this.stamina = new StaminaLevels(this);
	}

	public void readFromNBT(NBTTagCompound par1) {
		this.inventoryCDA.readFromNBT(par1.getTagList("cdainv"));
		this.killedPlayers = par1.getInteger("pkills");
		this.killedZombies = par1.getInteger("zkills");
		this.daysSurvived = par1.getInteger("days");
		this.timeAlive = par1.getInteger("timealive");
		this.playerWaterLevels.setWaterLevel(par1.hasKey("water") ? par1.getInteger("water") : this.playerWaterLevels.getWaterLevelMax());
		this.stamina.setStamina(par1.hasKey("stamina") ? par1.getInteger("stamina") : this.stamina.getStaminaMax());
		this.isHandCuffed = par1.getBoolean("handcuff");
		this.handcuffDamage = par1.getInteger("handdam");
		this.coins = par1.getInteger("coins");
		this.donatecoins = par1.getInteger("donatecoins");
	}

	public void writeToNBT(NBTTagCompound par1) {
		NBTTagList list = new NBTTagList();
		this.inventoryCDA.writeToNBT(list);
		par1.setTag("cdainv", list);
		par1.setInteger("pkills", this.killedPlayers);
		par1.setInteger("zkills", this.killedZombies);
		par1.setInteger("days", this.daysSurvived);
		par1.setInteger("timealive", this.timeAlive);
		par1.setInteger("water", this.playerWaterLevels.getWaterLevels());
		par1.setInteger("stamina", this.stamina.getStamina());
		par1.setBoolean("handcuff", this.isHandCuffed);
		par1.setInteger("handdam", this.handcuffDamage);
		par1.setInteger("coins", this.coins);
		par1.setInteger("donatecoins", this.donatecoins);
	}

	public void onPlayerDeath() {
		this.playerWaterLevels = new WaterLevels(this);
		this.stamina = new StaminaLevels(this);
		this.isAiming = false;
		this.timeAlive = 0;
		this.daysSurvived = 0;
		this.killedZombies = 0;
		this.killedPlayers = 0;
		this.antiCombatLoggingWaitTick = 0;
		this.isHandCuffed = false;
		this.handcuffDamage = 0;
		this.coins = (int) ((this.coins / 100) * 75);
	}

	public boolean isInCombat() {
		return this.inCombatTick > 0;
	}

	public void clearPlayerInventory() {
		this.inventoryCDA = new InventoryCDA();
	}

	public InventoryCDA getCDInventory() {
		return this.inventoryCDA;
	}

	public WaterLevels getWaterLevels() {
		return this.playerWaterLevels;
	}

	public StaminaLevels getStamina() {
		return this.stamina;
	}

	public void addSpread(float par1) {
		this.spread += par1;
		if (this.spread > this.maxSpread) {
			this.spread = this.maxSpread;
		}
	}

	public void addSoundLevels(float par1) {
		this.soundLevels += par1;
		if (this.soundLevels > 2.0F) {
			this.soundLevels = 2.0F;
		}
	}

	public int getSoundTravelDistance() {
		return (int)(this.soundLevels * 60.0F);
	}
}
