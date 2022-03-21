package net.pzvi.reaperClient.features.command.impl;

import net.pzvi.reaperClient.features.command.Command;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;
import net.minecraft.client.network.ClientPlayerEntity;
import java.util.Arrays;

public class vclip extends Command {
    public vclip() {
        super("vclip", "Vclip", "vclip");
    }

    public static boolean isInt(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    @Override
    public void execute(String[] args) {
        if ((args == null) || (args.length == 0)) {
            MinecraftClient.getInstance().player.sendMessage(Text.of("§3§lReaper§b§lClient §8» §4Invalid Arguments. Please use the following format: '.vclip <integer>'"), false);
            return;
        } else {
            if (isInt(args[0])) {
            int blocks = Integer.parseInt(args[0]);
            MinecraftClient.getInstance().player.sendMessage(Text.of("§3§lReaper§b§lClient §8» §7Teleported §8" + Arrays.toString(args) + " §7blocks on the y-axis."), false);
            ClientPlayerEntity player = MinecraftClient.getInstance().player;
            assert player != null;
            player.setPosition(player.getX(), player.getY() + blocks, player.getZ());
        }   else {
                MinecraftClient.getInstance().player.sendMessage(Text.of("§3§lReaper§b§lClient §8» §4Invalid Arguments. Please use the following format: '.vclip <integer>'"), false);
                return;
            }
    }
}}