package com.home.MusicStreamingPlatform;

public class PlayCommand implements Command{

	Player player;
	
	public PlayCommand(Player player) {
		super();
		this.player = player;
	}

	@Override
	public void execute() {
		this.player.clickPlay();
	}	
}
