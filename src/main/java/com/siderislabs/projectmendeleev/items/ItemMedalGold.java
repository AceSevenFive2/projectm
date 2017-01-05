package com.siderislabs.projectmendeleev.items;

import java.util.List;

import com.siderislabs.projectmendeleev.Reference;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemMedalGold extends Item {
	
 	public ItemMedalGold() {
		setUnlocalizedName(Reference.ModdedItems.MEDALGOLD.getUnlocalizedName());
		setRegistryName(Reference.ModdedItems.MEDALGOLD.getRegistryName());
		this.setCreativeTab(CreativeTabs.MISC);
	}

@SideOnly(Side.CLIENT)
public void addInformation(ItemStack item, EntityPlayer player, List<String> tooltip, boolean advanced) {
	System.out.println("Player: " + player.getName());
	String tmp = player.getName();
	if (tmp.contains("TehNut")) {
		tooltip.add("Awarded to: TehNut");
		tooltip.add("Grade: Gold");
		tooltip.add("Issued: January 1st, 2017");
	}
	else {
		tooltip.add("Invalid Medal");
	}
}
}