package be.thespattt.tutorialmod.datagen


import be.thespattt.tutorialmod.block.ModBlocks
import be.thespattt.tutorialmod.item.ModItems
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider
import net.minecraft.data.server.recipe.RecipeJsonProvider
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder
import net.minecraft.item.ItemConvertible
import net.minecraft.item.Items
import net.minecraft.recipe.book.RecipeCategory
import net.minecraft.util.Identifier
import java.util.function.Consumer


class ModRecipeProvider(output: FabricDataOutput?) : FabricRecipeProvider(output) {
    override fun generate(exporter: Consumer<RecipeJsonProvider>) {
        //Smelting
        offerSmelting(exporter, RUBY_SMELTABLES, RecipeCategory.MISC, ModItems.RUBY, 0.7f, 200, "ruby")
        offerSmelting(exporter, MALACHITE_SMELTABLES, RecipeCategory.MISC, ModItems.MALACHITE, 1.2f, 200, "ruby")
        //Blasting
        offerBlasting(exporter, RUBY_SMELTABLES, RecipeCategory.MISC, ModItems.RUBY, 0.7f, 100, "ruby")
        offerBlasting(exporter, MALACHITE_SMELTABLES, RecipeCategory.MISC, ModItems.MALACHITE, 1.2f, 100, "ruby")
        //Block Craft
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.RUBY, RecipeCategory.DECORATIONS, ModBlocks.RUBY_BLOCK)
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.MALACHITE, RecipeCategory.DECORATIONS, ModBlocks.MALACHITE_BLOCK)
        //CUSTOM CRAFT
        // RUBY
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.RUBY_PICKAXE, 1)
            .pattern("RRR")
            .pattern(" S ")
            .pattern(" S ")
            .input('S', Items.STICK)
            .input('R', ModItems.RUBY)
            .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
            .criterion(hasItem(ModItems.RUBY), conditionsFromItem(ModItems.RUBY))
            .offerTo(exporter, Identifier(getRecipeName(ModItems.RUBY_PICKAXE)))

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.RUBY_AXE, 1)
            .pattern(" RR")
            .pattern(" SR")
            .pattern(" S ")
            .input('S', Items.STICK)
            .input('R', ModItems.RUBY)
            .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
            .criterion(hasItem(ModItems.RUBY), conditionsFromItem(ModItems.RUBY))
            .offerTo(exporter, Identifier(getRecipeName(ModItems.RUBY_AXE)))

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.RUBY_SHOVEL, 1)
            .pattern(" R ")
            .pattern(" S ")
            .pattern(" S ")
            .input('S', Items.STICK)
            .input('R', ModItems.RUBY)
            .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
            .criterion(hasItem(ModItems.RUBY), conditionsFromItem(ModItems.RUBY))
            .offerTo(exporter, Identifier(getRecipeName(ModItems.RUBY_SHOVEL)))

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.RUBY_HOE, 1)
            .pattern(" RR")
            .pattern(" S ")
            .pattern(" S ")
            .input('S', Items.STICK)
            .input('R', ModItems.RUBY)
            .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
            .criterion(hasItem(ModItems.RUBY), conditionsFromItem(ModItems.RUBY))
            .offerTo(exporter, Identifier(getRecipeName(ModItems.RUBY_HOE)))

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.RUBY_SWORD, 1)
            .pattern(" R ")
            .pattern(" R ")
            .pattern(" S ")
            .input('S', Items.STICK)
            .input('R', ModItems.RUBY)
            .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
            .criterion(hasItem(ModItems.RUBY), conditionsFromItem(ModItems.RUBY))
            .offerTo(exporter, Identifier(getRecipeName(ModItems.RUBY_SWORD)))

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.RUBY_HELMET, 1)
            .pattern("RRR")
            .pattern("R R")
            .pattern("   ")
            .input('R', ModItems.RUBY)
            .criterion(hasItem(ModItems.RUBY), conditionsFromItem(ModItems.RUBY))
            .offerTo(exporter, Identifier(getRecipeName(ModItems.RUBY_HELMET)))

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.RUBY_CHESTPLATE, 1)
            .pattern("R R")
            .pattern("RRR")
            .pattern("RRR")
            .input('R', ModItems.RUBY)
            .criterion(hasItem(ModItems.RUBY), conditionsFromItem(ModItems.RUBY))
            .offerTo(exporter, Identifier(getRecipeName(ModItems.RUBY_CHESTPLATE)))

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.RUBY_LEGGINGS, 1)
            .pattern("RRR")
            .pattern("R R")
            .pattern("R R")
            .input('R', ModItems.RUBY)
            .criterion(hasItem(ModItems.RUBY), conditionsFromItem(ModItems.RUBY))
            .offerTo(exporter, Identifier(getRecipeName(ModItems.RUBY_LEGGINGS)))

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.RUBY_BOOTS, 1)
            .pattern("R R")
            .pattern("R R")
            .pattern("   ")
            .input('R', ModItems.RUBY)
            .criterion(hasItem(ModItems.RUBY), conditionsFromItem(ModItems.RUBY))
            .offerTo(exporter, Identifier(getRecipeName(ModItems.RUBY_BOOTS)))
        //MALACHITE
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.MALACHITE_PICKAXE, 1)
            .pattern("RRR")
            .pattern(" S ")
            .pattern(" S ")
            .input('S', Items.STICK)
            .input('R', ModItems.MALACHITE)
            .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
            .criterion(hasItem(ModItems.MALACHITE), conditionsFromItem(ModItems.MALACHITE))
            .offerTo(exporter, Identifier(getRecipeName(ModItems.MALACHITE_PICKAXE)))

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.MALACHITE_AXE, 1)
            .pattern(" RR")
            .pattern(" SR")
            .pattern(" S ")
            .input('S', Items.STICK)
            .input('R', ModItems.MALACHITE)
            .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
            .criterion(hasItem(ModItems.MALACHITE), conditionsFromItem(ModItems.MALACHITE))
            .offerTo(exporter, Identifier(getRecipeName(ModItems.MALACHITE_AXE)))

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.MALACHITE_SHOVEL, 1)
            .pattern(" R ")
            .pattern(" S ")
            .pattern(" S ")
            .input('S', Items.STICK)
            .input('R', ModItems.MALACHITE)
            .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
            .criterion(hasItem(ModItems.MALACHITE), conditionsFromItem(ModItems.MALACHITE))
            .offerTo(exporter, Identifier(getRecipeName(ModItems.MALACHITE_SHOVEL)))

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.MALACHITE_HOE, 1)
            .pattern(" RR")
            .pattern(" S ")
            .pattern(" S ")
            .input('S', Items.STICK)
            .input('R', ModItems.MALACHITE)
            .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
            .criterion(hasItem(ModItems.MALACHITE), conditionsFromItem(ModItems.MALACHITE))
            .offerTo(exporter, Identifier(getRecipeName(ModItems.MALACHITE_HOE)))

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.MALACHITE_SWORD, 1)
            .pattern(" R ")
            .pattern(" R ")
            .pattern(" S ")
            .input('S', Items.STICK)
            .input('R', ModItems.MALACHITE)
            .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
            .criterion(hasItem(ModItems.MALACHITE), conditionsFromItem(ModItems.MALACHITE))
            .offerTo(exporter, Identifier(getRecipeName(ModItems.MALACHITE_SWORD)))

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.MALACHITE_HELMET, 1)
            .pattern("RRR")
            .pattern("R R")
            .pattern("   ")
            .input('R', ModItems.MALACHITE)
            .criterion(hasItem(ModItems.MALACHITE), conditionsFromItem(ModItems.MALACHITE))
            .offerTo(exporter, Identifier(getRecipeName(ModItems.MALACHITE_HELMET)))

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.MALACHITE_CHESTPLATE, 1)
            .pattern("R R")
            .pattern("RRR")
            .pattern("RRR")
            .input('R', ModItems.MALACHITE)
            .criterion(hasItem(ModItems.MALACHITE), conditionsFromItem(ModItems.MALACHITE))
            .offerTo(exporter, Identifier(getRecipeName(ModItems.MALACHITE_CHESTPLATE)))

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.MALACHITE_LEGGINGS, 1)
            .pattern("RRR")
            .pattern("R R")
            .pattern("R R")
            .input('R', ModItems.MALACHITE)
            .criterion(hasItem(ModItems.MALACHITE), conditionsFromItem(ModItems.MALACHITE))
            .offerTo(exporter, Identifier(getRecipeName(ModItems.MALACHITE_LEGGINGS)))

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.MALACHITE_BOOTS, 1)
            .pattern("R R")
            .pattern("R R")
            .pattern("   ")
            .input('R', ModItems.MALACHITE)
            .criterion(hasItem(ModItems.MALACHITE), conditionsFromItem(ModItems.MALACHITE))
            .offerTo(exporter, Identifier(getRecipeName(ModItems.MALACHITE_BOOTS)))
    }

    companion object {
        private val RUBY_SMELTABLES = listOf<ItemConvertible>(
            ModItems.RAW_RUBY,
            ModBlocks.RUBY_ORE,
        )
        private val MALACHITE_SMELTABLES = listOf<ItemConvertible>(
            ModItems.RAW_MALACHITE,
            ModBlocks.MALACHITE_ORE,
        )
    }

}