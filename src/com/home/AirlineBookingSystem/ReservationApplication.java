package com.home.AirlineBookingSystem;

import java.util.*;

public class ReservationApplication {

	PersonController personController;
	FlightController flightController;
	BookingController bookingController;
	
	public ReservationApplication() {
		this.personController = new PersonController();
		this.bookingController = new BookingController();
		this.flightController = new FlightController();
	}

	public void addUser(Person p) {
		this.personController.addPerson(p);
	}
	
	public void addFlights(Flight f) {
		this.flightController.addFlights(f);
	}
	
	public List<Flight> searchOfFlights(String source, String dest, String date){
		return this.flightController.searchFlights(source, dest, date);
	}
	
	public Bookings createBooking(Flight flight, Person person, Seat seat, int price) {
		List<Seat> seats = this.flightController.getFlightByID(flight.getFlightNumber()).availableSeats;
		for(Seat s: seats) {
			if(s.seatNumber == seat.seatNumber && s.status == SeatStatus.RESERVED) {
				return null;
			}
		}
		Bookings booking = this.bookingController.createBooking(flight, person, seat, price);
		if(booking.status == BookingStatus.CONFIRMED) {
			this.flightController.updateSeat(flight, seat);
		}
		return booking;
	}
	
	public void cancelBooking(String bookingNumber) {
		this.bookingController.cancelBooking(bookingNumber);
	}

}
