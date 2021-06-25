package com.ferullogaming.craftingdead;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import com.ferullogaming.craftingdead.block.BlockLootSpawner;
import com.ferullogaming.craftingdead.entity.EntityGroundItem;
import com.ferullogaming.craftingdead.entity.EntityPlayerHead;
import com.ferullogaming.craftingdead.inventory.InventoryFuelTanks;
import com.ferullogaming.craftingdead.item.ItemClothing;
import com.ferullogaming.craftingdead.item.ItemClothingArmor;
import com.ferullogaming.craftingdead.item.ItemClothingJuggernaut;
import com.ferullogaming.craftingdead.item.ItemFuelTank;
import com.ferullogaming.craftingdead.item.ItemFuelTankBackpack;
import com.ferullogaming.craftingdead.item.ItemManager;
import com.ferullogaming.craftingdead.item.potion.PotionManager;
import com.ferullogaming.craftingdead.network.CDAPacketPlayerDataToPlayer;
import com.ferullogaming.craftingdead.player.PlayerData;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.common.network.Player;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

//ДЫРА!!! ОЗУ!!!
public class CommonTickHandler implements ITickHandler {
	private int refreshLootRadius = 10000; // 250m
	private int refreshLootRadiusPlayerAwayDistance = 2500; // 250m
	private int refreshLootTick = 0;
	private int refreshLootTickSeconds = 1800; // 30min VO TUT

	private int delayUpdatePlayerDataToClients = 0;
	private int delayUpdateArmor = 0;
	private int delayUpdateInventory = 0;
	private int delayUpdatePlayerHeadHitbox = 0;
	private int delayUpdateDays = 0;
	public ArrayList playerHeads = new ArrayList();

	public CommonTickHandler() {
		TickRegistry.registerTickHandler(this, Side.SERVER);
	}

	public void tickStart(EnumSet type, Object... tickData) {
	}

	public void tickEnd(EnumSet type, Object... tickData) {
		if (type.equals(EnumSet.of(TickType.PLAYER))) {
			this.onPlayerTick((EntityPlayer) tickData[0]);
		} else if (type.equals(EnumSet.of(TickType.SERVER))) {
			this.onServerTick(MinecraftServer.getServer());
		}
	}

	private void onServerTick(MinecraftServer server) {
		int i;
		WorldServer world;
		int i1;
		EntityPlayer player;
		if (this.refreshLootTick++ >= this.refreshLootTickSeconds * 20) {
			for (i = 0; i < server.worldServers.length; ++i) {
				world = server.worldServers[i];
				for (i1 = 0; i1 < world.playerEntities.size(); ++i1) {
					player = (EntityPlayer) world.playerEntities.get(i1);
					this.refreshLootAroundPlayer(player, this.refreshLootRadius);
				}
			}
			this.refreshLootTick = 0;
		}
		if (this.delayUpdatePlayerDataToClients++ >= 3) {
			for (i = 0; i < server.worldServers.length; ++i) {
				world = server.worldServers[i];
				for (i1 = 0; i1 < world.playerEntities.size(); ++i1) {
					player = (EntityPlayer) world.playerEntities.get(i1);
					ArrayList playersNear = getPlayersAround(player, ServerManager.PLAYER_PACKET_DISPATCH);
					Iterator var7 = playersNear.iterator();
					while (var7.hasNext()) {
						EntityPlayer player1 = (EntityPlayer) var7.next();
						PacketDispatcher.sendPacketToPlayer(CDAPacketPlayerDataToPlayer.buildPacket(player1), (Player) player);
					}
				}
			}
			this.delayUpdatePlayerDataToClients = 0;
		}
	}

