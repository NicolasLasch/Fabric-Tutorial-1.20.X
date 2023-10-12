package be.thespattt.tutorialmod.block.entity

import be.thespattt.tutorialmod.recipe.GemEmpoweringRecipe
import be.thespattt.tutorialmod.screen.GemEmpoweringScreenHandler
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory
import net.minecraft.block.BlockState
import net.minecraft.block.entity.BlockEntity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.entity.player.PlayerInventory
import net.minecraft.inventory.SimpleInventory
import net.minecraft.item.ItemStack
import net.minecraft.network.PacketByteBuf
import net.minecraft.registry.DynamicRegistryManager
import net.minecraft.screen.PropertyDelegate
import net.minecraft.screen.ScreenHandler
import net.minecraft.server.network.ServerPlayerEntity
import net.minecraft.text.Text
import net.minecraft.util.collection.DefaultedList
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World
import org.jetbrains.annotations.Nullable
import java.util.*


class GemEmpoweringStationBlockEntity(pos: BlockPos, state: BlockState) :
    BlockEntity(ModBlockEntities.GEM_EMPOWERING_STATION_BE, pos, state),
    ExtendedScreenHandlerFactory,
    ImplementedInventory {

    private val inventory: DefaultedList<ItemStack?> = DefaultedList.ofSize(4, ItemStack.EMPTY)

    companion object {
        private const val INPUT_SLOT = 0
        private const val FLUID_ITEM_SLOT = 1
        private const val OUTPUT_SLOT = 2
        private const val ENERGY_ITEM_SLOT = 3
    }

    protected val propertyDelegate: PropertyDelegate
    private var progress = 0
    private var maxProgress = 72

    init {
        propertyDelegate = object : PropertyDelegate {
            override fun get(index: Int): Int {
                return when (index) {
                    0 -> progress
                    1 -> maxProgress
                    else -> 0
                }
            }

            override fun set(index: Int, value: Int) {
                when (index) {
                    0 -> progress = value
                    1 -> maxProgress = value
                }
            }

            override fun size(): Int {
                return 2
            }
        }
    }

    override fun writeScreenOpeningData(player: ServerPlayerEntity, buf: PacketByteBuf) {
        buf.writeBlockPos(pos)
    }

    override fun getDisplayName(): Text {
        return Text.of("Gem Empowering Station")
    }

    @Nullable
    override fun createMenu(syncId: Int, playerInventory: PlayerInventory, player: PlayerEntity): ScreenHandler {
        return GemEmpoweringScreenHandler(syncId, playerInventory, this, propertyDelegate)
    }

    override val items: DefaultedList<ItemStack?>
        get() = inventory

    override fun markDirty() {
        // Override this method if you want custom behavior.
    }

    fun tick(world: World, pos: BlockPos, state: BlockState) {
        if (canInsertIntoOutputSlot() && hasRecipe()) {
            increaseCraftingProgress()
            markDirty()

            if (hasCraftingFinished()) {
                craftItem()
                resetProgress()
                markDirty()
            }
        } else {
            resetProgress()
            markDirty()
        }
    }

    private fun craftItem() {
        val recipe: Optional<GemEmpoweringRecipe?> = getCurrentRecipe()

        this.removeStack(INPUT_SLOT, 1)

        setStack(
            OUTPUT_SLOT, ItemStack(
                recipe.get().getOutput(DynamicRegistryManager.EMPTY).getItem(),
                getStack(OUTPUT_SLOT).count + recipe.get().getOutput(DynamicRegistryManager.EMPTY).getCount()
            )
        )
    }

    private fun resetProgress() {
        progress = 0
    }

    private fun hasCraftingFinished(): Boolean {
        return progress >= maxProgress
    }

    private fun increaseCraftingProgress() {
        progress++
    }

    private fun hasRecipe(): Boolean {
        val recipe = getCurrentRecipe()
        if (recipe!!.isEmpty) {
            return false
        }
        val output = recipe.get().getOutput(DynamicRegistryManager.EMPTY)
        return (canInsertAmountIntoOutputSlot(output.count)
                && canInsertItemIntoOutputSlot(output))
    }

    private fun canInsertItemIntoOutputSlot(output: ItemStack): Boolean {
        return getStack(OUTPUT_SLOT).isEmpty || getStack(OUTPUT_SLOT).item === output.item
    }

    private fun canInsertAmountIntoOutputSlot(count: Int): Boolean {
        return getStack(OUTPUT_SLOT).maxCount >= getStack(OUTPUT_SLOT).count + count
    }

    private fun getCurrentRecipe(): Optional<GemEmpoweringRecipe?> {
        val inventory = SimpleInventory(size())
        for (i in 0 until size()) {
            inventory.setStack(i, getStack(i))
        }
        return getWorld()!!.recipeManager.getFirstMatch(GemEmpoweringRecipe.Type, inventory, getWorld())
    }

    private fun canInsertIntoOutputSlot(): Boolean {
        val outputSlot = this.getStack(OUTPUT_SLOT)
        return outputSlot.isEmpty || outputSlot.count < outputSlot.maxCount
    }
}

