package be.thespattt.tutorialmod.screen

import be.thespattt.tutorialmod.block.entity.GemEmpoweringStationBlockEntity
import net.minecraft.block.entity.BlockEntity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.entity.player.PlayerInventory
import net.minecraft.inventory.Inventory
import net.minecraft.item.ItemStack
import net.minecraft.network.PacketByteBuf
import net.minecraft.screen.ArrayPropertyDelegate
import net.minecraft.screen.PropertyDelegate
import net.minecraft.screen.ScreenHandler
import net.minecraft.screen.slot.Slot


class GemEmpoweringScreenHandler(syncId: Int, playerInventory: PlayerInventory, blockEntity: BlockEntity?, arrayPropertyDelegate: PropertyDelegate) :
    ScreenHandler(ModScreenHandlers.GEM_EMPOWERING_SCREEN_HANDLER, syncId) {

    private val inventory: Inventory
    private val propertyDelegate: PropertyDelegate
    val blockEntity: GemEmpoweringStationBlockEntity

    constructor(syncId: Int, inventory: PlayerInventory, buf: PacketByteBuf) :
            this(syncId, inventory, inventory.player.world.getBlockEntity(buf.readBlockPos()), ArrayPropertyDelegate(2))

    init {
        checkSize(blockEntity as Inventory, 4)
        this.inventory = blockEntity
        propertyDelegate = arrayPropertyDelegate
        this.blockEntity = blockEntity as GemEmpoweringStationBlockEntity
        addSlot(Slot(inventory, 0, 80, 11))
        addSlot(Slot(inventory, 1, 26, 59))
        addSlot(Slot(inventory, 2, 80, 59))
        addSlot(Slot(inventory, 3, 134, 59))
        addPlayerInventory(playerInventory)
        addPlayerHotbar(playerInventory)
        addProperties(arrayPropertyDelegate)
    }

    val isCrafting: Boolean
        get() = propertyDelegate[0] > 0

    val scaledProgress: Int
        get() {
            val progress = propertyDelegate[0]
            val maxProgress = propertyDelegate[1]
            val progressArrowSize = 26

            return if (maxProgress != 0 && progress != 0) progress * progressArrowSize / maxProgress else 0
        }

    override fun quickMove(player: PlayerEntity, invSlot: Int): ItemStack {
        var newStack = ItemStack.EMPTY
        val slot = slots[invSlot]

        if (slot != null && slot.hasStack()) {
            val originalStack = slot.stack
            newStack = originalStack.copy()

            if (invSlot < inventory!!.size()) {
                if (!insertItem(originalStack, inventory.size(), slots.size, true)) {
                    return ItemStack.EMPTY
                }
            } else if (!insertItem(originalStack, 0, inventory.size(), false)) {
                return ItemStack.EMPTY
            }

            if (originalStack.isEmpty) {
                slot.stack = ItemStack.EMPTY
            } else {
                slot.markDirty()
            }
        }

        return newStack
    }

    override fun canUse(player: PlayerEntity): Boolean {
        return inventory!!.canPlayerUse(player)
    }

    private fun addPlayerInventory(playerInventory: Inventory) {
        for (i in 0..2) {
            for (l in 0..8) {
                addSlot(Slot(playerInventory, l + i * 9 + 9, 8 + l * 18, 84 + i * 18))
            }
        }
    }

    private fun addPlayerHotbar(playerInventory: Inventory) {
        for (i in 0..8) {
            addSlot(Slot(playerInventory, i, 8 + i * 18, 142))
        }
    }
}