	private void onPlayerTick(EntityPlayer player) {
		World world = player.worldObj;
		PlayerData data = CDAftermath.instance.playerDataHandler().getPlayerData(player);
		InventoryPlayer inv = player.inventory;
		++data.timeAlive;
		if (data.antiCombatLoggingWaitTick > 0) {
			--data.antiCombatLoggingWaitTick;
		}
		if (data.isHandCuffed && data.handcuffDamage >= 200) {
			data.isHandCuffed = false;
			data.handcuffDamage = 0;
			player.worldObj.playSoundAtEntity(player, "random.break", 1.5F, 1.0F);
		}
		if (FMLCommonHandler.instance().getSide() == Side.SERVER && data.killPlayerForCombatLogging) {
			data.clearPlayerInventory();
			player.inventory.clearInventory(-1, -1);
			player.sendChatToPlayer(ChatMessageComponent.createFromText(EnumChatFormatting.RED + "Combat Logging was detected, punishment invoking."));
			EntityPlayerMP entityplayermp = (EntityPlayerMP) player;
			entityplayermp.hurtResistantTime = 0;
			entityplayermp.attackEntityFrom(DamageSource.outOfWorld, Float.MAX_VALUE);
			data.killPlayerForCombatLogging = false;
		}
		if (this.delayUpdateDays++ >= 1200) {
			if (data.timeAlive % 24000 == 0) {
				++data.daysSurvived;
			}
			this.delayUpdateDays = 0;
		}
		int i;
		if (this.delayUpdatePlayerHeadHitbox++ >= 10) {
			if (player instanceof EntityPlayerMP) {
				if (!this.hasHeadRegistered(player)) {
					EntityPlayerHead head = new EntityPlayerHead(world);
					head.player = player;
					head.setPosition(player.posX, player.posY, player.posZ);
					world.spawnEntityInWorld(head);
					this.playerHeads.add(head);
				}
				for (i = 0; i < this.playerHeads.size(); ++i) {
					if (((EntityPlayerHead) this.playerHeads.get(i)).isDead || ((EntityPlayerHead) this.playerHeads.get(i)).player.isDead) {
						this.playerHeads.remove(i);
					}
				}
			}
			this.delayUpdatePlayerHeadHitbox = 0;
		}
		if (player.capabilities.isCreativeMode) {
			if (player.isPotionActive(PotionManager.brokenLeg.id)) {
				player.removePotionEffect(PotionManager.brokenLeg.id);
			}
			if (player.isPotionActive(PotionManager.bleeding.id)) {
				player.removePotionEffect(PotionManager.bleeding.id);
			}
			if (player.isPotionActive(PotionManager.RBInfection.id)) {
				player.removePotionEffect(PotionManager.RBInfection.id);
			}
		}
		if (data.soundLevels > 0.0F) {
			data.soundLevels -= 0.05F;
			if (data.soundLevels < 0.0F) {
				data.soundLevels = 0.0F;
			}
		}
		if (data.playerBulletInteractBlockDelay > 0) {
			--data.playerBulletInteractBlockDelay;
		}
		data.getWaterLevels().applyWaterUpdate(player);
		data.getStamina().applyStaminaUpdate(player);
		if (!player.capabilities.isCreativeMode && !player.isPotionActive(PotionManager.brokenLeg.id) && player.onGround && player.fallDistance > 0.0F && !player.isInWater()) {
			if (player.fallDistance > 4.0F) {
				Random rand = new Random();
				if (rand.nextInt(3) == 0) {
					player.sendChatToPlayer(ChatMessageComponent.createFromText(EnumChatFormatting.RED + "Ouch! You broke your leg!"));
					player.addPotionEffect(new PotionEffect(PotionManager.brokenLeg.id, 9999999, 4));
					player.addPotionEffect(new PotionEffect(Potion.blindness.id, 100, 1));
				}
			} else if (player.fallDistance > 10.0F) {
				player.sendChatToPlayer(ChatMessageComponent.createFromText(EnumChatFormatting.RED + "Ouch! You broke your leg!"));
				player.addPotionEffect(new PotionEffect(PotionManager.brokenLeg.id, 9999999, 4));
				player.addPotionEffect(new PotionEffect(Potion.blindness.id, 100, 1));
			}
		}
		int var1;
		if (this.delayUpdateInventory++ > 1) {
			ItemStack stack;
			if (data.getCDInventory() != null) {
				InventoryFuelTanks inv1 = (InventoryFuelTanks) ItemFuelTankBackpack.getTanksInventory(player);
				if (inv1 != null) {
					var1 = 0;
					for (var1 = 0; var1 < inv1.getSizeInventory(); ++var1) {
						ItemStack stack1 = inv1.getStackInSlot(var1);
						if (stack1 != null) {
							ItemFuelTank tank = (ItemFuelTank) stack1.getItem();
							var1 += tank.clipSize - stack1.getItemDamage();
						}
					}
					data.flamethrowerFuelCount = var1;
				}
				if (data.getCDInventory().getStack("clothing") != null) {
					stack = data.getCDInventory().getStack("clothing");
					if (stack.getItem() instanceof ItemClothingJuggernaut) {
						player.addPotionEffect(new PotionEffect(PotionManager.juggernautEffect.id, 9999999, 1));
					} else if (player.isPotionActive(PotionManager.juggernautEffect)) {
						player.removePotionEffect(PotionManager.juggernautEffect.id);
					}
				} else if (player.isPotionActive(PotionManager.juggernautEffect)) {
					player.removePotionEffect(PotionManager.juggernautEffect.id);
				}
			}
			for (i = 0; i < inv.getSizeInventory(); ++i) {
				stack = inv.getStackInSlot(i);
				if (i != 37 && i != 38 && i != 39 && stack != null) {
					if (stack.getItem() instanceof ItemClothingArmor) {
						inv.setInventorySlotContents(i, (ItemStack) null);
					} else if (stack.stackSize <= stack.getMaxStackSize()) {
						if (FMLCommonHandler.instance().getSide() == Side.SERVER && !MinecraftServer.getServer().getConfigurationManager().isPlayerOpped(player.username)) {
							var1 = stack.itemID - 256;
							if (stack.getItem() instanceof ItemBlock) {
								inv.setInventorySlotContents(i, (ItemStack) null);
							} else if (!ItemManager.whitelistedCraftingDeadItems.contains(var1) && !ItemManager.whitelistedCraftingDeadItems.contains(stack.itemID)) {
								inv.setInventorySlotContents(i, (ItemStack) null);
							}
						}
					} else {
						var1 = stack.stackSize - stack.getMaxStackSize();
						if (var1 > 16) {
							var1 = 16;
						}
						for (int i1 = 0; i1 < var1; ++i1) {
							ItemStack newStack = new ItemStack(stack.getItem(), 1, 0);
							if (!inv.addItemStackToInventory(newStack)) {
								EntityGroundItem groundItem = new EntityGroundItem(player.worldObj, player.posX, player.posY, player.posZ);
								groundItem.setEntityItemStack(newStack);
								player.worldObj.spawnEntityInWorld(groundItem);
							}
						}
						stack.stackSize = stack.getMaxStackSize();
					}
				}
			}

			this.delayUpdateInventory = 0;
		}
		if (this.delayUpdateArmor++ > 4) {
			if (FMLCommonHandler.instance().getSide() == Side.SERVER) {
				this.delayUpdateArmor = 0;
				return;
			}
			ItemStack clothingStack = data.getCDInventory().getStack("clothing");
			if (clothingStack == null) {
				for (var1 = 0; var1 < inv.armorInventory.length; ++var1) {
					if (inv.armorInventory[var1] != null) {
						inv.armorInventory[var1] = null;
					}
				}
			} else {
				var1 = ItemClothing.getClothingArmorLevel(clothingStack);
				if (data.lastArmorLevel != var1) {
					for (var1 = 0; var1 < inv.armorInventory.length; ++var1) {
						if (inv.armorInventory[var1] != null) {
							inv.armorInventory[var1] = null;
						}
					}

					data.lastArmorLevel = var1;
				}
				switch (var1) {
				case 1:
					if (inv.getStackInSlot(39) == null) {
						inv.setInventorySlotContents(39, new ItemStack(ItemManager.defaultArmorH));
					}
					break;
				case 2:
					if (inv.getStackInSlot(39) == null) {
						inv.setInventorySlotContents(39, new ItemStack(ItemManager.defaultArmorH));
					}

					if (inv.getStackInSlot(38) == null) {
						inv.setInventorySlotContents(38, new ItemStack(ItemManager.defaultArmorC));
					}
					break;
				case 3:
					if (inv.getStackInSlot(39) == null) {
						inv.setInventorySlotContents(39, new ItemStack(ItemManager.defaultArmorH));
					}

					if (inv.getStackInSlot(38) == null) {
						inv.setInventorySlotContents(38, new ItemStack(ItemManager.defaultArmorC));
					}

					if (inv.getStackInSlot(37) == null) {
						inv.setInventorySlotContents(37, new ItemStack(ItemManager.defaultArmorL));
					}
				}
			}
			this.delayUpdateArmor = 0;
		}
	}

