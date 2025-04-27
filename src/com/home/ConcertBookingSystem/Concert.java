package com.home.ConcertBookingSystem;

import java.time.LocalDateTime;
import java.util.List;

public class Concert {

	private String id;
	private String artist;
	private String venue;
	private LocalDateTime dateTime;
	private List<Seat> seats;
	
	public Concert(String id, String artist, String venue, LocalDateTime dateTime, List<Seat> seats) {
		super();
		this.id = id;
		this.artist = artist;
		this.venue = venue;
		this.dateTime = dateTime;
		this.seats = seats;
	}
	public String getId() {
		return id;
	}
	public String getArtist() {
		return artist;
	}
	public String getVenue() {
		return venue;
	}
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	public List<Seat> getSeats() {
		return seats;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public void setVenue(String venue) {
		this.venue = venue;
	}
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	public void setSeats(List<Seat> seats) {
		this.seats = seats;
	}
}
