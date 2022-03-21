package net.pzvi.reaperClient.mixin;

import net.minecraft.client.render.OutlineVertexConsumerProvider;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.pzvi.reaperClient.features.modules.ModuleRegistry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(WorldRenderer.class)
public abstract class MixinWorldRenderer {

    @Inject(method = "renderEntity", at = @At("HEAD"))
    private void renderEntity(Entity entity, double cameraX, double cameraY, double cameraZ, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, CallbackInfo ci) {
        if (entity.getType().equals(EntityType.ITEM) && entity.isGlowing()) {
            if (ModuleRegistry.getInstance().MODULES.get(2).isEnabled()) {


                OutlineVertexConsumerProvider outlineVertexConsumers = (OutlineVertexConsumerProvider) vertexConsumers;
                outlineVertexConsumers.setColor(251, 255, 65, 255);

            }
        }
        if (entity.getType().equals(EntityType.PLAYER) && entity.isGlowing()) {
            if (ModuleRegistry.getInstance().MODULES.get(2).isEnabled()) {


                OutlineVertexConsumerProvider outlineVertexConsumers = (OutlineVertexConsumerProvider) vertexConsumers;
                outlineVertexConsumers.setColor(0, 128, 128, 255);

            }
        }
    }
}