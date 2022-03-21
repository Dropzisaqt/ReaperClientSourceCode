package net.pzvi.reaperClient.features.command.impl;

import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;
import net.pzvi.reaperClient.features.command.Command;
import net.pzvi.reaperClient.util.Util;

import java.io.IOException;
import java.util.Arrays;

public class PlaySong extends Command {
    public PlaySong() {
        super("playmusic", "Plays songs from youtube", "playmusic");

    }

    @Override
    public void execute(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String[] videoId = Util.searchYT(String.join(" ",args));
                    MinecraftClient.getInstance().player.sendMessage(Text.of("§3§lReaper§b§lClient §8» §aDownloading song..."), true);
                    Util.makeUselessConnection(videoId[0]);
                    net.pzvi.reaperClient.util.PlaySong.playSong("c:/users/megae/" + videoId[1] + " [" + videoId[0] + "].mp3");
                    MinecraftClient.getInstance().player.sendMessage(Text.of("§3§lReaper§b§lClient §8» &aPlaying " + videoId[1] + ".mp3"), true);
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();


    }
}