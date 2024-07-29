package com.home.InventoryManagementSystem;

public class Payment {

	PaymentStartegy paymentStartegy;

	public Payment(PaymentStartegy paymentStartegy) {
		super();
		this.paymentStartegy = paymentStartegy;
	}
	
	public boolean makepayment() {
		return this.paymentStartegy.makePayment();
	}
}
