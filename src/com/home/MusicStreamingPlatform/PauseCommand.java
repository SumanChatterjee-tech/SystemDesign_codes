package com.home.MusicStreamingPlatform;

public class PauseCommand implements Command {

	Player player;

    public PauseCommand(Player player) { this.player = player; }

    @Override
    public void execute() { player.clickPause(); }
}
