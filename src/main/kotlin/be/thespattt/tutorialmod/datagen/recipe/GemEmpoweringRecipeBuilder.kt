package be.thespattt.tutorialmod.datagen.recipe

import be.thespattt.tutorialmod.TutorialMod
import be.thespattt.tutorialmod.recipe.GemEmpoweringRecipe
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import net.minecraft.advancement.Advancement
import net.minecraft.advancement.AdvancementRewards
import net.minecraft.advancement.criterion.CriterionConditions
import net.minecraft.advancement.criterion.RecipeUnlockedCriterion
import net.minecraft.data.server.recipe.CraftingRecipeJsonBuilder
import net.minecraft.data.server.recipe.RecipeJsonProvider
import net.minecraft.item.Item
import net.minecraft.item.ItemConvertible
import net.minecraft.recipe.Ingredient
import net.minecraft.recipe.RecipeSerializer
import net.minecraft.registry.Registries
import net.minecraft.util.Identifier
import java.util.function.Consumer


class GemEmpoweringRecipeBuilder(ingredient: ItemConvertible?, result: ItemConvertible, private val count: Int) :
    CraftingRecipeJsonBuilder {
    private val result: Item
    private val ingredient: Ingredient
    private val advancement = Advancement.Builder.create()

    init {
        this.ingredient = Ingredient.ofItems(ingredient)
        this.result = result.asItem()
    }

    override fun criterion(name: String, conditions: CriterionConditions): CraftingRecipeJsonBuilder {
        advancement.criterion(name, conditions)
        return this
    }

    override fun group(group: String?): CraftingRecipeJsonBuilder {
        return this
    }

    override fun getOutputItem(): Item {
        return result
    }

    override fun offerTo(exporter: Consumer<RecipeJsonProvider>, recipeId: Identifier) {
        advancement.parent(Identifier("recipes/root"))
            .criterion("has_the_recipe", RecipeUnlockedCriterion.create(recipeId))
            .rewards(AdvancementRewards.Builder.recipe(recipeId))
        exporter.accept(
            JsonBuilder(
                recipeId, result, count, ingredient,
                advancement, Identifier(
                    recipeId.namespace, "recipes/"
                            + recipeId.path
                )
            )
        )
    }

    class JsonBuilder(
        private val id: Identifier,
        private val result: Item,
        private val count: Int,
        private val ingredient: Ingredient,
        private val advancement: Advancement.Builder,
        private val advancementId: Identifier
    ) : RecipeJsonProvider {
        override fun serialize(json: JsonObject) {
            val jsonarray = JsonArray()
            jsonarray.add(ingredient.toJson())
            json.add("ingredients", jsonarray)
            val jsonobject = JsonObject()
            jsonobject.addProperty("item", Registries.ITEM.getId(result).toString())
            if (count > 1) {
                jsonobject.addProperty("count", count)
            }
            json.add("output", jsonobject)
        }

        override fun getRecipeId(): Identifier {
            return Identifier(
                TutorialMod.MOD_ID,
                Registries.ITEM.getId(result).path + "_from_gem_empowering"
            )
        }

        override fun getSerializer(): RecipeSerializer<*> {
            return GemEmpoweringRecipe.Serializer.INSTANCE
        }

        override fun toAdvancementJson(): JsonObject? {
            return advancement.toJson()
        }

        override fun getAdvancementId(): Identifier? {
            return advancementId
        }
    }
}