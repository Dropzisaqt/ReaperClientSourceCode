package net.pzvi.reaperClient.util;
import java.io.BufferedInputStream;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class PlaySong {

    public static MP3Player player;

    public static void playSong(String filepath){
        player = new MP3Player(filepath);
        player.play();
    }

    public static void stopSong(){
        player.close();
    }
}
class MP3Player {
    private final String mp3FileToPlay;
    private Player jlPlayer;

    public MP3Player(String mp3FileToPlay) {
        this.mp3FileToPlay = mp3FileToPlay;
    }

    public void play() {
        try {
            FileInputStream fileInputStream = new FileInputStream(mp3FileToPlay);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            jlPlayer = new Player(bufferedInputStream);;
        } catch (Exception e) {
            System.out.println("Problem playing mp3 file " + mp3FileToPlay);
            System.out.println(e.getMessage());
        }

        new Thread() {
            public void run() {
                try {
                    jlPlayer.play();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }.start();


    }

    public void close() {
        if (jlPlayer != null) jlPlayer.close();
    }
}