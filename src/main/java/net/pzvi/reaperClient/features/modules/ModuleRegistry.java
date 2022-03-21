package net.pzvi.reaperClient.features.modules;

import net.pzvi.reaperClient.features.modules.impl.ESP;
import net.pzvi.reaperClient.features.modules.impl.Freeze;
import net.pzvi.reaperClient.features.modules.impl.OpenGUI;

import java.util.ArrayList;
import java.util.List;

public class ModuleRegistry {
    private static ModuleRegistry INSTANCE = null;
    public List<Module> MODULES = new ArrayList<>();
    public ModuleRegistry() {
        if (INSTANCE != null) {
            throw new IllegalStateException("Module registry already exists!");
        }
        INSTANCE = this;
        registerModules();
    }

    void register(Module module) {
        MODULES.add(new Freeze());
        MODULES.add(new OpenGUI());
        MODULES.add(new ESP());
    }

    void registerModules() {
        register(new Freeze());
        register(new OpenGUI());
        register(new ESP());

    }

    public Module getByName(String name) {
        for (Module module : MODULES) {
            if (module.getName().equalsIgnoreCase(name)) return module;
        }
        return null;
    }

    public static ModuleRegistry getInstance() {
        if (INSTANCE == null) new ModuleRegistry();
        return INSTANCE;
    }

    public List<Module> getAll() {
        return MODULES;
    }
}