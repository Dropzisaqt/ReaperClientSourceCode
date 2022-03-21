package net.pzvi.reaperClient.features.command.impl;

import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;
import net.minecraft.world.GameMode;
import net.pzvi.reaperClient.features.command.Command;

public class gamemode extends Command {
    public gamemode() {
        super("gamemode", "gamemode", "gamemode");
    }

    @Override
    public void execute(String[] args) {
        String s1 = "c";
        String s2 = "creative";
        String s3 = "s";
        String s4 = "survival";
        String test = String.join(" ",args);
        if ((args == null) || (args.length == 0)) {
            MinecraftClient.getInstance().player.sendMessage(Text.of("§3§lReaper§b§lClient §8» §4Invalid Arguments. Please use the following format: '.gamemode <gamemode>'"), false);
            return;
        }
        else if (test.equals(s4)) {
            MinecraftClient.getInstance().interactionManager.setGameMode(GameMode.SURVIVAL);
        }
        else if (test.equals(s3)) {
            MinecraftClient.getInstance().interactionManager.setGameMode(GameMode.SURVIVAL);
        }
        else if (test.equals(s1)) {
            MinecraftClient.getInstance().interactionManager.setGameMode(GameMode.CREATIVE);
        }
        else if (test.equals(s2)) {
            MinecraftClient.getInstance().interactionManager.setGameMode(GameMode.CREATIVE);
        }
        else {
            MinecraftClient.getInstance().player.sendMessage(Text.of("§3§lReaper§b§lClient §8» §4Invalid Arguments. Please use the following format: '.gamemode <gamemode>'"), false);
            return;
        }
        }
    }


