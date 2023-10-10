package be.thespattt.tutorialmod.datagen


import be.thespattt.tutorialmod.block.ModBlocks
import be.thespattt.tutorialmod.item.ModItems
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider
import net.minecraft.block.Block
import net.minecraft.enchantment.Enchantments
import net.minecraft.item.Item
import net.minecraft.loot.LootTable
import net.minecraft.loot.condition.RandomChanceLootCondition
import net.minecraft.loot.entry.ItemEntry
import net.minecraft.loot.entry.LeafEntry
import net.minecraft.loot.entry.LootPoolEntry
import net.minecraft.loot.function.ApplyBonusLootFunction
import net.minecraft.loot.function.LootFunctionConsumingBuilder
import net.minecraft.loot.function.SetCountLootFunction
import net.minecraft.loot.provider.number.UniformLootNumberProvider


class ModLootTableProvider(dataOutput: FabricDataOutput?) : FabricBlockLootTableProvider(dataOutput) {
    override fun generate() {
        addDrop(ModBlocks.RUBY_BLOCK)
        addDrop(ModBlocks.RAW_RUBY_BLOCK)
        addDrop(ModBlocks.RUBY_ORE, oreDrops(ModBlocks.RUBY_ORE, ModItems.RAW_RUBY))
        addDrop(ModBlocks.MALACHITE_ORE, grassLikeOreDrops(ModBlocks.MALACHITE_ORE, ModItems.RAW_MALACHITE))
    }

    fun copperLikeOreDrops(drop: Block?, item: Item?): LootTable.Builder {
        return dropsWithSilkTouch(
            drop, applyExplosionDecay(
                drop,
                (ItemEntry.builder(item)
                    .apply(
                        SetCountLootFunction
                            .builder(
                                UniformLootNumberProvider
                                    .create(2.0f, 5.0f)
                            )
                    ) as LeafEntry.Builder<*>)
                    .apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))
            ) as LootPoolEntry.Builder<*>
        )
    }

    fun grassLikeOreDrops(drop: Block?, item: Item?): LootTable.Builder {
        return dropsWithShears(
            drop, applyExplosionDecay(
                drop, (ItemEntry.builder(item)
                    .conditionally(RandomChanceLootCondition.builder(0.7f))
                    .apply(ApplyBonusLootFunction.uniformBonusCount(Enchantments.FORTUNE, 2))
                        as LeafEntry.Builder<*>)
            ) as LootPoolEntry.Builder<*>
        )
    }
}