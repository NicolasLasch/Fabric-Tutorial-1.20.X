package be.thespattt.tutorialmod.item

import be.thespattt.tutorialmod.TutorialMod
import be.thespattt.tutorialmod.entity.ModEntities
import be.thespattt.tutorialmod.item.custom.ModArmorItem
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.minecraft.item.*
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.util.Identifier


object ModItems {
    val RUBY: Item = registerItem("ruby", Item(FabricItemSettings()))
    val RAW_RUBY: Item = registerItem("raw_ruby", Item(FabricItemSettings()))
    val RAW_MALACHITE: Item = registerItem("raw_malachite", Item(FabricItemSettings()))
    val MALACHITE: Item = registerItem("malachite", Item(FabricItemSettings()))
    val RUBY_PICKAXE = registerItem("ruby_pickaxe", PickaxeItem(ModToolMaterial.RUBY, 2, 2f, FabricItemSettings()))
    val RUBY_AXE = registerItem("ruby_axe", AxeItem(ModToolMaterial.RUBY, 2.5f, 1f, FabricItemSettings()))
    val RUBY_SHOVEL = registerItem("ruby_shovel", ShovelItem(ModToolMaterial.RUBY, 0f, 0f, FabricItemSettings()))
    val RUBY_SWORD = registerItem("ruby_sword", SwordItem(ModToolMaterial.RUBY, 4, 3f, FabricItemSettings()))
    val RUBY_HOE = registerItem("ruby_hoe", HoeItem(ModToolMaterial.RUBY, 0, 0f, FabricItemSettings()))
    val MALACHITE_PICKAXE = registerItem("malachite_pickaxe", PickaxeItem(ModToolMaterial.MALACHITE, 2, 2f, FabricItemSettings()))
    val MALACHITE_AXE = registerItem("malachite_axe", AxeItem(ModToolMaterial.MALACHITE, 4f, 1f, FabricItemSettings()))
    val MALACHITE_SHOVEL = registerItem("malachite_shovel", ShovelItem(ModToolMaterial.MALACHITE, 0f, 0f, FabricItemSettings()))
    val MALACHITE_SWORD = registerItem("malachite_sword", SwordItem(ModToolMaterial.MALACHITE, 6, 3f, FabricItemSettings()))
    val MALACHITE_HOE = registerItem("malachite_hoe", HoeItem(ModToolMaterial.MALACHITE, 0, 0f, FabricItemSettings()))
    val RUBY_HELMET = registerItem("ruby_helmet", ModArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.HELMET, FabricItemSettings()))
    val RUBY_CHESTPLATE = registerItem("ruby_chestplate", ModArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.CHESTPLATE, FabricItemSettings()))
    val RUBY_LEGGINGS = registerItem("ruby_leggings", ModArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.LEGGINGS, FabricItemSettings()))
    val RUBY_BOOTS = registerItem("ruby_boots", ModArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.BOOTS, FabricItemSettings()))
    val MALACHITE_HELMET = registerItem("malachite_helmet", ModArmorItem(ModArmorMaterials.MALACHITE, ArmorItem.Type.HELMET, FabricItemSettings()))
    val MALACHITE_CHESTPLATE = registerItem("malachite_chestplate", ModArmorItem(ModArmorMaterials.MALACHITE, ArmorItem.Type.CHESTPLATE, FabricItemSettings()))
    val MALACHITE_LEGGINGS = registerItem("malachite_leggings", ModArmorItem(ModArmorMaterials.MALACHITE, ArmorItem.Type.LEGGINGS, FabricItemSettings()))
    val MALACHITE_BOOTS = registerItem("malachite_boots", ModArmorItem(ModArmorMaterials.MALACHITE, ArmorItem.Type.BOOTS, FabricItemSettings()))
    val PORCUPINE_SPAWN_EGG = registerItem("porcupine_spawn_egg", SpawnEggItem(ModEntities.PORCUPINE, 0xa86518, 0x3b260f, FabricItemSettings()))
    private fun addItemsToIngredientItemGroup(entries: FabricItemGroupEntries) {
        entries.add(RUBY)
        entries.add(RAW_RUBY)
        entries.add(RAW_MALACHITE)
        entries.add(MALACHITE)
    }

    private fun registerItem(name: String, item: Item): Item {
        return Registry.register(Registries.ITEM, Identifier(TutorialMod.MOD_ID, name), item)
    }

    fun registerModItems() {
        TutorialMod.LOGGER.info("Registering Mod Items for ${TutorialMod.MOD_ID}")
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(::addItemsToIngredientItemGroup)
    }
}
