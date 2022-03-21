package net.pzvi.reaperClient.features.command.impl;

import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;
import net.pzvi.reaperClient.features.command.Command;
import net.pzvi.reaperClient.util.PlaySong;
import net.pzvi.reaperClient.features.command.impl.PlaySong.*;

import java.util.Arrays;

public class stopMusic extends Command {
    public stopMusic() {
        super("stopMusic", "Stops any playing music", "stopMusic");
    }

    @Override
    public void execute(String[] args) {
        PlaySong.stopSong();
        MinecraftClient.getInstance().player.sendMessage(Text.of("§3§lReaper§b§lClient §8» &cStopped all songs from playing!"), true);

    }
}