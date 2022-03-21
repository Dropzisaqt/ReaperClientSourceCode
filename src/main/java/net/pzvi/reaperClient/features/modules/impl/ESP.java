package net.pzvi.reaperClient.features.modules.impl;

import net.minecraft.client.render.OutlineVertexConsumerProvider;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.command.EntitySelector;
import net.pzvi.reaperClient.features.modules.Module;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.awt.*;


public class ESP extends Module {
    public ESP() {
        super("ESP","ESP");
    }

    @Override
    public void onActivate() {

    }

    @Override
    public void onDeactivate() {

    }

    @Override
    protected void enable() {

    }

    @Override
    protected void disable() {

    }

    @Override
    public void tick() {

    }

    @Override
    public void renderWorld(MatrixStack stack) {

    }

    @Override
    public void renderHud() {

    }
}