package be.thespattt.tutorialmod.entity.client


import be.thespattt.tutorialmod.TutorialMod
import be.thespattt.tutorialmod.entity.custom.PorcupineEntity
import net.minecraft.client.render.VertexConsumerProvider
import net.minecraft.client.render.entity.EntityRendererFactory
import net.minecraft.client.render.entity.MobEntityRenderer
import net.minecraft.client.util.math.MatrixStack
import net.minecraft.util.Identifier


class PorcupineRenderer(context: EntityRendererFactory.Context) :
    MobEntityRenderer<PorcupineEntity, PorcupineModel<PorcupineEntity?>?>(
        context,
        PorcupineModel<PorcupineEntity?>(context.getPart(ModModelLayers.PORCUPINE)),
        0.6f
    ) {
    override fun getTexture(entity: PorcupineEntity): Identifier {
        return TEXTURE
    }

    override fun render(
        mobEntity: PorcupineEntity, f: Float, g: Float, matrixStack: MatrixStack,
        vertexConsumerProvider: VertexConsumerProvider, i: Int
    ) {
        if (mobEntity.isBaby) {
            matrixStack.scale(0.7f, 0.7f, 0.7f)
        } else {
            matrixStack.scale(1.2f, 1.2f, 1.2f)
        }
        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i)
    }

    companion object {
        private val TEXTURE = Identifier(TutorialMod.MOD_ID, "textures/entity/porcupine.png")
    }
}