package net.pzvi.reaperClient.features.command.impl;

import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;
import net.pzvi.reaperClient.features.command.Command;

import java.util.Arrays;

public class help extends Command {
    public help() {
        super("help", "Help", "help");
    }

    @Override
    public void execute(String[] args) {
        MinecraftClient.getInstance().player.sendMessage(Text.of("§3§lReaper§b§lClient §8» §7Available Commands §8'§bvclip§5§8, §bfov§8, §btoggle§8, §bplaymusic§8, §bstopmusic§8, §bpanic§, §besp§8, §bgamemode§8'§7"), false);
    }
}