package com.home.BookMyShowApplication;

import java.util.List;

public class Theater {
	int theaterId;
	List<Screens> screens;
	List<Shows> movies;
	String address;
	City city;
	public Theater(int theaterId, List<Screens> screens, List<Shows> movies, String address, City city) {
		super();
		this.theaterId = theaterId;
		this.screens = screens;
		this.movies = movies;
		this.address = address;
		this.city = city;
	}
	public int getTheaterId() {
		return theaterId;
	}
	public void setTheaterId(int theaterId) {
		this.theaterId = theaterId;
	}
	public List<Screens> getScreens() {
		return screens;
	}
	public void setScreens(List<Screens> screens) {
		this.screens = screens;
	}
	public List<Shows> getMovies() {
		return movies;
	}
	public void setMovies(List<Shows> movies) {
		this.movies = movies;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
}
