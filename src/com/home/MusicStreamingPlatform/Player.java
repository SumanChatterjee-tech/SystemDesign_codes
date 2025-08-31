package com.home.MusicStreamingPlatform;

import java.util.*;

public class Player {

	PlayerState state;
	PlayerStatus status;
	List<Song> queue = new ArrayList<>(); // can be done in queue?
	int currIndex = -1;
	Song currSong;
	User currUser;

	public Player() {
		this.state = new StoppedState();
		this.status = PlayerStatus.STOPPED;
	}

	public void load(Playable playable, User currUser) {
		this.currIndex = 0;
		this.queue = playable.getTracks();
		this.currUser = currUser;
		this.state = new StoppedState();
	}

	public void playCurrentSongInQueue() {
		if (currIndex >= 0 && currIndex < queue.size()) {
			Song songToPlay = queue.get(currIndex);
			currUser.getPlaybackStrategy().play(songToPlay, this);
		}
	}

	// Methods for state transitions
	public void clickPlay() {
		state.play(this);
	}

	public void clickPause() {
		state.pause(this);
	}

	public void clickNext() {
		if (currIndex < queue.size() - 1) {
			currIndex++;
			playCurrentSongInQueue();
		} else {
			System.out.println("End of queue.");
			state.stop(this);
		}
	}

	// Getters and Setters used by States
	public void changeState(PlayerState state) {
		this.state = state;
	}

	public void setStatus(PlayerStatus status) {
		this.status = status;
	}

	public void setCurrentSong(Song song) {
		this.currSong = song;
	}

	public boolean hasQueue() {
		return !queue.isEmpty();
	}
}
