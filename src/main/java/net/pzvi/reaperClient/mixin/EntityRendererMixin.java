package net.pzvi.reaperClient.mixin;

import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.entity.Entity;
import net.pzvi.reaperClient.Freecam;
import net.pzvi.reaperClient.util.FreeCamera;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static net.pzvi.reaperClient.Freecam.MC;


@Mixin(EntityRenderer.class)
public class EntityRendererMixin {

    @Inject(method = "getLight", at = @At("HEAD"), cancellable = true)
    private void onGetLight(Entity entity, float tickDelta, CallbackInfoReturnable<Integer> cir) {
        if (Freecam.isEnabled() && entity.equals(MC.player)) {
            FreeCamera freeCamera = Freecam.getFreeCamera();
            EntityRenderer<? super FreeCamera> entityRenderer = MC.getEntityRenderDispatcher().getRenderer(freeCamera);
            cir.setReturnValue(entityRenderer.getLight(freeCamera, tickDelta));
        }
    }
}
