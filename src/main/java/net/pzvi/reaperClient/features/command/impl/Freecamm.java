package net.pzvi.reaperClient.features.command.impl;

import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;
import net.pzvi.reaperClient.features.command.Command;
import net.pzvi.reaperClient.Freecam;

import java.util.Arrays;

public class Freecamm extends Command {
    public Freecamm() {
        super("Freecam", "Allows you to see the perspective of gmsp!", "freecam");
    }

    @Override
    public void execute(String[] args) {
        Freecam.toggle();
        MinecraftClient.getInstance().player.sendMessage(Text.of("§3§lReaper§b§lClient §8» §7Successfully toggled freecam!"), false);
    }
}
