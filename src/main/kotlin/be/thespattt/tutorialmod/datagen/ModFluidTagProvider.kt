package be.thespattt.tutorialmod.datagen

import be.thespattt.tutorialmod.fluid.ModFluids
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider.FluidTagProvider
import net.minecraft.registry.RegistryWrapper.WrapperLookup
import net.minecraft.registry.tag.FluidTags
import java.util.concurrent.CompletableFuture


class ModFluidTagProvider(output: FabricDataOutput?, completableFuture: CompletableFuture<WrapperLookup?>?) :
    FluidTagProvider(output, completableFuture) {
    override fun configure(arg: WrapperLookup) {
        getOrCreateTagBuilder(FluidTags.WATER)
            .add(ModFluids.FLOWING_SOAP_WATER)
            .add(ModFluids.STILL_SOAP_WATER)
            .add(ModFluids.FLOWING_FAIRY_WATER)
            .add(ModFluids.STILL_FAIRY_WATER)

    }
}