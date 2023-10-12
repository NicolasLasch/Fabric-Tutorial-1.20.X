package be.thespattt.tutorialmod


import be.thespattt.tutorialmod.entity.ModEntities
import be.thespattt.tutorialmod.entity.client.ModModelLayers
import be.thespattt.tutorialmod.entity.client.PorcupineModel
import be.thespattt.tutorialmod.entity.client.PorcupineRenderer
import be.thespattt.tutorialmod.fluid.ModFluids
import be.thespattt.tutorialmod.screen.GemEmpoweringScreen
import be.thespattt.tutorialmod.screen.GemEmpoweringScreenHandler
import be.thespattt.tutorialmod.screen.ModScreenHandlers
import net.fabricmc.api.ClientModInitializer
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry
import net.minecraft.client.gui.screen.ingame.HandledScreens
import net.minecraft.client.render.RenderLayer
import net.minecraft.client.render.entity.EntityRendererFactory
import net.minecraft.entity.player.PlayerInventory
import net.minecraft.text.Text


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

        HandledScreens.register(ModScreenHandlers.GEM_EMPOWERING_SCREEN_HANDLER) { handler, playerInventory, title -> GemEmpoweringScreen(handler, playerInventory, title) }
    }
}