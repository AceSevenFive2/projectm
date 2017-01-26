package com.siderislabs.projectmendeleev.gui;

import com.siderislabs.projectmendeleev.container.ContainerChemicalDecomposer;
import com.siderislabs.projectmendeleev.tileentity.TileChemicalDecomposer;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class GUIChemicalDecomposer extends GuiContainer {
	
	private static final ResourceLocation texture = new ResourceLocation("projectm", "textures/gui/ChemicaldecomposerGUI.png");
	private TileChemicalDecomposer tileEntity;

	public GUIChemicalDecomposer(InventoryPlayer invPlayer, TileChemicalDecomposer tileChemicalDecomposer) {
		super(new ContainerChemicalDecomposer(invPlayer, tileChemicalDecomposer));
		xSize = 176;
		ySize = 184;
		this.tileEntity = tileChemicalDecomposer;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
	}
	public static boolean isInRect(int x, int y, int xSize, int ySize, int mouseX, int mouseY){
		return ((mouseX >= x && mouseX <= x+xSize) && (mouseY >= y && mouseY <= y+ySize));
	}

}
