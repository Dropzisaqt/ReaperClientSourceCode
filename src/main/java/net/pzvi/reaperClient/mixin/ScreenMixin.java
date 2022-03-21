package net.pzvi.reaperClient.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.pzvi.reaperClient.Freecam;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import net.minecraft.client.network.ClientPlayerEntity;
import net.pzvi.reaperClient.features.command.*;
import java.util.Arrays;

import static net.pzvi.reaperClient.Freecam.panic;


@Mixin(Screen.class)
public class ScreenMixin {

    @Inject(method = "sendMessage(Ljava/lang/String;Z)V", at = @At("HEAD"), cancellable = true)
    public void sendMessage(String message, boolean toHud, CallbackInfo ci) {
        if (!panic) {
            if (message.startsWith(".")) {
                MinecraftClient.getInstance().inGameHud.getChatHud().addToMessageHistory(message);
                ci.cancel();
                String messageWithoutPrefix = message.substring(1);
                String[] cmdAndArgs = messageWithoutPrefix.split(" +");
                String command = cmdAndArgs[0].toLowerCase();
                String[] args = Arrays.copyOfRange(cmdAndArgs, 1, cmdAndArgs.length);
                Command toExecute = CommandRegistry.getInstance().getByAlias(command);
                if (toExecute == null) {
                    MinecraftClient.getInstance().player.playSound(SoundEvents.BLOCK_NOTE_BLOCK_PLING, SoundCategory.MASTER, 1, 0.2f);
                    MinecraftClient.getInstance().player.sendMessage(Text.of("§3§lReaper§b§lClient §8» §4Invalid Command. Please do '§5.help§4' for a list of available commands."), false);
                } else {
                    toExecute.execute(args);
                    MinecraftClient.getInstance().player.playSound(SoundEvents.BLOCK_NOTE_BLOCK_PLING, SoundCategory.MASTER, 1, 1.5f);
                }

            }
            }
        else {
            if (message.startsWith(".safe")) {
                ci.cancel();
                panic = false;
            }
        }
    }
}