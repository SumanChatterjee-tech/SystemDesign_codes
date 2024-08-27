package com.home.AirlineBookingSystem;

public class Bookings {

	String bookingNumber;
	Flight flight;
	Person person;
	Seat seat;
	int price;
	BookingStatus status;
	
	public Bookings(String bookingNumber, Flight flight, Person person, Seat seat, int price) {
		super();
		this.bookingNumber = bookingNumber;
		this.flight = flight;
		this.person = person;
		this.seat = seat;
		this.price = price;
		this.status = BookingStatus.CONFIRMED;
	}
	
	 public void cancel() {
	     status = BookingStatus.CANCELLED;
	     seat.status = SeatStatus.AVAILABLE;
	 }
	 
	 public void createBooking() {
		 
	     seat.status = SeatStatus.RESERVED;
	 }
	
}
