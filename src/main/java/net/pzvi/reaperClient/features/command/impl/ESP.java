package net.pzvi.reaperClient.features.command.impl;

import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;
import net.pzvi.reaperClient.Freecam;
import net.pzvi.reaperClient.features.command.Command;
import net.pzvi.reaperClient.features.modules.Module;
import net.pzvi.reaperClient.features.modules.ModuleRegistry;


import java.util.Arrays;
import java.util.Objects;

public class ESP extends Command {
    public ESP() {
        super("ESP", "ESP", "esp");
    }

    @Override
    public void execute(String[] args) {
        if ((args == null) || (args.length == 0)) {
            MinecraftClient.getInstance().player.sendMessage(Text.of("§3§lReaper§b§lClient §8» §4Invalid Arguments. Please use the following format: '.esp toggle'"), false);
            return;
        }

        else {
            String s1 = "toggle";
            Module toToggle = (ModuleRegistry.getInstance().MODULES.get(2));
            String test = String.join(" ",args);
            if (test.equals("on")) {
                toToggle.setEnabled(true);
                MinecraftClient.getInstance().player.sendMessage(Text.of(toToggle.getName() + ":enabled  " + !toToggle.isEnabled() + " ->  " + toToggle.isEnabled()), false);
        }
            else if (test.equals("off")) {
                toToggle.setEnabled(false);
                MinecraftClient.getInstance().player.sendMessage(Text.of(toToggle.getName() + ":enabled  " + !toToggle.isEnabled() + " ->  " + toToggle.isEnabled()), false);
            }
}}}