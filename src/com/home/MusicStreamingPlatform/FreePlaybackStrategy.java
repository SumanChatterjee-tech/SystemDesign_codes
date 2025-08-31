package com.home.MusicStreamingPlatform;

public class FreePlaybackStrategy implements PlaybackStrategy {

	int toalSongsPlayed;
	
	static final int AD_BEFORE_NEW_SONGS=3;

	public FreePlaybackStrategy(int toalSongsPlayed) {
		super();
		this.toalSongsPlayed = toalSongsPlayed;
	}

	@Override
	public void play(Song song, Player player) {
		if(toalSongsPlayed >0 && toalSongsPlayed % AD_BEFORE_NEW_SONGS == 0) {
			 System.out.println("\n>>> Playing Advertisement: 'Buy Spotify Premium for ad-free music!' <<<\n");
		}
        player.setCurrentSong(song);
        System.out.printf("Free User is now playing: %s%n", song);
        toalSongsPlayed++;
	}
	
	
}
