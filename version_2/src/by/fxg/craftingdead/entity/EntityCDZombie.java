package by.fxg.craftingdead.entity;

import by.fxg.craftingdead.damage.DamageSourceZombie;
import by.fxg.craftingdead.entity.ai.EntityCDAIAttackOnCollide;
import by.fxg.craftingdead.item.ItemManager;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentThorns;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBreakDoor;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class EntityCDZombie extends EntityMob {
	private String randomZombieTexture = "";

	public EntityCDZombie(World par1World) {
		super(par1World);
		this.setSize(1.0F, 2.0F);
		this.randomZombieTexture = "" + (1 + super.rand.nextInt(21));
		this.getNavigator().setBreakDoors(false);
		super.tasks.addTask(2, new EntityCDAIAttackOnCollide(this, EntityPlayer.class, 1.0D, false));
		super.tasks.addTask(4, new EntityAIMoveTowardsRestriction(this, 1.0D));
		super.tasks.addTask(5, new EntityAIMoveThroughVillage(this, 1.0D, false));
		super.tasks.addTask(6, new EntityAIWander(this, 0.8D));
		super.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		super.tasks.addTask(7, new EntityAILookIdle(this));
		super.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
		super.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
	}

	protected void entityInit() {
		super.entityInit();
	}

	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setAttribute(30.0D);
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute(10.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setAttribute(0.24D + (double) (super.rand.nextFloat() / 10.0F));
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setAttribute(3.0D);
	}

	public int getTotalArmorValue() {
		int i = super.getTotalArmorValue() + 2;
		if (i > 20) {
			i = 20;
		}
		return i;
	}

	public void onEntityUpdate() {
		super.onEntityUpdate();
		World world = this.worldObj;
		if (!world.isRemote) {
			boolean isDay = (world.getWorldTime() % 16000L) > 7000L && (world.getWorldTime() % 16000L) > 13500L;
			if (!isDay) {
				this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setAttribute(0.285D + (double) (super.rand.nextFloat() / 10.0F));
			} else {
				this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setAttribute(0.24D + (double) (super.rand.nextFloat() / 10.0F));
			}
		}
	}

	public String getRandomSkin() {
		return this.randomZombieTexture;
	}

	public boolean getCanSpawnHere() {
		return true;
	}

	protected boolean isAIEnabled() {
		return true;
	}

	protected String getLivingSound() {
		return "mob.zombie.say";
	}

	protected String getHurtSound() {
		return "mob.zombie.hurt";
	}

	protected String getDeathSound() {
		return "mob.zombie.death";
	}

	protected void playStepSound(int par1, int par2, int par3, int par4) {
		this.playSound("mob.zombie.step", 0.15F, 1.0F);
	}

	protected int getDropItemId() {
		return 0;
	}

	protected void dropFewItems(boolean par1, int par2) {
		int j = this.getDropItemId();
		if (j > 0) {
			this.dropItem(j, 1);
		}
	}

	public int getAttackStrength(Entity par1Entity) {
		return 4;
	}

	public boolean attackEntityAsMob(Entity par1Entity) {
		int i = this.getAttackStrength(par1Entity);
		boolean flag = par1Entity.attackEntityFrom(new DamageSourceZombie(this), (float) i);
		if (flag) {
			int k = EnchantmentHelper.getFireAspectModifier(this);
			if (k > 0) {
				par1Entity.setFire(k * 4);
			}
			if (par1Entity instanceof EntityLiving) {
				EnchantmentThorns.func_92096_a(this, (EntityLiving) par1Entity, super.rand);
			}
		}
		return flag;
	}

	public EnumCreatureAttribute getCreatureAttribute() {
		return EnumCreatureAttribute.UNDEFINED;
	}
}
