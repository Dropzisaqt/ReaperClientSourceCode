package net.pzvi.reaperClient.util;

import com.mojang.authlib.GameProfile;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.input.KeyboardInput;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.EntityPose;
import net.minecraft.network.Packet;
import net.pzvi.reaperClient.util.Motion;

import java.util.UUID;

import static net.pzvi.reaperClient.Freecam.MC;

public class FreeCamera extends ClientPlayerEntity {

    private static final ClientPlayNetworkHandler NETWORK_HANDLER = new ClientPlayNetworkHandler(MC, MC.currentScreen, MC.getNetworkHandler().getConnection(), new GameProfile(UUID.randomUUID(), "FreeCamera")) {
        @Override
        public void sendPacket(Packet<?> packet) {
        }
    };

    public FreeCamera() {
        super(MC, MC.world, NETWORK_HANDLER, MC.player.getStatHandler(), MC.player.getRecipeBook(), false, false);

        copyPositionAndRotation(MC.player);
        this.getAbilities().flying = true;
        this.noClip = true;
        this.input = new KeyboardInput(MC.options);
    }

    public void spawn() {
        if (clientWorld != null) {
            clientWorld.addEntity(getId(), this);
        }
    }

    public void despawn() {
        if (clientWorld != null && clientWorld.getEntityById(getId()) != null) {
            clientWorld.removeEntity(getId(), RemovalReason.DISCARDED);
        }
    }

    @Override
    public void tickMovement() {
        input.tick(false);
        Motion.doMotion(this, 0.5, 0.5);
        }

    @Override
    public void setPose(EntityPose pose) {
    }

    @Override
    public boolean isSpectator() {
        return true;
    }
}
