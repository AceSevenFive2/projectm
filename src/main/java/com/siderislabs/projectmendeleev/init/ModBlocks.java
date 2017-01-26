package com.siderislabs.projectmendeleev.init;

import com.siderislabs.projectmendeleev.Starter;
import com.siderislabs.projectmendeleev.blocks.BlockChemicalDecomposer;
import com.siderislabs.projectmendeleev.blocks.BlockStabilizedAtoms;
import com.siderislabs.projectmendeleev.gui.GUIHandlerChemDecomp;
import com.siderislabs.projectmendeleev.gui.GUIMetaHandler;
import com.siderislabs.projectmendeleev.tileentity.TileChemicalDecomposer;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModBlocks {
	
	public static Block StabilizedAtoms;
	public static Block ChemicalDecomposer;

	public static void init() {
		StabilizedAtoms = new BlockStabilizedAtoms();
		ChemicalDecomposer = new BlockChemicalDecomposer();
	}
	public static void register() {
		registerBlock(StabilizedAtoms);
		registerBlock(ChemicalDecomposer);
		GameRegistry.registerTileEntity(TileChemicalDecomposer.class, "siderislabs_chemicaldecomposer_te");
		NetworkRegistry.INSTANCE.registerGuiHandler(Starter.instance, GUIMetaHandler.getInstance());
		GUIMetaHandler.getInstance().registerGuiHandler(new GUIHandlerChemDecomp(), GUIHandlerChemDecomp.getGuiID());
	}

	private static void registerBlock(Block block) {
		GameRegistry.register(block);
		ItemBlock item = new ItemBlock(block);
		item.setRegistryName(block.getRegistryName());
		GameRegistry.register(item);
	}
	public static void registerRenders() {
		registerRender(StabilizedAtoms, 0, "inventory");
		registerRender(StabilizedAtoms, 0, "type=0");
		registerRender(StabilizedAtoms, 1, "type=1");
		registerRender(ChemicalDecomposer, 0, "inventory");
	}
	public static void registerRender(Block block, int meta, String variant) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), meta, new ModelResourceLocation(block.getRegistryName(), variant));
	}
}
	
