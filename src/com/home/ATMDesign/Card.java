package com.home.ATMDesign;

public class Card {
	int cardNumber;
	int expiryDate;
	int holderName;
	static int PIN_NUMBER = 112211;
	UserBankAccount bankAccount;
	public int getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}
	public int getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(int expiryDate) {
		this.expiryDate = expiryDate;
	}
	public int getHolderName() {
		return holderName;
	}
	public void setHolderName(int holderName) {
		this.holderName = holderName;
	}
	public static int getPIN_NUMBER() {
		return PIN_NUMBER;
	}
	public static void setPIN_NUMBER(int pIN_NUMBER) {
		PIN_NUMBER = pIN_NUMBER;
	}
	public UserBankAccount getBankAccount() {
		return bankAccount;
	}
	public void setBankAccount(UserBankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}
	
	
}
