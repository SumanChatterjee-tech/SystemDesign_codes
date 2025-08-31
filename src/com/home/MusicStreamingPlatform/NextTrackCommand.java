package com.home.MusicStreamingPlatform;

public class NextTrackCommand implements Command{
	Player player;

    public NextTrackCommand(Player player) { this.player = player; }

    @Override
    public void execute() { player.clickNext(); }
}