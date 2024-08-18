package com.home.PaymentGateWay_Design_LLD;

import java.util.*;

public class TransactionService {

	static Map<Integer, List<Transaction>> userVsTransactionDetails  = new HashMap<>();
	
	public int makePayment(Transaction txnDetails) {
		//some validations and business logic
		return txnDetails.txnId;
	}
}
