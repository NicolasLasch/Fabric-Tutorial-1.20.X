package be.thespattt.tutorialmod.item

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup
import be.thespattt.tutorialmod.TutorialMod
import net.minecraft.item.ItemGroup
import be.thespattt.tutorialmod.block.ModBlocks
import be.thespattt.tutorialmod.fluid.ModFluids
import net.minecraft.item.ItemStack
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.text.Text
import net.minecraft.util.Identifier

object ModItemGroups {
    val CUSTOM_GROUP: ItemGroup = Registry.register(
        Registries.ITEM_GROUP,
        Identifier(TutorialMod.MOD_ID, "custom"),
        FabricItemGroup.builder()
            .displayName(Text.translatable("itemgroup.custom"))
            .icon { ItemStack(ModItems.RUBY) }
            .entries { displayContext, entries ->
                //Ruby
                entries.add(ModItems.RUBY)
                entries.add(ModItems.RAW_RUBY)
                entries.add(ModBlocks.RUBY_ORE)
                entries.add(ModBlocks.RUBY_BLOCK)
                entries.add(ModBlocks.RAW_RUBY_BLOCK)
                entries.add(ModItems.RUBY_PICKAXE)
                entries.add(ModItems.RUBY_AXE)
                entries.add(ModItems.RUBY_SHOVEL)
                entries.add(ModItems.RUBY_SWORD)
                entries.add(ModItems.RUBY_HOE)
                entries.add(ModItems.RUBY_HELMET)
                entries.add(ModItems.RUBY_CHESTPLATE)
                entries.add(ModItems.RUBY_LEGGINGS)
                entries.add(ModItems.RUBY_BOOTS)
                // Malachite
                entries.add(ModItems.MALACHITE)
                entries.add(ModItems.RAW_MALACHITE)
                entries.add(ModBlocks.MALACHITE_BLOCK)
                entries.add(ModBlocks.RAW_MALACHITE_BLOCK)
                entries.add(ModBlocks.MALACHITE_ORE)
                entries.add(ModItems.MALACHITE_PICKAXE)
                entries.add(ModItems.MALACHITE_AXE)
                entries.add(ModItems.MALACHITE_SHOVEL)
                entries.add(ModItems.MALACHITE_SWORD)
                entries.add(ModItems.MALACHITE_HOE)
                entries.add(ModItems.MALACHITE_HELMET)
                entries.add(ModItems.MALACHITE_CHESTPLATE)
                entries.add(ModItems.MALACHITE_LEGGINGS)
                entries.add(ModItems.MALACHITE_BOOTS)
                // EXTRA
                entries.add(ModItems.PORCUPINE_SPAWN_EGG)
                entries.add(ModFluids.SOAP_WATER_BUCKET)
                entries.add(ModFluids.FAIRY_WATER_BUCKET)
                entries.add(ModBlocks.GEM_EMPOWERING_STATION)
            }.build()
    )
    fun registerItemGroups() {
        TutorialMod.LOGGER.info("Registering Item Groups for ${TutorialMod.MOD_ID}")
    }
}
