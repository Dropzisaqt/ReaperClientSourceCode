package net.pzvi.reaperClient.features.command.impl;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.text.Text;
import net.pzvi.reaperClient.features.command.Command;
import java.util.Arrays;
import java.util.Arrays;

import static net.pzvi.reaperClient.features.command.impl.vclip.isInt;

public class FovChanger extends Command {
    public FovChanger() {
        super("fov", "Fov", "fov");
    }

    @Override
    public void execute(String[] args) {
        if ((args == null) || (args.length == 0)) {
            MinecraftClient.getInstance().player.sendMessage(Text.of("§3§lReaper§b§lClient §8» §4Invalid Arguments. Please use the following format: '.fov <integer>'"), false);
            return;
        } else {
            if (isInt(args[0])) {
                int fovv = Integer.parseInt(args[0]);
                MinecraftClient.getInstance().player.sendMessage(Text.of("§3§lReaper§b§lClient §8» §7Teleported §8" + Arrays.toString(args) + " §7blocks on the y-axis."), false);
                MinecraftClient.getInstance().options.fov = fovv;
            }   else {
                MinecraftClient.getInstance().player.sendMessage(Text.of("§3§lReaper§b§lClient §8» §4Invalid Arguments. Please use the following format: '.fov <integer>'"), false);
                return;
            }
        }
    }}