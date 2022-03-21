package net.pzvi.reaperClient.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.OutlineVertexConsumerProvider;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.command.EntitySelector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.pzvi.reaperClient.features.modules.impl.ESP;
import net.pzvi.reaperClient.features.modules.Module;
import net.pzvi.reaperClient.features.modules.ModuleRegistry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Entity.class)
public abstract class EntityRendererMixinn {
    @Shadow public abstract EntityType<?> getType();

    @Shadow public abstract boolean isPlayer();

    @Inject(method = "isGlowing", at = @At("HEAD"), cancellable = true)
    private void outlineEntities(CallbackInfoReturnable<Boolean> ci) {
        if (ModuleRegistry.getInstance().MODULES.get(2).isEnabled()) {
            if (getType().equals(EntityType.PLAYER) || getType().equals((EntityType.ITEM))) {
                ci.setReturnValue(true);
            }
}}
}