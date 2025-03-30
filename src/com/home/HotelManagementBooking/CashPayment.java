package com.home.HotelManagementBooking;

public class CashPayment implements Payment{

	@Override
	public void payBill(Bill bill) {
		System.out.println("Bill paid through cash");
	}

}
