package be.thespattt.tutorialmod.recipe

import com.google.gson.JsonObject
import net.minecraft.inventory.SimpleInventory
import net.minecraft.item.ItemStack
import net.minecraft.network.PacketByteBuf
import net.minecraft.recipe.*
import net.minecraft.registry.DynamicRegistryManager
import net.minecraft.util.Identifier
import net.minecraft.util.JsonHelper
import net.minecraft.util.collection.DefaultedList
import net.minecraft.world.World


class GemEmpoweringRecipe(
    private val id: Identifier,
    private val output: ItemStack,
    private val recipeItems: DefaultedList<Ingredient>
) :
    Recipe<SimpleInventory> {
    override fun matches(inventory: SimpleInventory, world: World): Boolean {
        return if (world.isClient()) {
            false
        } else recipeItems[0].test(inventory.getStack(0))
    }

    override fun craft(inventory: SimpleInventory, registryManager: DynamicRegistryManager): ItemStack {
        return output.copy()
    }

    override fun fits(width: Int, height: Int): Boolean {
        return true
    }

    override fun getOutput(registryManager: DynamicRegistryManager): ItemStack {
        return output.copy()
    }

    override fun getId(): Identifier {
        return id
    }

    override fun getSerializer(): RecipeSerializer<*> {
        return Serializer.INSTANCE
    }

    override fun getType(): RecipeType<*> {
        return Type.INSTANCE
    }

    override fun getIngredients(): DefaultedList<Ingredient> {
        return recipeItems
    }

    object Type : RecipeType<GemEmpoweringRecipe?> {
        val INSTANCE: Type = Type
        const val ID = "gem_empowering"
    }

    class Serializer : RecipeSerializer<GemEmpoweringRecipe> {
        // this is the name given in the json file
        override fun read(id: Identifier, json: JsonObject): GemEmpoweringRecipe {
            val output = ShapedRecipe.outputFromJson(JsonHelper.getObject(json, "output"))
            val ingredients = JsonHelper.getArray(json, "ingredients")
            val inputs = DefaultedList.ofSize(1, Ingredient.EMPTY)
            for (i in inputs.indices) {
                inputs[i] = Ingredient.fromJson(ingredients[i])
            }
            return GemEmpoweringRecipe(id, output, inputs)
        }

        override fun read(id: Identifier, buf: PacketByteBuf): GemEmpoweringRecipe {
            val inputs = DefaultedList.ofSize(buf.readInt(), Ingredient.EMPTY)
            for (i in inputs.indices) {
                inputs[i] = Ingredient.fromPacket(buf)
            }
            val output = buf.readItemStack()
            return GemEmpoweringRecipe(id, output, inputs)
        }

        override fun write(buf: PacketByteBuf, recipe: GemEmpoweringRecipe) {
            buf.writeInt(recipe.ingredients.size)
            for (ing in recipe.ingredients) {
                ing.write(buf)
            }
            buf.writeItemStack(recipe.getOutput(DynamicRegistryManager.EMPTY))
        }

        companion object {
            val INSTANCE = Serializer()
            const val ID = "gem_empowering"
        }
    }
}