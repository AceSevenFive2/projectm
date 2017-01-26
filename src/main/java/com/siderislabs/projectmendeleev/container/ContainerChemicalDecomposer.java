package com.siderislabs.projectmendeleev.container;

import java.io.IOException;

import com.siderislabs.projectmendeleev.config.RecipeConfig;
import com.siderislabs.projectmendeleev.tileentity.TileChemicalDecomposer;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

/**
 * User: brandon3055
 * Date: 06/01/2015
 *
 * ContainerSmelting is used to link the client side gui to the server side inventory and it is where
 * you add the slots holding items. It is also used to send server side data such as progress bars to the client
 * for use in guis
 */
public class ContainerChemicalDecomposer extends Container {

	// Stores the tile entity instance for later use
	private TileChemicalDecomposer tileChemicalDecomposer;

	// These store cache values, used by the server to only update the client side tile entity when values have changed
	private int [] cachedFields;

	// must assign a slot index to each of the slots used by the GUI.
	// For this container, we can see the furnace fuel, input, and output slots as well as the player inventory slots and the hotbar.
	// Each time we add a Slot to the container using addSlotToContainer(), it automatically increases the slotIndex, which means
	//  0 - 8 = hotbar slots (which will map to the InventoryPlayer slot numbers 0 - 8)
	//  9 - 35 = player inventory slots (which map to the InventoryPlayer slot numbers 9 - 35)
	//  36 - 39 = fuel slots (tileEntity 0 - 3)
	//  40 - 44 = input slots (tileEntity 4 - 8)
	//  45 - 49 = output slots (tileEntity 9 - 13)

	private final int HOTBAR_SLOT_COUNT = 9;
	private final int PLAYER_INVENTORY_ROW_COUNT = 3;
	private final int PLAYER_INVENTORY_COLUMN_COUNT = 9;
	private final int PLAYER_INVENTORY_SLOT_COUNT = PLAYER_INVENTORY_COLUMN_COUNT * PLAYER_INVENTORY_ROW_COUNT;
	private final int VANILLA_SLOT_COUNT = HOTBAR_SLOT_COUNT + PLAYER_INVENTORY_SLOT_COUNT;

	public final int INPUT_SLOTS_COUNT = 1;
	public final int OUTPUT_SLOTS_COUNT = 18;
	public final int SLOTS_TOTAL_COUNT = 27;

	private final int VANILLA_FIRST_SLOT_INDEX = 0;
	private final int FIRST_INPUT_SLOT_INDEX = VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT;

	// slot number is the slot number within each component; i.e. invPlayer slots 0 - 35, and tileInventoryFurnace slots 0 - 14

