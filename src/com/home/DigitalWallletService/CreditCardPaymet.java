package com.home.DigitalWallletService;

import java.math.BigDecimal;

public class CreditCardPaymet extends Payment{

	public CreditCardPaymet(String id, User user) {
		super(id, user);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean processPayment(BigDecimal amount, Currency currency) {
		// TODO Auto-generated method stub
		return true;
	}
}
