package com.fxg.decoration.block;

import java.util.Random;

import com.fxg.decoration.CDDecoration;
import com.fxg.decoration.tile.TileBaseProp;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class BlockBaseProp extends BlockSided {
	private int guiId = 0;
	private TileBaseProp tile = null;
	private String tilename = "";
	private boolean hasSound = false;
	private String sound = "";
	private Double soundDelay = 0.0D;
	private Float soundLong = 0.0F;
	private Integer soundMod = 0;
	private Boolean isCollideable = true;

	public BlockBaseProp(int id) {
		super(id);
	}

	public BlockBaseProp(int id, int guid) {
		super(id);
		this.guiId = guid;
	}

	public BlockBaseProp(int id, TileBaseProp tile) {
		super(id);
		this.tile = tile;
	}
	
	public BlockBaseProp(int id, String tile) {
		super(id);
		this.tilename = tile;
	}

	public BlockBaseProp(int id, int guid, TileBaseProp tile) {
		super(id);
		this.guiId = guid;
		this.tile = tile;
	}

	public BlockBaseProp install(String unlocalizedName) {
		this.setUnlocalizedName("cdd." + unlocalizedName);
		this.setResistance(9999.0F);
		this.setBlockUnbreakable();
		//this.setCreativeTab(CDDecoration.tabDecor);
		return this;
	}

	public BlockBaseProp setSkinable() {
		this.guiId = 11;
		return this;
	}

	public BlockBaseProp setRotateable() {
		this.guiId = 10;
		return this;
	}
	
	public BlockBaseProp setNoCollide() {
		this.isCollideable = false;
		return this;
	}
	
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1, int par2, int par3, int par4) {
        return this.isCollideable ? super.getCollisionBoundingBoxFromPool(par1, par2, par3, par4) : null;
    }
	
	public BlockBaseProp setSound(String s, Double delay, Float Long, Integer Mod) {
		this.sound = s;
		this.soundDelay = delay;
		this.soundLong = Long;
		this.soundMod = Mod;
		this.hasSound = true;
		return this;
	}
	
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World world, int x, int y, int z, Random random) {
        double d = Math.random();
        if (this.soundDelay > 1 || this.soundDelay == 0.0D) {
        	if (this.hasSound && random.nextInt(this.soundMod) == this.soundDelay) {
        		 world.playSound((double)((float)x + 0.5f), (double)((float)y + 0.5f), (double)((float)z + 0.5f), "craftingdead:" + this.sound, 10.0f, 1.0f, false);
        	}
        } else {
	        if (d > this.soundDelay && this.hasSound) {
	            world.playSound((double)((float)x + 0.5f), (double)((float)y + 0.5f), (double)((float)z + 0.5f), "craftingdead:" + this.sound, this.soundLong, 1.0f, false);
	        }
        }
    }

	@Override
	public boolean onBlockActivated(World par1World, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9) {
		if (!player.isSneaking() && player.capabilities.isCreativeMode) {
			TileBaseProp var10 = (TileBaseProp)par1World.getBlockTileEntity(x, y, z);
			if (var10 != null) {
				player.openGui(CDDecoration.instance, this.guiId, par1World, x, y, z);
			}
			
			return true;
		} else {
			return false;
		}
	}

	public TileEntity createNewTileEntity(World world) {
		return null;
	}

	public TileEntity createTileEntity(World world, int metadata) {
		if (!this.tilename.equals("")) {
			
			try {
				Class clazz = Class.forName("com.fxg.decoration.tile.block." + this.tilename);
				return (TileEntity)clazz.newInstance();
			} catch (Exception e) {
				System.out.println("[ERROR] Skipped creating tileEntity for " + this.getClass().getSimpleName() + ", because mapping is missing.");
				return null;
			}
		}
		return this.tile == null ? new TileBaseProp() : this.tile;
	}

	public int getRenderType() {
		return -1;
	}

	public boolean isOpaqueCube() {
		return false;
	}

    public boolean renderAsNormalBlock() {
        return false;
    }

	public void registerIcons(IconRegister par1IconRegister) {
		super.blockIcon = par1IconRegister.registerIcon("cddecoration");
	}
}