	public ContainerChemicalDecomposer(InventoryPlayer invPlayer, TileChemicalDecomposer tileChemicalDecomposer) {
		this.tileChemicalDecomposer = tileChemicalDecomposer;
        addSlotToContainer(new Slot(invPlayer, 0, 8, 159));
        addSlotToContainer(new Slot(invPlayer, 1, 26, 159));
        addSlotToContainer(new Slot(invPlayer, 2, 44, 159));
        addSlotToContainer(new Slot(invPlayer, 3, 62, 159));
        addSlotToContainer(new Slot(invPlayer, 4, 80, 159));
        addSlotToContainer(new Slot(invPlayer, 5, 98, 159));
        addSlotToContainer(new Slot(invPlayer, 6, 116, 159));
        addSlotToContainer(new Slot(invPlayer, 7, 134, 159));
        addSlotToContainer(new Slot(invPlayer, 8, 152, 159));
        addSlotToContainer(new Slot(invPlayer, 9, 8, 137));
        addSlotToContainer(new Slot(invPlayer, 10, 26, 137));
        addSlotToContainer(new Slot(invPlayer, 11, 44, 137));
        addSlotToContainer(new Slot(invPlayer, 12, 62, 137));
        addSlotToContainer(new Slot(invPlayer, 13, 80, 137));
        addSlotToContainer(new Slot(invPlayer, 14, 98, 137));
        addSlotToContainer(new Slot(invPlayer, 15, 116, 137));
        addSlotToContainer(new Slot(invPlayer, 16, 134, 137));
        addSlotToContainer(new Slot(invPlayer, 17, 152, 137));
        addSlotToContainer(new Slot(invPlayer, 18, 8, 119));
        addSlotToContainer(new Slot(invPlayer, 19, 26, 119));
        addSlotToContainer(new Slot(invPlayer, 20, 44, 119));
        addSlotToContainer(new Slot(invPlayer, 21, 62, 119));
        addSlotToContainer(new Slot(invPlayer, 22, 80, 119));
        addSlotToContainer(new Slot(invPlayer, 23, 98, 119));
        addSlotToContainer(new Slot(invPlayer, 24, 116, 119));
        addSlotToContainer(new Slot(invPlayer, 25, 134, 119));
        addSlotToContainer(new Slot(invPlayer, 26, 152, 119));
        addSlotToContainer(new Slot(invPlayer, 27, 8, 101));
        addSlotToContainer(new Slot(invPlayer, 28, 26, 101));
        addSlotToContainer(new Slot(invPlayer, 29, 44, 101));
        addSlotToContainer(new Slot(invPlayer, 30, 62, 101));
        addSlotToContainer(new Slot(invPlayer, 31, 80, 101));
        addSlotToContainer(new Slot(invPlayer, 32, 98, 101));
        addSlotToContainer(new Slot(invPlayer, 33, 116, 101));
        addSlotToContainer(new Slot(invPlayer, 34, 134, 101));
        addSlotToContainer(new Slot(invPlayer, 35, 152, 101));
		addSlotToContainer(new SlotInput(tileChemicalDecomposer, 0, 79, 15));
		addSlotToContainer(new SlotOutput(tileChemicalDecomposer, 1, 7, 79));
		addSlotToContainer(new SlotOutput(tileChemicalDecomposer, 2, 25, 79));
		addSlotToContainer(new SlotOutput(tileChemicalDecomposer, 3, 43, 79));
		addSlotToContainer(new SlotOutput(tileChemicalDecomposer, 4, 61, 79));
		addSlotToContainer(new SlotOutput(tileChemicalDecomposer, 5, 79, 79));
		addSlotToContainer(new SlotOutput(tileChemicalDecomposer, 6, 97, 79));
		addSlotToContainer(new SlotOutput(tileChemicalDecomposer, 7, 115, 79));
		addSlotToContainer(new SlotOutput(tileChemicalDecomposer, 8, 133, 79));
		addSlotToContainer(new SlotOutput(tileChemicalDecomposer, 9, 151, 79));
		addSlotToContainer(new SlotOutput(tileChemicalDecomposer, 10, 7, 61));
		addSlotToContainer(new SlotOutput(tileChemicalDecomposer, 11, 25, 61));
		addSlotToContainer(new SlotOutput(tileChemicalDecomposer, 12, 43, 61));
		addSlotToContainer(new SlotOutput(tileChemicalDecomposer, 13, 61, 61));
		addSlotToContainer(new SlotOutput(tileChemicalDecomposer, 14, 79, 61));
		addSlotToContainer(new SlotOutput(tileChemicalDecomposer, 15, 97, 61));
		addSlotToContainer(new SlotOutput(tileChemicalDecomposer, 16, 115, 61));
		addSlotToContainer(new SlotOutput(tileChemicalDecomposer, 17, 133, 61));
		addSlotToContainer(new SlotOutput(tileChemicalDecomposer, 18, 151, 61));
	}

