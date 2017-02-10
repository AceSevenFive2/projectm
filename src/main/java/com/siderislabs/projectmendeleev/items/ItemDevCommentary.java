package com.siderislabs.projectmendeleev.items;

import java.util.List;

import com.siderislabs.projectmendeleev.Reference;
import com.siderislabs.projectmendeleev.functions.AtomFunctions;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import java.util.concurrent.ThreadLocalRandom;

public class ItemDevCommentary extends Item {

	String[] devCommentary = {"This mod relies on Sideris Little Config for decomposer recipes; a format I developed because I couldn't figure out JSON.", "This mod is the spiritual successor to MineChem."};
	
 	public ItemDevCommentary() {
		setUnlocalizedName(Reference.ModdedItems.DEVCOMMENTARY.getUnlocalizedName());
		setRegistryName(Reference.ModdedItems.DEVCOMMENTARY.getRegistryName());
		this.setCreativeTab(CreativeTabs.MISC);
		this.setMaxStackSize(64);
	}

    public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand)
    {
 		if(!worldIn.isRemote) {
 			playerIn.addChatMessage(new TextComponentString(devCommentary[ThreadLocalRandom.current().nextInt(0, 2)]));
 			return new ActionResult<ItemStack>(EnumActionResult.PASS, itemStackIn);
 		}
 		else {
 			return new ActionResult<ItemStack>(EnumActionResult.FAIL, itemStackIn);
 		}
    }
}
