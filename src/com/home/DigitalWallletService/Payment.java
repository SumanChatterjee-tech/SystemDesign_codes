package com.home.DigitalWallletService;

import java.math.BigDecimal;

public abstract class Payment {

	protected final String id;
	protected final User user;

	public Payment(String id, User user) {
	        this.id = id;
	        this.user = user;
	}

	public abstract boolean processPayment(BigDecimal amount, Currency currency);

	public String getId() {
		return id;
	}

	public User getUser() {
		return user;
	}
}
