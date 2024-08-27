package com.home.AirlineBookingSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FlightController {

	List<Flight> listOfFlights;

	public FlightController() {
		this.listOfFlights = new ArrayList<>();
	}
	
	public void addFlights(Flight flight) {
		this.listOfFlights.add(flight);
	}
	
	public List<Flight> searchFlights(String source, String dest, String date){
		return this.listOfFlights.stream().filter(flight -> flight.source.equalsIgnoreCase(source)
				&& flight.dest.equalsIgnoreCase(date)
				&& flight.departDate.equalsIgnoreCase(date)).collect(Collectors.toList());
	}
	
	public Flight getFlightByID(int number) {
		for(Flight f: listOfFlights) {
			if(f.flightNumber ==  number) {
				return f;
			}
		}
		return null;
	}
	
	public void updateSeat(Flight flight, Seat seat) {
		List<Seat> seats1 = getFlightByID(flight.getFlightNumber()).availableSeats;
		for(Seat s: seats1) {
			if(s.seatNumber == seat.seatNumber) {
				s.status = SeatStatus.RESERVED;
			}
		}
	}
}
