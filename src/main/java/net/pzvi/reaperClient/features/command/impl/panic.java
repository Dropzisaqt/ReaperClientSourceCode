package net.pzvi.reaperClient.features.command.impl;

import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;
import net.pzvi.reaperClient.Freecam;
import net.pzvi.reaperClient.features.command.Command;
import net.pzvi.reaperClient.features.modules.Module;
import net.pzvi.reaperClient.features.modules.ModuleRegistry;

public class panic extends Command {
    public panic() {
        super("panic", "Panic", "panic");
    }

    @Override
    public void execute(String[] args) {
        for(Module module : ModuleRegistry.getInstance().MODULES){
            module.setEnabled(false);
            Freecam.panic = true;
            Freecam.onDisable();
        }

    }

}
