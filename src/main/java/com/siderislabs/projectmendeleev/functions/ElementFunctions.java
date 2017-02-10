package com.siderislabs.projectmendeleev.functions;

import java.util.ArrayList;

import net.minecraft.item.ItemStack;

public class ElementFunctions {

	static ArrayList<ItemStack> AtomItems = new ArrayList<ItemStack>();
	static ArrayList<String> AtomStrings = new ArrayList<String>();
	
	public static void AddNewElement(ItemStack item, String name) {
		if(!AtomItems.contains(item)) {
			AtomItems.add(item);
			AtomStrings.add(name);
		}
		else {
			System.err.println("Error: An attempt was made to register " + name + "twice.");
		}
	}
	
	public static ItemStack RetrieveElementFromString(String name, Integer quantity) {
		if (AtomStrings.contains(name)) {
				ItemStack result = AtomItems.get(AtomStrings.indexOf(name));
				result.stackSize = quantity;
				return result;
		}
		else {
			return null;
		}
	}

	public String RetrieveStringFromElement(ItemStack item) {
		if(AtomItems.contains(item)) {
			return(AtomStrings.get(AtomItems.indexOf(item)));
		}
		else {
			return null;
		}
	}
}
