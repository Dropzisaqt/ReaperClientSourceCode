package net.pzvi.reaperClient.mixin;

import net.minecraft.entity.player.PlayerEntity;
import net.pzvi.reaperClient.Freecam;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Mixin(PlayerEntity.class)
public class PlayerEntityMixin {

    @Inject(method = "isBlockBreakingRestricted", at = @At("HEAD"), cancellable = true)
    public void onIsBlockBreakingRestricted(CallbackInfoReturnable<Boolean> cir) {
        if (Freecam.isEnabled()) {
            cir.setReturnValue(true);
        }
    }
}
