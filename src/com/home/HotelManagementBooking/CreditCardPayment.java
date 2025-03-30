package com.home.HotelManagementBooking;

public class CreditCardPayment implements Payment{

	@Override
	public void payBill(Bill bill) {
		System.out.println("Bill paid through credit card");
	}

}
