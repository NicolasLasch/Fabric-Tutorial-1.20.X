package be.thespattt.tutorialmod.recipe


import be.thespattt.tutorialmod.TutorialMod
import net.minecraft.recipe.RecipeSerializer
import net.minecraft.recipe.RecipeType
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.util.Identifier


object ModRecipes {
    fun registerRecipes() {
        Registry.register<RecipeSerializer<*>, GemEmpoweringRecipe.Serializer>(
            Registries.RECIPE_SERIALIZER, Identifier(TutorialMod.MOD_ID, GemEmpoweringRecipe.Serializer.ID),
            GemEmpoweringRecipe.Serializer.INSTANCE
        )
        Registry.register<RecipeType<*>, GemEmpoweringRecipe.Type>(
            Registries.RECIPE_TYPE, Identifier(TutorialMod.MOD_ID, GemEmpoweringRecipe.Type.ID),
            GemEmpoweringRecipe.Type
        )
    }
}