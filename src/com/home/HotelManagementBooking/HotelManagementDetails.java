package com.home.HotelManagementBooking;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class HotelManagementDetails {

	private Map<String, Guest> guests;
	private Map<String, Room> rooms;
	private Map<String, Reservation> reservations;

	public HotelManagementDetails() {
		super();
		guests = new ConcurrentHashMap<>();
		rooms = new ConcurrentHashMap<>();
		reservations = new ConcurrentHashMap<>();
	}

	public void addGuest(Guest guest) {
		guests.put(guest.getId(), guest);
	}

	public Guest getGuest(String guestId) {
		return guests.get(guestId);
	}

	public void addRoom(Room room) {
		rooms.put(room.getId(), room);
	}

	public Room getRoom(String roomId) {
		return rooms.get(roomId);
	}

	public synchronized Reservation bookRoom(Guest guest, Room room, LocalDate checkInDate, LocalDate checkOutDate) {
		if (room.getStatus() == RoomStatus.FREE) {
			room.book();
			String reservationId = generateReservationId();
			Reservation reservation = new Reservation(reservationId, guest, room, checkInDate, checkOutDate);
			reservations.put(reservationId, reservation);
			return reservation;
		}
		return null;
	}

	public synchronized void cancelReservation(String reservationId) {
		Reservation reservation = reservations.get(reservationId);
		if (reservation != null) {
			reservation.cancel();
			reservations.remove(reservationId);
		}
	}

	public synchronized void checkIn(String reservationId) {
		Reservation reservation = reservations.get(reservationId);
		if (reservation != null && reservation.getStatus() == ReservationStatus.CONFIRMED) {
			reservation.getRoom().checkIn();
		} else {
			throw new IllegalStateException("Invalid reservation or reservation not confirmed.");
		}
	}

	public synchronized void checkOut(String reservationId, Payment payment) {
		Reservation reservation = reservations.get(reservationId);
		if (reservation != null && reservation.getStatus() == ReservationStatus.CONFIRMED) {
			Room room = reservation.getRoom();
			double amount = room.getPrice()
					* ChronoUnit.DAYS.between(reservation.getCheckInDate(), reservation.getCheckOutDate());
			Reservation reservationDetails = reservations.get(reservationId);
			Bill bill = new Bill(reservationDetails, false);
			payment.payBill(bill);
			room.checkOut();
//			if (payment.payBill(bill)) {
//				room.checkOut();
//				reservations.remove(reservationId);
//			} else {
//				throw new IllegalStateException("Payment failed.");
//			}
		} else {
			throw new IllegalStateException("Invalid reservation or reservation not confirmed.");
		}
	}

	private String generateReservationId() {
		// Generate a unique reservation ID
		return "RES" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
	}
}
