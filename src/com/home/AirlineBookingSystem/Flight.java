
package com.home.AirlineBookingSystem;

import java.util.List;

public class Flight {

	int flightNumber;
	String source;
	String dest;
	String arriavlDate;
	String departDate;
	List<Seat> availableSeats;
	
	public Flight(int flightNumber, String source, String dest, String arriavlDate, String departDate,
			List<Seat> availableSeats) {
		super();
		this.flightNumber = flightNumber;
		this.source = source;
		this.dest = dest;
		this.arriavlDate = arriavlDate;
		this.departDate = departDate;
		this.availableSeats = availableSeats;
	}
	public int getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDest() {
		return dest;
	}
	public void setDest(String dest) {
		this.dest = dest;
	}
	public String getArriavlDate() {
		return arriavlDate;
	}
	public void setArriavlDate(String arriavlDate) {
		this.arriavlDate = arriavlDate;
	}
	public String getDepartDate() {
		return departDate;
	}
	public void setDepartDate(String departDate) {
		this.departDate = departDate;
	}
	public List<Seat> getAvailableSeats() {
		return availableSeats;
	}
	public void setAvailableSeats(List<Seat> availableSeats) {
		this.availableSeats = availableSeats;
	}
}
