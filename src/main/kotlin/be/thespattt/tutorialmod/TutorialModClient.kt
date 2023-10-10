package be.thespattt.tutorialmod


import be.thespattt.tutorialmod.entity.ModEntities
import be.thespattt.tutorialmod.entity.client.ModModelLayers
import be.thespattt.tutorialmod.entity.client.PorcupineModel
import be.thespattt.tutorialmod.entity.client.PorcupineRenderer
import be.thespattt.tutorialmod.fluid.ModFluids
import net.fabricmc.api.ClientModInitializer
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry
import net.minecraft.client.render.RenderLayer
import net.minecraft.client.render.entity.EntityRendererFactory


class TutorialModClient : ClientModInitializer {
    override fun onInitializeClient() {
        EntityRendererRegistry.register(
            ModEntities.PORCUPINE
        ) { context: EntityRendererFactory.Context? -> PorcupineRenderer(context!!) }
        EntityModelLayerRegistry.registerModelLayer(
            ModModelLayers.PORCUPINE
        ) { PorcupineModel.texturedModelData }

        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.STILL_SOAP_WATER, ModFluids.FLOWING_SOAP_WATER,
            SimpleFluidRenderHandler.coloredWater(8087790))
        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(),
            ModFluids.STILL_SOAP_WATER, ModFluids.FLOWING_SOAP_WATER)

        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.STILL_FAIRY_WATER, ModFluids.FLOWING_FAIRY_WATER,
            SimpleFluidRenderHandler.coloredWater(38103293))
        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(),
            ModFluids.STILL_FAIRY_WATER, ModFluids.FLOWING_FAIRY_WATER)
    }
}