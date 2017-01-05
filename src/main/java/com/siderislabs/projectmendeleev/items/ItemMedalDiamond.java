package com.siderislabs.projectmendeleev.items;

import java.util.List;

import com.siderislabs.projectmendeleev.Reference;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemMedalDiamond extends Item {
	
 	public ItemMedalDiamond() {
		setUnlocalizedName(Reference.ModdedItems.MEDALDIAMOND.getUnlocalizedName());
		setRegistryName(Reference.ModdedItems.MEDALDIAMOND.getRegistryName());
		this.setCreativeTab(CreativeTabs.MISC);
	}

@SideOnly(Side.CLIENT)
public void addInformation(ItemStack item, EntityPlayer player, List<String> tooltip, boolean advanced) {
	System.out.println("Player: " + player.getName());
	String tmp = player.getName();
	if(tmp.contains("DerpField")) {
		tooltip.add("Awarded to: DerpField");
		tooltip.add("Grade: Diamond");
		tooltip.add("Issued: December 24th, 2016");
	}
	else {
		tooltip.add("Invalid Medal");
	}
}
}