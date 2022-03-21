package net.pzvi.reaperClient.features.modules;

import net.minecraft.client.util.math.MatrixStack;

public abstract class Module {
    boolean isEnabled = false;
    String name, description;
    public Module(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public abstract void onActivate();

    public abstract void onDeactivate();

    protected abstract void enable();
    protected abstract void disable();
    public abstract void tick();
    public abstract void renderWorld(MatrixStack stack);
    public abstract void renderHud();

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        if (enabled) enable();
        else disable();
        this.isEnabled = enabled;
    }
    public void setEnabledd(boolean enabled) {
        this.isEnabled = enabled;

    }
    public void setDisabled(boolean disabled) {
        disable();
    }

}