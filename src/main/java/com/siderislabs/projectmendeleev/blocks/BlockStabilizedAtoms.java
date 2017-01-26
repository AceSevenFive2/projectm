package com.siderislabs.projectmendeleev.blocks;

import java.util.List;
import java.util.Random;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.siderislabs.projectmendeleev.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockStabilizedAtoms extends Block {

	public BlockStabilizedAtoms() {
		super(Material.ANVIL);
		setHardness(0.3F);
		setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		setUnlocalizedName(Reference.ModdedBlocks.STABILIZEDATOMS.getUnlocalizedName());
		setRegistryName(Reference.ModdedBlocks.STABILIZEDATOMS.getRegistryName());
		setDefaultState(blockState.getBaseState().withProperty(TYPE, Integer.valueOf(1)));
	}
	
	public static final PropertyInteger TYPE = PropertyInteger.create("type", 0, 1);
	
	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.SOLID;
	}
	
	@Override
	public EnumBlockRenderType getRenderType(IBlockState state) {
		return EnumBlockRenderType.MODEL;
	}
	
	public int getDamageValue(World world, int x, int y, int z) {
		return getMetaFromState(world.getBlockState(new BlockPos(x, y, z)));
	}

	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, @Nullable ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {
		world.setBlockState(pos, world.getBlockState(pos).withProperty(TYPE, 1));
		System.out.println("Blockstate changed. Meta is: " + getMetaFromState(state));
		return true;
	}

	@Override
	public int damageDropped(IBlockState state) {
		System.out.println("Metadata: " + getMetaFromState(state));
		return getMetaFromState(state);
	}
	
	@Override
	public int quantityDropped(Random rand) {
		return 1;
	}

	@Nonnull
	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, TYPE);
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		return withType(meta);
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return getType(state);
	}
	
	public int getRenderType() {
		return 3;
	}

	protected int getType(IBlockState state) {
		return state.getValue(TYPE);
	}

	public IBlockState withType(int type) {
		return getDefaultState().withProperty(TYPE, type);
	}
	
	@Override
	public void getSubBlocks(Item itemIn, CreativeTabs tab, List<ItemStack> list) {
	    list.add(new ItemStack(itemIn, 1, 0));
	    list.add(new ItemStack(itemIn, 1, 1));
	}
	
}