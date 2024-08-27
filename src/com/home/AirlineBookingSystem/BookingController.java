package com.home.AirlineBookingSystem;

import java.util.*;

public class BookingController {

	Map<String, Bookings> bookingNumberVsBooking;

	public BookingController() {
		this.bookingNumberVsBooking = new HashMap<>();
	}
	
	public Bookings createBooking(Flight flight, Person person, Seat seat, int price) {
		String bookingNumber = String.valueOf(Math.random());
		 Bookings booking = new Bookings(bookingNumber, flight, person, seat, price);
		 //we can have one synchronized block
		 this.bookingNumberVsBooking.put(bookingNumber,booking);
		 booking.createBooking();
		 return booking;
	}
	
	public void cancelBooking(String bookingNumber) {
		Bookings bookingTOCancel = this.bookingNumberVsBooking.get(bookingNumber);
		bookingTOCancel.cancel();
	}
}
