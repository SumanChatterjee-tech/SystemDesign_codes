package com.home.ConcertBookingSystem;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.*;

public class ConcertBookingDemo {

	private final Map<String, Concert> concerts;
	private final Map<String, Booking> bookings;

	public ConcertBookingDemo() {
		this.concerts = new ConcurrentHashMap<>();
		this.bookings = new ConcurrentHashMap<>();
	}

	public void addConcert(Concert concert) {
		concerts.put(concert.getId(), concert);
	}

	public Concert getConcert(String concertId) {
		return concerts.get(concertId);
	}

	public List<Concert> searchConcerts(String artist, String venue, LocalDateTime dateTime) {
		return concerts.values().stream()
				.filter(concert -> concert.getArtist().equalsIgnoreCase(artist)
						&& concert.getVenue().equalsIgnoreCase(venue) && concert.getDateTime().equals(dateTime))
				.collect(Collectors.toList());
	}
	
	public synchronized Booking bookTickets(User user, Concert concert, List<Seat> seats) throws Exception {
		for (Seat seat : seats) {
            if (seat.getStatus() != SeatStatus.AVAILABLE) {
                throw new Exception("Seat " + seat.getRow() + "- "+ seat.getCol() +" is not available.");
            }
        }
        seats.forEach(t -> {
			try {
				t.book();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

        // Create booking
        String bookingId = generateBookingId();
        Booking booking = new Booking(bookingId, user, concert, seats);
        bookings.put(bookingId, booking);

        // Process payment
        processPayment(booking);

        // Confirm booking
        booking.confirmBooking();

        System.out.println("Booking " + booking.getId() + " - " + booking.getSeats().size() + " seats booked");

        return booking;
	}
	
	public void cancelBooking(String bookingId) {
        Booking booking = bookings.get(bookingId);
        if (booking != null) {
            booking.cancelBooking();
            bookings.remove(bookingId);
        }
    }

    private void processPayment(Booking booking) {
        // Process payment for the booking
        // ...
    }

    private String generateBookingId() {
        return "BKG" + UUID.randomUUID();
    }
}
