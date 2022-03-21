package net.pzvi.reaperClient.mixin;

import net.minecraft.entity.LivingEntity;
import net.pzvi.reaperClient.Freecam;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {

    @Inject(method = "getMovementSpeed(F)F", at = @At("HEAD"), cancellable = true)
    private void onGetMovementSpeed(CallbackInfoReturnable<Float> cir) {
        if (Freecam.isEnabled()) {
            cir.setReturnValue((float) (2 / 10) * (Freecam.getFreeCamera().isSprinting() ? 2 : 1));
        }
    }
}
