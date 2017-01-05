package com.siderislabs.projectmendeleev.config;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.siderislabs.projectmendeleev.Starter;
import com.siderislabs.projectmendeleev.functions.AtomFunctions;

import net.minecraft.item.ItemStack;

public class RecipeConfig {
	
	private static ArrayList<ItemStack> results;

	public static ArrayList<ItemStack> getDecomposerRecipeForEntity(ItemStack itemStack) throws IOException {
		final List<String> fileContents = FileUtils.readLines(new File(Starter.getModConfigDir().getPath() + File.separator + "projectm" + File.separator + itemStack.getItem().getRegistryName().toString().split(":")[0] + ".txt"));
		System.out.println("File contents: " + fileContents);
		String[] fileContents2 = fileContents.get(0).split(":");
		String thingToFind = itemStack.getItem().getRegistryName().toString().split(":")[1];
		System.out.println("Thing:" + thingToFind);
		for (int i = 0; i < fileContents2.length; i++) {
			System.out.println("Array contents: " + fileContents2[i]);
		}
		if(fileContents2[0].contains(thingToFind)) {
			ArrayList<ItemStack> results = new ArrayList<ItemStack>();
			for (int i = 1; i < fileContents2.length; i++) {
				if(i % 2 == 1 ) {
					results.add(AtomFunctions.GetElementData(fileContents2[i], Integer.valueOf(fileContents2[i + 1])));
					
				}
			}
			System.out.println("Found the thing");
			System.out.println("Results: " + results.toString());
			return results;
		}
		else {
			System.out.println("Didn't find the thing");
			results.add(itemStack);
			return results;
		}
	}
}
