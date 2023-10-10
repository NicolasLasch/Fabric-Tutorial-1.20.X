package be.thespattt.tutorialmod.entity


import be.thespattt.tutorialmod.TutorialMod
import be.thespattt.tutorialmod.entity.custom.PorcupineEntity
import net.fabricmc.fabric.api.`object`.builder.v1.entity.FabricEntityTypeBuilder
import net.minecraft.entity.EntityDimensions
import net.minecraft.entity.EntityType
import net.minecraft.entity.SpawnGroup
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.util.Identifier
import net.minecraft.world.World


object ModEntities {
    val PORCUPINE: EntityType<PorcupineEntity> = Registry.register<EntityType<*>, EntityType<PorcupineEntity>>(
        Registries.ENTITY_TYPE,
        Identifier(TutorialMod.MOD_ID, "porcupine"),
        FabricEntityTypeBuilder.create<PorcupineEntity>(SpawnGroup.CREATURE,
            EntityType.EntityFactory<PorcupineEntity?> { entityType: EntityType<PorcupineEntity?>?, world: World? ->
                PorcupineEntity(
                    entityType,
                    world
                )
            })
            .dimensions(EntityDimensions.fixed(1f, 1f)).build()
    )
}