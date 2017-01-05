package com.siderislabs.projectmendeleev.init;

import com.siderislabs.projectmendeleev.items.ItemMedalDiamond;
import com.siderislabs.projectmendeleev.items.ItemMedalGold;
import com.siderislabs.projectmendeleev.items.ItemVial;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModItems {

	public static Item Vial;
	public static Item MedalGold;
	public static Item MedalDiamond;
	
	public static void init() {
		Vial = new ItemVial();
		MedalGold = new ItemMedalGold();
		MedalDiamond = new ItemMedalDiamond();
	}
	public static void register() {
		GameRegistry.register(MedalGold);
		GameRegistry.register(MedalDiamond);
		GameRegistry.register(Vial);
	}
	public static void registerRenders() {
		registerRender(MedalGold);
		registerRender(MedalDiamond);
		registerRender(Vial);
	}
	private static void registerRender(Item item) {
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
		System.out.println("Registered item. Registry name: " + item.getRegistryName() + ". Unlocalized name: " + item.getUnlocalizedName());
	}
}
