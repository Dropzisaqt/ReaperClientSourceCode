package net.pzvi.reaperClient.features;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;

public class TestGUI extends Screen {
    public TestGUI() {
        super(Text.of("test"));
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        renderBackground(matrices); // render the background texture
        this.textRenderer.draw(matrices,"ReaperClient",465,5,0x16A598); // render a completely white Hello! at 5:5
        super.render(matrices, mouseX, mouseY, delta); // give it back to homeboy
    }
}