package be.thespattt.tutorialmod.fluid

import net.minecraft.block.Block
import net.minecraft.block.BlockState
import net.minecraft.fluid.FlowableFluid
import net.minecraft.fluid.Fluid
import net.minecraft.fluid.FluidState
import net.minecraft.item.Item
import net.minecraft.state.StateManager
import net.minecraft.state.property.Properties
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.Direction
import net.minecraft.world.BlockView
import net.minecraft.world.World
import net.minecraft.world.WorldAccess
import net.minecraft.world.WorldView
import be.thespattt.tutorialmod.fluid.ModFluids


abstract class SoapWaterFluid : FlowableFluid() {
    override fun getFlowing(): Fluid {
        return ModFluids.FLOWING_SOAP_WATER
    }

    override fun getStill(): Fluid {
        return ModFluids.STILL_SOAP_WATER
    }

    override fun isInfinite(world: World): Boolean {
        return false
    }

    override fun beforeBreakingBlock(world: WorldAccess, pos: BlockPos, state: BlockState) {
        val blockEntity = if (state.hasBlockEntity()) world.getBlockEntity(pos) else null
        Block.dropStacks(state, world, pos, blockEntity)
    }

    override fun getFlowSpeed(world: WorldView): Int {
        return 4
    }

    override fun getLevelDecreasePerBlock(world: WorldView): Int {
        return 1
    }

    override fun getBucketItem(): Item {
        return ModFluids.SOAP_WATER_BUCKET
    }

    override fun canBeReplacedWith(
        state: FluidState,
        world: BlockView,
        pos: BlockPos,
        fluid: Fluid,
        direction: Direction
    ): Boolean {
        return false
    }


    override fun getTickRate(world: WorldView): Int {
        return 5
    }

    override fun getBlastResistance(): Float {
        return 100f
    }

    override fun matchesType(fluid: Fluid): Boolean {
        return fluid === still || fluid === flowing
    }

    override fun toBlockState(state: FluidState): BlockState {
        return ModFluids.SOAP_WATER_BLOCK.getDefaultState().with(Properties.LEVEL_15, getBlockStateLevel(state))
    }

    override fun isStill(state: FluidState): Boolean {
        return false
    }

    override fun getLevel(state: FluidState): Int {
        return 0
    }

    class Flowing : SoapWaterFluid() {
        override fun appendProperties(builder: StateManager.Builder<Fluid, FluidState>) {
            super.appendProperties(builder)
            builder.add(LEVEL)
        }

        override fun getLevel(state: FluidState): Int {
            return state.get(LEVEL)
        }

        override fun isStill(state: FluidState): Boolean {
            return false
        }
    }

    class Still : SoapWaterFluid() {
        override fun getLevel(state: FluidState): Int {
            return 8
        }

        override fun isStill(state: FluidState): Boolean {
            return true
        }
    }
}