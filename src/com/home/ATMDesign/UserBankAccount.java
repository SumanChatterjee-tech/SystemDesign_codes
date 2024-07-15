package com.home.ATMDesign;

public class UserBankAccount {
	int balance;
	
	int remainingBalance(int amount) {
		return balance-amount;
	}
}
