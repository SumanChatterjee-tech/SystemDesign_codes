package com.home.BookMyShowApplication;

import java.util.ArrayList;
import java.util.List;

public class Shows {
	int id;
	Movie movie;
	Screens screen;
	int startTime;
	List<Integer> bookedSeatIds = new ArrayList<>();
	public Shows(int id, Movie movie, Screens screen, int startTime, List<Integer> bookedSeatIds) {
		super();
		this.id = id;
		this.movie = movie;
		this.screen = screen;
		this.startTime = startTime;
		this.bookedSeatIds = bookedSeatIds;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	public Screens getScreen() {
		return screen;
	}
	public void setScreen(Screens screen) {
		this.screen = screen;
	}
	public int getStartTime() {
		return startTime;
	}
	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}
	public List<Integer> getBookedSeatIds() {
		return bookedSeatIds;
	}
	public void setBookedSeatIds(List<Integer> bookedSeatIds) {
		this.bookedSeatIds = bookedSeatIds;
	}
}
