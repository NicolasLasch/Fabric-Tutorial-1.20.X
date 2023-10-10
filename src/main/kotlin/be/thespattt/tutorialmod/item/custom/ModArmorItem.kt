package be.thespattt.tutorialmod.item.custom

import be.thespattt.tutorialmod.item.ModArmorMaterials
import com.google.common.collect.ImmutableMap
import net.minecraft.entity.Entity
import net.minecraft.entity.effect.StatusEffectInstance
import net.minecraft.entity.effect.StatusEffects
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.ArmorItem
import net.minecraft.item.ArmorMaterial
import net.minecraft.item.ItemStack
import net.minecraft.world.World


class ModArmorItem(material: ArmorMaterial?, type: Type?, settings: Settings?) : ArmorItem(material, type, settings) {

    companion object {
        private val MATERIAL_TO_EFFECT_MAP: Map<ArmorMaterial, StatusEffectInstance> = ImmutableMap.Builder<ArmorMaterial, StatusEffectInstance>()
            .put(ModArmorMaterials.RUBY, StatusEffectInstance(StatusEffects.HASTE, 40, 1, false, false, false))
            .put(ModArmorMaterials.MALACHITE, StatusEffectInstance(StatusEffects.RESISTANCE, 40, 1, false, false, false))
            .build()
    }

    override fun inventoryTick(stack: ItemStack, world: World, entity: Entity, slot: Int, selected: Boolean) {
        if (!world.isClient()) {
            if (entity is PlayerEntity && hasFullSuitOfArmorOn(entity)) {
                evaluateArmorEffects(entity)
            }
        }
        super.inventoryTick(stack, world, entity, slot, selected)
    }

    private fun evaluateArmorEffects(player: PlayerEntity) {
        for ((mapArmorMaterial, mapStatusEffect) in MATERIAL_TO_EFFECT_MAP) {
            if (hasCorrectArmorOn(mapArmorMaterial, player)) {
                addStatusEffectForMaterial(player, mapArmorMaterial, mapStatusEffect)
                if (mapArmorMaterial == ModArmorMaterials.RUBY){
                    player.addStatusEffect(StatusEffectInstance(StatusEffects.NIGHT_VISION, 400, 1, false, false, false))
                }
            }
        }
    }

    private fun addStatusEffectForMaterial(
        player: PlayerEntity,
        mapArmorMaterial: ArmorMaterial,
        mapStatusEffect: StatusEffectInstance
    ) {
        val hasPlayerEffect = player.hasStatusEffect(mapStatusEffect.effectType)
        if (hasCorrectArmorOn(mapArmorMaterial, player) && !hasPlayerEffect) {
            player.addStatusEffect(StatusEffectInstance(mapStatusEffect))
        }
    }

    private fun hasFullSuitOfArmorOn(player: PlayerEntity): Boolean {
        val boots = player.inventory.getArmorStack(0)
        val leggings = player.inventory.getArmorStack(1)
        val breastplate = player.inventory.getArmorStack(2)
        val helmet = player.inventory.getArmorStack(3)
        return (!helmet.isEmpty && !breastplate.isEmpty
                && !leggings.isEmpty && !boots.isEmpty)
    }

    private fun hasCorrectArmorOn(material: ArmorMaterial, player: PlayerEntity): Boolean {
        for (armorStack in player.inventory.armor) {
            if (armorStack.item !is ArmorItem) {
                return false
            }
        }
        val boots = player.inventory.getArmorStack(0).item as ArmorItem
        val leggings = player.inventory.getArmorStack(1).item as ArmorItem
        val breastplate = player.inventory.getArmorStack(2).item as ArmorItem
        val helmet = player.inventory.getArmorStack(3).item as ArmorItem
        return helmet.material === material && breastplate.material === material && leggings.material === material && boots.material === material
    }
}

