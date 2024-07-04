package com.home.BookMyShowApplication;

public class Movie {
	int id;
	String movieName;
	int duration;
	public Movie(int id, String movieName, int duration) {
		super();
		this.id = id;
		this.movieName = movieName;
		this.duration = duration;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
}