	public static ArrayList getPlayersAround(EntityPlayer par1, int par2) {
		ArrayList list = new ArrayList();
		AxisAlignedBB box = AxisAlignedBB.getBoundingBox(par1.posX - (double) par2, par1.posY - (double) par2, par1.posZ - (double) par2, par1.posX + (double) par2, par1.posY + (double) par2, par1.posZ + (double) par2);
		List entities = par1.worldObj.getEntitiesWithinAABB(EntityPlayer.class, box);

		for (int i = 0; i < entities.size(); ++i) {
			Entity entity = (Entity) entities.get(i);
			if (entity instanceof EntityPlayer) {
				list.add((EntityPlayer) entity);
			}
		}

		return list;
	}

	public boolean hasHeadRegistered(EntityPlayer par1) {
		for (int i = 0; i < this.playerHeads.size(); ++i) {
			if (((EntityPlayerHead) this.playerHeads.get(i)).player == par1) {
				return true;
			}
		}

		return false;
	}

	public void refreshLootAroundPlayer(EntityPlayer player, int radius) {
		int posX = (int) player.posX;
		int posY = (int) player.posY;
		int posZ = (int) player.posZ;
		int yRadius = 15;

		for (int x = -radius; x < radius; ++x) {
			for (int y = -yRadius; y < yRadius; ++y) {
				for (int z = -radius; z < radius; ++z) {
					int blockid = player.worldObj.getBlockId(posX + x, posY + y, posZ + z);
					if (blockid != 0 && Block.blocksList[blockid] instanceof BlockLootSpawner && player.getDistance((double) (posX + x), (double) (posY + y), (double) (posZ + z)) > (double) this.refreshLootRadiusPlayerAwayDistance) {
						BlockLootSpawner spawner = (BlockLootSpawner) Block.blocksList[blockid];
						if (spawner.canSpawnLoot()) {
							int blockidup = player.worldObj.getBlockId(posX + x, posY + y + 1, posZ + z);
							if (blockidup == 0) {
								player.worldObj.setBlock(posX + x, posY + y + 1, posZ + z, spawner.lootBlockID);
							}
						}
					}
				}
			}
		}

	}

	public EnumSet ticks() {
		return EnumSet.of(TickType.PLAYER, TickType.SERVER);
	}

	public String getLabel() {
		return "commontick";
	}
}
