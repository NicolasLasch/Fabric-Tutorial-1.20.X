package be.thespattt.tutorialmod.block.custom


import be.thespattt.tutorialmod.block.entity.GemEmpoweringStationBlockEntity
import be.thespattt.tutorialmod.block.entity.ModBlockEntities
import net.minecraft.block.*
import net.minecraft.block.entity.BlockEntity
import net.minecraft.block.entity.BlockEntityTicker
import net.minecraft.block.entity.BlockEntityType
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.ItemPlacementContext
import net.minecraft.screen.NamedScreenHandlerFactory
import net.minecraft.state.StateManager
import net.minecraft.state.property.Properties
import net.minecraft.util.ActionResult
import net.minecraft.util.Hand
import net.minecraft.util.ItemScatterer
import net.minecraft.util.hit.BlockHitResult
import net.minecraft.util.math.BlockPos
import net.minecraft.util.shape.VoxelShape
import net.minecraft.world.BlockView
import net.minecraft.world.World


class GemEmpoweringStationBlock(settings: Settings?) : BlockWithEntity(settings), BlockEntityProvider {
    override fun getOutlineShape(
        state: BlockState,
        world: BlockView,
        pos: BlockPos,
        context: ShapeContext
    ): VoxelShape {
        return SHAPE
    }

    override fun getPlacementState(ctx: ItemPlacementContext): BlockState? {
        return defaultState.with(FACING, ctx.horizontalPlayerFacing.opposite)
    }

    override fun appendProperties(builder: StateManager.Builder<Block, BlockState>) {
        builder.add(FACING)
    }

    override fun createBlockEntity(pos: BlockPos, state: BlockState): BlockEntity? {
        return GemEmpoweringStationBlockEntity(pos, state)
    }

    override fun getRenderType(state: BlockState): BlockRenderType {
        return BlockRenderType.MODEL
    }

    override fun onStateReplaced(state: BlockState, world: World, pos: BlockPos, newState: BlockState, moved: Boolean) {
        if (state.block !== newState.block) {
            val blockEntity = world.getBlockEntity(pos)
            if (blockEntity is GemEmpoweringStationBlockEntity) {
                ItemScatterer.spawn(world, pos, blockEntity as GemEmpoweringStationBlockEntity?)
                world.updateComparators(pos, this)
            }
            super.onStateReplaced(state, world, pos, newState, moved)
        }
    }

    override fun onUse(
        state: BlockState,
        world: World,
        pos: BlockPos,
        player: PlayerEntity,
        hand: Hand,
        hit: BlockHitResult
    ): ActionResult {
        if (!world.isClient) {
            val screenHandlerFactory: NamedScreenHandlerFactory? =
                world.getBlockEntity(pos) as GemEmpoweringStationBlockEntity?
            if (screenHandlerFactory != null) {
                player.openHandledScreen(screenHandlerFactory)
            }
        }
        return ActionResult.SUCCESS
    }

    override fun <T : BlockEntity> getTicker(world: World, state: BlockState, type: BlockEntityType<T>): BlockEntityTicker<T>? {
        return checkType(type, ModBlockEntities.GEM_EMPOWERING_STATION_BE
        ) { world1, pos, state1, blockEntity ->
            blockEntity.tick(
                world1,
                pos,
                state1
            )
        }
    }

    companion object {
        val FACING = Properties.HORIZONTAL_FACING
        private val SHAPE = createCuboidShape(0.0, 0.0, 0.0, 16.0, 12.0, 16.0)
    }
}