	// Checks each tick to make sure the player is still able to access the inventory and if not closes the gui
	@Override
	public boolean canInteractWith(EntityPlayer player)
	{
		return tileChemicalDecomposer.isUseableByPlayer(player);
	}

	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int sourceSlotIndex)
	{
		System.out.println(sourceSlotIndex);
		Slot sourceSlot = (Slot)inventorySlots.get(sourceSlotIndex);
		if (sourceSlot == null || !sourceSlot.getHasStack()) return null;
		ItemStack sourceStack = sourceSlot.getStack();
		ItemStack copyOfSourceStack = sourceStack.copy();

		// Check if the slot clicked is one of the vanilla container slots
		if (sourceSlotIndex >= VANILLA_FIRST_SLOT_INDEX && sourceSlotIndex < VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT) {
			// This is a vanilla container slot so merge the stack into one of the furnace slots
			// If the stack is smeltable try to merge merge the stack into the input slots
			try {
				if (RecipeConfig.getDecomposerRecipeForEntity(sourceStack) != null) {
					if (!mergeItemStack(sourceStack, FIRST_INPUT_SLOT_INDEX, FIRST_INPUT_SLOT_INDEX + INPUT_SLOTS_COUNT, false)) {
						return null;
					}
				}	else {
					return null;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.err.print("Invalid slotIndex:" + sourceSlotIndex);
			return null;
		}

		// If stack size == 0 (the entire stack was moved) set slot contents to null
		if (sourceStack.stackSize == 0) {
			sourceSlot.putStack(null);
		} else {
			sourceSlot.onSlotChanged();
		}

		sourceSlot.onPickupFromSlot(player, sourceStack);
		return copyOfSourceStack;
}

	/* Client Synchronization */

	// This is where you check if any values have changed and if so send an update to any clients accessing this container
	// The container itemstacks are tested in Container.detectAndSendChanges, so we don't need to do that
	// We iterate through all of the TileEntity Fields to find any which have changed, and send them.
	// You don't have to use fields if you don't wish to; just manually match the ID in sendProgressBarUpdate with the value in
	//   updateProgressBar()
	// The progress bar values are restricted to shorts.  If you have a larger value (eg int), it's not a good idea to try and split it
	//   up into two shorts because the progress bar values are sent independently, and unless you add synchronisation logic at the
	//   receiving side, your int value will be wrong until the second short arrives.  Use a custom packet instead.
	@Override
	public void detectAndSendChanges() {
		super.detectAndSendChanges();

		boolean allFieldsHaveChanged = false;
		boolean fieldHasChanged [] = new boolean[tileChemicalDecomposer.getFieldCount()];
		if (cachedFields == null) {
			cachedFields = new int[tileChemicalDecomposer.getFieldCount()];
			allFieldsHaveChanged = true;
		}
		for (int i = 0; i < cachedFields.length; ++i) {
			if (allFieldsHaveChanged || cachedFields[i] != tileChemicalDecomposer.getField(i)) {
				cachedFields[i] = tileChemicalDecomposer.getField(i);
				fieldHasChanged[i] = true;
			}
		}

		// go through the list of listeners (players using this container) and update them if necessary
    for (IContainerListener listener : this.listeners) {
			for (int fieldID = 0; fieldID < tileChemicalDecomposer.getFieldCount(); ++fieldID) {
				if (fieldHasChanged[fieldID]) {
					// Note that although sendProgressBarUpdate takes 2 ints on a server these are truncated to shorts
          listener.sendProgressBarUpdate(this, fieldID, cachedFields[fieldID]);
				}
			}
		}
	}

	public class SlotInput extends Slot {
		public SlotInput(IInventory inventoryIn, int index, int xPosition, int yPosition) {
			super(inventoryIn, index, xPosition, yPosition);
		}

		// if this function returns false, the player won't be able to insert the given item into this slot
		@Override
		public boolean isItemValid(ItemStack stack) {
			return TileChemicalDecomposer.isItemValidForInputSlot(stack);
		}
	}

	// SlotOutput is a slot that will not accept any items
	public class SlotOutput extends Slot {
		public SlotOutput(IInventory inventoryIn, int index, int xPosition, int yPosition) {
			super(inventoryIn, index, xPosition, yPosition);
		}

		// if this function returns false, the player won't be able to insert the given item into this slot
		@Override
		public boolean isItemValid(ItemStack stack) {
			return TileChemicalDecomposer.isItemValidForOutputSlot(stack);
		}
	}
}