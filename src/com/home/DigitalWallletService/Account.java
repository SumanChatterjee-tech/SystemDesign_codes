package com.home.DigitalWallletService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Account {

	String id;
	String name;
	BigDecimal balance;
	Currency currency;
	List<Transaction> transactions;

	public Account(String id, String name, BigDecimal balance, Currency currency) {
		super();
		this.id = id;
		this.name = name;
		this.balance = balance;
		this.currency = currency;
		this.transactions = new ArrayList<>();
	}

	public synchronized void deposit(BigDecimal amount) {
		balance = balance.add(amount);
	}

	public synchronized void withdraw(BigDecimal amount) throws Exception {
		if (balance.compareTo(amount) >= 0) {
			balance = balance.subtract(amount);
		} else {
			throw new Exception("Insufficient funds in the account.");
		}
	}

	public synchronized void addTransaction(Transaction transaction) {
		transactions.add(transaction);
	}
	
	
}
