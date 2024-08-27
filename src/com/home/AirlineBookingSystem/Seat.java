package com.home.AirlineBookingSystem;

public class Seat {
	
	String seatNumber;
    SeatType type;
    SeatStatus status;

    public Seat(String seatNumber, SeatType type) {
        this.seatNumber = seatNumber;
        this.type = type;
        this.status = SeatStatus.AVAILABLE;
    }

    public void reserve() {
        status = SeatStatus.RESERVED;
    }

    public void release() {
        status = SeatStatus.AVAILABLE;
    }
	
}
