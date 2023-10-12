package be.thespattt.tutorialmod.block.entity


import be.thespattt.tutorialmod.TutorialMod
import be.thespattt.tutorialmod.block.ModBlocks
import net.fabricmc.fabric.api.`object`.builder.v1.block.entity.FabricBlockEntityTypeBuilder
import net.minecraft.block.BlockState
import net.minecraft.block.entity.BlockEntityType
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.util.Identifier
import net.minecraft.util.math.BlockPos


object ModBlockEntities {
    val GEM_EMPOWERING_STATION_BE =
        Registry.register<BlockEntityType<*>, BlockEntityType<GemEmpoweringStationBlockEntity>>(
            Registries.BLOCK_ENTITY_TYPE, Identifier(TutorialMod.MOD_ID, "gem_empowering_block_entity"),
            FabricBlockEntityTypeBuilder.create<GemEmpoweringStationBlockEntity>(
                { pos: BlockPos, state: BlockState ->
                    GemEmpoweringStationBlockEntity(
                        pos,
                        state
                    )
                },
                ModBlocks.GEM_EMPOWERING_STATION
            ).build(null)
        )

    fun registerBlockEntities() {
        TutorialMod.LOGGER.info("Registering Block Entities for " + TutorialMod.MOD_ID)
    }
}