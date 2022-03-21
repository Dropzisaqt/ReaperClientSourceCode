package net.pzvi.reaperClient;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.ModInitializer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.input.KeyboardInput;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.option.Perspective;

import net.pzvi.reaperClient.util.FreeCamera;
import net.pzvi.reaperClient.util.Util;
import org.lwjgl.glfw.GLFW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Freecam implements ModInitializer {

    public static final MinecraftClient MC = MinecraftClient.getInstance();

    private static KeyBinding keyBinding;
    private static boolean enabled = false;

    private static FreeCamera freeCamera;

    public static void toggle() {
        if (enabled) {
            onDisable();
        } else {
            onEnable();
        }
        enabled = !enabled;
    }

    public static void onEnable() {
        MC.chunkCullingEnabled = false;
        MC.gameRenderer.setRenderHand(true);
        freeCamera = new FreeCamera();
        freeCamera.spawn();
        MC.setCameraEntity(freeCamera);

        if (MC.gameRenderer.getCamera().isThirdPerson()) {
            MC.options.setPerspective(Perspective.FIRST_PERSON);
        }

    }

    public static void onDisable() {
        MC.chunkCullingEnabled = true;
        MC.gameRenderer.setRenderHand(true);
        MC.player.input = new KeyboardInput(MC.options);
        MC.setCameraEntity(MC.player);
        freeCamera.despawn();
        freeCamera = null;

    }


    public static FreeCamera getFreeCamera() {
        return freeCamera;
    }

    public static boolean isEnabled() {
        return enabled;
    }

    public static boolean panic;

    @Override
    public void onInitialize() {
        panic = false;

    }

}
