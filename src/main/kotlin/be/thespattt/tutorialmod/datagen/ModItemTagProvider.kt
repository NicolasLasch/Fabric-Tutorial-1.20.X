package be.thespattt.tutorialmod.datagen


import be.thespattt.tutorialmod.item.ModItems
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider
import net.minecraft.registry.RegistryWrapper.WrapperLookup
import net.minecraft.registry.tag.ItemTags
import java.util.concurrent.CompletableFuture


class ModItemTagProvider(output: FabricDataOutput?, completableFuture: CompletableFuture<WrapperLookup?>?) :
    FabricTagProvider.ItemTagProvider(output, completableFuture) {
    override fun configure(arg: WrapperLookup) {
        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
            .add(ModItems.RUBY_HELMET, ModItems.RUBY_CHESTPLATE, ModItems.RUBY_LEGGINGS, ModItems.RUBY_BOOTS)
            .add(ModItems.MALACHITE_HELMET, ModItems.MALACHITE_CHESTPLATE, ModItems.MALACHITE_LEGGINGS, ModItems.MALACHITE_BOOTS)
    }
}