package com.home.AirlineBookingSystem;

import java.util.ArrayList;
import java.util.List;

public class Main {

	private static List<Seat> getAllSeats() {
		List<Seat> result = new ArrayList<>();
		Seat s1 = new Seat("1", SeatType.BUSINESS);
		Seat s2 = new Seat("2", SeatType.BUSINESS);
		Seat s3 = new Seat("3", SeatType.BUSINESS);
		
		result.add(s1);
		result.add(s2);
		result.add(s3);
		
		return result;
	}
	public static void main(String[] args) {
		ReservationApplication reservation  = new ReservationApplication();
		Person p1 = new Person("U001", "John Doe", "john@example.com", "1234567890");
		Person p2 = new Person("U002", "John Doe1", "john@ee3ewxample.com", "12345sds67890");
		
		reservation.addUser(p1);
		reservation.addUser(p2);
		List<Seat> listOfSeats= getAllSeats();
		
		Flight flight1 = new Flight(1, "New York", "London", "arrivalTime1", "DepartTime1", listOfSeats);
		
		reservation.addFlights(flight1);
		
		Bookings b1 = reservation.createBooking(flight1, p1, new Seat("1", SeatType.BUSINESS), 1000);
		if(b1.status == BookingStatus.CONFIRMED) {
			System.out.println("Congratulations!!");
		}
		
		Bookings b2 = reservation.createBooking(flight1, p2, new Seat("1", SeatType.BUSINESS), 1000);
		if(b2!=null && b2.status == BookingStatus.CONFIRMED) {
			System.out.println("Congratulations!!");
		}else {
			System.out.println("seat is booked already");
		}
		
		Bookings b3 = reservation.createBooking(flight1, p2, new Seat("2", SeatType.BUSINESS), 1000);
		System.out.println(b3.status);
	}

}
