package be.thespattt.tutorialmod.fluid


import be.thespattt.tutorialmod.TutorialMod
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.Block
import net.minecraft.block.Blocks
import net.minecraft.block.FluidBlock
import net.minecraft.fluid.FlowableFluid
import net.minecraft.fluid.Fluid
import net.minecraft.item.BucketItem
import net.minecraft.item.Item
import net.minecraft.item.Items
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.util.Identifier


object ModFluids {
    val STILL_SOAP_WATER: FlowableFluid = Registry.register<Fluid, SoapWaterFluid.Still>(
        Registries.FLUID,
        Identifier(TutorialMod.MOD_ID, "soap_water"), SoapWaterFluid.Still()
    )
    val FLOWING_SOAP_WATER: FlowableFluid = Registry.register<Fluid, SoapWaterFluid.Flowing>(
        Registries.FLUID,
        Identifier(TutorialMod.MOD_ID, "flowing_soap_water"), SoapWaterFluid.Flowing()
    )
    val SOAP_WATER_BLOCK: Block = Registry.register<Block, FluidBlock>(
        Registries.BLOCK, Identifier(
            TutorialMod.MOD_ID,
            "soap_water_block"
        ), FluidBlock(
            STILL_SOAP_WATER, FabricBlockSettings.copyOf(Blocks.WATER)
                .replaceable().liquid()
        )
    )
    val SOAP_WATER_BUCKET: Item = Registry.register<Item, BucketItem>(
        Registries.ITEM, Identifier(
            TutorialMod.MOD_ID,
            "soap_water_bucket"
        ), BucketItem(
            STILL_SOAP_WATER,
            FabricItemSettings().recipeRemainder(Items.BUCKET).maxCount(1)
        )
    )


    val STILL_FAIRY_WATER: FlowableFluid = Registry.register<Fluid, FairyWaterFluid.Still>(
        Registries.FLUID,
        Identifier(TutorialMod.MOD_ID, "fairy_water"), FairyWaterFluid.Still()
    )
    val FLOWING_FAIRY_WATER: FlowableFluid = Registry.register<Fluid, FairyWaterFluid.Flowing>(
        Registries.FLUID,
        Identifier(TutorialMod.MOD_ID, "flowing_fairy_water"), FairyWaterFluid.Flowing()
    )
    val FAIRY_WATER_BLOCK: Block = Registry.register<Block, FluidBlock>(
        Registries.BLOCK, Identifier(
            TutorialMod.MOD_ID,
            "fairy_water_block"
        ), FluidBlock(
            STILL_FAIRY_WATER, FabricBlockSettings.copyOf(Blocks.WATER)
                .replaceable().liquid()
        )
    )
    val FAIRY_WATER_BUCKET: Item = Registry.register<Item, BucketItem>(
        Registries.ITEM, Identifier(
            TutorialMod.MOD_ID,
            "fairy_water_bucket"
        ), BucketItem(
            STILL_FAIRY_WATER,
            FabricItemSettings().recipeRemainder(Items.BUCKET).maxCount(1)
        )
    )

    fun registerFluids() {
        TutorialMod.LOGGER.info("Registering Fluid for " + TutorialMod.MOD_ID)
    }
}