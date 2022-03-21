package net.pzvi.reaperClient.features.command.impl;

import net.pzvi.reaperClient.features.command.Command;
import net.pzvi.reaperClient.features.modules.Module;
import net.pzvi.reaperClient.features.modules.ModuleRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;

public class Toggle extends Command {
    public Toggle() {
        super("Toggle","toggles modules","toggle","t","enable","disable");
    }

    @Override
    public void execute(String[] args) {
        if (args.length == 0) {
            MinecraftClient.getInstance().player.sendMessage(Text.of("I need a module name dude"),false);
            return;
        }
        Module toToggle = ModuleRegistry.getInstance().getByName(String.join(" ",args));
        if (toToggle == null) {
            MinecraftClient.getInstance().player.sendMessage(Text.of("Didn't find that module"),false);
            return;
        }
        toToggle.setEnabled(!toToggle.isEnabled());
        MinecraftClient.getInstance().player.sendMessage(Text.of(toToggle.getName()+":enabled  "+!toToggle.isEnabled()+" ->  "+toToggle.isEnabled()),false);
    }
}