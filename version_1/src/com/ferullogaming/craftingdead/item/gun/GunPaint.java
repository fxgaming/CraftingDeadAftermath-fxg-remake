package com.ferullogaming.craftingdead.item.gun;

import java.lang.reflect.Field;

public class GunPaint {
	public static GunPaint[] gunSkinsList = new GunPaint[128];
	public static GunPaint ASMO = new GunPaint(1, "Азимов", "asmo");
	public static GunPaint CYREX = new GunPaint(2, "Сайрекс", "cyrex");
	public static GunPaint VULCAN = new GunPaint(3, "Вулкан", "vulcan");
	public static GunPaint GEM = new GunPaint(4, "Кристалл", "gem");
	public static GunPaint FADE = new GunPaint(5, "Градиент", "fade");
	public static GunPaint RUBY = new GunPaint(6, "Рубин", "ruby");
	public static GunPaint UV = new GunPaint(7, "Ультрафиолет", "uv");
	public static GunPaint CandyApple = new GunPaint(8, "Красное яблоко", "candyapple");
	private String displayName;
	private String texture;
	public int skinID;

	public GunPaint(int par1) {
		this.skinID = par1;
		gunSkinsList[par1] = this;
	}

	public GunPaint(int par1, String par2, String par3) {
		this(par1);
		this.displayName = par2;
		this.texture = par3;
	}

	public String getTextureSuffix() {
		return this.texture;
	}

	public String getDisplayName() {
		return this.displayName;
	}

	public static GunPaint getPaintFromField(String par1) {
		Field[] fields = CYREX.getClass().getDeclaredFields();

		for (int i = 0; i < fields.length; ++i) {
			if (fields[i].getName().equals(par1)) {
				try {
					return (GunPaint) fields[i].get(CYREX);
				} catch (IllegalArgumentException var4) {
					var4.printStackTrace();
				} catch (IllegalAccessException var5) {
					var5.printStackTrace();
				}
			}
		}

		return null;
	}
}
