package be.thespattt.tutorialmod.entity.client


import be.thespattt.tutorialmod.TutorialMod
import net.minecraft.client.render.entity.model.EntityModelLayer
import net.minecraft.util.Identifier


object ModModelLayers {
    val PORCUPINE = EntityModelLayer(Identifier(TutorialMod.MOD_ID, "porcupine"), "main")
}