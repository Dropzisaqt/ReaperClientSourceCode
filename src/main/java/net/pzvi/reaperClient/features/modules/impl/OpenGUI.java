package net.pzvi.reaperClient.features.modules.impl;

import net.pzvi.reaperClient.features.TestGUI;
import net.pzvi.reaperClient.features.modules.Module;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.math.MatrixStack;

public class OpenGUI extends Module {
    int i = 0;
    public OpenGUI() {
        super("OpenGUI","Opens the gui");
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
        MinecraftClient instance = MinecraftClient.getInstance();
        i++;
        if (i > 1) {
            i = 0;
            setEnabled(false);
            instance.setScreen(new TestGUI());
        }
    }

    @Override
    public void renderWorld(MatrixStack stack) {

    }

    @Override
    public void renderHud() {

    }
}
