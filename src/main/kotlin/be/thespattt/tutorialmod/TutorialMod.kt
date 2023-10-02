package be.thespattt.tutorialmod

import net.fabricmc.api.ModInitializer
import org.slf4j.LoggerFactory

class TutorialMod : ModInitializer {
	val mod_ID = "tutorialmod"
	val logger = LoggerFactory.getLogger(mod_ID)

	override fun onInitialize() {
		logger.info("Hello Fabric world!")
	}
}