package com.home.MusicStreamingPlatform;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MusicStreamingSystem {
    private static volatile MusicStreamingSystem instance;

    private final Map<String, User> users = new HashMap<>();
    private final Map<String, Song> songs = new HashMap<>();
    private final Map<String, Artist> artists = new HashMap<>();

    private final Player player;


    private MusicStreamingSystem() {
        this.player = new Player();
    }
    public static MusicStreamingSystem getInstance() {
        if (instance == null) {
            synchronized (MusicStreamingSystem.class) {
                if (instance == null) {
                    instance = new MusicStreamingSystem();
                }
            }
        }
        return instance;
    }

    public void registerUser(User user) {
        users.put(user.getId(), user);
    }

    public Song addSong(String id, String title, String artistId, int duration) {
        Song song = new Song(id, title, artists.get(artistId), duration);
        songs.put(song.getId(), song);
        return song;
    }

    public void addArtist(Artist artist) {
        artists.put(artist.getId(), artist);
    }

}
