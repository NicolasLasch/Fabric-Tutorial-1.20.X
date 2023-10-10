package be.thespattt.tutorialmod.item

import net.minecraft.item.ToolMaterial
import net.minecraft.recipe.Ingredient
import java.util.function.Supplier


enum class ModToolMaterial(private val miningLevel: Int, private val itemDurability: Int, private val miningSpeed: Float, private val attackDamage: Float, private val enchantability: Int, private val repairIngredient: Supplier<Ingredient>) : ToolMaterial {

    RUBY(3, 100, 6f, 3.5f, 26,
    Supplier { Ingredient.ofItems(ModItems.RUBY) }),
    MALACHITE(5, 1250, 15f, 3.5f, 26,
    Supplier { Ingredient.ofItems(ModItems.MALACHITE) });
    override fun getDurability(): Int {
        return itemDurability
    }

    override fun getMiningSpeedMultiplier(): Float {
        return miningSpeed
    }

    override fun getAttackDamage(): Float {
        return attackDamage
    }

    override fun getMiningLevel(): Int {
        return miningLevel
    }

    override fun getEnchantability(): Int {
        return enchantability
    }

    override fun getRepairIngredient(): Ingredient {
        return repairIngredient.get()
    }
}