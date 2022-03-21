package net.pzvi.reaperClient.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.input.Input;
import net.minecraft.client.input.KeyboardInput;
import net.pzvi.reaperClient.Freecam;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static net.pzvi.reaperClient.Freecam.MC;

@Mixin(MinecraftClient.class)
public class MinecraftClientMixin {

    @Inject(method = "tick", at = @At("HEAD"))
    private void onTick(CallbackInfo ci) {
        if (Freecam.isEnabled() ) {
            Input input = new Input();
            input.sneaking = MC.player.input.sneaking;
            MC.player.input = input;
        }
    }
}
