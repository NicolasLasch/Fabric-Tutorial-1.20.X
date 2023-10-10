package be.thespattt.tutorialmod


import be.thespattt.tutorialmod.datagen.*
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.minecraft.registry.RegistryWrapper.WrapperLookup
import java.util.concurrent.CompletableFuture

class TutorialModDataGenerator : DataGeneratorEntrypoint {
	override fun onInitializeDataGenerator(fabricDataGenerator: FabricDataGenerator) {
		val pack = fabricDataGenerator.createPack()
		pack.addProvider { output: FabricDataOutput?, registriesFuture: CompletableFuture<WrapperLookup?>? -> ModBlockTagProvider(output, registriesFuture) }
		pack.addProvider { output: FabricDataOutput?, completableFuture: CompletableFuture<WrapperLookup?>? -> ModItemTagProvider(output, completableFuture) }
		pack.addProvider { dataOutput: FabricDataOutput? -> ModLootTableProvider(dataOutput) }
		pack.addProvider { output: FabricDataOutput? -> ModModelProvider(output) }
		pack.addProvider { output: FabricDataOutput? -> ModRecipeProvider(output) }
		pack.addProvider { output: FabricDataOutput?, completableFuture: CompletableFuture<WrapperLookup?>? -> ModFluidTagProvider(output, completableFuture) }
	}
}