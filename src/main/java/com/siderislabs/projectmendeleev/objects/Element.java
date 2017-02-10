package com.siderislabs.projectmendeleev.objects;

import com.siderislabs.projectmendeleev.functions.ElementFunctions;
import com.siderislabs.projectmendeleev.items.ItemVial;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class Element {

	public String name;
	public Integer atomicNumber;
	public long atomicWeight;
	public String state;
	public long meltingPoint;
	public long boilingPoint;
	public long density;
	private int isUnsafe;

	public Element(String[] data) {
		if(data.length == 6) {
			this.name = data[0];
			this.atomicNumber = Integer.valueOf(data[1]);
			this.atomicWeight = Long.valueOf(data[2]);
			this.state = data[3];
			this.meltingPoint = Long.valueOf(data[4]);
			this.density = Long.valueOf(data[5]);
		}
		else {
				System.err.println("Error: A new element does not have the required parameters. Calls to this var are unsafe.");
				isUnsafe = 1;
		}
	}
	
	public String getName() {
		if (this.name != null) {
			return this.name;
		}
		else {
			System.err.println("Error: A getName() call was made to an unsafe element.");
			return "Void in a Vial";
		}
	}
	
	public Integer getAtomicNumber() {
		if (this.atomicNumber > 0) {
			return this.atomicNumber;
		}
		else {
			System.err.println("Error: a getAtomicNumber() call was made to an unsafe element.");
			return 0;
		}
	}
	
	public Long getAtomicWeight() {
		if(this.atomicWeight >= 0) {
			return this.atomicWeight;
		}
		else {
			System.err.println("Error: a getAtomicWeight() call was made to an unsafe element.");
			return Long.valueOf(0);
		}
	}
	
	public String getState() {
		if(this.state != null) {
			return this.state;
		}
		else {
			System.err.println("Error: a getState() call was made to an unsafe element.");
			return "Unknown";
		}
	}

	public Long getMeltingPoint() {
		if(this.meltingPoint >= 0) {
			return this.meltingPoint;
		}
		else {
			System.err.println("Error: a getMeltingPoint() call was made to an unsafe element.");
			return Long.valueOf(0);
		}
	}
	
	public Long getDensity() {
		if(this.density >= 0) {
			return this.density;
		}
		else {
			System.err.println("Error: a getDensity() call was made to an unsafe element.");
			return Long.valueOf(0);
		}
	}
	
	public ItemStack getElementInstance(Integer quantity) {
		Item Vial = new ItemVial();
		NBTTagCompound tagCompound = new NBTTagCompound();
		if(isUnsafe != 1) {
			tagCompound.setString("Element", this.name);
			tagCompound.setInteger("Atomic Number", this.atomicNumber);
			tagCompound.setLong("Atomic Weight", this.atomicWeight);
			tagCompound.setString("State", this.state);
			tagCompound.setLong("Melting Point", this.meltingPoint);
			tagCompound.setLong("Boiling Point", this.boilingPoint);
			tagCompound.setLong("Density", this.density);
			ItemStack result = new ItemStack(Vial, quantity);
			result.setTagCompound(tagCompound);
			return result;
		}
		else {
			System.err.println("Error: An attempt was made to generate an item using an invalid element.");
			return null;
		}
	}
}
