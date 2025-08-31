package com.home.MusicStreamingPlatform;

import java.util.*;

public class User implements ArtistObserver {

	String id;
	String name;
	PlaybackStrategy playbackStrategy;
	Set<Artist> followedArtists = new HashSet<>();

	private User(String id, String name, PlaybackStrategy strategy) {
		this.id = id;
		this.name = name;
		this.playbackStrategy = strategy;
	}

	public void followArtist(Artist artist) {
		followedArtists.add(artist);
		artist.addObserver(this);
	}

	@Override
	public void update(Artist artist, Album album) {
		System.out.printf("[Notification for %s] Your followed artist %s just released a new album: %s!%n", this.name,
				artist.getName(), album.getTitle());
	}

	public PlaybackStrategy getPlaybackStrategy() {
		return playbackStrategy;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

}
