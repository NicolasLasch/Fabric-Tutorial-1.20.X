package be.thespattt.tutorialmod

import net.fabricmc.api.ModInitializer
import be.thespattt.tutorialmod.item.ModItemGroups
import be.thespattt.tutorialmod.block.ModBlocks
import be.thespattt.tutorialmod.block.entity.ModBlockEntities
import be.thespattt.tutorialmod.entity.ModEntities
import be.thespattt.tutorialmod.entity.custom.PorcupineEntity
import be.thespattt.tutorialmod.fluid.ModFluids
import be.thespattt.tutorialmod.item.ModItems
import be.thespattt.tutorialmod.recipe.ModRecipes
import be.thespattt.tutorialmod.screen.ModScreenHandlers
import net.fabricmc.fabric.api.`object`.builder.v1.entity.FabricDefaultAttributeRegistry
import net.fabricmc.fabric.api.registry.FuelRegistry
import org.slf4j.Logger
import org.slf4j.LoggerFactory

object TutorialMod : ModInitializer {
	const val MOD_ID = "tutorialmod"
	val LOGGER: Logger = LoggerFactory.getLogger(MOD_ID)

	override fun onInitialize() {
		ModItemGroups.registerItemGroups()
		ModItems.registerModItems()
		ModFluids.registerFluids()
		ModBlocks.registerModBlocks()
		FuelRegistry.INSTANCE.add(ModItems.MALACHITE, 360)
		FabricDefaultAttributeRegistry.register(ModEntities.PORCUPINE, PorcupineEntity.createPorcupineAttributes())
		ModBlockEntities.registerBlockEntities()
		ModScreenHandlers.registerScreenHandler()
		ModRecipes.registerRecipes()
	}
}
