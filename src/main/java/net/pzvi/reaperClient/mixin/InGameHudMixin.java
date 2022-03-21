package net.pzvi.reaperClient.mixin;

        import net.minecraft.entity.player.PlayerEntity;
        import net.pzvi.reaperClient.Freecam;
        import net.pzvi.reaperClient.features.modules.Module;
        import net.pzvi.reaperClient.features.modules.ModuleRegistry;
        import net.minecraft.client.gui.hud.InGameHud;
        import net.minecraft.client.util.math.MatrixStack;
        import org.spongepowered.asm.mixin.Mixin;
        import org.spongepowered.asm.mixin.injection.At;
        import org.spongepowered.asm.mixin.injection.Inject;
        import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
        import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

        import static net.pzvi.reaperClient.Freecam.MC;

@Mixin(InGameHud.class)
        public class InGameHudMixin {
        @Inject(method="render",at=@At("HEAD"))
        public void onRender(MatrixStack matrices, float tickDelta, CallbackInfo ci) {
        for (Module module : ModuleRegistry.getInstance().getAll()) {
        if (module.isEnabled()) module.renderHud();
        }
        }
        @Inject(method = "getCameraPlayer", at = @At("HEAD"), cancellable = true)
        private void onGetCameraPlayer(CallbackInfoReturnable<PlayerEntity> cir) {
                if (Freecam.isEnabled()) {
                        cir.setReturnValue(MC.player);
                }
        }
        }