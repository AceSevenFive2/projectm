package com.siderislabs.projectmendeleev.init;

import com.siderislabs.projectmendeleev.items.ItemDevCommentary;
import com.siderislabs.projectmendeleev.items.ItemMedalDiamond;
import com.siderislabs.projectmendeleev.items.ItemMedalGold;
import com.siderislabs.projectmendeleev.items.ItemVial;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModItems {

	public static Item Vial;
	public static Item MedalGold;
	public static Item MedalDiamond;
	public static Item DevCommentary;
	
	public static void init() {
		Vial = new ItemVial();
		MedalGold = new ItemMedalGold();
		MedalDiamond = new ItemMedalDiamond();
		DevCommentary = new ItemDevCommentary();
	}
	public static void register() {
		GameRegistry.register(MedalGold);
		GameRegistry.register(MedalDiamond);
		GameRegistry.register(Vial);
		GameRegistry.register(DevCommentary);
	    GameRegistry.addRecipe(new ItemStack(DevCommentary), new Object[]{
	            "SBS",
	            "TFT",
	            "OBO",
	            		'S', Items.STRING, 
	            		'B', Items.BREAD,
	            		'T', Items.GHAST_TEAR,
	            		'F', Items.FEATHER,  
	            		'O', Items.BOOK
	});
	}
	public static void registerRenders() {
		registerRender(MedalGold);
		registerRender(MedalDiamond);
		registerRender(Vial);
		registerRender(DevCommentary);
	}
	private static void registerRender(Item item) {
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
		System.out.println("Registered item. Registry name: " + item.getRegistryName() + ". Unlocalized name: " + item.getUnlocalizedName());
	}
}
