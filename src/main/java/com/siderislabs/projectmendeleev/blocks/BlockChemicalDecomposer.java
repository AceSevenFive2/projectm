package com.siderislabs.projectmendeleev.blocks;

import javax.annotation.Nullable;

import com.siderislabs.projectmendeleev.Reference;
import com.siderislabs.projectmendeleev.Starter;
import com.siderislabs.projectmendeleev.gui.GUIHandlerChemDecomp;
import com.siderislabs.projectmendeleev.tileentity.TileChemicalDecomposer;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockChemicalDecomposer extends BlockContainer {

	public BlockChemicalDecomposer() {
		super(Material.ANVIL);
		this.setCreativeTab(CreativeTabs.REDSTONE);
		this.setRegistryName(Reference.ModdedBlocks.CHEMICALDECOMPOSER.getRegistryName());
		this.setUnlocalizedName(Reference.ModdedBlocks.CHEMICALDECOMPOSER.getUnlocalizedName());
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		// TODO Auto-generated method stub
		return new TileChemicalDecomposer();
	}
	
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, @Nullable ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {
		// Uses the gui handler registered to your mod to open the gui for the given gui id
		// open on the server side only  (not sure why you shouldn't open client side too... vanilla doesn't, so we better not either)
		if (!worldIn.isRemote) {
			playerIn.openGui(Starter.instance, GUIHandlerChemDecomp.getGuiID(), worldIn, pos.getX(), pos.getY(), pos.getZ());
		}
		return true;
	}
	@Override
	public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos)
	{
		TileEntity tileEntity = worldIn.getTileEntity(pos);
		if (tileEntity instanceof TileChemicalDecomposer) {
			TileChemicalDecomposer tileChemicalDecomposer = (TileChemicalDecomposer)tileEntity;
		}
		return state;
}

}
