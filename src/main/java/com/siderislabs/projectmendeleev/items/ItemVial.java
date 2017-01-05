package com.siderislabs.projectmendeleev.items;

import java.util.List;

import com.siderislabs.projectmendeleev.Reference;
import com.siderislabs.projectmendeleev.functions.AtomFunctions;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemVial extends Item {
	
 	public ItemVial() {
		setUnlocalizedName(Reference.ModdedItems.VIAL.getUnlocalizedName());
		setRegistryName(Reference.ModdedItems.VIAL.getRegistryName());
		this.setCreativeTab(CreativeTabs.MISC);
		this.setMaxStackSize(64);
	}

@Override
public void getSubItems(Item item, CreativeTabs tab, List<ItemStack> subItems) {
	NBTTagCompound tagCompound = new NBTTagCompound();
	ItemStack atom = new ItemStack(item);
	tagCompound.setString("Element", AtomFunctions.elements[0]);
	tagCompound.setString("State", AtomFunctions.possiblestates[3]);
	atom.setTagCompound(tagCompound);
	subItems.add(atom);
}

@SideOnly(Side.CLIENT)
public void addInformation(ItemStack item, EntityPlayer player, List<String> tooltip, boolean advanced) {
	NBTTagCompound tagCompound = item.getTagCompound();
	tooltip.add("Like a bookshelf for your atoms. Shift-right click with this in your hand to empty it.");
	if(tagCompound != null) {
		tooltip.add("Element: " + tagCompound.getString("Element"));
		tooltip.add("State: " + tagCompound.getString("State"));
	}
	else {
		tooltip.add("This item is missing NBT data. Don't put this in a ProjectM machine, it'll probably crash your game.");
	}
}
}
