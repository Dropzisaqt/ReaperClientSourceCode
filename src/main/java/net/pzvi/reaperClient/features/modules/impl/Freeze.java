package net.pzvi.reaperClient.features.modules.impl;

import net.pzvi.reaperClient.features.modules.Module;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.math.MatrixStack;

public class Freeze extends Module {
    public Freeze() {
        super("Freeze","Freezes you in the air");
    }

    @Override
    public void onActivate() {

    }

    @Override
    public void onDeactivate() {

    }

    @Override
    protected void enable() {

    }

    @Override
    protected void disable() {

    }

    @Override
    public void tick() {
        assert MinecraftClient.getInstance().player != null;
        MinecraftClient.getInstance().player.setVelocity(0,0,0);
    }

    @Override
    public void renderWorld(MatrixStack stack) {

    }

    @Override
    public void renderHud() {

    }
}