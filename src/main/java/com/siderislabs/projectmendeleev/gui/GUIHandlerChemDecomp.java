package com.siderislabs.projectmendeleev.gui;

import com.siderislabs.projectmendeleev.container.ContainerChemicalDecomposer;
import com.siderislabs.projectmendeleev.tileentity.TileChemicalDecomposer;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GUIHandlerChemDecomp implements IGuiHandler {
	private static final int PROJECTM_GUILD = 55;
	public static int getGuiID() {return PROJECTM_GUILD;}

	// Gets the server side element for the given gui id this should return a container
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if (ID != getGuiID()) {
			System.err.println("Invalid ID: expected " + getGuiID() + ", received " + ID);
		}
		BlockPos xyz = new BlockPos(x, y, z);
		TileEntity tileEntity = world.getTileEntity(xyz);
		if (tileEntity instanceof TileChemicalDecomposer) {
			TileChemicalDecomposer tileChemicalDecomposer = (TileChemicalDecomposer) tileEntity;
			return new ContainerChemicalDecomposer(player.inventory, tileChemicalDecomposer);
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if (ID != getGuiID()) {
			System.err.println("Invalid ID: expected " + getGuiID() + ", received " + ID);
		}
		BlockPos xyz = new BlockPos(x, y, z);
		TileEntity tileEntity = world.getTileEntity(xyz);
		if (tileEntity instanceof TileChemicalDecomposer) {
			TileChemicalDecomposer tileChemicalDecomposer = (TileChemicalDecomposer) tileEntity;
			return new GUIChemicalDecomposer(player.inventory, tileChemicalDecomposer);
		}
		return null;
	}

}