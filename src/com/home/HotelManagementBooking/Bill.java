package com.home.HotelManagementBooking;

public class Bill {

	Reservation reservation;
	boolean isBillPaid;
	public Bill(Reservation reservation, boolean isBillPaid) {
		super();
		this.reservation = reservation;
		this.isBillPaid = isBillPaid;
	}
	
	public double computeTotalBill() {
		return 100.00;
	}
}
