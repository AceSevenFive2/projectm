package com.siderislabs.projectmendeleev.functions;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.ArrayUtils;

import com.siderislabs.projectmendeleev.Starter;
import com.siderislabs.projectmendeleev.items.ItemVial;
import com.siderislabs.projectmendeleev.objects.Element;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import scala.actors.threadpool.Arrays;

public class AtomFunctions {
			
		public void WriteElementData() throws IOException {
			final List<String> fileContents = FileUtils.readLines(new File(Starter.getModConfigDir().getPath() + File.separator + "projectm" + File.separator + "elements.txt"));
			for(int i = 0; i < fileContents.size(); i++) {
				@SuppressWarnings("unchecked")
				ArrayList<String> tmp = new ArrayList<String>(Arrays.asList(fileContents.get(i).split(":")));
				String[] tmp2 = new String[tmp.size()];
				for (int j = 0; j < tmp.size(); j++) {
					tmp2[j] = tmp.get(j);
				}
				Element tmp3 = new Element(tmp2);
				ElementFunctions.AddNewElement(tmp3.getElementInstance(1), tmp3.getName());
			}
		}
}
