package com.home.ConcertBookingSystem;

import java.util.List;

public class Booking {

	private String id;
	private User user;
	private Concert concert;
	private List<Seat> seats;
	private double totalPrice;
	private BookingStatus status;
	
    public Booking(String id, User user, Concert concert, List<Seat> seats) {
        this.id = id;
        this.user = user;
        this.concert = concert;
        this.seats = seats;
        this.totalPrice = calculateTotalPrice();
        this.status = BookingStatus.PENDING;
    }

    private double calculateTotalPrice() {
        return seats.stream().mapToDouble(Seat::getPrice).sum();
    }
    
    public void cancelBooking() {
    	if(status ==  BookingStatus.CONFIRMED) {
    		status = BookingStatus.CANCELLED;
    		seats.forEach(s-> s.release());
    		System.out.printf("Booking %s cancelled\n", id);
    	}
    }
    public void confirmBooking() {
        if (status == BookingStatus.PENDING) {
            status = BookingStatus.CONFIRMED;
            // Send booking confirmation to the user
            // ...
        }
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Concert getConcert() {
		return concert;
	}

	public void setConcert(Concert concert) {
		this.concert = concert;
	}

	public List<Seat> getSeats() {
		return seats;
	}

	public void setSeats(List<Seat> seats) {
		this.seats = seats;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public BookingStatus getStatus() {
		return status;
	}

	public void setStatus(BookingStatus status) {
		this.status = status;
	}
}
