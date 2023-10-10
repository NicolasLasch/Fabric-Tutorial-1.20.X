package be.thespattt.tutorialmod.block

import be.thespattt.tutorialmod.TutorialMod
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.Block
import net.minecraft.block.Blocks
import net.minecraft.block.ExperienceDroppingBlock
import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.sound.BlockSoundGroup
import net.minecraft.util.Identifier
import net.minecraft.util.math.intprovider.UniformIntProvider


object ModBlocks {
    val RUBY_BLOCK: Block = registerBlock("ruby_block", Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(1.6f).sounds(BlockSoundGroup.AMETHYST_BLOCK)))
    val RAW_RUBY_BLOCK: Block = registerBlock("raw_ruby_block", Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(1.2f).sounds(BlockSoundGroup.AMETHYST_BLOCK)))
    val MALACHITE_BLOCK: Block = registerBlock("malachite_block", Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(1.6f).sounds(BlockSoundGroup.AMETHYST_BLOCK)))
    val RAW_MALACHITE_BLOCK: Block = registerBlock("raw_malachite_block", Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(1.2f).sounds(BlockSoundGroup.AMETHYST_BLOCK)))
    val RUBY_ORE: Block = registerBlock("ruby_ore", ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.STONE).strength(2f), UniformIntProvider.create(2, 5)))
    val MALACHITE_ORE: Block = registerBlock("malachite_ore", ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.STONE).strength(2f), UniformIntProvider.create(2, 5)))

    private fun registerBlock(name: String, block: Block): Block {
        registerBlockItem(name, block)
        return Registry.register(Registries.BLOCK, Identifier(TutorialMod.MOD_ID, name), block)
    }

    private fun registerBlockItem(name: String, block: Block): Item {
        return Registry.register(Registries.ITEM, Identifier(TutorialMod.MOD_ID, name), BlockItem(block, FabricItemSettings()))
    }
    fun registerModBlocks() {
        TutorialMod.LOGGER.info("Registering ModBlocks for " + TutorialMod.MOD_ID)
    }
}