package com.siderislabs.projectmendeleev.functions;

import org.apache.commons.lang3.ArrayUtils;

import com.siderislabs.projectmendeleev.items.ItemVial;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import scala.actors.threadpool.Arrays;

public class AtomFunctions {
	
	public static String[] elements = { "Hydrogen", "Helium", "Lithium", "Beryllium", "Boron", "Carbon", "Nitrogen", "Oxygen", "Fluorine", "Neon", "Sodium", "Magnesium", "Aluminum", "Silicon", "Phosphorous", "Sulfur", "Chlorine", "Argon", "Potassium", "Calcium", "Scandium", "Titanium", "Vanadium", "Chromium", "Manganese", "Iron", "Cobalt", "Nickel", "Copper", "Zinc", "Gallium", "Germanium", "Arsenic", "Selenium", "Bromine", "Krypton", "Rubidium", "Strontium", "Yttrium", "Zirconium", "Niobium", "Molybdenum", "Technetium", "Ruthenium", "Rhodium", "Palladium", "Silver", "Cadmium", "Indium", "Tin", "Antimony", "Tellurium", "Iodine", "Xenon", "Caesium", "Barium", "Lanthanum", "Cerium", "Praesodymium", "Neodymium", "Prothemium", "Samarium", "Europium", "Gadolinium", "Terbium", "Dysprosium", "Holmium", "Erbium", "Thulium", "Ytterbium", "Lutetium", "Hafnium", "Tantalum", "Tungsten", "Rhenium", "Osmium", "Iridium", "Platinum", "Gold", "Mercury", "Thallium", "Lead", "Bismuth", "Polonium", "Astatine", "Radon", "Francium", "Radium", "Actinium", "Thorium", "Protactinium", "Uranium", "Neptunium", "Plutonium", "Americium", "Curium", "Berkelium", "Californium", "Einsteinium", "Fermium", "Mendelevium", "Nobelium", "Lawrencium", "Rutherfordium", "Dubnium", "Seaborgium", "Bohrium", "Hassium", "Meitnerium", "Darmstadium", "Roentgenium", "Copernicium", "Nihonium", "Flerovium", "Moscovium", "Livermorium", "Tennessine", "Oganesson"}; 
	public static String[] state = { "Gas", "Gas", "Solid", "Solid", "Solid", "Solid", "Gas", "Gas", "Gas", "Gas", "Solid", "Solid", "Solid", "Solid", "Solid", "Solid", "Gas", "Gas", "Solid", "Solid", "Solid", "Solid", "Solid", "Solid", "Solid", "Solid", "Solid", "Solid", "Solid", "Solid", "Solid", "Solid", "Solid", "Solid", "Liquid", "Gas", "Solid", "Solid", "Solid", "Solid", "Solid", "Solid", "Solid", "Solid", "Solid", "Solid", "Solid", "Solid", "Solid", "Solid", "Solid", "Solid", "Solid", "Solid", "Solid", "Gas", "Solid", "Solid", "Solid", "Solid", "Solid", "Solid", "Solid", "Solid", "Solid", "Solid", "Solid", "Solid", "Solid", "Solid", "Solid", "Solid", "Solid", "Solid", "Solid", "Solid", "Solid", "Solid", "Solid", "Solid", "Solid", "Liquid", "Solid", "Solid", "Solid", "Solid", "Solid", "Gas", "Solid?", "Solid", "Solid", "Solid", "Solid", "Solid", "Solid", "Solid", "Solid", "Solid", "Solid", "Solid", "Solid", "Solid?", "Solid?", "Solid?", "Solid?", "Solid?", "Solid?", "Solid?", "Solid?", "Solid?", "Solid?", "Solid?", "Solid?", "Gas?", "Solid?", "Solid?", "Solid?", "Solid?", "Solid", "Solid" };
	public static String[] solids = { "Lithium", "Beryllium", "Boron", "Carbon", "Sodium", "Magnesium", "Aluminum", "Silicon", "Phosphorous", "Sulphur", "Potassium", "Calcium", "Scandium", "Titanium", "Vanadium", "Chromium", "Manganese", "Iron", "Cobalt", "Nickel", "Copper", "Zinc", "Gallium", "Germanium", "Arsenic", "Selenium", "Rubidium", "Strontium", "Yttrium", "Zirconium", "Niobium", "Molybdenum", "Technetium", "Ruthenium", "Rhodium", "Palladium", "Silver", "Cadmium", "Indium", "Tin", "Antimony", "Tellurium", "Iodine", "Caesium", "Barium", "Lanthanum", "Cerium", "Praesodymium", "Neodymium", "Promethium", "Samarium", "Europium", "Gadolinium", "Terbium", "Dysprosium", "Holmium", "Erbium", "Thulium", "Ytterbium", "Lutetium", "Hafnium", "Tantalum", "Tungsten", "Rhenium", "Osmium", "Iridium", "Platinum", "Gold", "Thallium", "Lead", "Bismuth", "Polonium", "Astatine", "Francium", "Radium", "Actinium", "Thorium", "Protactinium", "Uranium", "Neptunium", "Plutonium", "Americium", "Curium", "Berkelium", "Californium", "Einsteinium" };
	public static String[] maybesolids = { "Fermium", "Mendelevium", "Nobelium", "Lawrencium", "Rutherfordium", "Dubnium", "Seaborgium", "Bohrium", "Hassium", "Meitnerium", "Darmstadtium", "Roentgenium", "Nihonium", "Flerovium", "Moscovium", "Livermorium", "Tennessine", "Oganesson" };
	public static String[] liquids = { "Bromine", "Mercury" };
	public static String[] gases = { "Hydrogen", "Helium", "Nitrogen", "Oxygen", "Fluorine", "Neon", "Chlorine", "Argon", "Krypton", "Xenon", "Radon" };
	public static String[] maybegases = { "Copernicium" };
	public static String[] possiblestates = {"Solid", "Solid?", "Liquid", "Gas", "Gas?", "You broke it"};
	
	public static int FindElementState(String searcharray, String[] array1, String[] array2, String[] array3, String[] array4, String[] array5) {
		if (Arrays.asList(array1).contains(searcharray)) {
			return 0;
		}
		else if (Arrays.asList(array2).contains(searcharray)) {
			return 1;
		}
		else if (Arrays.asList(array3).contains(searcharray)) {
			return 2;
		}
		else if (Arrays.asList(array4).contains(searcharray)) {
			return 3;
		}
		else if (Arrays.asList(array5).contains(searcharray)) {
			return 4;
		}
		return 5;
	}
		public static ItemStack GetElementData(String string, int stackSize) {
			NBTTagCompound tagCompound = new NBTTagCompound();
			Item Vial = new ItemVial();
			tagCompound.setString("Element", elements[ArrayUtils.indexOf(elements, string)]);
			tagCompound.setString("State", possiblestates[FindElementState(string, solids, maybesolids, liquids, gases, maybegases)]);
			ItemStack item = new ItemStack(Vial, stackSize);
			item.setTagCompound(tagCompound);
			return item;
		}
}
