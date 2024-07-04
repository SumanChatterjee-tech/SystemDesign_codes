package com.home.BookMyShowApplication;

import java.util.List;

public class Screens {
	int screenid;
	List<Seats> seats;
	public Screens(int screenid, List<Seats> seats) {
		super();
		this.screenid = screenid;
		this.seats = seats;
	}
	public int getScreenid() {
		return screenid;
	}
	public void setScreenid(int screenid) {
		this.screenid = screenid;
	}
	public List<Seats> getSeats() {
		return seats;
	}
	public void setSeats(List<Seats> seats) {
		this.seats = seats;
	}
}
