package com.home.ATMDesign;

public enum TransactionType {
    CASH_WITHDRAWAL(1),
    BALANCE_CHECK(2);
	
	int value;
	
	TransactionType(int value) {
		this.value = value;
	} 
}
