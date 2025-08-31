package com.home.MusicStreamingPlatform;

public class PlayingState implements PlayerState {

	public PlayingState() {
		super();
		System.out.println("Inside playing state");
	}

	@Override
	public void play(Player player) {
		System.out.println("already playing");
	}

	@Override
	public void pause(Player player) {
		System.out.println("pausing the playing state");
		player.changeState(new PauseState());
		player.setStatus(PlayerStatus.PAUSED);

	}

	@Override
	public void stop(Player player) {
		System.out.println("Stoppingthe playing state");
		player.changeState(new StoppedState());
		player.setStatus(PlayerStatus.STOPPED);

	}

}
