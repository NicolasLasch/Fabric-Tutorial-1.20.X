package be.thespattt.tutorialmod.datagen


import be.thespattt.tutorialmod.block.ModBlocks
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider.BlockTagProvider
import net.minecraft.block.Block
import net.minecraft.registry.RegistryKeys
import net.minecraft.registry.RegistryWrapper.WrapperLookup
import net.minecraft.registry.tag.BlockTags
import net.minecraft.registry.tag.TagKey
import net.minecraft.util.Identifier
import java.util.concurrent.CompletableFuture


class ModBlockTagProvider(output: FabricDataOutput?, registriesFuture: CompletableFuture<WrapperLookup?>?) :
    BlockTagProvider(output, registriesFuture) {
    override fun configure(arg: WrapperLookup) {

        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
            .add(ModBlocks.RAW_RUBY_BLOCK)
            .add(ModBlocks.RUBY_BLOCK)
            .add(ModBlocks.RUBY_ORE)
            .add(ModBlocks.RAW_MALACHITE_BLOCK)
            .add(ModBlocks.MALACHITE_BLOCK)
            .add(ModBlocks.MALACHITE_ORE)

        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
            .add(ModBlocks.RAW_RUBY_BLOCK)
            .add(ModBlocks.RUBY_BLOCK)
            .add(ModBlocks.RUBY_ORE)
            .add(ModBlocks.RAW_MALACHITE_BLOCK)
            .add(ModBlocks.MALACHITE_BLOCK)
            .add(ModBlocks.MALACHITE_BLOCK)

        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)

        getOrCreateTagBuilder(TagKey.of<Block>(RegistryKeys.BLOCK, Identifier("fabric", "needs_tool_level_4")))

        getOrCreateTagBuilder(TagKey.of<Block>(RegistryKeys.BLOCK, Identifier("fabric", "needs_tool_level_5")))

    }
}