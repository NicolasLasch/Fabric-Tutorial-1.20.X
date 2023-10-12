package be.thespattt.tutorialmod.datagen


import be.thespattt.tutorialmod.block.ModBlocks
import be.thespattt.tutorialmod.fluid.ModFluids
import be.thespattt.tutorialmod.item.ModItems
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider
import net.minecraft.data.client.BlockStateModelGenerator
import net.minecraft.data.client.ItemModelGenerator
import net.minecraft.data.client.Models
import net.minecraft.data.client.Model
import net.minecraft.item.ArmorItem
import net.minecraft.util.Identifier
import java.util.Optional


class ModModelProvider(output: FabricDataOutput?) : FabricModelProvider(output) {
    override fun generateBlockStateModels(blockStateModelGenerator: BlockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RUBY_BLOCK)
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_RUBY_BLOCK)
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RUBY_ORE)
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MALACHITE_BLOCK)
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MALACHITE_ORE)
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_MALACHITE_BLOCK)
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.GEM_EMPOWERING_STATION);
    }

    override fun generateItemModels(itemModelGenerator: ItemModelGenerator) {
        itemModelGenerator.register(ModItems.RUBY, Models.GENERATED)
        itemModelGenerator.register(ModItems.RAW_RUBY, Models.GENERATED)
        itemModelGenerator.register(ModItems.MALACHITE, Models.GENERATED)
        itemModelGenerator.register(ModItems.RAW_MALACHITE, Models.GENERATED)
        itemModelGenerator.register(ModItems.RUBY_PICKAXE, Models.HANDHELD)
        itemModelGenerator.register(ModItems.RUBY_AXE, Models.HANDHELD)
        itemModelGenerator.register(ModItems.RUBY_SHOVEL, Models.HANDHELD)
        itemModelGenerator.register(ModItems.RUBY_SWORD, Models.HANDHELD)
        itemModelGenerator.register(ModItems.RUBY_HOE, Models.HANDHELD)
        itemModelGenerator.register(ModItems.MALACHITE_PICKAXE, Models.HANDHELD)
        itemModelGenerator.register(ModItems.MALACHITE_AXE, Models.HANDHELD)
        itemModelGenerator.register(ModItems.MALACHITE_SHOVEL, Models.HANDHELD)
        itemModelGenerator.register(ModItems.MALACHITE_SWORD, Models.HANDHELD)
        itemModelGenerator.register(ModItems.MALACHITE_HOE, Models.HANDHELD)
        itemModelGenerator.registerArmor(ModItems.RUBY_HELMET as ArmorItem)
        itemModelGenerator.registerArmor(ModItems.RUBY_CHESTPLATE as ArmorItem)
        itemModelGenerator.registerArmor(ModItems.RUBY_LEGGINGS as ArmorItem)
        itemModelGenerator.registerArmor(ModItems.RUBY_BOOTS as ArmorItem)
        itemModelGenerator.registerArmor(ModItems.MALACHITE_HELMET as ArmorItem)
        itemModelGenerator.registerArmor(ModItems.MALACHITE_CHESTPLATE as ArmorItem)
        itemModelGenerator.registerArmor(ModItems.MALACHITE_LEGGINGS as ArmorItem)
        itemModelGenerator.registerArmor(ModItems.MALACHITE_BOOTS as ArmorItem)
        itemModelGenerator.register(ModItems.PORCUPINE_SPAWN_EGG, Model(Optional.of(Identifier("item/template_spawn_egg")), Optional.empty()))
        itemModelGenerator.register(ModFluids.SOAP_WATER_BUCKET, Models.GENERATED)
        itemModelGenerator.register(ModFluids.FAIRY_WATER_BUCKET, Models.GENERATED)

    }
}