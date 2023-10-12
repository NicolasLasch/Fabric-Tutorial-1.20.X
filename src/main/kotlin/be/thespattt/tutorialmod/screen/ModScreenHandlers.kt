package be.thespattt.tutorialmod.screen

import be.thespattt.tutorialmod.TutorialMod
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType
import net.minecraft.entity.player.PlayerInventory
import net.minecraft.network.PacketByteBuf
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.screen.ScreenHandlerType
import net.minecraft.util.Identifier


object ModScreenHandlers {
    val GEM_EMPOWERING_SCREEN_HANDLER: ScreenHandlerType<GemEmpoweringScreenHandler> =
        Registry.register(
            Registries.SCREEN_HANDLER, Identifier(TutorialMod.MOD_ID, "gem_empowering_screen_handler"),
            ExtendedScreenHandlerType { syncId: Int, inventory: PlayerInventory?, buf: PacketByteBuf? ->
                GemEmpoweringScreenHandler(
                    syncId,
                    inventory!!, buf!!
                )
            })

    fun registerScreenHandler() {
        TutorialMod.LOGGER.info("Registering Screen Handlers for " + TutorialMod.MOD_ID)
    }
}